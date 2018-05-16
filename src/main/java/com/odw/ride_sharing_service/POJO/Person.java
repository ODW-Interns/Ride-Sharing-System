package com.odw.ride_sharing_service.POJO;

public class Person {

    private String firstName;
    private String lastName;
    private String sex;
    private int age;
    
    public Person() {
        this("", "", "", -1);
    }
    
    public Person(String firstName_, String lastName_, String sex_, int age_) {
        firstName = firstName_;
        lastName = lastName_;
        sex = sex_;
        age = age_;
    }
    
    /* Setters and Getters */
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName_) {
        firstName = firstName_;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName_) {
        lastName = lastName_;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex_) {
        sex = sex_;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age_) {
        age = age_;
    }
    
}
