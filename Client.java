import Fare.LuxuryFareStrategy;
import Fare.StandardFareStrategy;
import RideCalculation.Location;
import RideCalculation.RideMatchingSystem;
import User.Driver;
import User.Passenger;
import Vehicle.Bike;
import Vehicle.Car;
import Vehicle.Vehicle;

public class Client {

    public static void main(String[] args) {
        //create 3 sample locations of india
        Location location1 = new Location(28.6139, 77.2090); // Delhi
        Location location2 = new Location(19.0760, 72.8777); // Mumbai
        Location location3 = new Location(13.0827, 80.2707); // Chennai

        // create vehicles
        Vehicle vehicle1 = new Car("DL-01-1234");
        Vehicle vehicle2 = new Bike("MH-02-5678");

        // create drivers
        Driver driver1 = new Driver("John", "john@gmail.com", location1, vehicle1);
        Driver driver2 = new Driver("Alice", "alice@gmail.com", location2, vehicle2);

        // create passengers
        Passenger passenger1 = new Passenger("Bob", "bob@gmail.com", location3);
        Passenger passenger2 = new Passenger("Charlie", "charlie@gmail.com", location1);

        RideMatchingSystem rideMatchingSystem = new RideMatchingSystem();

        //below request should show no availabele driver message
        rideMatchingSystem.requestRide(passenger1, 10, new StandardFareStrategy());

        rideMatchingSystem.addDriver(driver1);
        rideMatchingSystem.addDriver(driver2);

        rideMatchingSystem.requestRide(passenger1, 15, new LuxuryFareStrategy());
        rideMatchingSystem.requestRide(passenger2, 5, new StandardFareStrategy());

    }
}
