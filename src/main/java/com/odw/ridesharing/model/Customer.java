package com.odw.ridesharing.model;

public class Customer extends InputType {

    private static int nextID = 0;
    
    private int customerID;
    private Person customer;
    
    /* 
     * default constructor: Creates a new customer which is an empty Person
     */
    public Customer() {
        this(new Person());
    }
    
    /*
     * Creates a customer and give it an ID
     */
    public Customer(Person customer_) {
        setCustomer(customer_);
        
        customerID = Customer.nextID++;
    }
    
    /*
     * (non-Javadoc)
     * @see com.odw.ridesharing.model.InputType#getType()
     */
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
