package com.odw.ridesharing.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.Event;
import com.odw.ridesharing.model.Pickup;

public class CommandController {

    private EventParser eventParser;
    //private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    public CommandController() {
        eventParser = new EventParser("/input.txt", "l");
    }

    public void create(Event event_) {

    }

    public void modify(Event event_) {
      
    }

    public void delete(Event event_) {
        

    }
}
