package com.odw.ridesharing.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.Event;
import com.odw.ridesharing.model.Pickup;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.User;
import com.odw.ridesharing.model.exceptions.BadCarException;
import com.odw.ridesharing.model.exceptions.BadPickupException;
import com.odw.ridesharing.model.exceptions.BadUserException;

public class CommandController {

    // TODO: Document

    private CarController carController = new CarController();
    private UserController userController = new UserController();
    private PickupController pickupController = new PickupController();
    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    public void processFile(String fileName_, String delimiter_) {
        EventParser _eventParser = new EventParser();

        /* @formatter:off */
        try (BufferedReader _inputReader = new BufferedReader(
                                            new InputStreamReader(
                                             new FileInputStream(fileName_)))) {    
            // Process each event line-by-line.
            String _nextLine = null;
            while ((_nextLine = _inputReader.readLine()) != null) {
                Event _nextEvent = _eventParser.parseEvent(_nextLine, delimiter_);
                processEvent(_nextEvent);
            }

            // SUCCESS!
            logger.debug(carController.getCarInventoryAsString());
            logger.debug(userController.getUserDatabaseAsString());
        } catch (FileNotFoundException e_) {
            logger.error("Could not find the specified file.");
        } catch (IOException e_) {
            logger.error("Something went wrong while reading the file.");
        }
        /* @formatter:on */
    }

    private void processEvent(Event newEvent_) {
        switch (newEvent_.getCommand()) {
            case RuntimeConstants.CREATE:
                create(newEvent_);
                break;
            case RuntimeConstants.MODIFY:
                modify(newEvent_);
                break;
            case RuntimeConstants.DELETE:
                delete(newEvent_);
                break;
            default:
                logger.error("Error: Invalid command.");
                break;
        }
    }

    private void create(Event event_) {
        switch (event_.getInputType()) {
            case RuntimeConstants.CAR: {
                try {
                    Car _addedCar = carController.createCar(event_.getTypeValues());
                    logger.debug("CREATED CAR: " + _addedCar.toString());
                } catch (BadCarException e_) {
                    logger.error("There was a problem with adding car: " + event_.typeValuesToString("|"));
                }
                break;
            }
            case RuntimeConstants.USER: {
                try {
                    User _addedUser = userController.createUser(event_.getTypeValues());
                    logger.debug("CREATED USER: " + _addedUser.toString());
                } catch (BadUserException e_) {
                    logger.error("There was a problem with creating user: " + event_.typeValuesToString("|"));
                }
                break;
            }
            case RuntimeConstants.PICKUP: {
                try {
                    Pickup _addedPickup = pickupController.createPickup(event_.getTypeValues(),
                            userController.getNextAvailableDriver());
                    logger.debug("CREATED PICKUP: " + _addedPickup.toString());
                } catch (BadPickupException e_) {
                    logger.error("There was a problem with creating pickup: " + event_.typeValuesToString("|"));
                }
                break;
            }
            default:
                logger.error("Error: Invalid input type.");
                break;
        }
    }

    private void modify(Event event_) {
        switch (event_.getInputType()) {
            case RuntimeConstants.CAR: {
                try {
                    Car modifiedCar = carController.modifyCar(event_.getTypeValues());
                    logger.debug("MODIFIED CAR: " + modifiedCar.toString());
                } catch (BadCarException e_) {
                    logger.error("There was a problem with modifying car: " + event_.typeValuesToString("|"));
                }
                break;
            }
            case RuntimeConstants.USER: {
                try {
                    User modifiedUser = userController.modifyUser(event_.getTypeValues());
                    logger.debug("MODIFIED USER: " + modifiedUser.toString());
                } catch (BadUserException e_) {
                    logger.error("There was a problem with modifying user: " + event_.typeValuesToString("|"));
                }
                break;
            }
            
            // ----- DEPRECATED! -----
            case RuntimeConstants.PICKUP: {
                try {
                    Pickup modifiedPickup = pickupController.modifyPickup(event_.getTypeValues());
                    logger.debug("MODIFIED PICKUP: " + modifiedPickup.toString());
                } catch (BadPickupException e_) {
                    logger.error("There was a problem with modifying pickup: " + event_.typeValuesToString("|"));
                }
                break;
            }
            // -----------------------
            
            default:
                logger.error("Error: Invalid input type.");
                break;
        }
    }

    private void delete(Event event_) {
        switch (event_.getInputType()) {
            case RuntimeConstants.CAR: {
                try {
                    Car deletedCar = carController.deleteCar(event_.getTypeValues());
                    logger.debug("DELETED CAR: " + deletedCar.toString());
                } catch (BadCarException e_) {
                    logger.error("There was a problem deleting car: " + event_.typeValuesToString("|"));
                }
                break;
            }
            case RuntimeConstants.USER: {
                try {
                    User _deletedUser = userController.deleteUser(event_.getTypeValues());
                    logger.debug("DELETED USER: " + _deletedUser.toString());
                } catch (BadUserException e_) {
                    logger.error("There was a problem deleting user: " + event_.typeValuesToString("|"));
                }
                break;
            }
            
            // ----- DEPRECATED! -----
            case RuntimeConstants.PICKUP: {
                try {
                    Pickup deletedPickup = pickupController.deletePickup(event_.getTypeValues());
                    logger.debug("DELETED PICKUP: " + deletedPickup.toString());
                } catch (BadPickupException e_) {
                    logger.error("There was a problem with deleting pickup: " + event_.typeValuesToString("|"));
                }
                break;
            }
            // -----------------------
            
            default:
                logger.error("Error: Invalid input type.");
                break;
        }
    }
}
