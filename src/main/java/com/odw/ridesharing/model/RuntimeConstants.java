package com.odw.ridesharing.model;

public class RuntimeConstants {

    // Available Commands
    public static final String CREATE = "create";
    public static final String MODIFY = "modify";
    public static final String DELETE = "delete";

    // Available Input Types
    public static final String CAR = "car";
    public static final String CUSTOMER = "customer";
    public static final String DRIVER = "driver";
    public static final String PICKUP = "pickup";
    
    // Available Cars
    public static final String COUPE = "coupe";
    public static final String SEDAN = "sedan";
    public static final String SUV = "suv";

    // -- Predetermined Input Formats (Excludes COMMAND and INPUT_TYPES) --
    public static final String[] CREATE_CAR_FORMAT = new String[] { 
            "CAR_TYPE",
            "MAKE",
            "MODEL",
            "COLOR",
            "YEAR"
    };
    
    public static final String[] CREATE_USER_DRIVER_FORMAT = new String[] {
            "USER_TYPE",
            "FIRST_NAME",
            "LAST_NAME",
            "SEX",
            "AGE",
            "AVAILABILITY",
            "CAR_ID"
    };
    
    public static final String[] CREATE_USER_CUSTOMER_FORMAT = new String[] {
            "USER_TYPE",
            "FIRST_NAME",
            "LAST_NAME",
            "SEX",
            "AGE"
    };
    // TODO
    // public static final String[] createPickupFormat = new String[] {};

    public static final String[] MODIFY_CAR_FORMAT = new String[] {
            "CAR_ID",
            "CAR_TYPE",
            "MAKE",
            "MODEL",
            "COLOR",
            "YEAR"
    };
    
    public static final String[] MODIFY_USER_DRIVER_FORMAT = new String[] {
    		"USER_ID",
            "USER_TYPE",
            "FIRST_NAME",
            "LAST_NAME",
            "SEX",
            "AGE",
            "AVAILABILITY",
            "RATING",
            "CAR_ID"
    };
    
    public static final String[] MODIFY_USER_CUSTOMER_FORMAT = new String[] {
    		"USER_ID",
            "USER_TYPE",
            "FIRST_NAME",
            "LAST_NAME",
            "SEX",
            "AGE"
    };
    public static final String[] DELETE_CAR_FORMAT = new String[] {
            "CAR_ID",
    };
    
    public static final String[] DELETE_USER_FORMAT = new String[] {
            "USER_TYPE",
    		"USER_ID"
    };
}
