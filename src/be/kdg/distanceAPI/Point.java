package be.kdg.distanceAPI;

import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.shape.impl.PointImpl;

public class Point extends PointImpl {
    /*
    Creates a point on earth.
     */
    public Point(double lattitude, double longitude) {
        super(lattitude, longitude, SpatialContext.GEO);
    }
}
