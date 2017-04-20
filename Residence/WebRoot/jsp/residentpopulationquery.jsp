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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/popwin.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/popwin.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/play.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/play.js"></script>
<title>家庭人员查询</title>

<script type="text/javascript">
	$(window).ready(function(){
		setFormReadOnly();
	getListPage();
		$('#dlg1').dialog('close');
		$('#dlg2').dialog('close');
		$('#dlg3').dialog('close');
		$('#dlg4').dialog('close');
		$('#dlg6').dialog('close');
		$('#dlg7').dialog('close');
		$('#dlg8').dialog('close');
	});

	//查询方法，带分页
	function getListPage(){
				$('#list').datagrid({			
					url: "<%=request.getContextPath()%>/residentPopulationController/getListPage.action?type=0",
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
						}},																		
						{field:'name',title:'姓名',width:50},
						{field:'oldName',title:'曾姓名',width:50},

						{field:'sex',title:'性别',width:50},
						{field:'nation',title:'民族',width:50},
						{field:'certificateNum',title:'身份证号',width:150},
						{field:'personType',title:'人口性质',width:60},
						{field:'birthday',title:'出生日期',width:60},
						{field:'degreeEducation',title:'文化程度',width:60},						
						{field:'maritalSta',title:'婚姻状况',width:60},
						{field:'militarySta',title:'兵役状况',width:60},
						{field:'tempLiveNo',title:'暂住编码',width:100},
						{field:'relation',title:'成员关系',width:60},
						{field:'tempLiveDate',title:'暂住日期',width:60},
						{field:'bloodType',title:'血型',width:50},
						{field:'height',title:'身高',width:50},
						{field:'occupation',title:'职业',width:80},
						{field:'post',title:'职务',width:80},
						{field:'houseRegist',title:'户籍详址',width:100},
						{field:'serviceAddr',title:'服务住所',width:100},						
						{field:'landLine',title:'固定电话',width:100},
						{field:'telephone',title:'手机号码',width:100},
						{field:'actualLiveAddr',title:'实际地址',width:150},
						{field:'qqNum',title:'QQ',width:80},
						{field:'weChatNum',title:'微信',width:100},
						{field:'imgPersonUrl',title:'个人照片',hidden:true},
						{field:'tempLiveDate',title:'租住时间',width:90},
						//{field:'rentalTime',title:'到租时间',width:80},
						{field:'rentReason',title:'暂住事由',width:100},
						{field:'liveDate',title:'居住时间',width:80}
					//	{field:'version',title:'版本号',width:50},
					]],																								
				toolbar:[
					/*{
					id:'btnsave',
					text:'修改',
					disabled:false,
					iconCls:'icon-edit',
					handler:function(){
						var row = $('#list').datagrid('getChecked');
						if(row.length > 1){
							$.messager.alert("操作提示","只能选择一条数据","info");
						}else if(row.length == 0){
							$.messager.alert("操作提示","请选择要修改的数据","info");
						}else{
						$('#id').val(row[0].id);
							openDialog('修改信息','1');							
						}
					}
				},*/{
					id:'btnSpectific',
					text:'详细信息',
					disabled:false,
					iconCls:'icon-searchSpecific',
					handler:function(){
						var row = $('#list').datagrid('getChecked');
						if(row.length > 1){
							$.messager.alert("操作提示","只能选择一条数据","info");
						}else if(row.length == 0){
							$.messager.alert("操作提示","请选择要修改的数据","info");
						}else{
						    $('#id').val(row[0].id);
							openDialog('详细信息','0');							
						}
					}
				},{
					id:'btncut',
					text:'删除',
					iconCls:'icon-cut',
					handler:function(){
						var row = $('#list').datagrid('getChecked');
						residentpopulationDel(row);
					}
				},{
					id:'btncut',
					text:'一键导出',                 
					iconCls:'icon-print',
					handler:function(){
						var rows = $('#list').datagrid('getChecked');
						exportExcel(rows);
					}
				}],
				onClickRow: function(rowIndex, rowData){
				}					
			});
	}
	//修改
	function update(){
			  $.messager.confirm(''+'修改确认', '確定要修改此数据吗？', function(r){
			if (r){
				var rest = $("#fm").serialize();
				 $.ajax({
						type:'POST',
						url: "<%=basePath%>residentPopulationController/updateResidentPopulation.action",
						data: rest,
						success:function(info){
							if(info == 1){
								$.messager.alert("操作提示","修改成功","info");
								d_close();
								$('#list').datagrid('reload'); 
							}
						}
					});
			}
		});
	}
	
	//删除
	function residentpopulationDel(rows){
		var id ="";
		  if(rows != ""){
			  for(var i = 0; i < rows.length; i++){
				  id += rows[i].id +"," ;
			  }
			  $.messager.confirm('删除确认', '確定要删除选中的数据吗', function(r){
					if (r){
						 $.ajax({
							type:'POST',
							url: "<%=request.getContextPath()%>/residentPopulationController/residentpopulationDel.action",
							data : "id=" + id,
							dataType : "json",
							success : function(info) {
								if (info == 1) {
									$.messager.alert("操作提示","删除成功","info");
									$('#list').datagrid('reload');
								}
							}
						});
					}
				});
			} else {
				$.messager.alert("操作提示","请选择要删除的数据","info");
			}
	}
	
	//导出Excel
	function exportExcel(rows){
		if(rows != undefined && rows != ""){
			var count = rows.length;
			var fileName = "住房人员信息表";
			var type = "house_p";
			var rowsJsonStr = JSON.stringify(rows);
			$.messager.confirm('导出确认', '确定要导出当页的'+count+'条数据吗？', function(r){
				if (r){
					$.ajax({
							type:'POST',
							url: "<%=request.getContextPath()%>/excel/exportExcel.action",
							data : "fileName=" + fileName+"&rowsJsonStr="+rowsJsonStr+"&type="+type,
							success : function(msg) {
									local("<%=basePath%>/excel/downFile.action?fileName="+fileName);	
							}
					});
				}
			});
		}
	}
	function local(url){
		window.location.href=url;
	}
	function showDataDiv1(){
		setOpen($("#dataDiv1"));//默认显示第一个div
  		var data =$('#list').datagrid('getChecked');
//  			$('#id').val(data[0].id);		  			
//  			$('#hId').val(data[0].hid);
  			$('#pTypem').val(data[0].ptype);			  					  			
			$('#namem').val(data[0].name);
			$('#oldNamem').val(data[0].oldName);
			$('#sexm').val(data[0].sex);	
			$('#birthdaym').val(data[0].birthday);				
			$('#nationm').val(data[0].nation);										
			$('#relationm').val(data[0].relation);										
			$('#certificateNumm').val(data[0].certificateNum);
			$('#degreeEducationm').val(data[0].degreeEducation);					
			$('#maritalStam').val( data[0].maritalSta);
			$('#militaryStam').val( data[0].militarySta);
			$('#personTypem').val( data[0].personType);																		
			$('#tempLiveNom').val(data[0].tempLiveNo);
			$('#tempLiveDatem').val( data[0].tempLiveDate);	
			$('#tempLiveDatem1').val( data[0].tempLiveDate);
			$('#criminalm').val( data[0].criminal);
			$('#bloodTypem').val( data[0].bloodType);															
			$('#heightm').val(data[0].height);
			$('#occupationm').val(data[0].occupation);
			$('#actualLiveAddrm').val(data[0].actualLiveAddr);										
			$('#postm').val(data[0].post);
			$('#houseRegistm').val(data[0].houseRegist);										
			$('#serviceAddrm').val(data[0].serviceAddr);																								
			$('#landLinem').val(data[0].landLine);										
			$('#telephonem').val(data[0].telephone);
			$('#qqNumm').val(data[0].qqNum);
			$('#weChatNumm').val(data[0].weChatNum);
			$('#imgPersonUrlm').val(data[0].imgPersonUrl);					
			$('#prentalTimem').val(data[0].rentalTime);
			$('#rentReasonm').val(data[0].rentReason);
			$('#liveDatem').val(data[0].liveDate);
			 
			/*if(diff=='1')
			{
				$("#btnLa").hide();
				setFormReadOnly();
			}else{
				$("#btnLa").show();
				setFormCanBeEdited();
			}
			
			var str="<table align='center'><tr>";
			str+="<td><a id='ownerDetail' href='#' onclick='searchPopulation(1)'>住房人员详情</a></td>";
			//if(data[0].ptype=='2'){
				str+="<td><a id='ownerHBtn' href='#' onclick='searchPopulation(1)'>此人所在房屋的房主</a></td>";
			//}
			str+="<td><a id='familyMemsBtn' href='#' onclick='searchPopulation(2)'>此人所在房屋的家庭成员</a></td>";
			str+="<td><a id='houseBtn' href='#' onclick='searchHouseInfo()'>此人所在的房屋信息</a></td>";
			str+="<td><a id='photoBtn' href='#' onclick='searchPhoto()'>此人的拍照</a></td></tr>";
			str+="</table>";
			$("#tt").html(str);
			$('#ownerDetail').linkbutton({   
				iconCls: 'icon-search'  
			}); 
			$('#photoBtn').linkbutton({   
				iconCls: 'icon-search'  
			}); 
			$('#houseBtn').linkbutton({   
				iconCls: 'icon-search'  
			}); 
			$('#familyMemsBtn').linkbutton({   
				iconCls: 'icon-search'  
			}); 
			//if(data[0].ptype=='2'){
				$('#ownerHBtn').linkbutton({   
					iconCls: 'icon-search'  
				}); 
			//}*/
	}
	//打开Dialog层
	function openDialog(titleName,diff){
		  $('#dlg').dialog('open').dialog('setTitle',titleName);
		  showDataDiv1();
		  
	}
	//拍照
	function personPhotoImages()
	{
		var rows = $('#list').datagrid('getChecked');
		var photosImages=rows[0].imgPersonUrl;
		$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+rows[0].id+"&source=''",
						dataType:'JSON',
						success:function(info){
							var mediaFiles=info;
							
						/*	var imageUrlsStr="<table align='center'><tr>";
							for(var i=0;i<mediaFiles.length;i++){
								imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
							}
							imageUrlsStr+="</tr></table>";
							$("#imageUrlsDv").html(imageUrlsStr);*/

							_initRollImgs(mediaFiles,"imageUrlsDv");
						}
		});
	}
	//关闭dialog层
	function d_close(){
			$('#dlg').dialog('close');
	}
	function searchPhoto(){
		setOpen($("#dataDiv5"));
		//$('#dlg1').dialog('open');
		personPhotoImages();
	}
	//查询   
	function searchData(){
		var sname = $('#sname').val();
		var scertificateNum = $('#scertificateNum').val();			
		var stelephone = $('#stelephone').val();
		if(sname==''&&scertificateNum==''&&stelephone==''){
			getListPage();
			return;
		}
		var url = "<%=request.getContextPath()%>/residentPopulationController/getResidentPopulationQuery.action?type=0&sname="+sname+"&scertificateNum="+scertificateNum+"&stelephone="+stelephone;		
		$('#list').datagrid({url: url});
		$('#list').datagrid("reload");
	}
	//家庭成员或者房主信息
	function searchPopulation(personType){
		var rows =$('#list').datagrid('getChecked');
		var hid=rows[0].hid;
		 $.ajax({
					type:'POST',
					url: "<%=request.getContextPath()%>/residentPopulationController/selectHousePopulation.action?hId="+hid+"&pType="+personType,
				dataType : "json",
					success:function(info){
						if(personType=='1'){
							setOpen($('#dataDiv2'));
							var data =info;
						//	$('#dlg2').dialog('open');
							if(data[0].ptype=='1'){
							  $('#oWnerpTypef').val('房主');
							}else{
								 $('#oWnerpTypef').val('家庭成员');
							}
				  						  					  			
							$('#oWnernamef').val(data[0].name);
							$('#oWneroldNamef').val(data[0].oldName);
							 $('#oWnersexf').val(data[0].sex);
							 	
							$('#oWnerbirthdayf').val(data[0].birthday);				
							$('#oWnernationf').val(data[0].nation);										
							$('#oWnerrelationf').val(data[0].relation);										
							$('#oWnercertificateNumf').val(data[0].certificateNum);
							$('#oWnerdegreeEducationf').val(data[0].degreeEducation);					
							 $('#oWnermaritalStaf').val(data[0].maritalSta);
							 
							 $('#oWnermilitaryStaf').val(data[0].militarySta);
							 $('#oWnerpersonTypef').val(data[0].personType);																		
							$('#oWnertempLiveNof').val(data[0].tempLiveNo);
							$('#oWnertempLiveDatef').val(data[0].tempLiveDate);					
							$('#oWnerbloodTypef').val(data[0].bloodType);															
							$('#oWnerheightf').val(data[0].height);
							$('#oWneroccupationf').val(data[0].occupation);
							$('#oWneractualLiveAddrf').val(data[0].actualLiveAddr);										
							$('#oWnerpostf').val(data[0].post);
							$('#oWnerhouseRegistf').val(data[0].houseRegist);										
							$('#oWnerserviceAddrf').val(data[0].serviceAddr);																								
							$('#oWnerlandLinef').val(data[0].landLine);										
							$('#oWnertelephonef').val(data[0].telephone);
							$('#oWnerqqNumf').val(data[0].qqNum);
							$('#oWnerweChatNumf').val(data[0].weChatNum);
							$('#oWnerimgPersonUrlf').val(data[0].imgPersonUrl);					
							$('#oWnerrentDatef').val(data[0].rentalTime);
							$('#oWnerrentReasonf').val(data[0].rentReason);
							$('#oWnerliveDatef').val(data[0].liveDate);
						 
							$('#oWnercriminalf').val(data[0].criminal);
							var pId=data[0].id;
							var photosImages=data[0].imgPersonUrl;
							$.ajax({
										type:'POST',
										url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+pId+"&source=202",
										dataType:'JSON',
										success:function(minfo){
											var mediaFiles=minfo;
											
											/*var imageUrlsStr="<table align='center'><tr>";
											for(var i=0;i<mediaFiles.length;i++){
												imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
											}
											imageUrlsStr+="</tr></table>";
											$("#imageUrlsDv1").html(imageUrlsStr);*/

											_initRollImgs(mediaFiles,"imageUrlsDv1")
							
												
										}
							});
						}else{
							setOpen($('#dataDiv3'));
							$('#datagrid3').datagrid({   
							    data:info, 
							    pagination:true,//是否分页			
								fitColumns: false,//
								singleSelect: false,//是否只能单选
								scrollbarSize: 0,
								rownumbers:true,//行号
								fit: true,
								nowrap: true,   
							   columns:[[
							   
							   		{field:'id',title:'拍照',width:45,align:'center',formatter:function(value, row, index){
										return "<a href='#' onclick='housePersonImage(\""+value+"\")'>查看</a>";
									}},
									{field:'name',title:'姓名',width:60},
									{field:'oldName',title:'曾姓名',width:60},
			                        {field:'sex',title:'性别',width:50},
									{field:'nation',title:'民族',width:50},
									{field:'certificateNum',title:'身份证号',width:120},
									{field:'birthday',title:'出生日期',width:80},
									{field:'degreeEducation',title:'文化程度',width:60},	
									{field:'maritalSta',title:'婚姻状况',width:60},
									{field:'militarySta',title:'兵役状况',width:60},
									{field:'tempLiveNo',title:'暂住编码',width:80},
									{field:'relation',title:'成员关系',width:80},
									{field:'tempLiveDate',title:'暂住日期',width:80},
									{field:'bloodType',title:'血型',width:50},
									{field:'height',title:'身高',width:50},
									{field:'occupation',title:'职业',width:80},
									{field:'post',title:'职务',width:80},
									{field:'houseRegist',title:'户籍地址',width:100},
									{field:'serviceAddr',title:'服务住所',width:100},
									{field:'landLine',title:'固定电话',width:80},
									{field:'actualLiveAddr',title:'实际住址',width:100},
									 {field:'personType',title:'人口类型',width:60},
									 {field:'criminal',title:'重点人口分类',width:100},
									{field:'telephone',title:'手机',width:80},
									{field:'qqNum',title:'QQ',width:80},
									{field:'weChatNum',title:'微信',width:80},
									//{field:'imgPersonUrl',title:'个人照片',hidden:true},
									{field:'tempLiveDate',title:'租住时间',width:80},
									//id未定
									{field:'rentalTime',title:'到租时间',width:80},
									{field:'rentReason',title:'暂住事由',width:100},
									{field:'liveDate',title:'居住时间',width:80}
								]]   
							});
							//$('#dlg3').dialog('open');
						}	
					}
		});
	}
	//查看住房信息
	function searchHouseInfo(){
		setOpen($('#dataDiv4'));
		var rows =$('#list').datagrid('getChecked');
		var hid=rows[0].hid;
		$.ajax({
					type:'POST',
					url: "<%=request.getContextPath()%>/houseController/getHouseInfoByHId.action?hId="+hid,
					dataType:'json',
					success:function(info){
						//$('#dlg4').dialog('open');
						var data=info;
						$('#haddr').val(data[0].haddr);
			  			$('#hname').val(data[0].hname);
						$('#hbuildingNum').val(data[0].hbuildingNum);
						$('#hunitNum').val(data[0].hunitNum);										
						$('#hfloorNum').val(data[0].hfloorNum);
						$('#hroomNum').val(data[0].hroomNum);										
						$('#hstructure').val(data[0].hstructure);																								
						$('#hpropertyRight').val(data[0].hpropertyRight);										
						$('#hsecurityStatus').val(data[0].hsecurityStatus);
						$('#rentalTime').val(data[0].rentalTime);
						$('#rentalArea').val(data[0].rentalArea);
						$('#rentalRoomNum').val(data[0].rentalRoomNum);					
						$('#rentalRoomDate').val(data[0].rentalRoomDate);
						$('#policeOperateArea').val(data[0].policeOperateArea);
						$('#operateRow').val(data[0].operateRow);
						$('#chargePoliceNum').val(data[0].chargePoliceNum);								
						$('#hoversion').val(data[0].version);
						$('#houseImageUrlsId').val(data[0].hid);
						$('#houseLayOutDiagramId').val(data[0].layoutDiagramUrl);
						$('#rentType').val(data[0].rentType);
						}
		});
	}
	function housePersonImage(vv)
	{
		$.ajax({
				type:'POST',
			       url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+vv+"&source=203",
		    dataType:'JSON',
											success:function(minfo){
												$('#dlg6').dialog('open');
												var mediaFiles=minfo;
												
												/*var imageUrlsStr="<table align='center'><tr>";
												for(var i=0;i<mediaFiles.length;i++){
													imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
												}
												imageUrlsStr+="</tr></table>";
												$("#imageUrlsDv2").html(imageUrlsStr);*/

												_initRollImgs(mediaFiles,"imageUrlsDv2");
												}});
	}
	function searchLayOutUrl()
	{
		var ld=$('#houseLayOutDiagramId').val();
		$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/unitController/findImages.action?imagesIds="+ld,
						dataType:'JSON',
						success:function(info){
							var mediaFiles=info;
							$('#dlg8').dialog('open');
							/*var imageUrlsStr="<table align='center'><tr>";
							for(var i=0;i<mediaFiles.length;i++){
								imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
							}
							imageUrlsStr+="</tr></table>";
							$("#imageUrlsDv5").html(imageUrlsStr);*/

							_initRollImgs(mediaFiles,"imageUrlsDv5");
						}
		});
	}
	function searchHouseUrls()
	{
		var ld=$('#houseImageUrlsId').val();
		$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+ld+"&source=201",
						dataType:'JSON',
						success:function(info){
							var mediaFiles=info;
							$('#dlg7').dialog('open');
							/*var imageUrlsStr="<table align='center'><tr>";
							for(var i=0;i<mediaFiles.length;i++){
								imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
							}
							imageUrlsStr+="</tr></table>";
							$("#imageUrlsDv4").html(imageUrlsStr);*/
							_initRollImgs(mediaFiles,"imageUrlsDv4");
						}
		});
	}
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
	  		<div id="choose" data-options="region:'north'" style="height:50px;background-color:#F5F5F5">
	  			<div style="padding-left:5px;padding-top:10px;">
		  			<span>姓名:
						<input class="easyui-validatebox" type="text" style="width:130px;"  id="sname" name="sname"/></span>
						&nbsp;&nbsp;&nbsp;				
					<span>身份证号:
						<input class="easyui-validatebox" type="text" style="width:130px;"  id="scertificateNum" name="scertificateNum"/></span>
						&nbsp;&nbsp;&nbsp;
<!--					<span>小区名称:-->
<!--						<input class="easyui-validatebox" type="text" style="width:70px;"  id="hName" name="hName" /></span>-->
<!--						&nbsp;&nbsp;&nbsp;-->
<!--					<span> 楼栋:-->
<!--						<input class="easyui-validatebox" type="text" style="width:70px;"  id="hBuildingNum" name="hBuildingNum" /></span>-->
<!--						&nbsp;&nbsp;&nbsp;-->
<!--					<span> 单元:-->
<!--						<input class="easyui-validatebox" type="text" style="width:70px;"  id="hUnitNum" name="hUnitNum" /></span>-->
<!--						&nbsp;&nbsp;&nbsp;-->
<!--					<span> 房间号:-->
<!--						<input class="easyui-validatebox" type="text" style="width:70px;"  id="hRoomNumber" name="hRoomNumber" /></span>-->
<!--						&nbsp;&nbsp;&nbsp;												-->
					<span>手机号码:
						<input class="easyui-validatebox" type="text" style="width:130px;"  id="stelephone" name="stelephone"/></span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchData()">查询</a>		
				</div>
	  		</div>  		
	  		
			<div id="show"  data-options="region:'center'">
				<div id="list" class="easyui-datagrid" ></div>
			</div>
	</div>
	<%--
	<div id="dlg1" class="easyui-dialog" title="拍照" data-options="iconCls:'icon-save',modal:true" style="width:500px;height:300px;padding:10px">
		<div id="imageUrlsDv"></div>
	</div>
	<div id="dlg2" class="easyui-dialog" title="房主信息" data-options="iconCls:'icon-save',modal:true" style="width:600px;height:500px;padding:10px">
		<table data-options="region:',border:false,fit:true,fitColumns:false" cellspacing="5" >
					<tr>
						<td align="right">姓名：</td>
						<td ><input class="easyui-validatebox" type="text" id="oWnername"  name = "oWnername" ></input></td>

						<td align="right">曾用名：</td>
						<td ><input class="easyui-validatebox" type="text" id="oWneroldName" name="oWneroldName" >
						</td>
					</tr>
					<tr >
						<td align="right">性别：</td>
						<td ><input class="easyui-validatebox"  id="oWnersex" name="oWnersex" ></input></td>
						<td align="right">民族：</td>
						<td ><input class="easyui-validatebox"  id="oWnernation" name="oWnernation" ></input></td>
					</tr>
					<tr >
						<td align="right">出生日期：</td>
						<td ><input class="easyui-validatebox" type="text" id="oWnerbirthday" name="oWnerbirthday" ></input></td>
					</tr>															
					<tr >
						<td align="right">身份证号：</td>
						<td ><input class="easyui-validatebox" type="text" id="oWnercertificateNum" name="oWnercertificateNum" ></input></td>

						<td align="right">文化程度：</td>
						<td ><input class="easyui-validatebox" type="text" id="oWnerdegreeEducation" name="oWnerdegreeEducation" ></input></td>
					</tr>

					<tr >
						<td align="right">婚姻状况：</td>
						<td ><input class="easyui-validatebox"  id="oWnermaritalSta" name="oWnermaritalSta" ></input></td>
						<tr >
						<td align="right">人口性质：</td>
						<td ><input class="easyui-validatebox"  id="oWnerpersonType" name="oWnerpersonType" ></input></td>
					</tr>	
						<td align="right">兵役状况：</td>
						<td ><input class="easyui-validatebox"  id="oWnermilitarySta" name="oWnermilitarySta" ></input></td>
					</tr>											
					<tr>
						<td align="right">暂住编码：</td>
						<td ><input class="easyui-validatebox" type="text" id="oWnertempLiveNo" name="oWnertempLiveNo" ></input></td>

						<td align="right">暂住日期：</td>
						<td ><input class="easyui-validatebox"  id="oWnertempLiveDate" name="oWnertempLiveDate" ></input></td>
					</tr>															
					<tr >
						<td align="right">血型：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="oWnerbloodType" name="oWnerbloodType" ></input></td>
						<td align="right">身高：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="oWnerheight" name="oWnerheight" ></input></td>
					</tr>
					
					<tr >
						<td align="right">职业：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="oWneroccupation" name="oWneroccupation" ></input></td>

						<td align="right">职务：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="oWnerpost" name="oWnerpost" ></input></td>
					</tr>

					<tr >
						<td align="right">户籍：</td>
						<td colspan="3"><input class="easyui-validatebox" type="text" id="oWnerhouseRegist" name="oWnerhouseRegist" style="width:380px;" ></input></td>
					</tr>

					<tr >
						<td align="right">服务处所：</td>
						<td colspan="3"><input class="easyui-validatebox" type="text" id="oWnerserviceAddr" name="oWnerserviceAddr" style="width:380px;" ></input></td>
					</tr>	
					<tr >
						<td align="right">现居住地址：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="oWneractualLiveAddr" name="oWneractualLiveAddr"  ></input></td>

						<td align="right">固定电话：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="oWnerlandLine" name="oWnerlandLine" ></input></td>
					</tr>
					<tr>
						<td align="right">手机：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="oWnertelephone" name="oWnertelephone" ></input></td>

						<td align="right">QQ：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="oWnerqqNum" name="oWnerqqNum" ></input></td>
					</tr>	
					<tr >
						<td align="right">微信号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="oWnerweChatNum" name="oWnerweChatNum" ></input></td>

						<td align="right">人员类别：</td>					
						<td align="right"><input class="easyui-validatebox"  id="oWnerpType" name="oWnerpType" ></input></td>
					</tr>
					<tr>
						<td align="right">租住时间：</td>
						<td align="right"><input class="easyui-validatebox"  id="oWnerrentDate" name="oWnerrentDate" ></input></td>

						<td align="right">暂住事由：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="oWnerrentReason" name="oWnerrentReason" ></input></td>
					</tr>
					<tr>
						<td align="right">居住时间：</td>
						<td align="right"><input class="easyui-validatebox" id="oWnerliveDate" name="oWnerliveDate" ></input></td>

						<td align="right">版本号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="oWnerversion" name="oWnerversion"></input></td>
					</tr>																								
				</table>
				<div style="padding-top: 5px">
					<div id="imageUrlsDv1"></div>
				</div>
	</div> 
	<div id="dlg3" class="easyui-dialog" title="家庭人员信息列表" data-options="iconCls:'icon-save',modal:true" style="width:700px;height:200px;padding:0px">
		<table id="dg"></table>
	</div>
	<div id="dlg4" class="easyui-dialog" title="房屋信息" data-options="iconCls:'icon-save',modal:true" style="width:600px;height:500px;padding:0px">
		<table data-options="region:',border:false,fit:true,fitColumns:false" cellspacing="8" >
					<tr>
						<td align="right">房子地址信息：</td>
						<td ><input class="easyui-validatebox" type="text" id="haddr"  name = "haddr" ></input></td>

						<td align="right">房屋名称：</td>
						<td ><input class="easyui-validatebox" type="text" id="hname" name="hname" data-options="required:true,validType:['xyz','length[1,20]']">
						</td>
					</tr>
					
					<tr>
						<td align="right">房栋号：</td>
						<td ><input class="easyui-validatebox" type="text" id="hbuildingNum"  name = "hbuildingNum" data-options="required:true,validType:['alphabetfigure','length[1,20]']"></input></td>

						<td align="right">单元号：</td>
						<td ><input class="easyui-validatebox" type="text" id="hunitNum" name="hunitNum" data-options="required:true,validType:['xyz','length[1,20]']">
						</td>
					</tr>
					
					<tr>
						<td align="right">楼层：</td>
						<td ><input class="easyui-validatebox" type="text" id="hfloorNum"  name = "hfloorNum" data-options="required:true,validType:['alphabetfigure','length[1,20]']"></input></td>

						<td align="right">房间号：</td>
						<td ><input class="easyui-validatebox" type="text" id="hroomNum" name="hroomNum" data-options="required:true,validType:['xyz','length[1,20]']">
						</td>
					</tr>


					<tr>
						<td align="right">房屋结构：</td>
						<td ><input class="easyui-validatebox" type="text" id="hstructure" name="hstructure" ></input></td>

						<td align="right">产权性质：</td>
						<td ><input class="easyui-validatebox" type="text" id="hpropertyRight" name="hpropertyRight" ></input></td>
					</tr>
					

					<tr >
						<td align="right">安全状况：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="hsecurityStatus" name="hsecurityStatus" ></input></td>

						<td align="right">出租时间：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="rentalTime" name="rentalTime" ></input></td>
					</tr>
					
					<tr >
						<td align="right">出租面积：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="rentalArea" name="rentalArea" ></input></td>

						<td align="right">出租间数：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="rentalRoomNum" name="rentalRoomNum" ></input></td>
					</tr>
	

					<tr >
						<td align="right">出租日期：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="rentalRoomDate" name="rentalRoomDate"  ></input></td>

						<td align="right">警务负责区：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="policeOperateArea" name="policeOperateArea" ></input></td>
					</tr>
	
					<tr>
						<td align="right">委组：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="operateRow" name="operateRow" ></input></td>

						<td align="right">责任区民警编号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="chargePoliceNum" name="chargePoliceNum" ></input></td>
					</tr>	
					<tr>
						<td align="right">版本号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="hoversion" name="hoversion" ></input></td>
					</tr>
				</table>
				<div style="padding-top: 10px">
					<table align="center">
						<tr>
							<td><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchLayOutUrl()">户型图</a></td>
							<td><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchHouseUrls()">拍照</a></td>
						</tr>
					</table>
				</div>
	</div>
	--%>
	<input type="hidden" id="houseLayOutDiagramId"/>
	<input type="hideen" id="houseImageUrlsId"/>
	<div id="dlg" class="easyui-dialog" style="width:1100px; height:450px; padding: 0px;" closed="true" buttons="#dlg-buttons" data-options=" modal:true">
		
		<div class="easyui-layout" style="width:1090px;height:420px;">
		<div id="btnLa" data-options="region:'north'" style="height:46px;background:#fafafa;padding-top: 5px;">
			<%--<div id="tt" align="center">--%>
			<table align="center">
				<tr>
					<td>
					
					<span id="ownerDetail"> 
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="showDataDiv1()">人员基本信息</a>
						</span>
					
					<span id="houseBtn">
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchHouseInfo()">房屋基本信息</a>															
					</span>
						<span id="ownerHBtn"> 
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchPopulation(1)">房主信息</a>
						</span>
						
						<span id="familyMemsBtn"> 
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchPopulation(2)">家庭成员信息</a>					
						</span>
						
						<span id="photoBtn"> 
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchPhoto()">照片</a>
						</span>
					
					</td>
				</tr>
			</table>
		</div>
		<div data-options="region:'south'" style="height:46px;background:#fafafa;padding-top: 5px;">
			<table align="center">
				<tr>
					<td><a href="#" id ='fmconfirm'  class="easyui-linkbutton" iconCls="icon-ok" onclick="update()">确认</a></td>
					<td><a href="#" id ='fmcancel' class="easyui-linkbutton" iconCls="icon-cancel" onclick="d_close()">取消</a></td>
				</tr>
			</table>
		</div>
		<div data-options="region:'center'" style="background:#fafafa;padding-top:7px;" align="center">
			<div id='dataDiv1'>
			<form id="fm" method="post">
			<input type="hidden" value="" id="id" name = "id"/>
<!--		<input type="hidden" value="" id="hId" name = "hId"/>-->
<!--		<input type="hidden" value="" id="imgPersonUrl" name = "imgPersonUrl"/>-->
				<table data-options="region:',border:false,fit:true,fitColumns:false" cellspacing="5" >
						<tr>
							<td align="right">姓名：</td>
							<td ><input class="easyui-validatebox" type="text" id="namem"  name = "namem" ></input></td>
	
							<td align="right">曾用名：</td>
							<td ><input class="easyui-validatebox" type="text" id="oldNamem" name="oldNamem" >
							</td>
						
							<td align="right">性别：</td>
							<td ><input class="easyui-validatebox" type="text" id="sexm" name="sexm" ></td>
	
						</tr>
						<tr >
						
						   <td align="right">血型：</td>
						   <td align="right"><input class="easyui-validatebox" type="text" id="bloodTypem" name="bloodTypem" ></input></td>
						   
						   <td align="right">身高：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="heightm" name="heightm" ></input></td>
							
							<td align="right">民族：</td>
							<td ><input class="easyui-validatebox"  id="nationm" name="nationm" ></input></td>
						  
						</tr>															
						<tr >
						
						   <td align="right">出生日期：</td>
							<td ><input class="easyui-validatebox" type="text" id="birthdaym" name="birthdaym" ></input></td>
	
							<td align="right">身份证号：</td>
							<td ><input class="easyui-validatebox" type="text" id="certificateNumm" name="certificateNumm" ></input></td>
	
							<td align="right">文化程度：</td>
							<td ><input class="easyui-validatebox" type="text" id="degreeEducationm" name="degreeEducationm" ></input></td>
						   </tr>
	
						<tr >
							<td align="right">婚姻状况：</td>
						    <td ><input class="easyui-validatebox" type="text" id="maritalStam" name="maritalStam" ></input></td>
							
							<td align="right">兵役状况：</td>
						    <td ><input class="easyui-validatebox" type="text" id="militaryStam" name="militaryStam" ></input></td>
							
							<td align="right">人口性质：</td>
							<td ><input class="easyui-validatebox" type="text" id="personTypem" name="personTypem" ></input></td>
								
						</tr>
						 										
						<tr>
						 
						    <td align="right">成员关系：</td>
							<td ><input class="easyui-validatebox" type="text" id="relationm" name="relationm" ></input></td>
						
						
							<td align="right">暂住编码：</td>
							<td ><input class="easyui-validatebox" type="text" id="tempLiveNom" name="tempLiveNom" ></input></td>
	
							<td align="right">暂住日期：</td>
							<td ><input class="easyui-validatebox"  id="tempLiveDatem" name="tempLiveDatem" ></input></td>
						</tr>															
						 
						
						<tr >
							<td align="right">户籍详址：</td>
							<td  ><input class="easyui-validatebox" type="text" id="houseRegistm" name="houseRegistm"   ></input></td>
						
							<td align="right">职业：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="occupationm" name="occupationm" ></input></td>
	
							<td align="right">职务：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="postm" name="postm" ></input></td>
						</tr>
	
						<tr >
						  <td align="right">重点人口分类：</td>					
								<td ><input class="easyui-validatebox"  id="criminalm" name="criminalm" ></input></td>
							 
							
							<td align="right">实际住址：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="actualLiveAddrm" name="actualLiveAddrm"  ></input></td>
	
							<td align="right">固定电话：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="landLinem" name="landLinem" ></input></td>
						</tr>
						<tr>
						       <td align="right">手机：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="telephonem" name="telephonem" ></input></td>
	
							<td align="right">QQ：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="qqNumm" name="qqNumm" ></input></td>
						    
						    <td align="right">微信：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="weChatNumm" name="weChatNumm" ></input></td>
	 
						</tr>	
						<tr >
							
							<td align="right">服务住所：</td>
							<td  ><input class="easyui-validatebox" type="text" id="serviceAddrm" name="serviceAddrm"   ></input></td>
					 
					        <td align="right">租住时间：</td>
							<td align="right"><input class="easyui-validatebox"  id="tempLiveDatem1" name="tempLiveDatem1" ></input></td>
							<!-- id未定 -->
							<td align="right">到租时间：</td>
							<td align="right"><input class="easyui-validatebox"  id="prentalTimem" name="prentalTimem" ></input></td>
	
						</tr>
						<tr>
						
						    <td align="right">暂住事由：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="rentReasonm" name="rentReasonm" ></input></td>
						   <td align="right">居住时间：</td>
							<td align="right"><input class="easyui-validatebox" id="liveDatem" name="liveDatem" ></input></td>
	
						 </tr>
																								
				</table>
			</form>
			</div>
			<div id='dataDiv2'>
				<form id="fm2" method="post">
					<table data-options="region:',border:false,fit:true,fitColumns:false" cellspacing="5" >
						<tr>
								<td align="right">姓名：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnernamef"  name = "oWnernamef" ></input></td>
								
								<td align="right">曾用名：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWneroldNamef" name="oWneroldNamef" ></td>
								
								<td align="right">性别：</td>
								<td ><input class="easyui-validatebox"  id="oWnersexf" name="oWnersexf" ></input></td>
							</tr>
							
							<tr >							
								<td align="right">民族：</td>
								<td ><input class="easyui-validatebox"  id="oWnernationf" name="oWnernationf" ></input></td>
								
								<td align="right">身份证号：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnercertificateNumf" name="oWnercertificateNumf" ></input></td>
								
								<td align="right">出生日期：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnerbirthdayf" name="oWnerbirthdayf" ></input></td>
								</tr>	
																						
							<tr >
								<td align="right">文化程度：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnerdegreeEducationf" name="oWnerdegreeEducationf" ></input></td>
								
								<td align="right">婚姻状况：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnermaritalStaf" name="oWnermaritalStaf" ></input></td>
							
							    <td align="right">兵役状况：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnermilitaryStaf" name="oWnermilitaryStaf" ></input></td>
								
							</tr>
																
							<tr>	
								<td align="right">血型：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnerbloodTypef" name="oWnerbloodTypef" ></input></td>
								
								<td align="right">身高：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnerheightf" name="oWnerheightf" ></input></td>
							
								<td align="right">户籍详址：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnerhouseRegistf" name="oWnerhouseRegistf"   ></input></td>
							
							</tr>
							
							<tr > 
								<td align="right">服务处所：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnerserviceAddrf" name="oWnerserviceAddrf" ></input></td>
							
							    <td align="right">固定电话：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnerlandLinef" name="oWnerlandLinef" ></input></td>
								
								<td align="right">实际住址：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWneractualLiveAddrf" name="oWneractualLiveAddrf"  ></input></td>
							
							  </tr>	
							  	
							<tr >
						 
							    <td align="right">重点人口分类：</td>					
								<td ><input class="easyui-validatebox"  id="oWnercriminalf" name="oWnercriminalf" ></input></td>
							    
							    <td align="right">手机：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnertelephonef" name="oWnertelephonef" ></input></td>
								
								<td align="right">QQ：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnerqqNumf" name="oWnerqqNumf" ></input></td>
							</tr>
							<tr>			
								<td align="right">微信：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnerweChatNumf" name="oWnerweChatNumf" ></input></td>
								
								</tr>
						<%--<tr>	
							<td align="right">版本号：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="oWnerversion" name="oWnerversion"></input></td>
						</tr>																								
					--%></table>
				</form>
				<div id="imageUrlsDv1"></div>
			</div>
			<div id='dataDiv3' style="height:320px;">
				<div id="datagrid3"  ></div>
			</div>
			<div id='dataDiv4'>
				<form id="fm4" method="post">
					<table data-options="region:',border:false,fit:true,fitColumns:false" cellspacing="8" >
								<tr>
								    <td align="right">房屋名称：</td>
									<td ><input class="easyui-validatebox" type="text" id="hname" name="hname" data-options="required:true,validType:['xyz','length[1,20]']"></td>
								
									<td align="right">房栋号：</td>
									<td ><input class="easyui-validatebox" type="text" id="hbuildingNum"  name = "hbuildingNum" data-options="required:true,validType:['alphabetfigure','length[1,20]']"></input></td>
								</tr>
								
								<tr>
								   <td align="right">单元号：</td>
								   <td ><input class="easyui-validatebox" type="text" id="hunitNum" name="hunitNum" data-options="required:true,validType:['xyz','length[1,20]']"></td>
								   
								   <td align="right">房间号：</td>
								   <td ><input class="easyui-validatebox" type="text" id="hroomNum" name="hroomNum" data-options="required:true,validType:['xyz','length[1,20]']"></td>
							  </tr>
								
								<tr>
								   <td align="right">实际房址：</td>
									<td ><input class="easyui-validatebox" type="text" id="haddr"  name = "haddr" ></input></td>
									
									<td align="right">楼层：</td>
									<td ><input class="easyui-validatebox" type="text" id="hfloorNum"  name = "hfloorNum" data-options="required:true,validType:['alphabetfigure','length[1,20]']"></input></td>
								</tr>
								
								<tr>
								    <td align="right">房屋性质：</td>
									<td ><input class="easyui-validatebox" type="text" id="hstructure" name="hstructure" ></input></td>
								    
								    <td align="right">使用形式：</td>
									<td ><input class="easyui-validatebox" type="text" id="hpropertyRight" name="hpropertyRight" ></input></td>
								</tr>
								
								<tr >
									<td align="right">安全状况：</td>
									<td align="right"><input class="easyui-validatebox" type="text" id="hsecurityStatus" name="hsecurityStatus" ></input></td>
									
									<td align="right">出租面积：</td>
									<td align="right"><input class="easyui-validatebox" type="text" id="rentalArea" name="rentalArea" ></input></td>
									
								</tr>
								
								<tr >
								    <td align="right">出租间数：</td>
									<td align="right"><input class="easyui-validatebox" type="text" id="rentalRoomNum" name="rentalRoomNum" ></input></td>
								
								    <td align="right">出租日期：</td>
									<td align="right"><input class="easyui-validatebox" type="text" id="rentalRoomDate" name="rentalRoomDate" ></input></td>
								</tr>
								
								<tr >
								   <!-- id未定 -->
									<td align="right">到租日期：</td>
									<td align="right"><input class="easyui-validatebox" type="text" id="rentalTime" name="rentalTime"  ></input></td>
									
									<td align="right">租赁性质：</td>
									<td align="right"><input class="easyui-validatebox" type="text" id="rentType" name="rentType"  ></input></td>
								</tr>
								
								<tr>
								    <td align="right">警务责任区：</td>
									<td align="right"><input class="easyui-validatebox" type="text" id="policeOperateArea" name="policeOperateArea" ></input></td>
								
									<td align="right">委组：</td>
									<td align="right"><input class="easyui-validatebox" type="text" id="operateRow" name="operateRow" ></input></td>
								</tr>
								
								<tr>
								    <td align="right">责任区民警：</td>
									<td align="right"><input class="easyui-validatebox" type="text" id="chargePoliceNum" name="chargePoliceNum" ></input></td>
								
								</tr>	
					</table>
				</form>
				<div style="padding-top: 10px">
					<table align="center">
						<tr>
							<td><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchLayOutUrl()">房屋户型图</a></td>
							<td><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchHouseUrls()">房屋照片</a></td>
						</tr>
					</table>
				</div>
			</div>
			<div id='dataDiv5'>
				<div id="imageUrlsDv"></div>
			</div>
			<div id='dataDiv6'></div>
			
		</div>
		
		</div>
		
	</div>
	<div id="dlg6" class="easyui-dialog" title="家庭人员拍照"  style="width:800px;height:360px;padding:0px">
		<div id="imageUrlsDv2"></div>
	</div>
	<div id="dlg7" class="easyui-dialog" title="房屋拍照" style="width:800px;height:360px;padding:0px">
		<div id="imageUrlsDv4"></div>
	</div>
		<div id="dlg8" class="easyui-dialog" title="房屋户型图" style="width:800px;height:360px;padding:0px">
		<div id="imageUrlsDv5"></div>
	</div>
	<div id="dlgOpenImg" class="easyui-dialog" title="查看" closed="true"  style="width:700px;height:500px;padding:0px">
		<div id="imageOpenDIV"></div>
	</div>
</body>
</html>