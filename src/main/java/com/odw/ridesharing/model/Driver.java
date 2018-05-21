package com.odw.ridesharing.model;

public class Driver extends User {

	private int carID;
	private int rating;
	private User driver;
	private boolean isAvailable;

	public Driver() {
		this(-1, "", "", "", -1, -1, false, -1);
	}
	
	/**
	 * Store the information of this driver
	 * 
	 * @param firstName_ Driver's first name
	 * 
	 * @param lastName_ Driver's last name
	 * @param sex_ Driver's sex
	 * @param age_ Driver's age
	 * @param userID_ Driver's userID
	 * @param rating_ Driver's rating
	 * @param isAvaliable_ Driver's availability
	 * @param carID_ Driver's unique car id
	 */
	public Driver(int userID_, String firstName_, String lastName_, String sex_, int age_, int rating_, Boolean isAvailable_, int carID_) {
	    super(userID_, firstName_, lastName_, sex_, age_);
	    setRating(rating_);
	    setIsAvailable(isAvailable); 
	    setCarID(carID_);
	}
	
	/**
	 * Get the info of this person driver
	 * 
	 * @return driver this driver's info
	 */
	public User getDriver() {
		return driver;
	}
	
	/**
	 * Set person driver
	 * 
	 * @param driver_ This is driver's info to be set
	 * 				  It should includes Firstname, Lastname, Sex, and Age
	 */
	public void setDriver(User driver_) {
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
