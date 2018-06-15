package com.odw.ridesharing.model;

import com.odw.ridesharing.model.abstractmodel.AbstractCar;

/**
 * Sedan is a concrete implementation of Car class and is used to help 
 * parse the different carTypes. Sedan class refers to cars that have
 * four doors and generally a total rider capacity of 5.
 */
public class Sedan extends AbstractCar {

    /**
     * Creates a default, empty Sedan.
     */
    public Sedan() {
        this(-1, "", "", "", -1);
    }
    
    /**
     * Creates a new Sedan based on the given make, model, color, and year.
     * 
     * @param make_
     *            The Sedan's current maker.
     * @param model_
     *            The Sedan's current model.
     * @param color_
     *            The Sedan's current color.
     * @param year_
     *            The Sedan model's year.
     */
    public Sedan(int carID_, String make_, String model_, String color_, int year_) {
        super(carID_, make_, model_, color_, year_);
    }
    
    /**
     * Get the carType as a string.
     */
    @Override
    public String getCarTypeAsString() {
        return CarType.SEDAN.toString();
    }
}
