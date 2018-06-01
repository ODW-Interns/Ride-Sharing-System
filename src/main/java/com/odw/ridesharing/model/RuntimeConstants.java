package com.odw.ridesharing.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * All runtime constants in the program.
 */
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

    // Money Stuff
    public static final String USD_CURRENCY_CODE = "USD";
    public static final double CHARGE_RATE_PER_MILE = 1.25d;
    public static final double FLAT_RATE_FEE = 5.d;

    // The minimum event instruction length needed to process an event.
    public static final int MINIMUM_EVENT_LENGTH = 3;

    // -- Predetermined Input Formats (Excludes COMMAND and INPUT_TYPES) --
    public static enum CREATE_CAR_FORMAT {

        // Specify input order here.
        CAR_TYPE, MAKE, MODEL, COLOR, YEAR;

        private static Map<Integer, CREATE_CAR_FORMAT> ss = new TreeMap<Integer, CREATE_CAR_FORMAT>();
        private static final int START_VALUE = 0;
        private int value;

        static {
            for (int i = 0; i < values().length; i++) {
                values()[i].value = START_VALUE + i;
                ss.put(values()[i].value, values()[i]);
            }
        }

        public static CREATE_CAR_FORMAT fromInt(int i) {
            return ss.get(i);
        }

        public static int length() {
            return values().length;
        }

        public int value() {
            return value;
        }

    }

    public static enum CREATE_USER_FORMAT {

        // Specify input order here.
        USER_TYPE, FIRST_NAME, LAST_NAME, SEX, AGE;

        private static Map<Integer, CREATE_USER_FORMAT> ss = new TreeMap<Integer, CREATE_USER_FORMAT>();
        private static final int START_VALUE = 0;
        private int value;

        static {
            for (int i = 0; i < values().length; i++) {
                values()[i].value = START_VALUE + i;
                ss.put(values()[i].value, values()[i]);
            }
        }

        public static CREATE_USER_FORMAT fromInt(int i) {
            return ss.get(i);
        }

        public static int length() {
            return values().length;
        }

        public int value() {
            return value;
        }

    }

    public static enum CREATE_PICKUP_FORMAT {

        // Specify input order here.
        CUSTOMER_ID, ORIGIN_LATITUDE, ORIGIN_LONGITUDE, DESTINATION_LATITUDE, DESTINATION_LONGITUDE;

        private static Map<Integer, CREATE_PICKUP_FORMAT> ss = new TreeMap<Integer, CREATE_PICKUP_FORMAT>();
        private static final int START_VALUE = 0;
        private int value;

        static {
            for (int i = 0; i < values().length; i++) {
                values()[i].value = START_VALUE + i;
                ss.put(values()[i].value, values()[i]);
            }
        }

        public static CREATE_PICKUP_FORMAT fromInt(int i) {
            return ss.get(i);
        }

        public static int length() {
            return values().length;
        }

        public int value() {
            return value;
        }

    }

    public static enum MODIFY_CAR_FORMAT {

        // Specify input order here.
        CAR_ID, CAR_TYPE, MAKE, MODEL, COLOR, YEAR;

        private static Map<Integer, MODIFY_CAR_FORMAT> ss = new TreeMap<Integer, MODIFY_CAR_FORMAT>();
        private static final int START_VALUE = 0;
        private int value;

        static {
            for (int i = 0; i < values().length; i++) {
                values()[i].value = START_VALUE + i;
                ss.put(values()[i].value, values()[i]);
            }
        }

        public static MODIFY_CAR_FORMAT fromInt(int i) {
            return ss.get(i);
        }

        public static int length() {
            return values().length;
        }

        public int value() {
            return value;
        }

    }

    public static enum MODIFY_USER_DRIVER_FORMAT {

        // Specify input order here.
        USER_ID, USER_TYPE, FIRST_NAME, LAST_NAME, SEX, AGE, AVAILABILITY, CAR_ID;

        private static Map<Integer, MODIFY_USER_DRIVER_FORMAT> ss = new TreeMap<Integer, MODIFY_USER_DRIVER_FORMAT>();
        private static final int START_VALUE = 0;
        private int value;

        static {
            for (int i = 0; i < values().length; i++) {
                values()[i].value = START_VALUE + i;
                ss.put(values()[i].value, values()[i]);
            }
        }

        public static MODIFY_USER_DRIVER_FORMAT fromInt(int i) {
            return ss.get(i);
        }

        public static int length() {
            return values().length;
        }

        public int value() {
            return value;
        }

    }

    public static enum MODIFY_USER_CUSTOMER_FORMAT {

        // Specify input order here.
        USER_ID, USER_TYPE, FIRST_NAME, LAST_NAME, SEX, AGE;

        private static Map<Integer, MODIFY_USER_CUSTOMER_FORMAT> ss = new TreeMap<Integer, MODIFY_USER_CUSTOMER_FORMAT>();
        private static final int START_VALUE = 0;
        private int value;

        static {
            for (int i = 0; i < values().length; i++) {
                values()[i].value = START_VALUE + i;
                ss.put(values()[i].value, values()[i]);
            }
        }

        public static MODIFY_USER_CUSTOMER_FORMAT fromInt(int i) {
            return ss.get(i);
        }

        public static int length() {
            return values().length;
        }

        public int value() {
            return value;
        }

    }

    public static enum MODIFY_PICKUP_FORMAT {

        // Specify input order here.
        PICKUP_ID, CUSTOMER_ID, DRIVER_ID, ORIGIN_LATITUDE, ORIGIN_LONGTITUDE, DESTINATION_LATITUDE, DESTINATION_LONGITUDE;

        private static Map<Integer, MODIFY_PICKUP_FORMAT> ss = new TreeMap<Integer, MODIFY_PICKUP_FORMAT>();
        private static final int START_VALUE = 0;
        private int value;

        static {
            for (int i = 0; i < values().length; i++) {
                values()[i].value = START_VALUE + i;
                ss.put(values()[i].value, values()[i]);
            }
        }

        public static MODIFY_PICKUP_FORMAT fromInt(int i) {
            return ss.get(i);
        }

        public static int length() {
            return values().length;
        }

        public int value() {
            return value;
        }

    }

    public static enum DELETE_CAR_FORMAT {

        // Specify input order here.
        CAR_ID;

        private static Map<Integer, DELETE_CAR_FORMAT> ss = new TreeMap<Integer, DELETE_CAR_FORMAT>();
        private static final int START_VALUE = 0;
        private int value;

        static {
            for (int i = 0; i < values().length; i++) {
                values()[i].value = START_VALUE + i;
                ss.put(values()[i].value, values()[i]);
            }
        }

        public static DELETE_CAR_FORMAT fromInt(int i) {
            return ss.get(i);
        }

        public static int length() {
            return values().length;
        }

        public int value() {
            return value;
        }

    }

    public static enum DELETE_USER_FORMAT {

        // Specify input order here.
        USER_ID;

        private static Map<Integer, DELETE_USER_FORMAT> ss = new TreeMap<Integer, DELETE_USER_FORMAT>();
        private static final int START_VALUE = 0;
        private int value;

        static {
            for (int i = 0; i < values().length; i++) {
                values()[i].value = START_VALUE + i;
                ss.put(values()[i].value, values()[i]);
            }
        }

        public static DELETE_USER_FORMAT fromInt(int i) {
            return ss.get(i);
        }

        public static int length() {
            return values().length;
        }

        public int value() {
            return value;
        }

    }

    public static enum DELETE_PICKUP_FORMAT {

        // Specify input order here.
        PICKUP_ID;

        private static Map<Integer, DELETE_PICKUP_FORMAT> ss = new TreeMap<Integer, DELETE_PICKUP_FORMAT>();
        private static final int START_VALUE = 0;
        private int value;

        static {
            for (int i = 0; i < values().length; i++) {
                values()[i].value = START_VALUE + i;
                ss.put(values()[i].value, values()[i]);
            }
        }

        public static DELETE_PICKUP_FORMAT fromInt(int i) {
            return ss.get(i);
        }

        public static int length() {
            return values().length;
        }

        public int value() {
            return value;
        }

    }

}
