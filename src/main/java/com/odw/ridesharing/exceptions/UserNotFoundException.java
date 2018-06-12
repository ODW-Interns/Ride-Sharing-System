package com.odw.ridesharing.exceptions;

/**
 * 
 * Throw when user is not found in the database
 *
 */
public class UserNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 5994166669202486744L;

    /**
     *
     */
    public UserNotFoundException() {
    }

    /**
     *
     */
    public UserNotFoundException(String message_) {
        super(message_);

    }

    /**
     *
     */
    public UserNotFoundException(Throwable cause_) {
        super(cause_);

    }

    /**
     *
     */
    public UserNotFoundException(String message_, Throwable cause_) {
        super(message_, cause_);

    }

    /**
     *
     */
    public UserNotFoundException(String message_, Throwable cause_, boolean enableSuppression_,
            boolean writableStackTrace_) {
        super(message_, cause_, enableSuppression_, writableStackTrace_);

    }

}
