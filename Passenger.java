public class Passenger {
    String name;
    Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }

    public Passenger(final String name, final Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }


}
