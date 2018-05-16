package com.odw.ride_sharing_service;

public abstract class InputType {
	
	public static enum Type {CAR, DRIVER, PICKUP}
	
	public abstract Type getType();
	
}
