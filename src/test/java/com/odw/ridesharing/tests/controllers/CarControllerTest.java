package com.odw.ridesharing.tests.controllers;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

import com.odw.ridesharing.controllers.CarController;
import com.odw.ridesharing.exceptions.CarNotFoundException;
import com.odw.ridesharing.exceptions.InvalidCarArgumentsException;

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
			fail("Error creating a valid car." + e_.getMessage());
		}

	}

	/**
	 * Tests CarController's createCar method. Ensures that a invalid car cannot be
	 * created when length is invalid.
	 */
	@Test
	public void testCreateInvalidCarLength() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Testing invalid car creation.
		try {
			_carController.createCar(createInvalidCarInfo());
		} catch (InvalidCarArgumentsException e_) {

		}
	}

	/**
	 * Tests CarController's createCar method. Ensures that a invalid car cannot be
	 * created when year is invalid.
	 */
	@Test
	public void testCreateInvalidCarYear() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Testing invalid car creation.
		try {
			ArrayList<String> _invalidCarInfo = createInvalidCarInfo();
			_invalidCarInfo.add("length");
			_carController.createCar(_invalidCarInfo);
		} catch (InvalidCarArgumentsException e_) {

		}
	}

	/**
	 * Tests CarController's createCar method. Ensures that a invalid car cannot be
	 * created when year is invalid.
	 */
	@Test
	public void testCreateInvalidCarType() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Testing invalid car creation.
		try {
			ArrayList<String> _invalidCarInfo = createInvalidCarTypeInfo();
			_carController.createCar(_invalidCarInfo);
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
			fail("Error creating a valid car." + e_.getMessage());
		}

		// Testing valid car modification.
		ArrayList<String> _coupeNewInfo = new ArrayList<String>();
		_coupeNewInfo.add("0"); // ID
		_coupeNewInfo.add("coupe");
		_coupeNewInfo.add("toyota");
		_coupeNewInfo.add("trueno");
		_coupeNewInfo.add("black");
		_coupeNewInfo.add("1986");
		try {
			_carController.modifyCar(_coupeNewInfo);
		} catch (Exception e_) {
			fail(e_.getMessage());
		}

	}

	/**
	 * Tests CarController's modifyCar method. Ensures that a invalid car cannot be
	 * modified when input length is invalid.
	 */
	@Test
	public void testModifyInvalidCarLength() {
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
	 * Tests CarController's modifyCar method. Ensures that a invalid car cannot be
	 * modified when carID is invalid.
	 */
	@Test
	public void testModifyInvalidCarID() {
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
		// Testing CarID does not exist
		ArrayList<String> _coupeNewInfo = new ArrayList<String>();
		_coupeNewInfo.add("6"); // ID
		_coupeNewInfo.add("coupe");
		_coupeNewInfo.add("toyota");
		_coupeNewInfo.add("trueno");
		_coupeNewInfo.add("black");
		_coupeNewInfo.add("1986");

		try {
			_carController.modifyCar(_coupeNewInfo);
		} catch (Exception e_) {

		}

		// ---------------------------------------------
		// Testing CarID is invalid
		_coupeNewInfo.set(0, "5r5");
		try {
			_carController.modifyCar(_coupeNewInfo);
		} catch (Exception e_) {

		}
	}

	/**
	 * Tests CarController's modifyCar method. Ensures that a invalid car cannot be
	 * modified when carType is invalid.
	 */
	@Test
	public void testModifyInvalidCarType() {
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
		_invalidModifyInfo.add("0"); // ID
		_invalidModifyInfo.add("sedan");
		_invalidModifyInfo.add("toyota");
		_invalidModifyInfo.add("trueno");
		_invalidModifyInfo.add("black");
		_invalidModifyInfo.add("1986");
		try {
			_carController.modifyCar(_invalidModifyInfo);
		} catch (Exception e_) {

		}
	}

	/**
	 * Tests CarController's modifyCar method. Ensures that a invalid car cannot be
	 * modified when car make is invalid.
	 */
	@Test
	public void testModifyInvalidCarMake() {
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
		_invalidModifyInfo.add("0"); // ID
		_invalidModifyInfo.add("coupe");
		_invalidModifyInfo.add("nissan");
		_invalidModifyInfo.add("trueno");
		_invalidModifyInfo.add("black");
		_invalidModifyInfo.add("1986");
		try {
			_carController.modifyCar(_invalidModifyInfo);
		} catch (Exception e_) {

		}
	}

	/**
	 * Tests CarController's modifyCar method. Ensures that a invalid car cannot be
	 * modified when car model is invalid.
	 */
	@Test
	public void testModifyInvalidCarModel() {
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
		_invalidModifyInfo.add("0"); // ID
		_invalidModifyInfo.add("coupe");
		_invalidModifyInfo.add("toyota");
		_invalidModifyInfo.add("whatever");
		_invalidModifyInfo.add("black");
		_invalidModifyInfo.add("1986");
		try {
			_carController.modifyCar(_invalidModifyInfo);
		} catch (Exception e_) {

		}
	}

	/**
	 * Tests CarController's modifyCar method. Ensures that a invalid car cannot be
	 * modified when car year is invalid.
	 */
	@Test
	public void testModifyInvalidCarYear() {
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
		// Trying to change car's year
		ArrayList<String> _invalidModifyInfo = new ArrayList<String>();
		_invalidModifyInfo.add("0"); // ID
		_invalidModifyInfo.add("coupe");
		_invalidModifyInfo.add("toyota");
		_invalidModifyInfo.add("trueno");
		_invalidModifyInfo.add("white");
		_invalidModifyInfo.add("1999");
		try {
			_carController.modifyCar(_invalidModifyInfo);
		} catch (Exception e_) {

		}

		// -----------------------------------------------
		// Testing when year is not an integer
		_invalidModifyInfo.set(5, "notaninteger");
		try {
			_carController.modifyCar(_invalidModifyInfo);
		} catch (Exception e_) {

		}
	}

	/**
	 * Tests CarController's deleteCar method. Ensures that a valid car can be
	 * deleted.
	 * 
	 * @throws InvalidCarArgumentsException
	 */
	@Test
	public void testDeleteValidCar() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Creating a valid car to later be modified.
		try {
			_carController.createCar(createValidCarInfo());
		} catch (InvalidCarArgumentsException e_) {
			fail("Error creating a valid car." + e_.getMessage());
		}

		// Testing valid car deletion.
		ArrayList<String> _coupeDeleteInfo = new ArrayList<String>();
		_coupeDeleteInfo.add("0"); // Valid ID
		try {
			_carController.deleteCar(_coupeDeleteInfo);
		} catch (CarNotFoundException e_) {
			fail("Error deleting a valid car." + e_.getMessage());
		} catch (InvalidCarArgumentsException e_) {
			fail("Error deleting a valid car." + e_.getMessage());
		}
	}

	/**
	 * Tests CarController's deleteCar method. Ensures that a invalid car cannot be
	 * deleted when input length is invalid
	 */
	@Test
	public void testDeleteInvalidCarLength() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Creating a valid car to later be modified.
		try {
			_carController.createCar(createValidCarInfo());
		} catch (InvalidCarArgumentsException e_) {
			fail("Error creating a valid car." + e_.getMessage());
		}

		// ---------------------------------------------
		// Testing invalid car deletion.
		ArrayList<String> _invalidDeleteInfo = new ArrayList<String>();
		_invalidDeleteInfo.add("wrong"); // Invalid ID
		_invalidDeleteInfo.add("length"); // Invalid ID
		try {
			_carController.deleteCar(_invalidDeleteInfo);
		} catch (CarNotFoundException e_) {

		} catch (InvalidCarArgumentsException e_) {

		}

	}

	/**
	 * Tests CarController's deleteCar method. Ensures that a invalid car cannot be
	 * deleted when CarId is invalid.
	 */
	@Test
	public void testDeleteInvalidCarID() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Creating a valid car to later be modified.
		try {
			_carController.createCar(createValidCarInfo());
		} catch (InvalidCarArgumentsException e_) {
			fail("Error creating a valid car." + e_.getMessage());
		}

		// ---------------------------------------------
		// Testing invalid car deletion.
		// Testing CarId does not exist.
		ArrayList<String> _invalidDeleteInfo = new ArrayList<String>();
		_invalidDeleteInfo.add("1000"); // Invalid ID
		try {
			_carController.deleteCar(_invalidDeleteInfo);
		} catch (CarNotFoundException e_) {

		} catch (InvalidCarArgumentsException e_) {

		}

		// ---------------------------------------------
		// Testing invalid car deletion.
		// Testing Invalid carID.
		_invalidDeleteInfo.set(0, "string"); // Invalid ID
		try {
			_carController.deleteCar(_invalidDeleteInfo);
		} catch (CarNotFoundException e_) {

		} catch (InvalidCarArgumentsException e_) {

		}
	}

	/**
	 * Tests CarController's isCarInDatabase method. Ensures that a car is in the
	 * database.
	 */
	@Test
	public void testIsCarInDatabase() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Creating a valid car to later be modified.
		try {
			_carController.createCar(createValidCarInfo());
		} catch (InvalidCarArgumentsException e_) {
			fail("Error creating a valid car.");
		}

		assertTrue(_carController.isCarInDatabase(0));
		assertFalse(_carController.isCarInDatabase(1));

	}

	/**
	 * Test CarController's GetCardDatabaseAsString method. Ensures that all car in
	 * the database get printed.
	 */
	@Test
	public void testGetCarDatabaseAsString() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Creating car to be printed.
		try {
			_carController.createCar(createValidCarInfo());

		} catch (InvalidCarArgumentsException e_) {
			fail("Error creating a valid car.");
		}

		_carController.getCarDatabaseAsString();

	}

	/**
	 * Test CarController's GetCardDatabaseAsString method. Ensures that when
	 * database is empty, the empty string is returned.
	 */
	@Test
	public void testGetCarDatabaseAsEmptyString() {
		CarController _carController = new CarController();

		// ---------------------------------------------
		// Test printing the database when it is empty
		_carController.getCarDatabaseAsString();

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
		_invalidCarInfo.add("BMW");
		_invalidCarInfo.add("Z4");
		_invalidCarInfo.add("black");
		return _invalidCarInfo;
	}

	/**
	 * Helper function to generate invalid carType info.
	 * 
	 * @return An ArrayList of Strings containing invalid car info.
	 */
	private ArrayList<String> createInvalidCarTypeInfo() {
		ArrayList<String> _invalidCarInfo = new ArrayList<String>();
		_invalidCarInfo.add("coupee");
		_invalidCarInfo.add("invalid");
		_invalidCarInfo.add("input");
		_invalidCarInfo.add("and");
		_invalidCarInfo.add("more");
		return _invalidCarInfo;
	}
}
