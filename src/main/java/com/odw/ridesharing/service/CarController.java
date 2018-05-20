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
    public void modifyCar(ArrayList<String> typeValue_) throws BadCarException {
        // TODO add exception
        int _idx = Integer.parseInt(typeValue_.get(0));
        Car _car = carInventory.get(_idx);

        _car.setMake(typeValue_.get(2));
        _car.setModel(typeValue_.get(3));
        _car.setColor(typeValue_.get(4));
        _car.setYear(Integer.parseInt(typeValue_.get(5)));
    }

    /**
     * Delete the car's info from the inventory
     * 
     * @param typeValue_
     *            ArrayList of of input in string Should Contain carID to be deleted
     * @throws BadCarException
     */
    public void deleteCar(ArrayList<String> typeValue_) throws BadCarException {
        // TODO add exception
        carInventory.remove(Integer.parseInt(typeValue_.get(0)));
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
