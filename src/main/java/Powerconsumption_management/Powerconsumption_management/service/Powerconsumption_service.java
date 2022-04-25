package Powerconsumption_management.Powerconsumption_management.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import Powerconsumption_management.Powerconsumption_management.model.Powerconsumption_model;

public class Powerconsumption_service {
Connection con;

	
	public Powerconsumption_service (){
		
		try {
			String url =String.format("jdbc:mysql://localhost:3306/powerconsumtion_management");
			String uname ="root";
			String pwd = "ana123";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
	}

	
	public Powerconsumption_model  insertpowerconsumtion(Powerconsumption_model powerconsumtion) {
		String insert = "insert into powerconsumtion(customer_registration_id,last_meter_reading,curent_meter_reading,monthly_payable_units) values(?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, powerconsumtion.getCustomer_registration_id());
			ps.setInt(2, powerconsumtion.getLast_meter_reading());
			ps.setInt(3, powerconsumtion.getCurent_meter_reading());
			ps.setInt(4, powerconsumtion.getMonthly_payable_units());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return powerconsumtion;
		
	}
	
	public ArrayList<Powerconsumption_model> getpowerconsumtion() throws SQLException{
		
		ArrayList<Powerconsumption_model> data = new ArrayList<Powerconsumption_model>();
		
		String select = "select * from powerconsumtion";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Powerconsumption_model model = new Powerconsumption_model();
			
			model.setCustomer_registration_id(rs.getString("customer_registration_id")); // column name
			model.setLast_meter_reading(rs.getInt("last_meter_reading"));
			model.setCurent_meter_reading(rs.getInt("curent_meter_reading"));
			model.setMonthly_payable_units(rs.getInt("monthly_payable_units"));
			
			data.add(model);
			
		}
		
		return data;
		
	}
	
	
	public ArrayList<Powerconsumption_model> getpowerconsumtionById(String customer_registration_id) throws SQLException{
		
		ArrayList<Powerconsumption_model> data = new ArrayList<Powerconsumption_model>();
		String select = "select * from powerconsumtion where customer_registration_id =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setString(1,customer_registration_id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Powerconsumption_model model = new Powerconsumption_model();
			
			
			model.setCustomer_registration_id(rs.getString("customer_registration_id")); // column name
			model.setLast_meter_reading(rs.getInt("last_meter_reading"));
			model.setCurent_meter_reading(rs.getInt("curent_meter_reading"));
			model.setMonthly_payable_units(rs.getInt("monthly_payable_units"));
			data.add(model);		
		}		
		return data;	
	}
	
	public Powerconsumption_model updatetpowerconsumtion(Powerconsumption_model powerconsumtion) {
		String insert = "update powerconsumtion  set customer_registration_id = ?,last_meter_reading=?,curent_meter_reading= ?,monthly_payable_units= ? where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, powerconsumtion.getCustomer_registration_id());
			ps.setLong(2, powerconsumtion.getLast_meter_reading());
			ps.setLong(3, powerconsumtion.getCurent_meter_reading());
			ps.setLong(4, powerconsumtion.getMonthly_payable_units());
			ps.setLong(5, powerconsumtion.getId());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return powerconsumtion;
		
	}
	

	public String deletetpowerconsumtion(String customer_registration_id) {
		String insert = "delete from powerconsumtion where customer_registration_id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1,customer_registration_id);
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return customer_registration_id;
		
	}
}
