package com.odw.ridesharing.exceptions;

/**
 * Thrown when the arguments passed for create/modify/delete user is not valid
 */
public class InvalidUserArgumentsException extends Exception {
    
    private static final long serialVersionUID = 3313711250466662808L;
    
    /**
     * [TODO]
     * @param message_
     */
    public InvalidUserArgumentsException(String message_) {
        super(message_);
        
    }
    
}
