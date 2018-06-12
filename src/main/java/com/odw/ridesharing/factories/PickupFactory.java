package com.odw.ridesharing.factories;

import com.odw.ridesharing.exceptions.InvalidPickupArgumentsException;
import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Location;
import com.odw.ridesharing.model.Pickup;

/**
 * PickupFactory is called by CommandController to create a Pickup object. PickupFactory is passed in a Customer and
 * Driver along with the latitude and longitude to create a Pickup object. The pickupID is instantiated in this class
 * and is assigned to the Pickup objects as they are created.
 */
public class PickupFactory {
    
    private int nextPickupID = 0;
    
    /**
     * Creates a new pickup.
     * 
     * @param originLongitude_
     *            The starting position's longitude.
     * @param originLatitude_
     *            The starting positions latitude.
     * @param destinationLongitude_
     *            The final position's longitude.
     * @param destinationLatitude_
     *            The final position's latidude.
     * @throws InvalidPickupArgumentsException
     */
    public Pickup buildPickup(double originLatitude_, double originLongitude_, double destinationLatitude_,
                              double destinationLongitude_,
                              Customer pickupCustomer_) throws InvalidPickupArgumentsException {
        if (pickupCustomer_ != null) {
            // Set the origin and destination to be used for Pickup.
            Location _origin = new Location(originLatitude_, originLongitude_);
            Location _destination = new Location(destinationLatitude_, destinationLongitude_);
            
            // Create a new Pickup object
            return new Pickup(nextPickupID++, pickupCustomer_, _origin, _destination);
        }
        
        throw new InvalidPickupArgumentsException("Cannot create a pickup without a customer.");
    }
    
}
