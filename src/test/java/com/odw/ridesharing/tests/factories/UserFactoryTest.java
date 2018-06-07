package com.odw.ridesharing.tests.factories;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.factories.UserFactory;
import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.abstractmodel.AbstractUser;
import com.odw.ridesharing.model.exceptions.InvalidUserArgumentsException;

/**
 * Tests all the public methods inside UserFactory.
 */
public class UserFactoryTest {

    /**
     * Test to see if a customer is created through the factory based on the given input.
     */
    @Test
    public void testBuildCustomer() {
        UserFactory _userFactory = new UserFactory();

        // ---------------------------------------------
        // Creating a valid customer.
        try {
            AbstractUser _shouldBeCustomer = _userFactory.buildUser(createValidCustomerInfo());
            assertTrue(_shouldBeCustomer instanceof Customer);
        } catch (InvalidUserArgumentsException e) {
            fail("Error creating a valid customer.");
        }
    }
    
    /**
     * Test to see if a driver is created through the factory based on the given input.
     */
    @Test
    public void testBuildDriver() {
        UserFactory _userFactory = new UserFactory();
        
        // ---------------------------------------------
        // Creating a valid driver.
        try {
            AbstractUser _shouldBeDriver = _userFactory.buildUser(createValidDriverInfo());
            assertTrue(_shouldBeDriver instanceof Driver);
        } catch (InvalidUserArgumentsException e) {
            fail("Error creating a valid driver");
        }
    }
    
    /**
     * 
     */
    @Test
    public void testInvalidBuildInput() {
        UserFactory _userFactory = new UserFactory();
        
        // ---------------------------------------------
        // Creating an invalid user.
        try {
            @SuppressWarnings("unused") // Suppressed because this variable is not needed.
            AbstractUser _unknownUserType = _userFactory.buildUser(createInvalidUserInfo());
            fail("Built a user with invalid input without issues.");
        } catch (InvalidUserArgumentsException e) {
            // Execution SHOULD reach inside the catch statement.
        }
    }

    // ==========================================================================================
    // Helper Functions

    /**
     * Helper function to generate valid customer info.
     * 
     * @return An ArrayList of Strings containing valid customer info.
     */
    private ArrayList<String> createValidCustomerInfo() {
        ArrayList<String> _validCustomerInfo = new ArrayList<String>();
        _validCustomerInfo.add("customer");
        _validCustomerInfo.add("miley");
        _validCustomerInfo.add("cyrus");
        _validCustomerInfo.add("female");
        _validCustomerInfo.add("25");
        return _validCustomerInfo;
    }

    /**
     * Helper function to generate valid driver info.
     * 
     * @return An ArrayList of Strings containing valid driver info.
     */
    private ArrayList<String> createValidDriverInfo() {
        ArrayList<String> _validDriverInfo = new ArrayList<String>();
        _validDriverInfo.add("driver");
        _validDriverInfo.add("wesley");
        _validDriverInfo.add("dong");
        _validDriverInfo.add("male");
        _validDriverInfo.add("23");
        return _validDriverInfo;
    }

    /**
     * Helper function to generate invalid user info.
     * 
     * @return An ArrayList of Strings containing invalid user info.
     */
    private ArrayList<String> createInvalidUserInfo() {
        ArrayList<String> _invalidUserInfo = new ArrayList<String>();
        _invalidUserInfo.add("unknown");
        _invalidUserInfo.add("and");
        _invalidUserInfo.add("bad");
        _invalidUserInfo.add("length");
        return _invalidUserInfo;
    }
}
