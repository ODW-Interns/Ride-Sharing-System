package com.odw.ridesharing.service;

import java.util.LinkedList;
import java.util.Queue;

import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.Location;
import com.odw.ridesharing.model.Pickup;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.exceptions.CannotSchedulePickupException;

/**
 * 
 *
 */
public class PickupScheduler {

    private Queue<Pickup> unscheduledPickupQueue = new LinkedList<>();

    /**
     * Assigns an available driver to the pickup.
     * 
     * @param pickupToSchedule_
     * @param driverForPickup_
     * @return
     * @throws CannotSchedulePickupException
     */
    public Pickup schedulePickup(Pickup pickupToSchedule_, Driver driverForPickup_)
            throws CannotSchedulePickupException {
        if (pickupToSchedule_ != null) {
            // If driver is null, no available driver is available to be scheduled.
            if (driverForPickup_ == null) {
                // Storing unscheduled pickup.
                unscheduledPickupQueue.add(pickupToSchedule_);
            } else {
                if (unscheduledPickupQueue.isEmpty()) {
                    // Assigning the driver to the pickup.
                    pickupToSchedule_.setDriver(driverForPickup_);

                    return calculatePickupCost(pickupToSchedule_);
                } else {
                    // Unscheduled pickups still exist. Scheduling oldest first in FCFS manner.

                    // Storing current pickup for later scheduling.
                    unscheduledPickupQueue.add(pickupToSchedule_);

                    // Getting the oldest unscheduled pickup.
                    Pickup _nextPickup = unscheduledPickupQueue.remove();

                    // Pickup's original driver was unavailable. Setting to current.
                    _nextPickup.setDriver(driverForPickup_);

                    return calculatePickupCost(_nextPickup);
                }
            }
        }

        // Something went wrong..
        throw new CannotSchedulePickupException();
    }

    // TODO: Finish these comments.
    /**
     * Returns pickup with newly calculated cost.
     * 
     * @param currentPickup_
     * @return
     * @throws CannotSchedulePickupException
     */
    private Pickup calculatePickupCost(Pickup currentPickup_) throws CannotSchedulePickupException {
        if (currentPickup_ != null) {
            Location _origin = currentPickup_.getOrigin();
            Location _destination = currentPickup_.getDestination();

            double _tripCost = _origin.distanceTo(_destination) * RuntimeConstants.CHARGE_RATE_PER_MILE;

            currentPickup_.setPickupCost(_tripCost + RuntimeConstants.FLAT_RATE_FEE);

            return currentPickup_;
        }

        throw new CannotSchedulePickupException();
    }
}
