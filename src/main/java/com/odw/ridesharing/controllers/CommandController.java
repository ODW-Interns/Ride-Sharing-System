package com.odw.ridesharing.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.odw.ridesharing.exceptions.*;
import com.odw.ridesharing.model.*;
import com.odw.ridesharing.model.abstractmodel.*;
import com.odw.ridesharing.service.EventParser;

/**
 * CommandController is called by the Main function to process the events CREATE, MODIFY, and DELETE on objects CAR
 * (Coupe/Sedan/SUV), USER (Customer/Driver), or PICKUP. CommandController calls the respective controllers for each
 * object to handle the commands. CommandController calls EventParser to parse the file line-by-line into events.
 */
public class CommandController {
    
    private CarController carController = new CarController();
    private UserController userController = new UserController();
    private PickupController pickupController = new PickupController();
    private Logger logger = LoggerFactory.getLogger("Main Logger");
    
    /**
     * Processes a file line-by-line by parsing each line into an event and performing each event. Information is stored
     * internally in the controllers.
     * 
     * @param inputFile_
     *            The input file name and path to process.
     * @param delimiter_
     *            The delimiter used in the file to separate values.
     */
    public void processFile(String inputFile_, String delimiter_) {
        EventParser _eventParser = new EventParser();
        
        try (BufferedReader _inputReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile_)))) {
            logger.trace("PROCESSING FILE: {}", inputFile_);
            
            // Process each event line-by-line.
            String _nextLine = null;
            while ((_nextLine = _inputReader.readLine()) != null) {
                try {
                    Event _nextEvent = _eventParser.parseEvent(_nextLine, delimiter_);
                    processEvent(_nextEvent);
                } catch (InvalidEventException e_) {
                    logger.error("ERROR PARSING EVENT = \"{}\"", _nextLine);
                }
            }
            
            // File reading complete. Print out the database.
            logger.debug("FINAL CAR DATABASE" + "{}", carController.getCarDatabaseAsString());
            logger.debug("FINAL USER DATABASE" + "{}", userController.getUserDatabaseAsString());
            logger.debug("FINAL PICKUP HISTORY" + "{}", pickupController.getPickupDatabaseAsString());
        } catch (FileNotFoundException e_) {
            logger.error("ERROR READING FILE: {}", e_.getMessage());
        } catch (IOException e_) {
            logger.error("ERROR READING FILE: {}", e_.getMessage());
        }
    }
    
    /**
     * Exports the current state of the databases in XML format to the specified output directory.
     * 
     * @param outputDirectory_
     *            The output directory to export the databases to.
     */
    public void exportDatabasesToXML(String outputDirectory_) {
        if (outputDirectory_ == null) {
            outputDirectory_ = RuntimeConstants.DEFAULT_OUTPUT_DIRECTORY;
        }
        
        try {
            // Note: We're using JAXB here mainly for educational purposes and experience.
            // Whether or not this is a good application for JAXB is not considered for this project.
            
            // File reading complete. Use JAXB to generate XML to the specified files below.
            File carDatabaseOutputFile = new File(outputDirectory_ + "car-database.xml");
            File userDatabaseOutputFile = new File(outputDirectory_ + "user-database.xml");
            File pickupDatabaseOutputFile = new File(outputDirectory_ + "pickup-database.xml");
            
            /* @formatter:off */
            JAXBContext jaxbContext = JAXBContext.newInstance(CarController.class,
                                                              UserController.class,
                                                              PickupController.class);
            /* @formatter:on */
            
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            // Exporting the current database's state in XML format to the files specified above.
            jaxbMarshaller.marshal(carController, carDatabaseOutputFile);
            jaxbMarshaller.marshal(userController, userDatabaseOutputFile);
            jaxbMarshaller.marshal(pickupController, pickupDatabaseOutputFile);
            
            logger.info("EXPORTED DATABASE TO FILE: {}", carDatabaseOutputFile.getAbsolutePath());
            logger.info("EXPORTED DATABASE TO FILE: {}", userDatabaseOutputFile.getAbsolutePath());
            logger.info("EXPORTED DATABASE TO FILE: {}", pickupDatabaseOutputFile.getAbsolutePath());
        } catch (JAXBException e_) {
            logger.error("ERROR MARSHALLING DATABASE: {}", e_.getMessage());
        }
    }
    
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
                logger.error("ERROR PROCESSING COMMAND: Invalid command.");
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
            case RuntimeConstants.CAR:
                try {
                    AbstractCar _addedCar = carController.createCar(event_.getTypeValues());
                    logger.info("CREATED CAR = {}", _addedCar);
                } catch (Exception e_) {
                    logger.error("ERROR CREATING CAR: " + e_.getMessage());
                }
                break;
            case RuntimeConstants.USER:
                try {
                    AbstractUser _addedUser = userController.createUser(event_.getTypeValues());
                    if (_addedUser instanceof Driver) {
                        logger.info("CREATED DRIVER = {}", _addedUser);
                    } else if (_addedUser instanceof Customer) {
                        logger.info("CREATED CUSTOMER = {}", _addedUser);
                    }
                } catch (InvalidUserArgumentsException e_) {
                    logger.error("ERROR CREATING USER: {}", e_.getMessage());
                }
                break;
            case RuntimeConstants.PICKUP:
                try {
                    // Getting this input field early. Error handling handled in catch blocks.
                    int _customerID = Integer.parseInt(event_.getTypeValues().get(0));
                    
                    // Obtained from input.
                    Customer _pickupCustomer = userController.getCustomerByID(_customerID);
                    
                    // Create a pickup but do not schedule it yet.
                    Pickup _createdPickup = pickupController.createPickup(event_.getTypeValues(), _pickupCustomer);
                    
                    logger.info("PICKUP REQUEST = {}", _createdPickup.toStringPreScheduled("|"));
                    
                    // ---- Trying to schedule the pickup ---- //
                    // Driver available for the pickup. Null if no available drivers.
                    Driver _availableDriver = userController.getNextAvailableDriver();
                    
                    Pickup _scheduledPickup = pickupController.schedulePickup(_createdPickup, _availableDriver);
                    
                    if (_scheduledPickup != null) {
                        // Scheduling the pickup was successful!
                        pickupController.storePickupInDatabase(_scheduledPickup);
                        logger.info("SCHEDULED PICKUP = {}", _scheduledPickup);
                    }
                    
                } catch (CannotSchedulePickupException e_) {
                    logger.error("ERROR SCHEDULING PICKUP: {}", e_.getMessage());
                } catch (InvalidPickupArgumentsException e_) {
                    logger.error("ERROR CREATING PICKUP: {}", e_.getMessage());
                } catch (CustomerNotFoundException e_) {
                    logger.error("ERROR ASSIGNING PICKUP CUSTOMER: {}", e_.getMessage());
                } catch (NumberFormatException e_) {
                    logger.error("ERROR PARSING CUSTOMER_ID: CustomerID is not integer parseable. Check input format.");
                } catch (IndexOutOfBoundsException e_) {
                    logger.error("ERROR GETTING CUSTOMER_ID: Could not get customerID from input. Is it specified in the input?");
                }
                break;
            default:
                logger.error("ERROR PROCESSING INPUT_TYPE: \"{}\" is not a valid input type.", event_.getInputType());
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
            case RuntimeConstants.CAR:
                try {
                    AbstractCar _modifiedCar = carController.modifyCar(event_.getTypeValues());
                    logger.info("MODIFIED CAR = {}", _modifiedCar);
                } catch (Exception e_) {
                    logger.error("ERROR MODIFYING CAR: " + e_.getMessage());
                }
                break;
            case RuntimeConstants.USER:
                try {
                    String _userType = event_.getTypeValues().get(1);
                    
                    // Check to see if the driver's new carID is valid before modifying.
                    if (_userType.equals(RuntimeConstants.DRIVER)) {
                        int _newCarID = Integer.parseInt(event_.getTypeValues().get(7));
                        if (!carController.isCarInDatabase(_newCarID)) {
                            throw new CarNotFoundException("Car not found in database. CarID Value = " + _newCarID);
                        }
                    }
                    
                    AbstractUser _modifiedUser = userController.modifyUser(event_.getTypeValues());
                    
                    if (_modifiedUser instanceof Driver) {
                        // Modified user was a driver. Specify as a driver.
                        Driver _modifiedDriver = (Driver) _modifiedUser;
                        logger.info("MODIFIED DRIVER = {}", _modifiedUser);
                        
                        // If a driver has been made available try to schedule an unscheduled pickup.
                        if (_modifiedDriver.getIsAvailable()) {
                            Pickup _scheduledPickup = pickupController.scheduleUnscheduledPickup(_modifiedDriver);
                            
                            if (_scheduledPickup != null) {
                                pickupController.storePickupInDatabase(_scheduledPickup);
                                logger.info("SCHEDULED PICKUP = {}", _scheduledPickup);
                            }
                            
                            // _scheduledPickup was null. Do nothing (no unscheduled pickups).
                        }
                        
                    } else {
                        // Modified user was a customer. Specify as a customer.
                        Customer _modifiedCustomer = (Customer) _modifiedUser;
                        logger.info("MODIFIED CUSTOMER = {}", _modifiedCustomer);
                    }
                    
                } catch (Exception e_) {
                    logger.error("ERROR MODIFYING USER: ", e_.getMessage());
                }
                break;
            // ----- DEPRECATED! -----
            /*
             * case RuntimeConstants.PICKUP: { try { Pickup modifiedPickup =
             * pickupController.modifyPickup(event_.getTypeValues()); logger.debug("MODIFIED PICKUP: " +
             * modifiedPickup.toString()); } catch (BadPickupException e_) {
             * logger.error("There was a problem with modifying pickup: " + event_.typeValuesToString("|")); } break; }
             */
            // -----------------------
            default:
                logger.error("ERROR PROCESSING INPUT_TYPE: \"{}\" is not a valid input type.", event_.getInputType());
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
            case RuntimeConstants.CAR:
                try {
                    AbstractCar deletedCar = carController.deleteCar(event_.getTypeValues());
                    logger.info("DELETED CAR = {}", deletedCar);
                } catch (CarNotFoundException e_) {
                    logger.error("ERROR DELETING CAR: " + e_.getMessage());
                } catch (InvalidCarArgumentsException e_) {
                	logger.error("ERROR DELETING CAR: " + e_.getMessage());
                }
                break;
            case RuntimeConstants.USER:
                try {
                    AbstractUser _deletedUser = userController.deleteUser(event_.getTypeValues());
                    logger.info("DELETED USER = {}", _deletedUser);
                } catch (Exception e_) {
                    logger.error("ERROR DELETING USER: {}", e_.getMessage());
                }
                break;
            case RuntimeConstants.PICKUP:
                try {
                    Pickup deletedPickup = pickupController.deletePickup(event_.getTypeValues());
                    logger.debug("DELETED PICKUP: {}", deletedPickup);
                } catch (Exception e_) {
                    logger.error("ERROR DELETING PICKUP: {}", e_.getMessage());
                }
                break;
            default:
                logger.error("ERROR PROCESSING INPUT_TYPE: \"{}\" is not a valid input type.", event_.getInputType());
                break;
        }
    }
}
