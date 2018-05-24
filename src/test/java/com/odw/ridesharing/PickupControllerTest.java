package com.odw.ridesharing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.Pickup;
import com.odw.ridesharing.model.exceptions.BadCarException;
import com.odw.ridesharing.model.exceptions.BadUserException;
import com.odw.ridesharing.model.exceptions.InvalidCarArgumentsException;
import com.odw.ridesharing.model.exceptions.InvalidPickupArgumentsException;
import com.odw.ridesharing.model.exceptions.InvalidUserArgumentsException;
import com.odw.ridesharing.model.exceptions.BadCustomerException;
import com.odw.ridesharing.service.CarController;
import com.odw.ridesharing.service.PickupController;
import com.odw.ridesharing.service.UserController;

public class PickupControllerTest {
    
	@Test
	public void testCreatePickup() {
		CarController _carController = new CarController();
		UserController _userController = new UserController();
		PickupController _pickupController = new PickupController();
		Customer _customer = new Customer();
		Driver _driver = new Driver();
		Pickup _pickup = new Pickup();

		ArrayList<String> _coupeCarInfo = new ArrayList<String>();
		_coupeCarInfo.add("coupe");
		_coupeCarInfo.add("toyota");
		_coupeCarInfo.add("trueno");
		_coupeCarInfo.add("white");
		_coupeCarInfo.add("1986");
		try {
			_carController.createCar(_coupeCarInfo);
		} catch (InvalidCarArgumentsException e_) {
			fail("Error creating a valid car.");
		}

		ArrayList<String> _driverUserInfo = new ArrayList<String>();
		_driverUserInfo.add("driver");
		_driverUserInfo.add("Mark");
		_driverUserInfo.add("Constantine");
		_driverUserInfo.add("male");
		_driverUserInfo.add("21");

		try {
		  _driver = (Driver)(_userController.createUser(_driverUserInfo));
		} catch (InvalidUserArgumentsException e_) {
			fail("Error creating a valid driver user.");
		}

		ArrayList<String> _customerUserInfo = new ArrayList<String>();
		_customerUserInfo.add("customer");
		_customerUserInfo.add("Pete");
		_customerUserInfo.add("Tanthmanatham");
		_customerUserInfo.add("male");
		_customerUserInfo.add("21");

		try {
			_customer = (Customer)(_userController.createUser(_customerUserInfo));
		} catch (InvalidUserArgumentsException e_) {
			fail("Error creating a valid driver user.");
		}

		ArrayList<String> _pickupInfo = new ArrayList<String>();
		_pickupInfo.add("1");
		_pickupInfo.add("36.0731654");
		_pickupInfo.add("-115.20643259999997");
		_pickupInfo.add("36.0041386");
		_pickupInfo.add("-115.1412292");

		try {
			_pickup = _pickupController.createPickup(_pickupInfo, _customer, _driver);
			// check to see if schedule() is correct
			assertEquals(12.5 , _pickup.getPickupCost(), 0.01d);
		} catch (InvalidPickupArgumentsException e_) {
			fail("Error creating a valid pickup.");
		}

		// Invalid Pickup Info
		ArrayList<String> _invalidPickupInfo = new ArrayList<String>();
		_invalidPickupInfo.add("1");
		_invalidPickupInfo.add("2");
		_invalidPickupInfo.add("150.11");
		_invalidPickupInfo.add("180.32");

		try {
			_pickupController.createPickup(_invalidPickupInfo, _customer, _driver);
		} catch (InvalidPickupArgumentsException e_) {
			assertTrue(true); // This is the desired outcome.
		}
	}
		
}
