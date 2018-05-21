package com.odw.ridesharing.service;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.exceptions.BadCarException;
import java.util.ArrayList;
import java.util.Map;

public class CarController {

    // Available Cars
    public static final String COUPE = "coupe";
    public static final String SEDAN = "sedan";
    public static final String SUV = "suv";
    
    private ConcurrentHashMap<Integer, Car> carInventory;
    private CarFactory carFactory;

    /*
     * Default Constructor
     */
    public CarController() {
        carInventory = new ConcurrentHashMap<Integer, Car>();
        carFactory = new CarFactory();
    }

    /**
     * 
     * Call CarFactory to create a car
     * 
     * @param typeValue_
     *            Strings needed to create the car
     * @throws BadCarException
     *             If car.getID is greater than zero, then throw an exception
     */
    public void createCar(ArrayList<String> typeValue_) throws BadCarException {
        Car _car = carFactory.createCar(typeValue_);

        // Valid car IDs are non-negative.
        if (_car.getCarID() >= 0) {
            carInventory.put(_car.getCarID(), _car);
        } else {
            throw new BadCarException();
        }
    }

    /**
     * Modify the car's info in the inventory
     * 
     * @param typeValue_
     *            ArrayList of of input in string Should Contain Make, Model, Year,
     *            and Color
     * @throws BadCarException
     */
    public void modifyCar(ArrayList<String> typeValues) throws BadCarException {
        int _idx = Integer.parseInt(typeValues.get(0));
        Car _car = carInventory.get(_idx);
        if(_idx > -1) {
        	if(_car.getCarID() == _idx) {
        		_car.setMake(typeValues.get(2));
        		_car.setModel(typeValues.get(3));
        		_car.setColor(typeValues.get(4));
        		_car.setYear(Integer.parseInt(typeValues.get(5)));
        	}
        	else
        		throw new BadCarException();
        else
        	throw new BadCarException();
    }

    /**
     * Delete the car's info from the inventory
     * 
     * @param typeValues
     *            ArrayList of of input in string Should Contain carID to be deleted
     * @throws BadCarException
     */
    public void deleteCar(ArrayList<String> typeValues) throws BadCarException {

    	int _idx = Integer.parseInt(typeValues.get(0));
    	Car _car = carInventory.get(_idx);
    	if(_idx > -1) {
    		if(_car.getCarID() == _idx) 
    			carInventory.remove(_idx);
    		else
    			throw new BadCarException();
    	}
    	else
    		throw new BadCarException();
    }

    /**
     * Returns a string of all the cars in inventory.
     * 
     * @return TODO
     */
    public String getCarInventory() {
        if (carInventory.size() > 0) {
            StringBuilder _result = new StringBuilder();

            for (Map.Entry<Integer, Car> _entry : carInventory.entrySet()) {
                Car _currentCar = _entry.getValue();

                _result.append(_currentCar.toString() + System.lineSeparator());
            }

            return _result.toString();
        }

        return "";
    }

}
