package com.odw.ridesharing.service;

import java.util.ArrayList;

import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Location;
import com.odw.ridesharing.model.Pickup;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.exceptions.InvalidPickupArgumentsException;

/**
 * PickupFactory is called by CommandController to create a Pickup object.
 * PickupFactory is passed in a Customer and Driver along with the latitude and
 * longitude to create a Pickup object. The pickupID is instantiated in this
 * class and is assigned to the Pickup objects as they are created.
 */
public class PickupFactory {

    private int nextPickupID = 0;

    /* @formatter:off */
    /**
     * 
     * 
     * 
     * @param typeValues_ The input values of the following format:
     * NOTE: typeValues_ format (as an ArrayList)
     *      Values: | customerID | origin_x | origin_y | destination_x | destination_y |
     *      Index:  | 0          | 1        | 2        | 3             | 4             |
     * 
     * @param pickupCustomer_ The customer requesting the pickup. Cannot be null.
     * @return a Pickup object with a pickupID attached to it
     * @throws InvalidPickupArgumentsException 
     */
    public Pickup buildPickup(ArrayList<String> typeValues_, Customer pickupCustomer_)
     throws InvalidPickupArgumentsException {
        if (typeValues_.size() == RuntimeConstants.CREATE_PICKUP_FORMAT.length && pickupCustomer_ != null) {
            try {
                // Get the values from input
                // Ignoring .get(0) because the userID is a field of pickupCustomer_
                double _originLongitude = Double.parseDouble(typeValues_.get(1));
                double _originLatitude = Double.parseDouble(typeValues_.get(2));
                double _destinationLongitude = Double.parseDouble(typeValues_.get(3));
                double _destinationLatitude = Double.parseDouble(typeValues_.get(4));

                // Set the origin and destination to be used for Pickup.
                Location _origin = new Location(_originLongitude, _originLatitude);
                Location _destination = new Location(_destinationLongitude, _destinationLatitude);

                // create a new Pickup object
                return new Pickup(nextPickupID++,
                                  pickupCustomer_,
                                  _origin,
                                  _destination);
            } catch (NullPointerException e_) {
                throw new InvalidPickupArgumentsException();
            } catch (NumberFormatException e_) {
                throw new InvalidPickupArgumentsException();
            }
        }

        // Something went wrong creating a pickup..
        throw new InvalidPickupArgumentsException();
    }
    /* @formatter:on */
}
