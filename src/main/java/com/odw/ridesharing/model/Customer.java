package com.odw.ridesharing.model;

import com.odw.ridesharing.model.abstractmodel.AbstractUser;

/**
 * Customer is a concrete User that represents the User requesting a
 * Pickup.
 */
public class Customer extends AbstractUser {
   
    private AbstractUser customer;
    
    /**
     * default constructor: Creates a new customer which is an empty Person
     */
    public Customer() {
        this(-1, "", "", "", -1);
    }
    
    /**
     * Creates a customer and give it an ID
     */
    /*public Customer(User customer_) {
        setCustomer(customer_);
    }*/
    public Customer(int userID_, String firstName_, String lastName_, String sex_, int age_)  {
        super(userID_, firstName_, lastName_, sex_, age_);
    }
    
    /**
     * (non-Javadoc)
     * @see com.odw.ridesharing.model.InputType#getType()
     */
    
    /* Setters and Getters */
    /**
     * Get the customer
     * 
     * @return The customer to be executed
     */
    public AbstractUser getCustomer() {
        return customer;
    }
    
    /**
     * Set the customer
     * 
     * @param The new customer to be set
     */
    public void setCustomer(AbstractUser customer_) {
        this.customer = customer_;
    }

    
}
