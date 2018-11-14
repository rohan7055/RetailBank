package com.ilp.tcs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtil {
	
	private static final String drivername= "oracle.jdbc.OracleDriver";
	private static final String url= "jdbc:oracle:thin:@localhost:1521:XE"; 
	private static final String username= "system";
	private static final String password= "abc12345"; 
	
	
	public static Connection getConnection(){
		
		Connection conn = null;
		
		try {
				Class.forName(drivername);
				
				conn = DriverManager.getConnection(url, username, password);
				
				
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Driver cannot be loaded");
				
		}catch (SQLException e ) {
			// TODO Auto-generated catch block
			System.out.println("Connection cannot be established");
		}
		
		return conn;
	}
	
	
	public static void closeConnection(Connection conn){
		
		if(conn != null){
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void closeStatement(PreparedStatement ps){
		
		if(ps != null){
			try{
				ps.close();
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}
}
