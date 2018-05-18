package com.odw.ridesharing.model;

import java.util.ArrayList;

public class Event {

    // Commands
    public static final String CREATE = "create";
    public static final String MODIFY = "modify";
    public static final String DELETE = "delete";

    // Input Types
    public static final String CAR = "car";
    public static final String CUSTOMER = "customer";
    public static final String DRIVER = "driver";
    public static final String PICKUP = "pickup";

    private String commandType;
    private String inputType;
    private ArrayList<String> typeValues;

    /**
     * Initializes an empty Event.
     */
    public Event() {
        this("", "", "");
    }

    /**
     * Stores event information parsed from EventParser.
     * 
     * @param commandType_
     *            The type of command to be executed.
     * 
     * @param inputType_
     *            The input type to be operated on.
     * 
     * @param typeValues_
     *            The remaining command string to be assigned to an identity class.
     */
    public Event(String commandType_, String inputType_, String typeValues_) {
        setCommand(commandType_);
        setInputType(inputType_);
        typeValues = new ArrayList<String>();
    }

    /**
     * Add an element to the ArrayList storing to the remaining input values.
     * 
     * @param typeValue_
     *            String to add to the ArrayList
     */
    public void addTypeValue(String typeValue_) {
        typeValues.add(typeValue_);
    }

    /**
     * Get the remaining input values from the event. (excluding the command & type)
     * 
     * @return An ArrayList of the remaining input values.
     */
    public ArrayList<String> getTypeValues() {
        return typeValues;
    }

    /**
     * Reconstructs the original event before it was parsed and returns it as a
     * string. Uses pipes ("|") as the default delimiter.
     * 
     * @return The event string before it was parsed
     */
    @Override
    public String toString() {
        return toString("|");
    }

    /**
     * Reconstructs the original event before it was parsed and returns it as a
     * string. Can specify the desired delimiter.
     * 
     * @param delimiter_
     *            The specified delimiter to separate the values.
     * @return The event string before it was parsed
     */
    public String toString(String delimiter_) {
        StringBuilder _typeValuesStringBuilder = new StringBuilder();
        for (String typeValue : typeValues) {
            _typeValuesStringBuilder.append(typeValue + delimiter_);
        }
        return commandType + delimiter_ + inputType + delimiter_ + _typeValuesStringBuilder.toString();
    }

    /* ===== Getters and Setters ===== */

    /**
     * Gets the event's command to be executed.
     * 
     * @return The command that will be executed.
     */
    public String getCommand() {
        return commandType;
    }

    /**
     * Sets the event's command to be executed.
     * 
     * @param command_
     *            The new command to be set to.
     */
    public void setCommand(String command_) {
        commandType = command_;
    }

    /**
     * Gets the event's input type of the event. (i.e. the format)
     * 
     * @return The type of the input information.
     */
    public String getInputType() {
        return inputType;
    }

    /**
     * Sets the input type of the event. (i.e. the format)
     * 
     * @param inputType_
     *            The new input type to be set to.
     */
    public void setInputType(String inputType_) {
        inputType = inputType_;
    }

}
