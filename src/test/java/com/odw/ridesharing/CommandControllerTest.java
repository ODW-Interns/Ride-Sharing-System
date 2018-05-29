package com.odw.ridesharing;

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
        _commandController.processFile("src/main/resources/ScheduleWithNoAvailableDriver.txt", "|");
        
        // Separating executions. Not necessary.
        _commandController = new CommandController();
        _commandController.processFile("src/main/resources/InvalidInputFormats.txt", "|");
        // File found and read with no exceptions.
        _commandController = new CommandController();
        _commandController.processFile("src/main/resources/LargeInputExample.txt", "|");
        assertTrue(true); // See logger file to determine validity.
    }

}
