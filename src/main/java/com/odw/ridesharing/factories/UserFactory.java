package com.odw.ridesharing.factories;

import com.odw.ridesharing.exceptions.InvalidUserArgumentsException;
import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.UserType;
import com.odw.ridesharing.model.abstractmodel.AbstractUser;

/**
 * UserFactory is called by UserController to create a User object which can either be a Customer or Driver. The Users
 * share the userID which is instantiated in this class and assigned to the User as they are created.
 */
public class UserFactory {
    
    private int nextUserID = 0;
    
    /**
     * Creates an subclass instance of an AbstractUser (either driver or customer) based on the passed in parameters.
     * 
     * @param userType_
     *            The type of user to create. Can be either a Driver or Customer.
     * @param firstName_
     *            The first name of the user.
     * @param lastName_
     *            The last name of the user.
     * @param sex_
     *            The sex of the user.
     * @param age_
     *            The age of the user.
     * @return Returns the newly created user object.
     * @throws InvalidUserArgumentsException
     */
    public AbstractUser buildUser(UserType userType_, String firstName_, String lastName_, String sex_, int age_)
        throws InvalidUserArgumentsException {
        
        if (firstName_ == null || firstName_.equals("")) {
            throw new InvalidUserArgumentsException("Bad first name. Value passed: "
                                                    + (firstName_ == null ? "NULL" : firstName_));
        }
        
        if (lastName_ == null || lastName_.equals("")) {
            throw new InvalidUserArgumentsException("Bad last name. Value passed: "
                                                    + (lastName_ == null ? "NULL" : lastName_));
        }
        
        if (sex_ == null || sex_.equals("")) {
            throw new InvalidUserArgumentsException("Bad sex. Value passed: " + (sex_ == null ? "NULL" : sex_));
        }
        
        if (age_ < 0) {
            throw new InvalidUserArgumentsException("Bad age. Value passed: " + Integer.toString(age_));
        }
        
        // Create a concrete implementation of User based on userType_ input.
        switch (userType_) {
            case CUSTOMER:
                return new Customer(nextUserID++, firstName_, lastName_, sex_, age_);
            case DRIVER:
                return new Driver(nextUserID++, firstName_, lastName_, sex_, age_);
            default:
                throw new InvalidUserArgumentsException("Unable to determine user type. Value passed: "
                                                        + userType_.toString());
        }
    }
    
}
