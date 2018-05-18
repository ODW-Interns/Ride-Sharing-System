package com.odw.ridesharing.model;

public class Coupe extends Car {

    /**
     * Creates a default, empty coupe.
     */
    public Coupe() {
        this("", "", "", -1, -1);
    }
    
    /**
     * Creates a new coupe based on the given make, model, color, and year.
     * 
     * @param make_
     *            The coupe's current maker.
     * @param model_
     *            The coupe's current model.
     * @param color_
     *            The coupe's current color.
     * @param year_
     *            The coupe model's year.
     */
    public Coupe(String make_, String model_, String color_, int year_, int idx_) {
        super(make_, model_, color_, year_, idx_);
    }
    
}
