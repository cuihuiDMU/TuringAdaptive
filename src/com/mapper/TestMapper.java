package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pojo.TestItems;

@Repository
public interface TestMapper {
	
	public void testAdd(TestItems testItems);
	
	public List<TestItems> getTest(String username);
	
	public int rowDelete(@Param("loginUser")String loginUser,@Param("project")String project,@Param("month")String month);
	
	public int rowUpdate(@Param("testItems")TestItems testItems);
	
	public List<TestItems> downLoad();
}
