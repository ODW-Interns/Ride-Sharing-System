package com.odw.ride_sharing_service.POJO;

public abstract class InputType {
	
	public static enum Type {CAR, DRIVER, PICKUP, CUSTOMER}
	
	public abstract Type getType();
	
}
