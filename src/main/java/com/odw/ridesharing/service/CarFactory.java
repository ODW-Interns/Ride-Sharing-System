package com.odw.ridesharing.service;

import java.util.ArrayList;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.Coupe;
import com.odw.ridesharing.model.SUV;
import com.odw.ridesharing.model.Sedan;

public class CarFactory {

    private int nextCarID = 0;
    
    public Car createCar(ArrayList<String> typeValues) {        
        switch (typeValues.get(0)) {
            case Car.COUPE:
                return new Coupe(typeValues.get(1), typeValues.get(2), typeValues.get(3), 
                        Integer.parseInt(typeValues.get(4)), nextCarID++);
            case Car.SEDAN:
                return new Sedan(typeValues.get(1), typeValues.get(2), typeValues.get(3), 
                        Integer.parseInt(typeValues.get(4)), nextCarID++);
            case Car.SUV:
                return new SUV(typeValues.get(1), typeValues.get(2), typeValues.get(3), 
                        Integer.parseInt(typeValues.get(4)), nextCarID++);
            default:
                return null;
        }
    } 
}
