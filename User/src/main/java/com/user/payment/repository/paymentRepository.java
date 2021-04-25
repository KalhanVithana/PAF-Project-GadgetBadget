package com.user.payment.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.user.db.DatabaseConnectionPayment;
import com.user.payment.model.payment;

public class paymentRepository {

	List<payment> payments;
	
	Connection con = null;
	
	//Repository connection
	public paymentRepository() {		
		
		//con = DatabaseConnectionPayment.getConnection();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paymentdb", "root", "");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	//get all payments method
	public List<payment> getPayments() {
		
		List<payment> payments = new ArrayList<>();
		String sql = "select * from payment";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				payment p = new payment();
				p.setId(rs.getInt(1));
				p.setAccountNo(rs.getInt(2));
				p.setAmount(rs.getFloat(3));
				p.setType(rs.getString(4));
				p.setDate(rs.getString(5));
				p.setDescription(rs.getString(6));
				p.setBuyerName(rs.getString(7));
				
				payments.add(p);
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		return payments;
	}

	
	//get specific payment method
	public payment getPayment(int id) {
				
		String sql = "select * from payment where id = " + id;
		
		payment p = new payment();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				
				p.setId(rs.getInt(1));
				p.setAccountNo(rs.getInt(2));
				p.setAmount(rs.getFloat(3));
				p.setType(rs.getString(4));
				p.setDate(rs.getString(5));
				p.setDescription(rs.getString(6));
				p.setBuyerName(rs.getString(7));
				
				
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		return p;
	}

	//insert payment method
	public void create(payment p1) {	
		
		String sql = "INSERT INTO `payment` VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, p1.getId());
			st.setInt(2, p1.getAccountNo());
			st.setFloat(3, p1.getAmount());
			st.setString(4, p1.getType());
			st.setString(5, p1.getDate());
			st.setString(6, p1.getDescription());
			st.setString(7, p1.getBuyerName());
			
			st.executeUpdate();
			
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
	}

	//update payment method
	public void update(payment p1) {
		
		String sql = "update payment set accountNo = ?, amount = ?, type = ?, date = ?, description = ?, buyerName = ? where id = ?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, p1.getAccountNo());
			st.setFloat(2, p1.getAmount());
			st.setString(3, p1.getType());
			st.setString(4, p1.getDate());
			st.setString(5, p1.getDescription());
			st.setString(6, p1.getBuyerName());
			st.setInt(7, p1.getId());
			
			st.executeUpdate();
			
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
	}

	//delete payment method
	public void delete(int id) {
		
		String sql = "delete from payment where id = ?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			
			st.executeUpdate();
			
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
	}

}
