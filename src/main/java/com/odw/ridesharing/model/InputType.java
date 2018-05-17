package com.odw.ridesharing.model;

public abstract class InputType {
	
	public static enum Types {CAR, DRIVER, PICKUP, CUSTOMER}
	
	public abstract Types getType();
	
}
