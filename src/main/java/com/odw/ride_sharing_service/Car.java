package com.odw.ride_sharing_service;

public class Car extends InputType {

    private String color;
    private String make;
    private String model;
    private int year;
    private double distanceTraveled;

    public String getColor() {
        return color;
    }

    public void setColor(String color_) {
        this.color = color_;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make_) {
        this.make = make_;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model_) {
        this.model = model_;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year_) {
        this.year = year_;
    }
    
    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(double distanceTraveled_) {
        this.distanceTraveled = distanceTraveled_;
    }
    
    public Car() {
        
    }
    
    public Type getType() {
        return InputType.Type.CAR;
    }
}
