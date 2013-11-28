package com.galaxy.novaed.actions;

import java.util.HashMap;
import java.util.Map;

import com.galaxy.novaed.utilities.SQLCommands;
import com.opensymphony.xwork2.ActionSupport;

public class EditGroupAction extends ActionSupport{

	private String selectedGroup;
	
	private Map<Integer, String> trainees;
	private Map<Integer, String> groups;
	private int hidden;
	private String[] trainee_set;
	
	public EditGroupAction() {
		
		SQLCommands sql = SQLCommands.getInstance();
		
		
		trainees = sql.getActiveTrainees();
		setGroups(sql.getGroups());
		
		for (String name : getGroups().values()) {
			System.out.println(name);
		}

		
		setHidden(1);
		
	}
	
	public String execute(){
		
		
		if(getHidden()==0){
			
			SQLCommands sql = SQLCommands.getInstance();
			
			if(trainee_set != null){
				for(int i = 0; i < trainee_set.length ; i++){
					System.out.println(trainee_set[i]);
				}
			}
			
			sql.addStudentsToGroup(selectedGroup, trainee_set);
			
			
			
		}
		
		
		
		
		return SUCCESS;
	}

	public Map<Integer, String> getTrainees() {
		return trainees;
	}

	public void setTrainees(Map<Integer, String> trainees) {
		this.trainees = trainees;
	}

	public String[] getTrainee_set() {
		return trainee_set;
	}

	public void setTrainee_set(String[] trainee_set) {
		this.trainee_set = trainee_set;
	}

	public String getSelectedGroup() {
		return selectedGroup;
	}

	public void setSelectedGroup(String selectedGroup) {
		this.selectedGroup = selectedGroup;
	}

	public Map<Integer, String> getGroups() {
		return groups;
	}

	public void setGroups(Map<Integer, String> groups) {
		this.groups = groups;
	}

	public int getHidden() {
		return hidden;
	}

	public void setHidden(int hidden) {
		this.hidden = hidden;
	}
	
}


