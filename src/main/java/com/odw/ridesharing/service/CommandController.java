package com.odw.ridesharing.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.odw.ridesharing.model.Event;
import com.odw.ridesharing.model.exceptions.BadCarException;

public class CommandController {

    // Commands
    public static final String CREATE = "create";
    public static final String MODIFY = "modify";
    public static final String DELETE = "delete";

    // Input Types
    public static final String CAR = "car";
    public static final String CUSTOMER = "customer";
    public static final String DRIVER = "driver";
    public static final String PICKUP = "pickup";
    
    private CarController carController = new CarController();
    
    // TODO: Move
    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    
    public void processFile(String fileName_, String delimiter_) {
        EventParser _eventParser = new EventParser();  
        BufferedReader _inputReader = new BufferedReader(
                                          new InputStreamReader(
                                              getClass().getResourceAsStream(fileName_)));
        String _nextLine = null;
        try {
            while ((_nextLine = _inputReader.readLine()) != null) {
                Event _nextEvent = _eventParser.parseEvent(_nextLine, delimiter_);
                processEvent(_nextEvent);
            }
        } catch (IOException e_) {
            e_.printStackTrace(); // TODO: Log
        }
        
        if (logger.isInfoEnabled()) {
            logger.info(carController.getCarInventory());
        }
        
    }

    private void processEvent(Event newEvent_) {
        try {
            switch (newEvent_.getCommand()) {
            case CREATE:
                create(newEvent_);
                break;
            case MODIFY:
                modify(newEvent_);
                break;
            case DELETE:
                delete(newEvent_);
                break;
            default:
                if (logger.isErrorEnabled()) {
                    logger.error("Error: Invalid command.");
                }
                break;
            }
        } catch (Exception e_) {
            if (logger.isErrorEnabled()) {
                logger.error(e_.getMessage());
            }
        }
    }

    private void create(Event event_) {
        switch (event_.getInputType()) {
        case CAR:
            try {
                carController.createCar(event_.getTypeValues());
            } catch (BadCarException e_) {
                if (logger.isErrorEnabled()) {
                    logger.error("There was a problem adding a car.");
                }
            }
            break;
        case CUSTOMER:
            // TODO
            break;
        case DRIVER:
            // TODO
            break;
        case PICKUP:
            // TODO
            break;
        default:
            if (logger.isErrorEnabled()) {
                logger.error("Error: Invalid input type.");
            }
            break;
        }
    }

    private void modify(Event event_) {
        switch (event_.getInputType()) {
        case CAR:
        	 try {
                 carController.modifyCar(event_.getTypeValues());
             } catch (BadCarException e_) {
                 if (logger.isErrorEnabled()) {
                     logger.error("There was a problem modifying a car.");
                 }
             }
            break;
        case CUSTOMER:
            // TODO
            break;
        case DRIVER:
            // TODO
            break;
        case PICKUP:
            // TODO
            break;
        default:
            if (logger.isErrorEnabled()) {
                logger.error("Error: Invalid input type.");
            }
            break;
        }
    }

    private void delete(Event event_) {
        switch (event_.getInputType()) {
        case CAR:
        	try {
                carController.deleteCar(event_.getTypeValues());
            } catch (BadCarException e_) {
                if (logger.isErrorEnabled()) {
                    logger.error("There was a problem deleting a car.");
                }
            }
            break;
        case CUSTOMER:
            // TODO
            break;
        case DRIVER:
            // TODO
            break;
        case PICKUP:
            // TODO
            break;
        default:
            if (logger.isErrorEnabled()) {
                logger.error("Error: Invalid input type.");
            }
            break;
        }
    }
}
