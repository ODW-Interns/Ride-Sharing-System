package com.odw.ridesharing.model.abstractmodel;

public abstract class Car {

    private int carID;
    private String make;
    private String model;
    private String color;
    private int year;
    private double distanceTraveled;

    /**
     * Creates a default, empty car.
     */
    public Car() {
        this(-1, "", "", "", -1);
    }

    /**
     * Creates a new car based on the given make, model, color, and year.
     * 
     * @param make_
     *            The car's current maker.
     * @param model_
     *            The car's current model.
     * @param color_
     *            The car's current color.
     * @param year_
     *            The car model's year.
     */
    public Car(int carID_, String make_, String model_, String color_, int year_) {
        setCarID(carID_);
        setMake(make_);
        setModel(model_);
        setColor(color_);
        setYear(year_);
        distanceTraveled = 0;
    }

    /**
     * Returns the car's information in String format using a specified delimiter.
     * 
     * @param delimiter_
     *            The delimiter used to separate the values.
     * @return The car information as a String separated by the specified delimiter.
     */
    /* @formatter:off */
    public String toString(String delimiter_) {
        return "CarID: " + getCarID() + " " + delimiter_ + " " + 
               "Maker: " + getMake() + " " + delimiter_ + " " +
               "Model: " + getModel() + " " + delimiter_ + " " +
               "Color: " + getColor() + " " + delimiter_ + " " +
               "Year: " + getYear() + " " + delimiter_ + " " +
               "Distance Traveled: " + getDistanceTraveled() + " " + delimiter_ + " ";
    }
    /* @formatter:on */

    /**
     * Returns the car's information in String format using pipes ("|") as the
     * default delimiter.
     * 
     * @return The car information as a String.
     */
    @Override
    public String toString() {
        return toString("|");
    }

    /**
     * Gets the current car's id that was assigned
     * 
     * @return The current car's id.
     */
    public int getCarID() {
        return carID;
    }

    /**
     * Sets the unique ID of the car. Determining if unique is not handled here.
     * 
     * @param carID_
     *            The car ID to be set.
     */
    public void setCarID(int carID_) {
        carID = carID_;
    }

    /**
     * Gets the color of the car.
     * 
     * @return The current color of the car.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the car.
     * 
     * @param color_
     *            The new color of the car.
     */
    public void setColor(String color_) {
        color = color_;
    }

    /**
     * Gets the car's maker.
     * 
     * @return The car's maker to be executed.
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the make of the car.
     * 
     * @param make_
     *            The new make of the car.
     */
    public void setMake(String make_) {
        make = make_;
    }

    /**
     * Gets the model of the car.
     * 
     * @return The current model of the car.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the car.
     * 
     * @param model_
     *            The new model of the car.
     */
    public void setModel(String model_) {
        model = model_;
    }

    /**
     * Gets the year of the car.
     * 
     * @return The car model's year of the car.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of the car.
     * 
     * @param year_
     *            The car model's year.
     */
    public void setYear(int year_) {
        year = year_;
    }

    /**
     * Gets the total distance traveled by the car
     * 
     * @return The total distance traveled by the car.
     */
    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    /**
     * Sets the distance traveled by the car
     * 
     * @param distanceTraveled_
     *            The new distance traveled by the car.
     */
    public void setDistanceTraveled(double distanceTraveled_) {
        distanceTraveled = distanceTraveled_;
    }
}
