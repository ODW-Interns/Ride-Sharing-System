package com.odw.ridesharing.model;

/**
 *
 */
public class Car {

    private static int nextID = 0;

    private int carID;
    private int year;

    private CarMaker maker;

    private String color;
    private String model;
    private double distanceTraveled;

    /**
     *
     */
    protected Car() {
        this(null, "", 0, "");
    }

    /**
     *
     */
    public Car(CarMaker make_, String model_, int year_, String color_) {
        setModel(model_);
        setYear(year_);
        setColor(color_);

        distanceTraveled = 0;
        carID = Car.nextID++;
    }

    /* Getters and Setters */
    
    /**
     * Gets the color of the car
     * 
     * @return The color of the car to be executed
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the car
     * 
     * @param The new color to be set
     */
    public void setColor(String color_) {
        color = color_;
    }

    /**
     * Get the car's maker
     * 
     * @return The car's maker to be executed
     */
    public CarMaker getMake() {
        return maker;
    }

    /**
     * Set the make of the car
     * 
     * @param The new make of the car to be set
     */
    public void setMake(CarMaker make_) {
        maker = make_;
    }

    /**
     * Get the model of the car
     * 
     * @return The model of the car to be executed
     */
    public String getModel() {
        return model;
    }

    /**
     * Set the model of the car
     * 
     * @param The new model of the car
     */
    public void setModel(String model_) {
        model = model_;
    }

    /**
     * Get the year of the car
     * 
     * @return The year of the car to be executed
     */
    public int getYear() {
        return year;
    }

    /**
     * Set the year of the car
     * 
     * @param The new year of the car to set
     */
    public void setYear(int year_) {
        year = year_;
    }

    /**
     * Get the total distance traveled by the car
     * 
     * @return the total distance traveled by the car
     */
    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    /**
     * Set the distance traveled by the car
     * 
     * @param the new distance traveled by the car
     */
    public void setDistanceTraveled(double distanceTraveled_) {
        distanceTraveled = distanceTraveled_;
    }
}
