package com.odw.ridesharing.service;

import java.util.concurrent.ConcurrentHashMap;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.exceptions.BadCarException;
import java.util.ArrayList;
import java.util.Map;

public class CarController {

    private ConcurrentHashMap<Integer, Car> carInventory;
    private CarFactory carFactory;

    /*
     * Default Constructor
     */
    public CarController() {
        carFactory = new CarFactory();
        carInventory = new ConcurrentHashMap<Integer, Car>();
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
     * Temporary for now.
     * TODO: Modify
     */
    public String getCarInventory() {

        if (carInventory.size() > 0) {
            StringBuilder result = new StringBuilder();

            for (Map.Entry<Integer, Car> entry : carInventory.entrySet()) {
                int i = entry.getKey().intValue();
                Car c = entry.getValue();

                result.append(c.toString());
            }

            return result.toString();
        }

        return "";

    }

}
