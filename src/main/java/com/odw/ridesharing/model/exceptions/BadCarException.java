package com.odw.ridesharing.model.exceptions;

public class BadCarException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -7182344539016320569L;

    /**
     *
     */
    public BadCarException() {
    }

    /**
     *
     */
    public BadCarException(String message_) {
        super(message_);

    }

    /**
     *
     */
    public BadCarException(Throwable cause_) {
        super(cause_);

    }

    /**
     *
     */
    public BadCarException(String message_, Throwable cause_) {
        super(message_, cause_);

    }

    /**
     *
     */
    public BadCarException(String message_, Throwable cause_, boolean enableSuppression_, boolean writableStackTrace_) {
        super(message_, cause_, enableSuppression_, writableStackTrace_);

    }

}
