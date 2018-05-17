package com.odw.ridesharing.model;

public class Driver extends InputType {

    private static int nextID = 0;

    private int driverID;
    private int carID;
    private int rating;
    private Person driver;
    private boolean isAvailable;
    
    public Driver() {
        this(new Person(), -1, false, -1);
    }
    
    public Driver(Person driver_, int rating_, boolean isAvailable_, int carID_) {
        setDriver(driver_);
        setRating(rating_);
        setIsAvailable(isAvailable_);
        setCarID(carID_);
        
        driverID = Driver.nextID++;
    }

    @Override
    public Type getType() {
        return InputType.Type.DRIVER;
    }
    
    /* Setters and Getters */
    public Person getDriver() {
        return driver;
    }
    public void setDriver(Person driver_) {
        driver = driver_;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating_) {
        rating = rating_;
    }
    public boolean getIsAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(boolean isAvailable_) {
        isAvailable = isAvailable_;
    }
    public int getCarID() {
        return carID;
    }
    public void setCarID(int carID_) {
        carID = carID_;
    }
}
