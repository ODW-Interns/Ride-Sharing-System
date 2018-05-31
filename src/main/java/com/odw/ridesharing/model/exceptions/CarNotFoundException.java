package com.odw.ridesharing.model.exceptions;

/**
 * 
 * Throw when car is not found in the database
 *
 */
public class CarNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -7182344539016320569L;

    /**
     *
     */
    public CarNotFoundException() {
    }

    /**
     *
     */
    public CarNotFoundException(String message_) {
        super(message_);

    }

    /**
     *
     */
    public CarNotFoundException(Throwable cause_) {
        super(cause_);

    }

    /**
     *
     */
    public CarNotFoundException(String message_, Throwable cause_) {
        super(message_, cause_);

    }

    /**
     *
     */
    public CarNotFoundException(String message_, Throwable cause_, boolean enableSuppression_,
            boolean writableStackTrace_) {
        super(message_, cause_, enableSuppression_, writableStackTrace_);

    }

}
