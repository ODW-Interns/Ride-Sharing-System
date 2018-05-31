package com.odw.ridesharing.model.exceptions;

/**
 * 
 *Throw when the argument passed for create/modify/delete pickup is not valid
 *
 */
public class InvalidPickupArgumentsException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -9087921797036782598L;

    /**
     *
     */
    public InvalidPickupArgumentsException() {
    }

    /**
     *
     */
    public InvalidPickupArgumentsException(String message_) {
        super(message_);

    }

    /**
     *
     */
    public InvalidPickupArgumentsException(Throwable cause_) {
        super(cause_);

    }

    /**
      *
      */
    public InvalidPickupArgumentsException(String message_, Throwable cause_) {
        super(message_, cause_);

    }

    /**
      *
      */
    public InvalidPickupArgumentsException(String message_, Throwable cause_, boolean enableSuppression_,
            boolean writableStackTrace_) {
        super(message_, cause_, enableSuppression_, writableStackTrace_);

    }
}
