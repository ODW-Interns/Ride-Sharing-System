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
     * Schedules the specified available driver to the pickup.
     * 
     * @param pickupToSchedule_
     *            The pickup to be scheduled.
     * @param driverForPickup_
     *            The driver to be assigned to the pickup. Null if no available
     *            driver.
     * @return The pickup with the specified driver scheduled.
     * @throws CannotSchedulePickupException
     */
    /* @formatter:off */
    public Pickup schedulePickup(Pickup pickupToSchedule_, Driver driverForPickup_)
            throws CannotSchedulePickupException {
        if (pickupToSchedule_ != null) {
            // If driver is null, no available driver is available to be scheduled.
            if (driverForPickup_ == null) {
                // Storing unscheduled pickup.
                unscheduledPickupQueue.add(pickupToSchedule_);
                return null;
            } else {
                // Assigning the driver to the pickup.
                schedule(pickupToSchedule_, driverForPickup_);
            }
        }
        // Something went wrong..
        throw new CannotSchedulePickupException();
    }

    /**
     * Called iff driver isAvailable is modified to true
     * 
     * @param d_
     *            the driver whose isAvailable was modified to true
     * @return schedule the new driver
     */
    public Pickup getUnscheduledPickup(Driver d_) {
        if (!unscheduledPickupQueue.isEmpty())
            return schedule(unscheduledPickupQueue.remove(), d_);
        return null;
    }

    /**
     * Helper function to set the updated driver and calculate trip cost.
     * 
     * @param p_
     *            the pickup to be scheduled
     * @param d_
     *            the driver to be updated for the pickup
     * @return the pickup cost
     */
    private Pickup schedule(Pickup p_, Driver d_) {
        p_.setDriver(d_);

        return calculatePickupCost(p_);
    }
    /* @formatter:on */

    /**
     * Returns the given pickup with its newly calculated cost.
     * 
     * @param currentPickup_
     *            The pickup to calculate the cost from.
     * @return The same pickup with it's cost field modified. Null if something went
     *         wrong.
     */
    private Pickup calculatePickupCost(Pickup currentPickup_) {
        // currentPickup_ guaranteed to be not null because it is checked in
        // schedulePickup(...)
        if (currentPickup_ != null) {
            Location _origin = currentPickup_.getOrigin();
            Location _destination = currentPickup_.getDestination();

            double _tripCost = _origin.distanceTo(_destination) * RuntimeConstants.CHARGE_RATE_PER_MILE;

            currentPickup_.setPickupCost(_tripCost + RuntimeConstants.FLAT_RATE_FEE);

            return currentPickup_;
        }

        // Something went wrong.. Should never reach this point.
        return null;
    }
}
