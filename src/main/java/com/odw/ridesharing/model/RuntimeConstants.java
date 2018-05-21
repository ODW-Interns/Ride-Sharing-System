package com.odw.ridesharing.model;

public class RuntimeConstants {

    // Available Commands
    public static final String CREATE = "create";
    public static final String MODIFY = "modify";
    public static final String DELETE = "delete";

    // Available Input Types
    public static final String CAR = "car";
    public static final String USER = "user";
    public static final String CUSTOMER = "customer";
    public static final String DRIVER = "driver";
    public static final String PICKUP = "pickup";
    
    // Available Cars
    public static final String COUPE = "coupe";
    public static final String SEDAN = "sedan";
    public static final String SUV = "suv";

    // -- Predetermined Input Formats (Excludes COMMAND and INPUT_TYPES) --
    // Mainly used for checking input lengths. However, it can be expanded to be
    // used for other things. Can be used as a reference for when creating input.
    // This way our system knows how we expect our input.
    public static final String[] CREATE_CAR_FORMAT = new String[] { 
            "CAR_TYPE (STRING)",
            "MAKE (STRING)",
            "MODEL (STRING)",
            "COLOR (STRING)",
            "YEAR (INT)"
    };
    
    public static final String[] CREATE_USER_DRIVER_FORMAT = new String[] {
            "USER_TYPE (STRING)",
            "FIRST_NAME (STRING)",
            "LAST_NAME (STRING)",
            "SEX (STRING)",
            "AGE (INT)",
            "AVAILABILITY (BOOLEAN)",
            "CAR_ID (INT)"
    };
    
    public static final String[] CREATE_USER_CUSTOMER_FORMAT = new String[] {
            "USER_TYPE (STRING)",
            "FIRST_NAME (STRING)",
            "LAST_NAME (STRING)",
            "SEX (STRING)",
            "AGE (INT)"
    };
    
    public static final String[] CREATE_PICKUP_FORMAT = new String[] {
            "DRIVER_ID (INT)",
            "CAR_ID (INT)",
            "CUSTOMER_ID (INT)",
            "ORIGIN_LATITUDE (DOUBLE)",
            "ORIGIN_LONGITUDE (DOUBLE)",
            "DESTINATION_LATITUDE (DOUBLE)",
            "DESTINATION_LONGITUDE (DOUBLE)"
            
    };

    public static final String[] MODIFY_CAR_FORMAT = new String[] {
            "CAR_ID (INT)",
            "CAR_TYPE (STRING)",
            "MAKE (STRING)",
            "MODEL (STRING)",
            "COLOR (STRING)",
            "YEAR (INT)"
    };
    
    public static final String[] MODIFY_USER_DRIVER_FORMAT = new String[] {
    		"USER_ID (INT)",
            "USER_TYPE (STRING)",
            "FIRST_NAME (STRING)",
            "LAST_NAME (STRING)",
            "SEX (STRING)",
            "AGE (INT)",
            "AVAILABILITY (BOOLEAN)",
            "RATING (INT)",
            "CAR_ID (INT)"
    };
    
    public static final String[] MODIFY_USER_CUSTOMER_FORMAT = new String[] {
    		"USER_ID (INT)",
            "USER_TYPE (STRING)",
            "FIRST_NAME (STRING)",
            "LAST_NAME (STRING)",
            "SEX (STRING)",
            "AGE (INT)"
    };
    
    public static final String[] MODIFY_PICKUP_FORMAT = new String[] {
            "PICKUP_ID (INT)",
            "CAR_ID (INT)",
            "CUSTOMER_ID (INT)",
            "DRIVER_ID (INT)",
            "ORIGIN_LATITUDE (DOUBLE)",
            "ORIGIN_LONGITUDE (DOUBLE",
            "DESTINATION_LATITUDE (DOUBLE)",
            "DESTINATION_LONGITUDE (DOUBLE)"
            
    };
    
    public static final String[] DELETE_CAR_FORMAT = new String[] {
            "CAR_ID (INT)",
    };
    
    public static final String[] DELETE_USER_FORMAT = new String[] {
    		"USER_ID (INT)"
    };
    
    public static final String[] DELETE_PICKUP_FORMAT = new String[] {
            "PICKUP_ID (INT)"
    };
}
