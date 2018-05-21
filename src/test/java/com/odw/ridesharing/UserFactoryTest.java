package com.odw.ridesharing;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.User;
import com.odw.ridesharing.service.UserFactory;

public class UserFactoryTest {
    
    UserFactory userFactory = new UserFactory();
    
    /**
     * Tests UserFactory's createUser method. Ensures that the proper concrete user is
     * being generated. Note that the assumption for this method is that the
     * ArrayList is equal to the predetermined event type values size.
     */

    @Test
    public void testCreateUser() {
        ArrayList<String> customerUserInfo = new ArrayList<String>();
        customerUserInfo.add("customer");
        customerUserInfo.add("miley");
        customerUserInfo.add("cyrus");
        customerUserInfo.add("female");
        customerUserInfo.add("25");
        User customer = userFactory.createUser(customerUserInfo);
        assertTrue(customer instanceof Customer);
        
        ArrayList<String> driverUserInfo = new ArrayList<String>();
        driverUserInfo.add("driver");
        driverUserInfo.add("wesley");
        driverUserInfo.add("dong");
        driverUserInfo.add("male");
        driverUserInfo.add("23");
        driverUserInfo.add("true");
        driverUserInfo.add("3");
        User driver = userFactory.createUser(customerUserInfo);
        assertTrue(driver instanceof Driver);
        
        ArrayList<String> invalidUserInfo = new ArrayList<String>();
        invalidUserInfo.add("unknown");
        invalidUserInfo.add("must");
        invalidUserInfo.add("be");
        invalidUserInfo.add("length");
        invalidUserInfo.add("5");
        User unknown = userFactory.createUser(invalidUserInfo);
        assertNull(unknown);
    }
}
