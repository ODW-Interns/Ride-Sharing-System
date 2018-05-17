package com.odw.ridesharing.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.odw.ridesharing.model.Event;

public class CommandController {

    private EventParser eventParser;

    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    public CommandController() {
        eventParser = new EventParser("/input.txt", "l");
    }

    public void processCommand() {
        try {
            Event _newEvent = eventParser.parseEvent();
            switch (_newEvent.getCommand()) {
            case Event.CREATE:
                create(_newEvent);
                break;
            case Event.MODIFY:
                modify(_newEvent);
                break;
            case Event.DELETE:
                delete(_newEvent);
                break;
            default:
                if (logger.isErrorEnabled())
                    logger.error("Error: Invalid command.");
                break;
            }
        } catch (Exception e_) {
            if (logger.isErrorEnabled())
                logger.error(e_.getMessage());
        }
    }

    private void create(Event event_) {
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
            if (logger.isErrorEnabled())
                logger.error("Error: Invalid input type.");
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
            if (logger.isErrorEnabled())
                logger.error("Error: Invalid input type.");
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
            if (logger.isErrorEnabled())
                logger.error("Error: Invalid input type.");
            break;
        }
    }
}
