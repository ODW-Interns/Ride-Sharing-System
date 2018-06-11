package com.odw.ridesharing.service;

import java.util.LinkedList;
import java.util.Queue;

import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.Location;
import com.odw.ridesharing.model.Pickup;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.exceptions.CannotSchedulePickupException;

/**
 * PickupScheduler is called by PickupController to perform the scheduling of trips. PickupScheduler has a queue for
 * pickups where there is no available driver and will be accessed when a modify driver event is finished. Once a pickup
 * is scheduled, the driver is assigned to the pickup and the trip cost is calculated.
 */
public class PickupScheduler {
    
    private Queue<Pickup> unscheduledPickupQueue = new LinkedList<>();
    
    /**
     * Schedules the specified pickup to the specified driver. Called when a pickup is created.
     * 
     * @param pickupToSchedule_
     *            The pickup to be scheduled.
     * @param driverForPickup_
     *            The driver to be assigned to the pickup. Null if no available driver.
     * @return The pickup with the specified driver scheduled.
     * @throws CannotSchedulePickupException
     */
    /* @formatter:off */
    public Pickup schedule(Pickup pickupToSchedule_, Driver driverForPickup_)
     throws CannotSchedulePickupException {
        // pickupToSchedule_ should always be non-null.
        if (pickupToSchedule_ != null) {
            
            // If driver is null, no available driver is available to be scheduled.
            if (driverForPickup_ == null) {
                
                // Storing unscheduled pickup.
                unscheduledPickupQueue.add(pickupToSchedule_);
                
                // Pickup will be scheduled as soon as a driver is made available.
                // Do not schedule for now.
                return null;
            } else {
                // Assigning the driver to the pickup.
                return performPickup(pickupToSchedule_, driverForPickup_);
            }
        }
        
        // Something went wrong..
        throw new CannotSchedulePickupException();
    }
    /* @formatter:on */
    
    /**
     * Called if and only if a driver has been set to available.
     * 
     * @param driverForPickup_
     *            The the most recent driver that has been made available for pickup.
     * @return An unscheduled pickup scheduled to a driver.
     */
    public Pickup getUnscheduledPickup(Driver driverForPickup_) {
        if (!unscheduledPickupQueue.isEmpty()) {
            // Scheduling an unscheduled pickup.
            return performPickup(unscheduledPickupQueue.remove(), driverForPickup_);
        }
        
        // Currently, no unscheduled pickups to be scheduled.
        return null;
    }
    
    /**
     * Helper function to schedule a pickup.
     * 
     * @param pickupToSchedule_
     *            The pickup to be scheduled.
     * @param driverForPickup_
     *            The driver to be assigned for the pickup.
     * @return The newly scheduled pickup.
     */
    private Pickup performPickup(Pickup pickupToSchedule_, Driver driverForPickup_) {
        // pickupToSchedule_ and driverForPickup_ are always expected to be non-null.
        if (pickupToSchedule_ != null && driverForPickup_ != null) {
            
            // Assigning a driver to the pickup.
            pickupToSchedule_.setDriver(driverForPickup_);
            
            // Setting the pickup cost based on our pre-defined formula.
            Location _origin = pickupToSchedule_.getOrigin();
            Location _destination = pickupToSchedule_.getDestination();
            double _tripCost = _origin.distanceTo(_destination) * RuntimeConstants.CHARGE_RATE_PER_MILE;
            pickupToSchedule_.setPickupCost(_tripCost + RuntimeConstants.FLAT_RATE_FEE);
            
            return pickupToSchedule_;
        }
        
        // Something went wrong performing the pickup. Should not execute.
        return null;
    }
}
