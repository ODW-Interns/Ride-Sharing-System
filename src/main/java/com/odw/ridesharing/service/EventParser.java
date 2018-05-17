package com.odw.ridesharing.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.odw.ridesharing.model.Event;

public class EventParser {

    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    private BufferedReader inputReader;
    private String delimiter;
    
    public EventParser(String fileName_, String delimiter_) {
        // TODO: exception if not found
        inputReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName_)));
        delimiter = delimiter_;
    }    
    
    public Event parseEvent() throws IOException {
        StringTokenizer _tokenizer = new StringTokenizer(getNextLine(), delimiter);
        Event _returnedEvent = new Event();
        
        // Storing the command to be executed as a String.
        try {
            _returnedEvent.setCommand(_tokenizer.nextToken());
        }
        catch (Exception e_) {
            if (logger.isErrorEnabled())
                logger.error("Exception message: {}", e_.getMessage());
            return null;
        }
        
        // Storing the type-of-input format as a String.
        try {
            _returnedEvent.setInputType(_tokenizer.nextToken());
        }
        catch (Exception e_) {
            if (logger.isErrorEnabled())
                logger.error("Exception message: {}", e_.getMessage());
            return null;
        }
        
        // Storing the remaining type information for later object creation.
        try {
            while(_tokenizer.hasMoreTokens()) {
                _returnedEvent.addTypeValue(_tokenizer.nextToken());
            }
            
        }
        catch (Exception e_) {
            if (logger.isErrorEnabled())
                logger.error("Exception message: {}", e_.getMessage());
            return null;
        }
    
        if (logger.isInfoEnabled()) {
            logger.info("---- New event created ----");
            logger.info("Event CommandType: {}", _returnedEvent.getCommand());
            logger.info("Event InputType: {}", _returnedEvent.getInputType());
            logger.info("Event TypeValues: {}", _returnedEvent.getTypeValues().toString());
        }
        
        return _returnedEvent;
    }
    
    /*
     * Get the next line to process in the specified file.
     * @return A string of the next line (event) to be parsed.
     */
    private String getNextLine() throws IOException {
        return inputReader.readLine();
    }
}
