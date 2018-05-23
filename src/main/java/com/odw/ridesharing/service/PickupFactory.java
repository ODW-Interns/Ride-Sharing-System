package com.odw.ridesharing.service;

import java.util.ArrayList;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.Location;
import com.odw.ridesharing.model.Pickup;

public class PickupFactory {
    
    private int nextPickupID = 0;
    
    /* @formatter:off */
    /**
     * 
     * @param typeValues_ 
     * 
     * NOTE: typeValues_ format (as an ArrayList)
     *      Values: | customerID | origin_x | origin_y | destination_x | destination_y |
     *      Index:  | 0          | 1        | 2        | 3             | 4             |
     *      
     * @return a Pickup object with a pickupID attached to it
     */
    /* @formatter:on */
    public Pickup createPickup(ArrayList<String> typeValues_, Customer pickupCustomer_, Driver pickupDriver_) {
        
        // Get the values from input
        // Ignoring .get(0) because that's passed under pickupCustomer_
        double _originLongitude = Double.parseDouble(typeValues_.get(1));
        double _originLatitude = Double.parseDouble(typeValues_.get(2));
        double _destinationLongitude = Double.parseDouble(typeValues_.get(3));
        double _destinationLatitude = Double.parseDouble(typeValues_.get(4));
        
        // Set the origin and destination to be used for Pickup.
        Location _origin = new Location(_originLongitude, _originLatitude);
        Location _destination = new Location(_destinationLongitude, _destinationLatitude);
        
        //create a new Pickup object
        return new Pickup(nextPickupID++, pickupCustomer_, pickupDriver_, _origin, _destination);
    }

}
