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
<title>修改密码</title>
 <script type="text/javascript">
// $(document).ready(function(){
//  loadImage();
//});
 
  function updatepass(){
 // 	$("#ff").form("validate");

	     var oldpassword=$("#oldpassword").val();

	     var newpassword1=$("#newpassword1").val();

	     var newpassword2=$("#newpassword2").val();
	     if(oldpassword==null||oldpassword==''){
	     	alert("请输入当前密码!");
	     	return;
	     }else if(newpassword1==null||newpassword1==''){
	     	alert("请输入新密码!");
	     	return;
	     	
	     }
	     else if(newpassword2==null||newpassword2==''){
	     	alert("请输入确认新密码!");
	     	return;
	     	
	     }
	     if(newpassword1!=newpassword2){
	     	alert("新密码必须和确认密码一致!");
	     	return;
	     }
/*	     if("" == newpassword1 || "" == newpassword2 || "" == oldpassword){
	     		$.messager.alert("操作提示","密码不能为空,请重新输入!","info");	
	     }else{
			 if(newpassword1 != newpassword2){
			  		$("#newpassword1").val(""); 
			  		$("#newpassword2").val(""); 
					$.messager.alert("操作提示","输入两次新密码不一致,请重新输入!","info");	
			  }
		}*/
			$.ajax({
	    		type:'POST',
	    		url: "<%=request.getContextPath()%>/manageUserController/updatepass.action",
	    		data: "oldpassword="+oldpassword+"&newpassword1="+newpassword1,
	    		dataType: "json",
	    		success:function(info){	  	
				  	     if(info==1){
				  	     	$("#oldpassword").val("");
				  	      	$("#newpassword1").val(""); 
			  				$("#newpassword2").val(""); 
							$.messager.alert("操作提示","修改成功!","info");	
				  	      }else if(info==2){
				  	      	$("#oldpassword").val("");
				  	      	$("#newpassword1").val(""); 
			  				$("#newpassword2").val(""); 
				  	      	$.messager.alert("操作提示","密码不正确,请重新输入!","info");					  	      
				  	      }
	    		}
	    	});
	}
  </script>

</head>
<body>
	<table  align="center" style="position:absolute;top:20px;left:20px" cellspacing="8"> 
		<tr>
			<td align="right">原始密码：</td>
			<td align="right"><input class="easyui-validatebox" type="password" id="oldpassword" ></input></td>
		</tr>
		<tr>
			<td align="right">新密码：</td>
			<td align="right"><input class="easyui-validatebox" type="password"  id="newpassword1" >
			</td>
		</tr>
		<tr>
			<td align="right">确认密码：</td>
			<td align="right"><input class="easyui-validatebox" type="password"  id="newpassword2" >
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updatepass()">确定</a>
			</td>
		</tr>	  	
	</table>
</body>
</html>