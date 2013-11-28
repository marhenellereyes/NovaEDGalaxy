package com.galaxy.novaed.actions;

import java.util.Map;

import com.galaxy.novaed.model.LogInfo;
import com.galaxy.novaed.utilities.SQLCommands;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	
	private LogInfo logInfo;

	public String execute(){
		
		Map session = ActionContext.getContext().getSession();
		setLogInfo((LogInfo)session.get("logInfo"));
		
		return "success";
		
	}

	public LogInfo getLogInfo() {
		return logInfo;
	}

	public void setLogInfo(LogInfo logInfo) {
		this.logInfo = logInfo;
	}
}
