package com.odw.ridesharing.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.Pickup;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.exceptions.CannotSchedulePickupException;
import com.odw.ridesharing.model.exceptions.InvalidPickupArgumentsException;

/**
 * PickupController is called by CommandController to handle the
 * commands done on Pickup. PickupController calls PickupFactory to 
 * create a Pickup. PickupController also handles scheduling of the 
 * Pickups and calculates the rate/fees associated with the Pickup based
 * off of the distance traveled.
 */
public class PickupController {

    private ConcurrentHashMap<Integer, Pickup> pickupDatabase = new ConcurrentHashMap<Integer, Pickup>();
    private PickupFactory pickupFactory = new PickupFactory();
    private PickupScheduler pickupScheduler = new PickupScheduler();

    /**
     * Call PickupFactory to create a pickup. Immediately schedules the pickup to
     * the next available driver. See command controller.
     * 
     * @param typeValues_
     *            Expected input values specified under CREATE_PICKUP_FORMAT in
     *            RuntimeConstants.
     * @return _pickup pickup object to be used for logger
     * @throws InvalidPickupArgumentsException
     */
    /* @formatter:off */
    public Pickup createPickup(ArrayList<String> typeValues_, Customer pickupCustomer_, Driver pickupDriver_)
     throws InvalidPickupArgumentsException, CannotSchedulePickupException {
        if (typeValues_.size() == RuntimeConstants.CREATE_PICKUP_FORMAT.length && pickupCustomer_ != null) {
            try {
                // Creating the pickup through the factory. No driver is assigned yet.
                Pickup _newPickup = pickupFactory.buildPickup(typeValues_, pickupCustomer_);
                
                // Scheduling the pickup obtained from the factory.
                // If a driver is available he/she is immediately assigned.
                // Otherwise the pickup is null.
                Pickup _scheduledPickup = pickupScheduler.schedulePickup(_newPickup, pickupDriver_);
                
                if (_scheduledPickup != null) {
                    // Adding the scheduled pickup to the database. Pickup is done.
                    return storePickupInDatabase(_scheduledPickup);
                }
                
                // Pickup was unable to be scheduled.
                throw new CannotSchedulePickupException();
            
            } catch (InvalidPickupArgumentsException e_) {
                throw new InvalidPickupArgumentsException();
            }
        }

        // Something went wrong creating a pickup..
        throw new InvalidPickupArgumentsException();
    }
    /* @formatter:on */

    /**
     * Returns a string of all the pickup in pickupDatabase.
     * 
     * @return A list string of all the pickup in the database
     */
    public String getPickupHistoryAsString() {
        if (!pickupDatabase.isEmpty()) {
            StringBuilder _result = new StringBuilder();

            for (Map.Entry<Integer, Pickup> _entry : pickupDatabase.entrySet()) {
                Pickup _currentPickup = _entry.getValue();

                _result.append(System.lineSeparator() + _currentPickup.toString());
            }

            return _result.toString();
        }

        return "";
    }
    
    /**
     * Returns the pickupScheduler object.
     * @return pickupScheduler object
     */
    public PickupScheduler getPickupScheduler() {
        return pickupScheduler;
    }
    
    /**
     * Stores the pickup into the pickup database
     * @param pickupToStore_
     * @return the pickup that was stored in the database
     */
    public Pickup storePickupInDatabase(Pickup pickupToStore_) {
        pickupDatabase.put(pickupToStore_.getPickupID(), pickupToStore_);
        return pickupToStore_;
    }

    // DEPRECATED!
    /**
     * Modify Pickup's info in the database
     * 
     * @param typeValues_
     *            ArrayList of of input in string Should Contain PickupID,
     *            CustomerID, DriverID, Origin, and Destination
     * 
     * @return _currentPickup Object to be used for logger
     * @throws BadPickupException
     */
    /*----------------------------------------------------------------------------------------------------
    public Pickup modifyPickup(ArrayList<String> typeValues_) throws BadPickupException {
        if (typeValues_.size() == RuntimeConstants.MODIFY_PICKUP_FORMAT.length) {
            int _pickupIdx = Integer.parseInt(typeValues_.get(0));
            int _newCustomerIdx = Integer.parseInt(typeValues_.get(1));
            int _newDriverIdx = Integer.parseInt(typeValues_.get(2));
            double _newOriginLatitude = Double.parseDouble(typeValues_.get(3));
            double _newOriginLongitude = Double.parseDouble(typeValues_.get(4));
            double _newDestinationLatitude = Double.parseDouble(typeValues_.get(5));
            double _newDestinationLongitude = Double.parseDouble(typeValues_.get(6));
            Location _newOrigin = new Location(_newOriginLatitude, _newOriginLongitude);
            Location _newDestination = new Location(_newDestinationLatitude, _newDestinationLongitude);
    
            Pickup _currentPickup = pickupDatabase.get(_pickupIdx);
            if (_currentPickup != null) {
                _currentPickup.setCustomerID(_newCustomerIdx);
                _currentPickup.setDriverID(_newDriverIdx);
                _currentPickup.setOrigin(_newOrigin);
                _currentPickup.setDestination(_newDestination);
    
                return _currentPickup;
            } else
                throw new BadPickupException();
    
        }
    
        // Something went wrong..
        throw new BadPickupException();
    }
    ----------------------------------------------------------------------------------------------------*/

    // DEPRECATED!
    /**
     * Delete Pickup's info in the database
     * 
     * @param typeValues_
     *            ArrayList of of input in string Should Contain PickupID
     * @return pickupDatabase.remove(_idx) The object to be removed, will be used
     *         for logger
     * @throws BadPickupException
     */
    /*----------------------------------------------------------------------------------------------------
    public Pickup deletePickup(ArrayList<String> typeValues_) throws BadPickupException {
        if (typeValues_.size() == RuntimeConstants.DELETE_PICKUP_FORMAT.length) {
            int _idx = Integer.parseInt(typeValues_.get(0));
            try {
                return pickupDatabase.remove(_idx);
            } catch (NullPointerException e_) {
                throw new BadPickupException();
            }
        }
    
        // Something went wrong..
        throw new BadPickupException();
    }
    ----------------------------------------------------------------------------------------------------*/

}
