package com.controller;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.service.LoginTest;

@Controller
@RequestMapping("")
public class GotoController {
	@Autowired
	@Qualifier("LoginTestImpl")
	LoginTest loginTest;
	
	@RequestMapping("GotoController")
	public void pageLoad(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String loginUser = request.getParameter("loginUser");
		
		List<String> userAuthority;
		JSONArray authorityList = new JSONArray();
		if(loginUser!=null)
		{
			userAuthority = loginTest.getAuthority(loginUser);
			for(Iterator<String> i = userAuthority.iterator();i.hasNext();)
			{
				JSONObject jsonobj = new JSONObject();
				jsonobj.put("authority",i.next());
				authorityList.add(jsonobj);
			}
		}
		response.setContentType("application/x-json");
		PrintWriter out = response.getWriter();
		out.write(authorityList.toString());
	}
}
