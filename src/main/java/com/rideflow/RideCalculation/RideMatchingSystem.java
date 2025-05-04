package com.rideflow.RideCalculation;



import com.rideflow.Fare.FareStrategy;
import com.rideflow.User.Driver;
import com.rideflow.User.Passenger;

import java.util.ArrayList;
import java.util.List;

public class RideMatchingSystem {

    private final List<Driver> availableDrivers = new ArrayList<>();

    public void addDriver(Driver driver) {
        availableDrivers.add(driver);
    }

    public void removeDriver(Driver driver) {
        availableDrivers.remove(driver);
    }

    public void requestRide(Passenger passenger, double distance, FareStrategy fareStrategy) {
        if (availableDrivers.isEmpty()) {
            passenger.notify("No drivers available.");
            return;
        }

        Driver assignedDriver = findNearestDriver(passenger);

        Ride ride = new Ride(passenger, assignedDriver, distance, fareStrategy);

        removeDriver(assignedDriver);

        //fare calculation
        ride.calculateFare();
        double fare = ride.getFare();

        //notification
        if (assignedDriver != null) {
            passenger.notify("Driver " + assignedDriver.getName() + " is on the way to pick you up.");
            assignedDriver.notify("You have a new ride request for " + ride.getFare());
            System.out.println("Ride booked for " + passenger.getName() + " with driver " + assignedDriver.getName() +
                                       " for fare " + fare);

        } else {
            passenger.notify("No drivers available to fulfill your ride request.");
        }

        //Update Ride Status :

        ride.updateStatus(RideStatus.ONGOING);

        // Add driver back once ride finished and update Status
        addDriver(assignedDriver);
        ride.updateStatus(RideStatus.COMPLETED);

    }

    private Driver findNearestDriver(Passenger passenger) {
        Driver nearestDriver = null;
        double minDistance = Double.MAX_VALUE;

        for (Driver driver : availableDrivers) {
            double distance = driver.getLocation().calcDistance(passenger.getLocation());
            if (distance < minDistance) {
                minDistance = distance;
                nearestDriver = driver;
            }
        }

        return nearestDriver;
    }
}
