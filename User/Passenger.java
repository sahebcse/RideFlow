package User;

import RideCalculation.Location;

public class Passenger extends User {
    public Passenger(final String name, final String email, final Location location) {
        super(name, email, location);
    }

    @Override
    public void notify(String message) {
        System.out.println("Notification to Passenger " + name + ": " + message);
    }
}
