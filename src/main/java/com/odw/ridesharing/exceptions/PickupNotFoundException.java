package com.odw.ridesharing.exceptions;

/**
 * 
 * Thrown when a pickup is not found in the database.
 *
 */
public class PickupNotFoundException extends Exception {
    
    private static final long serialVersionUID = -7182344539016320569L;
    
    /**
     * [TODO]
     * @param message_
     */
    public PickupNotFoundException(String message_) {
        super(message_);
        
    }
    
}
