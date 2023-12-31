package com.jspiders.jdbc.select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SelectDemo4 {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static FileInputStream file;
	private static Properties properties=new Properties();
	private static String driverPath="com.mysql.cj.jdbc.Driver";
	private static String dburl="jdbc:mysql://localhost:3306/weja2";
	private static String filePath="C:\\Users\\saura\\eclipse-coreJAVA-QSP\\JDBC\\resources\\db_info.properties";
	private static String query;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName(driverPath);
			file=new FileInputStream(filePath);
			properties.load(file);
			connection=DriverManager.getConnection(dburl,properties);
			statement=connection.createStatement();
			query="select * from student";
			resultSet=statement.executeQuery(query);
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"||"
						+resultSet.getString(2)+"||"
								+resultSet.getString(3)+"||"
								+resultSet.getString(4));
			}
		}catch(ClassNotFoundException | SQLException |IOException e) {
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
				if(file!=null) {
					file.close();
				}
			}catch(SQLException |IOException e) {
				e.printStackTrace();
			}
		}
	}

}
