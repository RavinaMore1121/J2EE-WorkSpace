package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo3 {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String driverPath="com.mysql.cj.jdbc.Driver";
	private static String dburl="jdbc:mysql://localhost:3306/weja2";
	private static String user="root";
	private static String password="root";
	private static String query;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName(driverPath);
			connection=DriverManager.getConnection(dburl,user,password);
			statement=connection.createStatement();
			query="select * from student";
			resultSet=statement.executeQuery(query);
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"||"
						+resultSet.getString(2)+"||"
								+resultSet.getString(3)+"||"
								+resultSet.getString(4));
			}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(statement!=null) {
					statement.close();
				}
				if(resultSet!=null) {
					resultSet.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
