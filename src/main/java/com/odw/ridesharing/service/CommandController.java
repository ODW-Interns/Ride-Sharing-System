package com.odw.ridesharing.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.Customer;
import com.odw.ridesharing.model.Driver;
import com.odw.ridesharing.model.InputType;
import com.odw.ridesharing.model.Pickup;

public class CommandController {

    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    public CommandController() {
        Driver d = new Driver();
        Car c = new Car();
        Pickup p = new Pickup();
        Customer k = new Customer();
        create(d);
        create(c);
        create(p);
        create(k);
        modify(d);
        modify(c);
        modify(p);
        modify(k);
        delete(d);
        delete(c);
        delete(p);
        delete(k);
    }

    public void create(InputType input_) {
        switch (input_.getType()) {
        case CAR:
            // createCar();
            if (logger.isDebugEnabled())
                logger.debug("Created Car"); // TODO: toString the car
            break;
        case DRIVER:
            // createDriver();
            if (logger.isDebugEnabled())
                logger.debug("Created Driver"); // TODO: toString the driver
            break;
        case PICKUP:
            // createPickup();
            if (logger.isDebugEnabled())
                logger.debug("Created Pickup"); // TODO: toString the pickup
            break;
        case CUSTOMER:
        	//createCustomer();
        	if (logger.isDebugEnabled())
                logger.debug("Created Customer"); // TODO: toString the customer
            break;
        default:
            if (logger.isErrorEnabled())
                logger.error("Error invalid InputType for create()");
            break;
        }
    }

    public void modify(InputType input_) {
        switch (input_.getType()) {
        case CAR:
            // modifyCar();
            if (logger.isDebugEnabled())
                logger.debug("Modified Car");
            break;
        case DRIVER:
            // modifyDriver();
            if (logger.isDebugEnabled())
                logger.debug("Modified Driver");
            break;
        case PICKUP:
            // modifyPickup();
            if (logger.isDebugEnabled())
                logger.debug("Modified Pickup");
            break;
        case CUSTOMER:
        	//createCustomer();
        	if (logger.isDebugEnabled())
                logger.debug("Modified Customer");
            break;
        default:
            if (logger.isErrorEnabled())
                logger.error("Error invalid InputType for modify()");
            break;
        }

    }

    public void delete(InputType input_) {
        switch (input_.getType()) {
        case CAR:
            // deleteCar();
            if (logger.isDebugEnabled())
                logger.debug("Deleted Car"); // TODO: toString the car
            break;
        case DRIVER:
            // deleteDriver();
            // deleteCar();
            if (logger.isDebugEnabled())
                logger.debug("Deleted Driver"); // TODO: toString the driver
            break;
        case PICKUP:
            // deletePickup();
            if (logger.isDebugEnabled())
                logger.debug("Deleted Pickup"); // TODO: toString the pickup
            break;
        case CUSTOMER:
        	//createCustomer();
        	if (logger.isDebugEnabled())
                logger.debug("Deleted Customer"); // TODO: toString the customer
            break;
        default:
            if (logger.isErrorEnabled())
                logger.error("Error invalid InputType for delete()");
            break;
        }

    }
}
