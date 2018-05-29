package com.odw.ridesharing.model.exceptions;

public class DriverNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 416154890178631578L;

    /**
     *
     */
    public DriverNotFoundException() {
    }

    /**
     *
     */
    public DriverNotFoundException(String message_) {
        super(message_);

    }

    /**
     *
     */
    public DriverNotFoundException(Throwable cause_) {
        super(cause_);

    }

    /**
     *
     */
    public DriverNotFoundException(String message_, Throwable cause_) {
        super(message_, cause_);

    }

    /**
     *
     */
    public DriverNotFoundException(String message_, Throwable cause_, boolean enableSuppression_,
            boolean writableStackTrace_) {
        super(message_, cause_, enableSuppression_, writableStackTrace_);

    }

}
