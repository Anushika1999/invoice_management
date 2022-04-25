package com.invoice_management_resource;
 


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.invoice_management_model.*;
import com.invoice_management_service.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("invoice")
public class invoice_resource {
	 @GET
	    @Produces(MediaType.TEXT_PLAIN)
	    public String getIt() {
	        return "Got it 77!";
	    }
	
	invoice_service service = new invoice_service();
	
	@Path("/insert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public invoice_model addInvoice(invoice_model invoice) {
		 return service.insertInvoice(invoice);
		
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<invoice_model>  getInvoice() throws SQLException {
		 return service.getInvoice();
		
	}
	
	@Path("/retrieveByID/{invoice_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<invoice_model>  getInvoice(@PathParam("invoice_id") String invoice_id) throws SQLException {
		return service. getInvoiceById(invoice_id);
		
	}
	

	
	@Path("/updatetInvoice")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public invoice_model updatetInvoice(invoice_model invoice) {
		 return service.updatetInvoice(invoice);
		
	}
	
	@Path("/deleteInvoiceById/{invoice_id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public String deletetInvoice(@PathParam("invoice_id") String invoice_id) {
		return service.deletetInvoice(invoice_id);
		
	}

	
	
}