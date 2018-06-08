package com.odw.ridesharing.service;

import com.odw.ridesharing.controllers.CommandController;

public class App {
    private CommandController commandController = new CommandController();
    
    public void run(String inputFile_, String outputDirectory_) {
        commandController.processFile(inputFile_, "|"); // Delimiter MUST be pipes |
        commandController.exportDatabasesToXML(outputDirectory_);
    }
}
