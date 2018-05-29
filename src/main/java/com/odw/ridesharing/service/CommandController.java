package com.odw.ridesharing.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.odw.ridesharing.model.*;
import com.odw.ridesharing.model.abstractmodel.*;
import com.odw.ridesharing.model.exceptions.*;

/**
 * CommandController is called by the Main function to process the events
 * CREATE, MODIFY, and DELETE on objects CAR (Coupe/Sedan/SUV), USER
 * (Customer/Driver), or PICKUP. CommandController calls the respective
 * controllers for each object to handle the commands. CommandController calls
 * EventParser to parse the file line-by-line into events.
 */
public class CommandController {

    private CarController carController = new CarController();
    private UserController userController = new UserController();
    private PickupController pickupController = new PickupController();
    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    /**
     * Processes a file line-by-line by parsing each line into an event and
     * performing each event. Can be considered as the application's "starting
     * point".
     * 
     * @param fileName_
     *            The file name and path to process.
     * @param delimiter_
     *            The delimiter used in the file to separate values.
     */
    /* @formatter:off */
    public void processFile(String fileName_, String delimiter_) {
        EventParser _eventParser = new EventParser();

        try (BufferedReader _inputReader = new BufferedReader(
                                            new InputStreamReader(
                                             new FileInputStream(fileName_)))) {    
            logger.trace("=============== Processing File: " + fileName_ + " ===============");
            
            // Process each event line-by-line.
            String _nextLine = null;
            while ((_nextLine = _inputReader.readLine()) != null) {
                try {
                    Event _nextEvent = _eventParser.parseEvent(_nextLine, delimiter_);
                    processEvent(_nextEvent);
                } catch (InvalidEventException e_) {
                    logger.error("Could not parse the given event: \"" + _nextLine + "\"");
                }
            }

            // File reading complete. Print out the inventory.
            logger.debug("FINAL CAR INVENTORY:" + carController.getCarInventoryAsString());
            logger.debug("FINAL USER DATABASE:" + userController.getUserDatabaseAsString());
            logger.debug("PICKUP HISTORY:" + pickupController.getPickupHistoryAsString());
        } catch (FileNotFoundException e_) {
            logger.error("Could not find the specified file.");
        } catch (IOException e_) {
            logger.error("Something went wrong while reading the file.");
        }        
    }
    /* @formatter:on */

    /**
     * Helper function for processFile. Decodes the current event's command.
     * 
     * @param newEvent_
     *            The current event to be decoded
     */
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

    /**
     * Helper function for processEvent. Decodes the input type to create.
     * 
     * @param event_
     *            The current event to be decoded.
     */
    private void create(Event event_) {
        switch (event_.getInputType()) {
            case RuntimeConstants.CAR: {
                try {
                    Car _addedCar = carController.createCar(event_.getTypeValues());
                    logger.info("CREATED CAR = " + _addedCar.toString());
                } catch (InvalidCarArgumentsException e_) {
                    logger.error("There was a problem with adding car: " + event_.typeValuesToString());
                }
                break;
            }
            case RuntimeConstants.USER: {
                try {
                    User _addedUser = userController.createUser(event_.getTypeValues());
                    if (_addedUser instanceof Driver) {
                        logger.info("CREATED DRIVER = " + _addedUser.toString());
                    } else if (_addedUser instanceof Customer) {
                        logger.info("CREATED CUSTOMER = " + _addedUser.toString());
                    }
                } catch (InvalidUserArgumentsException e_) {
                    logger.error(
                            "The argument passed are not valid; unable to add user: " + event_.typeValuesToString());
                }
                break;
            }
            /* @formatter:off */
            case RuntimeConstants.PICKUP: {
                try {
                    // Getting this input field early. Error handling handled in catch blocks.
                    int _customerID = Integer.parseInt(event_.getTypeValues().get(0));
                    
                    // Obtained from input.
                    Customer _pickupCustomer = userController.getCustomerByID(_customerID);
                    
                    // Driver to be scheduled is chosen by the userController.
                    Driver _scheduledDriver = userController.getNextAvailableDriver();
                    
                    Pickup _addedPickup = pickupController.createPickup(event_.getTypeValues(),
                                                                        _pickupCustomer,
                                                                        _scheduledDriver);

                    logger.info("CREATED PICKUP = " + _addedPickup.toString());

                } catch (CannotSchedulePickupException e_) {
                    logger.info("No available driver for pickup: " + event_.typeValuesToString() + " (Will attempt to reschedule ASAP)");
                } catch (InvalidPickupArgumentsException e_) {
                    logger.error("There was a problem with creating pickup: " + event_.typeValuesToString());
                } catch (CustomerNotFoundException e_) {
                    logger.error("Pickup customerID " + event_.getTypeValues().get(0) + " does not exist in the user database.");
                } catch (NumberFormatException e_) {
                    logger.error("CustomerID is not integer parseable. Check input format.");
                } catch (IndexOutOfBoundsException e_) {
                    logger.error("Could not get customerID from input. Is it specified in the input?");
                }
                break;
            }
            /* @formatter:on */
            default:
                logger.error("Error: Invalid input type.");
                break;
        }
    }

    /**
     * Helper function for processEvent. Decodes the input type to modify.
     * 
     * @param event_
     *            The current event to be decoded.
     */
    private void modify(Event event_) {
        switch (event_.getInputType()) {
            case RuntimeConstants.CAR: {
                try {
                    Car _modifiedCar = carController.modifyCar(event_.getTypeValues());
                    logger.info("MODIFIED CAR = " + _modifiedCar.toString());
                } catch (CarNotFoundException e_) {
                    logger.error("There was a problem with modifying car: " + event_.typeValuesToString());
                } catch (InvalidCarArgumentsException e_) {
                    logger.error("There was a problem with modifying car: " + event_.typeValuesToString());
                }
                break;
            }
            case RuntimeConstants.USER: {
                try {
                    if (event_.getTypeValues().get(1).equals(RuntimeConstants.DRIVER)) {
                        int _carID = Integer.parseInt(event_.getTypeValues().get(8));
                        carController.getCarByID(_carID);
                    }
                    
                    User _modifiedUser = userController.modifyUser(event_.getTypeValues());
                    logger.info("MODIFIED USER: " + _modifiedUser.toString());
                } catch (CarNotFoundException e_) {
                    logger.error("There was a problem with modifying driver's car; car does not exist: "
                            + event_.typeValuesToString("|"));
                } catch (CustomerNotFoundException e_) {
                    logger.error("There was a problem with modifying customer; customer does not exist: "
                            + event_.typeValuesToString("|"));
                } catch (DriverNotFoundException e_) {
                    logger.error("There was a problem with modifying driver; driver does not exist: "
                            + event_.typeValuesToString("|"));
                } catch (InvalidUserArgumentsException e_) {
                    logger.error(
                            "The argument passed are not valid; unable to modify user: " + event_.typeValuesToString());
                }
                break;
            }

            // ----- DEPRECATED! -----
            /*
             * case RuntimeConstants.PICKUP: { try { Pickup modifiedPickup =
             * pickupController.modifyPickup(event_.getTypeValues());
             * logger.debug("MODIFIED PICKUP: " + modifiedPickup.toString()); } catch
             * (BadPickupException e_) {
             * logger.error("There was a problem with modifying pickup: " +
             * event_.typeValuesToString("|")); } break; }
             */
            // -----------------------

            default:
                logger.error("Error: Invalid input type.");
                break;
        }
    }

    /**
     * Helper function for processEvent. Decodes the input type to delete.
     * 
     * @param event_
     *            The current event to be decoded.
     */
    private void delete(Event event_) {
        switch (event_.getInputType()) {
            case RuntimeConstants.CAR: {
                try {
                    Car deletedCar = carController.deleteCar(event_.getTypeValues());
                    logger.info("DELETED CAR = " + deletedCar.toString());
                } catch (CarNotFoundException e_) {
                    logger.error("There was a problem deleting car: " + event_.typeValuesToString());
                }
                break;
            }
            case RuntimeConstants.USER: {
                try {
                    User _deletedUser = userController.deleteUser(event_.getTypeValues());
                    logger.info("DELETED USER: " + _deletedUser.toString());
                } catch (UserNotFoundException e_) {
                    logger.error("There was a problem deleting user: " + event_.typeValuesToString());
                }
                break;
            }

            // ----- DEPRECATED! -----
            /*
             * case RuntimeConstants.PICKUP: { try { Pickup deletedPickup =
             * pickupController.deletePickup(event_.getTypeValues());
             * logger.debug("DELETED PICKUP: " + deletedPickup.toString()); } catch
             * (BadPickupException e_) {
             * logger.error("There was a problem with deleting pickup: " +
             * event_.typeValuesToString("|")); } break; }
             */
            // -----------------------

            default:
                logger.error("Error: Invalid input type.");
                break;
        }
    }
}
