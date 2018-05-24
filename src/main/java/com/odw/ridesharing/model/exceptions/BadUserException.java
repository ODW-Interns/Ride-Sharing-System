package com.odw.ridesharing.model.exceptions;

public class BadUserException extends Exception {
    
    /**
     *
     */
    public BadUserException() {
    }

    /**
     *
     */
    public BadUserException(String message_) {
        super(message_);

    }

    /**
     *
     */
    public BadUserException(Throwable cause_) {
        super(cause_);

    }

    /**
     *
     */
    public BadUserException(String message_, Throwable cause_) {
        super(message_, cause_);

    }

    /**
     *
     */
    public BadUserException(String message_, Throwable cause_, boolean enableSuppression_,
            boolean writableStackTrace_) {
        super(message_, cause_, enableSuppression_, writableStackTrace_);

    }

}
