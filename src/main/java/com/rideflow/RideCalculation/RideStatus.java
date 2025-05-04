package com.rideflow.RideCalculation;

public enum RideStatus {
    SCHEDULED,
    ONGOING,
    COMPLETED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
