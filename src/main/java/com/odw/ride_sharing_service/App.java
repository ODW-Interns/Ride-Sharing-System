package com.odw.ride_sharing_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
    
    /* Testing slf4j Logger below */
    private Logger _logger;
    
    public App() {
        _logger = LoggerFactory.getLogger(getClass().getSimpleName());
    }
    
    public void run() {
        if (_logger.isTraceEnabled())
            _logger.trace("Running trace mode!");
        if (_logger.isDebugEnabled())
            _logger.debug("Running debug mode!");
        if (_logger.isInfoEnabled())
            _logger.info("Running info mode!");
        if (_logger.isWarnEnabled())
            _logger.warn("Running info mode!");
        if (_logger.isErrorEnabled())
            _logger.error("Running error mode!");
    }
}
