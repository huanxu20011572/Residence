<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>三实信息采集系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/jquery.range.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/easyui/css/architecture/yangshi.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/easyui/css/architecture/zi.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery-1.8.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/js/master.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.range.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validateboxRules.js"></script>
	
	<script type="text/javascript">
		$(function(){
			addTab("单位信息查询", "<%=request.getContextPath()%>/jsp/unitquery.jsp");
		});
		
		//点击链接
		function clickLink(obj){
			obj = $(obj);
			var title = obj.html();
			var url = obj.attr("href");
			addTab(title, url);
		}
		
		//添加tab
		function addTab(title, url){
			if ($('#tabs').tabs('exists', title)){
				$('#tabs').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
				$('#tabs').tabs('add',{
					title:title,
					content:content,
					closable:true
				});
			}
		}
	</script>
<style type="text/css">
a:link {
 text-decoration: none;
 
}
a:visited {
 text-decoration: none;
}
a:hover {
	color:#F00;
	
}
a:active {
 text-decoration: none;
}
.cs-north {
	width:100%;
	height:65px;
}
.cs-north-bg {
	width: 100%;
	height: 100%;
	background:url(<%=request.getContextPath()%>/js/easyui/themes/default/images/top_bj.png) repeat-x;
}

.yun{
	float:left;
	background:url(<%=request.getContextPath()%>/js/easyui/themes/default/images/logo.png) no-repeat;
	width:386px;
	height:60px;
	margin-left:15px;
	}
.cs-north-bg h2{
	float:left;
	font-size:22px;
	color:#FFF;
	font-weight:bold;
	padding-left:30px;
	padding-top:20px;
	}

.cs-north-logo {
	margin: 20px 0px 0px 20px;
	display: inline-block;
	color:#FFFFFF;font-size:22px;font-weight:bold;text-decoration:none;
	width:200px;
}
.cs-west {
	width:200px;padding:0px;
}
.cs-south {
	height:25px;background:url('<%=request.getContextPath()%>/js/easyui/themes/pepper-grinder/images/ui-bg_fine-grain_15_ffffff_60x60.png') repeat-x;padding:0px;text-align:center;
}
.cs-navi-tab {
	padding-left:50px;
	line-height:36px;
}
.cs-tab-menu {
	
}
.cs-home-remark {
	
}
.wrapper {
    float: right;
    height: 30px;
    margin-left: 10px;
}
.ui-skin-nav {
    float: right;
	padding: 0;
	margin-right: 10px;
	list-style: none outside none;
	height: 30px;
}

.ui-skin-nav .li-skinitem {
    float: left;
    font-size: 12px;
    line-height: 30px;
	margin-left: 10px;
    text-align: center;
	padding-top:15px;
}
.ui-skin-nav .li-skinitem span {
	cursor: pointer;
	width:10px;
	height:10px;
	display:inline-block;
}
.ui-skin-nav .li-skinitem span.cs-skin-on{
	border: 1px solid #FFFFFF;
}
</style>
	
  </head>
  
  <body>
  	<div class="easyui-layout" fit=true>
	<div region="north" border="true" class="cs-north">
    	
		<div class="cs-north-bg">
		<div class="yun"></div>
		<ul class="ui-skin-nav">				
			<li class="li-skinitem" title="metro-green" style="color:#FFF">您好！<strong><%=session.getAttribute("username") %></strong>&nbsp;&nbsp;&nbsp;&nbsp;  欢迎进入三实信息采集系统&nbsp;&nbsp;&nbsp;&nbsp;</li>
			<li class="li-skinitem" title="metro-green"><a href="<%=request.getContextPath()%>/manageUserController/calcelUser.action" style="color:#F00;">注销</a></li>
		</ul>	
		</div>
	</div>
		<div id="menu" data-options="region:'west',border:true,title:'导航菜单',split:true" style="width:250px;background-color:#F5F5F5;">
			<div class="easyui-accordion" fit="true">
				<div title='实有单位信息'>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;<a id="dpet" onclick="clickLink(this);return false;" 
						href="<%=request.getContextPath()%>/jsp/unitquery.jsp">单位信息查询</a></p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;<a id="dept_p" onclick="clickLink(this);return false;" 
						href="<%=request.getContextPath()%>/jsp/unitpopulationquery.jsp">单位人员信息查询</a></p>
				</div>
				<div title='实有人口信息'>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;<a id="house" onclick="clickLink(this);return false;" 
						href="<%=request.getContextPath()%>/jsp/housequery.jsp">实有房屋信息查询</a></p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;<a id="house_p" onclick="clickLink(this);return false;" 
						href="<%=request.getContextPath()%>/jsp/residentpopulationquery.jsp">实有人口信息查询</a></p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;<a id="house_p" onclick="clickLink(this);return false;" 
						href="<%=request.getContextPath()%>/jsp/populationStatistics.jsp">实有人口统计查询</a></p>
				</div>
				<div title='重点人口管理'>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;<a id="criminalRecordQuery" onclick="clickLink(this);return false;" 
						href="<%=request.getContextPath()%>/jsp/criminalPopulationquery.jsp">重点人口查询</a></p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;<a id="criminalRecordCountQuery" onclick="clickLink(this);return false;" 
						href="<%=request.getContextPath()%>/jsp/criminalPopulationStatistics.jsp">重点人口统计查询</a></p>
				</div>
				<div title='流动人口到期检查'>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;<a id="floatPopExpireCheck" onclick="clickLink(this);return false;" 
						href="<%=request.getContextPath()%>/jsp/floatPopExpireCheck.jsp">房屋到期检查</a></p>
				</div>
				<div title='账户管理'>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;<a id="registerId" onclick="clickLink(this);return false;" 
						href="<%=request.getContextPath()%>/jsp/manageuser.jsp">用户管理</a></p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;<a id="modifyPass" onclick="clickLink(this);return false;" 
						href="<%=request.getContextPath()%>/jsp/ChangePassWord.jsp">修改密码</a></p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;<a id="registerId" onclick="clickLink(this);return false;" 
						href="<%=request.getContextPath()%>/register/userRegistration.jsp">用户注册</a></p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;<a id="modifyPass" onclick="clickLink(this);return false;" 
						href="<%=request.getContextPath()%>/jsp/updateData.jsp">更新记录</a></p>

				</div>
			</div>
			<div><h1>标 题 信 息</h1></div>
		</div>
		<div id="show" data-options="region:'center',border:true">
			<div id="tabs" class="easyui-tabs"  fit="true" border="false" ></div>
		</div>
	</div>	
  </body>
</html>
