package com.odw.ridesharing.service;

import com.odw.ridesharing.controllers.CommandController;
import com.odw.ridesharing.model.RuntimeConstants;

public class RideSharingService {
    private CommandController commandController = new CommandController();
    
    /**
     * Application's main entry point.
     * 
     * @param args_
     *            [TODO]
     */
    public static void main(String[] args_) {
        RideSharingService rideSharingService = new RideSharingService();
        
        if (args_.length == 1) {
            // Unspecified output directory.
            rideSharingService.run(args_[0], RuntimeConstants.DEFAULT_OUTPUT_DIRECTORY);
        } else if (args_.length == 2) {
            // Specified output directory
            rideSharingService.run(args_[0], args_[1]);
        } else {
            System.out.println("Usage: java -jar ride-sharing-service-1.0.0.jar [FILE_TO_PROCESS] [(optional) OUTPUT_DIRECTORY]");
        }
    }
    
    /**
     * Runs the Ride-Sharing-Service application.
     * 
     * @param inputFile_
     *            File to process.
     * @param outputDirectory_
     *            Directory to output to.
     */
    public void run(String inputFile_, String outputDirectory_) {
        commandController.processFile(inputFile_, "|"); // Delimiter MUST be pipes |
        commandController.exportDatabasesToXML(outputDirectory_);
    }
}
