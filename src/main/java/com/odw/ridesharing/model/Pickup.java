package com.odw.ridesharing.model;

public class Pickup {
    
    private int pickupID;
    private int carID;
    private int driverID;
    private int customerID;
    private Location origin;
    private Location destination;
    
    public Pickup() {
        this(-1, -1, -1, new Location(), new Location());
    }
    
    /**
     * Initialize a Pickup with IDs from car, driver, and customer
     * 
     * Includes the ride to and from
     * 
     * @param carID_ This car's unique id
     * 
     * @param driverID_ This driver's unique id
     * 
     * @param customerID_ This customer's unique id
     * 
     * @param origin_ the starting location of the driver in longitude and latitude
     * 
     * @param destination_ the destination location in longitude and latitude
     */
    public Pickup(int carID_, int driverID_, int customerID_, Location origin_, Location destination_) {
        setCarID(carID_);
        setDriverID(driverID_);
        setCustomerID(customerID_);
        setOrigin(origin_);
        setDestination(destination_);
    }
    
    /* Getters and Setters */
    /**
     * Get the unique ID of the car
     * 
     * @return The ID of the car to be executed
     */
    public int getCarID() {
        return carID;
    }
    /**
     * Set the ID of the car
     * 
     * @param The new ID of the car to be set
     */
    public void setCarID(int carID_) {
        carID = carID_;
    }
    /**
     * Get the unique ID of the driver
     * 
     * @return The ID of the driver to be executed
     */
    public int getDriverID() {
        return driverID;
    }
    /**
     * Set the ID of the driver
     * 
     * @param The new ID of the driver to be set
     */
    public void setDriverID(int driverID_) {
        driverID = driverID_;
    }
    /**
     * Get the unique ID of the customer
     * 
     * @return The ID of the driver to be executed
     */
    public int getCustomerID() {
        return customerID;
    }
    /**
     * Set the ID of the customer
     * 
     * @param The new ID of the customer to be set
     */
    public void setCustomerID(int customerID_) {
        customerID = customerID_;
    }
    
    /**
     * Get the x and y coordinates of the starting location for the Pickup
     * 
     * @return The origin of the Pickup to be executed
     */
    public Location getOrigin() {
        return origin;
    }
    /**
     * Set the x and y coordinates of the starting location for the Pickup
     * 
     * @param The new origin of the Pickup to be set
     */
    public void setOrigin(Location origin_) {
        origin = origin_;
    }
    /**
     * Get the x and y coordinates of the ending location for the Pickup
     * 
     * @return The end location of the Pickup to be executed
     */
    public Location getDestination() {
        return destination;
    }
    /**
     * Set the x and y coordinates of the ending location for the Pickup
     * 
     * @param The new end location of the Pickup to be set
     */
    public void setDestination(Location destination_) {
        destination = destination_;
    }
}
