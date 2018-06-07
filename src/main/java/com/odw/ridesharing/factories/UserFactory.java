package com.odw.ridesharing.factories;

import java.util.ArrayList;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.abstractmodel.AbstractUser;
import com.odw.ridesharing.model.exceptions.InvalidUserArgumentsException;

/**
 * UserFactory is called by UserController to create a User object which
 * can either be a Customer or Driver. The Users share the userID which is
 * instantiated in this class and assigned to the User as they are created.
 */
public class UserFactory {

    private int nextUserID = 0;

    /* @formatter:off */
    /**
     * 
     * @param typeValues_
     * 
     * NOTE: typeValues_ format (as an ArrayList):
     *      Values: Customer | FirstName | LastName | Sex | Age |
     *      Index:  0        | 1         | 2        | 3   | 4   |
     *      
     *      Values: Driver | FName | LName | Sex | Age | 
     *      Index:  0      | 1     | 2     | 3   | 4   | 
     * @return
     */
    /* @formatter:on */
    public AbstractUser buildUser(ArrayList<String> typeValues_) throws InvalidUserArgumentsException {
        if (typeValues_.size() == RuntimeConstants.CREATE_USER_FORMAT.length) {
            try {
                String _userType = typeValues_.get(0);
                String _firstName = typeValues_.get(1);
                String _lastName = typeValues_.get(2);
                String _sex = typeValues_.get(3);
                int _age = Integer.parseInt(typeValues_.get(4));

                // Create a concrete implementation of User based on userType input.
                switch (_userType) {
                    case RuntimeConstants.CUSTOMER:
                        return new Customer(nextUserID++, _firstName, _lastName, _sex, _age);
                    case RuntimeConstants.DRIVER:
                        return new Driver(nextUserID++, _firstName, _lastName, _sex, _age);
                    default:
                        return null;
                }
            } catch (Exception e_) {
                throw new InvalidUserArgumentsException();
            }

        }
        throw new InvalidUserArgumentsException();
    }

}
