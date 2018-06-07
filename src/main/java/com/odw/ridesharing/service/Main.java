package com.odw.ridesharing.service;

import com.odw.ridesharing.controllers.CommandController;

/**
 * Main entry point of the application.
 */
public class Main {

    /**
     * The application starts here.
     */
    public static void main(String[] args_) {
        CommandController _commandController = new CommandController();

        // TODO: Command-line arguments to process file?
        
        // ScheduleWithNoAvailableDriver.txt
        _commandController.processFile("src/main/resources/ScheduleWithNoAvailableDriver.txt", "|");

        // Resetting the databases. (Note: This is not necessary)
        _commandController = new CommandController();

        // InvalidInputFormats.txt
        _commandController.processFile("src/main/resources/InvalidInputFormats.txt", "|");
        
        // Resetting the databases.
        _commandController = new CommandController();

        // LargeInputExample.txt
        _commandController.processFile("src/main/resources/LargeInputExample.txt", "|");

        // Resetting the databases.
        _commandController = new CommandController();

        // SimpleInputExample.txt
        _commandController.processFile("src/main/resources/SimpleInputExample.txt", "|");
        
        // File found and read with no exceptions.
    }

}
