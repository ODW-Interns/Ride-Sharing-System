package com.odw.ridesharing.service;

import java.util.ArrayList;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.Coupe;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.Suv;
import com.odw.ridesharing.model.Sedan;

public class CarFactory {

    private int nextCarID = 0;

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

    public Car createCar(ArrayList<String> typeValues_) {
        String _carType = typeValues_.get(0);
        String _make = typeValues_.get(1);
        String _model = typeValues_.get(2);
        String _color = typeValues_.get(3);
        int _year = Integer.parseInt(typeValues_.get(4));

        switch (_carType) {
        case RuntimeConstants.COUPE:
            return new Coupe(_make, _model, _color, _year, nextCarID++);
        case RuntimeConstants.SEDAN:
            return new Sedan(_make, _model, _color, _year, nextCarID++);
        case RuntimeConstants.SUV:
            return new Suv(_make, _model, _color, _year, nextCarID++);
        default:
            return null;
        }

    }
}
