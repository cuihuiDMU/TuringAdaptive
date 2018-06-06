package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pojo.User;

@Repository
public interface UserMapper {

	 
    public User getPass(@Param("name")String user_name);
    
    public void userAdd(@Param("name")String user_name, @Param("pass")String user_pass);
    
    public List<String> getAuthority(String user_name);
    
}

