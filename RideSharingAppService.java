import java.util.ArrayList;
import java.util.List;

public class RideSharingAppService {

    //Matching Service
    private List<Driver> drivers = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();

    //Methods to add drivers and passengers

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    //booking ride

    public void bookRide(Passenger passenger,double distance) {

        //corner case
        if(drivers.isEmpty()) {
            System.out.println("No Drivers available for" + passenger.name);
            return;
        }
        // Hardcoded assignment logic
        //find the nearest driver
        //O(n) brute force

        Driver assignedDriver = null;
        double minDistance = Double.MAX_VALUE;

        for(Driver driver : drivers){
            double currentDriverDistance = calcDistance(passenger.location,driver.location);
            if(currentDriverDistance < minDistance){
                minDistance = currentDriverDistance;
                assignedDriver = driver;
            }
        }


        //fare calculation

        double fare = calcFare(assignedDriver.vehicle,distance);


        //show the fare to driver and passenger

        System.out.println("Ride booked for " + passenger.name + " with driver " + assignedDriver.name +
                " for fare " + fare);
        System.out.println("Driver "+ assignedDriver.name +" is on the way to pick you up");



    }

    //distance calculation

    private double calcDistance(Location passengerLocation, Location driverLocation) {
        // Using Euclidean distance formula
        return Math.sqrt(Math.pow(passengerLocation.getLatitude() - driverLocation.getLatitude(), 2) +
                Math.pow(passengerLocation.getLongitude() - driverLocation.getLongitude(), 2));
    }

    //fare calculation
    private double calcFare(Vehicle vehicle, double distance) {

        if(vehicle.type.equals("Car")) {
            return distance * 20; // Car fare rate
        } else if(vehicle.type.equals("Bike")) {
            return distance * 15; // Bike fare rate
        } else if(vehicle.type.equals("Bus")) {
            return distance * 10; // Bus fare rate
        } else {
            return distance * 8; // Unknown vehicle type
        }
    }


}
