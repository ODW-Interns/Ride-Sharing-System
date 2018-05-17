package com.odw.ridesharing;

import java.io.IOException;

import com.odw.ridesharing.model.Event;
import com.odw.ridesharing.service.CommandController;
import com.odw.ridesharing.service.EventParser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
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
    
    public void testController() {
        //CommandController testController = new CommandController();
               
    }
    
    public void testEventParser() {
        EventParser eventParser = new EventParser("/input.txt", "|");
        try {
            Event firstEvent = eventParser.parseEvent();
            Event secondEvent = eventParser.parseEvent();
            Event thirdEvent = eventParser.parseEvent();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
}
