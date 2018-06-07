package com.odw.ridesharing.tests.factories;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.factories.CarFactory;
import com.odw.ridesharing.model.Coupe;
import com.odw.ridesharing.model.Sedan;
import com.odw.ridesharing.model.Suv;
import com.odw.ridesharing.model.abstractmodel.AbstractCar;
import com.odw.ridesharing.model.exceptions.InvalidCarArgumentsException;

/**
 * Tests all the public methods inside CarFactory.
 */
public class CarFactoryTest {

	/**
	 * Tests CarFactory's createCar method. Ensures that the coupe car is being
	 * generated.
	 */
	@Test
	public void testCreateValidCoupeCar() {
		CarFactory _carFactory = new CarFactory();

		// ---------------------------------------------
		// Creating a valid coupe.
		ArrayList<String> _coupeCarInfo = new ArrayList<String>();
		_coupeCarInfo.add("coupe");
		_coupeCarInfo.add("toyota");
		_coupeCarInfo.add("trueno");
		_coupeCarInfo.add("white");
		_coupeCarInfo.add("1986");
		try {
			AbstractCar _coupe = _carFactory.buildCar(_coupeCarInfo);
			assertTrue(_coupe instanceof Coupe);
		} catch (InvalidCarArgumentsException e_) {
			fail("Invalid arguments creating a coupe.");
		}
	}

	/**
	 * Tests CarFactory's createCar method. Ensures that the valid sedan car is
	 * being generated.
	 */
	@Test
	public void testCreateValidSedanCar() {
		CarFactory _carFactory = new CarFactory();

		// ---------------------------------------------
		// Creating a valid sedan.
		ArrayList<String> _sedanCarInfo = new ArrayList<String>();
		_sedanCarInfo.add("sedan");
		_sedanCarInfo.add("ford");
		_sedanCarInfo.add("focus");
		_sedanCarInfo.add("grey");
		_sedanCarInfo.add("2014");
		try {
			AbstractCar _sedan = _carFactory.buildCar(_sedanCarInfo);
			assertTrue(_sedan instanceof Sedan);
		} catch (InvalidCarArgumentsException e_) {
			fail("Invalid arguments creating a sedan.");
		}
	}
	
	/**
	 * Tests CarFactory's createCar method. Ensures that the valid suv car is
	 * being generated.
	 */
	@Test
	public void testCreateValidSuvCar() {
		CarFactory _carFactory = new CarFactory();
	
		// ---------------------------------------------
		// Creating a valid suv.
		ArrayList<String> _suvCarInfo = new ArrayList<String>();
		_suvCarInfo.add("suv");
		_suvCarInfo.add("cadillac");
		_suvCarInfo.add("escalade");
		_suvCarInfo.add("black");
		_suvCarInfo.add("2018");
		try {
			AbstractCar _suv = _carFactory.buildCar(_suvCarInfo);
			assertTrue(_suv instanceof Suv);
		} catch (InvalidCarArgumentsException e_) {
			fail("Invalid arguments creating an SUV.");
		}
	}
	/**
	 * Tests CarFactory's createCar method. Ensures that the invalid car is
	 * not being generated.
	 */
	@Test
	public void testCreateInvalidCar() {
		CarFactory _carFactory = new CarFactory();

		// ---------------------------------------------
		// Creating a invalid car.
		ArrayList<String> _invalidCarInfo = new ArrayList<String>();
		_invalidCarInfo.add("unknown");
		_invalidCarInfo.add("must");
		_invalidCarInfo.add("be");
		_invalidCarInfo.add("length");
		_invalidCarInfo.add("5");
		try {
			AbstractCar _unknown = _carFactory.buildCar(_invalidCarInfo);
			assertNull(_unknown);
		} catch (InvalidCarArgumentsException e_) {

		}
	}

}
