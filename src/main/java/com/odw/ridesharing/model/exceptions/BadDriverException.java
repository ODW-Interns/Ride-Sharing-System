package com.odw.ridesharing.model.exceptions;

public class BadDriverException extends Exception {
    
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
