package be.kdg.distanceAPI;

import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.distance.DistanceUtils;


/**
 * This class mocks an API class that connects to a webservice. At this moment the only functionality is calculating the distance between 2 points.
 * It depends on an external package which is already included.
 */
// TODO (Week 3-4-5): Deze klasse kan je aanroepen vanuit je code om de afstand tussen twee punten te berekenen. Je zal deze nodig hebben voor de belgische orderselectielogica, je moet dus enkel weten dat de methode bestaat. Beschouw dit als een externe API waar je niets aan kan wijzigen.
public class DistanceCalculator {


    /**
     * Returns the distance in km between two points.
     *
     * @param point1
     * @param point2
     * @return
     */
    public double getDistance(Point point1, Point point2) {
        // transform to point
        SpatialContext ctx = SpatialContext.GEO;
        return DistanceUtils.DEG_TO_KM * ctx.calcDistance(point1, point2);
    }
}