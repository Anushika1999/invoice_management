package user_managment.userprofile.services;

import user_managment.userprofile.model.usermodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class userservices {
	
	
	Connection con;

	
	public userservices(){
		
		try {
			String url =String.format("jdbc:mysql://localhost:3306/usermanagment");
			String uname ="root";
			String pwd = "9928";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
	}

	
	public usermodel insertUser(usermodel user) {
		String insert = "insert into person values(?,?,?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getNic());
			ps.setString(4, user.getAddress());
			ps.setInt(5, user.getZipCode());
			ps.setString(6, user.getPhoneNumber());
			ps.setString(7, user.getEmail());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return user;
		
	}
	
	public ArrayList<usermodel> getUser() throws SQLException{
		
		ArrayList<usermodel> data = new ArrayList<usermodel>();
		
		String select = "select * from person";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			usermodel model = new usermodel();
			
			model.setId(rs.getInt("id"));
			model.setName(rs.getString("name")); 
			model.setNic(rs.getString("nic"));
			model.setAddress(rs.getString("address")); 
			model.setZipCode(rs.getInt("zipCode"));
			model.setPhoneNumber(rs.getString("phoneNumber")); 
			model.setEmail(rs.getString("email"));
		
		
			
			data.add(model);
			
		}
		
		return data;
		
	}
	
	
	public ArrayList<usermodel> getUserById(int id) throws SQLException{
		
		ArrayList<usermodel> data = new ArrayList<usermodel>();
		String select = "select * from person where id =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			usermodel model = new usermodel();
			
			model.setId(rs.getInt("id"));
			model.setName(rs.getString("name")); 
			model.setNic(rs.getString("nic"));
			model.setAddress(rs.getString("address")); 
			model.setZipCode(rs.getInt("zipCode"));
			model.setPhoneNumber(rs.getString("phoneNumber")); 
			model.setEmail(rs.getString("email"));
		
			data.add(model);		
		}		
		return data;	
	}
	
	public usermodel updatetUser(usermodel user) {
		String insert = "update person set name=? , age=? where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getNic());
			ps.setString(4, user.getAddress());
			ps.setInt(5, user.getZipCode());
			ps.setString(6, user.getPhoneNumber());
			ps.setString(7, user.getEmail());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return user;
		
	}
	

	public int deletetUser(int id) {
		String insert = "delete from person where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,id);
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return id;
		
	}
	

}
