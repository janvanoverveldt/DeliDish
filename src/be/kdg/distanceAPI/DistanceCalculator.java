package be.kdg.distanceAPI;

import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.distance.DistanceUtils;


/**
 * This class mocks an API class that connects to a webservice. At this moment the only functionality is calculating the distance between 2 points. that calculates the distance between two Points.
 * It depends on an external package.
 */
public class DistanceCalculator {


    /**
     * Returns the distance between two points.
     *
     * @param point1
     * @param point2
     * @return
     */
    public double getDistance(Position point1, Position point2) {
        // transform to point
        SpatialContext ctx = SpatialContext.GEO;
        return DistanceUtils.DEG_TO_KM * ctx.calcDistance(point1, point2);
    }
}