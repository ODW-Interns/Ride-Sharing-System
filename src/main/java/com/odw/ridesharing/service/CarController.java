/****************************************************************************
 * FILE: CarController.java
 * DSCRPT:
 ****************************************************************************/

package com.odw.ridesharing.service;

import java.util.concurrent.ConcurrentHashMap;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.exceptions.BadCarException;
import java.util.ArrayList;

public class CarController {

	private ConcurrentHashMap<Integer, Object> CarInventory;

	/*
	 * Default Constructor
	 */
	private CarController() {
		CarInventory = new ConcurrentHashMap<Integer, Object>();
	}

	/**
	 * 
	 * Call CarFactory to create a car
	 * 
	 * @param typeValue Strings needed to create the cae
	 * @throws BadCarException If car.getID is greater than zero, then throw an exception
	 */
	public void createCar(ArrayList<String> typeValue) throws BadCarException {
		Car car = CarFactory.createCar(typeValue);
		if (car.getCarID >= 0)
			CarInventory.put(car.getCarID, car);
		else
			throw new BadCarException();
	}

}
