<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  
	String sess = (String)request.getSession().getAttribute("loginUser");
 %>
<! DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<base href="<%=basePath%>">
	<title>我的提交</title>
	<link type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link type="text/css" href="css/theme.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.4.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.4.5/demo/demo.css">
    
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
						<li><a href="<%=request.getContextPath()%>/jsp/loginGOTO.jsp">信息录入</a> </li> 
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

						<div class="module">
							
							 <div class="module-body" >
    							
    								<table id="insertPart" class="easyui-datagrid" title="我的提交数据" style="width:100%;height:auto">
    									<%-- <c:foreach item = "list"  var ="p">
        									<li >${p.A}</li>
        									<li>${p.B}</li>
    									<c:foreach> --%>
    								</table> 
							</div> 
					</div><!--/.content-->
				</div><!--/.span9-->
			</div>
		</div><!--/.container-->
		
		<a href="excelDownload">下载链接</a>
		
	</div><!--/.wrapper-->

	<div class="footer">
		<div class="container">
			 

			<b class="copyright">&copy; 2018 CUIHUI </b> All rights reserved.
		</div>
	</div>
</div>
	<script src="jquery-easyui-1.5.4.5/jquery.min.js" type="text/javascript"></script>
	<script src="scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="jquery-easyui-1.5.4.5/jquery.easyui.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	
	<!-- <script src="scripts/raydreams.js" type="text/javascript"></script> -->
	<script type="text/javascript" defer>
	var loginUser = "<%=sess %>";
	var editRow = undefined;
	$(document).ready(function(){
		   	  $.ajax({
		   	        type:"GET",
		   	        url:"<%=request.getContextPath()%>/GetDataController?loginUser="+loginUser,
		   	        dataType:"json",
		   	        success: function(data){
		   	        $('#insertPart').datagrid('loadData', data);
		   	      	},   // success结束
		   	        error: function(e){
		   	           alert("查询失败:" + e);
		   	        }
		   	    });// ajax结束
		   	//$.parser.parse($()); 
		});// $function结束
		
	$('#insertPart').datagrid({
        title : '我的数据表',
        //iconCls : 'icon-a_detail',
        fitColumns : false,
        rownumbers : true, 
        //rownumbers : true,
        // pagination : true,
        singleSelect : true, //True允许选择一行数据
        border : false, //是否有外边框
        striped : true, //条纹行
        nowrap : false,
        toolbar : [ {
            	
                text: "删除",
                iconCls: "icon-cut",
                handler: function () {
                    DeleteRow();
             	}
             	}, '-', {
                text: "修改",
                iconCls: "icon-edit",
                handler: function () {
					var row = $('#insertPart').datagrid("getSelected");
						//修改之前先关闭已经开启的编辑行，当调用endEdit该方法时会触发onAfterEdit事件
					if(row){
					if (editRow != undefined) {
						alert("请先保存已修改项");
						//$('#insertPart').datagrid("endEdit", editRow);
						}
					if (editRow == undefined) {
					$.messager.confirm("提示", "只能修改单项，无法同步计算需要计算的项，请自行修改需要计算的项。以免造成数据项混乱！确定要开始编辑吗？", function (r) {
					if (r) {
						//获取到当前选择行的下标
						var index = $('#insertPart').datagrid("getRowIndex", row);
						//开启编辑
						$('#insertPart').datagrid("beginEdit", index);
						//把当前开启编辑的行赋值给全局变量editRow
						editRow = index;
						//当开启了当前选择行的编辑状态之后，
						//应该取消当前列表的所有选择行，要不然双击之后无法再选择其他行进行编辑
						$('#insertPart').datagrid("unselectAll");
						}
						});
						}
					}else{
						alert("请先选择需要修改的数据");
					}
             	
             	}
             	}, '-', {
                    text: "保存",
                    iconCls: "icon-save",
                    handler: function () {
                    	$('#insertPart').datagrid("endEdit", editRow);
                    	editRow = undefined;
                 	}
        } ], 
        frozenColumns:[[{
        	field:'A',title:'项目名称',align:'center',halign:'center',width:120
        	},{
        	field:'B',title:'月份',align:'center',halign:'center',width:50,sortable:'true'
        	/* },{
        	field:'username',title:'用户名',width:100,hidden:'true' */
        }]], 
        columns : [ [ {
            field : 'C',title : '支持版本名称',width : 100,align : 'center',editor:'text'
            }, {
            field : 'D',title : '支持总需求数量',width : 100,align : 'center',editor: {type:'numberbox'}
            }, {
            field : 'E',title : '适配总款次',width : 100,align : 'center',editor: {type:'numberbox'}
            }, {
            field : 'F',title : '用户覆盖量',width : 100,align : 'center',editor:'text'
            }, {
            field : 'G',title : '兼容性测试需求数量',width : 150,align : 'center',editor: {type:'numberbox'}
            }, {
            field : 'H',title : '兼容性测试款均效率',width : 150, align : 'center',editor: {type:'numberbox',options:{precision:2}}
            }, {
            field : 'I',title : '兼容性问题数量',width : 100,align : 'center',editor: {type:'numberbox'}
            }, {
            field : 'J',title : '公共问题数量',width : 100,align : 'center',editor: {type:'numberbox'}
            }, {
            field : 'K',title : '总问题数量',width : 100,align : 'center',editor: {type:'numberbox'}
            }, {
            field : 'L',title : '兼容性问题占比',width : 100,align : 'center',editor: {type:'numberbox',options:{precision:2}}
            }, {
            field : 'M',title : '严重问题数量',width : 100, align : 'center',editor: {type:'numberbox'}
            }, {
            field : 'N',title : '严重问题占比',width : 100,align : 'center',editor: {type:'numberbox',options:{precision:1}}
            }, {
            field : 'O',title : '主线总问题数量',width : 100,align : 'center',editor: {type:'numberbox'}
            }, {
            field : 'P',title : '占主线总问题比例',width : 120,align : 'center',editor: {type:'numberbox',options:{precision:1}}
            }, {
            field : 'Q',title : '总兼容性问题数量',width : 120,align : 'center',editor: {type:'numberbox'}
            }, {
            field : 'R',title : '占总兼容性问题比例',width : 150,align : 'center',editor: {type:'numberbox',options:{precision:1}}
            }, {
            field : 'S',title : '解决问题数量',width : 100,align : 'center',editor: {type:'numberbox'}
        	}, {
            field : 'T',title : '解决问题占比',width : 100,align : 'center',editor: {type:'numberbox',options:{precision:1}}
             }, {
            field : 'U',title : '自动化适配机型数量',width : 150,align : 'center',editor: {type:'numberbox'}
             }, {
            field : 'V',title : '自动化适配机型数量占比',width : 150,align : 'center',editor: {type:'numberbox',options:{precision:1}}
             }, {
            field : 'W',title : '自动化发现问题数量',width : 150,align : 'center',editor: {type:'numberbox'}
             }, {
            field : 'X',title : '自动化发现问题占比',width : 150,align : 'center',editor: {type:'numberbox',options:{precision:1}}
             }, {
            field : 'Y',title : '自动化发现严重致命问题数',width : 160,align : 'center',editor: {type:'numberbox'}
             }, {
            field : 'Z',title : '自动化发现严重问题占比',width : 150,align : 'center',editor: {type:'numberbox',options:{precision:1}}
             }, {
            field : 'AA',title : '解决方案数量',width : 100,align : 'center',editor: {type:'numberbox'}
             }, {
            field : 'AB',title : '验收工作详细',width : 150,align : 'center',editor:'text',fixed:true
        } ] ],
        	onBeforeEdit:function(index,row){
				//updateActions(index);
			},
			onAfterEdit:function(index){
				
				//updateActions(index);
				//var updated = $('#insertPart').datagrid('getChanges', 'updated');  
				var updated = $('#insertPart').datagrid("selectRow", index).datagrid("getSelected");
            	if (updated) { 
            	$.ajax({ 
            	type:"POST", 
                url : "<%=request.getContextPath()%>/upDataController",  
                data: {
				"username":loginUser,
				"A":updated.A,
					"B":updated.B,
					"C":updated.C,
					"D":updated.D,
					"E":updated.E,
					"F":updated.F,
					"G":updated.G,
					"H":updated.H,
					"I":updated.I,
				"J":updated.J,
					"K":updated.K,
					"L":updated.L,
				"M":updated.M,
					"N":updated.N,
					"O":updated.O,
				"P":updated.P,
					"Q":updated.Q,
					"R":updated.R,
				"S":updated.S,
					"T":updated.T,
					"U":updated.U,
				"V":updated.V,
					"W":updated.W,
					"X":updated.X,
				"Y":updated.Y,
					"Z":updated.Z,
					"AA":updated.AA,
				"AB":updated.AB,
					},  
                dataType : 'json',  
                success : function(r) {  
                    if (r.status == "true") {  
                        alert("修改成功！");
                        $('#insertPart').datagrid('acceptChanges');
                        editRow = undefined;  
                        $('#insertPart').datagrid('reload');
                    } else {  
                        /*datagrid.datagrid('rejectChanges');*/  
                        //$('#insertPart').datagrid('beginEdit', editRow);  
                        alert("后台故障，请联系开发人员!");  
                    }  
                    $('#insertPart').datagrid('unselectAll');  
                }  
            }); 
            }
			},
			/* onCancelEdit:function(index,row){
				row.editing = false;
				alert("onCancelEdit");
				//updateActions(index);
			}, */
        onDblClickRow:function(){    //单击进行操作的方法
      		var row = $('#insertPart').datagrid('getSelected');//获取选中行的数据
      			if(row){
					if (editRow != undefined) {
						alert("请先保存已修改项");
						//$('#insertPart').datagrid("endEdit", editRow);
						}
					if (editRow == undefined) {
					$.messager.confirm("提示", "只能修改单项，无法同步计算需要计算的项，请自行修改需要计算的项。以免造成数据项混乱！确定要开始编辑吗？", function (r) {
					if (r) {
						//获取到当前选择行的下标
						var index = $('#insertPart').datagrid("getRowIndex", row);
						//开启编辑
						$('#insertPart').datagrid("beginEdit", index);
						//把当前开启编辑的行赋值给全局变量editRow
						editRow = index;
						//当开启了当前选择行的编辑状态之后，
						//应该取消当前列表的所有选择行，要不然双击之后无法再选择其他行进行编辑
						$('#insertPart').datagrid("unselectAll");
						}
						});
						}
					}else{
						alert("请先选择需要修改的数据");
					}
					
					 
      		}
    });
	
	function DeleteRow(){
			var row = $('#insertPart').datagrid('getSelected');
					if (row) {
						$.messager.confirm("提示", "你确定要删除吗?", function (r) {
							if (r) {
								$.ajax({
		   	        				type:"GET",
		   	       	 				url:"<%=request.getContextPath()%>/rowDelete?loginUser="+loginUser+"&project="+row.A+"&month="+row.B,
		   	        				dataType:"json",
		   	        				success: function(data){
		   	        				if(data.status == "true"){
		   	        				    alert("删除成功");
		   	        					var rowIndex = $('#insertPart').datagrid('getRowIndex', row);
		   	        					$('#insertPart').datagrid('deleteRow', rowIndex);
		   	        					}
		   	      					},   // success结束
		   	        				error: function(e){
		   	           					alert("查询失败:" + e);
		   	       					 }
		   	    				});// ajax结束
							}
						});
						}
					else {
						$.messager.alert("提示", "请选择要删除的行", "error");
						}
	
	}
	
	function EditRow(){
	
	
	}
	
			
	</script>
</body>
</html>