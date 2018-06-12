package com.odw.ridesharing.tests.factories;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.exceptions.InvalidCarArgumentsException;
import com.odw.ridesharing.factories.CarFactory;
import com.odw.ridesharing.model.CarType;
import com.odw.ridesharing.model.Coupe;
import com.odw.ridesharing.model.Sedan;
import com.odw.ridesharing.model.Suv;
import com.odw.ridesharing.model.abstractmodel.AbstractCar;

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
			
			CarType _carType = CarType.valueOf((_coupeCarInfo.get(0).toUpperCase()));
			String _make = _coupeCarInfo.get(1);
			String _model = _coupeCarInfo.get(2);
			String _color = _coupeCarInfo.get(3);
			int _year = Integer.parseInt(_coupeCarInfo.get(4));

			AbstractCar _coupe = _carFactory.buildCar(_carType, _make, _model, _color, _year);
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
			
			CarType _carType = CarType.valueOf((_sedanCarInfo.get(0).toUpperCase()));
			String _make = _sedanCarInfo.get(1);
			String _model = _sedanCarInfo.get(2);
			String _color = _sedanCarInfo.get(3);
			int _year = Integer.parseInt(_sedanCarInfo.get(4));
			
			AbstractCar _sedan = _carFactory.buildCar(_carType, _make, _model, _color, _year);
			assertTrue(_sedan instanceof Sedan);
		} catch (InvalidCarArgumentsException e_) {
			fail("Invalid arguments creating a sedan.");
		}
	}

	/**
	 * Tests CarFactory's createCar method. Ensures that the valid suv car is being
	 * generated.
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
			
			CarType _carType = CarType.valueOf((_suvCarInfo.get(0).toUpperCase()));
			String _make = _suvCarInfo.get(1);
			String _model = _suvCarInfo.get(2);
			String _color = _suvCarInfo.get(3);
			int _year = Integer.parseInt(_suvCarInfo.get(4));
			
			AbstractCar _suv = _carFactory.buildCar(_carType, _make, _model, _color, _year);
			assertTrue(_suv instanceof Suv);
		} catch (InvalidCarArgumentsException e_) {
			fail("Invalid arguments creating an SUV.");
		}
	}

	/**
	 * Tests CarFactory's createCar method. Ensures that the invalid car is not
	 * being generated.
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
			
			CarType _carType = CarType.valueOf((_invalidCarInfo.get(0).toUpperCase()));
			String _make = _invalidCarInfo.get(1);
			String _model = _invalidCarInfo.get(2);
			String _color = _invalidCarInfo.get(3);
			int _year = Integer.parseInt(_invalidCarInfo.get(4));
			
			AbstractCar _unknown = _carFactory.buildCar(_carType, _make, _model, _color, _year);
			assertNull(_unknown);
		} catch (InvalidCarArgumentsException e_) {

		} catch (IllegalArgumentException e_) {
			
		}
	}

}
