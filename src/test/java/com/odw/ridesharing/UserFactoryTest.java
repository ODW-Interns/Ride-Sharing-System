package com.odw.ridesharing;

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
     * Tests UserFactory's createUser method. Ensures that the proper concrete user is
     * being generated. Note that the assumption for this method is that the
     * ArrayList is equal to the predetermined event type values size.
     * @throws InvalidUserArgumentsException 
     */
    @Test
    public void testCreateUser() throws InvalidUserArgumentsException {
        UserFactory _userFactory = new UserFactory();
        
        ArrayList<String> _customerUserInfo = new ArrayList<String>();
        _customerUserInfo.add("customer");
        _customerUserInfo.add("miley");
        _customerUserInfo.add("cyrus");
        _customerUserInfo.add("female");
        _customerUserInfo.add("25");
        User _customer = _userFactory.createUser(_customerUserInfo);
        assertTrue(_customer instanceof Customer);
        
        ArrayList<String> _driverUserInfo = new ArrayList<String>();
        _driverUserInfo.add("driver");
        _driverUserInfo.add("wesley");
        _driverUserInfo.add("dong");
        _driverUserInfo.add("male");
        _driverUserInfo.add("23");
 
        User _driver = _userFactory.createUser(_driverUserInfo);
        assertTrue(_driver instanceof Driver);
        
        ArrayList<String> _invalidUserInfo = new ArrayList<String>();
        _invalidUserInfo.add("unknown");
        _invalidUserInfo.add("must");
        _invalidUserInfo.add("be");
        _invalidUserInfo.add("length");
        _invalidUserInfo.add("5");
        User _unknown = _userFactory.createUser(_invalidUserInfo);
        assertNull(_unknown);
    }
}
