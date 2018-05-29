package com.odw.ridesharing.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.abstractmodel.User;
import com.odw.ridesharing.model.exceptions.*;

/**
 * The UserController is called by the CommandController to handle the commands
 * done on a User. UserController calls UserFactory to create a User 
 * (Customer/Driver) and handles modifying and deleting of User object.
 */
public class UserController {

    private ConcurrentHashMap<Integer, User> userDatabase = new ConcurrentHashMap<Integer, User>();
    private UserFactory userFactory = new UserFactory();

    /**
     * Add user to the userDatabase
     * 
     * @param typeValues_
     *            String needed to create the user
     * @return _user User object to be used for logger
     * @throws InvalidUserArgumentsException
     */
    public User createUser(ArrayList<String> typeValues_) throws InvalidUserArgumentsException {
        if (typeValues_.size() == RuntimeConstants.CREATE_USER_FORMAT.length) {
            try {
                User _user = userFactory.createUser(typeValues_);
                userDatabase.put(_user.getUserID(), _user);
                return _user;
            } catch (Exception e_) {
                throw new InvalidUserArgumentsException();
            }
        }

        // Something went wrong..
        throw new InvalidUserArgumentsException();
    }

    /**
     * Modify user that is currently in the userDatabase
     * 
     * @param typeValues_
     *            ArrayList of string that should contain FirstName, LastName, Age,
     *            and Sex for customer For Driver, the ArrayList will contain 3 more
     *            fields: isAvailable, Rating, and CarID
     * @return modifyDriver(_userID, typeValues_) User object that contain driver's
     *         info
     * @return modifyCustomer(_userID, typeValues_) User object that contain
     *         customer's info
     * @throws BadCustomerException
     * @throws InvalidUserArgumentsException
     * @throws BadDriverException
     */
    public User modifyUser(ArrayList<String> typeValues_)
            throws BadCustomerException, InvalidUserArgumentsException, BadDriverException {
        if (typeValues_.size() == RuntimeConstants.MODIFY_USER_DRIVER_FORMAT.length) {
            try {
                int _userID = Integer.parseInt(typeValues_.get(0));
                String _userType = typeValues_.get(1);
                if (_userType.equals(RuntimeConstants.DRIVER)) {
                    return modifyDriver(_userID, typeValues_);
                }
            } catch (NullPointerException e_) {
                throw new InvalidUserArgumentsException();
            } catch (NumberFormatException e_) {
                throw new InvalidUserArgumentsException();
            }

        } else if (typeValues_.size() == RuntimeConstants.MODIFY_USER_CUSTOMER_FORMAT.length) {
            try {
                int _userID = Integer.parseInt(typeValues_.get(0));
                String _userType = typeValues_.get(1);
                if (_userType.equals(RuntimeConstants.CUSTOMER)) {
                    return modifyCustomer(_userID, typeValues_);
                }
            } catch (NullPointerException e_) {
                throw new InvalidUserArgumentsException();
            } catch (NumberFormatException e_) {
                throw new InvalidUserArgumentsException();
            }
        }

        // Something went wrong..
        throw new InvalidUserArgumentsException();
    }

    /**
     * Delete user from the database
     * 
     * @param typeValues
     *            ArrayList of string that should contain userID
     * @return userDatabase.remove(_userID) Object to be removed, will be used for
     *         logger
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
     * @return A list string of all the users currently in database.
     */
    public String getUserDatabaseAsString() {
        if (userDatabase.size() > 0) {
            StringBuilder _result = new StringBuilder();

            for (Map.Entry<Integer, User> _entry : userDatabase.entrySet()) {

                User _currentUser = _entry.getValue();
                if (_currentUser instanceof Driver) {
                    Driver _currentDriver = (Driver) _currentUser;
                    _result.append(System.lineSeparator() + _currentDriver.toString());
                } else
                    _result.append(System.lineSeparator() + _currentUser.toString());

            }

            return _result.toString();
        }

        return "";
    }

    /**
     * Return the first available driver in the user database. Sets the driver's
     * availability to false because he/she is going to be scheduled.
     * 
     * @return _currentDriver The first available driver's info
     */
    public Driver getNextAvailableDriver() {
        if (!userDatabase.isEmpty()) {
            for (Map.Entry<Integer, User> _entry : userDatabase.entrySet()) {
                User _currentUser = _entry.getValue();

                if (_currentUser instanceof Driver) {
                    Driver _currentDriver = (Driver) _currentUser;

                    if (_currentDriver.getIsAvailable()) {
                        // Set false here because driver is guaranteed to be scheduled.
                        _currentDriver.setIsAvailable(false);

                        // Update the database.
                        int _driverKey = _entry.getKey();
                        userDatabase.remove(_driverKey);
                        userDatabase.put(_driverKey, _currentDriver);

                        return _currentDriver;
                    }
                }
            }
        }

        // There are no available drivers to be scheduled.
        return null;
    }

    /**
     * Search the user database for the driver/customer based on the given ID, then
     * return it
     * 
     * @param userID_
     *            userID needed to search the database
     * @return userDatabase.get(userID_) return the user object
     * @throws BadCustomerException
     */
    public Customer getCustomerByID(int userID_) throws BadCustomerException {

        User _retrievedUser = userDatabase.get(userID_);

        if (_retrievedUser != null && _retrievedUser instanceof Customer) {
            return (Customer) _retrievedUser;
        }

        // User was driver or does not exist.
        throw new BadCustomerException();
    }

    /**
     * Private method to modify a specific driver from the database.
     * 
     * @param userID_
     *            The userID to be modify
     * @param newValues_
     *            ArrayList of string that should contain FirstName, LastName, Sex,
     *            Age, isAvailable, Rating, and CarID to be modified
     * @return _newDriver Object that contain new info of driver
     * @throws BadDriverException
     * @throws InvalidUserArgumentsException
     */
    /* @formatter:off */
    private Driver modifyDriver(int userID_, ArrayList<String> newValues_)
     throws BadDriverException, InvalidUserArgumentsException {
        try {
            String _newFirstName = newValues_.get(2);
            String _newLastName = newValues_.get(3);
            String _newSex = newValues_.get(4);
            int _newAge = Integer.parseInt(newValues_.get(5));
            Boolean _newIsAvailable = Boolean.parseBoolean(newValues_.get(6));
            int _newRating = Integer.parseInt(newValues_.get(7));
            int _newCarID = Integer.parseInt(newValues_.get(8));
            User _modifiedUser = userDatabase.remove(userID_);

            Driver _newDriver = (Driver) _modifiedUser; // TODO: error handle this downcasting
            _newDriver.setFirstName(_newFirstName);
            _newDriver.setLastName(_newLastName);
            _newDriver.setSex(_newSex);
            _newDriver.setAge(_newAge);
            _newDriver.setIsAvailable(_newIsAvailable);
            _newDriver.setCarID(_newCarID);
            _newDriver.setRating(_newRating);

            userDatabase.put(userID_, _newDriver);

            return _newDriver;
        } catch (NullPointerException e_) {
            throw new BadDriverException();
        } catch (NumberFormatException e_) {
            throw new InvalidUserArgumentsException();
        }
    }
    /* @formatter:on */

    /**
     * Private method to modify a specific customer from the database.
     * 
     * @param userID_
     *            The userID to be modify
     * @param newValues_
     *            ArrayList of string that should contain first name, last name,
     *            sex, age
     * @return _newCustomer Object that contain new info of customer
     * @throws BadCustomerException
     * @throws InvalidUserArgumentsException
     */
    /* @formatter:off */
    private Customer modifyCustomer(int userID_, ArrayList<String> newValues_)
     throws BadCustomerException, InvalidUserArgumentsException {
        try {
            String _newFirstName = newValues_.get(2);
            String _newLastName = newValues_.get(3);
            String _newSex = newValues_.get(4);
            int _newAge = Integer.parseInt(newValues_.get(5));

            User _modifiedUser = userDatabase.remove(userID_);

            Customer _newCustomer = (Customer) _modifiedUser; // TODO: error handle this downcasting
            _newCustomer.setFirstName(_newFirstName);
            _newCustomer.setLastName(_newLastName);
            _newCustomer.setSex(_newSex);
            _newCustomer.setAge(_newAge);

            userDatabase.put(userID_, _newCustomer);

            return _newCustomer;
        } catch (NullPointerException e_) {
            throw new BadCustomerException();
        } catch (NumberFormatException e_) {
            throw new InvalidUserArgumentsException();
        }
    }
    /* @formatter:on */
}
