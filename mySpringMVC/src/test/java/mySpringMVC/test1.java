package mySpringMVC;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration({"file:F:\\workspace\\oxygen\\Bean\\mySpringMVC\\src\\main\\webapp\\WEB-INF\\configs\\spring\\applicationContext.xml","file:F:\\workspace\\oxygen\\Bean\\mySpringMVC\\src\\main\\webapp\\WEB-INF\\configs\\spring\\mySpringMVC-servlet.xml"})  
@ContextConfiguration({"classpath:/configs/spring/applicationContext.xml","classpath:/configs/spring/mySpringMVC-servlet.xml"})  
public class test1 extends TestCase {
	
    @Resource
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }
	
	@Test  
    public void test0() throws Exception{  
        System.out.println("first J test*******");  
        //String json = "{\"name\":\"yutong\", \"pwd\":\"0714\"}";  
        JSONObject json = new JSONObject();
        json.put("name", "yutong");
        json.put("pwd", "0714");
        String responseString =  mockMvc.perform(
                (post("/hello/addUser")   //post
                        //.contentType(MediaType.APPLICATION_JSON).content(json.toJSONString())
                      .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                      .param("name", "yutong").param("pwd", "0714")
                		))
//                .andExpect(status().isOk()).andDo(print());
		        .andDo(print())         //print out req and res
		        .andReturn().getResponse().getContentAsString();
        
        System.out.println(responseString);
    }  
}
