<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.common.*"%>
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>数据管理</title>
</head>
<body>
<div style="padding-left:100px;padding-top:100px;">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="searchData1()">一键导出</a>
 	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="searchData2()">一键同步</a>
</div>
</body>
</html>