package be.kdg.deliDish.business;

import be.kdg.distanceAPI.DistanceRepository;
import be.kdg.distanceAPI.Point;
import be.kdg.foundation.contact.Position;

/**
 *
 */
public class DistanceApiManager implements DistanceManager {



    public double getDistance(Position start, Position dest) {
        return new DistanceRepository().getDistance(toPoint(start), toPoint(dest));
    }

    public int getDuration(Position start, Position dest, int minutesPerKm) {
        return (int) getDistance(start,dest) * minutesPerKm;
    }

    private Point toPoint(Position pos){
    	return new Point (pos.getLattitude(), pos.getLongitude());
    }


}
