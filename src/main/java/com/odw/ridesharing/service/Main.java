package com.odw.ridesharing.service;

public class Main {

    /**
     * Main entry point for the application.
     */
    public static void main(String[] args_) {
        CommandController _commandController = new CommandController();
        _commandController.processFile("src/main/resources/ScheduleWithNoAvailableDriver.txt", "|");
    
        _commandController = new CommandController();
        _commandController.processFile("src/main/resources/InvalidInputFormats.txt", "|");

        _commandController = new CommandController();
        _commandController.processFile("src/main/resources/LargeInputExample.txt", "|");
    }

}
