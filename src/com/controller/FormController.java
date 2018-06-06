package com.controller;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.calculate.TurnDecimal;
import com.pojo.TestItems;
import com.service.LoginTest;
import com.service.TestService;

@Controller
@RequestMapping("")
public class FormController {
	@Autowired
	@Qualifier("testServiceImpl")
	TestService testAdd;
	
	@Autowired
	@Qualifier("testItems")
	TestItems testItems;
	
	@RequestMapping("formController")
	public void formController(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
        
		String projectname = request.getParameter("projectname");  //int 转换
		String test_month = request.getParameter("month");	
		String username = request.getParameter("username");	//int 转换
		
		// System.out.println(projectname+"--"+test_month+"--"+username);
		String C = request.getParameter("C");
		
		String dd = request.getParameter("D");	//int 
		String ee = request.getParameter("E");	//int 
		String F = request.getParameter("F");
		String gg = request.getParameter("G");	//int
		String hhhh = request.getParameter("H");	//float
		String ii = request.getParameter("I");	//int
		String jj = request.getParameter("J");	//int
		String mm = request.getParameter("M");	//int
		String oo = request.getParameter("O");	//int
		String qq = request.getParameter("Q");	//int
		String ss = request.getParameter("S");	//int
		String uu = request.getParameter("U");	//int
		String ww = request.getParameter("W");	//int
		String yy = request.getParameter("Y");	//int
		String aa = request.getParameter("AA");	//int
		String AB = request.getParameter("AB");
		testItems.setA(projectname);;
		testItems.setB(test_month);
		testItems.setUsername(username);
		
		if(C!=null&&!("").equals(C)) { testItems.setC(C);}
		if(dd!=null&&!("").equals(dd)) {testItems.setD(Integer.valueOf(dd));}
		if(ee!=null&&!("").equals(ee)) {testItems.setE(Integer.valueOf(ee));}
		if(F!=null&&!("").equals(F)) { testItems.setF(F);}
		if(gg!=null&&!("").equals(gg)) {testItems.setG(Integer.valueOf(gg));}
		if(hhhh!=null&&!("").equals(hhhh)) {testItems.setH(TurnDecimal.turnDecimal(Float.valueOf(hhhh)));}
		if(ii!=null&&!("").equals(ii)) {testItems.setI(Integer.valueOf(ii));}
		if(jj!=null&&!("").equals(jj)) {testItems.setJ(Integer.valueOf(jj));}
		if(mm!=null&&!("").equals(mm)) {testItems.setM(Integer.valueOf(mm));}
		if(oo!=null&&!("").equals(oo)) {testItems.setO(Integer.valueOf(oo));}
		if(qq!=null&&!("").equals(qq)) {testItems.setQ(Integer.valueOf(qq));}
		if(ss!=null&&!("").equals(ss)) {testItems.setS(Integer.valueOf(ss));}
		if(uu!=null&&!("").equals(uu)) {testItems.setU(Integer.valueOf(uu));}
		if(ww!=null&&!("").equals(ww)) {testItems.setW(Integer.valueOf(ww));}
		if(yy!=null&&!("").equals(yy)) {testItems.setY(Integer.valueOf(yy));}
		if(aa!=null&&!("").equals(aa)) {testItems.setAA(Integer.valueOf(aa));}
		if(AB!=null&&!("").equals(AB)) {testItems.setAB(AB);}
		
		/*以下是需要计算的数值项目K L N P R T V X Z*/
		testItems.setK(testItems.getI()+testItems.getJ());
		if(testItems.getK()!=0){testItems.setL(TurnDecimal.calculateDecimal(testItems.getI(),testItems.getK()));}
		if(testItems.getK()!=0){testItems.setN(TurnDecimal.calculateDecimal(testItems.getM(),testItems.getK()));}
		if(testItems.getO()!=0){testItems.setP(TurnDecimal.calculateDecimal(testItems.getK(),testItems.getO()));}
		if(testItems.getQ()!=0){testItems.setR(TurnDecimal.calculateDecimal(testItems.getI(),testItems.getQ()));}
		if(testItems.getK()!=0){testItems.setT(TurnDecimal.calculateDecimal(testItems.getS(),testItems.getK()));}
		if(testItems.getE()!=0){testItems.setV(TurnDecimal.calculateDecimal(testItems.getU(),testItems.getE()));}
		if(testItems.getK()!=0){testItems.setX(TurnDecimal.calculateDecimal(testItems.getW(),testItems.getK()));}
		if(testItems.getK()!=0){testItems.setZ(TurnDecimal.calculateDecimal(testItems.getY(),testItems.getK()));}

		
		/*DecimalFormat df = new DecimalFormat("0.00%");  
        System.out.println("getN---------"+df.format(testItems.getN()));*/  
		
		
		System.out.println(testItems.toString());
        testAdd.testAdd(testItems);
        
        // System.out.println("getID---------"+testItems.getTest_id());
        
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("status","success");
		response.setContentType("application/x-json");
		PrintWriter out = response.getWriter();
		out.write(jsonobj.toString());
		
		}
	
	
	

}
