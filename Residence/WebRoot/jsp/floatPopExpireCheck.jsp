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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/play.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/popwin.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/play.js"></script>

<title>家庭人员查询</title>

<script type="text/javascript">
	$(window).ready(function(){
		setFormReadOnly();
		getListPage();
		$('#dlg').dialog('close');
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
					url: "<%=request.getContextPath()%>/residentPopulationController/findFlowPopulationWillExpire.action",
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
						{field:'ptype',title:'人员类别',width:80,formatter:function(value, row, index){
																	if (value == "1") {
																		return "房主";
																	} else if (value == "2") {
																		return "家庭成员";
																	}
						}},																		
						{field:'name',title:'姓名',width:60},
						{field:'oldName',title:'曾姓名',width:60},

						{field:'sex',title:'性别',width:50},
						{field:'nation',title:'民族',width:50},
						{field:'certificateNum',title:'身份证号',width:120},
						{field:'personType',title:'人口性质',width:80},
						{field:'birthday',title:'出生日期',width:80},
						{field:'degreeEducation',title:'文化程度',width:80},						
						{field:'maritalSta',title:'婚姻状况',width:80},
						{field:'militarySta',title:'兵役状况',width:80},
						{field:'tempLiveNo',title:'暂住编码',width:80},
						{field:'relation',title:'成员关系',width:80},
						{field:'tempLiveDate',title:'暂住日期',width:80},
						{field:'bloodType',title:'血型',width:50},
						{field:'height',title:'身高',width:50},
						{field:'occupation',title:'职业',width:80},
						{field:'post',title:'职务',width:80},
						{field:'houseRegist',title:'户籍',width:80},
						{field:'serviceAddr',title:'服务处所',width:80},						
						{field:'landLine',title:'固定电话',width:80},
						{field:'telephone',title:'手机号码',width:80},
						{field:'actualLiveAddr',title:'实际住址',width:100},
						{field:'qqNum',title:'QQ',width:80},
						{field:'weChatNum',title:'微信',width:80},
						{field:'imgPersonUrl',title:'个人照片',hidden:true},
						{field:'rentalTime',title:'到期时间',width:80},
						{field:'rentReason',title:'暂住事由',width:80},
						{field:'liveDate',title:'居住时间',width:80}
						//{field:'version',title:'版本号',width:150},
					]],																								
				toolbar:[
//				{
//					id:'btnsave',
//					text:'修改',
//					disabled:false,
//					iconCls:'icon-edit',
//					handler:function(){
//						var row = $('#list').datagrid('getChecked');
//						if(row.length > 1){
//							$.messager.alert("操作提示","只能选择一条数据","info");
//						}else if(row.length == 0){
//							$.messager.alert("操作提示","请选择要修改的数据","info");
//						}else{
//						$('#id').val(row[0].id);
//							openDialog('修改信息','1');							
//						}
//					}
//				},
				{
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
				},
//				{
//					id:'btncut',
//					text:'删除',
//					iconCls:'icon-cut',
//					handler:function(){
//						var row = $('#list').datagrid('getChecked');
//						residentpopulationDel(row);
//					}
//				},
				{
					id:'btnCheck',
					text:'检查',
					disabled:false,
					iconCls:'icon-check',
					handler:function(){
						var row = $('#list').datagrid('getChecked');
						if(row.length == 0){
							$.messager.alert("操作提示","请选择要修改的数据","info");
						}else{
							var rows = $('#list').datagrid('getChecked');
							checkOperate(rows);							
						}
					}
				},
				{
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
	//检查信息
	function checkOperate(rows){
		if(rows != undefined && rows != ""){
			var count = rows.length;
			var rowsJsonStr = JSON.stringify(rows);
			$.messager.confirm('导出确认', '确定要修改当页的'+count+'条数据吗？', function(r){
				if (r){
					 $.ajax({
							type:'POST',
							url: "<%=request.getContextPath()%>/residentPopulationController/checkOperateModify.action?rowsJsonStr="+rowsJsonStr,
							dataType : "json",
							success : function(info) {
								if (info == 1) {
									$.messager.alert("操作提示","修改成功","info");
									$('#list').datagrid('reload');
								}else{
									$.messager.alert("操作提示","修改失败","info");
								}
							}
					});
				}
			});
		}
	}
	function searchPhoto(){
		$('#dlg1').dialog('open');
		personPhotoImages();
	}
	
	//打开Dialog层
	function openDialog(titleName,type){
		  $('#dlg').dialog('open').dialog('setTitle',titleName);
		  showDataDiv1(titleName,type);
	 }
	//初始化
	function showDataDiv0(titleName,diff){
	                setOpen($("#dataDiv0"));//默认显示第一个div
			  		var data =$('#list').datagrid('getChecked');
//		  			$('#id').val(data[0].id);		  			
//		  			$('#hId').val(data[0].hid);
		  			$('#pType0').combobox('setValue',data[0].ptype);			  					  			
					$('#name0').val(data[0].name);
					$('#oldName0').val(data[0].oldName);
					$('#sex0').combobox('setValue',data[0].sex);	
					$('#birthday0').datebox('setValue',data[0].birthday);				
					$('#nation0').val(data[0].nation);										
					$('#relation0').val(data[0].relation);										
					$('#certificateNum0').val(data[0].certificateNum);
					$('#degreeEducation0').val(data[0].degreeEducation);					
					$('#maritalSta0').combobox('setValue',data[0].maritalSta);
					$('#militarySta0').combobox('setValue',data[0].militarySta);
					$('#personType0').combobox('setValue',data[0].personType);																		
					$('#tempLiveNo0').val(data[0].tempLiveNo);
					$('#tempLiveDate0').datebox('setValue',data[0].tempLiveDate);					
					$('#bloodType0').combobox('setValue',data[0].bloodType);															
					$('#height0').val(data[0].height);
					$('#occupation0').val(data[0].occupation);
					$('#actualLiveAddr0').val(data[0].actualLiveAddr);										
					$('#post0').val(data[0].post);
					$('#houseRegist0').val(data[0].houseRegist);										
					$('#serviceAddr0').val(data[0].serviceAddr);																								
					$('#landLine0').val(data[0].landLine);										
					$('#telephone0').val(data[0].telephone);
					$('#qqNum0').val(data[0].qqNum);
					$('#weChatNum0').val(data[0].weChatNum);
					$('#imgPersonUrl0').val(data[0].imgPersonUrl);					
					$('#prentalTime0').datebox('setValue',data[0].rentalTime);
					$('#rentReason0').val(data[0].rentReason);
					$('#liveDate0').datebox('setValue',data[0].liveDate);
					$('#version0').val(data[0].version);
					if(diff=='1')
					{
						$("#btnLa").hide();
						setFormReadOnly();
					}else{
						$("#btnLa").show();
						setFormCanBeEdited();
					}
				/*	var str="<table align='center'><tr>";
					
					
					//if(data[0].ptype=='2'){
						str+="<td><a id='ownerHBtn' href='#' onclick='searchPopulation(1)'>此人所在房屋的房主</a></td>";
					//}
					str+="<td><a id='familyMemsBtn' href='#' onclick='searchPopulation(2)'>此人所在房屋的家庭成员</a></td>";
					str+="<td><a id='houseBtn' href='#' onclick='searchHouseInfo()'>此人所在的房屋信息</a></td>";
					str+="<td><a id='photoBtn' href='#' onclick='searchPhoto()'>此人的拍照</a></td></tr>";
					str+="</table>";
					$("#tt").html(str);
					*/
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
					//}
	}
	//第一个
	function showDataDiv1(titleName,diff){
	                setOpen($("#dataDiv1"));//默认显示第一个div
			  		var data =$('#list').datagrid('getChecked');
//		  			$('#id').val(data[0].id);		  			
//		  			$('#hId').val(data[0].hid);
		  			$('#zpType').val(data[0].ptype);			  					  			
					$('#zname').val(data[0].name);
					$('#zoldName').val(data[0].oldName);
					$('#zsex').val(data[0].sex);	
					$('#zbirthday').val(data[0].birthday);				
					$('#znation').val(data[0].nation);										
					$('#zrelation').val(data[0].relation);										
					$('#zcertificateNum').val(data[0].certificateNum);
					$('#zdegreeEducation').val(data[0].degreeEducation);					
					$('#zmaritalSta').val(data[0].maritalSta);
					$('#zmilitarySta').val(data[0].militarySta);
					$('#zpersonType').val(data[0].personType);																		
					$('#ztempLiveNo').val(data[0].tempLiveNo);
					$('#ztempLiveDate').val(data[0].tempLiveDate);					
					$('#zbloodType').val(data[0].bloodType);															
					$('#zheight').val(data[0].height);
					$('#zoccupation').val(data[0].occupation);
					$('#zactualLiveAddr').val(data[0].actualLiveAddr);										
					$('#zpost').val(data[0].post);
					$('#zhouseRegist').val(data[0].houseRegist);										
					$('#zserviceAddr').val(data[0].serviceAddr);																								
					$('#zlandLine').val(data[0].landLine);										
					$('#ztelephone').val(data[0].telephone);
					$('#zqqNum').val(data[0].qqNum);
					$('#zweChatNum').val(data[0].weChatNum);
					$('#zimgPersonUrl').val(data[0].imgPersonUrl);					
					$('#zptempLiveDate').val(data[0].tempLiveDate);
					$('#zrentReason').val(data[0].rentReason);
					$('#zliveDate').val(data[0].liveDate);
					if(diff=='1')
					{
						//$("#btnLa").hide();
						setFormReadOnly();
					}else{
						$("#btnLa").show();
						setFormCanBeEdited();
					}
				/*	var str="<table align='center'><tr>";
					
					
					//if(data[0].ptype=='2'){
						str+="<td><a id='ownerHBtn' href='#' onclick='searchPopulation(1)'>此人所在房屋的房主</a></td>";
					//}
					str+="<td><a id='familyMemsBtn' href='#' onclick='searchPopulation(2)'>此人所在房屋的家庭成员</a></td>";
					str+="<td><a id='houseBtn' href='#' onclick='searchHouseInfo()'>此人所在的房屋信息</a></td>";
					str+="<td><a id='photoBtn' href='#' onclick='searchPhoto()'>此人的拍照</a></td></tr>";
					str+="</table>";
					$("#tt").html(str);
					*/
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
					//}
	}
	//第二个和第三个
	function showDataDiv2(personType){
	   setOpen($("#dataDiv2"));//默认显示第一个div
	  var rows =$('#list').datagrid('getChecked');
		var hid=rows[0].hid;
		 $.ajax({
					type:'POST',
					url: "<%=request.getContextPath()%>/residentPopulationController/selectHousePopulation.action?hId="+hid+"&pType="+personType,
				dataType : "json",
					success:function(info){
						if(personType=='1'){
							var data =info;
							var pId=data[0].id;
							var photosImages=data[0].imgPersonUrl;
							$.ajax({
											type:'POST',
											url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+pId+"&source=202",
											dataType:'JSON',
											success:function(minfo){
												var mediaFiles=minfo;
											// _initRollImgs(mediaFiles,"lelimage");
												var imageUrlsStr="<table align='center'><tr>";
												for(var i=0;i<mediaFiles.length;i++){
													imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
												}
												imageUrlsStr+="</tr></table>";
												$("#imageUrlsDv2").html(imageUrlsStr);
							                  
							                  if(data[0].ptype=='1')
							{
								$('#pType').val('房主');	
							}else if(data[0].ptype=='2'){
								$('#pType').val('家庭人员');	
							}			  					  			
							$('#oWnername').val(data[0].name);
							$('#oWneroldName').val(data[0].oldName);
							$('#sex').val(data[0].sex);	
							$('#birthday').val(data[0].birthday);				
							$('#nation').val(data[0].nation);										
							$('#relation').val(data[0].relation);										
							$('#certificateNum').val(data[0].certificateNum);
							$('#degreeEducation').val(data[0].degreeEducation);	
							$('#maritalSta').val(data[0].maritalSta);	
							$('#militarySta').val(data[0].militarySta);					
							/*if(data[0].maritalSta=='0')
							{
								$('#maritalSta').val('未婚');
							}else if(data[0].maritalSta=='1')
							{
								$('#maritalSta').val('已婚');
							}else if(data[0].maritalSta=='2')
							{
								$('#maritalSta').val('离异');
							}
							if(data[0].militarySta=='0')
							{
								$('#militarySta').val('未服役');
							}else if(data[0].militarySta=='1')
							{
								$('#militarySta').val('正在服役');
							}else if(data[0].militarySta=='2')
							{
								$('#militarySta').val('服役已过');
							}*/
							$('#personType').val(data[0].personType);																		
							$('#tempLiveNo').val(data[0].tempLiveNo);
							$('#tempLiveDate').val(data[0].tempLiveDate);					
							$('#bloodType').val(data[0].bloodType);															
							$('#height').val(data[0].height);
							$('#occupation').val(data[0].occupation);
							$('#actualLiveAddr').val(data[0].actualLiveAddr);										
							$('#post').val(data[0].post);
							$('#houseRegist').val(data[0].houseRegist);										
							$('#serviceAddr').val(data[0].serviceAddr);																								
							$('#landLine').val(data[0].landLine);										
							$('#telephone').val(data[0].telephone);
							$('#qqNum').val(data[0].qqNum);
							$('#weChatNum').val(data[0].weChatNum);
							$('#imgPersonUrl').val(data[0].imgPersonUrl);					
							$('#rentDate').val(data[0].rentalTime);
							$('#rentReason').val(data[0].rentReason);
							$('#liveDate').val(data[0].liveDate);
							$('#owVersion').val(data[0].version);
							$('#criminal').val(data[0].criminal);
											}
										});
						}else{
						    setOpen($('#dataDiv3'));
							$('#houseFamilyGrounp').datagrid({   
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
									/*{field:'ptype',title:'人员类别',width:80,formatter:function(value, row, index){
																				if (value == "1") {
																					return "房主";
																				} else if (value == "2") {
																					return "家庭成员";
																				}
									}},		*/																
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
									{field:'liveDate',title:'居住时间',width:80},
								]]   
							});
							//$('#dlg3').dialog('open');
						}	
					}
		});
	              
	}
	//第四个
	//查看住房信息
	function showDataDiv4(){
	  setOpen($('#dataDiv4'));
		var rows =$('#list').datagrid('getChecked');
		var hid=rows[0].hid;
		$.ajax({
					type:'POST',
					url: "<%=request.getContextPath()%>/houseController/getHouseInfoByHId.action?hId="+hid,
					dataType:'json',
					success:function(info){
						$('#dlg4').dialog('open');
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
						$('#rentType').val(data[0].rentType);
						$('#rentalArea').val(data[0].rentalArea);
						$('#rentalRoomNum').val(data[0].rentalRoomNum);					
						$('#rentalRoomDate').val(data[0].rentalRoomDate);
						$('#policeOperateArea').val(data[0].policeOperateArea);
						$('#operateRow').val(data[0].operateRow);
						$('#chargePoliceNum').val(data[0].chargePoliceNum);								
						$('#hoversion').val(data[0].version);
						$('#houseImageUrlsId').val(data[0].hid);
						$('#houseLayOutDiagramId').val(data[0].layoutDiagramUrl);
					}
		});
	}
		//第五个
	function showDataDiv5()
	{
	setOpen($('#dataDiv5'));
		var rows = $('#list').datagrid('getChecked');
		var photosImages=rows[0].imgPersonUrl;
		$('#dlg5').dialog('open');
		$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+rows[0].id+"&source=''",
						dataType:'JSON',
						success:function(info){
							var mediaFiles=info;
							
							/*var imageUrlsStr="<table align='center'><tr>";
							for(var i=0;i<mediaFiles.length;i++){
								imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
							}
							imageUrlsStr+="</tr></table>";
								$("#imageUrlsDv").html(imageUrlsStr);*/
						
							_initRollImgs(mediaFiles,"imageUrlsDv51");
						}
		});
	}
	//打开Dialog层
	/*function openDialog(titleName,diff){
		  $('#dlg').dialog('open').dialog('setTitle',titleName);
		  		var data =$('#list').datagrid('getChecked');
//		  			$('#id').val(data[0].id);		  			
//		  			$('#hId').val(data[0].hid);
		  			$('#pType').combobox('setValue',data[0].ptype);			  					  			
					$('#name').val(data[0].name);
					$('#oldName').val(data[0].oldName);
					$('#sex').combobox('setValue',data[0].sex);	
					$('#birthday').datebox('setValue',data[0].birthday);				
					$('#nation').val(data[0].nation);										
					$('#relation').val(data[0].relation);										
					$('#certificateNum').val(data[0].certificateNum);
					$('#degreeEducation').val(data[0].degreeEducation);					
					$('#maritalSta').combobox('setValue',data[0].maritalSta);
					$('#militarySta').combobox('setValue',data[0].militarySta);
					$('#personType').combobox('setValue',data[0].personType);																		
					$('#tempLiveNo').val(data[0].tempLiveNo);
					$('#tempLiveDate').datebox('setValue',data[0].tempLiveDate);					
					$('#bloodType').combobox('setValue',data[0].bloodType);															
					$('#height').val(data[0].height);
					$('#occupation').val(data[0].occupation);
					$('#actualLiveAddr').val(data[0].actualLiveAddr);										
					$('#post').val(data[0].post);
					$('#houseRegist').val(data[0].houseRegist);										
					$('#serviceAddr').val(data[0].serviceAddr);																								
					$('#landLine').val(data[0].landLine);										
					$('#telephone').val(data[0].telephone);
					$('#qqNum').val(data[0].qqNum);
					$('#weChatNum').val(data[0].weChatNum);
					$('#imgPersonUrl').val(data[0].imgPersonUrl);					
					$('#prentalTime').datebox('setValue',data[0].rentalTime);
					$('#rentReason').val(data[0].rentReason);
					$('#liveDate').datebox('setValue',data[0].liveDate);
					$('#version').val(data[0].version);
					if(diff=='1')
					{
						$("#btnLa").hide();
						setFormReadOnly();
					}else{
						$("#btnLa").show();
						setFormCanBeEdited();
					}
					var str="<table align='center'><tr>";
					
					
					//if(data[0].ptype=='2'){
						str+="<td><a id='ownerHBtn' href='#' onclick='searchPopulation(1)'>此人所在房屋的房主</a></td>";
					//}
					str+="<td><a id='familyMemsBtn' href='#' onclick='searchPopulation(2)'>此人所在房屋的家庭成员</a></td>";
					str+="<td><a id='houseBtn' href='#' onclick='searchHouseInfo()'>此人所在的房屋信息</a></td>";
					str+="<td><a id='photoBtn' href='#' onclick='searchPhoto()'>此人的拍照</a></td>";
					str+="</tr></table>";
					$("#tt").html(str);
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
					//}
	}*/
	//拍照
	function personPhotoImages()
	{
		var rows = $('#list').datagrid('getChecked');
		var photosImages=rows[0].imgPersonUrl;
		$('#dlg5').dialog('open');
		$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+rows[0].id+"&source=''",
						dataType:'JSON',
						success:function(info){
							var mediaFiles=info;
							
							var imageUrlsStr="<table align='center'><tr>";
							for(var i=0;i<mediaFiles.length;i++){
								imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
							}
							imageUrlsStr+="</tr></table>";
							$("#imageUrlsDv").html(imageUrlsStr);
						}
		});
	}
	//关闭dialog层
	function d_close(){
			$('#dlg').dialog('close');
	}
	//查询   
	function searchData(){
		var sname = $('#sname').val();
		var scertificateNum = $('#scertificateNum').val();
		var hName = $('#hName').val();
		var hBuildingNum = $('#hBuildingNum').val();
		var hUnitNum = $('#hUnitNum').val();	
		var hRoomNumber = $('#hRoomNumber').val();			
		var stelephone = $('#stelephone').val();
/*		alert("sname"+sname)
				alert("scertificateNum"+scertificateNum)
						alert("hName"+hName)
								alert("hBuildingNum"+hBuildingNum)				
										alert("hRoomNumber"+hRoomNumber)
												alert("stelephone"+stelephone)*/
		var url = "<%=request.getContextPath()%>/residentPopulationController/getResidentPopulationQuery.action?sname="+sname+"&scertificateNum="+scertificateNum+"&hName="+hName+"&hBuildingNum="+hBuildingNum+"&hUnitNum="+hUnitNum+"&hRoomNumber="+hRoomNumber+"&stelephone="+stelephone;		
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
							var data =info;
							var pId=data[0].id;
							var photosImages=data[0].imgPersonUrl;
							$.ajax({
											type:'POST',
											url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+pId+"&source=202",
											dataType:'JSON',
											success:function(minfo){
												var mediaFiles=minfo;
												
												var imageUrlsStr="<table align='center'><tr>";
												for(var i=0;i<mediaFiles.length;i++){
													imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
												}
												imageUrlsStr+="</tr></table>";
												$("#imageUrlsDv1").html(imageUrlsStr);
							
												$('#dlg2').dialog('open');
												if(data[0].ptype=='1'){
												  $('#oWnerpType').val('房主');
												}else{
													 $('#oWnerpType').val('家庭成员');
												}		  					  					  			
												$('#oWnername').val(data[0].name);
												$('#oWneroldName').val(data[0].oldName);
												if(data[0].sex=='0')
												{
													$('#oWnersex').val('男');
												}else if(data[0].maritalSta=='1')
												{
													$('#oWnersex').val('女');
												}	
												$('#oWnerbirthday').val(data[0].birthday);				
												$('#oWnernation').val(data[0].nation);										
												$('#oWnerrelation').val(data[0].relation);										
												$('#oWnercertificateNum').val(data[0].certificateNum);
												$('#oWnerdegreeEducation').val(data[0].degreeEducation);					
												if(data[0].maritalSta=='0')
												{
													$('#oWnermaritalSta').val('未婚');
												}else if(data[0].maritalSta=='1')
												{
													$('#oWnermaritalSta').val('已婚');
												}else if(data[0].maritalSta=='2')
												{
													$('#oWnermaritalSta').val('离异');
												}
												if(data[0].militarySta=='0')
												{
													$('#oWnermilitarySta').val('未服役');
												}else if(data[0].militarySta=='1')
												{
													$('#oWnermilitarySta').val('正在服役');
												}else if(data[0].militarySta=='2')
												{
													$('#oWnermilitarySta').val('服役已过');
												}
												$('#oWnerpersonType').val(data[0].personType);																		
												$('#oWnertempLiveNo').val(data[0].tempLiveNo);
												$('#oWnertempLiveDate').val(data[0].tempLiveDate);					
												$('#oWnerbloodType').val(data[0].bloodType);															
												$('#oWnerheight').val(data[0].height);
												$('#oWneroccupation').val(data[0].occupation);
												$('#oWneractualLiveAddr').val(data[0].actualLiveAddr);										
												$('#oWnerpost').val(data[0].post);
												$('#oWnerhouseRegist').val(data[0].houseRegist);										
												$('#oWnerserviceAddr').val(data[0].serviceAddr);																								
												$('#oWnerlandLine').val(data[0].landLine);										
												$('#oWnertelephone').val(data[0].telephone);
												$('#oWnerqqNum').val(data[0].qqNum);
												$('#oWnerweChatNum').val(data[0].weChatNum);
												$('#oWnerimgPersonUrl').val(data[0].imgPersonUrl);					
												$('#oWnerrentDate').val(data[0].rentalTime);
												$('#oWnerrentReason').val(data[0].rentReason);
												$('#oWnerliveDate').val(data[0].liveDate);
												$('#oWnerversion').val(data[0].version);
											}
										});
						}else{
							$('#dg').datagrid({   
							    data:info,   
							   columns:[[
							        {field:'id',title:'拍照',width:45,align:'center',formatter:function(value, row, index){
										return "<a href='#' onclick='housePersonImage(\""+value+"\")'>查看</a>";
									}},
									{field:'ptype',title:'人员类别',width:150,formatter:function(value, row, index){
																				if (value == "1") {
																					return "房主";
																				} else if (value == "2") {
																					return "家庭成员";
																				}
									}},																		
									{field:'name',title:'姓名',width:150},
									{field:'oldName',title:'曾姓名',width:150},
			
									{field:'sex',title:'性别',width:150},
									{field:'nation',title:'民族',width:150},
									{field:'certificateNum',title:'身份证号',width:150},
									{field:'personType',title:'人口性质',width:150},
									{field:'birthday',title:'出生日期',width:150},
									{field:'degreeEducation',title:'文化程度',width:150},						
									{field:'maritalSta',title:'婚姻状况',width:150,formatter:function(value, row, index){
																				if (value == "0") {
																					return "未婚";
																				} else if (value == "1") {
																					return "已婚";
																				}else{
																				return "离异"
																				}
									}},
									{field:'militarySta',title:'兵役状况',width:150,formatter:function(value, row, index){
																				if (value == "0") {
																					return "未服";
																				} else if (value == "1") {
																					return "正在服";
																				}else{
																				return "服役已过"
																				}
									}},
									{field:'tempLiveNo',title:'暂住编码',width:150},
									{field:'relation',title:'成员关系',width:150},
									{field:'tempLiveDate',title:'暂住日期',width:150},
									{field:'bloodType',title:'血型',width:150},
									{field:'height',title:'身高',width:150},
									{field:'occupation',title:'职业',width:150},
									{field:'post',title:'职务',width:150},
									{field:'houseRegist',title:'户籍',width:150},
									{field:'serviceAddr',title:'服务处所',width:150},						
									{field:'landLine',title:'固定电话',width:150},
									{field:'telephone',title:'手机号码',width:150},
									{field:'actualLiveAddr',title:'现居住地址',width:150},
									{field:'qqNum',title:'QQ',width:150},
									{field:'weChatNum',title:'微信',width:150},
									{field:'imgPersonUrl',title:'个人照片',hidden:true},
									{field:'tempLiveDate ',title:'租住时间',width:150},
									{field:'rentReason',title:'暂住事由',width:150},
									{field:'liveDate',title:'居住时间',width:150}
								//	{field:'version',title:'版本号',width:150},
								]]   
							});
							$('#dlg3').dialog('open');
						}	
					}
		});
	}
	//查看住房信息
	function searchHouseInfo(){
		var rows =$('#list').datagrid('getChecked');
		var hid=rows[0].hid;
		$.ajax({
					type:'POST',
					url: "<%=request.getContextPath()%>/houseController/getHouseInfoByHId.action?hId="+hid,
					dataType:'json',
					success:function(info){
						$('#dlg4').dialog('open');
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
												
											/*	var imageUrlsStr="<table align='center'><tr>";
												for(var i=0;i<mediaFiles.length;i++){
													imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
												}
												imageUrlsStr+="</tr></table>";
												$("#imageUrlsDv2").html(imageUrlsStr);*/
												_initRollImgs(mediaFiles,"imageUrlsDv22");
												
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
<!-- 	  		<div id="choose" data-options="region:'north'" style="height:50px;background-color:#F5F5F5">
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
<!--					<span>手机号码:
						<input class="easyui-validatebox" type="text" style="width:130px;"  id="stelephone" name="stelephone"/></span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchData()">查询</a>		
				</div>
	  		</div>  		
 -->	
   		
			<div id="show"  data-options="region:'center'">
				<div id="list" class="easyui-datagrid" ></div>
			</div>
	</div>
	<!--   
	<div id="dlg1" class="easyui-dialog" title="头像" data-options="iconCls:'icon-save',modal:true" style="width:500px;height:300px;padding:10px">
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
						<td colspan="3"><input class="easyui-validatebox" type="text" id="oWnerhouseRegist" name="oWnerhouseRegist" style="width:650px;" ></input></td>
					</tr>

					<tr >
						<td align="right">服务处所：</td>
						<td colspan="3"><input class="easyui-validatebox" type="text" id="oWnerserviceAddr" name="oWnerserviceAddr" style="width:650px;" ></input></td>
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

						<%--<td align="right">版本号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="oWnerversion" name="oWnerversion"></input></td>
					--%></tr>																								
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
					<!-- <tr>
						<td align="right">版本号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="hoversion" name="hoversion" ></input></td>
					</tr> -->
				 
	</div>
	  -->
		
		
		
		
		
	<!-- 现在使用的页面代码 -->
	<div id="dlg" class="easyui-dialog" style="width:1100px; height: 450px; padding: 0px;" closed="true" buttons="#dlg-buttons" data-options=" modal:true">
		<form id="fm" method="post">
		<div class="easyui-layout" style="width:1090px;height:420px;">
		<div id="btnLa" data-options="region:'north'" style="height:60px;background:#fafafa;padding-top: 5px;">
			<div id="tt" align="center"></div>
				<div id="btnDIv" data-options="region:'north'" style="height:40px;background:#fafafa;padding-top: 10px;">
					<table align="center">
						<tr>
							<td>
								<div>
								      <a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="showDataDiv1('详细信息',1)">流动人口信息</a>
										&nbsp;&nbsp;
										<a href="#" class="easyui-linkbutton"   data-options="iconCls:'icon-search'" onclick="showDataDiv4()">房屋基本信息</a>		
										&nbsp;&nbsp;
				                      <a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="showDataDiv2(1)">房主信息</a>
										&nbsp;&nbsp;
				                       <a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="showDataDiv2(2)">家庭成员信息</a>
										&nbsp;&nbsp;
									
										<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="showDataDiv5()">照片</a>		
										&nbsp;&nbsp;
												
									</div>
								</td>
							</tr>
					</table>
	           </div>
		</div>
		 <!--
		<div data-options="region:'south'" style="height:47px;background:#fafafa;padding-top: 5px;">
			<table align="center">
				<tr>
				     <td><a href="#" id ='fmconfirm' class="easyui-linkbutton" iconCls="icon-ok" onclick="update()">确认</a></td>
					<td><a href="#" id ='fmcancel' class="easyui-linkbutton" iconCls="icon-cancel" onclick="d_close()">取消</a></td>
				</tr>
			</table>
		</div>
		-->
		<div data-options="region:'center'" style="background:#fafafa;padding-top: 7px;" align="center">
		 	
		 	 
			
			<div id = 'dataDiv1'>
		        <input type="hidden" value="" id="id" name = "id"/>
<!--		<input type="hidden" value="" id="hId" name = "hId"/>-->
<!--		<input type="hidden" value="" id="imgPersonUrl" name = "imgPersonUrl"/>-->
			  <table data-options="region:',border:false,fit:true,fitColumns:false" cellspacing="5" >
					 	<tr style="height:25px;">
						<td align="right">姓名：</td>
						<td ><input class="easyui-validatebox" type="text" id="zname"  name = "zname" ></input></td>

						 <td align="right">曾用名：</td>
						<td ><input class="easyui-validatebox" type="text" id="zoldName" name="zoldName" ></td>
					 
						<td align="right">性别：</td>
						<td ><input class="easyui-validatebox" type="text" id="zsex" name="zsex" ></td>
							
					</tr>
					<tr  style="height:25px;">
						
					  <td align="right">出生日期：</td>
						<td ><input class="easyui-validatebox" type="text" id="zbirthday" name="zbirthday" ></input></td>
					
					   <td align="right">身份证号：</td>
						<td ><input class="easyui-validatebox" type="text" id="zcertificateNum" name="zcertificateNum" ></input></td>
						
						<td align="right">民族：</td>
						<td ><input class="easyui-validatebox"  id="znation" name="znation" ></input></td>
						
					
					</tr>
					
					<tr>
					
						 <td align="right">血型：</td>
						 <td ><input class="easyui-validatebox" type="text" id="zbloodType" name="zbloodType" ></input></td>
					
						 <td align="right">身高：</td>
						<td ><input class="easyui-validatebox" type="text" id="zheight" name="zheight" ></input></td>
					
					
						<td align="right">实际住址：</td>
						<td ><input class="easyui-validatebox" type="text" id="zactualLiveAddr" name="zactualLiveAddr"  ></input></td>
				    
				    </tr>
				 
					 <tr  style="height:25px;">
					 
					 <td align="right">文化程度：</td>
					 <td ><input class="easyui-validatebox" type="text" id="zdegreeEducation" name="zdegreeEducation" ></input></td>
					 
					  
					 <td align="right">婚姻状况：</td>
					 <td ><input class="easyui-validatebox" type="text" id="zmaritalSta" name="zmaritalSta"  ></input></td>
				     
				    
					 <td align="right">兵役状况：</td>
					     <td ><input class="easyui-validatebox" type="text" id="zmilitarySta" name="zmilitarySta" ></input></td>
				     </tr>	
					
					<tr style="height:25px;">
						<td align="right">户籍详址：</td>
						<td  ><input class="easyui-validatebox" type="text" id="zhouseRegist" name="zhouseRegist"   ></input></td>
					
					   
						<td align="right">职业：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="zoccupation" name="zoccupation" ></input></td>
                       
						<td align="right">职务：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="zpost" name="zpost" ></input></td>
					
					</tr>									
				     <tr  style="height:25px;">
						<td align="right">人口性质：</td>
						 <td ><input class="easyui-validatebox" type="text" id="zpersonType" name="zpersonType" ></input></td>
				      
				        <td align="right">成员关系：</td>
						<td ><input class="easyui-validatebox" type="text" id="zrelation" name="zrelation" ></input></td>
					
						<td align="center">服务住所：</td>
						<td  ><input class="easyui-validatebox" type="text" id="zserviceAddr" name="zserviceAddr"  ></input></td>
					
						</tr>	
				 
					<tr  style="height:25px;">
				 
					     <td align="right">暂住编码：</td>
						<td ><input class="easyui-validatebox" type="text" id="ztempLiveNo" name="ztempLiveNo" ></input></td>

						<td align="right">暂住日期：</td>
						<td ><input class="easyui-validatebox"  id="ztempLiveDate" name="ztempLiveDate" ></input></td>
						
						<td align="right">固定电话：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="zlandLine" name="zlandLine" ></input></td>
					
					</tr>															
					
					<tr style="height:25px;">
						<td align="right">手机：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="ztelephone" name="ztelephone" ></input></td>

						<td align="right">QQ：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="zqqNum" name="zqqNum" ></input></td>
					    
					    <td align="right">微信：</td>
						<td ><input class="easyui-validatebox" type="text" id="zweChatNum" name="zweChatNum" ></input></td>
					
					</tr>	
				    
				    <tr style="height:25px;">
						<td align="right">租住时间：</td>
						<td align="right"><input class="easyui-validatebox"  id="zptempLiveDate" name="zptempLiveDate" ></input></td>

                        <td align="right">居住时间：</td>
						<td align="right"><input class="easyui-validatebox" id="zliveDate" name="zliveDate" ></input></td>

						<td align="right">暂住事由：</td>
						<td ><input class="easyui-validatebox" type="text" id="zrentReason" name="zrentReason" ></input></td>
					</tr>																
				</table>
			</div>
		    
			
			<div id='dataDiv2' style="height:340px;" >
			  <table data-options="region:',border:false,fit:true,fitColumns:false" cellspacing="5" >
			
			  <tr>
								<td align="right">姓名：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWnername"  name = "oWnername" ></input></td>
								
								<td align="right">曾用名：</td>
								<td ><input class="easyui-validatebox" type="text" id="oWneroldName" name="oWneroldName" ></td>
								
								<td align="right">性别：</td>
								<td ><input class="easyui-validatebox"  id="sex" name="sex" ></input></td>
							</tr>
							
							<tr >							
								<td align="right">民族：</td>
								<td ><input class="easyui-validatebox"  id="nation" name="nation" ></input></td>
								
								<td align="right">身份证号：</td>
								<td ><input class="easyui-validatebox" type="text" id="certificateNum" name="certificateNum" ></input></td>
								
								<td align="right">出生日期：</td>
								<td ><input class="easyui-validatebox" type="text" id="birthday" name="birthday" ></input></td>
								</tr>	
																						
							<tr >
								<td align="right">文化程度：</td>
								<td ><input class="easyui-validatebox" type="text" id="degreeEducation" name="degreeEducation" ></input></td>
								
								<td align="right">婚姻状况：</td>
								<td ><input class="easyui-validatebox" type="text" id="maritalSta" name="maritalSta" ></input></td>
							
							    <td align="right">兵役状况：</td>
								<td ><input class="easyui-validatebox" type="text" id="militarySta" name="militarySta" ></input></td>
								
							</tr>
																
							<tr>	
								<td align="right">血型：</td>
								<td ><input class="easyui-validatebox" type="text" id="bloodType" name="bloodType" ></input></td>
								
								<td align="right">身高：</td>
								<td ><input class="easyui-validatebox" type="text" id="height" name="height" ></input></td>
							
								<td align="right">户籍详址：</td>
								<td ><input class="easyui-validatebox" type="text" id="houseRegist" name="houseRegist"   ></input></td>
							
							</tr>
							
							<tr > 
								<td align="right">服务住所：</td>
								<td ><input class="easyui-validatebox" type="text" id="serviceAddr" name="serviceAddr" ></input></td>
							
							    <td align="right">固定电话：</td>
								<td ><input class="easyui-validatebox" type="text" id="landLine" name="landLine" ></input></td>
								
								<td align="right">实际住址：</td>
								<td ><input class="easyui-validatebox" type="text" id="actualLiveAddr" name="actualLiveAddr"  ></input></td>
							
							  </tr>	
							  	
							<tr >
						 
							    <td align="right">重点人口分类：</td>					
								<td ><input class="easyui-validatebox"  id="criminal" name="criminal" ></input></td>
							    
							    <td align="right">手机：</td>
								<td ><input class="easyui-validatebox" type="text" id="telephone" name="telephone" ></input></td>
								
								<td align="right">QQ：</td>
								<td ><input class="easyui-validatebox" type="text" id="qqNum" name="qqNum" ></input></td>
							</tr>
							<tr>			
								<td align="right">微信：</td>
								<td ><input class="easyui-validatebox" type="text" id="weChatNum" name="weChatNum" ></input></td>
								
								</tr>
							
			  </table>
				<div style="padding-top: 5px">
					<div id="imageUrlsDv2"></div>
				 </div>
			 </div>
			
			
			
			
			
			
			
			<div id='dataDiv3' style="height:320px">
			   <!--  此人所在房屋家庭成员   -->
						<div id="houseFamilyGrounp" class="easyui-datagrid" ></div>
			</div>
			
			
			
			
			<div id='dataDiv4' >
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
				<div style="padding-top: 10px">
					<table align="center">
						<tr>
							<td><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchLayOutUrl()">户型图</a></td>
							<td><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchHouseUrls()">拍照</a></td>
						</tr>
					</table>
				</div>
			  
			</div>
			
			<div id='dataDiv5'>
			   <div id="imageUrlsDv51"></div>
			</div>
			
			
			
			</div>
		</div>
		</form>
	</div>
	<!--  
	<div id="dlg" class="easyui-dialog" style="width:800px; height: 550px; padding: 0px;" closed="true" buttons="#dlg-buttons" data-options=" modal:true">
		<form id="fm" method="post">
		<div class="easyui-layout" style="width:780px;height:590px;">
		<div id="btnLa" data-options="region:'north'" style="height:35px;background:#fafafa;padding-top: 5px;">
			<div id="tt" align="center"></div>
			
		</div>
		<div data-options="region:'south'" style="height:47px;background:#fafafa;padding-top: 5px;">
			<table align="center">
				<tr>
					<td><a href="#" id ='fmconfirm' class="easyui-linkbutton" iconCls="icon-ok" onclick="update()">确认</a></td>
					<td><a href="#" id ='fmcancel' class="easyui-linkbutton" iconCls="icon-cancel" onclick="d_close()">取消</a></td>
				</tr>
			</table>
		</div>
		
		<div data-options="region:'center'" style="background:#fafafa;overflow:hidden;padding-top: 20px;" align="center">
		<input type="hidden" value="" id="id" name = "id"/>
<!--		<input type="hidden" value="" id="hId" name = "hId"/>-->
<!--		<input type="hidden" value="" id="imgPersonUrl" name = "imgPersonUrl"/>-->
		<!--    <table data-options="region:',border:false,fit:true,fitColumns:false" cellspacing="5" >
					<tr style="height:25px;">
						<td align="right">姓名：</td>
						<td ><input class="easyui-validatebox" type="text" id="name"  name = "name" ></input></td>

						<td align="right">曾用名：</td>
						<td ><input class="easyui-validatebox" type="text" id="oldName" name="oldName" >
						</td>
					</tr>
					<tr style="height:25px;">
						<td align="right">性别：</td>
						<td ><select id="sex" name="sex" class="easyui-combobox"  >
												<option value="1">男</option>
												<option value="0">女</option>
										</select>
						</td>

						<td align="right">民族：</td>
						<td ><input class="easyui-validatebox"  id="nation" name="nation" ></input></td>
					</tr>
					<tr style="height:25px;">
						<td align="right">出生日期：</td>
						<td ><input class="easyui-datebox" type="text" id="birthday" name="birthday" ></input></td>

						<td align="right">成员关系：</td>
						<td ><input class="easyui-validatebox" type="text" id="relation" name="relation" ></input></td>
					</tr>															
					<tr style="height:25px;">
						<td align="right">身份证号：</td>
						<td ><input class="easyui-validatebox" type="text" id="certificateNum" name="certificateNum" ></input></td>

						<td align="right">文化程度：</td>
						<td ><input class="easyui-validatebox" type="text" id="degreeEducation" name="degreeEducation" ></input></td>
					</tr>

					<tr  style="height:25px;">
						<td align="right">婚姻状况：</td>
						<td align="right"><select id="maritalSta" name="maritalSta" class="easyui-combobox"  >
												<option value="0">未婚</option>
												<option value="1">已婚</option>
												<option value="2">离异</option>
										</select>
						</td>
					
						<td align="right">人口性质：</td>
						<td>
							<select id="personType" name="personType" class="easyui-combobox"  >
												<option value="流动人口">流动人口</option>
												<option value="实住人口">实住人口</option>
										</select>
						</td>
					</tr>	
					<tr style="height:25px;">
						<td align="right">兵役状况：</td>
						<td align="right"><select id="militarySta" name="militarySta" class="easyui-combobox"  >
												<option value="0">未服役</option>
												<option value="1">正在服役</option>
												<option value="2">服役已过</option>
										</select>
						</td>
					</tr>											
					<tr style="height:25px;">
						<td align="right">暂住编码：</td>
						<td ><input class="easyui-validatebox" type="text" id="tempLiveNo" name="tempLiveNo" ></input></td>

						<td align="right">暂住日期：</td>
						<td ><input class="easyui-datebox"  id="tempLiveDate" name="tempLiveDate" ></input></td>
					</tr>															
					<tr style="height:25px;">
						<td align="right">血型：</td>
						<td align="right"><select id="bloodType" name="bloodType" class="easyui-combobox"  >
												<option value="A">A</option>
												<option value="B">B</option>
												<option value="AB">AB</option>
												<option value="O">O</option>
										</select>
						</td>

						<td align="right">身高：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="height" name="height" ></input></td>
					</tr>
					
					<tr style="height:25px;">
						<td align="right">职业：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="occupation" name="occupation" ></input></td>

						<td align="right">职务：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="post" name="post" ></input></td>
					</tr>

					<tr style="height:25px;">
						<td align="right">户籍：</td>
						<td colspan="3"><input class="easyui-validatebox" type="text" id="houseRegist" name="houseRegist" style="width:650px;" ></input></td>
					</tr>

					<tr style="height:25px;">
						<td align="right">服务处所：</td>
						<td colspan="3"><input class="easyui-validatebox" type="text" id="serviceAddr" name="serviceAddr" style="width:650px;" ></input></td>
					</tr>	
					<tr style="height:25px;">
						<td align="right">现居住地址：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="actualLiveAddr" name="actualLiveAddr"  ></input></td>

						<td align="right">固定电话：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="landLine" name="landLine" ></input></td>
					</tr>
					<tr style="height:25px;">
						<td align="right">手机：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="telephone" name="telephone" ></input></td>

						<td align="right">QQ：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="qqNum" name="qqNum" ></input></td>
					</tr>	
					<tr style="height:25px;">
						<td align="right">微信号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="weChatNum" name="weChatNum" ></input></td>

						<td align="right">人员类别：</td>					
						<td align="right"><select id="pType" name="pType" class="easyui-combobox"  >
												<option value="1">房主</option>
												<option value="2">家庭成员</option>
												
										</select>
						</td>
					</tr>
					<tr style="height:25px;">
						<td align="right">租住时间：</td>
						<td align="right"><input class="easyui-datebox"  id="prentalTime" name="prentalTime" ></input></td>

						<td align="right">暂住事由：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="rentReason" name="rentReason" ></input></td>
					</tr>
					<tr style="height:25px;">
						<td align="right">居住时间：</td>
						<td align="right"><input class="easyui-datebox" id="liveDate" name="liveDate" ></input></td>

						<%--<td align="right">版本号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="version" name="version" ></input></td>
					--%></tr>																									
				</table>
				
			</div>
		</div>
		</form>
	</div>
	  -->
	<input type="hidden" id="houseLayOutDiagramId"/>
	<input type="hideen" id="houseImageUrlsId"/>
	<div id="dlg6" class="easyui-dialog" title="家庭人员拍照"  style="width:800px;height:360px;padding:0px">
		<div id="imageUrlsDv22"></div>
	</div>
	<div id="dlg7" class="easyui-dialog" title="房屋拍照"  style="width:800px;height:360px;padding:0px">
		<div id="imageUrlsDv4"></div>
	</div>
		<div id="dlg8" class="easyui-dialog" title="房屋户型图"  style="width:800px;height:360px;padding:0px">
		<div id="imageUrlsDv5"></div>
	</div>
	<div id="dlgOpenImg" class="easyui-dialog" title="查看" closed="true"  style="width:700px;height:500px;padding:0px">
		<div id="imageOpenDIV"></div>
	</div>
</body>
</html>