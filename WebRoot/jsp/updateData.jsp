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
<title>更新记录</title>


</head>
<body>
<div>
<Br/>
<strong>三实信息管理系统 V1.5 更新记录</strong><br/>
&nbsp;&nbsp; 一、PC：提示当前版本号<br/>
&nbsp;&nbsp; 1、［显示内容删除］单位基本信息查询：去掉：经营性质、租金<br/>
&nbsp;&nbsp; 2、［显示内容删除］实有单位信息查询：去掉：化程度－出租日起，户口类别、曾用民，职业，人口性质<br/>
&nbsp;&nbsp; 3、［文字修改］实有人口信息,实有房屋信息查询,实有人口信息查询<br/>
&nbsp;&nbsp; 4、［显示内容删除及追加显示内容］重点人口分类:犯罪类型－改成－列化类型;增加：联系方式，现住址，户籍<br/>
&nbsp;&nbsp; 5、［新功能追加］参照重点人口统计：常住户人口、流动人口，总人口数，以报表的形式进行数据展示<br/>
<Br/>
<strong>三实信息管理系统 V1.4 更新记录</strong><br/>
&nbsp;&nbsp; 1、PAD：提示当前版本号<br/>
&nbsp;&nbsp; 2、PC：调整标格宽度<br/>
&nbsp;&nbsp; 3、PC：图片点击放大<br/>
&nbsp;&nbsp; 4、PC：版本号＋更新记录文件<br/>
&nbsp;&nbsp; 5、PC：一键导出数据<br/>
<br/>
<strong>三实信息管理系统 V1.3 更新记录</strong><br/>
&nbsp;&nbsp; 1、PAD：首页：在一屏上显示，不要出现拖动的情况  <br/>
&nbsp;&nbsp; 2、PAD：对输入系统中的内容，不能为空的，进行为空判断  <br/>
&nbsp;&nbsp; 3、PAD：每个页面的，左箭头，去掉  <br/>
&nbsp;&nbsp; 4、PAD：删除位置标  <br/>
&nbsp;&nbsp; 5、PAD：底部，平均居中  <br/>
&nbsp;&nbsp; 6、PAD：画笔，分粗细，建议，做两个  <br/>
&nbsp;&nbsp; 7、PAD：线条，调整粗细，用原来的粗细  <br/>
&nbsp;&nbsp; 8、PAD：窗户，完全黑色，无法看到，门图片处的留白应该超过10个像素  <br/>
&nbsp;&nbsp; 9、PAD：方向标，初始，太小，胡重新提供一个  <br/>
&nbsp;&nbsp; 10、PAD：房屋基本信息：民警责任片区：4个片区：P1021 程喆、P1022 李晓龙、P1023 段成鑫、 P1024 陈玉龙  <br/>
&nbsp;&nbsp; 11、PC：数据导出到EXCEL，同时也导出图片到另一个文件夹中，EXCEL文件中链接好图片的URL地址  <br/>
&nbsp;&nbsp; 12、PC：实有人口信息：添加重点人口分类后，统计出分类类别的总数  <br/>
&nbsp;&nbsp; 13、PC：根据房屋“到租时间“，提示到租前10天的信息，管理员根据检查工作内容后，进行修改。修改完成后的数据不再显示  <br/>
&nbsp;&nbsp; 14、PAD＋PC：房屋基本信息：出租时间（到租日期），位置和出租日期，放一块  <br/>
&nbsp;&nbsp; 15、PAD＋PC信息查询详细内容展示，以table标签的形式进行展示，可以进行修改、删除操作：实有单位：table名为（单位信息、屋主信息、法人信息、职工信息、户型图、照片／拍照）；实有人口：table名为（房屋信息、房主信息、实有人口信息、户型图、照片／拍照）  <br/>
&nbsp;&nbsp; 16、PAD＋PC：住房信息：重点人口分类，下拉列表，PAD和PC都需要：三抢偷盗、卖淫嫖娼、打架斗殴、非法集会、上访、诈骗、吸毒  <br/>
&nbsp;&nbsp; 17、PAD+PC：实有人口信息：在实有人口信息页面添加 人口类型｛常住人口、流动人口｝  <br/>
<br/>
<strong>三实信息管理系统 V1.2 更新记录</strong><br/>
&nbsp;&nbsp; 1、PC：登陆：去掉注册按钮<br/>
&nbsp;&nbsp; 2、PC：修改：弹窗位置，和数据显示位置<br/>
&nbsp;&nbsp; 3、PC：EXCEL导出，选择导出<br/>
&nbsp;&nbsp; 4、PC：能做数据显示下拉的尽量做数据下拉<br/>
&nbsp;&nbsp; 5、PC：查询，做成like模糊查询<br/>
&nbsp;&nbsp; 6、PC：无法操作，给出提示<br/>
&nbsp;&nbsp; 7、PC：表格重新设计<br/>
&nbsp;&nbsp; 8、PC：图片左右切图<br/>
&nbsp;&nbsp; 9、PC：注册时对已经使用过的名字进行判断<br/>
&nbsp;&nbsp; 10、PAD+PC：名族添加下拉列表<br/>
<br/>
<strong>三实信息管理系统 V1.1 更新记录</strong><br/>
&nbsp;&nbsp; 1、PAD：UI设计<br/>
&nbsp;&nbsp; 2、PAD：登录功能<br/>
&nbsp;&nbsp; 3、PAD：三实单位信息录入<br/>
&nbsp;&nbsp; 4、PAD：三实人口信息录入<br/>
&nbsp;&nbsp; 5、PAD：实有单位，实有人口信息查询<br/>
&nbsp;&nbsp; 6、PAD：信息同步：上传本地单位数据信息，上传本地房屋数据信息，同步服务器数据信息<br/>
&nbsp;&nbsp; 7、PAD：修改密码功能<br/>
&nbsp;&nbsp; 8、PC：登录功能<br/>
&nbsp;&nbsp; 9、PC：单位信息：单位信息查询，单位人员信息查询<br/>
&nbsp;&nbsp; 10、PC：住房信息：房屋信息查询，房屋人员信息查询<br/>
&nbsp;&nbsp; 11、PC：账户管理<br/>
<br/><br/><br/><br/><br/><br/>
</div>
</body>

</html>