package User;

import RideCalculation.Location;
import Vehicle.Vehicle;

public class Driver extends User {

    Vehicle vehicle;


    public Driver(final String name, final String email, final Location location, final Vehicle vehicle) {
        super(name, email, location);
        this.vehicle = vehicle;
    }

    @Override
    public void notify(final String message) {
        System.out.println("Notification to Driver " + name + ": " + message);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
