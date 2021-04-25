package com.user.project.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class project {
//abc
	
	
	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");

	 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget", "root", "");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 } 
	
	public String insertItem(String Project, String OwnerName, String Duration, String Email, String Description)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
		 return "Error while connecting to the database for inserting."; 
	}
	 // create a prepared statement
	 String query = "insert into project(`Project`,`OwnerName`,`Duration`,`Email`,`Description`)" + " values (?, ?, ?, ?, ?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 //preparedStmt.setInt(1, 0);
	 preparedStmt.setString(1, Project);
	 preparedStmt.setString(2, OwnerName);
	 preparedStmt.setString(3, Duration);
	 preparedStmt.setString(4, Email);
	 preparedStmt.setString(5, Description);
	 
	 preparedStmt.execute();
	 con.close();
	 output = "Inserted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while inserting the item.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 } 
	//display
	public String readItems()
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	 // Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>PID</th><th>Project</th>" +
	 "<th>OwnerName</th>" +
	 "<th>Duration</th>" +
	 "<th>Email</th>" +
	 "<th>Description</th>" +
	 "<th>Update</th><th>Remove</th></tr>";

	 String query = "select * from project";
	 java.sql.Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 String PID = Integer.toString(rs.getInt("PID"));
	 String Project = rs.getString("Project");
	 String OwnerName = rs.getString("OwnerName");
	 String Duration = rs.getString("Duration");
	 String Email =rs.getString("Email");
	 String Description = rs.getString("Description");
	 // Add into the html table
	 output += "<tr><td>" + PID + "</td>";
	 output += "<td>" + Project + "</td>";
	 output += "<td>" + OwnerName + "</td>";
	 output += "<td>" + Duration + "</td>";
	 output += "<td>" + Email + "</td>";
	 output += "<td>" + Description + "</td>";
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='items.jsp'>" + "<input name='PID' type='hidden' value='" + PID
	 + "'>" + "</form></td></tr>";
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the items.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	
	//update
	public String updateItem(int PID, String Project, String OwnerName, String Duration, String Email, String Description)
	{
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for updating."; }
		 // create a prepared statement
		 String query = "UPDATE project SET Project=?,OwnerName=?,Duration=?,Email=?,Description=? WHERE PID=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		
		 preparedStmt.setString(1, Project);
		 preparedStmt.setString(2, OwnerName);
		 preparedStmt.setString(3, Duration);
		 preparedStmt.setString(4, Email);
		 preparedStmt.setString(5, Description);
		 preparedStmt.setInt(6, PID);
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Updated successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while updating the item.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 } 
	
	
	
	
	
	//Delete record...
	
	public String deleteItem(String PID)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 String query = "delete from project where PID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setString(1, (PID));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Deleted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while deleting the item.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 } 
	
	
}
