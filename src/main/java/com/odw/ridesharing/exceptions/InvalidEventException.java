package com.odw.ridesharing.exceptions;

/**
 * Thrown when Event cannot be parsed.
 */
public class InvalidEventException extends Exception {

    private static final long serialVersionUID = 4681756768366057326L;
    
    /**
     * [TODO]
     * @param message_
     */
    public InvalidEventException(String message_) {
        super(message_);
    }

}
