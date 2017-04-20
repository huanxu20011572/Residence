 <%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/jquery-ui.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery-1.8.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>

<title>家庭人员查询</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true"> 		
			<div id="show"  data-options="region:'center'">
				<div id="list" class="easyui-datagrid" ></div>
			</div>
	</div>
	<script type="text/javascript">

		$('#list').datagrid({			
					url: "<%=request.getContextPath()%>/residentPopulationController/getListPage.action?type=0",
					pagination:true,//是否分页			
					fitColumns: false,//
					singleSelect: false,//是否只能单选
					scrollbarSize: 0,
					rownumbers:true,//行号
					nowrap: true,
					fit: true,
					onLoadSuccess:function(){
						dataCbProject = $('#list').data('datagrid').data;
					},
					columns:[[
						{field:'checkBox',checkbox:true},
						{field:'id',title:'id',hidden:true},
						{field:'hid',title:'hId',hidden:true},
						{field:'ptype',title:'人员类别',width:60,formatter:function(value, row, index){
																	if (value == "1") {
																		return "房主";
																	} else if (value == "2") {
																		return "家庭成员";
																	}
						}}
					]]			
			});

</script>
</body>
</html>