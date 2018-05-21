package com.odw.ridesharing.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.User;
import com.odw.ridesharing.model.exceptions.BadCarException;
import com.odw.ridesharing.model.exceptions.BadUserException;

public class UserController {

	public static final String DRIVER = "driver";
	public static final String CUSTOMER = "customer";

	private ConcurrentHashMap<Integer, User> userDatabase;
	private UserFactory userFactory;

	/*
	 * Default Constructor
	 */
	public UserController() {
		userDatabase = new ConcurrentHashMap<Integer, User>();
		userFactory = new UserFactory();
	}

	/**
	 * Add user to the userDatabase 
	 * 
	 * @param typeValue_
	 * @throws BadUserException
	 */
	public void createUser(ArrayList<String> typeValue_) throws BadUserException {
		User _user = userFactory.createUser(typeValue_);

		// Valid car IDs are non-negative.
		if (_user.getUserID() >= 0) {
			userDatabase.put(_user.getUserID(), _user);
		} else {
			throw new BadUserException();
		}
	}

	/**
	 * Modify user that is currently in the userDatabase
	 * 
	 * @param typeValues
	 * @throws BadCarException
	 */
	public void modifyUser(ArrayList<String> typeValues) throws BadCarException {
		int _idx = Integer.parseInt(typeValues.get(0));
		User _user = userDatabase.get(_idx);

		if (_idx > -1) {
			if (typeValues.get(1) == DRIVER) {
				Driver _driver = (Driver) _user;
				if (_user.getUserID() == _idx) {
					_user.setFirstName(typeValues.get(2));
					_user.setLastName(typeValues.get(3));
					_user.setSex(typeValues.get(4));
					_user.setAge(Integer.parseInt(typeValues.get(5)));
					_driver.setRating(Integer.parseInt(typeValues.get(6)));
					_driver.setIsAvailable(Boolean.parseBoolean(typeValues.get(7)));
					_driver.setCarID(Integer.parseInt(typeValues.get(8)));

				} else
					throw new BadCarException();
			} else {
				//Customer _customer = (Customer) _user;
				if (_user.getUserID() == _idx) {
					_user.setFirstName(typeValues.get(2));
					_user.setLastName(typeValues.get(3));
					_user.setSex(typeValues.get(4));
					_user.setAge(Integer.parseInt(typeValues.get(5)));
				} else
					throw new BadCarException();
			}
		} else
			throw new BadCarException();
	}

	/**
	 * Delete user from the database 
	 * 
	 * @param typeValues
	 * @throws BadCarException
	 */
	public void deleteUser(ArrayList<String> typeValues) throws BadCarException {

		int _idx = Integer.parseInt(typeValues.get(1));
		User _user = userDatabase.get(_idx);
		if (_idx > -1) {
			if (_user.getUserID() == _idx)
				userDatabase.remove(_idx);
			else
				throw new BadCarException();
		} else
			throw new BadCarException();
	}

	/**
	 * Returns a string of all the users in userDatabase.
	 * 
	 * @return TODO
	 */
	public String getUserDatabase() {
		if (userDatabase.size() > 0) {
			StringBuilder _result = new StringBuilder();

			for (Map.Entry<Integer, User> _entry : userDatabase.entrySet()) {

				User _currentUser = _entry.getValue();
				if (_currentUser instanceof Driver) {
					Driver _currentDriver = (Driver) _currentUser;
					_result.append(_currentDriver.toString() + System.lineSeparator());
				} else
					_result.append(_currentUser.toString() + System.lineSeparator());

			}

			return _result.toString();
		}

		return "";
	}
}
