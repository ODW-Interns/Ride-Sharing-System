package com.odw.ridesharing.service;

import java.util.ArrayList;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.Coupe;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.Suv;
import com.odw.ridesharing.model.exceptions.BadCarException;
import com.odw.ridesharing.model.Sedan;

public class CarFactory {

    private int nextCarID = 0;

    /* @formatter:off */
    /**
     * Creates a specific Car instance object and sets its values. Assumes that the
     * method format is correct.
     * 
     * @param typeValues_
     *            the ArrayList to be turned into a Car Object
     * 
     *            NOTE: typeValues_ format (as an ArrayList):
     *            Values: CarType | Make | Model | Color | Year
     *            Index:  0       | 1    | 2     | 3     | 4
     * 
     * @return a Car Object
     */
    /* @formatter:on */
    public Car createCar(ArrayList<String> typeValues_) throws BadCarException {
        
        if (typeValues_.size() == RuntimeConstants.CREATE_CAR_FORMAT.length) {
                // store the values from ArrayList
                String _carType = typeValues_.get(0);
                String _make = typeValues_.get(1);
                String _model = typeValues_.get(2);
                String _color = typeValues_.get(3);
                int _year = Integer.parseInt(typeValues_.get(4));
    
                // create a Car object based off of its carType
                switch (_carType) {
                case RuntimeConstants.COUPE:
                    return new Coupe(nextCarID++, _make, _model, _color, _year);
                case RuntimeConstants.SEDAN:
                    return new Sedan(nextCarID++, _make, _model, _color, _year);
                case RuntimeConstants.SUV:
                    return new Suv(nextCarID++, _make, _model, _color, _year);
                default:
                    return null;
                
            }
        }
        
        throw new BadCarException();
    }
}
