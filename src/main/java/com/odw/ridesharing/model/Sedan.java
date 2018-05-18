package com.odw.ridesharing.model;

public class Sedan extends Car {

    /**
     * Creates a default, empty sedan.
     */
    public Sedan() {
        this("", "", "", -1, -1);
    }
    
    /**
     * Creates a new sedan based on the given make, model, color, and year.
     * 
     * @param make_
     *            The sedan's current maker.
     * @param model_
     *            The sedan's current model.
     * @param color_
     *            The sedan's current color.
     * @param year_
     *            The sedan model's year.
     */
    public Sedan(String make_, String model_, String color_, int year_, int idx_) {
        super(make_, model_, color_, year_, idx_);
    }
}
