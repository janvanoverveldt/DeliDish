package be.kdg.foundation.contact;

import be.kdg.distanceAPI.DistanceCalculator;
import be.kdg.distanceAPI.Point;
import be.kdg.foundation.contact.Move;
import be.kdg.foundation.contact.Position;

/**
 *
 */
public class Ride implements Move {
    private Position start;
    private Position dest;
    private int minutesPerKm;


    public Ride(Position start, Position dest, int minutesPerKm) {
        this.start = start;
        this.dest = dest;
        this.minutesPerKm = minutesPerKm;
    }

    public double getDistance() {
        return new DistanceCalculator().getDistance(toPoint(start), toPoint(dest));
    }

    public int getDuration() {
        return (int) getDistance() * minutesPerKm;
    }

    private Point toPoint(Position pos){
    	return new Point (pos.getLattitude(), pos.getLongitude());
    }


}
