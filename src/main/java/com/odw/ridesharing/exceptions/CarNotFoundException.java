package com.odw.ridesharing.exceptions;

/**
 * Thrown when car is not found in the database
 */
public class CarNotFoundException extends Exception {

    private static final long serialVersionUID = -7182344539016320569L;
    
    /**
     * [TODO]
     * @param message_
     */
    public CarNotFoundException(String message_) {
        super(message_);
    }

}
