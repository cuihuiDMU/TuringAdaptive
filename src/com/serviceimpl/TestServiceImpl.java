package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.TestMapper;
import com.pojo.TestItems;
import com.service.TestService;
@Service("testServiceImpl")
public class TestServiceImpl implements TestService {
	
	@Autowired
	TestMapper testMapper;
	
	@Override
	public void testAdd(TestItems testItems) {
		//System.out.println();
		System.out.println("this is testServiceImpl.testAdd"+testItems.toString());
		testMapper.testAdd(testItems);
	}

	@Override
	public List<TestItems> getTest(String username) {
		// System.out.println("this is testServiceImpl and user is "+username);
		List<TestItems> result = testMapper.getTest(username);
		for(TestItems a:result)
			System.out.println("this is testServiceImpl.testAdd"+a.toString());
		return result;
	}

	@Override
	public boolean rowDelete(String loginUser, String project, String month) {
			int c = testMapper.rowDelete(loginUser, project, month);
			if(c>0){
				return true;
			}
				return false;
	}

	@Override
	public boolean rowUpdate(TestItems testItems) {
		int u = testMapper.rowUpdate(testItems);
		
		if(u>0){
			return true;
		}
			return false;
	}

	@Override
	public List<TestItems> downLoad() {
		List<TestItems> result = testMapper.downLoad();
		
		return result;
	}

}
