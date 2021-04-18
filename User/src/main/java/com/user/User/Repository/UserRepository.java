package com.user.User.Repository;

import java.beans.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.ws.rs.core.Response;

import com.user.User.model.User;

public class UserRepository {

	
	
	Connection con = null;
	
	  
	 public UserRepository() {
		 
		 String url = "jdbc:mysql://localhost:3306/restdb";
		 String username = "root";
		 String password = "";
		 
		 
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		
		
	}
		catch(Exception e)	{
			
			System.out.println("Connection Error");
			e.printStackTrace();
		}
		 
	 }
	 
	 public ArrayList<User> getUsers(){
		 
		 
		 ArrayList<User> users = new  ArrayList<User>();
		 String sql = "select * from user";
		 try {
		 java.sql.Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(sql);
		 while(rs.next()) {
			 
			 User a = new User();
			 a.setId(rs.getInt(1));
			 a.setName(rs.getString(2));
			 a.setEmail(rs.getString(3));
			 a.setMobile(rs.getString(4));
			 
			 users.add(a);
		 }
		 
		 }
		 catch(Exception e) {
			 
			 System.out.println("get user error");
			 e.printStackTrace();
		 }
		 
		 return users;
	 }
	 
	 public User getOneUser(int id) {
		 
		
		 String sql = "select * from user where id="+id;
		 User a = new User(); 
		 try {
		 java.sql.Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(sql);
		 if(rs.next()) {
			 
			
			 a.setId(rs.getInt(1));
			 a.setName(rs.getString(2));
			 a.setEmail(rs.getString(3));
			 a.setMobile(rs.getString(4));
			 
			 
			
		 }
		 
		 }
		 catch(Exception e) {
			 
			 System.out.println("get one user eerror");
			 e.printStackTrace();
		 }
		 return a;
	 }

	public void  create(User s1) {
		// TODO Auto-generated method stub
		
	 
		String sql = "insert into user values(?,?,?,?)";
		
		 try {
			 PreparedStatement st = con.prepareStatement(sql);
			
			
				 
			
				 
				 st.setInt(1,s1.getId());
				 st.setString(2, s1.getName());
				 st.setString(3, s1.getEmail());
				 st.setString(4, s1.getMobile());
				 
				 st.executeUpdate();
			 
			 
			 }
			 catch(Exception e) {
				 
				 System.out.println("user cant create ");
				 Response.status(404);
				 e.printStackTrace();
			 }
			
		
	}
	
	
	public void  Update(User s1) {
		// TODO Auto-generated method stub
		
	 
		String sql = "update user set name=?,email =?,mobile=? where id=?";
		
		 try {
			 PreparedStatement st = con.prepareStatement(sql);
			
			
				 
			
				 
				
				 st.setString(1, s1.getName());
				 st.setString(2, s1.getEmail());
				 st.setString(3, s1.getMobile());
				 st.setInt(4,s1.getId());
				 
				 st.executeUpdate();
			 
			 
			 }
			 catch(Exception e) {
				 
				 System.out.println("user not updated");
				 Response.status(404);
				 e.printStackTrace();
			 }
			
		
	}
	
	
	public void  Delete(int id) {
		// TODO Auto-generated method stub
		
	 
		String sql = "delete from user where id=?";
		
		 try {
			 PreparedStatement st = con.prepareStatement(sql);
			
				
				 st.setInt(1,id);
				 
				 st.executeUpdate();
			 
			 
			 }
			 catch(Exception e) {
				 
				 System.out.println("error");
				 Response.status(404);
				 e.printStackTrace();
			 }
			
		
	}
	 
	
	public User login(User s1) {
		
		
		String sql = "select name,email from user where name = ? AND email =?";
		
		try {
			
			

			 PreparedStatement st = con.prepareStatement(sql);
			 
			 st.setString(1, s1.getName());
			 st.setString(2, s1.getEmail());
			 ResultSet resul = st.executeQuery();
			
	         if(resul.next()){
	        	 return new User(resul.getNString("name"), resul.getNString("email"));
	         }
	         
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
     } 
		
	
	
	
	/*  
	 public UserRepository() {
		 
		 
		 
		 System.out.println("User Repository");
			User s1 = new User();
			
			s1.setId(1);
			s1.setName("arithik");
			s1.setEmail("abc");
			s1.setMobile("123");
			
			
			User s2 = new User();
			
			s2.setId(2);
			s2.setName("mani");
			s2.setEmail("mani@");
			s2.setMobile("756");
			
			 
			   
			   users.add(s1);
			   users.add(s2);
			
			   
		 
	 }
	 
	 public ArrayList<User> getUsers(){
		 
		 return users;
		 
	 }
	 
	 public User getOneUser(int id) {
		 
		 User s1 = null;
		 
		 for(User a :users) {
			 
			 if(a.getId() == id) {
				 
				 return a;
			 }
		 }
		 
		 return null;
	 }

	public void  create(User s1) {
		// TODO Auto-generated method stub
		
	
		users.add(s1);
		
	}
	*/
	 
	 
}
