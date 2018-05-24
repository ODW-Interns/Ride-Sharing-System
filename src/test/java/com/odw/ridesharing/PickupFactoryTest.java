package com.odw.ridesharing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.Pickup;
import com.odw.ridesharing.service.PickupFactory;

public class PickupFactoryTest {

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
            Pickup _firstPickup = _pickupFactory.createPickup(_pickupValues, _customer, _driver);
                    
            assertEquals(_firstPickup.getPickupID(), 0);
            
            assertEquals(_firstPickup.getDriver().getUserID(), 1);
            assertEquals(_firstPickup.getDriver().getFirstName(), "Mark");
            assertEquals(_firstPickup.getDriver().getLastName(), "Constantine");
            assertEquals(_firstPickup.getDriver().getSex(), "Male");
            assertEquals(_firstPickup.getDriver().getAge(), 21);
            assertEquals(_firstPickup.getDriver().getCarID(), 50);
            
            assertEquals(_firstPickup.getCustomer().getUserID(), 0);
            assertEquals(_firstPickup.getCustomer().getFirstName(), "Wesley");
            assertEquals(_firstPickup.getCustomer().getLastName(), "Dong");
            assertEquals(_firstPickup.getCustomer().getSex(), "Female");
            assertEquals(_firstPickup.getCustomer().getAge(), 23);
        } catch (Exception e_) {
            fail("Error creating a valid pickup");
        }
        
        
    }

}
