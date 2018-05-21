package com.odw.ridesharing.service;

import java.util.concurrent.ConcurrentHashMap;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.exceptions.BadCarException;
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
     * @throws BadCarException
     *             If car.getID is greater than zero. If typeValues
     */
    public Car createCar(ArrayList<String> typeValues_) throws BadCarException {
        if (typeValues_.size() == RuntimeConstants.CREATE_CAR_FORMAT.length) {
            Car _car = carFactory.createCar(typeValues_);
            carInventory.put(_car.getCarID(), _car);
            return _car;
        }
        
        // Something went wrong..
        throw new BadCarException();
    }

    /**
     * Modify the car's info in the inventory
     * 
     * @param typeValue_
     *            ArrayList of of input in string Should Contain Make, Model, Year,
     *            and Color
     * @throws BadCarException
     */
    public Car modifyCar(ArrayList<String> typeValues_) throws BadCarException {
        if (typeValues_.size() == RuntimeConstants.MODIFY_CAR_FORMAT.length) {
            int _idx = Integer.parseInt(typeValues_.get(0));
            String _newMake = typeValues_.get(2);
            String _newModel = typeValues_.get(3);
            String _newColor = typeValues_.get(4);
            int _newYear = Integer.parseInt(typeValues_.get(5));

            Car _currentCar = carInventory.get(_idx);

            if (_currentCar != null) {
                _currentCar.setMake(_newMake);
                _currentCar.setModel(_newModel);
                _currentCar.setColor(_newColor);
                _currentCar.setYear(_newYear);
                return _currentCar;
            } else {
                throw new BadCarException();
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
     * @throws BadCarException
     */
    public Car deleteCar(ArrayList<String> typeValues_) throws BadCarException {
        if (typeValues_.size() == RuntimeConstants.DELETE_CAR_FORMAT.length) {
            int _idx = Integer.parseInt(typeValues_.get(0));

            try {
                return carInventory.remove(_idx);
            } catch (NullPointerException e_) {
                throw new BadCarException();
            }
        }
        
        // Something went wrong..
        throw new BadCarException();
    }

    /**
     * Returns a string of all the cars in inventory.
     * 
     * @return A list string of all the cars currently in inventory.
     */
    public String getCarInventory() {
        if (carInventory.size() > 0) {
            StringBuilder _result = new StringBuilder(System.lineSeparator());

            for (Map.Entry<Integer, Car> _entry : carInventory.entrySet()) {
                Car _currentCar = _entry.getValue();

                _result.append(_currentCar.toString() + System.lineSeparator());
            }

            return _result.toString();
        }

        return "";
    }

}
