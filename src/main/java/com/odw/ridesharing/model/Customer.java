package com.odw.ridesharing.model;

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
    public Types getType() {
        return InputType.Types.CUSTOMER;
    }
    
    /* Setters and Getters */
    public Person getCustomer() {
        return customer;
    }
    public void setCustomer(Person customer_) {
        this.customer = customer_;
    }

    
}
