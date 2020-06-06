package com.projeto.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static ConnectionUtil connectionUtil;
	
	public static ConnectionUtil getInstance() {
		if(connectionUtil == null) {
			connectionUtil = new ConnectionUtil();
		}
		return connectionUtil;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456789");
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(ConnectionUtil.getInstance().getConnection());
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
}
