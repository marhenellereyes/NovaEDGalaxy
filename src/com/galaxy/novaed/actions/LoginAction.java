package com.galaxy.novaed.actions;

import java.util.Map;

import com.galaxy.novaed.model.LogInfo;
import com.galaxy.novaed.utilities.SQLCommands;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	private String username;
	private String password;
	private LogInfo logInfo;
	
	public String execute(){
		
		SQLCommands sql = SQLCommands.getInstance();
		setLogInfo(sql.getLoginInfo(username, password));
		System.out.println(getLogInfo() + username + " " + password);
		
		if(getLogInfo().getId()==0){
			return "success";
		}
			
		
			Map session = ActionContext.getContext().getSession();
			session.put("logged-in", "true");
			session.put("logInfo", getLogInfo());
			
			return getLogInfo().getUserType();
			
	}
	
	public  String logout(){
		
		Map session = ActionContext.getContext().getSession();
		session.remove("logged-in");
		
		return SUCCESS;
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

	public LogInfo getLogInfo() {
		return logInfo;
	}

	public void setLogInfo(LogInfo logInfo) {
		this.logInfo = logInfo;
	}
}
