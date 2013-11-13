package com.galaxy.novaed.utilities;

import java.sql.*;

import com.galaxy.novaed.connection.ConnectionClass;
import com.galaxy.novaed.model.LogInfo;
import com.galaxy.novaed.model.PersonalInfo;

public class SQLCommands {

	private static SQLCommands instance;
	private static Connection connection;
	
	private SQLCommands(){
		
		connection = ConnectionClass.getConnection();	
		
	}
	
	public static SQLCommands getInstance(){
		
		if(instance==null){
			instance = new SQLCommands();
		}
		
		return instance;
		
	}
	
	public LogInfo getLoginInfo(String username, String password){
		
		ResultSet rs = null;
		LogInfo logInfo = null;
		
		try {
			PreparedStatement psmt = connection.prepareStatement("SELECT * FROM login WHERE username=? AND password=?");
			psmt.setString(1, username);
			psmt.setString(2, password);
			
			rs = psmt.executeQuery();
			logInfo = new LogInfo();
			while(rs.next()){
				logInfo.setUsername(rs.getString("username"));
				logInfo.setId(rs.getInt("id"));
				logInfo.setUserType(rs.getString("user_type"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return logInfo;
	}
	
	public int insertLoginInfo(LogInfo logInfo){
	
		try {
			PreparedStatement psmt = connection.prepareStatement("INSERT INTO login(username,password,user_type) VALUES(?,?,?)");
			psmt.setString(1, logInfo.getUsername());
			psmt.setString(2, logInfo.getPassword());
			psmt.setString(3, logInfo.getUserType());
			int i = psmt.executeUpdate();
			
			System.out.println("executing query... " + i);
			
			return i;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
		return -1;
	}

	public int createUser(PersonalInfo personalInfo) {
		
		try {
			PreparedStatement psmt = connection.prepareStatement(
					"insert into personal_info(first_name,last_name,school,contact_number,login_id) values(?,?,?,?,?)"
					);
			psmt.setString(1, personalInfo.getFirstName());
			psmt.setString(2, personalInfo.getLastName());
			psmt.setString(3, personalInfo.getSchool());
			psmt.setString(4, personalInfo.getContactNumber());
			psmt.setInt(5, personalInfo.getLogInfo().getId());		
			int i = psmt.executeUpdate();
			return i;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return -1;
	}
	
	
}
