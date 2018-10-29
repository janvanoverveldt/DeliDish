package be.kdg.deliDish.business.delivery;

import be.kdg.distanceAPI.DistanceCalculator;
import be.kdg.distanceAPI.Point;
import be.kdg.foundation.contact.Position;

/**
 *
 */
public class Ride implements Tour {
    private Position start;
    private Position dest;
    private int minutesPerKm;


    public Ride(Position start, Position dest, int minutesPerKm) {
        this.start = start;
        this.dest = dest;
        this.minutesPerKm = minutesPerKm;
    }

    public double getDistance() {
        return new DistanceCalculator().getDistance(new Point(start.getLattitude(), start.getLongitude()), new Point(dest.getLattitude(), dest.getLongitude()));
    }

    public double getDuration() {
        return getDistance() * minutesPerKm;
    }
}
