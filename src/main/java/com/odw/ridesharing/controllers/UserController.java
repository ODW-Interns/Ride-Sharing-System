package com.odw.ridesharing.controllers;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.odw.ridesharing.factories.UserFactory;
import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.UserType;
import com.odw.ridesharing.model.abstractmodel.AbstractUser;
import com.odw.ridesharing.model.exceptions.*;

/**
 * The UserController is called by the CommandController to handle the commands
 * done on a User. UserController calls UserFactory to create a User
 * (Customer/Driver) and handles modifying and deleting of User object.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserController {

    private ConcurrentHashMap<Integer, AbstractUser> userDatabase = new ConcurrentHashMap<Integer, AbstractUser>();
    
    @XmlTransient
    private UserFactory userFactory = new UserFactory();

    /**
     * Add user to the userDatabase
     * 
     * @param typeValues_
     *            Expected input values specified under CREATE_USER_FORMAT in
     *            RuntimeConstants.
     * @return _user User object to be used for logger
     * @throws InvalidUserArgumentsException
     */
    public AbstractUser createUser(ArrayList<String> typeValues_) throws InvalidUserArgumentsException {
        if (typeValues_.size() == RuntimeConstants.CREATE_USER_FORMAT.length) {
            try {
            	 UserType _userType = UserType.valueOf(typeValues_.get(0).toUpperCase());
                 String _firstName = typeValues_.get(1);
                 String _lastName = typeValues_.get(2);
                 String _sex = typeValues_.get(3);
                 int _age = Integer.parseInt(typeValues_.get(4));
                 
                AbstractUser _user = userFactory.buildUser(_userType, _firstName, _lastName, _sex, _age);
                userDatabase.put(_user.getUserID(), _user);
                return _user;
            } catch (InvalidUserArgumentsException e_) {
                throw new InvalidUserArgumentsException(e_.getMessage());
            } catch (NumberFormatException e_) {
                throw new InvalidUserArgumentsException("Cannot parse age as an Integer.");
            }
        }

        // Something went wrong..
        throw new InvalidUserArgumentsException("Invalid arguments for createUser.");
    }

    /**
     * Modify user that is currently in the userDatabase
     * 
     * @param typeValues_
     *            Expected input values specified under MODIFY_USER_FORMAT in
     *            RuntimeConstants.
     * @return modifyDriver(_userID, typeValues_) User object that contain driver's
     *         info
     * @return modifyCustomer(_userID, typeValues_) User object that contain
     *         customer's info
     * @throws CustomerNotFoundException
     * @throws InvalidUserArgumentsException
     * @throws DriverNotFoundException
     */
    /* @formatter:off */
    public AbstractUser modifyUser(ArrayList<String> typeValues_) 
            throws CustomerNotFoundException, InvalidUserArgumentsException, DriverNotFoundException {
        // CAREFUL! The assumption here is that the driver format is always NOT the same as the customer format.
        // This will require changing if MODIFY_USER_DRIVER_FORMAT == MODIFY_USER_CUSTOMER_FORMAT.
        if (typeValues_.size() == RuntimeConstants.MODIFY_USER_DRIVER_FORMAT.length) {
            try {
                int _userID = Integer.parseInt(typeValues_.get(0));
                String _userType = typeValues_.get(1);
                
                if (_userType.equals(RuntimeConstants.DRIVER)) {
                    return modifyDriver(_userID, typeValues_);
                }
            } catch (DriverNotFoundException e_) {
                // There is no such driver in the database.
                throw new DriverNotFoundException("Driver not found in the database. DriverID Value = " + typeValues_.get(0));
            } catch (Exception e_) {
                throw new InvalidUserArgumentsException(e_.getMessage());
            }

        } else if (typeValues_.size() == RuntimeConstants.MODIFY_USER_CUSTOMER_FORMAT.length) {
            try {
                int _userID = Integer.parseInt(typeValues_.get(0));
                String _userType = typeValues_.get(1);
                
                if (_userType.equals(RuntimeConstants.CUSTOMER)) {
                    return modifyCustomer(_userID, typeValues_);
                }
            } catch (CustomerNotFoundException e_) {
                // There is no such customer in the database.
                throw new CustomerNotFoundException("Customer not found in the database. UserID Value = " + typeValues_.get(0));
            } catch (Exception e_) {
                throw new InvalidUserArgumentsException(e_.getMessage());
            }
        }

        // Something went wrong..
        throw new InvalidUserArgumentsException("Invalid number of arguments passed in ModifyUser.");
    }
    /* @formatter:on */

    /**
     * Delete user from the database
     * 
     * @param typeValues
     *            Expected input values specified under DELETE_USER_FORMAT in
     *            RuntimeConstants.
     * @return userDatabase.remove(_userID) Object to be removed, will be used for
     *         logger
     * @throws UserNotFoundException
     */
    public AbstractUser deleteUser(ArrayList<String> typeValues_) 
            throws UserNotFoundException, InvalidUserArgumentsException {
        if (typeValues_.size() == RuntimeConstants.DELETE_USER_FORMAT.length) {
            int _userID = Integer.parseInt(typeValues_.get(0));

            if (userDatabase.get(_userID) != null) {
                return userDatabase.remove(_userID);
            } else {
                throw new UserNotFoundException("User not found in the database. UserID Value = " + typeValues_.get(0));
            }
        }

        // Something went wrong..
        throw new InvalidUserArgumentsException("Invalid number of arguments passed in DeleteUser.");
    }

    /**
     * Returns a string of all the users in userDatabase.
     * 
     * @return A list string of all the users currently in database.
     */
    public String getUserDatabaseAsString() {
        if (!userDatabase.isEmpty()) {
            StringBuilder _result = new StringBuilder();

            for (Map.Entry<Integer, AbstractUser> _entry : userDatabase.entrySet()) {
                AbstractUser _currentUser = _entry.getValue();
                if (_currentUser instanceof Driver) {
                    Driver _currentDriver = (Driver) _currentUser;
                    _result.append(System.lineSeparator() + _currentDriver.toString());
                } else {
                    _result.append(System.lineSeparator() + _currentUser.toString());
                }
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
            for (Map.Entry<Integer, AbstractUser> _entry : userDatabase.entrySet()) {
                AbstractUser _currentUser = _entry.getValue();

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
     * @throws CustomerNotFoundException
     */
    public Customer getCustomerByID(int userID_) throws CustomerNotFoundException {
        AbstractUser _retrievedUser = userDatabase.get(userID_);

        if (_retrievedUser != null && _retrievedUser instanceof Customer) {
            return (Customer) _retrievedUser;
        }

        // User was driver or does not exist.
        throw new CustomerNotFoundException("User not found in the database. UserID Value = " + userID_);
    }

    /**
     * Helper method to modify a specific driver from the database.
     * 
     * @param userID_
     *            The ID of the user to be modified.
     * @param newValues_
     *            Expected input values specified under MODIFY_USER_DRIVER_FORMAT in
     *            RuntimeConstants.
     * @return _newDriver The newly modified driver.
     * @throws DriverNotFoundException
     * @throws InvalidUserArgumentsException
     */
    /* @formatter:off */
    private Driver modifyDriver(int userID_, ArrayList<String> newValues_) 
            throws DriverNotFoundException, InvalidUserArgumentsException {
        try {
            // Getting the values from input.
            // userID and userType obtained from modifyUser. (i.e. .get(0) and .get(1))
            String _newFirstName = newValues_.get(2);
            String _newLastName = newValues_.get(3);
            String _newSex = newValues_.get(4);
            int _newAge = Integer.parseInt(newValues_.get(5));
            Boolean _newIsAvailable = Boolean.parseBoolean(newValues_.get(6));
            int _newCarID = Integer.parseInt(newValues_.get(7));
            
            // Setting the modified driver values. Should be driver (ClassCastException otherwise).
            Driver _modifiedDriver = (Driver) userDatabase.remove(userID_);
            _modifiedDriver.setFirstName(_newFirstName);
            _modifiedDriver.setLastName(_newLastName);
            _modifiedDriver.setSex(_newSex);
            _modifiedDriver.setAge(_newAge);
            _modifiedDriver.setIsAvailable(_newIsAvailable);
            _modifiedDriver.setCarID(_newCarID);

            // Storing the newly modified driver under the same ID.
            userDatabase.put(userID_, _modifiedDriver);

            return _modifiedDriver;
        } catch (NullPointerException e_) {
            throw new DriverNotFoundException("Driver not found in database. UserID = " + userID_);
        } catch (Exception e_) {
            throw new InvalidUserArgumentsException("Invalid number of arguments passed in ModifyDriver.");
        }
    }
    /* @formatter:on */

    /**
     * Helper method to modify a specific customer from the database.
     * 
     * @param userID_
     *            The ID of the user to be modified.
     * @param newValues_
     *            Expected input values specified under MODIFY_USER_CUSTOMER_FORMAT
     *            in RuntimeConstants.
     * @return _newCustomer The newly modified customer.
     * @throws CustomerNotFoundException
     * @throws InvalidUserArgumentsException
     */
    /* @formatter:off */
    private Customer modifyCustomer(int userID_, ArrayList<String> newValues_) 
            throws CustomerNotFoundException, InvalidUserArgumentsException {
        try {
            // Getting the values from input.
            // userID and userType obtained from modifyUser. (i.e. .get(0) and .get(1))
            String _newFirstName = newValues_.get(2);
            String _newLastName = newValues_.get(3);
            String _newSex = newValues_.get(4);
            int _newAge = Integer.parseInt(newValues_.get(5));

            // Setting the modified customer values. Should be customer (ClassCastException otherwise).
            Customer _modifiedCustomer = (Customer) userDatabase.remove(userID_);
            _modifiedCustomer.setFirstName(_newFirstName);
            _modifiedCustomer.setLastName(_newLastName);
            _modifiedCustomer.setSex(_newSex);
            _modifiedCustomer.setAge(_newAge);

            // Storing the newly modified customer under the same ID.
            userDatabase.put(userID_, _modifiedCustomer);

            return _modifiedCustomer;
        } catch (NullPointerException e_) {
            throw new CustomerNotFoundException("Customer not found in database. UserID = " + userID_);
        } catch (Exception e_) {
            throw new InvalidUserArgumentsException("Invalid number of arguments passed in ModifyCustomer.");
        }
    }
    /* @formatter:on */
}
