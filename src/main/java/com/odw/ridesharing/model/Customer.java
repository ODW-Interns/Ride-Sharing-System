package com.odw.ridesharing.model;

import com.odw.ridesharing.model.abstractmodel.AbstractUser;

/**
 * Customer is a concrete AbstractUser that represents the User requesting a Pickup.
 */
public class Customer extends AbstractUser {
    
    /**
     * Creates a default, empty Customer.
     */
    public Customer() {
        this(-1, "", "", "", -1);
    }
    
    /**
     * Creates a Customer with a specified id, first name, last name, sex, and age.
     * 
     * @param userID_
     *            Customer's userID
     * @param firstName_
     *            Customer's first name
     * @param lastName_
     *            Customer's last name
     * @param sex_
     *            Customer's sex
     * @param age_
     *            Customer's age
     */
    public Customer(int userID_, String firstName_, String lastName_, String sex_, int age_) {
        super(userID_, firstName_, lastName_, sex_, age_);
    }
    
}
