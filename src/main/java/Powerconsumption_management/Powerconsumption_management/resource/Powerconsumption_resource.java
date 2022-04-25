package Powerconsumption_management.Powerconsumption_management.resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Powerconsumption_management.Powerconsumption_management.model.Powerconsumption_model;
import Powerconsumption_management.Powerconsumption_management.service.Powerconsumption_service;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Powerconsumption")
public class Powerconsumption_resource {

	Powerconsumption_service service = new Powerconsumption_service();
	
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Powerconsumption_model addpowerconsumtion(Powerconsumption_model powerconsumtion) {
		 return service.insertpowerconsumtion(powerconsumtion);
		
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Powerconsumption_model>  getpowerconsumtion() throws SQLException {
		 return service.getpowerconsumtion();
		
	}
	
	@Path("/retrieveById/{customer_registration_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Powerconsumption_model>  getpowerconsumtion(@PathParam("customer_registration_id") String customer_registration_id) throws SQLException {
		return service.getpowerconsumtionById(customer_registration_id);
		
	}
	

	
	@Path("/updatePowerconsumption")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Powerconsumption_model updatepowerconsumtion(Powerconsumption_model powerconsumtion) {
		 return service.updatetpowerconsumtion(powerconsumtion);
		
	}
	
	@Path("/deletePowerconsumptionById/{customer_registration_id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public String deletepowerconsumtion(@PathParam("customer_registration_id") String customer_registration_id) {
		return service.deletetpowerconsumtion(customer_registration_id);
		
	}
}
