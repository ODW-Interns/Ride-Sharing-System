package com.odw.ridesharing.model;

import com.odw.ridesharing.model.abstractmodel.User;

public class Customer extends User {
   
    private User customer;
    
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
    public User getCustomer() {
        return customer;
    }
    
    /**
     * Set the customer
     * 
     * @param The new customer to be set
     */
    public void setCustomer(User customer_) {
        this.customer = customer_;
    }

    
}
