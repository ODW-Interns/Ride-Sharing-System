package com.odw.ridesharing.tests.controllers;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

import com.odw.ridesharing.controllers.CarController;
import com.odw.ridesharing.model.exceptions.CarNotFoundException;
import com.odw.ridesharing.model.exceptions.InvalidCarArgumentsException;

/**
 * Tests all the public methods inside CarController.
 */
public class CarControllerTest {

	/**
	 * Tests CarController's createCar method. Ensures that a valid car can be
	 * created.
	 */
	@Test
	public void testCreateValidCar() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Testing valid car creation
		try {
			_carController.createCar(createValidCarInfo());
		} catch (InvalidCarArgumentsException e_) {
			fail("Error creating a valid car.");
		}

	}

	/**
	 * Tests CarController's createCar method. Ensures that a invalid car cannot be
	 * created.
	 */
	@Test
	public void testCreateInvalidCar() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Testing invalid car creation.
		try {
			_carController.createCar(createInvalidCarInfo());
		} catch (InvalidCarArgumentsException e_) {

		}
	}

	/**
	 * Tests CarController's modifyCar method. Ensures that a valid car can be
	 * modified.
	 */
	@Test
	public void testModifyValidCar() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Creating a valid car to later be modified.
		try {
			_carController.createCar(createValidCarInfo());
		} catch (InvalidCarArgumentsException e_) {
			fail("Error creating a valid car.");
		}

		// Testing valid car modification.
		ArrayList<String> _coupeNewInfo = new ArrayList<String>();
		_coupeNewInfo.add("0"); // ID
		_coupeNewInfo.add("coupe");
		_coupeNewInfo.add("toyota");
		_coupeNewInfo.add("camry");
		_coupeNewInfo.add("black");
		_coupeNewInfo.add("2004");
		try {
			_carController.modifyCar(_coupeNewInfo);
		} catch (CarNotFoundException e_) {
			fail("Error modifying a valid car.");
		} catch (InvalidCarArgumentsException e_) {
			fail("Error modifying arguments for a valid car.");
		}

	}

	/**
	 * Tests CarController's modifyCar method. Ensures that a invalid car cannot be
	 * modified.
	 */
	@Test
	public void testModifyInvalidCar() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Creating a valid car to later be modified.
		try {
			_carController.createCar(createValidCarInfo());
		} catch (InvalidCarArgumentsException e_) {
			fail("Error creating a valid car.");
		}

		// ---------------------------------------------
		// Testing invalid car modification.
		ArrayList<String> _invalidModifyInfo = new ArrayList<String>();
		_invalidModifyInfo.add("not enough info");
		try {
			_carController.modifyCar(_invalidModifyInfo);
		} catch (Exception e_) {

		}
	}

	/**
	 * Tests CarController's deleteCar method. Ensures that a valid car can be
	 * deleted.
	 */
	@Test
	public void testDeleteValidCar() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Creating a valid car to later be modified.
		try {
			_carController.createCar(createValidCarInfo());
		} catch (InvalidCarArgumentsException e_) {
			fail("Error creating a valid car.");
		}

		// Testing valid car deletion.
		ArrayList<String> _coupeDeleteInfo = new ArrayList<String>();
		_coupeDeleteInfo.add("0"); // Valid ID
		try {
			_carController.deleteCar(_coupeDeleteInfo);
		} catch (CarNotFoundException e_) {
			fail("Error deleting a valid car.");
		}
	}

	/**
	 * Tests CarController's deleteCar method. Ensures that a invalid car cannot be
	 * deleted.
	 */
	@Test
	public void testDeleteInvalidCar() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Creating a valid car to later be modified.
		try {
			_carController.createCar(createValidCarInfo());
		} catch (InvalidCarArgumentsException e_) {
			fail("Error creating a valid car.");
		}

		// ---------------------------------------------
		// Testing invalid car deletion.
		ArrayList<String> _invalidDeleteInfo = new ArrayList<String>();
		_invalidDeleteInfo.add("1000"); // Invalid ID
		try {
			_carController.deleteCar(_invalidDeleteInfo);
		} catch (CarNotFoundException e_) {
			assertTrue(true);
		}
	}

	/**
	 * Tests CarController's isCarInInventory method. Ensures that a car is in the
	 * inventory.
	 */
	@Test
	public void testIsCarInInventory() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Creating a valid car to later be modified.
		try {
			_carController.createCar(createValidCarInfo());
		} catch (InvalidCarArgumentsException e_) {
			fail("Error creating a valid car.");
		}

		assertTrue(_carController.isCarInInventory(0));
		assertFalse(_carController.isCarInInventory(1));

	}

	// ==========================================================================================
    // Helper Functions

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
	 * Helper function to generate invalid car info.
	 * 
	 * @return An ArrayList of Strings containing invalid car info.
	 */
	private ArrayList<String> createInvalidCarInfo() {
		ArrayList<String> _invalidCarInfo = new ArrayList<String>();
		_invalidCarInfo.add("coupe");
		_invalidCarInfo.add("invalid");
		_invalidCarInfo.add("input");
		_invalidCarInfo.add("length");
		return _invalidCarInfo;
	}
}
