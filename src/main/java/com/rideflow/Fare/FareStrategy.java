package com.rideflow.Fare;

import com.rideflow.Vehicle.Vehicle;

public interface FareStrategy {

    double calcFare(Vehicle vehicle, double distance);
}

