package com.rideflow.RideCalculation;

import com.rideflow.Fare.FareStrategy;
import com.rideflow.User.Driver;
import com.rideflow.User.Passenger;

public class Ride {
    private final Passenger passenger;
    private final Driver driver;
    private final double distance;
    private final FareStrategy fareStrategy;
    private double fare;
    private RideStatus rideStatus;

    public Ride(Passenger passenger, Driver driver, double distance, FareStrategy fareStrategy) {
        this.passenger = passenger;
        this.driver = driver;
        this.distance = distance;
        this.fareStrategy = fareStrategy;
        this.rideStatus = RideStatus.SCHEDULED;
    }

    public void calculateFare() {
        this.fare = fareStrategy.calcFare(driver.getVehicle(), distance);
    }

    public double getFare() {
        return fare;
    }

    private void notifyUser(RideStatus rideStatus) {
        if (rideStatus == RideStatus.COMPLETED) {
            passenger.notify("Your ride has been completed. Fare: " + fare);
            driver.notify("Your ride has been completed. Fare: " + fare);
        } else {
            passenger.notify("Ride status: " + rideStatus);
            driver.notify("Ride status: " + rideStatus);
        }
    }

    public void updateStatus(RideStatus newStatus) {
        this.rideStatus = newStatus;
        notifyUser(rideStatus);
    }
}
