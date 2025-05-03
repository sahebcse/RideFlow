package Fare;

import Vehicle.Vehicle;

public class LuxuryFareStrategy implements FareStrategy {

    @Override
    public double calcFare(Vehicle vehicle, double distance) {
        //additional 50% for luxury vehicles
        return (vehicle.getFarePerKm() * distance) * 1.5;
    }
}
