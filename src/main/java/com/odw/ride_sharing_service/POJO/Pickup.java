package com.odw.ride_sharing_service.POJO;

import com.odw.ride_sharing_service.POJO.InputType.Type;

public class Pickup extends InputType {

    private static int nextID = 0;
    
    private int pickupID;
    private int carID;
    private int driverID;
    private int customerID;
    private Location origin;
    private Location destination;
    
    public Pickup() {
        this(-1, -1, -1, new Location(), new Location());
    }
    
    public Pickup(int carID_, int driverID_, int customerID_, Location origin_, Location destination_) {
        setCarID(carID_);
        setDriverID(driverID_);
        setCustomerID(customerID_);
        setOrigin(origin_);
        setDestination(destination_);
        
        pickupID = Pickup.nextID++;
    }
    
    @Override
    public Type getType() {
        return InputType.Type.PICKUP;
    }
    
    /* Setters and Getters */
    public int getCarID() {
        return carID;
    }
    public void setCarID(int carID_) {
        carID = carID_;
    }
    public int getDriverID() {
        return driverID;
    }
    public void setDriverID(int driverID_) {
        driverID = driverID_;
    }
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID_) {
        customerID = customerID_;
    }
    public Location getOrigin() {
        return origin;
    }
    public void setOrigin(Location origin_) {
        origin = origin_;
    }
    public Location getDestination() {
        return destination;
    }
    public void setDestination(Location destination_) {
        destination = destination_;
    }
}
