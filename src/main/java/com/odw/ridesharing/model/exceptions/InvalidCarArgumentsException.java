package com.odw.ridesharing.model.exceptions;

/**
 * 
 * Throw when the argument passed for create/modify/delete car is not valid
 *
 */
public class InvalidCarArgumentsException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 2823368122118207360L;

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
