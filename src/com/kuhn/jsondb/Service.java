package com.kuhn.jsondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//数据库连接服务
public class Service {
	
	private static String url = "jdbc:mysql://127.0.0.1:3306/kuhn";
	private static String user = "root";
	private static String passwd ="szxpek";
	public static Connection conn;


	
	
	public static Connection getConnection(){

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,passwd);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	

	
	
}
