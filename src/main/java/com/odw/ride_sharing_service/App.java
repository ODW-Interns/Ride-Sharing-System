package com.odw.ride_sharing_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
    private Logger _logger;
    
    public App() {
        _logger= LoggerFactory.getLogger(getClass().getSimpleName());
    }
    
    public void run() {
        if (_logger.isDebugEnabled())
            _logger.debug("Hello World!");
    }
    
    public static void main(String[] args) {
        App a = new App();
        a.run();
    }
}
