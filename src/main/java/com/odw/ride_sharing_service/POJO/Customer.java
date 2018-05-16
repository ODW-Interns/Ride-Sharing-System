package com.odw.ride_sharing_service.POJO;

public class Customer {

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
    
    /* Setters and Getters */
    public Person getCustomer() {
        return customer;
    }
    public void setCustomer(Person customer_) {
        this.customer = customer_;
    }

    
}
