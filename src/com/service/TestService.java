package com.service;

import java.util.List;

import com.pojo.TestItems;

public interface TestService {
		public void testAdd(TestItems testItems);
		public List<TestItems> getTest(String username);
		public boolean rowDelete(String loginUser,String project,String month);
		public boolean rowUpdate(TestItems testItems);
		public List<TestItems> downLoad();
}
