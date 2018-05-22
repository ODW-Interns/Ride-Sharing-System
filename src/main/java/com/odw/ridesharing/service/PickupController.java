package com.odw.ridesharing.service;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import com.odw.ridesharing.model.Location;
import com.odw.ridesharing.model.Pickup;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.exceptions.BadPickupException;

public class PickupController {

    private ConcurrentHashMap<Integer, Pickup> pickupDatabase = new ConcurrentHashMap<Integer, Pickup>();
    private PickupFactory pickupFactory = new PickupFactory();

    public Pickup createPickup(ArrayList<String> typeValues_) throws BadPickupException {
        if (typeValues_.size() == RuntimeConstants.CREATE_PICKUP_FORMAT.length) {
            Pickup _pickup = schedule(pickupFactory.createPickup(typeValues_));
            pickupDatabase.put(_pickup.getPickupID(), _pickup);
            return _pickup;
        }

        // Something went wrong..
        throw new BadPickupException();
    }

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

    private Pickup schedule(Pickup current_) {
        Location origin = current_.getOrigin();
        Location destination = current_.getDestination();
        
        current_.setTotalCost(origin.distanceTo(destination) * RuntimeConstants.CHARGE_RATE);
        
        return current_;
    }
}
