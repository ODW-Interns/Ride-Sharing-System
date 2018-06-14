package com.odw.ridesharing.exceptions;

/**
 * Thrown when the arguments passed for create/modify/delete car is not valid
 */
public class InvalidCarArgumentsException extends Exception {

    private static final long serialVersionUID = 2823368122118207360L;
    
    /**
     * [TODO]
     * @param message_
     */
    public InvalidCarArgumentsException(String message_) {
        super(message_);

    }
    
}
