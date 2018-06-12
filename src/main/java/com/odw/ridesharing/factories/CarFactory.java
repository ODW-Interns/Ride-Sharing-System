package com.odw.ridesharing.factories;

import java.time.LocalDateTime;

import com.odw.ridesharing.exceptions.InvalidCarArgumentsException;
import com.odw.ridesharing.model.CarType;
import com.odw.ridesharing.model.Coupe;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.Sedan;
import com.odw.ridesharing.model.Suv;
import com.odw.ridesharing.model.abstractmodel.AbstractCar;

/**
 * CarFactory is called by CarController to create a Car object. The carID is instantiated in this class and is assigned
 * to the Car objects as they are created.
 */
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
     *            NOTE: typeValues_ format (as an ArrayList): Values: CarType | Make
     *            | Model | Color | Year Index: 0 | 1 | 2 | 3 | 4
     * 
     * @return a Car Object
     */
    /* @formatter:on */
    
    // Deprecated!
    /*
    public AbstractCar buildCar(ArrayList<String> typeValues_) throws InvalidCarArgumentsException {

        if (typeValues_.size() == RuntimeConstants.CREATE_CAR_FORMAT.length) {
            try {
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
            catch (NullPointerException e_) {
                throw new InvalidCarArgumentsException();
            }
            catch (NumberFormatException e_) {
                throw new InvalidCarArgumentsException();
            }
        }
        // something went wrong creating a car...
        throw new InvalidCarArgumentsException();
    }*
    /
    
    /**
     * Creates a specific Car instance object and sets its values.
     * 
     * @param carType_
     *            The type of car.
     * @param make_
     *            The make of the car.
     * @param model_
     *            The model of the car.
     * @param color_
     *            The color of the car.
     * @param year_
     *            The year of the car.
     * @return The newly created car.
     * @throws InvalidCarArgumentsException
     */
    /* @formatter:off */
    public AbstractCar buildCar(CarType carType_,
                                String make_,
                                String model_,
                                String color_,
                                int year_) throws InvalidCarArgumentsException {
        
        if (year_ > LocalDateTime.now().getYear() || year_ < RuntimeConstants.FIRST_YEAR_CARS_EXISTED) {
            throw new InvalidCarArgumentsException("Invalid arguments, bad year. Value passed: " + Integer.toString(year_));
        }
        
        if (color_ == null || "".equals(color_)) {
            throw new InvalidCarArgumentsException("Invalid arguments, bad color. Value passed: " + (color_ == null ? "NULL" : color_));
        }
        
        if (model_ == null || "".equals(model_)) {
            throw new InvalidCarArgumentsException("Invalid arguments, bad model. Value passed: " + (model_ == null ? "NULL" : model_));
        }
        
        if (make_ == null || "".equals(make_)) {
            throw new InvalidCarArgumentsException("Invalid arguments, bad make. Value passed: " + (make_ == null ? "NULL" : make_));
        }
        
        switch (carType_) {
            case COUPE:
                return new Coupe(nextCarID++, make_, model_, color_, year_);
            case SEDAN:
                return new Sedan(nextCarID++, make_, model_, color_, year_);
            case SUV:
                return new Suv(nextCarID++, make_, model_, color_, year_);
            default:
                throw new InvalidCarArgumentsException("Invalid arguments, unable to determine car type. Value passed: " + carType_.toString());
        }
    }
    /* @formatter:on */
    
}
