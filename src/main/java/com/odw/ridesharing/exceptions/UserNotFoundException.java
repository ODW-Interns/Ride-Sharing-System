package com.odw.ridesharing.exceptions;

/**
 * 
 * Throw when user is not found in the database
 *
 */
public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = 5994166669202486744L;

    /**
     * [TODO]
     * @param message_
     */
    public UserNotFoundException(String message_) {
        super(message_);

    }

}
