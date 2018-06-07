package com.odw.ridesharing.service;

import java.util.concurrent.ConcurrentHashMap;

import com.odw.ridesharing.factories.CarFactory;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.abstractmodel.Car;

import com.odw.ridesharing.model.exceptions.CarNotFoundException;
import com.odw.ridesharing.model.exceptions.InvalidCarArgumentsException;

import java.util.ArrayList;
import java.util.Map;

/**
 * CarController is called by CommandController to handle the commands done on
 * Car. Car Controller calls CarFactory to create a Car and handles modifying
 * and deleting of Car object.
 */
public class CarController {

    private ConcurrentHashMap<Integer, Car> carInventory = new ConcurrentHashMap<Integer, Car>();
    private CarFactory carFactory = new CarFactory();

    /**
     * 
     * Call CarFactory to create a car
     * 
     * @param typeValues_
     *            Expected input values specified under CREATE_CAR_FORMAT in
     *            RuntimeConstants.
     * @return _car To be used for logger
     * @throws InvalidCarArgumentsException
     */
    public Car createCar(ArrayList<String> typeValues_) throws InvalidCarArgumentsException {
        if (typeValues_.size() == RuntimeConstants.CREATE_CAR_FORMAT.length) {
            try {
                Car _car = carFactory.buildCar(typeValues_);
                carInventory.put(_car.getCarID(), _car);
                return _car;
            } catch (Exception e_) {
                throw new InvalidCarArgumentsException();
            }
        }
        // Something went wrong..
        throw new InvalidCarArgumentsException();
    }

    /**
     * Modifies the car specified by the ID by creating a new car and deleting the
     * old car.
     * 
     * @param typeValues_
     *            Expected input values specified under MODIFY_CAR_FORMAT in
     *            RuntimeConstants.
     */
    public Car modifyCar(ArrayList<String> typeValues_) throws CarNotFoundException, InvalidCarArgumentsException {
        if (typeValues_.size() == RuntimeConstants.MODIFY_CAR_FORMAT.length) {
            try {
                // Removing the carID from typeValues_ so that it is properly formatted
                // to CREATE_CAR_FORMAT (see RuntimeConstants) buildCar (in carFactory).
                int _carID = Integer.parseInt(typeValues_.remove(0));

                // Removing the old car from the system.
                Car _oldCar = carInventory.remove(_carID);

                // Modifying the existing car by replacing it with a new car.
                Car _newlyModifiedCar = carFactory.buildCar(typeValues_);

                // Setting this car ID to _oldCar's ID. NullPointerException if _oldCar is null.
                _newlyModifiedCar.setCarID(_oldCar.getCarID());

                // Replacing the old car with the new car.
                carInventory.put(_newlyModifiedCar.getCarID(), _newlyModifiedCar);

                return _newlyModifiedCar;
            } catch (NullPointerException e_) {
                throw new CarNotFoundException();
            } catch (NumberFormatException e_) {
                throw new InvalidCarArgumentsException();
            }
        }

        // Something went wrong..
        throw new CarNotFoundException();
    }

    /**
     * Delete the car's info from the inventory
     * 
     * @param typeValues_
     *            Expected input values specified under DELETE_CAR_FORMAT in
     *            RuntimeConstants.
     * @return carInventory.remove(_carID) The object to be removed
     * @throws CarNotFoundException
     */
    public Car deleteCar(ArrayList<String> typeValues_) throws CarNotFoundException {
        if (typeValues_.size() == RuntimeConstants.DELETE_CAR_FORMAT.length) {
            int _carID = Integer.parseInt(typeValues_.get(0));

            if (carInventory.get(_carID) != null) {
                return carInventory.remove(_carID);
            } else {
                throw new CarNotFoundException();
            }
        }

        // Something went wrong..
        throw new CarNotFoundException();
    }

    /**
     * Check to see if a car is in inventory.
     * 
     * @param carID_
     *            The ID used to lookup the car.
     * @return Returns true if the car is inventory. False otherwise.
     */
    public boolean isCarInInventory(int carID_) {
        return carInventory.get(carID_) != null; // If null then car doesn't exist in inventory.
    }

    /**
     * Returns a string of all the cars in inventory.
     * 
     * @return A list string of all the cars currently in inventory.
     */
    public String getCarInventoryAsString() {
        if (!carInventory.isEmpty()) {
            StringBuilder _result = new StringBuilder();

            for (Map.Entry<Integer, Car> _entry : carInventory.entrySet()) {
                Car _currentCar = _entry.getValue();

                _result.append(System.lineSeparator() + _currentCar.toString());
            }

            return _result.toString();
        }

        return "";
    }

}
