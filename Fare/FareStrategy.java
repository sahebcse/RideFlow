package Fare;

import Vehicle.Vehicle;

public interface FareStrategy {

    double calcFare(Vehicle vehicle, double distance);
}

