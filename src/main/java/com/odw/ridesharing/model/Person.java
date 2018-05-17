package com.odw.ridesharing.model;

public class Person {

	private String firstName;
	private String lastName;
	private String sex;
	private int age;

	public Person() {
		this("", "", "", -1);
	}

	/**
	 * Store the information of this person
	 * 
	 * @param firstName This person's first name
	 * 
	 * @param lastName_ This person's last name
	 * 
	 * @param sex_ This person's gender
	 * 
	 * @param age_ This person's age
	 */
	public Person(String firstName_, String lastName_, String sex_, int age_) {
		setFirstName(firstName_);
		setLastName(lastName_);
		setSex(sex_);
		setAge(age_);
	}

	/**
	 * Get the first name of this person
	 * 
	 * @return firstName This person's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the first name of this person
	 * 
	 * @param firstName_ The first name of this person to be set
	 */
	public void setFirstName(String firstName_) {
		firstName = firstName_;
	}

	/**
	 * Get the last name of this person
	 * 
	 * @return lastName This person's last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Set the last name of this person
	 * 
	 * @param lastName_ This person's last name to be set
	 */
	public void setLastName(String lastName_) {
		lastName = lastName_;
	}
	
	/**
	 * Get the gender of this person
	 * 
	 * @return sex This person's gender
	 * 			   It should return "male" or "female"
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Set the gender of this person
	 * 
	 * @param sex_ This person's gender to be set
	 */
	public void setSex(String sex_) {
		sex = sex_;
	}

	/**
	 * Get the age of this person
	 * 
	 * @return the person's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Set the age of this person
	 * 
	 * @param age_ This person's age to be set
	 */
	public void setAge(int age_) {
		age = age_;
	}

}
