/****************************************************************************
 * FILE: CarController.java
 * DSCRPT:
 ****************************************************************************/

package com.odw.ridesharing.service;

import java.util.concurrent.ConcurrentHashMap;

import com.odw.ridesharing.model.exceptions.BadCarException;

public class CarController {
    
    private ConcurrentHashMap<String, Object> _models;
    private ConcurrentHashMap<String, Object> _makes;
    private ConcurrentHashMap<String, Object> _year;
    

    /**
     *
     */
    private CarController() {
        _models = new ConcurrentHashMap<String, Object>();
        _makes = new ConcurrentHashMap<String, Object>();
        _year = new ConcurrentHashMap<String, Object>();
    }
    
    
    
    
    
    public void addCar(String make_, String model_, int year_, String color_) throws BadCarException
    {
        
    }

}
