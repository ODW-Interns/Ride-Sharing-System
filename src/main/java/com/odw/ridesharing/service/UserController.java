package com.odw.ridesharing.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.User;
import com.odw.ridesharing.model.exceptions.BadUserException;
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
        // Valid car IDs are non-negative.

        if (typeValues_.size() == RuntimeConstants.CREATE_USER_DRIVER_FORMAT.length
                || typeValues_.size() == RuntimeConstants.CREATE_USER_CUSTOMER_FORMAT.length) {
            User _user = userFactory.createUser(typeValues_);
            userDatabase.put(_user.getUserID(), _user);
            return _user;
        }

        throw new BadUserException();
    }

    /**
     * Modify user that is currently in the userDatabase
     * 
     * @param typeValues_
     * @throws BadUserException
     */
    public User modifyUser(ArrayList<String> typeValues_) throws BadUserException {
        if (typeValues_.size() == RuntimeConstants.MODIFY_USER_DRIVER_FORMAT.length
                || typeValues_.size() == RuntimeConstants.MODIFY_USER_CUSTOMER_FORMAT.length) {
            int _idx = Integer.parseInt(typeValues_.get(0));
            String _newFirstName = typeValues_.get(2);
            String _newLastName = typeValues_.get(3);            
            String _newSex = typeValues_.get(4);
            int _newAge = Integer.parseInt(typeValues_.get(5));
            Boolean _newIsAvailable = Boolean.parseBoolean(typeValues_.get(6));
            int _newCarID = Integer.parseInt(typeValues_.get(7));
            int _newRating = Integer.parseInt(typeValues_.get(8));
            
            
            User _currentUser = userDatabase.get(_idx);

            if (_idx > -1) {
                if (typeValues_.get(1) == RuntimeConstants.DRIVER) {
                    Driver _currentDriver = (Driver) _currentUser;
                    if (_currentDriver.getUserID() == _idx) {
                        _currentDriver.setFirstName(_newFirstName);
                        _currentDriver.setLastName(_newLastName);
                        _currentDriver.setSex(_newSex);
                        _currentDriver.setAge(_newAge);
                        _currentDriver.setIsAvailable(_newIsAvailable);
                        _currentDriver.setCarID(_newCarID);
                        _currentDriver.setRating(_newRating);
                        return _currentDriver;
                    } else
                        throw new BadUserException();
                } else {
                    // Customer _customer = (Customer) _user;
                    if (_currentUser.getUserID() == _idx) {
                        _currentUser.setFirstName(_newFirstName);
                        _currentUser.setLastName(_newLastName);
                        _currentUser.setSex(_newSex);
                        _currentUser.setAge(_newAge);
                        return _currentUser;
                    } else
                        throw new BadUserException();
                }
            } else
                throw new BadUserException();
        } else
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

            int _idx = Integer.parseInt(typeValues_.get(0));

            if (_idx > -1) {
                try {
                    User _user = userDatabase.get(_idx);
                    if (_user.getUserID() == _idx)
                        return userDatabase.remove(_idx);
                    else
                        throw new BadUserException();

                } catch (NullPointerException e_) {
                    throw new BadUserException();

                }

            } else
                throw new BadUserException();
        } else
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
}
