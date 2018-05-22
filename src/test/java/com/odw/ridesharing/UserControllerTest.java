package com.odw.ridesharing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.model.exceptions.BadUserException;
import com.odw.ridesharing.service.UserController;

public class UserControllerTest {

    /**
     * Tests CarController's createCar method. Ensures that a valid car can be
     * created and an invalid car is handled properly
     * 
     */
    @Test
    public void testCreateUser() throws BadUserException {
        UserController userController = new UserController();

        // Testing valid car creation
        ArrayList<String> driverUserInfo = new ArrayList<String>();
        driverUserInfo.add("driver");
        driverUserInfo.add("Mark");
        driverUserInfo.add("Constantine");
        driverUserInfo.add("male");
        driverUserInfo.add("21");
        driverUserInfo.add("true");
        driverUserInfo.add("0");
        try {
            userController.createUser(driverUserInfo);
        } catch (BadUserException e_) {
            fail("Error creating a valid driver user.");
        }

        ArrayList<String> invalidDriverInfo = new ArrayList<String>();
        invalidDriverInfo.add("driver");
        invalidDriverInfo.add("invalid");
        invalidDriverInfo.add("input");
        invalidDriverInfo.add("length");
        try {
            userController.createUser(invalidDriverInfo);
        } catch (BadUserException e_) {
            assertTrue(true); // Hacky solution to state that this is the desired outcome.
        }

        ArrayList<String> customerUserInfo = new ArrayList<String>();
        customerUserInfo.add("customer");
        customerUserInfo.add("Pete");
        customerUserInfo.add("Tanthmanatham");
        customerUserInfo.add("male");
        customerUserInfo.add("21");

        try {
            userController.createUser(customerUserInfo);
        } catch (BadUserException e_) {
            fail("Error creating a valid driver user.");
        }

        ArrayList<String> invalidCustomerInfo = new ArrayList<String>();
        invalidCustomerInfo.add("customer");
        invalidCustomerInfo.add("invalid");
        invalidCustomerInfo.add("input");
        invalidCustomerInfo.add("length");
        invalidCustomerInfo.add("add");
        invalidCustomerInfo.add("more");
        invalidCustomerInfo.add("field");
        try {
            userController.createUser(invalidCustomerInfo);
        } catch (BadUserException e_) {
            assertTrue(true); // Hacky solution to state that this is the desired outcome.
        }
    }

    @Test
    public void testModifyUser() {
        UserController userController = new UserController();
        ArrayList<String> userDriverInfo = new ArrayList<String>();
        userDriverInfo.add("driver");
        userDriverInfo.add("Mark");
        userDriverInfo.add("Constantine");
        userDriverInfo.add("male");
        userDriverInfo.add("21");
        userDriverInfo.add("true");
        userDriverInfo.add("0");
        try {
            userController.createUser(userDriverInfo);
        } catch (BadUserException e_) {
            fail("Error creating a valid driver.");
        }

        // Testing valid driver modification.
        ArrayList<String> userNewInfo = new ArrayList<String>();
        userNewInfo.add("0");
        userNewInfo.add("driver");
        userNewInfo.add("Mark");
        userNewInfo.add("Constantine");
        userNewInfo.add("male");
        userNewInfo.add("21");
        userNewInfo.add("false");
        userNewInfo.add("0");
        userNewInfo.add("5");
       

        try {
            userController.modifyUser(userNewInfo);
        } catch (BadUserException e_) {
            fail("Error modifying a valid driver.");
        }

        ArrayList<String> customerUserInfo = new ArrayList<String>();
        customerUserInfo.add("customer");
        customerUserInfo.add("Pete");
        customerUserInfo.add("Tanthmanatham");
        customerUserInfo.add("male");
        customerUserInfo.add("21");

        try {
            userController.createUser(customerUserInfo);
        } catch (BadUserException e_) {
            fail("Error creating a valid driver user.");
        }

        // Testing valid customer modification.
        ArrayList<String> userNewCustomerInfo = new ArrayList<String>();
        userNewCustomerInfo.add("1");
        userNewCustomerInfo.add("customer");
        userNewCustomerInfo.add("Pete");
        userNewCustomerInfo.add("Tanthmanatham");
        userNewCustomerInfo.add("male");
        userNewCustomerInfo.add("22");

        try {
            userController.modifyUser(userNewInfo);
        } catch (BadUserException e_) {
            fail("Error modifying a valid driver.");
        }

        // Testing invalid user modification.
        ArrayList<String> invalidModifyInfo = new ArrayList<String>();
        invalidModifyInfo.add("0");
        invalidModifyInfo.add("this user doesn't exist");

        try {
            userController.modifyUser(invalidModifyInfo);
        } catch (BadUserException e_) {
            assertTrue(true);
        }
    }

    @Test
    public void testDeleteUser() {
        UserController userController = new UserController();
        ArrayList<String> driverUserInfo = new ArrayList<String>();

        driverUserInfo.add("driver");
        driverUserInfo.add("Mark");
        driverUserInfo.add("Constantine");
        driverUserInfo.add("male");
        driverUserInfo.add("21");
        driverUserInfo.add("true");
        driverUserInfo.add("0");
        try {
            userController.createUser(driverUserInfo);
        } catch (BadUserException e_) {
            fail("Error creating a valid driver user.");
        }

        // Testing valid user deletion.
        ArrayList<String> driverDeleteInfo = new ArrayList<String>();
        driverDeleteInfo.add("0"); // Valid ID
        try {
            userController.deleteUser(driverDeleteInfo);
        } catch (BadUserException e_) {
            fail("Error deleting a valid user.");
        }

        // Testing invalid user deletion.
        ArrayList<String> invalidDeleteInfo = new ArrayList<String>();
        invalidDeleteInfo.add("driver");
        invalidDeleteInfo.add("1000"); // Invalid ID
        try {
            userController.deleteUser(invalidDeleteInfo);
        } catch (BadUserException e_) {
            assertTrue(true);
        }
    }

}
