package com.odw.ride_sharing_service.POJO;

import com.odw.ride_sharing_service.InputType;

public class Driver extends InputType {

    private static int nextID = 0;

    private int driverID;
    private int carID;
    private int rating;
    private Person person;
    private boolean isAvailable;
    
    public Driver() {
        this(new Person(), -1, false, -1);
    }
    
    public Driver(Person person_, int rating_, boolean isAvailable_, int carID_) {
        setPerson(person_);
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
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person_) {
        person = person_;
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
