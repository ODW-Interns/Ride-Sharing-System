package com.odw.ridesharing.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.Event;
import com.odw.ridesharing.model.RuntimeConstants;
import com.odw.ridesharing.model.exceptions.BadCarException;
import com.odw.ridesharing.model.exceptions.BadUserException;

public class CommandController {

    // TODO: Document
    
    private CarController carController = new CarController();
    private UserController userController = new UserController();
    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    public void processFile(String fileName_, String delimiter_) {
        EventParser _eventParser = new EventParser();

        try (BufferedReader _inputReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName_)))) {
            
            // Process each event line-by-line.
            String _nextLine = null;
            while ((_nextLine = _inputReader.readLine()) != null) {
                Event _nextEvent = _eventParser.parseEvent(_nextLine, delimiter_);
                processEvent(_nextEvent);
            }

            // SUCCESS!
            logger.info(carController.getCarInventory());
        } catch (FileNotFoundException e_) {
            logger.error("Could not find the specified file.");
        } catch (IOException e_) {
            logger.error("Something went wrong while reading the file.");
        }
    }

    private void processEvent(Event newEvent_) {
        try {
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
        } catch (Exception e_) {
            logger.error(e_.getMessage());
        }
    }

    private void create(Event event_) {
        switch (event_.getInputType()) {
        case RuntimeConstants.CAR: {
            try {
                Car addedCar = carController.createCar(event_.getTypeValues());
                logger.info("CREATED CAR: " + addedCar.toString());
            } catch (BadCarException e_) {
                logger.error("There was a problem with adding car: " + event_.typeValuesToString("|"));
            }
            break;
        }
        case RuntimeConstants.USER: {
            try {
                userController.createUser(event_.getTypeValues());
            } catch (BadUserException e_) {
                logger.error("There was a problem with creating user: " + event_.typeValuesToString("|"));
            }
            break;
        }
        case RuntimeConstants.PICKUP: {
            // TODO
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
                logger.info("MODIFIED CAR: " + modifiedCar.toString());
            } catch (BadCarException e_) {
                logger.error("There was a problem with modifying car: " + event_.typeValuesToString("|"));
            }
            break;
        }
        case RuntimeConstants.USER: {
            try {
                userController.modifyUser(event_.getTypeValues());
            } catch (BadUserException e_) {
                logger.error("There was a problem with modifying user: " + event_.typeValuesToString("|"));
            }
            break;
        }
        case RuntimeConstants.PICKUP: {
            // TODO
            break;
        }
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
                logger.info("DELETED CAR: " + deletedCar.toString());
            } catch (BadCarException e_) {
                logger.error("There was a problem deleting car: " + event_.typeValuesToString("|"));
            }
            break;
        }
        case RuntimeConstants.USER: {
            try {
                userController.deleteUser(event_.getTypeValues());
            } catch (BadUserException e_) {
                logger.error("There was a problem deleting user: " + event_.typeValuesToString("|"));
            }
            break;
        }
        case RuntimeConstants.PICKUP: {
            // TODO
            break;
        }
        default:
            logger.error("Error: Invalid input type.");
            break;
        }
    }
}
