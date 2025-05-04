package com.rideflow.RideCalculation;

import com.rideflow.Fare.StandardFareStrategy;
import com.rideflow.User.Driver;
import com.rideflow.User.Passenger;
import com.rideflow.Vehicle.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Confirms passengers and drivers receive status‑change notifications.
 */
class NotificationTest {

    static final class RecordingPassenger extends Passenger {
        List<String> messages = new ArrayList<>();
        RecordingPassenger(String n, String e, Location l) { super(n, e, l); }
        @Override public void notify(String msg) { messages.add(msg); }
    }

    static final class RecordingDriver extends Driver {
        List<String> messages = new ArrayList<>();
        RecordingDriver(String n, String e, Location l, Car v) { super(n, e, l, v); }
        @Override public void notify(String msg) { messages.add(msg); }
    }

    @Test
    void passengerAndDriverAreNotified() {
        Location loc = new Location(0, 0);
        RecordingPassenger passenger = new RecordingPassenger("Bob", "bob@test.com", loc);
        RecordingDriver   driver    = new RecordingDriver("John", "john@test.com", loc, new Car("DL‑01"));

        Ride ride = new Ride(passenger, driver, 10, new StandardFareStrategy());

        ride.calculateFare();
        ride.updateStatus(RideStatus.ONGOING);
        ride.updateStatus(RideStatus.COMPLETED);

        assertFalse(passenger.messages.isEmpty(), "Passenger should receive notifications.");
        assertFalse(driver.messages.isEmpty(),    "Driver should receive notifications.");

        String lastMsg = passenger.messages.get(passenger.messages.size() - 1);
        assertTrue(lastMsg.contains("completed"), "Completion message should be sent.");
    }
}