package com.odw.ridesharing.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.odw.ridesharing.model.Event;
import com.odw.ridesharing.model.exceptions.BadCarException;

public class CommandController {

    private CarController carController;
    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    public CommandController() {
        carController = new CarController();
    }
    
    public void processFile(String fileName_, String delimiter_) {
        EventParser _eventParser = new EventParser(fileName_, delimiter_);
        Event _nextEvent = null;
        
        try {
            while ((_nextEvent = _eventParser.parseEvent()) != null) {
                processEvent(_nextEvent);
            }
        } catch (IOException e_) {
            e_.printStackTrace();
        }
        
        if (logger.isInfoEnabled()) {
            logger.info(carController.getCarInventory());
        }
        
    }

    private void processEvent(Event newEvent_) {
        try {
            switch (newEvent_.getCommand()) {
            case Event.CREATE:
                create(newEvent_);
                break;
            case Event.MODIFY:
                modify(newEvent_);
                break;
            case Event.DELETE:
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
        case Event.CAR:
            try {
                carController.createCar(event_.getTypeValues());
            } catch (BadCarException e_) {
                if (logger.isErrorEnabled()) {
                    logger.error("There was a problem adding a car.");
                }
            }
            break;
        case Event.CUSTOMER:
            // TODO
            break;
        case Event.DRIVER:
            // TODO
            break;
        case Event.PICKUP:
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
        case Event.CAR:
            // TODO
            break;
        case Event.CUSTOMER:
            // TODO
            break;
        case Event.DRIVER:
            // TODO
            break;
        case Event.PICKUP:
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
        case Event.CAR:
            // TODO
            break;
        case Event.CUSTOMER:
            // TODO
            break;
        case Event.DRIVER:
            // TODO
            break;
        case Event.PICKUP:
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
