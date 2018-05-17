package com.odw.ridesharing.model;

public class Location {

    public double longitude;
    public double latitude;
    
    public Location() {
        this(0, 0);
    }
    
    public Location(double longitude_, double latitude_) {
        longitude = longitude_;
        latitude = latitude_;
    }
}
