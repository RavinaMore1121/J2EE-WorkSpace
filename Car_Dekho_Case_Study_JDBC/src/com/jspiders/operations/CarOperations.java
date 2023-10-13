package com.jspiders.operations;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.jspiders.jdbc.select.CarDekho;
import com.jspiders.jdbc.source.Car;
public class CarOperations {
	    private static Connection connection;
		private static PreparedStatement preparedStatement;
		private static ResultSet resultSet;
		private static int result;
		private static FileInputStream file;
		private static Properties properties=new Properties();
		private static String filePath="C:\\Users\\saura\\eclipse-coreJAVA-QSP\\Car_Dekho_Case_Study_JDBC\\resources\\db_info.properties";
		private static String query;
	    public static void OpenConnection() {
	    	try {
	    	file = new FileInputStream(filePath);
			properties.load(file);
			Class.forName(properties.getProperty("driverPath"));
			connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    public void CloseConnection() {
	    	try {
				if(connection!=null) {
					connection.close();
				}
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				if(resultSet!=null) {
					resultSet.close();
				}
				if(file!=null) {
					file.close();
				}
				if(result!=0) {
					result=0;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }
	    CarDekho carDekho=new CarDekho();
	    List <Car> cars=new ArrayList<Car>();
	    Car car1=new Car();
		public void add()
		{
				try {
					OpenConnection();
					Scanner obj2=new Scanner(System.in);
					System.out.println("Enter Car Id: ");
					int c_id=obj2.nextInt();
					System.out.println("Enter Car name: ");
					String c_name=obj2.next();
					System.out.println("Enter Model: ");
					String model=obj2.next();
					System.out.println("Enter Brand of Car: ");
					String brand=obj2.next();
					System.out.println("Enter Fuel type: ");
					String fuel=obj2.next();
					System.out.println("Enter price of car");
					Double price=obj2.nextDouble();
					query="insert into car(c_id,c_name,model,brand,fuel,price) values(?,?,?,?,?,?)";
				    preparedStatement = connection.prepareStatement(query);
				    preparedStatement.setInt(1,c_id);
				    preparedStatement.setString(2,c_name);
				    preparedStatement.setString(3, model);
				    preparedStatement.setString(4, brand);
				    preparedStatement.setString(5, fuel);
				    preparedStatement.setDouble(6, price);
				    result=preparedStatement.executeUpdate();
				    System.out.println("Query OK, "+result+ "row(s) affected.");
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					CloseConnection();
				}
		}
		public void delete()
		{
			try {
				OpenConnection();
				try {
					OpenConnection();
					query="select * from car";
				    preparedStatement = connection.prepareStatement(query);
				    resultSet=preparedStatement.executeQuery();
				}catch(Exception e) {
					e.printStackTrace();
				}
				Scanner sc=new Scanner(System.in);
				System.out.println("enter Car_Id which you want to delete?");
				int deleteId=sc.nextInt();
				query="delete from car where c_id=?";
				preparedStatement = connection.prepareStatement(query);
			    preparedStatement.setInt(1,deleteId);
				result=preparedStatement.executeUpdate();
			    System.out.println("Query OK, "+result+ "row(s) affected.");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				CloseConnection();
			}	
		}
		public void update()
		{
			try {
				OpenConnection();
				try{
					OpenConnection();
					query="select * from car";
				    preparedStatement = connection.prepareStatement(query);
				    resultSet=preparedStatement.executeQuery();
				}catch(Exception e) {
					e.printStackTrace();
				}
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter Car_ID to update the record");
				int UpdateId=sc.nextInt();
				System.out.println("Enter new Details to update");
				System.out.println("Name: ");
				String c_name=sc.next();
				System.out.println("Model: ");
				String model=sc.next();
				System.out.println("Brand: ");
				String brand=sc.next();
				System.out.println("Fuel: ");
				String fuel=sc.next();
				System.out.println("Price: ");
				double price=sc.nextDouble();
				query="update car SET c_name=?, model=?, brand=?, fuel=?, price=? where c_id=?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1,c_name);
				preparedStatement.setString(2,model);
				preparedStatement.setString(3, brand);
				preparedStatement.setString(4, fuel);
				preparedStatement.setDouble(5, price);
				preparedStatement.setInt(6, UpdateId);
				int rowsUpdated=preparedStatement.executeUpdate();
				result=preparedStatement.executeUpdate();
			    System.out.println("Query OK, "+result+ "row(s) affected.");	    
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				CloseConnection();
			}
		}
		public void search()
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("-----------------Menu----------------");
			System.out.println("1.Search By Car_Id\n2.Search By Name\n3.Search By Model\n4.Search By Brand\n5.Search By Fuel\n6.Search By Price");
			System.out.println("Enter Your Choice :");
		    int ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					searchById();
				break;
				case 2:
					searchByName();
				break;
				case 3:
					searchByModel();
				break;
				case 4:
					searchByBrand();
				break;
				case 5:
					searchByFuel();
				break;
				case 6:
					searchByPrice();
				break;
				default:
					System.out.println("Invalid Choice");
				break;
			}
		}
		public void searchById()
		{
			try {
				OpenConnection();
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter Car ID for Searching");
				query="select * from car where c_id=?";
			    preparedStatement = connection.prepareStatement(query);
			    preparedStatement.setInt(1,sc.nextInt());
			    resultSet=preparedStatement.executeQuery();
			    boolean found=false;
			    while(resultSet.next()) {
			    	found=true;
			    	System.out.println(resultSet.getInt(1)+" | "
			    			+resultSet.getString(2)+" | "
			    			+resultSet.getString(3)+" | "
			    			+resultSet.getString(4)+" | "
			    			+resultSet.getString(5)+" |"
			    			+resultSet.getDouble(6));
			    }
			    if(found==false) { System.out.println("no result found"); }
			    System.out.println("Query OK, "+result+ "row(s) affected.");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				CloseConnection();
			}
		}
		public void searchByName()
		{
			try {
				OpenConnection();
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter Car name for Searching");
				String searchName=sc.next();
				query="select * from car where c_name=?";
			    preparedStatement = connection.prepareStatement(query);
			    preparedStatement.setString(1,searchName);
			    resultSet=preparedStatement.executeQuery();
			    System.out.println("Query OK, "+result+ "row(s) affected.");
			    boolean found=false;
			    while(resultSet.next()) {
			    	found=true;
			    	System.out.println(resultSet.getInt(1)+" | "
			    			+resultSet.getString(2)+" | "
			    			+resultSet.getString(3)+" | "
			    			+resultSet.getString(4)+" | "
			    			+resultSet.getString(5)+" |"
			    			+resultSet.getDouble(6));
			    }
			    if(found==false) { System.out.println("No result found!!!"); }
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				CloseConnection();
			}
		}
		public void searchByBrand()
		{
			try {
				OpenConnection();
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter Car Brand for searching");
				String searchBrand=sc.next();
				query="select from car where brand=?";
			    preparedStatement = connection.prepareStatement(query);
			    preparedStatement.setString(1,searchBrand);
			    resultSet=preparedStatement.executeQuery();
			    System.out.println("Query OK, "+result+ "row(s) affected.");
			    boolean found=false;
			    while(resultSet.next()) {
			    	found=true;
			    	System.out.println(resultSet.getInt(1)+" | "
			    			+resultSet.getString(2)+" | "
			    			+resultSet.getString(3)+" | "
			    			+resultSet.getString(4)+" | "
			    			+resultSet.getString(5)+" |"
			    			+resultSet.getDouble(6));
			    }
			    if(found==false) { System.out.println("No result found!!!"); }
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				CloseConnection();
			}
		}
		public void searchByModel()
		{
			try {
				OpenConnection();
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter Model for searching");
				String searchModel=sc.next();
				query="select from car where model=?";
			    preparedStatement = connection.prepareStatement(query);
			    preparedStatement.setString(1,searchModel);
			    resultSet=preparedStatement.executeQuery();
			    System.out.println("Query OK, "+result+ "row(s) affected.");
			    boolean found=false;
			    while(resultSet.next()) {
			    	found=true;
			    	System.out.println(resultSet.getInt(1)+" | "
			    			+resultSet.getString(2)+" | "
			    			+resultSet.getString(3)+" | "
			    			+resultSet.getString(4)+" | "
			    			+resultSet.getString(5)+" |"
			    			+resultSet.getDouble(6));
			    }
			    if(found==false) {
			    	System.out.println("No result found!!!");
			    }
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				 CloseConnection();
			}
		}
		public void searchByFuel()
		{
			try {
				OpenConnection();
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter Fuel for searching");
				String searchFuel=sc.next();
				query="select * from car where fluel=?";
			    preparedStatement = connection.prepareStatement(query);
			    preparedStatement.setString(1,searchFuel);
			    resultSet=preparedStatement.executeQuery();
			    System.out.println("Query OK, "+result+ "row(s) affected.");
			    boolean found=false;
			    while(resultSet.next()) {
			    	found=true;
			    	System.out.println(resultSet.getInt(1)+" | "
			    			+resultSet.getString(2)+" | "
			    			+resultSet.getString(3)+" | "
			    			+resultSet.getString(4)+" | "
			    			+resultSet.getString(5)+" |"
			    			+resultSet.getDouble(6));
			    }
			    if(found==false) { System.out.println("No result found!!!"); }
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				CloseConnection();
			}
		}
		public void searchByPrice()
		{
			try {
				OpenConnection();
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter Car price for Searching");
				double searchPrice=sc.nextDouble();
				query="select from car where price=?";
			    preparedStatement = connection.prepareStatement(query);
			    preparedStatement.setDouble(1,searchPrice);
			    resultSet=preparedStatement.executeQuery();
			    System.out.println("Query OK, "+result+ "row(s) affected.");
			    boolean found=false;
			    while(resultSet.next()) {
			    	found=true;
			    	System.out.println(resultSet.getInt(1)+" | "
			    			+resultSet.getString(2)+" | "
			    			+resultSet.getString(3)+" | "
			    			+resultSet.getString(4)+" | "
			    			+resultSet.getString(5)+" |"
			    			+resultSet.getDouble(6));
			    }
			    if(found==false) { System.out.println("No result Found!!!"); }
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				CloseConnection();
			}
		} 
		public void display()
		{
			try {
				OpenConnection();
				query="select * from car";
			    preparedStatement = connection.prepareStatement(query);
			    resultSet=preparedStatement.executeQuery();
			    while(resultSet.next()) {
			    	System.out.println(resultSet.getInt(1)+" | "
			    			+resultSet.getString(2)+" | "
			    			+resultSet.getString(3)+" | "
			    			+resultSet.getString(4)+" | "
			    			+resultSet.getString(5)+" |"
			    			+resultSet.getDouble(6));
			    }
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				CloseConnection();
			}
		}
}
