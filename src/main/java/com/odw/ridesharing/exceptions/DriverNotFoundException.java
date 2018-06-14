package com.odw.ridesharing.exceptions;

/**
 * Thrown when a driver does not exist in the database.
 */
public class DriverNotFoundException extends Exception {

    private static final long serialVersionUID = 416154890178631578L;
    
    /**
     * [TODO]
     * @param message_
     */
    public DriverNotFoundException(String message_) {
        super(message_);
    }

}
