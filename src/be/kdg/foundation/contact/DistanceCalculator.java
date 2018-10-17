package be.kdg.foundation.contact;

import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.distance.DistanceUtils;
import org.locationtech.spatial4j.shape.Point;


/**
 * This class is an adapter that calculates the distance between two Position objects as used in the DeliDish software.
 * It depends on an external package.
 */
public class DistanceCalculator {


    /**
     * Returns the distance between two positions.
     *
     * @param first
     * @param second
     * @return
     */
    public double getDistance(Position first, Position second) {
        // transform to point
        SpatialContext ctx = SpatialContext.GEO;
        Point firstPoint = ctx.getShapeFactory().pointXY(first.getLattitude(), first.getLongitude());
        Point secondPoint = ctx.getShapeFactory().pointXY(second.getLattitude(), second.getLongitude());
        return DistanceUtils.DEG_TO_KM * ctx.calcDistance(firstPoint, secondPoint);
    }
}