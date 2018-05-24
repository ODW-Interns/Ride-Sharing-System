package com.odw.ridesharing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.Location;
import com.odw.ridesharing.model.Pickup;
import com.odw.ridesharing.model.exceptions.BadCarException;
import com.odw.ridesharing.model.exceptions.BadPickupException;
import com.odw.ridesharing.model.exceptions.BadUserException;
import com.odw.ridesharing.model.exceptions.InvalidUserArgumentsException;
import com.odw.ridesharing.model.exceptions.BadCustomerException;
import com.odw.ridesharing.service.CarController;
import com.odw.ridesharing.service.PickupController;
import com.odw.ridesharing.service.UserController;

public class PickupControllerTest {
    
	@Test
	public void testCreatePickup() {
		CarController carController = new CarController();
		UserController userController = new UserController();
		PickupController pickupController = new PickupController();
		Customer customer = new Customer();
		Driver driver = new Driver();
		Pickup pickup = new Pickup();

		ArrayList<String> coupeCarInfo = new ArrayList<String>();
		coupeCarInfo.add("coupe");
		coupeCarInfo.add("toyota");
		coupeCarInfo.add("trueno");
		coupeCarInfo.add("white");
		coupeCarInfo.add("1986");
		try {
			carController.createCar(coupeCarInfo);
		} catch (InvalidCarArgumentsException e_) {
			fail("Error creating a valid car.");
		}

		ArrayList<String> driverUserInfo = new ArrayList<String>();
		driverUserInfo.add("driver");
		driverUserInfo.add("Mark");
		driverUserInfo.add("Constantine");
		driverUserInfo.add("male");
		driverUserInfo.add("21");

		try {
		    driver = (Driver)(userController.createUser(driverUserInfo));
		} catch (InvalidUserArgumentsException e_) {
			fail("Error creating a valid driver user.");
		}

		ArrayList<String> customerUserInfo = new ArrayList<String>();
		customerUserInfo.add("customer");
		customerUserInfo.add("Pete");
		customerUserInfo.add("Tanthmanatham");
		customerUserInfo.add("male");
		customerUserInfo.add("21");

		try {
			customer = (Customer)(userController.createUser(customerUserInfo));
		} catch (InvalidUserArgumentsException e_) {
			fail("Error creating a valid driver user.");
		}

		ArrayList<String> pickupInfo = new ArrayList<String>();
		pickupInfo.add("1");
		pickupInfo.add("36.0731654");
		pickupInfo.add("-115.20643259999997");
		pickupInfo.add("36.0041386");
		pickupInfo.add("-115.1412292");

		try {
			pickup = pickupController.createPickup(pickupInfo, customer, driver);
			// check to see if schedule() is correct
			assertEquals(12.5 , pickup.getPickupCost(), 0.01d);
		} catch (BadPickupException e_) {
			fail("Error creating a valid pickup.");
		}

		// Invalid Pickup Info
		ArrayList<String> invalidPickupInfo = new ArrayList<String>();
		invalidPickupInfo.add("1");
		invalidPickupInfo.add("2");
		invalidPickupInfo.add("150.11");
		invalidPickupInfo.add("180.32");

		try {
			pickupController.createPickup(invalidPickupInfo, customer, driver);
		} catch (BadPickupException e_) {
			assertTrue(true);
		}
	}
		
}
