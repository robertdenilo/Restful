package com.restful;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;





//ΪWebServceisָ��Path
@Path("/UserService")
public class UserService {

	UserDao userDao = new UserDao();
	
	@GET
	//ΪWebServices�еķ���ָ��Path  @WebResult @WebParam
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
