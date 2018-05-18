package com.odw.ridesharing.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.odw.ridesharing.model.Event;

public class EventParser {

    private BufferedReader inputReader;
    private String fileName;
    private String delimiter;

    /**
     * Creates a new EventParser for the given file.
     * 
     * @param fileName_
     *            The name of the file to access.
     * 
     * @param delimited_
     *            The file's delimiter.
     */
    public EventParser(String fileName_, String delimiter_) {
        delimiter = delimiter_;
        fileName = fileName_;
        inputReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)));
    }

    /**
     * Creates a new EventParser for a generic InputStream
     * 
     * @param inputStream_
     *            The InputStream to read from.
     * @param delimiter_
     *            The InputStream's delimiter.
     */
    public EventParser(InputStream inputStream_, String delimiter_) {
        delimiter = delimiter_;
        inputReader = new BufferedReader(new InputStreamReader(inputStream_));
    }

    /**
     * Parses the event information on the current line of the inputReader. Does not
     * check to see if format is correct.
     * 
     * @return A new event if an event exists in the file. Returns null if
     */
    public Event parseEvent() throws IOException {
        String _eventToParse = getNextLine();

        if (_eventToParse != null) {
            StringTokenizer _tokenizer = new StringTokenizer(_eventToParse, delimiter);
            Event _returnedEvent = new Event();

            // Storing the command to be executed as a String.
            _returnedEvent.setCommand(_tokenizer.nextToken().toLowerCase());

            // Storing the type-of-input format as a String.
            _returnedEvent.setInputType(_tokenizer.nextToken().toLowerCase());

            // Storing the remaining type information for later object creation.
            while (_tokenizer.hasMoreTokens()) {
                _returnedEvent.addTypeValue(_tokenizer.nextToken().toLowerCase());
            }

            return _returnedEvent;
        }
        
        // There is nothing more to parse.
        return null;
    }

    /**
     * Get the next line to process in the specified file.
     * 
     * @return A string of the next line (event) to be parsed.
     */
    private String getNextLine() throws IOException {
        return inputReader.readLine();
    }
}
