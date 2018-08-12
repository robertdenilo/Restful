package mySpringMVC_Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import mySpringMVC.SpringMVC_Hello1;

public class TestInterceptor implements HandlerInterceptor {

	private static Logger log = LoggerFactory.getLogger(TestInterceptor.class);
	
	//返回模式表示是否需要拦截当前请求
	//return false 请求被终止，true请求继续进行
	//Object arg2 被拦截请求的目标对象
	//WebRequestInterceptor无此返回值
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//request.setCharacterEncoding("utf-8");
		if(request.getSession().getAttribute("login_status").equals("true")) {
			request.getRequestDispatcher("../login1.jsp").forward(request, response);
		}
		
		System.out.println(">>>>>>>before interceptor, session id:"+request.getRequestedSessionId() + " login_status:" + request.getSession().getAttribute("login_status"));
		//log.debug("before interceptor");
		return true;
	}

	//通过ModelAndView参数来改变视图，或者发往视图的方法参数
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(">>>>>>post interceptor");
		//log.debug("post interceptor");
		//arg3.addObject("name", "illegal user")
        //arg3.setViewName("/404notfound.jsp")
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println(">>>>>>>>>after interceptor");
		log.debug(">>>>>>>after interceptor");

	}

}
