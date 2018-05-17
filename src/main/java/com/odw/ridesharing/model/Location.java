package com.odw.ridesharing.model;

public class Location {

    public double longitude;
    public double latitude;
    
    public Location() {
        this(0, 0);
    }
    /**
     * Initialize a Location with longitude and latitude
     * 
     * Should be either origin location or destination location
	 * 
     * @param longitude_ This is the longitude of the location (x-coordinate)
     * 
     * @param latitude_ This is the latitude of the location (y-coordinate)
     */
    public Location(double longitude_, double latitude_) {
        longitude = longitude_;
        latitude = latitude_;
    }
}
