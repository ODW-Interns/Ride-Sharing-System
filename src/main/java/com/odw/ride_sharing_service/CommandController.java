package com.odw.ride_sharing_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandController {

    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    
    CommandController() {
        Driver d = new Driver();
        Car c = new Car();
        create(d);
        modify(c);
    }

    public void create(InputType input_) {
        switch (input_.getType()) {
        case CAR:
            //createCar();
        case DRIVER:
            // createDriver();
            if (logger.isDebugEnabled()) {
                logger.debug("Created Driver");
            }
            
        case PICKUP:
            //createPickup();
        default:
            
        break;
        }
    }

    public void modify(InputType input_) {
        switch (input_.getType()) {
        case CAR:
            // modifyCar();
            if (logger.isDebugEnabled())
                logger.debug("Modified Car");
        case DRIVER:
            // modifyDriver();
        case PICKUP:
            // modifyPickup();
        default:
            
            break;
        }

    }

    public void delete(InputType input_) {
        switch (input_.getType()) {
        case CAR:
            // deleteCar();
        case DRIVER:
            // deleteDriver();
        case PICKUP:
            // deletePickup();
        default:

            break;
        }

    }
}
