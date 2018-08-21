package com.restful;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig{
	public RestApplication() {
		System.out.println("ggggg  uuuuu");
		//服务类所在的包路径 
	    packages("com.restful");
	    // 加载resources
	    register(UserService.class);
	    //注册JSON转换器  // 注册数据转换器
	    register(JacksonJsonProvider.class);
	    
	    
	 // 注册日志
	    register(LoggingFilter.class);
/*	    使用自己的资源加载器可控性强的特点就是可以除了加载业务资源以外，还可以加载日子和其他的需要一些工具资源等等。
	    或者package下的某个资源不想被暴露，就不要加载进来就可以了。*/
    }
}
