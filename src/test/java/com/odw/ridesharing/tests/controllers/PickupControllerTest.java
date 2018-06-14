package com.odw.ridesharing.tests.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.controllers.PickupController;
import com.odw.ridesharing.exceptions.InvalidPickupArgumentsException;
import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.Pickup;

/**
 * Tests all the public methods inside PickupController.
 */
public class PickupControllerTest {
    
    /**
     * Tests PickupController's createPickup method. Ensures that a valid pickup can be created.
     */
    @Test
    public void testCreateValidPickup() {
        PickupController _pickupController = new PickupController();
        Customer _customerForPickup = new Customer(0, "Pete", "Tanthmanatham", "Male", 21);
        
        // ---------------------------------------------
        // Creating a valid pickup.
        try {
            _pickupController.createPickup(createValidPickupInfo(), _customerForPickup);
        } catch (Exception e_) {
            fail("Error creating a valid pickup. " + e_.getMessage());
        }
    }
    
    /**
     * Tests createPickup with invalid number of arguments to see if it fails.
     */
    @Test
    public void testCreatePickupWithInvalidNumberOfArguments() {
        PickupController _pickupController = new PickupController();
        Customer _customerForPickup = new Customer(0, "Pete", "Tanthmanatham", "Male", 21);
        
        ArrayList<String> _invalidNumberOfCreatePickupArguments = new ArrayList<String>();
        _invalidNumberOfCreatePickupArguments.add("1");
        _invalidNumberOfCreatePickupArguments.add("2");
        
        // ---------------------------------------------
        // Creating an invalid pickup with an invalid number of arguments.
        try {
            _pickupController.createPickup(_invalidNumberOfCreatePickupArguments, _customerForPickup);
            
            // Should fail due to incorrect Pickup information.
            fail("Created an invalid pickup without issues.");
        } catch (InvalidPickupArgumentsException expected_) {
            // Execution SHOULD reach inside the catch statement.
        }
    }
    
    /**
     * Tests the createPickup method.
     */
    @Test
    public void testCreatePickupWithNullCustomer() {
        PickupController _pickupController = new PickupController();
        
        // ---------------------------------------------
        // Creating an invalid pickup using a null customer.
        try {
            _pickupController.createPickup(createValidPickupInfo(), null);
            
            // Should fail due to null customer.
            fail("Created an invalid pickup without issues.");
        } catch (InvalidPickupArgumentsException expected_) {
            // Execution SHOULD reach inside the catch statement.
        }
    }
    
    /**
     * Tests the deletePickup method.
     */
    @Test
    public void testDeleteValidPickup() {
        PickupController _pickupController = new PickupController();
        Customer _customerForPickup = new Customer(0, "Pete", "Tanthmanatham", "Male", 21);
        
        try {
            Pickup _createdPickup = _pickupController.createPickup(createValidPickupInfo(), _customerForPickup);
            
            _pickupController.storePickupInDatabase(_createdPickup);
            
            ArrayList<String> _deletePickupInput = new ArrayList<>();
            _deletePickupInput.add("0");
            _pickupController.deletePickup(_deletePickupInput);
        } catch (Exception e_) {
            fail("Error deleting a valid pickup. " + e_.getMessage());
        }
    }
    
    /**
     * Tests deletePickup with invalid number of arguments to see if it fails.
     */
    @Test
    public void testDeletePickupWithInvalidNumberOfArguments() {
        PickupController _pickupController = new PickupController();
        
        ArrayList<String> _invalidNumberOfDeletePickupArguments = new ArrayList<String>();
        _invalidNumberOfDeletePickupArguments.add("1");
        _invalidNumberOfDeletePickupArguments.add("2");
        
        try {
            _pickupController.deletePickup(_invalidNumberOfDeletePickupArguments);
            
            // Should fail due to invalid number of arguments.
            fail("Deleted an invalid pickup without issue.");
        } catch (Exception expected_) {
            // Execution SHOULD reach inside the catch statement.
        }
    }
    
    /**
     * Tests deleting a pickup that does not exist.
     */
    @Test
    public void testDeletingPickupThatDoesNotExist() {
        PickupController _pickupController = new PickupController();
        
        ArrayList<String> _deletePickupArguments = new ArrayList<String>();
        _deletePickupArguments.add("100"); // Pickup with ID does not exist.
        
        try {
            _pickupController.deletePickup(_deletePickupArguments);
            
            // Should fail due to no pickup exists to delete.
            fail("Deleted a pickup that does not exist without issue.");
        } catch (Exception expected_) {
            // Execution SHOULD reach inside the catch statement.
        }
    }
    
    /**
     * Tests deleting a pickup with an ID that is not integer parseable.
     */
    @Test
    public void testDeletePickupWithBadID() {
        PickupController _pickupController = new PickupController();
        
        ArrayList<String> _deletePickupArguments = new ArrayList<String>();
        _deletePickupArguments.add("ID NOT INTEGER PARSEABLE"); // BAD ID
        
        try {
            _pickupController.deletePickup(_deletePickupArguments);
            
            // Should fail due to no pickup exists to delete.
            fail("Deleted a pickup with a invalid ID without issue.");
        } catch (Exception expected_) {
            // Execution SHOULD reach inside the catch statement.
        }
    }
    
    /**
     * Tests the schedulePickup method.
     */
    @Test
    public void testSchedulePickup() {
        PickupController _pickupController = new PickupController();
        Customer _customerForPickup = new Customer(0, "Pete", "Tanthmanatham", "Male", 21);
        Driver _driverToSchedule = new Driver(1, "Mark", "Constantine", "Male", 21);
        
        try {
            Pickup _scheduledPickup = _pickupController.createPickup(createValidPickupInfo(), _customerForPickup);
            _pickupController.schedulePickup(_scheduledPickup, _driverToSchedule);
        } catch (Exception e_) {
            fail("Error scheduling a valid pickup. " + e_.getMessage());
        }
    }
    
    /**
     * Tests the scheduleUnscheduledPickup method.
     */
    @Test
    public void testScheduleUnscheduledPickup() {
        PickupController _pickupController = new PickupController();
        Customer _customerForPickup = new Customer(0, "Pete", "Tanthmanatham", "Male", 21);
        Driver _driverMadeAvailable = new Driver(1, "Mark", "Constantine", "Male", 21);
        
        try {
            Pickup _unscheduledPickup = _pickupController.createPickup(createValidPickupInfo(), _customerForPickup);
            
            // Null driver means no available drivers to be scheduled. Enter unscheduled queue.
            _pickupController.schedulePickup(_unscheduledPickup, null);
            
            // Driver has been made available. Ready to schedule the unscheduled pickup.
            _driverMadeAvailable.setIsAvailable(true);
            
            _pickupController.scheduleUnscheduledPickup(_driverMadeAvailable);
        } catch (Exception e_) {
            fail("Error scheduling an unscheduled pickup. " + e_.getMessage());
        }
    }
    
    /**
     * Tests to see if getPickupDatabaseAsString returns an empty string for an empty pickup database.
     */
    @Test
    public void testGetPickupDatabaseAsEmptyString() {
        PickupController _pickupController = new PickupController();
        
        assertEquals("Pickup database string should be empty", "", _pickupController.getPickupDatabaseAsString());
    }
    
    /**
     * Tests to see if a null pickup does NOT get stored in the pickup database.
     */
    @Test
    public void testStoreNullPickupInDatabase() {
        PickupController _pickupController = new PickupController();
        
        // Should not store null into database.
        _pickupController.storePickupInDatabase(null);
        
        assertEquals("Pickup database string should be empty", "", _pickupController.getPickupDatabaseAsString());
    }
    
    // ==========================================================================================
    // Helper Functions
    
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
}
