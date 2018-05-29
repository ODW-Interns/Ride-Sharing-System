package com.odw.ridesharing.service;

public class Main {

    /**
     * Main entry point for the application.
     */
    public static void main(String[] args_) {
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
    }

}
