package com.galaxy.novaed.actions;

import com.opensymphony.xwork2.ActionSupport;

public class CreateClassAction extends ActionSupport{
	
	private String name;
	
	public String execute(){
		
		
		System.out.println(name);
		
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
