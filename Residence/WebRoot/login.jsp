<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>账号登录</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/mune.css" rel="stylesheet" type="text/css" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/Residence/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="/Residence/js/easyui/jquery.range.css" />
	<link rel="stylesheet" type="text/css" href="/Residence/js/easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="/Residence/js/easyui/jquery-ui.css" />
	<link rel="stylesheet" type="text/css" href="/Residence/js/easyui/css/common.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery-1.8.1.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/js/master.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.range.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/validateboxRules.js"></script>

 <script type="text/javascript">
// $(document).ready(function(){
//  loadImage();
//});
 
  function login(){
 // 	$("#ff").form("validate");
	     var username=$("#username").val();
	     var pass=$("#pass").val();
//	     var code=$("#code").val();
	     if(username==null||username==""){
	     	alert("请输入用户名!");
	     	return;
	     }else if(pass==null||pass==""){
	     	alert("请输入密码!");
	     	return;
	     }
//	     else if(code==null||code==""){
//	     	alert("请输入验证码!");
//	     	return;
//	     }
			$.ajax({
	    		type:'POST',
	    		url: "<%=request.getContextPath()%>/manageUserController/loginSys.action",
	    		data: "username="+username+"&pass="+pass,
	    		dataType: "json",
	    		success:function(info){	
				  	     if(info==1){
				  	     	alert("验证码错误!");
				  	       // $("#ts1").value("验证码错误!");			  	       
				  	       // $("#ts1").css("color","#00FF00");
				  	       }
				  	       else if(info==2){
							alert("用户名不存在!");
				  	       // $("#ts1").value("用户名不存在!");
				  	        //$("#ts1").css("color","#FF0000");
				  	       }else if(info==3){
							alert("密码错误!");
				  	       	//$("#ts1").value("密码错误!");
				  	       // $("#ts1").css("color","#FF0000");
				  	       }else{
							location.href="<%=request.getContextPath()%>/jsp/home.jsp";
				  	       
				  	       }
	    		}
	    	});
	}
  
//	function clickcode(code){
//		code.value="";
//	}
  
//  function clickImage(){
//   	document.getElementById("image").src="<%=request.getContextPath()%>/manageUserController/getImage.action?r="+Math.random();  	  	
//   }
  
  </script>
  </head>
  <body>
  <div id="warp">
<div class="bj">
	 <div class="bt"  style='position:absolut; left:670px; top:220px'>
   			<h2 style=" text-align:center">三实信息采集系统</h2>
     </div>
    <div class="zh">
    	<div class="srk">
    		 <p>用户名：<input style="background:#FFF;border:1px solid #a7a6a6; width:209px; height:24px;" id="username" name="username"></p> 
        	 <p style="letter-spacing: 4px;">密码：<input id="pass" name="password" type="password" style="background:#FFF;border:1px solid #a7a6a6; width:209px; height:24px; margin-left: 3px"></p>



<!--        	<p >验证码：<input id="code" name="checkcode" onclick="clickcode(this)" value="看不清？请点击验证码！" style="background:#FFF;border:1px solid #a7a6a6; width:104px; height:24px;">-->
<!--        	          <span onclick="clickImage()"><img id="image" src="<%=request.getContextPath()%>/manageUserController/getImage.action" style="padding-left:10px;"/></span>-->
<!--        	</p>   -->
        	          
        	          
        	          
       	</div> 
    </div>
    <div class="anniu" style="padding-left:48%; padding-top:10px;">       
        	<div class="dl">            
				<p href="javascript:void(0)"  onclick="login()">登录</p>
            </div>
            <!--
            <div class="zc">
				<p><a href="<%=request.getContextPath()%>/register/userRegistration.jsp"  onclick="userRegistration()">注册</a></p>
            </div>       
   			 -->
    </div>
    </div>
</div>
  </body>
</html>
