package com.odw.ridesharing.service;

import java.util.ArrayList;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.User;

public class UserFactory {
    
    private int nextUserID = 0;
    
    /**
     * 
     * @param typeValues_
     * 
     * NOTE: typeValues_ format (as an ArrayList):
     *      Values: Customer | FirstName | LastName | Sex | Age |
     *      Index:  0        | 1         | 2        | 3   | 4   |
     *      
     *      Values: Driver | FName | LName | Sex | Age | isAvail | CarID |
     *      Index:  0      | 1     | 2     | 3   | 4   | 5       | 6     | 
     * @return
     */
    public User createUser(ArrayList<String> typeValues_) {
        
        String _userType = typeValues_.get(0);
        String _firstName = typeValues_.get(1);
        String _lastName = typeValues_.get(2);
        String _sex = typeValues_.get(3);
        int _age = Integer.parseInt(typeValues_.get(4));
        
        switch (_userType) {
            case RuntimeConstants.CUSTOMER:        
                return new Customer(nextUserID++, _firstName, _lastName, _sex, _age);
            case RuntimeConstants.DRIVER:
                return new Driver(nextUserID++, _firstName, _lastName, _sex, _age);
            default:
                return null;
        }
        
    }

}
