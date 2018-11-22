package be.kdg.deliDish.business.delivery;

import be.kdg.distanceAPI.DistanceCalculator;
import be.kdg.distanceAPI.Position;

/**
 *
 */
public class Ride implements Move {
    private be.kdg.foundation.contact.Position start;
    private be.kdg.foundation.contact.Position dest;
    private int minutesPerKm;


    public Ride(be.kdg.foundation.contact.Position start, be.kdg.foundation.contact.Position dest, int minutesPerKm) {
        this.start = start;
        this.dest = dest;
        this.minutesPerKm = minutesPerKm;
    }

    public double getDistance() {
        return new DistanceCalculator().getDistance(new Position(start.getLattitude(), start.getLongitude()), new Position(dest.getLattitude(), dest.getLongitude()));
    }

    public double getDuration() {
        return getDistance() * minutesPerKm;
    }
}
