package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class OutSessionController extends HttpServlet {
	@RequestMapping("OutServlet")
	public void outSession(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //false代表：不创建session对象，只是从request中获取。
		HttpSession session = request.getSession(false);  
        if(session==null){  
            return;  
        }  
        session.removeAttribute("loginUser");
        String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/jsp/login.jsp";
        System.out.println(url);
        response.sendRedirect(url);
	}
}
