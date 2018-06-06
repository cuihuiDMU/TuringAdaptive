<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  
	String sess = (String)request.getSession().getAttribute("loginUser");
 %>
<!DOCTYPE HTML>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<base href="<%=basePath%>">
	<title>图灵-项目选择</title>
	<link type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link type="text/css" href="css/theme.css" rel="stylesheet">
	 
	<link type="text/css" href="images/icons/css/font-awesome.css" rel="stylesheet">
	<link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600' rel='stylesheet'>
</head>
<body>

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
					<i class="icon-reorder shaded"></i>
				</a>

			  	<p class="brand">welcome <%=sess %></p>
				
				<div class="nav-collapse collapse navbar-inverse-collapse">
					<ul class="nav nav-icons">
						<li><a href="<%=request.getContextPath()%>/jsp/show.jsp">我的提交</a> </li> 
					</ul>
					
					<ul class="nav pull-right">
						<li><a href="OutServlet">退出登录</a> </li>
					</ul>
					
				</div><!-- /.nav-collapse -->
			</div>
		</div><!-- /navbar-inner -->
	</div><!-- /navbar -->



	<div class="wrapper">
		<div class="container">
			<div class="row">
				
				<div class="span9">
					<div class="content">

						<div id = "insertPart" class="btn-controls">
							
						</div><!--/.btn-controls-->

						
					</div><!--/.content-->
				</div><!--/.span9-->
			</div>
		</div><!--/.container-->
	</div><!--/.wrapper-->

	<div class="footer">
		<div class="container">
			<b class="copyright">&copy; 2018 CUIHUI </b> All rights reserved.
		</div>
	</div>

	<script src="scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
	<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	var loginUser = "<%=sess %>";
	$(function(){
		   	  $.ajax({
		   	        type:"GET",
		   	        url:"<%=request.getContextPath()%>/GotoController?loginUser=<%=sess %>",
		   	       /*  data:loginUser, */
		   	        dataType:"json",
		   	        success: function(data){
		   	        	//alert(data.pageNo);
		   	        	//alert(data.dataList.length);
		   	            /* if(data.isError == false) { */
		   	           // options.totalPages = data.pages;
				    if (data.length > 0 ) {
		  	  		var str="";
		  	  		for(var i=0; i < data.length; i++) {
		  	  		var projectName=data[i].authority;
		        	   str += "<div  class='btn-box-row row-fluid'><p><b>"+projectName+"</b></p><a href='<%=request.getContextPath()%>/jsp/form.jsp?project="+encodeURI(projectName)+"&month="+encodeURI("1月")+"&user="+loginUser+"' class='btn-box big span4'><i class='icon-arrow-up'></i><b>"+projectName+"/1 月</b></a>";
		        	   str += "<a href='<%=request.getContextPath()%>/jsp/form.jsp?project="+encodeURI(projectName)+"&month="+encodeURI("2月")+"&user="+loginUser+"' class='btn-box big span4'><i class='icon-arrow-up'></i><b>"+projectName+"/2 月</b></a>";
		        	   str += "<a href='<%=request.getContextPath()%>/jsp/form.jsp?project="+encodeURI(projectName)+"&month="+encodeURI("3月")+"&user="+loginUser+"' class='btn-box big span4'><i class='icon-arrow-up'></i><b>"+projectName+"/3 月</b></a>";
		        	   str += "<a href='<%=request.getContextPath()%>/jsp/form.jsp?project="+encodeURI(projectName)+"&month="+encodeURI("4月")+"&user="+loginUser+"' class='btn-box big span4'><i class='icon-arrow-up'></i><b>"+projectName+"/4 月</b></a>";
		        	   str += "<a href='<%=request.getContextPath()%>/jsp/form.jsp?project="+encodeURI(projectName)+"&month="+encodeURI("5月")+"&user="+loginUser+"' class='btn-box big span4'><i class='icon-arrow-up'></i><b>"+projectName+"/5 月</b></a>";
		        	   str += "<a href='<%=request.getContextPath()%>/jsp/form.jsp?project="+encodeURI(projectName)+"&month="+encodeURI("6月")+"&user="+loginUser+"' class='btn-box big span4'><i class='icon-arrow-up'></i><b>"+projectName+"/6 月</b></a>";
		        	   str += "<a href='<%=request.getContextPath()%>/jsp/form.jsp?project="+encodeURI(projectName)+"&month="+encodeURI("7月")+"&user="+loginUser+"' class='btn-box big span4'><i class='icon-arrow-up'></i><b>"+projectName+"/7 月</b></a>";
		        	   str += "<a href='<%=request.getContextPath()%>/jsp/form.jsp?project="+encodeURI(projectName)+"&month="+encodeURI("8月")+"&user="+loginUser+"' class='btn-box big span4'><i class='icon-arrow-up'></i><b>"+projectName+"/8 月</b></a>";
		        	   str += "<a href='<%=request.getContextPath()%>/jsp/form.jsp?project="+encodeURI(projectName)+"&month="+encodeURI("9月")+"&user="+loginUser+"' class='btn-box big span4'><i class='icon-arrow-up'></i><b>"+projectName+"/9 月</b></a>";
		        	   str += "<a href='<%=request.getContextPath()%>/jsp/form.jsp?project="+encodeURI(projectName)+"&month="+encodeURI("10月")+"&user="+loginUser+"' class='btn-box big span4'><i class='icon-arrow-up'></i><b>"+projectName+"/10 月</b></a>";
		        	   str += "<a href='<%=request.getContextPath()%>/jsp/form.jsp?project="+encodeURI(projectName)+"&month="+encodeURI("11月")+"&user="+loginUser+"' class='btn-box big span4'><i class='icon-arrow-up'></i><b>"+projectName+"/11 月</b></a>";
		        	   str += "<a href='<%=request.getContextPath()%>/jsp/form.jsp?project="+encodeURI(projectName)+"&month="+encodeURI("12月")+"&user="+loginUser+"' class='btn-box big span4'><i class='icon-arrow-up'></i><b>"+projectName+"/12月</b></a></div>";
		        	   }  
		  	  $("#insertPart").html(str);
		     }else {  // dataList.length > 0 不成立          	            	
			          $("#insertPart").html('<tr><td><center>无可用权限</center></td></tr>');
			      }
		   	      },   // success结束
		   	        error: function(e){
		   	           alert("查询失败:" + e);
		   	        }
		   	    });// ajax结束
		});
	
	</script>

</body>
</html>

