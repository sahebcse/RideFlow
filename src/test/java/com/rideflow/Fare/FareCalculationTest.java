package com.rideflow.Fare;

import com.rideflow.Vehicle.Bike;
import com.rideflow.Vehicle.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Verifies each fare‑calculation strategy.
 */
class FareCalculationTest {

    @Test
    void standardCarFare() {
        double fare = new StandardFareStrategy().calcFare(new Car("DL‑01"), 10);
        assertEquals(200, fare, 0.001);
    }

    @Test
    void sharedCarFare() {
        double fare = new SharedFareStrategy().calcFare(new Car("DL‑01"), 10);
        assertEquals(100, fare, 0.001);
    }

    @Test
    void luxuryCarFare() {
        double fare = new LuxuryFareStrategy().calcFare(new Car("DL‑01"), 10);
        assertEquals(300, fare, 0.001);
    }

    @Test
    void standardBikeFare() {
        double fare = new StandardFareStrategy().calcFare(new Bike("MH‑02"), 10);
        assertEquals(100, fare, 0.001);
    }
}