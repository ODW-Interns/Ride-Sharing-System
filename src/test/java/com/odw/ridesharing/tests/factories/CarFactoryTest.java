package com.odw.ridesharing.tests.factories;

import static org.junit.Assert.*;

import org.junit.Test;
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

		CarType _carType = CarType.valueOf("coupe".toUpperCase());
		String _make = "toyota";
		String _model = "trueno";
		String _color = "white";
		int _year = 1986;

		// ---------------------------------------------
		// Creating a valid coupe.

		try {
			AbstractCar _coupe = _carFactory.buildCar(_carType, _make, _model, _color, _year);
			assertTrue(_coupe instanceof Coupe);
		} catch (Exception e_) {
			fail("Failed to create a valid Coupe.");
		}
	}

	/**
	 * Tests CarFactory's createCar method. Ensures that the valid sedan car is
	 * being generated.
	 */
	@Test
	public void testCreateValidSedanCar() {
		CarFactory _carFactory = new CarFactory();

		CarType _carType = CarType.valueOf("sedan".toUpperCase());
		String _make = "ford";
		String _model = "focus";
		String _color = "grey";
		int _year = 2014;

		// ---------------------------------------------
		// Creating a valid sedan.
		try {
			AbstractCar _sedan = _carFactory.buildCar(_carType, _make, _model, _color, _year);
			assertTrue(_sedan instanceof Sedan);
		} catch (Exception e_) {
			fail("Failed to create a valid Sedan.");
		}
	}

	/**
	 * Tests CarFactory's createCar method. Ensures that the valid Suv car is being
	 * generated.
	 */
	@Test
	public void testCreateValidSuvCar() {
		CarFactory _carFactory = new CarFactory();

		CarType _carType = CarType.valueOf(("suv".toUpperCase()));
		String _make = "cadillac";
		String _model = "escalade";
		String _color = "black";
		int _year = 2018;

		// ---------------------------------------------
		// Creating a valid Suv.
		try {
			AbstractCar _suv = _carFactory.buildCar(_carType, _make, _model, _color, _year);
			assertTrue(_suv instanceof Suv);
		} catch (Exception e_) {
			fail("Failed to create a valid SUV.");
		}
	}

	/**
	 * Tests CarFactory's createCar method. Ensures that the invalid car is not
	 * being generated when CarType is invalid.
	 */
	@Test
	public void testCreateInvalidCarType() {
		CarFactory _carFactory = new CarFactory();

		String _make = "invalid_make";
		String _model = "invalid_model";
		String _color = "invalid_color";
		int _year = -1;

		// ---------------------------------------------
		// Creating a invalid car.
		try {
			CarType _carType = CarType.valueOf(("unknown_type".toUpperCase()));
			@SuppressWarnings("unused")
			AbstractCar _unknown = _carFactory.buildCar(_carType, _make, _model, _color, _year);

			fail("Successfully created an invalid car (should not work).");
		} catch (Exception expected_) {
		}
	}

	/**
	 * Tests CarFactory's createCar method. Ensures that the invalid car is not
	 * being generated when make is empty.
	 */
	@Test
	public void testCreateEmptyCarMake() {
		CarFactory _carFactory = new CarFactory();

		CarType _carType = CarType.valueOf(("coupe".toUpperCase()));
		String _make = "";
		String _model = "invalid_model";
		String _color = "invalid_color";
		int _year = 1990;

		// ---------------------------------------------
		// Creating an empty make car.
		try {
			@SuppressWarnings("unused")
			AbstractCar _unknown = _carFactory.buildCar(_carType, _make, _model, _color, _year);

			fail("Successfully created an invalid car (should not work).");
		} catch (Exception expected_) {
		}

		// ---------------------------------------------
		// Creating a null make car.
		try {
			@SuppressWarnings("unused")
			AbstractCar _unknown = _carFactory.buildCar(_carType, null, _model, _color, _year);

			fail("Successfully created an invalid car (should not work).");
		} catch (Exception expected_) {
		}
	}

	/**
	 * Tests CarFactory's createCar method. Ensures that the invalid car is not
	 * being generated when make is null.
	 */
	@Test
	public void testCreateNullCarMake() {
		CarFactory _carFactory = new CarFactory();

		CarType _carType = CarType.valueOf(("coupe".toUpperCase()));
		String _make = null;
		String _model = "invalid_model";
		String _color = "invalid_color";
		int _year = 1990;

		// ---------------------------------------------
		// Creating a null make car.
		try {
			@SuppressWarnings("unused")
			AbstractCar _unknown = _carFactory.buildCar(_carType, _make, _model, _color, _year);

			fail("Successfully created an invalid car (should not work).");
		} catch (Exception expected_) {
		}
	}

	/**
	 * Tests CarFactory's createCar method. Ensures that the invalid car is not
	 * being generated when model is empty.
	 */
	@Test
	public void testCreateEmptyCarModel() {
		CarFactory _carFactory = new CarFactory();

		CarType _carType = CarType.valueOf(("coupe".toUpperCase()));
		String _make = "BMW";
		String _model = "";
		String _color = "invalid_color";
		int _year = 1999;

		// ---------------------------------------------
		// Creating an empty model car.
		try {
			@SuppressWarnings("unused")
			AbstractCar _unknown = _carFactory.buildCar(_carType, _make, _model, _color, _year);

			fail("Successfully created an invalid car (should not work).");
		} catch (Exception expected_) {
		}

	}

	/**
	 * Tests CarFactory's createCar method. Ensures that the invalid car is not
	 * being generated when model is null.
	 */
	@Test
	public void testCreateNullCarModel() {
		CarFactory _carFactory = new CarFactory();

		CarType _carType = CarType.valueOf(("coupe".toUpperCase()));
		String _make = "BMW";
		String _model = null;
		String _color = "invalid_color";
		int _year = 1999;

		// ---------------------------------------------
		// Creating an null model car.
		try {
			@SuppressWarnings("unused")
			AbstractCar _unknown = _carFactory.buildCar(_carType, _make, _model, _color, _year);

			fail("Successfully created an invalid car (should not work).");
		} catch (Exception expected_) {
		}

	}

	/**
	 * Tests CarFactory's createCar method. Ensures that the invalid car is not
	 * being generated when color is empty.
	 */
	@Test
	public void testCreateEmptyCarColor() {
		CarFactory _carFactory = new CarFactory();

		CarType _carType = CarType.valueOf(("coupe".toUpperCase()));
		String _make = "BMW";
		String _model = "Z4";
		String _color = "";
		int _year = 1990;

		// ---------------------------------------------
		// Creating an empty color car.
		try {
			@SuppressWarnings("unused")
			AbstractCar _unknown = _carFactory.buildCar(_carType, _make, _model, _color, _year);

			fail("Successfully created an invalid car (should not work).");
		} catch (Exception expected_) {

		}
	}

	/**
	 * Tests CarFactory's createCar method. Ensures that the invalid car is not
	 * being generated when color is null.
	 */
	@Test
	public void testCreateNullCarColor() {
		CarFactory _carFactory = new CarFactory();

		CarType _carType = CarType.valueOf(("coupe".toUpperCase()));
		String _make = "BMW";
		String _model = "Z4";
		String _color = null;
		int _year = 1990;

		// ---------------------------------------------
		// Creating an empty color car.
		try {
			@SuppressWarnings("unused")
			AbstractCar _unknown = _carFactory.buildCar(_carType, _make, _model, _color, _year);

			fail("Successfully created an invalid car (should not work).");
		} catch (Exception expected_) {

		}
	}

	/**
	 * Tests CarFactory's createCar method. Ensures that the invalid car is not
	 * being generated when year is in the future.
	 */
	@Test
	public void testCreateFutureCarYear() {
		CarFactory _carFactory = new CarFactory();

		CarType _carType = CarType.valueOf(("coupe".toUpperCase()));
		String _make = "BMW";
		String _model = "Z4";
		String _color = "black";
		int _year = 19900;

		// ---------------------------------------------
		// Creating a future year.
		try {
			@SuppressWarnings("unused")
			AbstractCar _unknown = _carFactory.buildCar(_carType, _make, _model, _color, _year);
			fail("Successfully created an invalid car (should not work).");
		} catch (Exception expected_) {

		}

	}

	/**
	 * Tests CarFactory's createCar method. Ensures that the invalid car is not
	 * being generated when year is in the past before car is invented.
	 */
	@Test
	public void testCreatePastCarYear() {
		CarFactory _carFactory = new CarFactory();

		CarType _carType = CarType.valueOf(("coupe".toUpperCase()));
		String _make = "BMW";
		String _model = "Z4";
		String _color = "black";
		int _year = 1800;

		// ---------------------------------------------
		// Creating past year.

		try {
			@SuppressWarnings("unused")
			AbstractCar _unknown = _carFactory.buildCar(_carType, _make, _model, _color, _year);
			fail("Successfully created an invalid car (should not work).");
		} catch (Exception expected_) {

		}
	}
}
