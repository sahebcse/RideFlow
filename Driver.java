public class Driver {
    String name;

    Location location;

    Vehicle vehicle;

    boolean isAvailable;

    public Driver(String name, Location location, Vehicle vehicle, boolean isAvailable) {
        this.name = name;
        this.location = location;
        this.vehicle = vehicle;
        this.isAvailable = isAvailable;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

}
