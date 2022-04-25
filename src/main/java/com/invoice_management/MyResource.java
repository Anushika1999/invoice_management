package com.invoice_management;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.invoice_management_model.*;
import com.invoice_management_service.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("invoice")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	invoice_service service = new invoice_service();
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it 77!";
    }
    
    @Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<invoice_model>  getInvoice() throws SQLException {
		 return service.getInvoice();
		
	}
	@Path("/insert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public invoice_model addInvoice(invoice_model invoice) {
		 return service.insertInvoice(invoice);
		
	}
	
	@Path("/retrieveByID/{invoice_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<invoice_model>  getInvoice(@PathParam("invoice_id") String invoice_id) throws SQLException {
		return service. getInvoiceById(invoice_id);
		
	}
	@Path("/deleteInvoiceById/{invoice_id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public String deletetInvoice(@PathParam("invoice_id") String invoice_id) {
		return service.deletetInvoice(invoice_id);
		
	}
	@Path("/updatetInvoice")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public invoice_model updatetInvoice(invoice_model invoice) {
		 return service.updatetInvoice(invoice);
		
	}
}
