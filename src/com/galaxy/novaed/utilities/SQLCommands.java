package com.galaxy.novaed.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.galaxy.novaed.connection.ConnectionClass;
import com.galaxy.novaed.model.Group;
import com.galaxy.novaed.model.LogInfo;
import com.galaxy.novaed.model.PersonalInfo;
import com.galaxy.novaed.model.Student;

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
			PreparedStatement psmt = connection.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
			psmt.setString(1, username);
			psmt.setString(2, password);
			
			rs = psmt.executeQuery();
			logInfo = new LogInfo();
			while(rs.next()){
				logInfo.setUsername(rs.getString("username"));
				logInfo.setId(rs.getInt("id"));
				logInfo.setUserType(rs.getInt("user_type_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return logInfo;
	}
	
	public int insertLoginInfo(LogInfo logInfo){
	
		try {
			PreparedStatement psmt = connection.prepareStatement("INSERT INTO user(username,password,user_type_id) VALUES(?,?,?)");
			psmt.setString(1, logInfo.getUsername());
			psmt.setString(2, logInfo.getPassword());
			psmt.setInt(3, logInfo.getUserType());
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
					"insert into personal_info(first_name,last_name,school,contact_number,user_id) values(?,?,?,?,?)"
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
	
	public int createGroup(Group group){
		
		try {
			PreparedStatement psmt = connection.prepareStatement(
					"INSERT INTO `group` (`name`, `description`) VALUES (?,?);"
			);
			psmt.setString(1, group.getName());
			psmt.setString(2, group.getDescription());
			int i = psmt.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return -1;
	}
	
	public Map<Integer,String> getActiveTrainees(){
		
		ResultSet rs = null;
		Map<Integer,String> trainees = new HashMap<Integer,String>();
		
		
		try {
			PreparedStatement psmt = connection.prepareStatement("SELECT * FROM user JOIN personal_info ON user.id = personal_info.user_id WHERE status_id = 1 AND user_type_id = 2");

			rs = psmt.executeQuery();
			
			while(rs.next()){
				
				PersonalInfo personalInfo = new PersonalInfo();
				personalInfo.setId(rs.getInt("user_id"));
				personalInfo.setFirstName(rs.getString("first_name"));
				personalInfo.setLastName(rs.getString("last_name"));
				personalInfo.setSchool(rs.getString("school"));
				
				trainees.put(personalInfo.getId(), personalInfo.getLastName() + " " + personalInfo.getFirstName() +  "\t | \t" + personalInfo.getSchool() );
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return trainees;
	}

	public Map<Integer, String> getGroups() {
		
		
		ResultSet rs = null;
		Map<Integer,String> groups = new HashMap<Integer,String>();
		
		
		try {
			PreparedStatement psmt = connection.prepareStatement("select * from `group`");
			
			rs = psmt.executeQuery();
			
			while(rs.next()){
				
				Group group = new Group();
				group.setId(rs.getInt("id"));
				group.setName(rs.getString("name"));
				group.setDescription(rs.getString("description"));
				
				groups.put(group.getId(), group.getName());
				
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return groups;

	}

	public void addStudentsToGroup(String selectedGroup, String[] trainee_set) {

		
		try {
			PreparedStatement psmt = connection.prepareStatement(
					"INSERT INTO `user_group` (`group_id`, `user_id`) VALUES (?,?);"
			);
			
			int intGroup = Integer.parseInt(selectedGroup);
			
			for(String trainee: trainee_set){
				
				psmt.setInt(1, intGroup);
				psmt.setInt(2, Integer.parseInt(trainee));
				psmt.addBatch();
				
			}
			
			psmt.executeBatch();
			psmt.close();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	public List<Group> getGroupsWithStudents() {

		ResultSet rs = null;
		List<Group> groups = new ArrayList<Group>();
		
		
		
		try {
			PreparedStatement psmt = connection.prepareStatement("select * from `group`");
			
			
			rs = psmt.executeQuery();
			
			while(rs.next()){
				
				List<Student> students = new ArrayList<Student>();
				
				Group group = new Group();
				group.setId(rs.getInt("id"));
				group.setName(rs.getString("name"));
				group.setDescription(rs.getString("description"));
				
				PreparedStatement psmt2 = connection.prepareStatement("select * from `user_group` WHERE group_id = '" + group.getId() +"'");
			
				ResultSet rs2 = null;
				
				rs2 = psmt2.executeQuery();
				
				while(rs2.next()){
					
					
					
					PreparedStatement psmt3 = connection.prepareStatement("select * from `personal_info` WHERE user_id = '" + rs2.getInt("user_id") +"'");
					ResultSet rs3 = null;
					rs3 = psmt3.executeQuery();
				
					
					while(rs3.next()){
						
						Student student = new Student();
						student.setFirstName(rs3.getString("first_name"));
						student.setLastName(rs3.getString("last_name"));
						student.setId(rs3.getInt("user_id"));
						student.setSchool(rs3.getString("school"));
				
						students.add(student);
						
					}

				}				
				
				group.setStudents(students);
				groups.add(group);
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return groups;

	}
	
	public List<Student> getStudentsByGroup(){
		
		
		return null;
	}
	
	
	
}
