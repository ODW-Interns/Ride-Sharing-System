package com.odw.ridesharing.model;

/**
 *
 */
public class Car extends InputType {

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

    /** 
     * (non-Javadoc)
     */
    @Override
    public Type getType() {
        return InputType.Type.CAR;
    }

    /* Setters and Getters */
    public String getColor() {
        return color;
    }

    /**
     * 
     */
    public void setColor(String color_) {
        color = color_;
    }

    /**
     * 
     */
    public CarMaker getMake() {
        return maker;
    }

    public void setMake(CarMaker make_) {
        maker = make_;
    }

    /**
     * 
     */
    public String getModel() {
        return model;
    }

    /**
     * 
     */
    public void setModel(String model_) {
        model = model_;
    }

    /**
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * 
     */
    public void setYear(int year_) {
        year = year_;
    }

    /**
     * 
     */
    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    /**
     * 
     */
    public void setDistanceTraveled(double distanceTraveled_) {
        distanceTraveled = distanceTraveled_;
    }
}
