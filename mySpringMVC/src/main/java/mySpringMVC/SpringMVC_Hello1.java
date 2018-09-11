package mySpringMVC;


//http://localhost:8080/mySpringMVC/login2.jsp

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import mySpringMVC.SERVICE.UserManageImpl;
import mySpringMVC.AWARE.SpringContextHelper;
import mySpringMVC.ENTITY.User;
import mySpringMVC.AWARE.Demo2;

@Controller
@RequestMapping("/hello")
public class SpringMVC_Hello1 {
     
	private static Logger log = LoggerFactory.getLogger(SpringMVC_Hello1.class);
	
	//   /hello/mvc?name=zhouming   http://localhost:8080/mySpringMVC/hello/mvc?name=zhouming4
	@RequestMapping(value = "/mvc", method = RequestMethod.GET)
	public String sayHello(@RequestParam("name") String Name , Model model) {
		model.addAttribute(Name);
        log.debug("aaaaaaabbbbbbbb ni hao:{}" , Name);
    	return "home";
        
    	//@ResponseBody
        //return new StringBuilder().append("tim horton");
    }
	
	
	//  /hello/mvc/{Name}     http://localhost:8080/mySpringMVC/hello/mvc2/zhouming4
	@RequestMapping(value="/mvc2/{name}", method = RequestMethod.GET)
	public String sayHello2(@PathVariable("name") String Name, Map<String,Object> model) {
		log.debug("cccccccnnnnnnnnbonjour, {}",Name);
		
		return "home";
				
	}
	
	
	
	
	
	//http://localhost:8080/mySpringMVC/hello/mvc3?name=zhouming
	@ModelAttribute("MyAge")
	public String handleB4RequestMap() {
		return "herooo";
	}
	
	
	
	//@ModelAttribute("Name")
	@RequestMapping(value="/mvc3", method = RequestMethod.GET)
	public String sayHello3(HttpServletRequest request, Model model){
		String Name = request.getParameter("name");
		log.debug("say hello 3 {}", Name);

		model.addAttribute("Name",Name);
		Map modelMap = model.asMap();
		
		for(Object modelKey: modelMap.keySet()) {
			Object modelValue = modelMap.get(modelKey);
			System.out.println(modelKey + ":" +modelValue);
		}
		//request.setAttribute("Name", Name);
		
		
		request.getSession().setAttribute("login_status", "true");
		
		return "home";
	}
	
	
	//http://localhost:8080/mySpringMVC/hello/mingge
	@RequestMapping(value="/{Name}", method=RequestMethod.GET)
	public @ResponseBody String sayHello4(@PathVariable String Name) {
		System.out.println("got msg*********");
		return "Good Guy!!!";   //instead of Json
	}
	
	//http://localhost:8080/mySpringMVC/hello/json/ert
	@RequestMapping(value="/json/{Name}", method=RequestMethod.GET)
	public ResponseEntity<String>  sayHello5(@PathVariable String Name){
		String aa = "Stark!!";
		return new ResponseEntity<String>(aa,HttpStatus.OK);
	}
	
	
	
	//http://localhost:8080/mySpringMVC/hello/login
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("input");  
		Map mm = mav.getModel();
		for(Object item: mm.keySet()){
				
		}
		return mav;
	}	
	@RequestMapping("/input")
	public ModelAndView input(@RequestParam("Name") String name, @RequestParam("Pwd") String pwd) {
		   ModelAndView mav = new ModelAndView("viewAll");  
	        mav.addObject("Name",name);
	        mav.addObject("Pwd",pwd);
	        return mav;
	}
	
	//http://localhost:8080/mySpringMVC/login2.jsp
	@RequestMapping(value = "/viewResult",method=RequestMethod.POST)
	public ModelAndView viewAll(String Name1, String Pwd1) {
		ModelAndView mv = new ModelAndView();
		log.debug(">>>>>>> {}", Name1);
		log.debug(">>>>>>> {}", Pwd1);
		mv.addObject("Name",Name1);
        mv.addObject("Pwd",Pwd1);
		mv.setViewName("viewAll");
		return mv;
	}	
	@RequestMapping(value="/sayHi", method= RequestMethod.POST)
	public String sayHi(UserInfo ui) {
		log.debug(">>>>>>>"+ReflectionToStringBuilder.toString(ui));
		return "redirect:input?Name="+ ui.getName() + "&Pwd=" + ui.getPwd();
	}
	
	//http://localhost:8080/mySpringMVC/upload.jsp
	@RequestMapping(value = "/uploadfile",method=RequestMethod.POST)
	public ModelAndView uploadFile(HttpServletRequest request, @RequestParam("urlParam") String urlParam, 
			@RequestParam("formParam") String formParam, @RequestParam("formFile") MultipartFile formFile) {
        ModelAndView mv = new ModelAndView();  
        mv.addObject("urlParam", urlParam);  
        mv.addObject("formParam", formParam);  
        mv.addObject("formFileName", formFile.getOriginalFilename());  
        

        //锟斤拷锟斤拷锟斤拷锟阶拷锟斤拷远锟斤拷蠖ǎ锟斤拷锟斤拷腔锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟揭伙拷锟斤拷侄锟斤拷锟饺★拷锟斤拷锟�
        //String[] urlParam1 = (String[]) request.getParameterValues("urlParam");
        //mv.addObject("urlParam1", urlParam1[0]);  
       String urlParam1 = ServletRequestUtils.getStringParameter(request, "urlParam", null);
       String formParam1 = ServletRequestUtils.getStringParameter(request, "formParam", null);
       MultipartFile formFile1 = ((MultipartHttpServletRequest) request).getFile("formFile"); 
       mv.addObject("urlParam1", urlParam1);  
       mv.addObject("formParam1", formParam1);  
       mv.addObject("formFileName1", formFile1.getOriginalFilename());  
		log.debug("uploadfile bonjour, >>>>>>>>>>>>>>>>>>>>>>>> {}",urlParam);

		mv.setViewName("uploadfile");
		return mv;
	}
	
	
    //below same url: http://localhost:8080/mySpringMVC/UserAdd.jsp
    @Autowired  
    private UserManageImpl userService;  
    //添加用户  
    @RequestMapping(value="/addUser",method=RequestMethod.POST)  
    public String addUser(User user,HttpServletRequest request) throws Exception{  
        System.out.println("用户名：======"+user.getName());  
        userService.addUser(user);  
        return "success";  
    } 
    

    //ajax calling: http://localhost:8080/mySpringMVC/hello/getUsers
    @RequestMapping(value="/getUsers",method=RequestMethod.GET)  
    public ResponseEntity<String>  getUser(User user,HttpServletRequest request) throws Exception{
    	Object[] aa = userService.getUsers();
    	List<Object> a1 = Arrays.asList(aa);
    	ResponseEntity<String> bb = new ResponseEntity<String>(a1.toString(),HttpStatus.OK);  
    	log.debug(bb.toString());  //<200 OK,[5, zhouyutong, 0714],{}>
   	    return bb;
    }
    //below ajax calling with data input: http://localhost:8080/mySpringMVC/hello/getUsersWithJsonParam
    @RequestMapping(value="/getUsersWithJsonParam",method=RequestMethod.POST)  
    public ResponseEntity<String> getUsersWithJsonParam(@RequestBody User user) throws Exception {
    	List<User> aa = userService.getUsersWithJsonParam(user.getName());
    	if (aa.size()>0) {
        	ResponseEntity<String> bb = new ResponseEntity<String>(aa.get(0).toString(),HttpStatus.OK);
        	log.debug(aa.get(0).toString()); 
        	return bb;
    	}
        return null;
    }
    
    //ajax calling with param list: http://localhost:8080/mySpringMVC/hello/getUsersWithList
    @RequestMapping(value="/getUsersWithList",method=RequestMethod.POST)
    public ResponseEntity<String> getUsersWithList(@RequestBody List<String> name_list) throws Exception {
    	List<User> aa = userService.getUsersWithJsonParam(name_list.get(0));
    	ResponseEntity<String> bb = new ResponseEntity<String>(aa.get(0).toString(),HttpStatus.OK);
    	return bb;
    }
    
    
    
    //test Aware function to introduce new Bean
    @RequestMapping(value="/getAware",method=RequestMethod.GET)
    public ResponseEntity<String> getAwareDemo() {
    	
    	Demo2 d2 = (Demo2)SpringContextHelper.getBean("testDemo");
    	System.out.println(d2.getId()+":"+d2.getName());
    	ResponseEntity<String> bb = new ResponseEntity<String>(d2.toString(),HttpStatus.OK);
    	return bb;
    }
    
}
