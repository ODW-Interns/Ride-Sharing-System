package com.odw.ridesharing.service;

import java.util.StringTokenizer;

import com.odw.ridesharing.model.Event;

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
    public Event parseEvent(String eventToParse_, String delimiter_) {
        if (eventToParse_ != null && delimiter_ != null) {
            StringTokenizer _tokenizer = new StringTokenizer(eventToParse_, delimiter_);
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
                e_.printStackTrace(); // TODO: Log
            }

            return _returnedEvent;
        }

        // Either eventToParse_ or delimiter_ was null.
        return null;
    }
}
