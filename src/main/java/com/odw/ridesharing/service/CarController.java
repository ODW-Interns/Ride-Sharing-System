package com.odw.ridesharing.service;

import java.util.concurrent.ConcurrentHashMap;

import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.abstractmodel.Car;

import com.odw.ridesharing.model.exceptions.BadCarException;
import com.odw.ridesharing.model.exceptions.BadCustomerException;
import com.odw.ridesharing.model.exceptions.InvalidCarArgumentsException;

import java.util.ArrayList;
import java.util.Map;

public class CarController {

    private ConcurrentHashMap<Integer, Car> carInventory = new ConcurrentHashMap<Integer, Car>();
    private CarFactory carFactory = new CarFactory();

    /**
     * 
     * Call CarFactory to create a car
     * 
     * @param typeValues_
     *            Strings needed to create the car
     * @return _car To be used for logger
     * @throws InvalidCarArgumentsException 
     */
    public Car createCar(ArrayList<String> typeValues_) throws InvalidCarArgumentsException {
        if (typeValues_.size() == RuntimeConstants.CREATE_CAR_FORMAT.length) {
            try {
                Car _car = carFactory.createCar(typeValues_);
                carInventory.put(_car.getCarID(), _car);
                return _car;
            } catch (NullPointerException e_) {
                throw new InvalidCarArgumentsException();
            } catch (NumberFormatException e_) {
                throw new InvalidCarArgumentsException();
            }
        }

        // Something went wrong..
        throw new InvalidCarArgumentsException();
    }

    /**
     * Modify the car's info in the inventory
     * 
     * @param typeValue_
     *            ArrayList of of input in string Should Contain Make, Model, Year,
     *            and Color
     * @return _currentCar Car object to be used in logger
     * @throws BadCarException
     * @throws InvalidCarArgumentsException
     */
    public Car modifyCar(ArrayList<String> typeValues_) throws BadCarException, InvalidCarArgumentsException {
        if (typeValues_.size() == RuntimeConstants.MODIFY_CAR_FORMAT.length) {
            try {

                int _carID = Integer.parseInt(typeValues_.get(0));
                // typeValues_.get(1) = carType (coupe/sedan/suv)
                String _newMake = typeValues_.get(2);
                String _newModel = typeValues_.get(3);
                String _newColor = typeValues_.get(4);
                int _newYear = Integer.parseInt(typeValues_.get(5));

                Car _currentCar = carInventory.get(_carID);

                if (_currentCar != null) {
                    _currentCar.setMake(_newMake);
                    _currentCar.setModel(_newModel);
                    _currentCar.setColor(_newColor);
                    _currentCar.setYear(_newYear);
                    return _currentCar;
                } else {
                    throw new BadCarException();
                }
            } catch (NullPointerException e_) {
                throw new InvalidCarArgumentsException();
            } catch (NumberFormatException e_) {
                throw new InvalidCarArgumentsException();
            }
        }

        // Something went wrong..
        throw new BadCarException();
    }

    /**
     * Delete the car's info from the inventory
     * 
     * @param typeValues_
     *            ArrayList of of input in string Should Contain carID to be deleted
     * @return carInventory.remove(_carID) The object to be removed
     * @throws BadCarException
     */
    public Car deleteCar(ArrayList<String> typeValues_) throws BadCarException {
        if (typeValues_.size() == RuntimeConstants.DELETE_CAR_FORMAT.length) {
            int _carID = Integer.parseInt(typeValues_.get(0));
            try {
                return carInventory.remove(_carID);
            } catch (NullPointerException e_) {
                throw new BadCarException();
            }
        }

        // Something went wrong..
        throw new BadCarException();
    }
    
    public Car getCarByID (int carID_) throws BadCarException{
        Car _retrievedCar = carInventory.get(carID_);

        if (_retrievedCar != null) {
            return _retrievedCar;
        }

        // Car does not exist.
        throw new BadCarException();
    }

    /**
     * Returns a string of all the cars in inventory.
     * 
     * @return A list string of all the cars currently in inventory.
     */
    public String getCarInventoryAsString() {
        if (carInventory.size() > 0) {
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
