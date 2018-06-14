package com.odw.ridesharing.exceptions;

/**
 * Thrown when SchedulePickup cannot be scheduled
 */
public class CannotSchedulePickupException extends Exception {
    
    private static final long serialVersionUID = 4469601577329763359L;
    
    /**
     * [TODO]
     * @param message_
     */
    public CannotSchedulePickupException(String message_) {
        super(message_);   
    }
    
}
