package com.rideflow.Vehicle;

public class Car extends Vehicle {


    public Car(final String numberPlate) {
        super(numberPlate);
    }

    @Override
    public double getFarePerKm() {
        return 20;
    }
}
