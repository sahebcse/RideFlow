package com.rideflow.RideCalculation;

import com.rideflow.Fare.StandardFareStrategy;
import com.rideflow.User.Driver;
import com.rideflow.User.Passenger;
import com.rideflow.Vehicle.Bike;
import com.rideflow.Vehicle.Car;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Ensures the nearest driver is matched to a passenger.
 */
class RideMatchingSystemTest {

    @Test
    void nearestDriverIsAssigned() {
        Location d1Loc = new Location(0, 0);          // nearest
        Location d2Loc = new Location(50, 50);        // far
        Location pLoc  = new Location(1, 1);

        Driver driver1 = new Driver("John", "john@test.com", d1Loc, new Car("DL‑01"));
        Driver driver2 = new Driver("Alice", "alice@test.com", d2Loc, new Bike("MH‑02"));
        Passenger passenger = new Passenger("Bob", "bob@test.com", pLoc);

        RideMatchingSystem rms = new RideMatchingSystem();
        rms.addDriver(driver1);
        rms.addDriver(driver2);

        // capture console output
        PrintStream original = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        rms.requestRide(passenger, 10, new StandardFareStrategy());

        System.setOut(original);
        String log = out.toString();

        assertTrue(log.contains("driver John"), "Nearest driver should be assigned to the ride.");
    }
}