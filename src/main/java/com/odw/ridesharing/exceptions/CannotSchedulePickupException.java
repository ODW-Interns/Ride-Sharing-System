package com.odw.ridesharing.exceptions;

/**
 * 
 * Throw when SchedulePickup cannot be scheduled
 *
 */
public class CannotSchedulePickupException extends Exception {
    
    /**
     * 
     */
    private static final long serialVersionUID = 4469601577329763359L;
    
    /**
    *
    */
    public CannotSchedulePickupException(String message_) {
        super(message_);
        
    }
    
    /**
    *
    */
    public CannotSchedulePickupException(Throwable cause_) {
        super(cause_);
        
    }
    
    /**
    *
    */
    public CannotSchedulePickupException(String message_, Throwable cause_) {
        super(message_, cause_);
        
    }
    
    /**
    *
    */
    public CannotSchedulePickupException(String message_, Throwable cause_, boolean enableSuppression_,
            boolean writableStackTrace_) {
        super(message_, cause_, enableSuppression_, writableStackTrace_);
        
    }
    
}
