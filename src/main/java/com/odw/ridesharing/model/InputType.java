package com.odw.ridesharing.model;

public abstract class InputType {
	
	public static enum Type {CAR, DRIVER, PICKUP, CUSTOMER}
	
	public abstract Type getType();
	
}
