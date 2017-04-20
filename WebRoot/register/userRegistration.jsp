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
<title>用户注册</title>


<script type="text/javascript">

	//注册
	function userRegistation(){
			var uName=$("#uName").val();
			var telephone=$("#telephone").val();
			var password1=$("#password1").val();
			var newpassword2=$("#newpassword2").val();
			if(uName==null||uName==''){
			 	alert("请输入用户名!");
			 	return;
			}else if(telephone==null||telephone==''){
				alert("请输入手机号码!");
				return;
			}else if(password1==null||password1==''){
				alert("请输入密码!");
				return;
			}else if(newpassword2==null||newpassword2==''){
				alert("请输入确认密码!");
				return;
			}

			var phone = /^(0|86|17951)?(13[0-9]|15[012356789]|18[02356789]|14[57])[0-9]{8}$/;
			if(!phone.test($("#telephone").val())){
			    alert("手机号码不合法!");

			    return ;

			}
			if(password1.length!=6){
				alert("请输入6位密码!");
				return;
			}
			if(password1!=newpassword2){
				alert("密码必须和确认密码一致!");
				return;
			}
			
			  $.messager.confirm('注册确认', '確定要注册此数据吗？', function(r){
			if (r){
				var rest = $("#fm").serialize();
				 $.ajax({
						type:'POST',
						url: "<%=basePath%>manageUserController/userRegistation.action",
						data: rest,
						success:function(info){
							if(info == 1){
								alert("注册成功！");
								location.reload();
							}
						}
					});
			}
		});
	}
	var eqnumber="";
	//校验证件号重复
	function checkNumber(){
		var certificateNum = $("#certificateNum").val();
		if(eqnumber == certificateNum){
			return false;
		}
		if(certificateNum != ""){
			$.ajax({
	    		type:'POST',
	    		url: "<%=basePath%>manageUserController/checkNumber.action",
	    		data: "certificateNum="+certificateNum,
	    		dataType: "json",
	    		success:function(info){
	    			if(info == 1){
	   					$.messager.alert("操作提示","证件号码已存在，请重新输入！","info");
	   					$("#certificateNum").val("");
	   				}
	    		}
	    	});
		}
	}

	//校验用户名重复
	function checkUserName(){
		var uName = $("#uName").val();
		if(uName != ""){
			$.ajax({
	    		type:'POST',
	    		url: "<%=basePath%>manageUserController/checkUserName.action",
	    		data: "uName="+uName,
	    		dataType: "json",
	    		success:function(info){
	    			if(info == 1){
	   					$.messager.alert("操作提示","用户名已存在，请重新输入！","info");
	   					$("#uName").val("");
	   				}
	    		}
	    	});
		}
	}
</script>
</head>
<body>
<div>
	<form id="fm" method="post">
	<table  align="center" style="position:absolute;top:20px;left:20px" cellspacing="10"> 
		<tr>
			<td align="right">管理人用户名：</td>
			<td align="right"><input class="easyui-validatebox" type="text" id="uName" name="uName"  onblur="checkUserName()" ></input></td><td><font color='red'>*</font></td>		
		</tr>
		
		<tr>
			<td align="right">手机号码：</td>
			<td align="right"><input class="easyui-validatebox" type="text" id=telephone name=telephone ></td><td><font color='red'>*</font></td>
		</tr>
		<tr>
			<td align="right">密码：</td>
			<td align="right"><input class="easyui-validatebox" type="password" id="password1" name="password1" ></td><td><font color='red'>*</font></td>
		</tr>
		
		<tr>
			<td align="right">确认密码：</td>
			<td align="right"><input class="easyui-validatebox" type="password" id="newpassword2" name="newpassword2" ></td><td><font color='red'>*</font></td>
		</tr>
		<tr>
			<td align="right">证件类型：</td>
			<td align="right"><input class="easyui-validatebox" type="text" id="certificateType" name="certificateType" ></input></td>		
		</tr>
		
		<tr>
			<td align="right">证件号码：</td>
			<td align="right"><input class="easyui-validatebox" type="text" id="certificateNum" name="certificateNum"  ></td>		
		</tr>
		
		<tr>
			<td align="right">QQ号码：</td>
			<td align="right"><input class="easyui-validatebox" type="text" id="qqNum" name="qqNum" ></td>
		</tr>
		
		<tr>
			<td align="right">常用邮箱：</td>
			<td align="right"><input class="easyui-validatebox" type="text" id="email" name="email" ></td>
		</tr>
		
		
		
		<tr>
		<td colspan="4"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			 	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="userRegistation()">确定</a>			 
			</td>
		</tr>	  	
	</table>
	</form>
</div>
</body>

</html>