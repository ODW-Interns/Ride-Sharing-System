package com.odw.ridesharing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.odw.ridesharing.service.CommandController;

public class CommandControllerTest {

    CommandController commandController = new CommandController();

    /**
     * Tests CommandController's processFile method. Does not check it see if
     * everything was processed correctly. Only tests file and exception handling.
     */
    @Test
    public void testProcessFile() {
        String _fileName = "src/main/resources/input.txt";
        String _delimiter = "|";

        commandController.processFile(_fileName, _delimiter);

        // File found and read with no exceptions.
        assertTrue(true); // See logger file to determine validity.
    }

}
