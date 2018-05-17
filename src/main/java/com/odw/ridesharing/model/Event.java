package com.odw.ridesharing.model;

import java.util.ArrayList;

public class Event {

    private String commandType;
    private String inputType;
    private ArrayList<String> typeValues;
    
    public Event() {
        this("", "", "");
    }
    
    public Event(String commandType_, String inputType_, String typeValues_) {
        setCommand(commandType_);
        setInputType(inputType_);
        typeValues = new ArrayList<String>();
    }

    /* Getters and Setters */
    public String getCommand() {
        return commandType;
    }

    public void setCommand(String command_) {
        commandType = command_;
    }

    public String getInputType() {
        return inputType;
    }    

    public void setInputType(String inputType_) {
        inputType = inputType_;
    }

    /*
     * TODO: Setter for typeValues
     * TODO: @Override?
     */
    public void addTypeValue(String typeValue_) {
        typeValues.add(typeValue_);
    }
    
    public String getTypeValues() {
        return typeValues.toString();
    }

}
