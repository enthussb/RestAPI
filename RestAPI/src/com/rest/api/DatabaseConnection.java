package com.rest.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseConnection 
{
	String DB_URL = "jdbc:mysql://127.0.0.1:3306/";
	String dbname="testapi";
	String USER = "root";
	String PASS = "";
    Connection conn = null;
    
    public DatabaseConnection() throws ClassNotFoundException, SQLException
    {
    	System.out.println("Inside Database Connection");
    	Class.forName("com.mysql.jdbc.Driver");
    	conn = DriverManager.getConnection(DB_URL+dbname,USER,PASS);
    	System.out.println("Connected to database");
    }
    public ArrayList<Customer> retrieve() throws SQLException
    {
    	ArrayList<Customer> al = new ArrayList<Customer>();
    	PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String name = null,city = null,country = null;
		long ph_no = 0;
		
	    preparedStatement = conn.prepareStatement("Select * from records");
	    resultSet = preparedStatement.executeQuery();
	   
	    while (resultSet.next()) 
	    {
             name = resultSet.getString(1);
             ph_no = resultSet.getLong(2);
             city = resultSet.getString(3);
             country = resultSet.getString(4);
             al.add(new Customer(name,city,country,ph_no));
	    }
	    return al;
    }
    public void storeinDB(ArrayList<Customer> al) throws SQLException
    {
    	PreparedStatement preparedStatement = null;
 		preparedStatement = conn.prepareStatement("insert into records1 values (?, ?, ?, ?)");
         
 		for (Customer cust : al) 
 		{ 		      
 			preparedStatement.setString(1, cust.getCustomerName());
 	        preparedStatement.setLong(2, cust.getCustomerPhoneNo());
 	        preparedStatement.setString(3, cust.getCustomerCity());
 	        preparedStatement.setString(4, cust.getCustomerCountry());
 	        preparedStatement.executeUpdate();   		
 		}
        System.out.println("Successfully added record to database");
    }
}
