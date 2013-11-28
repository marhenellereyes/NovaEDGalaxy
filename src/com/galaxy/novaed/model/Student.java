package com.galaxy.novaed.model;

public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private String school;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", school=" + school + "]";
	}
	
}
