package com.jspider.jdbc.dynamic;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class DynamicDelete {
	private static Connection connection;
	private static Statement statement;
	private static int result;
	private static PreparedStatement preparedStatement;
	private static FileInputStream file;
	
	private static Properties properties=new Properties();
	private static String driverPath="com.mysql.cj.jdbc.Driver";
	private static String dburl="jdbc:mysql://localhost:3306/weja2";
	private static String filePath="C:\\Users\\saura\\eclipse-coreJAVA-QSP\\JDBC\\resources\\db_info.properties";
	private static String query;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			file=new FileInputStream(filePath);
			properties.load(file);
			Class.forName(properties.getProperty("driverPath"));
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			statement=connection.createStatement();
			query = "delete from student where sid=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			result=preparedStatement.executeUpdate();
			System.out.println("Query Ok,"+result+"row(s) affected.");
		}catch(ClassNotFoundException | SQLException |IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(preparedStatement!=null) {
					preparedStatement.close();
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


