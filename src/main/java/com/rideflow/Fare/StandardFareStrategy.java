package com.rideflow.Fare;

import com.rideflow.Vehicle.Vehicle;

public class StandardFareStrategy implements FareStrategy {

    @Override
    public double calcFare(Vehicle vehicle, double distance) {
        return vehicle.getFarePerKm() * distance;
    }
}
