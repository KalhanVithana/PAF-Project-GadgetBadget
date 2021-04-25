package com.user.fund.repository;


import com.user.db.DatabaseConnectionFund;
import com.user.fund.model.fund;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class fundRepository {

List<fund> fund;
	
	Connection con = null;
	
	public fundRepository()
	{
		con = DatabaseConnectionFund.getConnection();
		/*fund = new ArrayList<>();
		
		Fund f1 = new Fund();
		f1.setFund_ID(1);
		f1.setFunder_name("Uvin");
		f1.setDate("2021/02/10");
		f1.setDescription("fund for chethana");
		f1.setFund_amount("1000000");
		f1.setRecipient_name("shashini");
		
		Fund f2 = new Fund();
		f2.setFund_ID(1);
		f2.setFunder_name("Kalhan");
		f2.setDate("2021/03/10");
		f2.setDescription("fund for sathma");
		f2.setFund_amount("100000");
		f2.setRecipient_name("miuranga");
		
		fund.add(f1);
		fund.add(f2);*/
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/funddb", "root", "");
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public List<fund> getFunds() {
		
		List<fund> funds = new ArrayList<>();
		String sql = "select * from fund";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				fund p = new fund();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDate(rs.getString(3));
				p.setDescription(rs.getString(4));
				p.setAmount(rs.getFloat(5));
				p.setRecipient_name(rs.getString(6));
				
				funds.add(p);
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		return funds;
	
	}

	 /* public List<Fund> getFunds()
	  {
		  System.out.println("inside getFunds method");
		  System.out.println(fund);
		  return fund;
	  }*/
	  
	public fund getFund(int id) {
		
		String sql = "select * from fund where id = " + id;
		
		fund p = new fund();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDate(rs.getString(3));
				p.setDescription(rs.getString(4));
				p.setAmount(rs.getFloat(5));
				p.setRecipient_name(rs.getString(6));
								
				
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		return p;
	}

	/*public void create(Fund f1) {
		// TODO Auto-generated method stub
		fund.add(f1);
		
	}*/
	  
	  public void create(fund p) {	
			
			String sql = "INSERT INTO `fund` VALUES (?,?,?,?,?,?)";
			
			try {
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setInt(1, p.getId());
				st.setString(2, p.getName());
				st.setString(3, p.getDate());
				st.setString(4, p.getDescription());
				st.setFloat(5, p.getAmount());
				st.setString(6, p.getRecipient_name());
			
				
				st.executeUpdate();
				
				
			} catch (Exception e) { 
				e.printStackTrace();
			}
			
		}
	  
	  
		public void update(fund p1) {
			
			String sql = "update payment set recipient_name = ?, name = ?, date = ?, description = ?, amount = ? where id = ?";
			
			try {
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setInt(1, p1.getId());
				st.setString(2, p1.getName());
				st.setString(3, p1.getDate());
				st.setString(4, p1.getDescription());
				st.setFloat(5, p1.getAmount());
				st.setString(6, p1.getRecipient_name());
				
				st.executeUpdate();
				
				
			} catch (Exception e) { 
				e.printStackTrace();
			}
			
		}

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
