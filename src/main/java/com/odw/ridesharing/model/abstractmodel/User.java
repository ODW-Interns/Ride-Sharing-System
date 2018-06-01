package com.odw.ridesharing.model.abstractmodel;

/**
 * User class is an abstract class that has two concrete classes: Customer
 * and Driver. As Customer and Drivers share many attributes and are both
 * Users of the system, they share the same base frame. This class allows 
 * for scalable approach to add Admin User or other forms.
 */
public abstract class User {

    protected int userID;
    protected String firstName;
    protected String lastName;
    protected String sex;
    protected int age;

    public User() {
        this(-1, "", "", "", -1);
    }

    /**
     * Store the information of this user
     * 
     * @param firstName
     *            This user's first name
     * 
     * @param lastName_
     *            This user's last name
     * 
     * @param sex_
     *            This user's gender
     * 
     * @param age_
     *            This user's age
     */
    public User(int userID_, String firstName_, String lastName_, String sex_, int age_) {
        setFirstName(firstName_);
        setLastName(lastName_);
        setSex(sex_);
        setAge(age_);
        setUserID(userID_);
    }

    /**
     * Returns the user's information in String format using a specified delimiter.
     * 
     * @param delimiter_
     *            The delimiter to separate the values.
     * @return The user information as a String.
     */
    /* @formatter:off */
    public String toString(String delimiter_) {
        return delimiter_ + " " +
               "UserID: " + getUserID() + " " + delimiter_ + " " +
               "First Name: " + getFirstName() + " " + delimiter_ + " " + 
               "Last Name: " + getLastName() + " " + delimiter_ + " " +
               "Sex: " + getSex() + " " + delimiter_ + " " +
               "Age: " + getAge() + " " + delimiter_;
    }
    /* @formatter:on */

    /**
     * Returns the user's information in String format. Using pipes ("|") as the
     * default delimiter.
     * 
     * @return The user information as a String.
     */
    @Override
    public String toString() {
        return toString("|");
    }

    /**
     * Get the first name of this user
     * 
     * @return firstName This user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of this user
     * 
     * @param firstName_
     *            The first name of this user to be set
     */
    public void setFirstName(String firstName_) {
        firstName = firstName_;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID_) {
        userID = userID_;
    }

    /**
     * Get the last name of this user
     * 
     * @return lastName This user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of this user
     * 
     * @param lastName_
     *            This user's last name to be set
     */
    public void setLastName(String lastName_) {
        lastName = lastName_;
    }

    /**
     * Get the gender of this user
     * 
     * @return sex This user's gender It should return "male" or "female"
     */
    public String getSex() {
        return sex;
    }

    /**
     * Set the gender of this user
     * 
     * @param sex_
     *            This user's gender to be set
     */
    public void setSex(String sex_) {
        sex = sex_;
    }

    /**
     * Get the age of this user
     * 
     * @return the user's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the age of this user
     * 
     * @param age_
     *            This user's age to be set
     */
    public void setAge(int age_) {
        age = age_;
    }

}