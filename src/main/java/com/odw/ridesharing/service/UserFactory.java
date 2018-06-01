package com.odw.ridesharing.service;

import java.util.ArrayList;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.abstractmodel.User;
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
    public User buildUser(ArrayList<String> typeValues_) throws InvalidUserArgumentsException {
        if (typeValues_.size() == RuntimeConstants.CREATE_USER_FORMAT.length()) {
            try {
                String _userType = typeValues_.get(RuntimeConstants.CREATE_USER_FORMAT.USER_TYPE.value());
                String _firstName = typeValues_.get(RuntimeConstants.CREATE_USER_FORMAT.FIRST_NAME.value());
                String _lastName = typeValues_.get(RuntimeConstants.CREATE_USER_FORMAT.LAST_NAME.value());
                String _sex = typeValues_.get(RuntimeConstants.CREATE_USER_FORMAT.SEX.value());
                int _age = Integer.parseInt(typeValues_.get(RuntimeConstants.CREATE_USER_FORMAT.AGE.value()));

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
