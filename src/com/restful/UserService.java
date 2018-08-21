package com.restful;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;





//为WebServceis指定Path
@Path("/UserService")
public class UserService {

	UserDao userDao = new UserDao();
	
	//http://localhost:8080/RestW/rest/UserService/users
	@GET
	//为WebServices中的方法指定Path  @WebResult @WebParam
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	//@Produces(MediaType.APPLICATION_JSON) 
	public List<User> getUsers(){
		System.out.println("XML result  2222233   ZZZ123");
		return userDao.getAllUsers();
	}
	
	
	//http://localhost:8080/RestW/rest/UserService/getUserJson     return: {"id":485,"name":"Ella","profession":null}
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
	
	
	//http://localhost:8080/RestW/rest/UserService/getUserJsonQuery?username=Marks
	@GET    
	@Path("/getUserJsonQuery") 
	@Produces(MediaType.APPLICATION_JSON)    
	public User getUserJsonByParam(@QueryParam("username") String userName) {    
		System.out.println("json result TTTTTT   9999");
	 User user  = new User();    
	 user.setId(485);
	 user.setName(userName);      
	 return user;    
	}
	//http://localhost:8080/RestW/rest/UserService/getUserTextQuery?username=Marks2
	@GET    
	@Path("/getUserTextQuery") 
	@Produces("text/plain")    
	public String getUserTextByParam(@QueryParam("username") String userName) {    
		System.out.println("json result TTTTTT   3333");
	 User user  = new User();    
	 user.setId(485);
	 user.setName(userName);      
	 return userName;    
	}
	
	//http://localhost:8080/RestW/rest/UserService/setUser   sent by postman
	@POST 
	@Path("/setUser") 
	@Consumes("application/x-www-form-urlencoded")   
	public String setUserByPost(@FormParam("username") String userName) {    
		System.out.println("json result TTTTTT   00000");
	 User user  = new User();    
	 user.setId(485);
	 user.setName(userName);      
	 return userName;    
	}
	
    @Context 
    HttpServletRequest req; 

    @Context 
    ServletConfig servletConfig; 

    @Context 
    ServletContext servletContext; 

    //http://localhost:8080/RestW/rest/UserService/servlet
    @GET 
    @Path("/servlet") 
    public String getBasicServlet(@Context HttpHeaders hh, @Context HttpServletRequest sr) { 
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders(); 
        Map<String, Cookie> pathParams = hh.getCookies();
        String sess_id = sr.getSession().getId();
        System.out.println("good news:"+sess_id);
		return sess_id; 
    } 
}
