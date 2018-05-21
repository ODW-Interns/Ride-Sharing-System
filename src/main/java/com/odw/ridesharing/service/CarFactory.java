package com.odw.ridesharing.service;

import java.util.ArrayList;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.Coupe;
import com.odw.ridesharing.model.Suv;
import com.odw.ridesharing.model.Sedan;

public class CarFactory {

    private int nextCarID = 0;
    
    public Car createCar(ArrayList<String> typeValues_) {        
        // NOTE typeValues_ format (as an ArrayList):
            // Values: CarType | Make | Model | Color | Year
            // Index:  0       | 1    | 2     | 3     | 4
        switch (typeValues_.get(0)) {
            case CarController.COUPE:
                return new Coupe(typeValues_.get(1), typeValues_.get(2), typeValues_.get(3), 
                        Integer.parseInt(typeValues_.get(4)), nextCarID++);
            case CarController.SEDAN:
                return new Sedan(typeValues_.get(1), typeValues_.get(2), typeValues_.get(3), 
                        Integer.parseInt(typeValues_.get(4)), nextCarID++);
            case CarController.SUV:
                return new Suv(typeValues_.get(1), typeValues_.get(2), typeValues_.get(3), 
                        Integer.parseInt(typeValues_.get(4)), nextCarID++);
            default:
                return null;
        }
    } 
}
