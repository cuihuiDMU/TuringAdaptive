package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestUrl = request.getRequestURI();
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("loginUser");
        /*url请求参数获取：post方法的url参数列表:request.getInputStream() 
                      get方法的url参数列表:request.getQueryString(),
        							  request.getParameter("参数名");//根据参数名获取参数值（注意，只能获取一个值的参数）
        							  request.getParameterValue("参数名“); //根据参数名获取参数值（可以获取多个值的参数）
        							  request.getParameterNames();   //获取所有参数名称列表 */
        if(requestUrl.indexOf("/login.jsp") > -1) {
        	filterChain.doFilter(servletRequest, servletResponse);
        	   return;
        	  }else{
        		  if (user == null || "".equals(user)||"null".equals(user)) {
            		response.setContentType("text/html; charset=utf-8");
        			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        			return;
            	
        	  }else{
        		  if(requestUrl.indexOf("/form.jsp") != -1 && request.getQueryString()==null){
        			response.setContentType("text/html; charset=utf-8");
          			response.sendRedirect(request.getContextPath() + "/jsp/loginGOTO.jsp");
          			return;
        		  }else{
        			  filterChain.doFilter(servletRequest, servletResponse);
        		  }
        	  }
       }
        	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
