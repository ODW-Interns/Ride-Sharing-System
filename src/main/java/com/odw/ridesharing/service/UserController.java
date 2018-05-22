package com.odw.ridesharing.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.User;
import com.odw.ridesharing.model.exceptions.BadUserException;

public class UserController {

    private ConcurrentHashMap<Integer, User> userDatabase = new ConcurrentHashMap<Integer, User>();
    private UserFactory userFactory = new UserFactory();

    /**
     * Add user to the userDatabase
     * 
     * @param typeValues_
     * @throws BadUserException
     */
    public User createUser(ArrayList<String> typeValues_) throws BadUserException {
        if (typeValues_.size() == RuntimeConstants.CREATE_USER_FORMAT.length) {
            User _user = userFactory.createUser(typeValues_);
            userDatabase.put(_user.getUserID(), _user);
            return _user;
        }

        // Something went wrong..
        throw new BadUserException();
    }

    /**
     * Modify user that is currently in the userDatabase
     * 
     * @param typeValues_
     * @throws BadUserException
     */
    public User modifyUser(ArrayList<String> typeValues_) throws BadUserException {
        if (typeValues_.size() == RuntimeConstants.MODIFY_USER_DRIVER_FORMAT.length) {
            int _userID = Integer.parseInt(typeValues_.get(0));
            String _userType = typeValues_.get(1);
            if (_userType.equals(RuntimeConstants.DRIVER)) {
                return modifyDriver(_userID, typeValues_);
            }
        } else if (typeValues_.size() == RuntimeConstants.MODIFY_USER_CUSTOMER_FORMAT.length) {
            int _userID = Integer.parseInt(typeValues_.get(0));
            String _userType = typeValues_.get(1);
            if (_userType.equals(RuntimeConstants.CUSTOMER)) {
                return modifyCustomer(_userID, typeValues_);
            }
        }
        
        // Something went wrong..
        throw new BadUserException();
    }

    /**
     * Delete user from the database
     * 
     * @param typeValues
     * @throws BadUserException
     */
    public User deleteUser(ArrayList<String> typeValues_) throws BadUserException {
        if (typeValues_.size() == RuntimeConstants.DELETE_USER_FORMAT.length) {
            int _userID = Integer.parseInt(typeValues_.get(0));
            try {
                return userDatabase.remove(_userID);
            } catch (NullPointerException e_) {
                throw new BadUserException();
            }
        }

        // Something went wrong..
        throw new BadUserException();
    }

    /**
     * Returns a string of all the users in userDatabase.
     * 
     * @return TODO
     */
    public String getUserDatabase() {
        if (userDatabase.size() > 0) {
            StringBuilder _result = new StringBuilder();

            for (Map.Entry<Integer, User> _entry : userDatabase.entrySet()) {

                User _currentUser = _entry.getValue();
                if (_currentUser instanceof Driver) {
                    Driver _currentDriver = (Driver) _currentUser;
                    _result.append(_currentDriver.toString() + System.lineSeparator());
                } else
                    _result.append(_currentUser.toString() + System.lineSeparator());

            }

            return _result.toString();
        }

        return "";
    }

    /**
     * Private method to modify a specific driver from the database.
     */
    private Driver modifyDriver(int userID_, ArrayList<String> newValues_) {
     // TODO: Can't modify a driver to customer.
        
        String _newFirstName = newValues_.get(2);
        String _newLastName = newValues_.get(3);
        String _newSex = newValues_.get(4);
        int _newAge = Integer.parseInt(newValues_.get(5));
        Boolean _newIsAvailable = Boolean.parseBoolean(newValues_.get(6));
        int _newCarID = Integer.parseInt(newValues_.get(7));
        int _newRating = Integer.parseInt(newValues_.get(8));
        
        User _modifiedUser = userDatabase.remove(userID_);
        
        Driver _newDriver = (Driver)_modifiedUser; // TODO: error handle this downcasting
        _newDriver.setFirstName(_newFirstName);
        _newDriver.setLastName(_newLastName);
        _newDriver.setSex(_newSex);
        _newDriver.setAge(_newAge);
        _newDriver.setIsAvailable(_newIsAvailable);
        _newDriver.setCarID(_newCarID);
        _newDriver.setRating(_newRating);
        
        userDatabase.put(userID_, _newDriver);
        
        return _newDriver;
    }
    
    /**
     * Private method to modify a specific customer from the database.
     */
    private Customer modifyCustomer(int userID_, ArrayList<String> newValues_) {
        // TODO: Can't modify a customer to driver.
        
        String _newFirstName = newValues_.get(2);
        String _newLastName = newValues_.get(3);
        String _newSex = newValues_.get(4);
        int _newAge = Integer.parseInt(newValues_.get(5));
        
        User _modifiedUser = userDatabase.remove(userID_);
        
        Customer _newCustomer = (Customer)_modifiedUser; // TODO: error handle this downcasting
        _newCustomer.setFirstName(_newFirstName);
        _newCustomer.setLastName(_newLastName);
        _newCustomer.setSex(_newSex);
        _newCustomer.setAge(_newAge);
        
        userDatabase.put(userID_, _newCustomer);
        
        return _newCustomer;
    }
}
