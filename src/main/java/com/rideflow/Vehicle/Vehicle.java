package com.rideflow.Vehicle;

public abstract class Vehicle {

    protected String numberPlate;

    protected Vehicle(final String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public abstract double getFarePerKm();

}
