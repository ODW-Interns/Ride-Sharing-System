package com.odw.ridesharing.factories;

import com.odw.ridesharing.exceptions.InvalidPickupArgumentsException;
import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Location;
import com.odw.ridesharing.model.Pickup;

/**
 * PickupFactory is called by PickupController to create a Pickup object. The factory pattern is used for Pickup for
 * consistency purposes (to mimic the other controllers) and for scalability.
 */
public class PickupFactory {
    
    private int nextPickupID = 0;
    
    /**
     * Creates a new pickup and assigns the created pickup to a unique ID.
     * 
     * @param originLongitude_
     *            The starting position's longitude.
     * @param originLatitude_
     *            The starting positions latitude.
     * @param destinationLongitude_
     *            The final position's longitude.
     * @param destinationLatitude_
     *            The final position's latitude.
     * @return Returns the newly created pickup object.
     * @throws InvalidPickupArgumentsException
     */
    public Pickup buildPickup(double originLatitude_,
                              double originLongitude_,
                              double destinationLatitude_,
                              double destinationLongitude_,
                              Customer pickupCustomer_)
        throws InvalidPickupArgumentsException {
        
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
