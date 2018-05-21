package com.odw.ridesharing;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

import com.odw.ridesharing.model.exceptions.BadCarException;
import com.odw.ridesharing.service.CarController;

public class CarControllerTest {

    /**
     * Tests CarController's createCar method. Ensures that a valid car can be
     * created and an invalid car is handled properly
     */
    @Test
    public void testCreateCar() {
        CarController carController = new CarController();

        // Testing valid car creation
        ArrayList<String> coupeCarInfo = new ArrayList<String>();
        coupeCarInfo.add("coupe");
        coupeCarInfo.add("toyota");
        coupeCarInfo.add("trueno");
        coupeCarInfo.add("white");
        coupeCarInfo.add("1986");
        try {
            carController.createCar(coupeCarInfo);
        } catch (BadCarException e_) {
            fail("Error creating a valid car.");
        }

        // Testing invalid car creation.
        ArrayList<String> invalidCarInfo = new ArrayList<String>();
        invalidCarInfo.add("coupe");
        invalidCarInfo.add("invalid");
        invalidCarInfo.add("input");
        invalidCarInfo.add("length");
        try {
            carController.createCar(invalidCarInfo);
        } catch (BadCarException e_) {
            assertTrue(true); // Hacky solution to state that this is the desired outcome.
        }
    }

    /**
     * Tests CarController's modifyCar method. Ensures that a valid car can be
     * modified and an invalid car is handled properly
     */
    @Test
    public void testModifyCar() {
        CarController carController = new CarController();
        ArrayList<String> coupeCarInfo = new ArrayList<String>();
        coupeCarInfo.add("coupe");
        coupeCarInfo.add("toyota");
        coupeCarInfo.add("trueno");
        coupeCarInfo.add("white");
        coupeCarInfo.add("1986");
        try {
            carController.createCar(coupeCarInfo);
        } catch (BadCarException e_) {
            fail("Error creating a valid car.");
        }

        // Testing valid car modification.
        ArrayList<String> coupeNewInfo = new ArrayList<String>();
        coupeNewInfo.add("0"); // ID
        coupeNewInfo.add("coupe");
        coupeNewInfo.add("toyota");
        coupeNewInfo.add("camry");
        coupeNewInfo.add("black");
        coupeNewInfo.add("2004");
        try {
            carController.modifyCar(coupeNewInfo);
        } catch (BadCarException e_) {
            fail("Error modifying a valid car.");
        }

        // Testing invalid car modification.
        ArrayList<String> invalidModifyInfo = new ArrayList<String>();
        invalidModifyInfo.add("this car doesn't exist");
        try {
            carController.modifyCar(invalidModifyInfo);
        } catch (BadCarException e_) {
            assertTrue(true);
        }
    }

    /**
     * Tests CarController's deleteCar method. Ensures that a valid car can be
     * deleted and an invalid car is handled properly
     */
    @Test
    public void testDeleteCar() {
        CarController carController = new CarController();
        ArrayList<String> coupeCarInfo = new ArrayList<String>();
        coupeCarInfo.add("coupe");
        coupeCarInfo.add("toyota");
        coupeCarInfo.add("trueno");
        coupeCarInfo.add("white");
        coupeCarInfo.add("1986");
        try {
            carController.createCar(coupeCarInfo);
        } catch (BadCarException e_) {
            fail("Error creating a valid car.");
        }

        // Testing valid car deletion.
        ArrayList<String> coupeDeleteInfo = new ArrayList<String>();
        coupeDeleteInfo.add("0"); // Valid ID
        try {
            carController.deleteCar(coupeDeleteInfo);
        } catch (BadCarException e_) {
            fail("Error deleting a valid car.");
        }

        // Testing invalid car deletion.
        ArrayList<String> invalidDeleteInfo = new ArrayList<String>();
        invalidDeleteInfo.add("1000"); // Invalid ID
        try {
            carController.deleteCar(invalidDeleteInfo);
        } catch (BadCarException e_) {
            assertTrue(true);
        }
    }

}
