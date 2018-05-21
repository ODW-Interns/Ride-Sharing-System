package com.odw.ridesharing.service;

import java.util.ArrayList;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.Coupe;
import com.odw.ridesharing.model.Suv;
import com.odw.ridesharing.model.Sedan;

public class CarFactory {

    private int nextCarID = 0;
    
    
    /**
     * Create a Car Object and fill it with ArrayList info
     * 
     * @param typeValues_ 
     *          the ArrayList to be turned into a Car Object
     *     
     * NOTE: typeValues_ format (as an ArrayList):
     *      Values: CarType | Make | Model | Color | Year
     *      Index:  0       | 1    | 2     | 3     | 4
     * 
     * @return 
     *          a Car Object
     */
    public Car createCar(ArrayList<String> typeValues_) {  
        
        String _carType = typeValues_.get(0);
        String _make = typeValues_.get(1);
        String _model = typeValues_.get(2);
        String _color = typeValues_.get(3);
        int _year = Integer.parseInt(typeValues_.get(4));
        
        // get the carType 
        switch (typeValues_.get(0)) {
            case CarController.COUPE:
                return new Coupe(_make, _model, _color, _year, nextCarID++);
                
            case CarController.SEDAN:
                return new Sedan(_make, _model, _color, _year, nextCarID++);
                
            case CarController.SUV:
                return new Suv(_make, _model, _color, _year, nextCarID++);
                
            default:
                return null;
        }
    } 
}
