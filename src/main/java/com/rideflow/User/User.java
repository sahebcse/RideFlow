package com.rideflow.User;


import com.rideflow.RideCalculation.Location;

public abstract class User {
    protected String name;
    protected String email;
    protected Location location;

    protected User(String name, String email, Location location) {
        this.name = name;
        this.email = email;
        this.location = location;
    }

    public abstract void notify(String message);

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }
}
