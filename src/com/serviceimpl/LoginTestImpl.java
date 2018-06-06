package com.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.LoginTest;
@Service("LoginTestImpl")
public class LoginTestImpl implements LoginTest {
	
	@Autowired
	UserMapper userMapper;

	
	public User getPass(String user_name) {
		User user = userMapper.getPass(user_name);
		if(user!=null){
			return user;
		}else{
			return null;
		}
	}


	@Override
	public void userAdd(String user_name, String user_pass) {
		userMapper.userAdd(user_name,user_pass);
		
	}


	@Override
	public List<String> getAuthority(String loginUser) {
		List<String> userAuthority = new ArrayList<>();
		userAuthority = userMapper.getAuthority(loginUser);
		return userAuthority;
	}


}
