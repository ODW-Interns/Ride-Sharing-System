package com.odw.ride_sharing_service;

public class Employee {

    private int employeeAge;
    private int employeeId;
    private int employeeRating;
    private int employeeSalary;
    private String employeeName;
    private String employeeSex;

    //TODO: add private Car employeeCar;

    public int getEmployeeAge() {
        return employeeAge;
    }
    public void setEmployeeAge(int employeeAge_) {
        employeeAge = employeeAge_;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId_) {
        employeeId = employeeId_;
    }
    public int getEmployeeRating() {
        return employeeRating;
    }
    public void setEmployeeRating(int employeeRating_) {
        employeeRating = employeeRating_;
    }
    public int getEmployeeSalary() {
        return employeeSalary;
    }
    public void setEmployeeSalary(int employeeSalary_) {
        employeeSalary = employeeSalary_;
    }
    public String getEmployeeName() {
        return employeeName;
	}
    public void setEmployeeName(String employeeName_) {
        employeeName = employeeName_;
    }
    public String getEmployeeSex() {
        return employeeSex;
    }
    public void setEmployeeGender(String employeeSex_) {
        employeeSex = employeeSex_;
    }

}