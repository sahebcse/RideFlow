package RideCalculation;

public class Location {
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //distance calculation
    public double calcDistance(Location locationTwo) {
        double dx = this.latitude - locationTwo.latitude;
        double dy = this.longitude - locationTwo.longitude;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(final double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(final double longitude) {
        this.longitude = longitude;
    }
}
