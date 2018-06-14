package com.odw.ridesharing.exceptions;

/**
 * 
 *Thrown when the arguments passed for create/modify/delete pickup is not valid.
 *
 */
public class InvalidPickupArgumentsException extends Exception {

    private static final long serialVersionUID = -9087921797036782598L;
    
    /**
     * [TODO]
     * @param message_
     */
    public InvalidPickupArgumentsException(String message_) {
        super(message_);
    }
    
}
