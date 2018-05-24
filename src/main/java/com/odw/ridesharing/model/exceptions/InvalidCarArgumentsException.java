package com.odw.ridesharing.model.exceptions;

public class InvalidCarArgumentsException extends Exception {

    /**
     *
     */
    public InvalidCarArgumentsException() {
    }

    /**
     *
     */
    public InvalidCarArgumentsException(String message_) {
        super(message_);

    }

    /**
     *
     */
    public InvalidCarArgumentsException(Throwable cause_) {
        super(cause_);

    }

    /**
     *
     */
    public InvalidCarArgumentsException(String message_, Throwable cause_) {
        super(message_, cause_);

    }

    /**
     *
     */
    public InvalidCarArgumentsException(String message_, Throwable cause_, boolean enableSuppression_,
            boolean writableStackTrace_) {
        super(message_, cause_, enableSuppression_, writableStackTrace_);

    }
}
