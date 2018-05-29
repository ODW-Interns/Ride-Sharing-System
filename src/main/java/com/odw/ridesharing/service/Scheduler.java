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
public class Scheduler {

    private static Queue<Pickup> queue = new LinkedList<>();

    /**
     * 
     * @param p_
     * @param d_
     * @return
     * @throws CannotSchedulePickupException
     */
    public static Pickup schedulePickup(Pickup p_, Driver d_) throws CannotSchedulePickupException {

        Pickup _nextPickup;

        if (p_ != null) {
            if (d_ == null)
                queue.add(p_);
            else {
                if (queue.isEmpty()) {
                    return schedule(p_);
                } else {
                    queue.add(p_);
                    _nextPickup = queue.remove();
                    _nextPickup.setDriver(d_);
                    return schedule(_nextPickup);
                }
            }

            return null;
        }

        throw new CannotSchedulePickupException();
    }

    /**
     * 
     * @param currentPickup_
     * @return
     * @throws CannotSchedulePickupException
     */
    private static Pickup schedule(Pickup currentPickup_) throws CannotSchedulePickupException {
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
