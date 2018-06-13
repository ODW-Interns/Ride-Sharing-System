package com.odw.ridesharing.tests.factories;

import static org.junit.Assert.*;

import org.junit.Test;

import com.odw.ridesharing.exceptions.InvalidUserArgumentsException;
import com.odw.ridesharing.factories.UserFactory;
import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.UserType;
import com.odw.ridesharing.model.abstractmodel.AbstractUser;

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
            UserType _userType = UserType.valueOf("customer".toUpperCase());
            String _firstName = "miley";
            String _lastName = "cyrus";
            String _sex = "female";
            int _age = 25;
            
            AbstractUser _shouldBeCustomer = _userFactory.buildUser(_userType, _firstName, _lastName, _sex, _age);
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
            UserType _userType = UserType.valueOf("driver".toUpperCase());
            String _firstName = "wesley";
            String _lastName = "dong";
            String _sex = "male";
            int _age = 23;
            
            AbstractUser _shouldBeDriver = _userFactory.buildUser(_userType, _firstName, _lastName, _sex, _age);
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
        	UserType _userType = UserType.valueOf("unknown".toUpperCase());
            String _firstName =  "and";
            String _lastName =  "super";
            String _sex =  "bad";
            int _age = 22;
            
            @SuppressWarnings("unused") // Suppressed because this variable is not needed.
            AbstractUser _unknownUserType = _userFactory.buildUser(_userType, _firstName, _lastName, _sex, _age);
            
            fail("Built a user with invalid input without issues.");
        } catch (InvalidUserArgumentsException e) {
            // Execution SHOULD reach inside the catch statement.
        } catch (IllegalArgumentException e_) {
        	
        }
    }

}
