package com.galaxy.novaed.model;

public class PersonalInfo {
	
	private int id;
	private String firstName;
	private String lastName;
	private String school;
	private String contactNumber;
	private LogInfo logInfo;
	
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
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public LogInfo getLogInfo() {
		return logInfo;
	}
	public void setLogInfo(LogInfo logInfo) {
		this.logInfo = logInfo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
