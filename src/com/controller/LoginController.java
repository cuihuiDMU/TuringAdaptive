package com.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.User;
import com.service.LoginTest;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("")
public class LoginController {
	@Autowired
	@Qualifier("LoginTestImpl")
	LoginTest loginTest;
	
	@RequestMapping("login")
	public void loginTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String loginName=request.getParameter("loginName");
		String loginPassword=request.getParameter("loginPassword");
		
		User user = null;
		String userpass = "";
		
		String status = "";
		
		if(loginName != null && !loginName.equals(""))
		{
			if(loginPassword != null && !loginName.equals("")){
				user = loginTest.getPass(loginName);
				if(user == null)
				{
					status = "用户名不存在";
				}else{
					userpass = user.getUser_password();
					String loginPass = MD5Util.getCryptogram(loginPassword);
					/*System.out.println(userpass);
					System.out.println(loginPass);*/

					status = LoginController.isSame(userpass, loginPass);
					if(status.equals("success")){
						request.getSession().setAttribute("loginUser",user.getUser_name());
					}
			}
		  }else{
			  status = "请输入密码";
			}
		}else{
			status = "请输入用户名";
		  }
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("status",status);
		response.setContentType("application/x-json");
		PrintWriter out = response.getWriter();
		out.write(jsonobj.toString());
		
	}
	public static String isSame(String pass, String loginPass){
		if(pass.equals(loginPass)){
			return "success";
		}
		return "用户名密码不一致";
		
	}
	
	}

