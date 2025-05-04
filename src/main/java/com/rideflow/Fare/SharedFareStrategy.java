package com.rideflow.Fare;

import com.rideflow.Vehicle.Vehicle;

public class SharedFareStrategy implements FareStrategy {

    @Override
    public double calcFare(Vehicle vehicle, double distance) {
        return (vehicle.getFarePerKm() * distance) / 2;
    }
}
