package com.user.product.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.user.db.DatabaseConnection;
import com.user.db.DatabaseConnectionProduct;
import com.user.product.model.product;

public class productRepository {

	
	Connection con = null;
	
	public productRepository()
	{
		con = DatabaseConnectionProduct.getConnection();
//		String url = "jdbc:mysql://localhost:3306/productdb";
//		String username = "root";
//		String password = "";
//		try 
//		{
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection(url,username,password);
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
	}
	
	public List<product> getProducts()
	{
		List<product> products = new ArrayList<>();
		
		String sql = "select * from product";
		try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			product p = new product();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setType(rs.getString(3));
			p.setPrice(rs.getFloat(4));
			p.setDescription(rs.getString(5));
			p.setQuantity(rs.getInt(6));
			
			products.add(p);
		}
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return products;
	}
	
	public product getProduct(int id)
	{
		String sql = "select * from product where id="+id;
		product p= new product();
		try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next())
		{
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setType(rs.getString(3));
			p.setPrice(rs.getFloat(4));
			p.setDescription(rs.getString(5));
			p.setQuantity(rs.getInt(6));
				
		}
		
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		return p;
	}

	public void create(product p1) {
		String sql = "insert into product values(?,?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, p1.getId());
			st.setString(2, p1.getName());
			st.setString(3, p1.getType());
			st.setFloat(4, p1.getPrice());
			st.setString(5, p1.getDescription());
			st.setInt(6, p1.getQuantity());
			
			st.executeUpdate();
			
			
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
	}

	public void update(product p1) {
		String sql = "update product set name=?, type=?, price=?, description=?, quantity=? where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(6, p1.getId());
			st.setString(1, p1.getName());
			st.setString(2, p1.getType());
			st.setFloat(3, p1.getPrice());
			st.setString(4, p1.getDescription());
			st.setInt(5, p1.getQuantity());
			
			st.executeUpdate();
			
			
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
	}

	public void delete(int id) {
		
		String sql = "delete from product where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			st.executeUpdate();
			
			
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
	}

	
	

	
}
