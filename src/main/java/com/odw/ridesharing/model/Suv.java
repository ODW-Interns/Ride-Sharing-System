package com.odw.ridesharing.model;

import com.odw.ridesharing.model.abstractmodel.Car;

public class Suv extends Car {

    /**
     * Creates a default, empty suv.
     */
    public Suv() {
        this(-1, "", "", "", -1);
    }
    
    /**
     * Creates a new suv based on the given make, model, color, and year.
     * 
     * @param make_
     *            The suv's current maker.
     * @param model_
     *            The suv's current model.
     * @param color_
     *            The suv's current color.
     * @param year_
     *            The suv model's year.
     */
    public Suv(int carID_, String make_, String model_, String color_, int year_) {
        super(carID_, make_, model_, color_, year_);
    }
}
