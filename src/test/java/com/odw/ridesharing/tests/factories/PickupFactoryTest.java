package com.odw.ridesharing.tests.factories;

import static org.junit.Assert.*;

import org.junit.Test;

import com.odw.ridesharing.factories.PickupFactory;
import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Pickup;

/**
 * Tests all the public methods inside PickupFactory.
 */
public class PickupFactoryTest {
    
    /**
     * Tests PickupFactory's createPickup method. Ensures that the proper a valid pickup is being generated.
     */
    @Test
    public void testBuildPickup() {
        PickupFactory _pickupFactory = new PickupFactory();
        
        // ---------------------------------------------
        // Creating a valid pickup.
        Customer _customer = new Customer(0, "Wesley", "Dong", "Female", 23); // ID: 0
        
        double _originLatitude = 36.10583630000001;
        double _originLongitude = -115.13841919999999;
        double _destinationLatitude = 36.0041386;
        double _destinationLongitude = -115.1412292;
        
        try {
            Pickup _firstPickup = _pickupFactory.buildPickup(_originLatitude,
                                                             _originLongitude,
                                                             _destinationLatitude,
                                                             _destinationLongitude,
                                                             _customer);
            
            assertEquals(0, _firstPickup.getPickupID());
            
            // No driver is assigned when creating a pickup.
            assertNull(null, _firstPickup.getDriver());
            
            assertEquals(0, _firstPickup.getCustomer().getUserID());
            assertEquals("Wesley", _firstPickup.getCustomer().getFirstName());
            assertEquals("Dong", _firstPickup.getCustomer().getLastName());
            assertEquals("Female", _firstPickup.getCustomer().getSex());
            assertEquals(23, _firstPickup.getCustomer().getAge());
        } catch (Exception e_) {
            fail("Error creating a valid pickup.");
        }
        
    }
    
}
