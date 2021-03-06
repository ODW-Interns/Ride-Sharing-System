package com.odw.ridesharing.controllers;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.odw.ridesharing.exceptions.CannotSchedulePickupException;
import com.odw.ridesharing.exceptions.InvalidPickupArgumentsException;
import com.odw.ridesharing.exceptions.PickupNotFoundException;
import com.odw.ridesharing.factories.PickupFactory;
import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.Pickup;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.service.PickupScheduler;

/**
 * PickupController is called by CommandController to handle the commands done on Pickup. PickupController calls
 * PickupFactory to create a Pickup. PickupController also handles scheduling of the Pickups and calculates the
 * rate/fees associated with the Pickup based off of the distance traveled.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PickupController {
    
    private ConcurrentHashMap<Integer, Pickup> pickupDatabase = new ConcurrentHashMap<Integer, Pickup>();
    
    @XmlTransient
    private PickupFactory pickupFactory = new PickupFactory();
    
    @XmlTransient
    private PickupScheduler pickupScheduler = new PickupScheduler();
    
    /**
     * Creates a pickup by calling PickupFactory.
     * 
     * @param typeValues_
     *            Expected input values specified under CREATE_PICKUP_FORMAT in RuntimeConstants.
     * @return Returns the newly created pickup object.
     * @throws InvalidPickupArgumentsException
     */
    public Pickup createPickup(ArrayList<String> typeValues_, Customer pickupCustomer_)
        throws InvalidPickupArgumentsException {
        
        if (typeValues_.size() == RuntimeConstants.CREATE_PICKUP_FORMAT.length) {
            try {
                double _originLatitude = Double.parseDouble(typeValues_.get(1));
                double _originLongitude = Double.parseDouble(typeValues_.get(2));
                double _destinationLatitude = Double.parseDouble(typeValues_.get(3));
                double _destinationLongitude = Double.parseDouble(typeValues_.get(4));
                
                // Creating the pickup through the factory. No driver is assigned yet.
                return pickupFactory.buildPickup(_originLatitude,
                                                 _originLongitude,
                                                 _destinationLatitude,
                                                 _destinationLongitude,
                                                 pickupCustomer_);
            } catch (Exception e_) {
                throw new InvalidPickupArgumentsException(e_.getMessage());
            }
        }
        
        throw new InvalidPickupArgumentsException("Invalid number of arguments for create pickup. " + "Expected: "
                                                  + RuntimeConstants.CREATE_PICKUP_FORMAT.length + ", Actual: "
                                                  + typeValues_.size());
    }
    
    /**
     * Delete Pickup's info from the database.
     * 
     * @param typeValues_
     *            Expected input values specified under DELETE_PICKUP_FORMAT in RuntimeConstants.
     * @return The pickup that was removed from the database.
     * @throws InvalidPickupArgumentsException
     * @throws BadPickupException
     */
    public Pickup deletePickup(ArrayList<String> typeValues_)
        throws PickupNotFoundException, InvalidPickupArgumentsException {
        
        if (typeValues_.size() == RuntimeConstants.DELETE_PICKUP_FORMAT.length) {
            try {
                // Get the pickup ID from input.
                int _pickupID = Integer.parseInt(typeValues_.get(0));
                
                Pickup _deletedPickup = pickupDatabase.remove(_pickupID);
                
                if (_deletedPickup == null) {
                    throw new PickupNotFoundException("Cannot delete a pickup that does not exist. PickupID = "
                                                      + _pickupID);
                }
                
                return _deletedPickup;
                
            } catch (NumberFormatException e_) {
                throw new InvalidPickupArgumentsException(e_.getMessage());
            }
        }
        
        throw new InvalidPickupArgumentsException("Invalid number of arguments for delete pickup. " + "Expected: "
                                                  + RuntimeConstants.DELETE_PICKUP_FORMAT.length + ", Actual: "
                                                  + typeValues_.size());
    }
    
    /**
     * Returns a string of all the pickup in pickupDatabase.
     * 
     * @return A list string of all the pickup in the database
     */
    public String getPickupDatabaseAsString() {
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
     * Stores the pickup into the pickup history database. Should only store scheduled pickups.
     * 
     * @param pickupToStore_
     *            The scheduled pickup to store in the database.
     */
    public void storePickupInDatabase(Pickup pickupToStore_) {
        if (pickupToStore_ != null) {
            pickupDatabase.put(pickupToStore_.getPickupID(), pickupToStore_);
        }
    }
    
    /**
     * A method to be called to schedule a pickup.
     * 
     * @param pickup_
     *            The pickup that was created.
     * @param driver_
     *            The next available driver if there is one.
     * @return A pickup with its driver set to driver_ and fees calculated
     * @throws CannotSchedulePickupException
     */
    public Pickup schedulePickup(Pickup pickup_, Driver driver_) throws CannotSchedulePickupException {
        return pickupScheduler.schedulePickup(pickup_, driver_);
    }
    
    /**
     * A function to be called in CommandController to schedule a pickup that is in the pickup queue.
     * 
     * @param driver_
     *            The driver whose availability was modified from false to true
     * @return A pickup with its driver set to driver_ and fees calculated. Null if there are no unscheduledPickups
     */
    public Pickup scheduleUnscheduledPickup(Driver driver_) {
        return pickupScheduler.scheduleUnscheduledPickup(driver_);
    }
    
    // DEPRECATED!
    /**
     * Modify Pickup's info in the database
     * 
     * @param typeValues_
     *            ArrayList of of input in string Should Contain PickupID, CustomerID, DriverID, Origin, and Destination
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
    
}
