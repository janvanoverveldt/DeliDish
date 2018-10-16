package be.kdg.foundation.contact;

import java.io.Serializable;

public class Position implements Serializable {
    private final double longitude;
    private final double lattitude;

    public Position(double longitude, double lattitude) {
        this.longitude = longitude;
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLattitude() {
        return lattitude;
    }
}
