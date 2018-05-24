package com.odw.ridesharing.model.exceptions;

public class InvalidPickupArgumentsException extends Exception {

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
