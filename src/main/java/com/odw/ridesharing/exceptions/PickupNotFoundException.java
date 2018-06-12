package com.odw.ridesharing.exceptions;

/**
 * 
 * Throw when pickup is not found in the database
 *
 */
public class PickupNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -7182344539016320569L;

    /**
     *
     */
    public PickupNotFoundException() {
    }

    /**
     *
     */
    public PickupNotFoundException(String message_) {
        super(message_);

    }

    /**
     *
     */
    public PickupNotFoundException(Throwable cause_) {
        super(cause_);

    }

    /**
     *
     */
    public PickupNotFoundException(String message_, Throwable cause_) {
        super(message_, cause_);

    }

    /**
     *
     */
    public PickupNotFoundException(String message_, Throwable cause_, boolean enableSuppression_, boolean writableStackTrace_) {
        super(message_, cause_, enableSuppression_, writableStackTrace_);

    }

}
