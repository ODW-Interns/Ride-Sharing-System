package com.odw.ridesharing.model;

import com.odw.ridesharing.model.abstractmodel.AbstractCar;

/**
 * Coupe is a concrete implementation of Car class and is used to help 
 * parse the different carTypes. Coupe class refers to cars that have
 * two doors and generally a total rider capacity of 2-4.
 */
public class Coupe extends AbstractCar {

    /**
     * Creates a default, empty Coupe.
     */
    public Coupe() {
        this(-1, "", "", "", -1);
    }
    
    /**
     * Creates a new Coupe based on the given make, model, color, and year.
     * 
     * @param make_
     *            The Coupe's current maker.
     * @param model_
     *            The Coupe's current model.
     * @param color_
     *            The Coupe's current color.
     * @param year_
     *            The Coupe model's year.
     */
    public Coupe(int carID_, String make_, String model_, String color_, int year_) {
        super(carID_, make_, model_, color_, year_);
    }
    
    /**
     * Get the carType as a string.
     */
    @Override
    public String getCarTypeAsString() {
        return CarType.COUPE.toString();
    }
    
}
