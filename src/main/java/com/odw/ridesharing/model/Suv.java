package com.odw.ridesharing.model;

import com.odw.ridesharing.model.abstractmodel.AbstractCar;

/**
 * Suv is a concrete implementation of Car class and is used to help 
 * parse the different carTypes. Suv class refers to cars that have
 * four doors and generally a rider capacity of 6.
 */
public class Suv extends AbstractCar {

    /**
     * Creates a default, empty Suv.
     */
    public Suv() {
        this(-1, "", "", "", -1);
    }
    
    /**
     * Creates a new Suv based on the given make, model, color, and year.
     * 
     * @param make_
     *            The Suv's current maker.
     * @param model_
     *            The Suv's current model.
     * @param color_
     *            The Suv's current color.
     * @param year_
     *            The Suv model's year.
     */
    public Suv(int carID_, String make_, String model_, String color_, int year_) {
        super(carID_, make_, model_, color_, year_);
    }
    
    /**
     * Get the carType as a string.
     */
    @Override
    public String getCarTypeAsString() {
        return CarType.SUV.toString();
    }
}
