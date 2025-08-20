package com.naidu.p3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
	static Connection con=null;
	static String url="jdbc:mysql://localhost:3306/yugandhar";
	static String un="root";
	static String pw="root123";
	

	public static Connection requestConnection()throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url, un, pw);
		return con;
		
	}
}
