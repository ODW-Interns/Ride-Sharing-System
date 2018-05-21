package com.odw.ridesharing.service;

import java.util.ArrayList;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.User;

public class UserFactory {
    
    private int nextUserID = 0;
    
    /**
     * 
     * @param typeValues_
     * 
     * NOTE: typeValues_ format (as an ArrayList):
     *      Values: Customer | FirstName | LastName | Sex | Age | \n
     *      Index:  0        | 1        | 2         | 3   | 4   |
     *      
     *      Values: Driver | FName | LName | Sex | Age | isAvail | CarID | \n
     *      Index:  0      | 1     | 2     | 3   | 4   | 5       | 6     | 
     * @return
     */
    public User createUser(ArrayList<String> typeValues_) {
        
        String _userType = typeValues_.get(0);
        String _firstName = typeValues_.get(1);
        String _lastName = typeValues_.get(2);
        String _sex = typeValues_.get(3);
        int _age = Integer.parseInt(typeValues_.get(4));
        
        // get the userType
        switch (_userType) {
            case UserController.CUSTOMER:        
                return new Customer(_firstName, _lastName, _sex, _age, nextUserID++);
                
            case UserController.DRIVER:
                boolean _isAvailable = Boolean.parseBoolean(typeValues_.get(5));
                int _carID = Integer.parseInt(typeValues_.get(6));
                
                return new Driver(_firstName, _lastName, _sex, _age, nextUserID++, _isAvailable, _carID);
                
            default:
                return null;
        }
        
    }

}
