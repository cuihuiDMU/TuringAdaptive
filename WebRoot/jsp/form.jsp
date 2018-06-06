<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	String sess = (String)request.getSession().getAttribute("loginUser");
	
	String project = new String(request.getParameter("project").getBytes(),"utf-8");;
    
	String month = 	 new String(request.getParameter("month").getBytes(), "utf-8");
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<base href="<%=basePath%>">
	<title>图灵-数据录入</title>
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
						<li><a href="OutServlet">退出登录</a> </li> 
						<li><a href="jsp/loginGOTO.jsp">返回选择页</a> </li>
						<li><a href="jsp/show.jsp">我的录入信息</a> </li>
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

						<div class="module">
							<div class="module-head">
								<h2><%=project %> &nbsp;&nbsp; <%=month %></h2>
							</div>
							<div class="module-body">

									<form id="datasheet" class="form-horizontal row-fluid">
										
										<div class="control-group" style="width:100%;"><b> 工作量汇总 </b></div>
										<div class="control-group">
											<label class="control-label" for="basicinput">支持版本名称</label>
											<div class="controls">
												 <input name="C" value=" " type="text" class="span8 tip">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput" >支持总需求数量</label>
											<div class="controls">
												<input name="D" type="text" class="span8 tip">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">适配总款次</label>
											<div class="controls">
												<input name="E" type="text" class="span8 tip">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">用户覆盖量</label>
											<div class="controls">
												<input name="F" type="text" class="span8 tip">
											</div>
										</div>
										
										<div class="control-group" style="width:100%;"><b> bug汇总 </b></div>
										<div class="control-group">
											<label class="control-label" for="basicinput">兼容性测试需求数量</label>
											<div class="controls">
												<input name="G" type="text" class="span8 tip">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">兼容性测试款均效率</label>
											<div class="controls">
												<input name="H" type="text" class="span8 tip">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">兼容性问题数量</label>
											<div class="controls">
												<input name="I" type="text" class="span8 tip">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">公共问题数量</label>
											<div class="controls">
												<input name="J" type="text" class="span8 tip">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">严重问题数量</label>
											<div class="controls">
												<input name="M" type="text" class="span8 tip">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">主线总问题数量</label>
											<div class="controls">
												<input name="O" type="text" class="span8 tip">
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">总兼容性问题数量</label>
											<div class="controls">
												<input name="Q" type="text" class="span8 tip">
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">解决问题数量</label>
											<div class="controls">
												<input name="S" type="text" class="span8 tip">
											</div>
										</div>
										
										
										<div class="control-group" style="width:100%;"><b> 自动化汇总 </b></div>
										<div class="control-group">
											<label class="control-label" for="basicinput">自动化适配机型数量</label>
											<div class="controls">
												<input name="U" type="text" class="span8 tip">
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">自动化发现问题数量</label>
											<div class="controls">
												<input name="W" type="text" class="span8 tip">
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">自动化发现严重致命问题数</label>
											<div class="controls">
												<input name="Y" type="text" class="span8 tip">
											</div>
										</div>
										
										<div class="control-group" style="width:70%;">
											<label class="control-label" for="basicinput">解决方案数量</label>
											<div class="controls">
												<input name="AA" type="text" class="span8 tip">
											</div>
										</div>
										
									
										<div class="control-group" style="width:90%;">
											<label class="control-label" for="basicinput">验收工作详细</label>
											<div class="controls">
												<textarea name="AB" class="span8" rows="5"  cols="20" wrap="hard" style="overflow:scroll;overflow-x:hidden;" ></textarea>
											</div>
										</div>

										<div class="control-group" style="width:90%;">
											<div class="controls">
												<button type="submit" class="btn">提交</button>
											</div>
										</div>
										<input type="reset" style="display:none;" />
									</form>
									
							</div>
							
							
						</div>

						
					</div><!--/.content-->
				</div><!--/.span9-->
			</div>
		</div><!--/.container-->
	</div><!--/.wrapper-->

	<div class="footer">
		<div class="container">
			 

			<b class="copyright">&copy;  2018 CUIHUI</b> All rights reserved.
		</div>
	</div>

	<script src="scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="scripts/jquery.form.js" type="text/javascript"></script>
	<script src="scripts/jquery.validate.js"type="text/javascript"></script>
	<script src="scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
	<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="scripts/flot/jquery.flot.js" type="text/javascript"></script>
	<script type="text/javascript">

$().ready(function() {
　　$("#datasheet").validate({
　　onsubmit:true,// 是否在提交是验证
　　onfocusout:false,// 是否在获取焦点时验证
　　onkeyup :false,// 是否在敲击键盘时验证

rules: {　　　　//规则
　　 		D: { digits:true,maxlength:10 },  
        E: { digits:true,maxlength:10 },
        G: { digits:true,maxlength:10 },
        I: { digits:true,maxlength:10 },
        J: { digits:true,maxlength:10 },
        M: { digits:true,maxlength:10 },
        O: { digits:true,maxlength:10 },
        Q: { digits:true,maxlength:10 },
        S: { digits:true,maxlength:10 },
        U: { digits:true,maxlength:10 },
        W: { digits:true,maxlength:10 },
        Y: { digits:true,maxlength:10 },
        AA: { digits:true,maxlength:10 }
},
messages:{　　　　//验证错误信息
　　	D: {digits:$.validator.format("请输入整数"),maxlength:$.validator.format("长度不可以超过10")},
　　	E: {digits:$.validator.format("请输入整数"),maxlength:$.validator.format("长度不可以超过10")},
	G: {digits:$.validator.format("请输入整数"),maxlength:$.validator.format("长度不可以超过10") },
        I: {digits:$.validator.format("请输入整数"),maxlength:$.validator.format("长度不可以超过10") },
        J: {digits:$.validator.format("请输入整数"),maxlength:$.validator.format("长度不可以超过10") },
        M: {digits:$.validator.format("请输入整数"),maxlength:$.validator.format("长度不可以超过10") },
        O: {digits:$.validator.format("请输入整数"),maxlength:$.validator.format("长度不可以超过10") },
        Q: {digits:$.validator.format("请输入整数"),maxlength:$.validator.format("长度不可以超过10") },
        S: {digits:$.validator.format("请输入整数"),maxlength:$.validator.format("长度不可以超过10") },
        U: {digits:$.validator.format("请输入整数"),maxlength:$.validator.format("长度不可以超过10") },
        W: {digits:$.validator.format("请输入整数"),maxlength:$.validator.format("长度不可以超过10") },
        Y: {digits:$.validator.format("请输入整数"),maxlength:$.validator.format("长度不可以超过10") },
        AA: {digits:$.validator.format("请输入整数"),maxlength:$.validator.format("长度不可以超过10") }
},
submitHandler: function(form) { //通过之后回调
		 formdata = $("#datasheet").serialize();
		 projectname = "<%=project %>";
		 month = "<%=month %>";
		 username = "<%=sess %>";
$("#datasheet").ajaxSubmit({
　　url : "<%=request.getContextPath()%>/formController",
　　type : "post",
　　dataType : "json",
　　data: {
　　　　"formdata":formdata,
　　　　"projectname":projectname,
	 "month":month,
	 "username":username
　　},
　　success : function(data) {
		if(data.status=="success"){
		    alert("表单提交成功！");
			// $("#datasheet").resetForm();
			// $("input[type=reset]").trigger("click");
			$("#datasheet input").val("");
			window.location.href = "<%=request.getContextPath()%>/jsp/show.jsp";
		}else{
       		 alert("error exist");
       		 }
　　		}, // success结束
	error: function(e){
		  alert("查询失败:" + e);
		  }
});

},
invalidHandler: function(form, validator) {return false;}
}); 
});

</script>
</body>
</html>