package com.odw.ridesharing.model;

import com.odw.ridesharing.model.InputType.Type;

public class Customer extends InputType {

    private static int nextID = 0;
    
    private int customerID;
    private Person customer;
    
    public Customer() {
        this(new Person());
    }
    
    public Customer(Person customer_) {
        setCustomer(customer_);
        
        customerID = Customer.nextID++;
    }
    
    @Override
    public Type getType() {
        return InputType.Type.CUSTOMER;
    }
    
    /* Setters and Getters */
    public Person getCustomer() {
        return customer;
    }
    public void setCustomer(Person customer_) {
        this.customer = customer_;
    }

    
}
