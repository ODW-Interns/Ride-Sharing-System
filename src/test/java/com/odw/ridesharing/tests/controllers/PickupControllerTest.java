package com.odw.ridesharing.tests.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.exceptions.InvalidPickupArgumentsException;
import com.odw.ridesharing.model.exceptions.InvalidUserArgumentsException;
import com.odw.ridesharing.service.CarController;
import com.odw.ridesharing.service.PickupController;
import com.odw.ridesharing.service.UserController;

/**
 * Tests all the public methods inside PickupController.
 */
public class PickupControllerTest {
    
    /**
     * Tests PickupController's createPickup method. Ensures that a valid pickup can be
     * created and an invalid car is handled properly.
     */
	@Test
	public void testCreatePickup() {
		CarController _carController = new CarController();
		UserController _userController = new UserController();
		PickupController _pickupController = new PickupController();
		Customer _customer = new Customer();

		// Creating a valid car for the driver.
		try {
			_carController.createCar(createValidCarInfo());
		} catch (Exception e_) {
			fail("Error creating a valid car.");
		}

		// Creating a valid driver for the pickup.
		try {
		  _userController.createUser(createValidDriverInfo());
		} catch (Exception e_) {
			fail("Error creating a valid driver user.");
		}
		
		// Creating a valid customer for the pickup.
		try {
            _customer = (Customer)(_userController.createUser(createValidCustomerInfo()));
        } catch (InvalidUserArgumentsException e_) {
            fail("Error creating a valid driver user.");
        }
		
		// Modifying the driver to be available for pickup.
        try {
            _userController.modifyUser(modifyValidDriverInfo());
        } catch (Exception e_) {
            fail("Error modifying a valid driver");
        }

     // Creating an invalid pickup.
        try {
            _pickupController.createPickup(createValidPickupInfo(), _customer);
        } catch (InvalidPickupArgumentsException e_) {
            fail("Error creating a valid pickup."); // This is the desired outcome.
        }

        // Creating an invalid pickup.
        try {
            _pickupController.createPickup(createInvalidPickupInfo(), _customer);
        } catch (Exception e_) {
            assertTrue(true); // This is the desired outcome.
        }
	}
	
	@Test
	public void testDeletePickup() {
	    // [TODO]
	}
	
	@Test
	public void testSchedulePickup() {
	    // [TODO]
	}
	
	@Test
	public void testScheduleUnscheduledPickup() {
	    // [TODO]
	}
	
	/**
     * Helper function to generate valid car info.
     * 
     * @return An ArrayList of Strings containing valid car info.
     */
	private ArrayList<String> createValidCarInfo() {
	    ArrayList<String> _validCarInfo = new ArrayList<String>();
	    _validCarInfo.add("coupe");
        _validCarInfo.add("toyota");
        _validCarInfo.add("trueno");
        _validCarInfo.add("white");
        _validCarInfo.add("1986");
        return _validCarInfo;
	}
	
	/**
     * Helper function to generate valid driver info.
     * 
     * @return An ArrayList of Strings containing valid driver info.
     */
	private ArrayList<String> createValidDriverInfo() {
	    ArrayList<String> _validDriverInfo = new ArrayList<String>();
        _validDriverInfo.add("driver");
        _validDriverInfo.add("Mark");
        _validDriverInfo.add("Constantine");
        _validDriverInfo.add("male");
        _validDriverInfo.add("21");
        return _validDriverInfo;
	}
	
	/**
     * Helper function to generate valid modify driver info.
     * 
     * @return An ArrayList of Strings containing valid car info.
     */
	private ArrayList<String> modifyValidDriverInfo() {
        ArrayList<String> _modifyValidDriverInfo = new ArrayList<String>();
        _modifyValidDriverInfo.add("0");
        _modifyValidDriverInfo.add("driver");
        _modifyValidDriverInfo.add("Mark");
        _modifyValidDriverInfo.add("Constantine");
        _modifyValidDriverInfo.add("male");
        _modifyValidDriverInfo.add("21");
        _modifyValidDriverInfo.add("true");
        _modifyValidDriverInfo.add("0");
        return _modifyValidDriverInfo;
    }
	
	/**
     * Helper function to generate valid customer info.
     * 
     * @return An ArrayList of Strings containing valid customer info.
     */
	private ArrayList<String> createValidCustomerInfo() {
	    ArrayList<String> _validCustomerInfo = new ArrayList<String>();
        _validCustomerInfo.add("customer");
        _validCustomerInfo.add("Pete");
        _validCustomerInfo.add("Tanthmanatham");
        _validCustomerInfo.add("male");
        _validCustomerInfo.add("21");
        return _validCustomerInfo;
	}
	
	/**
     * Helper function to generate valid pickup info.
     * 
     * @return An ArrayList of Strings containing valid pickup info.
     */
	private ArrayList<String> createValidPickupInfo() {
	    ArrayList<String> _validPickupInfo = new ArrayList<String>();
        _validPickupInfo.add("1");
        _validPickupInfo.add("36.0731654");
        _validPickupInfo.add("-115.20643259999997");
        _validPickupInfo.add("36.0041386");
        _validPickupInfo.add("-115.1412292");
        return _validPickupInfo;
	}
	
	/**
     * Helper function to generate invalid pickup info.
     * 
     * @return An ArrayList of Strings containing invalid pickup info.
     */
	private ArrayList<String> createInvalidPickupInfo() {
	    ArrayList<String> _invalidPickupInfo = new ArrayList<String>();
        _invalidPickupInfo.add("1");
        _invalidPickupInfo.add("2");
        _invalidPickupInfo.add("150.11");
        _invalidPickupInfo.add("180.32");
        return _invalidPickupInfo;
	}
}
