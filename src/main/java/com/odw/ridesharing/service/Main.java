package com.odw.ridesharing.service;

import com.odw.ridesharing.model.RuntimeConstants;

/**
 * Main entry point of the application.
 */
public class Main {

    /**
     * The application starts here.
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

}
