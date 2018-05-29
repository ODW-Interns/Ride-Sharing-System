package com.odw.ridesharing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.Pickup;
import com.odw.ridesharing.service.PickupFactory;

public class PickupFactoryTest {

    /**
     * Tests PickupFactory's createPickup method. Ensures that the proper a valid
     * pickup is being generated.
     */
    @Test
    public void testCreatePickup() {
        PickupFactory _pickupFactory = new PickupFactory();

        // ---------------------------------------------
        // Creating a valid pickup.
        Customer _customer = new Customer(0, "Wesley", "Dong", "Female", 23); // ID: 0
        Driver _driver = new Driver(1, "Mark", "Constantine", "Male", 21); // ID: 1
        _driver.setCarID(50); // Driving car with ID 50

        ArrayList<String> _pickupValues = new ArrayList<String>();
        _pickupValues.add("IGNORED");
        _pickupValues.add("36.10583630000001");
        _pickupValues.add("-115.13841919999999");
        _pickupValues.add("36.0041386");
        _pickupValues.add("-115.1412292");
        try {
            Pickup _firstPickup = _pickupFactory.buildPickup(_pickupValues, _customer);
                  
            assertEquals(0, _firstPickup.getPickupID());
            
            assertNull(null, _firstPickup.getDriver());
            
            assertEquals(0, _firstPickup.getCustomer().getUserID());
            assertEquals("Wesley", _firstPickup.getCustomer().getFirstName());
            assertEquals("Dong", _firstPickup.getCustomer().getLastName());
            assertEquals("Female", _firstPickup.getCustomer().getSex());
            assertEquals(23, _firstPickup.getCustomer().getAge());
        } catch (Exception e_) {
            fail("Error creating a valid pickup");
        }

    }

}
