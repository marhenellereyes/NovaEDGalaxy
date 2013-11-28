package com.galaxy.novaed.connection;

import java.sql.*;


public class ConnectionClass {

	private static Connection connection;
		
	public static Connection getConnection()
	{
		if(connection == null)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = (Connection) DriverManager
						.getConnection("jdbc:mysql://localhost/novaed_galaxy2?user=root");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return connection;
	} 
}
