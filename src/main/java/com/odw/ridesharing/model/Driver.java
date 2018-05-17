package com.odw.ridesharing.model;

public class Driver {

	private static int nextID = 0;

	private int driverID;
	private int carID;
	private int rating;
	private Person driver;
	private boolean isAvailable;

	public Driver() {
		this(new Person(), -1, false, -1);
	}

	/**
	 * Store the information of this driver
	 * 
	 * @param driver_ Driver's info and should includes Fistname, Lastname, Sex, and Age
	 * 
	 * @param rating_ Driver's rating
	 * 
	 * @param isAvaliable_ Driver's availability
	 * 
	 * @param carID_ Driver's unique car id
	 */
	public Driver(Person driver_, int rating_, boolean isAvailable_, int carID_) {
		setDriver(driver_);
		setRating(rating_);
		setIsAvailable(isAvailable_);
		setCarID(carID_);

		driverID = Driver.nextID++;
	}

	/**
	 * Get the info of this person driver
	 * 
	 * @return driver this driver's info
	 */
	public Person getDriver() {
		return driver;
	}
	
	/**
	 * Set person driver
	 * 
	 * @param driver_ This is driver's info to be set
	 * 				  It should includes Firstname, Lastname, Sex, and Age
	 */
	public void setDriver(Person driver_) {
		driver = driver_;
	}
	
	/**
	 * Get the rating of this driver
	 * 
	 * @return rating driver's rating info
	 */
	public int getRating() {
		return rating;
	}
	
	/**
	 * Set the rating of this driver
	 * 
	 * @param rating_ This is rating's info of the driver to be set
	 * 				  It should range from 1 to 5
	 */
	public void setRating(int rating_) {
		rating = rating_;
	}
	
	/**
	 * Get the availability of this driver
	 * 
	 * @return isAvailable This driver's status
	 */
	public boolean getIsAvailable() {
		return isAvailable;
	}

	/**
	 * Set the status of the this driver
	 * 
	 * @param isAvailable This driver's status to be set
	 * 					  It should be true or false
	 */
	public void setIsAvailable(boolean isAvailable_) {
		isAvailable = isAvailable_;
	}

	/**
	 * Get the car id of this driver
	 * 
	 * @return carID The id of this person's car
	 * 				 The id should be unique integer number
	 */
	public int getCarID() {
		return carID;
	}

	/**
	 * Set the car id of this driver
	 * 
	 * @param carID This is the driver's unique car id to be set
	 */
	public void setCarID(int carID_) {
		carID = carID_;
	}
}
