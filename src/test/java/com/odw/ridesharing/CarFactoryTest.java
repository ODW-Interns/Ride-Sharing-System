package com.odw.ridesharing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.Coupe;
import com.odw.ridesharing.model.Sedan;
import com.odw.ridesharing.model.Suv;
import com.odw.ridesharing.model.exceptions.InvalidCarArgumentsException;
import com.odw.ridesharing.service.CarFactory;

public class CarFactoryTest {

    /**
     * Tests CarFactory's createCar method. Ensures that the proper concrete car is
     * being generated. Note that the assumption for this method is that the
     * ArrayList is equal to the predetermined event type values size.
     */
    @Test
    public void testCreateCar() {
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
            Car _coupe = _carFactory.createCar(_coupeCarInfo);
            assertTrue(_coupe instanceof Coupe);
        } catch (InvalidCarArgumentsException e_) {
            fail("Invalid arguments creating a coupe.");
        }

        // ---------------------------------------------
        // Creating a valid sedan.
        ArrayList<String> _sedanCarInfo = new ArrayList<String>();
        _sedanCarInfo.add("sedan");
        _sedanCarInfo.add("ford");
        _sedanCarInfo.add("focus");
        _sedanCarInfo.add("grey");
        _sedanCarInfo.add("2014");
        try {
            Car _sedan = _carFactory.createCar(_sedanCarInfo);
            assertTrue(_sedan instanceof Sedan);
        } catch (InvalidCarArgumentsException e_) {
            fail("Invalid arguments creating a sedan.");
        }

        // ---------------------------------------------
        // Creating a valid suv.
        ArrayList<String> _suvCarInfo = new ArrayList<String>();
        _suvCarInfo.add("suv");
        _suvCarInfo.add("cadillac");
        _suvCarInfo.add("escalade");
        _suvCarInfo.add("black");
        _suvCarInfo.add("2018");
        try {
            Car _suv = _carFactory.createCar(_suvCarInfo);
            assertTrue(_suv instanceof Suv);
        } catch (InvalidCarArgumentsException e_) {
            fail("Invalid arguments creating an SUV.");
        }

        // ---------------------------------------------
        // Creating a invalid car.
        ArrayList<String> _invalidCarInfo = new ArrayList<String>();
        _invalidCarInfo.add("unknown");
        _invalidCarInfo.add("must");
        _invalidCarInfo.add("be");
        _invalidCarInfo.add("length");
        _invalidCarInfo.add("5");
        try {
            Car _unknown = _carFactory.createCar(_invalidCarInfo);
            assertNull(_unknown);
        } catch (InvalidCarArgumentsException e_) {
            fail("Invalid arguments creating a car");
        }
    }

}
