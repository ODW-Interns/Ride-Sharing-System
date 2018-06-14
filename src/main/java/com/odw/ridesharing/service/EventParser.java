package com.odw.ridesharing.service;

import java.util.StringTokenizer;

import com.odw.ridesharing.exceptions.InvalidEventException;
import com.odw.ridesharing.model.Event;
import com.odw.ridesharing.model.RuntimeConstants;

/**
 * EventParser parses a string into an event and is called by the 
 * CommandController.
 */
public class EventParser {

    /**
     * Parses a string into an event.
     * 
     * @param eventToParse_
     *            The string to parse.
     * @param delimiter_
     *            The delimiter used to separate the event's values.
     * @return An event object parsed from the string.
     */
    public Event parseEvent(String eventToParse_, String delimiter_) throws InvalidEventException {
        if (eventToParse_ != null && delimiter_ != null) {
            StringTokenizer _tokenizer = new StringTokenizer(eventToParse_, delimiter_);

            if (_tokenizer.countTokens() >= RuntimeConstants.MINIMUM_EVENT_LENGTH) {
                Event _returnedEvent = new Event();
                try {
                    // Storing the command to be executed as a String.
                    _returnedEvent.setCommand(_tokenizer.nextToken().toLowerCase());

                    // Storing the type-of-input format as a String.
                    _returnedEvent.setInputType(_tokenizer.nextToken().toLowerCase());

                    // Storing the remaining type information for later object creation.
                    while (_tokenizer.hasMoreTokens()) {
                        _returnedEvent.addTypeValue(_tokenizer.nextToken().toLowerCase());
                    }
                } catch (Exception e_) {
                    throw new InvalidEventException("Event: \"" + eventToParse_ + "\" cannot be parsed");
                }
                
                return _returnedEvent;
            }
        }

        // Could not parse the given event.
        throw new InvalidEventException("The passed event or delimiter was null.");
    }
}
