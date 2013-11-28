package com.galaxy.novaed.actions;

import java.util.Map;

import com.galaxy.novaed.model.Group;
import com.galaxy.novaed.model.LogInfo;
import com.galaxy.novaed.utilities.SQLCommands;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreateGroupAction extends ActionSupport{
	
	private String name;
	private String description;
	private String hidden;
	
	public CreateGroupAction(){
		
		
		this.hidden="1";
		
	}
	
	public String execute(){
			
		System.out.println(name);
		System.out.println(description);
		
		if(this.hidden.equalsIgnoreCase("0")){
			
			System.out.println("SQL: processing...");
			SQLCommands sql = SQLCommands.getInstance();
			
			Group group = new Group();
			
			group.setName(name);
			group.setDescription(description);
			int n = sql.createGroup(group);
			System.out.println(n);
			
		}
		
			return SUCCESS;
			
		}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	
}
