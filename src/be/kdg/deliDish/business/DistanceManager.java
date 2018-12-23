package be.kdg.deliDish.business;

import be.kdg.foundation.contact.Position;

/**
 * Represents a travel from one point to another.
 */
public interface DistanceManager {

	public double getDistance(Position start, Position dest);

	public int getDuration(Position start, Position dest, int minutesPerKm) ;
}
