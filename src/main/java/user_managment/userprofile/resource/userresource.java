package user_managment.userprofile.resource;

import user_managment.userprofile.model.usermodel;
import user_managment.userprofile.services.userservices;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/user")
public class userresource {
	userservices service = new userservices();
	
	@Path("/insert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public usermodel addUser(usermodel user) {
		 return service.insertUser(user);
		
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<usermodel>  getUser() throws SQLException {
		 return service.getUser();
		
	}
	
	@Path("/retrieveById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<usermodel>  getUser(@PathParam("id") int id) throws SQLException {
		return service.getUserById(id);
		
	}
	

	
	@Path("/updateUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public usermodel updateUser(usermodel user) {
		 return service.updatetUser(user);
		
	}
	
	@Path("/deleteUserById/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteUser(@PathParam("id") int id) {
		return service.deletetUser(id);
		
	}

	

}
