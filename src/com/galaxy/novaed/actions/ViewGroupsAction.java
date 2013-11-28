package com.galaxy.novaed.actions;

import java.util.List;

import com.galaxy.novaed.model.Group;
import com.galaxy.novaed.model.Student;
import com.galaxy.novaed.utilities.SQLCommands;
import com.opensymphony.xwork2.ActionSupport;

public class ViewGroupsAction extends ActionSupport{

	private List<Group> groups;
	
	public String execute(){
		
		SQLCommands sql = SQLCommands.getInstance();
		
		setGroups(sql.getGroupsWithStudents());
		
		
		
		for (Group group : getGroups()) {
			
			System.out.println(group.getName());
			System.out.println("--------");
			for (Student student : group.getStudents()) {
				System.out.println(student.getFirstName());
				
			}
		}
		
		
		return SUCCESS;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	
	
}
