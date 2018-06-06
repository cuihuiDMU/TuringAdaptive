package com.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.calculate.TurnDecimal;
import com.pojo.TestItems;
import com.service.TestService;
@Controller
@RequestMapping("")
public class DownLoadController {
	@Autowired
	@Qualifier("testServiceImpl")
	TestService testService;
	
	@Autowired
	@Qualifier("testItems")
	TestItems testItems;
	
	@RequestMapping("excelDownload")
	public void excelDownload(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		HSSFWorkbook wb = new HSSFWorkbook();
	     // 2.在workbook中添加一个sheet，对应Excel中的一个sheet
	     HSSFSheet sheet = wb.createSheet("图灵测试组测试服务项目度量表");
	     wb.setSheetName(0, "图灵测试组测试服务项目度量表");
	     
	     // 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
	     HSSFRow row = sheet.createRow((int) 0);
	     // 4.创建单元格，设置值表头，设置表头居中
	     HSSFCellStyle style = wb.createCellStyle();
	     // 居中格式
	     
	     style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	     style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	     // 设置表头
	     sheet.setColumnWidth(0, 4500);
	     sheet.setColumnWidth(1, 1500);
	     for(int i=2;i<28;i++){
	    	 sheet.setColumnWidth(i, 6500);
	     }
	     HSSFCellStyle style1 = wb.createCellStyle();
	     //style1.setFillBackgroundColor(HSSFColor.YELLOW.index);
	     style1.setFillForegroundColor(HSSFColor.DARK_YELLOW.index);
	     style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	     style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	     HSSFCell cell = row.createCell(0);
	     cell.setCellValue("项目名称");
	     cell.setCellStyle(style1);

	     
	     cell = row.createCell(1);
	     cell.setCellValue("月份");
	     cell.setCellStyle(style);

	     cell = row.createCell(2);
	     cell.setCellValue("支持版本名称");
	     cell.setCellStyle(style);

	     cell = row.createCell(3);
	     cell.setCellValue("支持总需求数量");
	     cell.setCellStyle(style);

	     cell = row.createCell(4);
	     cell.setCellValue("适配总款次");
	     cell.setCellStyle(style);

	     cell = row.createCell(5);
	     cell.setCellValue("用户覆盖量");
	     cell.setCellStyle(style);

	     cell = row.createCell(6);
	     cell.setCellValue("兼容性测试需求数量");
	     cell.setCellStyle(style);

	     cell = row.createCell(7);
	     cell.setCellValue("兼容性测试款均效率");
	     cell.setCellStyle(style);

	     cell = row.createCell(8);
	     cell.setCellValue("兼容性问题数量");
	     cell.setCellStyle(style);

	     cell = row.createCell(9);
	     cell.setCellValue("公共问题数量");
	     cell.setCellStyle(style);

	     cell = row.createCell(10);
	     cell.setCellValue("总问题数量");
	     cell.setCellStyle(style);

	     cell = row.createCell(11);
	     cell.setCellValue("兼容性问题占比");
	     cell.setCellStyle(style);

	     cell = row.createCell(12);
	     cell.setCellValue("严重问题数量");
	     cell.setCellStyle(style);

	     cell = row.createCell(13);
	     cell.setCellValue("严重问题占比");
	     cell.setCellStyle(style);

	     cell = row.createCell(14);
	     cell.setCellValue("主线总问题数量");
	     cell.setCellStyle(style);

	     cell = row.createCell(15);
	     cell.setCellValue("占主线总问题比例");
	     cell.setCellStyle(style);

	     cell = row.createCell(16);
	     cell.setCellValue("总兼容性问题数量");
	     cell.setCellStyle(style);

	     cell = row.createCell(17);
	     cell.setCellValue("占总兼容性问题比例");
	     cell.setCellStyle(style);

	     cell = row.createCell(18);
	     cell.setCellValue("解决问题数量");
	     cell.setCellStyle(style);

	     cell = row.createCell(19);
	     cell.setCellValue("解决问题占比");
	     cell.setCellStyle(style);

	     cell = row.createCell(20);
	     cell.setCellValue("自动化适配机型数量");
	     cell.setCellStyle(style);

	     cell = row.createCell(21);
	     cell.setCellValue("自动化适配机型数量占比");
	     cell.setCellStyle(style);

	     cell = row.createCell(22);
	     cell.setCellValue("自动化发现问题数量");
	     cell.setCellStyle(style);

	     cell = row.createCell(23);
	     cell.setCellValue("自动化发现问题占比");
	     cell.setCellStyle(style);

	     cell = row.createCell(24);
	     cell.setCellValue("自动化发现严重致命问题数");
	     cell.setCellStyle(style);

	     cell = row.createCell(25);
	     cell.setCellValue("自动化发现严重问题占比");
	     cell.setCellStyle(style);

	     cell = row.createCell(26);
	     cell.setCellValue("解决方案数量");
	     cell.setCellStyle(style);

	     cell = row.createCell(27);
	     cell.setCellValue("验收工作详细");
	     cell.setCellStyle(style);
	     
	     List<TestItems> lists = testService.downLoad();
	     
	     for (int i = 0; i < lists.size(); i++) {
	         row = sheet.createRow((int) i + 1);
	         TestItems list= lists.get(i);
	         // 创建单元格，设置值
	         row.createCell(0).setCellValue(list.getA());
	         row.createCell(1).setCellValue(list.getB());
	         row.createCell(2).setCellValue(list.getC());
	         row.createCell(3).setCellValue(list.getD());
	         row.createCell(4).setCellValue(list.getE());
	         row.createCell(5).setCellValue(list.getF());
	         row.createCell(6).setCellValue(list.getG());
	         row.createCell(7).setCellValue(TurnDecimal.turnDecimal(Float.valueOf(list.getH())));
	         row.createCell(8).setCellValue(list.getI());
	         row.createCell(9).setCellValue(list.getJ());
	         row.createCell(10).setCellValue(list.getK());
	         row.createCell(11).setCellValue(TurnDecimal.turnDecimal(Float.valueOf(list.getL())));
	         row.createCell(12).setCellValue(list.getM());
	         row.createCell(13).setCellValue(TurnDecimal.turnDecimal(Float.valueOf(list.getN())));
	         row.createCell(14).setCellValue(list.getO());
	         row.createCell(15).setCellValue(TurnDecimal.turnDecimal(Float.valueOf(list.getP())));
	         row.createCell(16).setCellValue(list.getQ());
	         row.createCell(17).setCellValue(TurnDecimal.turnDecimal(Float.valueOf(list.getR())));
	         row.createCell(18).setCellValue(list.getS());
	         row.createCell(19).setCellValue(TurnDecimal.turnDecimal(Float.valueOf(list.getT())));
	         row.createCell(20).setCellValue(list.getU());
	         row.createCell(21).setCellValue(TurnDecimal.turnDecimal(Float.valueOf(list.getV())));
	         row.createCell(22).setCellValue(list.getW());
	         row.createCell(23).setCellValue(TurnDecimal.turnDecimal(Float.valueOf(list.getX())));
	         row.createCell(24).setCellValue(list.getY());
	         row.createCell(25).setCellValue(TurnDecimal.turnDecimal(Float.valueOf(list.getZ())));
	         row.createCell(26).setCellValue(list.getAA());
	         row.createCell(27).setCellValue(list.getAB());
	       }

	     String filename = "图灵测试组测试服务项目度量表.xls";
	      ByteArrayOutputStream os = new ByteArrayOutputStream();
	      wb.write(os);
	      // 设置response参数，可以打开下载页面
	      response.reset();
	      response.setContentType("application/vnd.ms-excel");
	      response.setHeader("Content-Disposition", "attachment;filename="+ filename);
	      BufferedInputStream bis = null;
	      BufferedOutputStream bos = null;
	 
	      try {
	    	  OutputStream ouputStream = response.getOutputStream();   
	          wb.write(ouputStream);   
	          ouputStream.flush();   
	          ouputStream.close(); 
	      } catch (Exception e) {
	        // TODO: handle exception
	        e.printStackTrace();
	      } finally {
	        if (bis != null)
	          bis.close();
	        if (bos != null)
	          bos.close();
	      }	
}
	
}
