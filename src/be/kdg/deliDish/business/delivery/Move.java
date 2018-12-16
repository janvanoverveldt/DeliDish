package be.kdg.deliDish.business.delivery;

/**
 * Represents a travel from one point to another.
 */
public interface Move {
    double getDistance();

    int getDuration();
}
