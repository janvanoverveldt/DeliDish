package be.kdg.foundation.contact;

import be.kdg.distanceAPI.DistanceRepository;
import be.kdg.distanceAPI.Point;

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
        return new DistanceRepository().getDistance(toPoint(start), toPoint(dest));
    }

    public int getDuration() {
        return (int) getDistance() * minutesPerKm;
    }

    private Point toPoint(Position pos){
    	return new Point (pos.getLattitude(), pos.getLongitude());
    }


}
