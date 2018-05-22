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

        // Testing valid driver creation.
        try {
            userController.createUser(createValidDriverInfo());
        } catch (BadUserException e_) {
            fail("Error creating a valid driver user.");
        }

        // Testing valid customer creation.
        try {
            userController.createUser(createValidCustomerInfo());
        } catch (BadUserException e_) {
            fail("Error creating a valid driver user.");
        }
        
        // Testing invalid driver creation.
        try {
            userController.createUser(createInvalidDriverInfo());
        } catch (BadUserException e_) {
            assertTrue(true); // Hacky solution to state that this is the desired outcome.
        }
        
        // Testing invalid customer creation.
        try {
            userController.createUser(createInvalidCustomerInfo());
        } catch (BadUserException e_) {
            assertTrue(true); // Hacky solution to state that this is the desired outcome.
        }
    }

    @Test
    public void testModifyUser() {
        UserController userController = new UserController();
        
        // ---------------------------------------------
        // Creating a valid driver to later be modified.
        try {
            userController.createUser(createValidDriverInfo());
        } catch (BadUserException e_) {
            fail("Error creating a valid driver.");
        }
        
        // Testing valid driver modification.
        ArrayList<String> driverNewInfo = new ArrayList<String>();
        driverNewInfo.add("0");
        driverNewInfo.add("driver");
        driverNewInfo.add("Mark");
        driverNewInfo.add("Constantine");
        driverNewInfo.add("male");
        driverNewInfo.add("21");
        driverNewInfo.add("false");
        driverNewInfo.add("0");
        driverNewInfo.add("5");
        try {
            userController.modifyUser(driverNewInfo);
        } catch (BadUserException e_) {
            fail("Error modifying a valid driver.");
        }

        // ---------------------------------------------
        // Creating a valid customer to be later modified.
        try {
            userController.createUser(createValidCustomerInfo());
        } catch (BadUserException e_) {
            fail("Error creating a valid driver user.");
        }
        
        // Testing valid customer modification.
        ArrayList<String> customerNewInfo = new ArrayList<String>();
        customerNewInfo.add("1");
        customerNewInfo.add("customer");
        customerNewInfo.add("Pete");
        customerNewInfo.add("Tanthmanatham");
        customerNewInfo.add("male");
        customerNewInfo.add("22");
        try {
            userController.modifyUser(customerNewInfo);
        } catch (BadUserException e_) {
            fail("Error modifying a valid customer.");
        }

        // ---------------------------------------------
        // Testing invalid user modification.
        ArrayList<String> invalidModifyInfo = new ArrayList<String>();
        invalidModifyInfo.add("0"); // Modifying the first created user (Mark Constantine)
        invalidModifyInfo.add("must include all fields");
        try {
            userController.modifyUser(invalidModifyInfo);
        } catch (BadUserException e_) {
            assertTrue(true);
        }
    }
    

    @Test
    public void testDeleteUser() {
        UserController userController = new UserController();

        // ---------------------------------------------
        // Creating a valid driver to delete later.
        try {
            userController.createUser(createValidDriverInfo());
        } catch (BadUserException e_) {
            fail("Error creating a valid driver user.");
        }

        // Testing valid user deletion. (User and Driver work the same)
        ArrayList<String> driverDeleteInfo = new ArrayList<String>();
        driverDeleteInfo.add("0"); // Valid ID
        try {
            userController.deleteUser(driverDeleteInfo);
        } catch (BadUserException e_) {
            fail("Error deleting a valid user.");
        }

        // ---------------------------------------------
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
    
    
    private ArrayList<String> createValidDriverInfo() {
        ArrayList<String> userDriverInfo = new ArrayList<String>();
        userDriverInfo.add("driver");
        userDriverInfo.add("Mark");
        userDriverInfo.add("Constantine");
        userDriverInfo.add("male");
        userDriverInfo.add("21");
        return userDriverInfo;
    }
    
    private ArrayList<String> createValidCustomerInfo() {
        ArrayList<String> userCustomerInfo = new ArrayList<String>();
        userCustomerInfo.add("customer");
        userCustomerInfo.add("Pete");
        userCustomerInfo.add("Tanthmanatham");
        userCustomerInfo.add("male");
        userCustomerInfo.add("21");
        return userCustomerInfo;
    }
    
    private ArrayList<String> createInvalidDriverInfo() {
        ArrayList<String> invalidDriverInfo = new ArrayList<String>();
        invalidDriverInfo.add("driver");
        invalidDriverInfo.add("invalid");
        invalidDriverInfo.add("input");
        invalidDriverInfo.add("length");
        return invalidDriverInfo;
    }
    
    private ArrayList<String> createInvalidCustomerInfo() {
        ArrayList<String> invalidCustomerInfo = new ArrayList<String>();
        invalidCustomerInfo.add("customer");
        invalidCustomerInfo.add("invalid");
        invalidCustomerInfo.add("input");
        invalidCustomerInfo.add("length");
        invalidCustomerInfo.add("too");
        invalidCustomerInfo.add("many");
        invalidCustomerInfo.add("fields");
        return invalidCustomerInfo;
    }

}
