package com.odw.ridesharing;

import org.junit.Test;
import junit.framework.TestCase;

import com.odw.ridesharing.model.Event;
import com.odw.ridesharing.model.exceptions.InvalidEventException;
import com.odw.ridesharing.service.EventParser;

public class EventParserTest extends TestCase {

    /**
     * Tests parseEvent in EventParser. Note that parseEvent does not check if the
     * event is valid or not. The first token gets stored into Command. The second
     * into InputType. The rest into TypeValues.
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
            fail("Error creating a valid event.");
        }

        String _invalidEventString = "";
        try {
            @SuppressWarnings("unused")
            Event _invalidEvent = _eventParser.parseEvent(_invalidEventString, "|");
        } catch (InvalidEventException e_) {
            assertTrue(true); // This is the desired outcome.
        }
        

        
    }

}
