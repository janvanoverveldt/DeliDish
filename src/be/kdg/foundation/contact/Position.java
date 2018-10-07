package be.kdg.foundation.contact;

public class Position {
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
