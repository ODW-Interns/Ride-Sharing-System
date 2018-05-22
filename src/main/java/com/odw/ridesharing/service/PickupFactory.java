package com.odw.ridesharing.service;

import java.util.ArrayList;

import com.odw.ridesharing.model.Location;
import com.odw.ridesharing.model.Pickup;

public class PickupFactory {
    
    private int nextPickupID = 0;
    
    /**
     * 
     * @param typeValues_ 
     * 
     * NOTE: typeValues_ format (as an ArrayList)
     *      Values: | carID | customerID | driverID | origin_x | origin_y | 
     *      Index:  | 0     | 1          | 2        | 3        | 4        |
     *      
     *      Values: | destination_x | destination_y|
     *      Index:  | 5             | 6            |
     *      
     * @return a Pickup object with a pickupID attached to it
     */
    public Pickup createPickup(ArrayList<String> typeValues_) {
        
        // get the values from the ArrayList
        int _carID = Integer.parseInt(typeValues_.get(0));
        int _customerID = Integer.parseInt(typeValues_.get(1));
        int _driverID = Integer.parseInt(typeValues_.get(2));
        double _originLongitude = Double.parseDouble(typeValues_.get(3));
        double _originLatitude = Double.parseDouble(typeValues_.get(4));
        double _destinationLongitude = Double.parseDouble(typeValues_.get(5));
        double _destinationLatitude = Double.parseDouble(typeValues_.get(6));
        
        // set the origin and destination to be used for Pickup
        Location _origin = new Location(_originLongitude, _originLatitude);
        Location _destination = new Location(_destinationLongitude, _destinationLatitude);
        
        //create a new Pickup object
        return new Pickup(nextPickupID++, _carID, _customerID, _driverID,
                _origin, _destination);
    }

}
