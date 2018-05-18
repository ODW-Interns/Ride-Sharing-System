package com.odw.ridesharing;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.odw.ridesharing.model.*;
import com.odw.ridesharing.service.CommandController;
import com.odw.ridesharing.service.EventParser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    
    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }
    
    public void testEventParser() {
        EventParser eventParser = new EventParser("/input.txt", "|");
        Event nextEvent = null;
        
        try {
            while ((nextEvent = eventParser.parseEvent()) != null) {
                if (logger.isInfoEnabled()) {
                    logger.info(nextEvent.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void testCar() {
        Car car = new Sedan();
    }
}
