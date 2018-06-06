package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.calculate.TurnDecimal;
import com.google.gson.Gson;
import com.pojo.TestItems;
import com.service.TestService;


	
@Controller
@RequestMapping("")
public class GetDataController extends HttpServlet {
	
	@Autowired
	@Qualifier("testServiceImpl")
	TestService testService;
	
	@Autowired
	@Qualifier("testItems")
	TestItems testItems;
	
	
		@RequestMapping("GetDataController")
		public void getDataController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String loginUser = request.getParameter("loginUser");
			
			List<TestItems> result = testService.getTest(loginUser);
			for(TestItems a:result)
			System.out.println(a.toString());
			Gson gson = new Gson(); 
			String s2 = gson.toJson(result);

			/*ModelAndView mModelAndView = new ModelAndView("show");
			mModelAndView.addObject("data", s2);
			return mModelAndView;*/
			
			/*JSONArray resultList = new JSONArray();
			for(TestItems re:result){
				JSONObject.toJSONString(result);
				JSONObject jo = new JSONObject();
				jo.put("A", re.getA());
				jo.put("B", re.getB());
  	  		    jo.put("C", re.getC());
				jo.put("D", re.getD());
				jo.put("E", re.getE());
				jo.put("F", re.getF());
				jo.put("G", re.getG());
		        jo.put("H", re.getH());
				jo.put("I", re.getI());
				jo.put("J", re.getJ());
				jo.put("K", re.getK());
				jo.put("L", re.getL());
				jo.put("M", re.getM());
				jo.put("N", re.getN());
				jo.put("O", re.getO());
				jo.put("P", re.getP());
				jo.put("Q", re.getQ());
				jo.put("R", re.getR());
				jo.put("S", re.getS());
				jo.put("T", re.getT());
				jo.put("U", re.getU());
				jo.put("V", re.getV());
				jo.put("W", re.getW());
				jo.put("X", re.getX());
				jo.put("Y", re.getY());
				jo.put("Z", re.getZ());
				jo.put("AA", re.getAA());
				jo.put("AB", re.getAB());
				
				resultList.add(jo);
			}*/
			
			response.setContentType("application/x-json");
			PrintWriter out = response.getWriter();
			out.write(s2);
			
		}
		@RequestMapping("rowDelete")
		public void rowDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String loginUser = request.getParameter("loginUser");
			String project = request.getParameter("project");
			String month = request.getParameter("month");
			
			String result = "false";
			
			boolean b = testService.rowDelete(loginUser,project,month);

			if(b==true){
				result = "true";
			}
			
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("status",result);
			response.setContentType("application/x-json");
			PrintWriter out = response.getWriter();
			out.write(jsonobj.toString());
			
		}
		
		@RequestMapping("upDataController")
		public void upDataController(HttpServletRequest request, HttpServletResponse response) throws IOException{
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String username = request.getParameter("username");
			String A = request.getParameter("A");  //int 转换
			String B = request.getParameter("B");	
			String C = request.getParameter("C");
			String D = request.getParameter("D");	//int 
			String E = request.getParameter("E");	//int 
			String F = request.getParameter("F");
			String G = request.getParameter("G");	//int
			String H = request.getParameter("H");	//float
			String I = request.getParameter("I");	//int
			String J = request.getParameter("J");	//int
			String K = request.getParameter("K");
			String L = request.getParameter("L");
			String M = request.getParameter("M");
			String N = request.getParameter("N");//int
			String O = request.getParameter("O");
			String P = request.getParameter("P");//int
			String Q = request.getParameter("Q");
			String R = request.getParameter("R");//int
			String S = request.getParameter("S");
			String T = request.getParameter("T");//int
			String U = request.getParameter("U");
			String V = request.getParameter("V");//int
			String W = request.getParameter("W");
			String X = request.getParameter("X");//int
			String Y = request.getParameter("Y");
			String Z = request.getParameter("z");//int
			String AA = request.getParameter("AA");	//int
			String AB = request.getParameter("AB");
			
			testItems.setUsername(username);
			testItems.setA(A);;
			testItems.setB(B);
			if(C!=null&&!("").equals(C)) { testItems.setC(C);}
			if(D!=null&&!("").equals(D)) {testItems.setD(Integer.valueOf(D));}
			if(E!=null&&!("").equals(E)) {testItems.setE(Integer.valueOf(E));}
			if(F!=null&&!("").equals(F)) { testItems.setF(F);}
			if(G!=null&&!("").equals(G)) {testItems.setG(Integer.valueOf(G));}
			if(H!=null&&!("").equals(H)) {testItems.setH(TurnDecimal.turnDecimal(Float.valueOf(H)));}
			if(I!=null&&!("").equals(I)) {testItems.setI(Integer.valueOf(I));}
			if(J!=null&&!("").equals(J)) {testItems.setJ(Integer.valueOf(J));}
			if(K!=null&&!("").equals(K)) {testItems.setK(Integer.valueOf(K));}
			if(L!=null&&!("").equals(L)) {testItems.setL(TurnDecimal.turnDecimal(Float.valueOf(L)));}
			if(M!=null&&!("").equals(M)) {testItems.setM(Integer.valueOf(M));}
			if(N!=null&&!("").equals(N)) {testItems.setN(TurnDecimal.turnDecimal(Float.valueOf(N)));}
			if(O!=null&&!("").equals(O)) {testItems.setO(Integer.valueOf(O));}
			if(P!=null&&!("").equals(P)) {testItems.setP(TurnDecimal.turnDecimal(Float.valueOf(P)));}
			if(Q!=null&&!("").equals(Q)) {testItems.setQ(Integer.valueOf(Q));}
			if(R!=null&&!("").equals(R)) {testItems.setR(TurnDecimal.turnDecimal(Float.valueOf(R)));}
			if(S!=null&&!("").equals(S)) {testItems.setS(Integer.valueOf(S));}
			if(T!=null&&!("").equals(T)) {testItems.setT(TurnDecimal.turnDecimal(Float.valueOf(T)));}
			if(U!=null&&!("").equals(U)) {testItems.setU(Integer.valueOf(U));}
			if(V!=null&&!("").equals(V)) {testItems.setV(TurnDecimal.turnDecimal(Float.valueOf(V)));}
			if(W!=null&&!("").equals(W)) {testItems.setW(Integer.valueOf(W));}
			if(X!=null&&!("").equals(X)) {testItems.setX(TurnDecimal.turnDecimal(Float.valueOf(X)));}
			if(Y!=null&&!("").equals(Y)) {testItems.setY(Integer.valueOf(Y));}
			if(Z!=null&&!("").equals(Z)) {testItems.setZ(TurnDecimal.turnDecimal(Float.valueOf(Z)));}
			if(AA!=null&&!("").equals(AA)) {testItems.setAA(Integer.valueOf(AA));}
			if(AB!=null&&!("").equals(AB)) {testItems.setAB(AB);}
			
			String result = "false";
			boolean b = testService.rowUpdate(testItems);
			if(b==true){
				result = "true";
			}
			/*JSONObject jsonObj = (JSONObject) JSON.parse(updata);
			testItems= JSONObject.toJavaObject(jsonObj,TestItems.class);
	        Gson gson = new Gson();  
	        testItems = gson.fromJson(updata, TestItems.class);//将json数据转换成user类实体  
	        System.out.println("-=-=-=->>testItems.toString = " + testItems.toString());*/  
			/*String loginUser = request.getParameter("loginUser");
			String project = request.getParameter("project");
			String month = request.getParameter("month");
			
			String result = "false";
			
			boolean b = testService.rowDelete(loginUser,project,month);

			if(b==true){
				result = "true";
			}*/
			
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("status",result);
			response.setContentType("application/x-json");
			PrintWriter out = response.getWriter();
			out.write(jsonobj.toString());
			
		}

	}


