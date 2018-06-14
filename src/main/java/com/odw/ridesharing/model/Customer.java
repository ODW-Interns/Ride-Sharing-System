package com.odw.ridesharing.model;

import com.odw.ridesharing.model.abstractmodel.AbstractUser;

/**
 * Customer is a concrete User that represents the User requesting a
 * Pickup.
 */
public class Customer extends AbstractUser {
    
    /**
     * Creates a default, empty Customer.
     */
    public Customer() {
        this(-1, "", "", "", -1);
    }
    
    
    /**
     * [TODO]
     * @param userID_
     * @param firstName_
     * @param lastName_
     * @param sex_
     * @param age_
     */
    public Customer(int userID_, String firstName_, String lastName_, String sex_, int age_)  {
        super(userID_, firstName_, lastName_, sex_, age_);
    }
    
}
