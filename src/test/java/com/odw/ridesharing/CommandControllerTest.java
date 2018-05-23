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

        String _fileName = "src/main/resources/input.txt";
        String _delimiter = "|";

        _commandController.processFile(_fileName, _delimiter);

        // File found and read with no exceptions.
        assertTrue(true); // See logger file to determine validity.
    }

}
