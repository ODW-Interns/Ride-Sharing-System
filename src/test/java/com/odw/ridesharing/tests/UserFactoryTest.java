package com.odw.ridesharing.tests;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.abstractmodel.User;
import com.odw.ridesharing.model.exceptions.InvalidUserArgumentsException;
import com.odw.ridesharing.service.UserFactory;

public class UserFactoryTest {

    /**
     * Tests UserFactory's createUser method. Ensures that the proper concrete user
     * is being generated.
     */
    @Test
    public void testCreateUser() {
        UserFactory _userFactory = new UserFactory();

        // ---------------------------------------------
        // Creating a valid customer.
        try {
            User _shouldBeCustomer = _userFactory.buildUser(createValidCustomerInfo());
            assertTrue(_shouldBeCustomer instanceof Customer);
        } catch (InvalidUserArgumentsException e) {
            fail("Error creating a valid customer.");
        }

        // ---------------------------------------------
        // Creating a valid driver.
        try {
            User _shouldBeDriver = _userFactory.buildUser(createValidDriverInfo());
            assertTrue(_shouldBeDriver instanceof Driver);
        } catch (InvalidUserArgumentsException e) {
            fail("Error creating a valid driver");
        }

        // ---------------------------------------------
        // Creating an invalid user.
        try {
            @SuppressWarnings("unused") // Suppressed because this variable is not needed.
            User _unknownUserType = _userFactory.buildUser(createInvalidUserInfo());
        } catch (InvalidUserArgumentsException e) {
            assertTrue(true); // This is the desired outcome.
        }
    }

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
