package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pojo.User;

@Service
public interface LoginTest {
	
	User getPass(String user_name);
	void userAdd(String user_name,String user_pass);
	List<String> getAuthority(String user_name);
	
}
