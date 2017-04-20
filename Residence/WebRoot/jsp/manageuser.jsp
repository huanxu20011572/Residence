 <%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/jquery.range.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/css/common.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery-1.8.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/js/master.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.range.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validateboxRules.js"></script>

<title>单位人员查询</title>

<script type="text/javascript">
	$(window).ready(function(){
		getListPage();
	});

	//查询方法，带分页
	function getListPage(){
				$('#list').datagrid({			
					url: "<%=request.getContextPath()%>/manageUserController/getListPage.action",
					pagination:true,//是否分页			
					fitColumns: false,//
					singleSelect: false,//是否只能单选
					scrollbarSize: 0,
					rownumbers:true,//行号
					fit: true,
					nowrap: true,
					
					onLoadSuccess:function(){
						dataCbProject = $('#list').data('datagrid').data;
					},
					// hBuildingNum   hUnitNum  hFloorNum  roomNumber  birthday
					columns:[[
						{field:'checkBox',checkbox:true},
						{field:'id',title:'id',hidden:true},
						{field:'uName',title:'姓名',width:150},
						{field:'password',title:'密码',width:150},
						{field:'certificateType',title:'证件类型',width:150},
						{field:'certificateNum',title:'证件号码',width:150},
						{field:'telephone',title:'手机号',width:150},
						{field:'email',title:'邮箱',width:150},						
						{field:'qqNum',title:'QQ号',width:150}										
					]],
				onClickRow: function(rowIndex, rowData){
				}					
			});
	}
	
	

</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
	
			<div id="show"  data-options="region:'center'">
				<div id="list" class="easyui-datagrid" ></div>
			</div>
	</div>
	

</body>
</html>