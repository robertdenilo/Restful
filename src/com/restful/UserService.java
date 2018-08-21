package com.restful;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;





//为WebServceis指定Path
@Path("/UserService")
public class UserService {

	UserDao userDao = new UserDao();
	
	@GET
	//为WebServices中的方法指定Path  @WebResult @WebParam
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	//@Produces(MediaType.APPLICATION_JSON) 
	public List<User> getUsers(){
		System.out.println("XML result  2222233   ZZZ123");
		return userDao.getAllUsers();
	}
	
	@GET    
	@Path("/getUserJson")    
	@Produces(MediaType.APPLICATION_JSON)    
	public User getUserJson() {    
		System.out.println("json result TTTTTT   88888");
	 User user  = new User();    
	 user.setId(485);
	 user.setName("Ella");      
	 return user;    
	}   
}
