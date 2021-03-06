package com.odw.ridesharing.tests;

import org.junit.Test;
import junit.framework.TestCase;

import com.odw.ridesharing.exceptions.InvalidEventException;
import com.odw.ridesharing.model.Event;
import com.odw.ridesharing.service.EventParser;

/**
 * Tests all the public methods inside EventParser.
 */
public class EventParserTest extends TestCase {
    
    /**
     * Tests to see if a valid event gets successfully parsed. Note that parseEvent does not check if the event is valid
     * or not. The first token gets stored into Command. The second into InputType. The rest into TypeValues.
     */
    @Test
    public void testParseEvent() {
        EventParser _eventParser = new EventParser();
        
        String _validEventString = "create|customer|Britney|Spears|female|36|";
        try {
            Event _validEvent = _eventParser.parseEvent(_validEventString, "|");
            assertEquals(_validEvent.getCommand(), "create");
            assertEquals(_validEvent.getInputType(), "customer");
            assertEquals(_validEvent.typeValuesToString(), "|britney|spears|female|36|");
        } catch (InvalidEventException e_) {
            fail("Error parsing a valid event.");
        }
    }
    
    /**
     * Tests to see if an invalid event doesn't get parsed.
     */
    @Test
    public void testParseInvalidEvent() {
        EventParser _eventParser = new EventParser();
        
        String _invalidEventString = "";
        try {
            @SuppressWarnings("unused") // Suppressed because the variable is not used.
            Event _invalidEvent = _eventParser.parseEvent(_invalidEventString, "|");
            fail("Successfully parsed an invalid event.");
        } catch (InvalidEventException e_) {
            // Execution SHOULD reach inside the catch statement.
        }
    }
    
}
