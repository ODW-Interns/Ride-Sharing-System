package com.odw.ridesharing;

import org.junit.Test;
import junit.framework.TestCase;

import com.odw.ridesharing.model.Event;
import com.odw.ridesharing.service.EventParser;

public class EventParserTest extends TestCase {

    EventParser eventParser = new EventParser();
    
    /**
     * Tests parseEvent in EventParser. Note that parseEvent does not check if the
     * event is valid or not.
     */
    @Test
    public void testParseEvent() {
        String _validEventString = "create|customer|Britney|Spears|female|36|";
        String _invalidEventString = "event|parser|has|no|check|for|valid|events|";

        Event _validEvent = eventParser.parseEvent(_validEventString, "|");
        Event _invalidEvent = eventParser.parseEvent(_invalidEventString, "|");

        assertEquals(_validEvent.getCommand(), "create");
        assertEquals(_validEvent.getInputType(), "customer");
        assertEquals(_validEvent.typeValuesToString("|"), "britney|spears|female|36|");

        assertEquals(_invalidEvent.getCommand(), "event");
        assertEquals(_invalidEvent.getInputType(), "parser");
        assertEquals(_invalidEvent.typeValuesToString("|"), "has|no|check|for|valid|events|");
    }

}
