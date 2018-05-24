package com.odw.ridesharing.model.exceptions;

public class BadDriverException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 416154890178631578L;

    /**
     *
     */
    public BadDriverException() {
    }

    /**
     *
     */
    public BadDriverException(String message_) {
        super(message_);

    }

    /**
     *
     */
    public BadDriverException(Throwable cause_) {
        super(cause_);

    }

    /**
     *
     */
    public BadDriverException(String message_, Throwable cause_) {
        super(message_, cause_);

    }

    /**
     *
     */
    public BadDriverException(String message_, Throwable cause_, boolean enableSuppression_,
            boolean writableStackTrace_) {
        super(message_, cause_, enableSuppression_, writableStackTrace_);

    }

}
