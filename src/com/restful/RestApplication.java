package com.restful;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig{
	public RestApplication() {
		System.out.println("ggggg  uuuuu");
		//���������ڵİ�·�� 
	    packages("com.restful");
	    // ����resources
	    register(UserService.class);
	    //ע��JSONת����  // ע������ת����
	    register(JacksonJsonProvider.class);
	    
	    
	 // ע����־
	    register(LoggingFilter.class);
/*	    ʹ���Լ�����Դ�������ɿ���ǿ���ص���ǿ��Գ��˼���ҵ����Դ���⣬�����Լ������Ӻ���������ҪһЩ������Դ�ȵȡ�
	    ����package�µ�ĳ����Դ���뱻��¶���Ͳ�Ҫ���ؽ����Ϳ����ˡ�*/
    }
}
