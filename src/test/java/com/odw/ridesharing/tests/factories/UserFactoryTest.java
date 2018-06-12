package com.odw.ridesharing.tests.factories;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.factories.UserFactory;
import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.UserType;
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
        	ArrayList<String> _validCustomerInfo = createValidCustomerInfo();
        	UserType _userType = UserType.valueOf(_validCustomerInfo.get(0).toUpperCase());
            String _firstName = _validCustomerInfo.get(1);
            String _lastName = _validCustomerInfo.get(2);
            String _sex = _validCustomerInfo.get(3);
            int _age = Integer.parseInt(_validCustomerInfo.get(4));
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
        	ArrayList<String> _validDriverInfo = createValidDriverInfo();
        	UserType _userType = UserType.valueOf(_validDriverInfo.get(0).toUpperCase());
            String _firstName = _validDriverInfo.get(1);
            String _lastName = _validDriverInfo.get(2);
            String _sex = _validDriverInfo.get(3);
            int _age = Integer.parseInt(_validDriverInfo.get(4));
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
        	ArrayList<String>  _invalidUserInfo = createInvalidUserInfo();
        	UserType _userType = UserType.valueOf( _invalidUserInfo.get(0).toUpperCase());
            String _firstName =  _invalidUserInfo.get(1);
            String _lastName =  _invalidUserInfo.get(2);
            String _sex =  _invalidUserInfo.get(3);
            int _age = Integer.parseInt( _invalidUserInfo.get(4));
            @SuppressWarnings("unused") // Suppressed because this variable is not needed.
            AbstractUser _unknownUserType = _userFactory.buildUser(_userType, _firstName, _lastName, _sex, _age);
            fail("Built a user with invalid input without issues.");
        } catch (InvalidUserArgumentsException e) {
            // Execution SHOULD reach inside the catch statement.
        } catch (IllegalArgumentException e_) {
        	
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
        _invalidUserInfo.add("too");
        return _invalidUserInfo;
    }
}
