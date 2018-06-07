package com.odw.ridesharing.tests.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.controllers.PickupController;
import com.odw.ridesharing.controllers.UserController;
import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.Pickup;

/**
 * Tests all the public methods inside PickupController.
 */
public class PickupControllerTest {

    /**
     * Tests PickupController's createPickup method. Ensures that a valid pickup can
     * be created
     */
    @Test
    public void testCreatePickup() {
        UserController _userController = new UserController();
        PickupController _pickupController = new PickupController();
        Customer _customer = new Customer();

        // Creating a valid customer for the pickup.
        try {
            _customer = (Customer) (_userController.createUser(createValidCustomerInfo()));
            _pickupController.createPickup(createValidPickupInfo(), _customer);
        } catch (Exception e_) {
            fail("Error creating a valid pickup.");
        }
    }

    /**
     * Tests createPickup with bad information to see if it fails
     */
    @Test
    public void testCreatePickupFailsIfInvalidPickupInfo() {
        UserController _userController = new UserController();
        PickupController _pickupController = new PickupController();
        Customer _customer = new Customer();

        try {
            _customer = (Customer) _userController.createUser(createValidCustomerInfo());
            _pickupController.createPickup(createInvalidPickupInfo(), _customer);

            fail("Should fail due to incorrect Pickup info.");
        } catch (Exception e_) {
            // Execution should catch
        }
    }

    /**
     * Tests the deletePickup method
     */
    @Test
    public void testDeletePickup() {
        UserController _userController = new UserController();
        PickupController _pickupController = new PickupController();
        Customer _customer = new Customer();
        ArrayList<String> _pickupList = new ArrayList<>();
        _pickupList.add(Integer.toString(0));

        try {
            _customer = (Customer) (_userController.createUser(createValidCustomerInfo()));
            _pickupController.createPickup(createValidPickupInfo(), _customer);

            _pickupController.deletePickup(_pickupList);
        } catch (Exception e_) {
            fail("Error deleting a valid pickup.");
        }
    }

    /**
     * Tests the schedulePickup method
     */
    @Test
    public void testSchedulePickup() {
        UserController _userController = new UserController();
        PickupController _pickupController = new PickupController();
        Customer _customer = new Customer();
        Driver _driver = new Driver();
        Pickup _pickup = new Pickup();

        try {
            _customer = (Customer) (_userController.createUser(createValidCustomerInfo()));
            _driver = (Driver) (_userController.createUser(createValidDriverInfo()));
            _pickup = _pickupController.createPickup(createValidPickupInfo(), _customer);

            _pickupController.schedulePickup(_pickup, _driver);
        } catch (Exception e_) {
            fail("Error scheduling a pickup.");
        }
    }

    /**
     * Tests the scheduleUnscheduledPickup method
     */
    @Test
    public void testScheduleUnscheduledPickup() {
        UserController _userController = new UserController();
        PickupController _pickupController = new PickupController();
        Customer _customer = new Customer();
        Driver _driver = new Driver();
        Pickup _pickup = new Pickup();

        try {

            _customer = (Customer) (_userController.createUser(createValidCustomerInfo()));
            _pickup = _pickupController.createPickup(createValidPickupInfo(), _customer);
            // pass null driver so it goes into unscheduled queue
            _pickupController.schedulePickup(_pickup, null);
            _driver = (Driver) (_userController.createUser(createValidDriverInfo()));
            _driver.setIsAvailable(true);

            _pickupController.scheduleUnscheduledPickup(_driver);
        } catch (Exception e_) {
            fail("Error scheduling an unscheduled pickup.");
        }
    }

    /**
     * Helper function to generate valid car info.
     * 
     * @return An ArrayList of Strings containing valid car info.
     * 
     *         private ArrayList<String> createValidCarInfo() { ArrayList<String>
     *         _validCarInfo = new ArrayList<String>(); _validCarInfo.add("coupe");
     *         _validCarInfo.add("toyota"); _validCarInfo.add("trueno");
     *         _validCarInfo.add("white"); _validCarInfo.add("1986"); return
     *         _validCarInfo; }
     */

    /**
     * Helper function to generate valid driver info.
     * 
     * @return An ArrayList of Strings containing valid driver info.
     */
    private ArrayList<String> createValidDriverInfo() {
        ArrayList<String> _validDriverInfo = new ArrayList<String>();
        _validDriverInfo.add("driver");
        _validDriverInfo.add("Mark");
        _validDriverInfo.add("Constantine");
        _validDriverInfo.add("male");
        _validDriverInfo.add("21");
        return _validDriverInfo;
    }

    /**
     * Helper function to generate valid customer info.
     * 
     * @return An ArrayList of Strings containing valid customer info.
     */
    private ArrayList<String> createValidCustomerInfo() {
        ArrayList<String> _validCustomerInfo = new ArrayList<String>();
        _validCustomerInfo.add("customer");
        _validCustomerInfo.add("Pete");
        _validCustomerInfo.add("Tanthmanatham");
        _validCustomerInfo.add("male");
        _validCustomerInfo.add("21");
        return _validCustomerInfo;
    }

    /**
     * Helper function to generate valid pickup info.
     * 
     * @return An ArrayList of Strings containing valid pickup info.
     */
    private ArrayList<String> createValidPickupInfo() {
        ArrayList<String> _validPickupInfo = new ArrayList<String>();
        _validPickupInfo.add("1");
        _validPickupInfo.add("36.0731654");
        _validPickupInfo.add("-115.20643259999997");
        _validPickupInfo.add("36.0041386");
        _validPickupInfo.add("-115.1412292");
        return _validPickupInfo;
    }

    /**
     * Helper function to generate invalid pickup info.
     * 
     * @return An ArrayList of Strings containing invalid pickup info.
     */
    private ArrayList<String> createInvalidPickupInfo() {
        ArrayList<String> _invalidPickupInfo = new ArrayList<String>();
        _invalidPickupInfo.add("1");
        _invalidPickupInfo.add("2");
        _invalidPickupInfo.add("150.11");
        _invalidPickupInfo.add("180.32");
        return _invalidPickupInfo;
    }
}
