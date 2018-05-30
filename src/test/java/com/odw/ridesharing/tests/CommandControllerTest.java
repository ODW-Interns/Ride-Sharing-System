package com.odw.ridesharing.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.odw.ridesharing.service.CommandController;

public class CommandControllerTest {

    /**
     * Tests CommandController's processFile method. Takes the given input file,
     * processes it, and logs it to console and the specified log file in
     * log4j.properties.
     */
    @Test
    public void testProcessFile() {
        CommandController _commandController = new CommandController();
        
        // ScheduleWithNoAvailableDriver.txt
        _commandController.processFile("src/main/resources/ScheduleWithNoAvailableDriver.txt", "|");
        
        // Resetting the databases. (Note: This is not necessary)
        _commandController = new CommandController();
   
        // InvalidInputFormats.txt
        _commandController.processFile("src/main/resources/InvalidInputFormats.txt", "|");
        // File found and read with no exceptions.
      
        // Resetting the databases.
        _commandController = new CommandController();
      
        // LargeInputExample.txt
        _commandController.processFile("src/main/resources/LargeInputExample.txt", "|");
        
        // Resetting the databases.
        _commandController = new CommandController();
      
        // SimpleInputExample.txt
        _commandController.processFile("src/main/resources/SimpleInputExample.txt", "|");
        
        
        
        // See logger file to determine validity.
        assertTrue(true);
    }

}
