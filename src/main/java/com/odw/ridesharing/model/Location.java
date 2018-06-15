package com.odw.ridesharing.model;

/**
 * Location class is used to keep track of coordinates of the origin and destination of Pickup. Location will be
 * converted and used to calculate the cost of the ride associated with Pickup.
 */
public class Location {
    
    private double latitude;
    private double longitude;
    
    /**
     * Create and initialize a default point with a latitude and longitude specified in degrees.
     */
    public Location() {
        this(0.d, 0.d);
    }
    
    /**
     * Create and initialize a point with a latitude and longitude specified in degrees.
     * 
     * @param latitude
     *            The latitude of the location in degrees.
     * @param longitude
     *            The longitude of the location in degrees.
     */
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /**
     * Return distance between this location and that location measured in statute miles.
     * 
     * @param that_
     *            The other location to calculate the distance from.
     * @return The distance between two locations.
     */
    public double distanceTo(Location that_) {
        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(that_.latitude);
        double lon2 = Math.toRadians(that_.longitude);
        
        // Great circle distance in radians, using law of cosines formula
        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                                 + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
        
        // Each degree on a great circle of Earth is 60 nautical miles
        double nauticalMiles = 60.d * Math.toDegrees(angle);
        double statuteMiles = RuntimeConstants.STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
        return statuteMiles;
    }
    
    @Override
    public String toString() {
        return Double.toString(latitude) + ", " + Double.toString(longitude);
    }
}
