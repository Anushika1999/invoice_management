package com.invoice_management_service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.invoice_management_model.*;

public class invoice_service {
	
	Connection con = null;
	
	public invoice_service() 
	{
		String url = "jdbc:mysql://localhost:3306/power_grid?verifyServerCertificate=false&useSSL=true";
		String username = "root";
		String password = "root";
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection (url, username, password);
		}
		catch (Exception e) 
		{ 
			System.out.println(e);
		}
	} 

	
	public invoice_model insertInvoice(invoice_model invoice) {
		String insert = "insert into invoice_management (invoice_id,customer_id,customer_name,customer_type,pay_units,monthly_amount) values(?,?,?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, invoice.getInvoice_id());
			ps.setString(2, invoice.getCustomer_id());
			ps.setString(3, invoice.getCustomer_name());
			ps.setString(4, invoice.getCustomer_type());
			ps.setInt(5,invoice.getPay_units());
			ps.setFloat(6,invoice.getMonthly_amount());
			ps.execute();
			
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return invoice;
		
	}
	
	public ArrayList<invoice_model> getInvoice() throws SQLException{
		
		ArrayList<invoice_model> invoice = new ArrayList<invoice_model>();
		
		String select = "select * from invoice_management";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			invoice_model model = new invoice_model();
			
			model.setInvoice_id(rs.getString("invoice_id")); // column name
			model.setCustomer_id(rs.getString("customer_id"));
			model.setCustomer_name(rs.getString("customer_name"));
			model.setCustomer_type(rs.getString("customer_type"));
			model.setPay_units(rs.getInt("pay_units"));
			model.setMonthly_amount(rs.getFloat("monthly_amount"));
			
			invoice.add(model);
			
		}
		
		return invoice;
		
	}
	
	
	public ArrayList<invoice_model> getInvoiceById(String invoice_id) throws SQLException{
		
		ArrayList<invoice_model> invoice = new ArrayList<invoice_model>();
		String select = "select * from invoice_management where invoice_id =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setString(1,invoice_id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			invoice_model model = new invoice_model();
			
			model.setInvoice_id(rs.getString("invoice_id")); // column name
			model.setCustomer_id(rs.getString("customer_id"));
			model.setCustomer_name(rs.getString("customer_name"));
			model.setCustomer_type(rs.getString("customer_type"));
			model.setPay_units(rs.getInt("pay_units"));
			model.setMonthly_amount(rs.getFloat("monthly_amount"));
			invoice.add(model);		
		}		
		return invoice;	
	}
	
	public invoice_model updatetInvoice(invoice_model invoice) {
//		String insert = "update invoice_management set invoice_id=? , customer_id=? customer_name=? customer_type=? pay_units=? monthly_amount=? where invoice_id =?";
		String insert = "update `invoice_management` set `invoice_id` = ?, `customer_id` = ?, `customer_name` = ?, `customer_type` = ?, `pay_units` = ?, `monthly_amount` = ? where (`invoice_id` = ?);";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, invoice.getInvoice_id());
			ps.setString(2, invoice.getCustomer_id());
			ps.setString(3, invoice.getCustomer_name());
			ps.setString(4, invoice.getCustomer_type());
			ps.setInt(5, invoice.getPay_units());
			ps.setFloat(6, invoice.getMonthly_amount());
			ps.setString(7, invoice.getInvoice_id());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data update unsuccess.");
		}
		
		return invoice;
		
	}
	

	public String deletetInvoice(String invoice_id) {
		String insert = "delete from invoice_management where invoice_id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1,invoice_id);
			
			ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e +"data delete unsuccess.");
		}
		
		return invoice_id;
		
	}
	
	


}
