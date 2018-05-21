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
     * @param typeValues
     * @throws BadUserException
     */
    public void modifyUser(ArrayList<String> typeValues) throws BadUserException {
        if (typeValues.size() == RuntimeConstants.MODIFY_USER_DRIVER_FORMAT.length
                || typeValues.size() == RuntimeConstants.MODIFY_USER_CUSTOMER_FORMAT.length) {
            int _idx = Integer.parseInt(typeValues.get(0));
            User _user = userDatabase.get(_idx);

            if (_idx > -1) {
                if (typeValues.get(1) == RuntimeConstants.DRIVER) {
                    Driver _driver = (Driver) _user;
                    if (_user.getUserID() == _idx) {
                        _user.setFirstName(typeValues.get(2));
                        _user.setLastName(typeValues.get(3));
                        _user.setSex(typeValues.get(4));
                        _user.setAge(Integer.parseInt(typeValues.get(5)));
                        _driver.setIsAvailable(Boolean.parseBoolean(typeValues.get(6)));
                        _driver.setCarID(Integer.parseInt(typeValues.get(7)));
                        _driver.setRating(Integer.parseInt(typeValues.get(8)));
                    } else
                        throw new BadUserException();
                } else {
                    // Customer _customer = (Customer) _user;
                    if (_user.getUserID() == _idx) {
                        _user.setFirstName(typeValues.get(2));
                        _user.setLastName(typeValues.get(3));
                        _user.setSex(typeValues.get(4));
                        _user.setAge(Integer.parseInt(typeValues.get(5)));
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
    public void deleteUser(ArrayList<String> typeValues_) throws BadUserException {
        if (typeValues_.size() == RuntimeConstants.DELETE_USER_FORMAT.length) {

            int _idx = Integer.parseInt(typeValues_.get(1));

            if (_idx > -1) {
                try {
                    User _user = userDatabase.get(_idx);
                    if (_user.getUserID() == _idx)
                        userDatabase.remove(_idx);
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
