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
     *      Values: | customerID | origin_x | origin_y | destination_x |
     *      Index:  | 0          | 1        | 2        | 3             |
     *      
     *      Values: | destination_y | driverID | driverFirstName | driverLastName |
     *      Index:  | 4             | 5        | 6               | 7              |
     *      
     * @return a Pickup object with a pickupID attached to it
     */
    public Pickup createPickup(ArrayList<String> typeValues_) {
        
        // get the values from the ArrayList
        int _customerID = Integer.parseInt(typeValues_.get(0));
        double _originLongitude = Double.parseDouble(typeValues_.get(1));
        double _originLatitude = Double.parseDouble(typeValues_.get(2));
        double _destinationLongitude = Double.parseDouble(typeValues_.get(3));
        double _destinationLatitude = Double.parseDouble(typeValues_.get(4));
        int _driverID = Integer.parseInt(typeValues_.get(5));
        String _driverFirstName = typeValues_.get(6);
        String _driverLastName = typeValues_.get(7);
        
        // set the origin and destination to be used for Pickup
        Location _origin = new Location(_originLongitude, _originLatitude);
        Location _destination = new Location(_destinationLongitude, _destinationLatitude);
        
        //create a new Pickup object
        return new Pickup(nextPickupID++, _customerID, _origin, _destination, 
                _driverID, _driverFirstName, _driverLastName);
    }

}
