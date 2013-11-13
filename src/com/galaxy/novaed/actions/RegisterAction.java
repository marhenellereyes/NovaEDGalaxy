package com.galaxy.novaed.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import com.galaxy.novaed.model.LogInfo;
import com.galaxy.novaed.model.PersonalInfo;
import com.galaxy.novaed.utilities.SQLCommands;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	
	private String firstname;
	private String lastname;
	private String school;
	private String contactno;
	private String username;
	private String password;
	private String hidden;
	private String userType;
	
	private List<String> userTypeList;
	
	
	
	public RegisterAction(){
		
		setUserTypeList(new ArrayList<String>());
		getUserTypeList().add("student");
		getUserTypeList().add("admin");
		getUserTypeList().add("teacher");
		
		hidden = "1";
	}
	
	public String execute(){
		
		if(hidden.equals("1")){
			
			System.out.println("here here");
			return SUCCESS;
			
		}else{

			SQLCommands sql = SQLCommands.getInstance();
			
			LogInfo logInfo = new LogInfo();
			logInfo.setUsername(username);
			logInfo.setPassword(password);
			logInfo.setUserType(userType);
			
			sql.insertLoginInfo(logInfo);
			
			logInfo = sql.getLoginInfo(username, password);
			
			PersonalInfo personalInfo = new PersonalInfo();
			personalInfo.setFirstName(firstname);
			personalInfo.setLastName(lastname);
			personalInfo.setSchool(school);
			personalInfo.setContactNumber(contactno);
			personalInfo.setLogInfo(logInfo);
			
			sql.createUser(personalInfo);
			
			
		
		}
		
		
		
		return SUCCESS;
	}
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getHidden() {
		return hidden;
	}


	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<String> getUserTypeList() {
		return userTypeList;
	}

	public void setUserTypeList(List<String> userTypeList) {
		this.userTypeList = userTypeList;
	}
}
