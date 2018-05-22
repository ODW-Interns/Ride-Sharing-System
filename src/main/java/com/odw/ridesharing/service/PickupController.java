package com.odw.ridesharing.service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.Location;
import com.odw.ridesharing.model.Pickup;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.exceptions.BadCarException;
import com.odw.ridesharing.model.exceptions.BadPickupException;

public class PickupController {

	private ConcurrentHashMap<Integer, Pickup> pickupDatabase = new ConcurrentHashMap<Integer, Pickup>();
	private PickupFactory pickupFactory = new PickupFactory();

	public Pickup createPickupr(ArrayList<String> typeValues_) throws BadPickupException {

		if (typeValues_.size() == RuntimeConstants.CREATE_PICKUP_FORMAT.length) {

			Pickup _pickup = pickupFactory.createPickup(typeValues_);
			pickupDatabase.put(_pickup.getPickupID(), _pickup);
			return _pickup;

		}

		throw new BadPickupException();
	}

	public Pickup modifyPickup(ArrayList<String> typeValues_) throws BadPickupException {

		if (typeValues_.size() == RuntimeConstants.MODIFY_PICKUP_FORMAT.length) {

			int _pickupIdx = Integer.parseInt(typeValues_.get(0));
			int _newCarIdx = Integer.parseInt(typeValues_.get(1));
			int _newCustomerIdx = Integer.parseInt(typeValues_.get(2));
			int _newDriverIdx = Integer.parseInt(typeValues_.get(3));
			double _newOriginx = Double.parseDouble(typeValues_.get(4));
			double _newOriginy = Double.parseDouble(typeValues_.get(5));
			double _newDestx = Double.parseDouble(typeValues_.get(6));
			double _newDesty = Double.parseDouble(typeValues_.get(7));
			Location _newOrigin = new Location(_newOriginx, _newOriginy);
			Location _newDest = new Location(_newDestx, _newDesty);

			Pickup _currentPickup = pickupDatabase.get(_pickupIdx);
			if (_currentPickup != null) {
				_currentPickup.setCarID(_newCarIdx);
				_currentPickup.setCustomerID(_newCustomerIdx);
				_currentPickup.setDriverID(_newDriverIdx);
				_currentPickup.setOrigin(_newOrigin);
				_currentPickup.setDestination(_newDest);

				return _currentPickup;
			} else
				throw new BadPickupException();

		} else
			throw new BadPickupException();
	}

	public Pickup deletePickup(ArrayList<String> typeValues_) throws BadPickupException {

		if (typeValues_.size() == RuntimeConstants.DELETE_PICKUP_FORMAT.length) {

			int _idx = Integer.parseInt(typeValues_.get(0));
			Pickup _currentPickup = pickupDatabase.get(_idx);

			try {
				return pickupDatabase.remove(_idx);
			} catch (NullPointerException e_) {
				throw new BadCarException();
			}

		} else
			throw new BadPickupException();
	}

}
