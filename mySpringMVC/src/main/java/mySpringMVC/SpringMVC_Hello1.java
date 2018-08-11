package mySpringMVC;



import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


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
		return "home";
	}
	
	
	//http://localhost:8080/mySpringMVC/hello/mingge
	@RequestMapping(value="/{Name}", method=RequestMethod.GET)
	public @ResponseBody String sayHello4(@PathVariable String Name) {
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
        

        //如果不用注解自动绑定，我们还可以像下面一样手动获取数据
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
}
