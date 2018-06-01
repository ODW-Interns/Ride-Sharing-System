package com.odw.ridesharing.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.model.exceptions.CustomerNotFoundException;
import com.odw.ridesharing.model.exceptions.DriverNotFoundException;
import com.odw.ridesharing.model.exceptions.UserNotFoundException;
import com.odw.ridesharing.model.exceptions.InvalidUserArgumentsException;
import com.odw.ridesharing.service.UserController;

/**
 * Tests all the public methods inside UserController.
 */
public class UserControllerTest {

    /**
     * Tests UserController's createUser method. Ensures that a valid customer and
     * driver can be created and an invalid user is handled properly.
     */
    @Test
    public void testCreateUser() {
        UserController _userController = new UserController();

        // Testing valid driver creation.
        try {
            _userController.createUser(createValidDriverInfo());
        } catch (InvalidUserArgumentsException e_) {
            fail("Error creating a valid driver user.");
        }

        // Testing valid customer creation.
        try {
            _userController.createUser(createValidCustomerInfo());
        } catch (InvalidUserArgumentsException e_) {
            fail("Error creating a valid driver user.");
        }

        // Testing invalid driver creation.
        try {
            _userController.createUser(createInvalidDriverInfo());
        } catch (InvalidUserArgumentsException e_) {
            assertTrue(true); // Hacky solution to state that this is the desired outcome.
        }

        // Testing invalid customer creation.
        try {
            _userController.createUser(createInvalidCustomerInfo());
        } catch (InvalidUserArgumentsException e_) {
            assertTrue(true); // Hacky solution to state that this is the desired outcome.
        }
    }

    /**
     * Tests UserController's modifyUser method. Ensures that a valid customer and
     * driver can be modified and an invalid user is handled properly.
     */
    @Test
    public void testModifyUser() {
        UserController _userController = new UserController();

        // ---------------------------------------------
        // Creating a valid driver to later be modified.
        try {
            _userController.createUser(createValidDriverInfo());
        } catch (InvalidUserArgumentsException e_) {
            fail("Error creating a valid driver.");
        }

        // Testing valid driver modification.
        ArrayList<String> _driverNewInfo = new ArrayList<String>();
        _driverNewInfo.add("0");
        _driverNewInfo.add("driver");
        _driverNewInfo.add("Mark");
        _driverNewInfo.add("Constantine");
        _driverNewInfo.add("male");
        _driverNewInfo.add("21");
        _driverNewInfo.add("false");
        _driverNewInfo.add("5");
        try {
            _userController.modifyUser(_driverNewInfo);
        } catch (Exception e_) {
            fail("Error modifying a valid driver.");
        }

        // ---------------------------------------------
        // Creating a valid customer to be later modified.
        try {
            _userController.createUser(createValidCustomerInfo());
        } catch (InvalidUserArgumentsException e_) {
            fail("Error creating a valid driver user.");
        }

        // Testing valid customer modification.
        ArrayList<String> _customerNewInfo = new ArrayList<String>();
        _customerNewInfo.add("1");
        _customerNewInfo.add("customer");
        _customerNewInfo.add("Pete");
        _customerNewInfo.add("Tanthmanatham");
        _customerNewInfo.add("male");
        _customerNewInfo.add("22");
        try {
            _userController.modifyUser(_customerNewInfo);
        } catch (DriverNotFoundException e_) {
            fail("Error modifying a valid customer.");
        } catch (CustomerNotFoundException e_) {
            fail("Error modifying a valid customer.");
        } catch (InvalidUserArgumentsException e_) {
            fail("Error modifying a valid customer.");
        }

        // ---------------------------------------------
        // Testing invalid user modification.
        ArrayList<String> _invalidModifyInfo = new ArrayList<String>();
        _invalidModifyInfo.add("0"); // Modifying the first created user (Mark Constantine)
        _invalidModifyInfo.add("must include all fields");
        try {
            _userController.modifyUser(_invalidModifyInfo);
        } catch (DriverNotFoundException e_) {
            assertTrue(true);
        } catch (CustomerNotFoundException e_) {
            assertTrue(true);
        } catch (InvalidUserArgumentsException e_) {
            assertTrue(true);
        }

    }

    /**
     * Tests UserController's deleteUser method. Ensures that a valid user can be
     * deleted and an invalid user is handled properly.
     */
    @Test
    public void testDeleteUser() {
        UserController _userController = new UserController();

        // ---------------------------------------------
        // Creating a valid driver to delete later.
        try {
            _userController.createUser(createValidDriverInfo());
        } catch (InvalidUserArgumentsException e_) {
            fail("Error creating a valid driver user.");
        }

        // Testing valid user deletion. (User and Driver work the same)
        ArrayList<String> _driverDeleteInfo = new ArrayList<String>();
        _driverDeleteInfo.add("0"); // Valid ID
        try {
            _userController.deleteUser(_driverDeleteInfo);
        } catch (UserNotFoundException e_) {
            fail("Error deleting a valid user.");
        }

        // ---------------------------------------------
        // Testing invalid user deletion.
        ArrayList<String> _invalidDeleteInfo = new ArrayList<String>();
        _invalidDeleteInfo.add("driver");
        _invalidDeleteInfo.add("1000"); // Invalid ID
        try {
            _userController.deleteUser(_invalidDeleteInfo);
        } catch (UserNotFoundException e_) {
            assertTrue(true);
        }
    }

    /**
     * Helper function to generate valid driver info.
     * 
     * @return An ArrayList of Strings containing valid driver info.
     */
    private ArrayList<String> createValidDriverInfo() {
        ArrayList<String> _userDriverInfo = new ArrayList<String>();
        _userDriverInfo.add("driver");
        _userDriverInfo.add("Mark");
        _userDriverInfo.add("Constantine");
        _userDriverInfo.add("male");
        _userDriverInfo.add("21");
        return _userDriverInfo;
    }

    /**
     * Helper function to generate valid customer info.
     * 
     * @return An ArrayList of Strings containing valid customer info.
     */
    private ArrayList<String> createValidCustomerInfo() {
        ArrayList<String> _userCustomerInfo = new ArrayList<String>();
        _userCustomerInfo.add("customer");
        _userCustomerInfo.add("Pete");
        _userCustomerInfo.add("Tanthmanatham");
        _userCustomerInfo.add("male");
        _userCustomerInfo.add("21");
        return _userCustomerInfo;
    }

    /**
     * Helper function to generate invalid driver info.
     * 
     * @return An ArrayList of Strings containing invalid driver info.
     */
    private ArrayList<String> createInvalidDriverInfo() {
        ArrayList<String> _invalidDriverInfo = new ArrayList<String>();
        _invalidDriverInfo.add("driver");
        _invalidDriverInfo.add("invalid");
        _invalidDriverInfo.add("input");
        _invalidDriverInfo.add("length");
        return _invalidDriverInfo;
    }

    /**
     * Helper function to generate invalid customer info.
     * 
     * @return An ArrayList of Strings containing invalid customer info.
     */
    private ArrayList<String> createInvalidCustomerInfo() {
        ArrayList<String> _invalidCustomerInfo = new ArrayList<String>();
        _invalidCustomerInfo.add("customer");
        _invalidCustomerInfo.add("invalid");
        _invalidCustomerInfo.add("input");
        _invalidCustomerInfo.add("length");
        _invalidCustomerInfo.add("too");
        _invalidCustomerInfo.add("many");
        _invalidCustomerInfo.add("fields");
        return _invalidCustomerInfo;
    }

}
