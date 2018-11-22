package be.kdg.distanceAPI;

import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.shape.impl.PointImpl;

public class Position extends PointImpl {
    /*
    Creates a point on earth.
     */
    public Position(double lattitude, double longitude) {
        super(lattitude, longitude, SpatialContext.GEO);
    }
}
