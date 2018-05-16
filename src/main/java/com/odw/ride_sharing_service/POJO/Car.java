package com.odw.ride_sharing_service.POJO;

import com.odw.ride_sharing_service.POJO.InputType.Type;

public class Car extends InputType {

    private static int nextID = 0;

    private int carID;
    private int year;
    private String color;
    private String make;
    private String model;
    private double distanceTraveled; 

    public Car() {
        this("","",0,"");
    }
    
    public Car(String make_, String model_, int year_, String color_) {
        setMake(make_);
        setModel(model_);
        setYear(year_);
        setColor(color_);
        
        distanceTraveled = 0;
        carID = Car.nextID++;
    }
    
    @Override
    public Type getType() {
        return InputType.Type.CAR;
    }
    
    /* Setters and Getters */
    public String getColor() {
        return color;
    }
    public void setColor(String color_) {
        color = color_;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make_) {
        make = make_;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model_) {
        model = model_;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year_) {
        year = year_;
    }
    public double getDistanceTraveled() {
        return distanceTraveled;
    }
    public void setDistanceTraveled(double distanceTraveled_) {
        distanceTraveled = distanceTraveled_;
    }
}
