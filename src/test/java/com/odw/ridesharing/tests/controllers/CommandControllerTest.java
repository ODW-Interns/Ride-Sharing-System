package com.odw.ridesharing.tests.controllers;

import static org.junit.Assert.*;

import org.junit.Test;

import com.odw.ridesharing.controllers.CommandController;

/**
 * Tests all the public methods inside CommandController.
 */
public class CommandControllerTest {

    // [TODO] : Test export
    
    /**
     * Runs the service with the ScheduleWithNoAvailableDriver.txt example input.
     */
    @Test
    public void testProcessingScheduleWithNoAvailableDriver() {
        try {
            CommandController _commandController = new CommandController();
            _commandController.processFile("src/main/resources/ScheduleWithNoAvailableDriver.txt", "|");
        } catch (Exception e_) {
            fail("There was a problem processing ScheduleWithNoAvailableDriver.txt");
        }
    }
    
    /**
     * Runs the service with the InvalidInputFormats.txt example input.
     */
    @Test
    public void testProcessingInvalidInputFormats() {
        try {
            CommandController _commandController = new CommandController();
            _commandController.processFile("src/main/resources/InvalidInputFormats.txt", "|");
        } catch (Exception e_) {
            fail("There was a problem processing InvalidInputFormats.txt");

        }
    }
    
    /**
     * Runs the service with the LargeInputExample.txt example input.
     */
    @Test
    public void testProcessingLargeInputExample() {
        try {
            CommandController _commandController = new CommandController();
            _commandController.processFile("src/main/resources/LargeInputExample.txt", "|");
        } catch (Exception e_) {
            fail("There was a problem processing LargeInputExample.txt");
        }
    }
    
    /**
     * Runs the service with the SimpleInputExample.txt example input.
     */
    @Test
    public void testProcessingSimpleInputExample() {
        try {
            CommandController _commandController = new CommandController();
            _commandController.processFile("src/main/resources/SimpleInputExample.txt", "|");
        } catch (Exception e_) {
            fail("There was a problem processing SimpleInputExample.txt");
        }
    }

}
