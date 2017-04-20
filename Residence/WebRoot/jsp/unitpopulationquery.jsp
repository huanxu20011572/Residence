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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/popwin.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/popwin.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/play.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/play.js"></script>

<title>单位人员查询</title>

<script type="text/javascript">
	$(window).ready(function(){
	 setFormReadOnly();
	getListPage();
	$("div[id$='Dlg'] input").attr("readonly","readonly");
	//$('#dlg1').dialog('close');
	$('#dlg5').dialog('close');
	$('#dlg6').dialog('close');
	});

	//查询方法，带分页
	function getListPage(){
				$('#list').datagrid({			
					url: "<%=request.getContextPath()%>/unitPopulationController/getListPage.action",
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
						{field:'uid',title:'uid',hidden:true},
						{field:'hbuildingNum',title:'房栋号',width:60},
						{field:'hunitNum',title:'单元号',width:60},
						{field:'hfloorNum',title:'楼层',width:50},
						{field:'roomNumber',title:'房间号',width:50},
						
						
						{field:'name',title:'姓名',width:60},
						//{field:'oldName',title:'曾姓名',width:60},
						//{field:'personType',title:'人口性质',width:80},
						{field:'birthday',title:'出生日期',width:80},
						{field:'sex',title:'性别',width:50},
						{field:'nation',title:'民族',width:50},
						{field:'certificateNum',title:'身份证号',width:120},
					/*	{field:'degreeEducation',title:'文化程度',width:80},
						{field:'maritalSta',title:'婚姻状况',width:80,formatter:function(value, row, index){
																	if (value == "0") {
																		return "未婚";
																	} else if (value == "1") {
																		return "已婚";
																	}else{
																	return "离异"
																	}
						}},
						{field:'militarySta',title:'兵役状况',width:80,formatter:function(value, row, index){
																	if (value == "0") {
																		return "未服";
																	} else if (value == "1") {
																		return "正在服";
																	}else{
																	return "服役已过"
																	}
						}},
						{field:'bloodType',title:'血型',width:50},
						{field:'height',title:'身高',width:50},
						{field:'rentDate',title:'出租日期',width:80},*/
						{field:'workDate',title:'从业日期',width:80},
						/*{field:'IdType',title:'户口类别',width:80,formatter:function(value, row, index){
																	if (value == "1") {
																		return "农村";
																	} else {
																		return "城镇";
																	}
						}},*/
						{field:'residenceId',title:'居住证号',width:80},
						//{field:'occupation',title:'职业',width:80},
						{field:'post',title:'职务',width:80},
						{field:'houseRegist',title:'户籍详址',width:80},
						{field:'serviceAddr',title:'服务住所',width:80},						
						{field:'landLine',title:'固定电话',width:80},
						{field:'actualLiveAddr',title:'实际住址',width:100},
						{field:'telephone',title:'手机',width:80},
						{field:'qqNum',title:'QQ',width:80},
						{field:'weChatNum',title:'微信',width:80},
						{field:'ptype',title:'人员类别',width:80,formatter:function(value, row, index){
																	if (value == "1") {
																		return "法人";
																	} else if (value == "2") {
																		return "员工";
																	} else {
																	return "房主";
																	}
						}}
						//{field:'imgPersonUrl',title:'个人照片',hidden:false},
						//{field:'version',title:'版本号',width:50}												
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
						$('#id').val(row[0].hid);
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
	//导出Word
	function exportWord(type){
		var rows = $('#list').datagrid('getChecked');
		var id="";
		if(rows[0].ptype=='3'){
			alert('此人是房主,导出法人和职工信息请去法人或者职工里面导!');
			return;
		}
		else if(rows[0].ptype!='1'){
			getUnitInfo("","2");
			id = legalRepresentId;
		} 
		else{
			id=rows[0].id;
		}
		$.ajax({
				type: "POST",
				url: "<%=request.getContextPath()%>/unitPopulationController/getLegalOrLandlordInfo.action?id="+id,
				async : false,
				dataType: "json",
				success: function(json){
					var fileName = "单位信息表";
					var newJson=[];
					newJson.push(json);
					var rowsJsonStr = JSON.stringify(newJson);
					$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/word/exportWord.action?fileName="+fileName+"&type="+type+"&rowsJsonStr="+rowsJsonStr,
						success:function(info){
							if(info=="0"){
								alert("文件生成失败！");
							}else{
			 					local("<%=basePath%>/word/downFile.action?type="+type);	
							}
						}
						
					});
				}
		});
	}
	//导出职工Word
	function exportEmploeeWord(type){
		var rows = $('#list').datagrid('getChecked');
		var id=rows[0].uid;
		if(rows[0].ptype=='3'){
			alert('此人是房主,导出法人和职工信息请去法人或者职工里面导!');
			return;
		}
		
		$.ajax({
				type: "POST",
				url: "<%=request.getContextPath()%>/unitPopulationController/getUnitPopulationInfo.action?uId="+id,
				async : false,
				dataType: "json",
				success: function(json){
					var fileName = "单位信息表";
					var rowsJsonStr = JSON.stringify(json);
					$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/word/exportWord.action?fileName="+fileName+"&type="+type+"&rowsJsonStr="+rowsJsonStr,
						success:function(info){
							if(info=="0"){
								alert("文件生成失败！");
							}else{
			 					local("<%=basePath%>/word/downFile.action?type="+type);	
							}
						}
						
					});
				}
		});
	}
	function local(url){
		window.location.href=url;
	}
	//修改
	function update(){
			  $.messager.confirm('修改确认', '確定要修改此数据吗？', function(r){
			if (r){
				var rest = $("#fm").serialize();
				 $.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/unitPopulationController/updataUnitPopulation.action",
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
							url: "<%=request.getContextPath()%>/unitPopulationController/unitPopulationDel.action",
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
			var fileName = "单位人员信息表";
			var type = "unit_p";
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

	function showDataDiv1(){
		setOpen($("#dataDiv1"));//默认显示第一个div
  		var data =$('#list').datagrid('getChecked');
//  		$('#id').val(data[0].id);
//  			$('#uId').val(data[0].uId);
  			$('#pTypeg').val(data[0].ptype);																				
  			//hBuildingNum
  			$('#hBuildingNumg').val(data[0].hbuildingNum);
  			$('#hUnitNumg').val(data[0].hunitNum);
  			$('#hFloorNumg').val(data[0].hfloorNum);
  			$('#roomNumberg').val(data[0].roomNumber);
			$('#nameg').val(data[0].name);
			$('#oldNameg').val(data[0].oldName);
			$('#birthdayg').val(data[0].birthday);					
			$('#sexg').val(data[0].sex);					
			$('#nationg').val(data[0].nation);
			$('#certificateNumg').val(data[0].certificateNum);
			$('#degreeEducationg').val(data[0].degreeEducation);					
			$('#maritalStag').val( data[0].maritalSta);
			$('#personTypeg').val( data[0].personType);
			$('#militaryStag').val( data[0].militarySta);
			$('#bloodTypeg').val( data[0].bloodType);															
			$('#heightg').val(data[0].height);
			$('#rentDateg').val(data[0].rentDate);
			$('#workDateg').val(data[0].workDate);
			$('#IdTypeg').val(data[0].IdType);
			$('#residenceIdg').val(data[0].residenceId);
			$('#occupationg').val(data[0].occupation);
			$('#actualLiveAddrg').val(data[0].actualLiveAddr);										
			$('#postg').val(data[0].post);
			$('#houseRegistg').val(data[0].houseRegist);										
			$('#serviceAddrg').val(data[0].serviceAddr);
			$('#landLineg').val(data[0].landLine);										
			$('#telephoneg').val(data[0].telephone);
			$('#qqNumg').val(data[0].qqNum);
			$('#weChatNumg').val(data[0].weChatNum);
			//$('#weChatNum').val(data[0].weChatNum);
//			$('#imgPersonUrl').val(data[0].imgPersonUrl);
			 
			if (data[0].ptype == "1") {
				//$("#legalOrInfo").hide();
				//$("#landlordInfo").show();
				//$("#unitpopulationInfo").hide();
			} else if (data[0].ptype == "2") {
				//$("#legalOrInfo").show();					
				//$("#unitpopulationInfo").show();
			} else {
				//$("#legalOrInfo").show();
				//$("#landlordInfo").hide();
				//$("#unitpopulationInfo").hide();
			}	
	}
	//打开Dialog层
	function openDialog(titleName,diff){
	/*	  if(diff=='1')
		  {
		  	$("#btnDiv").hide();
		//	setFormReadOnly();
		  }else{
		  	$("#btnDiv").show();
		//	setFormCanBeEdited();
		  }*/
		  $('#dlg').dialog('open').dialog('setTitle',titleName);
		 // showDataDiv1();
		getUnitInfo('单位信息','1')		
	}

	//关闭dialog层
	function d_close(){
			$('#dlg').dialog('close');
	}
	//头像信息
	function showPhotoInfo()
	{
		//$('#dlg1').dialog('open');
		setOpen($("#dataDiv4"));
		unitPhotoImages();
	}
	//此人的拍照
	function unitPhotoImages(){
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
							$("#imageUrlsDvu").html(imageUrlsStr);*/

							_initRollImgs(mediaFiles,"imageUrlsDvu");
						}
		});
	}	
	//获得单位信息
	function getUnitInfo(titleNam,info){
		if("1"==info){
			//$('#unitdlg').dialog('open').dialog('setTitle',titleNam);
			
			//$('#dataDiv5').html($('#unitdlg').html());
			setOpen($("#dataDiv5"));	
		}
		var data =$('#list').datagrid('getChecked');
		var uId = data[0].uid;	
			$.ajax({
				type: "POST",
				url: "<%=request.getContextPath()%>/unitController/getUnitIdById.action?uId="+uId,
				async : false,
				dataType: "json",
				success: function(json){
//		  			$('#id').val(data[0].id);		  			
		  			$('#uName').val(json.uname);
		  			$('#uAddr').val(json.uaddr);
					$('#uProperty').val(json.uproperty);
					$('#uOperateRange').val(json.uoperateRange);										
					$('#uOperateArea').val(json.uoperateArea);
					$('#rent').val(json.rent);										
					$('#LinkNumber').val(json.LinkNumber);																								
					$('#uCategory').val(json.ucategory);										
					$('#securityPersonId').val(json.securityPersonId);
					$('#uPersonNum').val(json.upersonNum);
					$('#uTelephone').val(json.utelephone);
					$('#bussinessNum').val(json.bussinessNum);					
					$('#regesistMoney').val(json.regesistMoney);
					$('#regesistTime').val(json.regesistTime);
					$('#regesistcloseTime').val(json.regesistTime);
					
					$('#openningTime').val(json.openningTime);
					$('#closeTime').val(json.closeTime);
					$('#orgNum').val(json.orgNum);
//					$('#legalRepresentId').val(data[0].legalRepresentId);
//					$('#landlordId').val(data[0].landlordId);										
//					$('#imageUrls').val(data[0].imageUrls);
//					$('#layoutDiagramUrl').val(data[0].layoutDiagramUrl);	
					legalRepresentId = 	json.legalRepresentId;
					landlordId = json.landlordId;							
					$('#uversion').val(json.version);	
					}
				});				
	}
	
	var legalRepresentId ;
	var landlordId ;
	// 房主信息
	function legalOrlandlordInfo(titleNam){
			getUnitInfo("","2");
		//	$('#legalOrlandlordInfoDlg').dialog('open').dialog('setTitle',titleNam);
		//	$('#dataDiv2').html($('#legalOrlandlordInfoDlg').html());
			setOpen($('#dataDiv2'));
			
			var data =$('#list').datagrid('getChecked');
			var id;
			if("此员工的法人信息"==titleNam){
				id = legalRepresentId;
				setOpen($('#dataDivCorporation1'));
			}else{//房主信息
				id = landlordId;
			}
			$.ajax({
				type: "POST",
				url: "<%=request.getContextPath()%>/unitPopulationController/getLegalOrLandlordInfo.action?id="+id,
				async : false,
				dataType: "json",
				success: function(json){
		 				//	$('#id').val(data[0].id);
//		  			$('#uId').val(data[0].uId);
					if("1"==json.ptype){//1 为法定代表人  2为单位员工 3为房主
						$('#pType1').val("法定代表人");									
					}else if("2"==json.ptype){
						$('#pType1').val("单位员工");					
					}else{
						$('#pType1').val("房主");					
					}
		  																							
		  			//hBuildingNum
		  			$('#hBuildingNum1').val(json.hbuildingNum);
		  			$('#hUnitNum1').val(json.hunitNum);
		  			$('#hFloorNum1').val(json.hfloorNum);
		  			$('#roomNumber1').val(json.roomNumber);
					$('#name1').val(json.name);
					$('#oldName1').val(json.oldName);
					$('#birthday1').val(json.birthday);
					if("1"==json.sex){
						$('#sex1').val("女");
					}else{
						$('#sex1').val("男");
					}					
					$('#nation1').val(json.nation);
					$('#certificateNum1').val(json.certificateNum);
					$('#degreeEducation1').val(json.degreeEducation);
				    $('#maritalSta1').val(json.maritalSta);
					$('#militarySta1').val(json.militarySta);	
					/*if("0"==json.maritalSta){
						$('#maritalSta').val("未婚");
					}else if("1"==json.maritalSta){
						$('#maritalSta').val("已婚");
					}else{
						$('#maritalSta').val("离异");					
					}*/								
					$('#personType1').val(json.personType);
					
					/*if("0"==json.maritalSta){
						$('#militarySta').val("未服");
					}else if("1"==json.maritalSta){
						$('#militarySta').val("正在服");
					}else{
						$('#militarySta').val("服起已过");					
					}*/
					$('#bloodType1').val(json.bloodType);															
					$('#height1').val(json.height);
					$('#rentDate1').val(json.rentDate);
					$('#workDate1').val(json.workDate);
					if("1"==json.IdType){//1 农村 2 城镇
						$('#IdType1').val("农村");
					}else{
						$('#IdType1').val("城镇");
					}
					
					$('#residenceId1').val(json.residenceId);
					$('#occupation1').val(json.occupation);
					$('#actualLiveAddr1').val(json.actualLiveAddr);										
					$('#post1').val(json.post);
					$('#houseRegist1').val(json.houseRegist);										
					$('#serviceAddr1').val(json.serviceAddr);
					$('#landLine1').val(json.landLine);										
					$('#telephone1').val(json.telephone);
					$('#qqNum1').val(json.qqNum);
					$('#weChatNum1').val(json.weChatNum);
					//$('#weChatNum').val(data[0].weChatNum);
//					$('#imgPersonUrl').val(data[0].imgPersonUrl);
					$('#pversion1').val(json.version);
					setImage(json.id);
					}
				});	
	}
	
	 		//法人信息窗口
	function legalRepresentOrlandlordInfo2(titleNa){
 
		 getUnitInfo("","2");
		//	$('#legalOrlandlordInfoDlg').dialog('open').dialog('setTitle',titleNam);
		//	$('#dataDiv2').html($('#legalOrlandlordInfoDlg').html());
			setOpen($('#dataDivCorporation1'));
			
			var data =$('#list').datagrid('getChecked');
			var id;
			if("法人信息"==titleNa){
				id = legalRepresentId;
			}else{//房主信息
				id = landlordId;
			}
			
			
			
			
			
			
			$.ajax({
				type: "POST",
				url: "<%=request.getContextPath()%>/unitPopulationController/getLegalOrLandlordOrUnitPopulationInfo.action?uId="+uId+"&id="+id,
				async : false,
				dataType: "json",
				success: function(json){
				//	$('#id').val(data[0].id);
//		  			$('#uId').val(data[0].uId);
					if("1"==json.ptype){//1 为法定代表人  2为单位员工 3为房主
						$('#copType1').val("法定代表人");									
					}else if("2"==json.ptype){
						$('#copType1').val("单位员工");					
					}else{
						$('#copType1').val("房主");					
					}
		  																							
		  			//hBuildingNum
		  			$('#cohBuildingNum1').val(json.hbuildingNum);
		  			$('#cohUnitNum1').val(json.hunitNum);
		  			$('#cohFloorNum1').val(json.hfloorNum);
		  			$('#coroomNumber1').val(json.roomNumber);
					$('#coname1').val(json.name);
					$('#cooldName1').val(json.oldName);
					$('#cobirthday1').val(json.birthday);
					if("1"==json.sex){
						$('#cosex1').val("女");
					}else{
						$('#cosex1').val("男");
					}					
					$('#conation1').val(json.nation);
					$('#cocertificateNum1').val(json.certificateNum);
					$('#codegreeEducation1').val(json.degreeEducation);	
				    $('#comaritalSta1').val(json.maritalSta);
					$('#comilitarySta1').val(json.militarySta);	
					$('#copersonType1').val(json.personType);
					$('#cobloodType1').val(json.bloodType);															
					$('#coheight1').val(json.height);
					$('#corentDate1').val(json.rentDate);
					$('#coworkDate1').val(json.workDate);
					/*if("1"==json.IdType){//1 农村 2 城镇
						$('#coIdType').val("农村");
					}else{
						$('#coIdType').val("城镇");
					}*/
					$('#coIdType1').val(json.IdType);
					$('#coresidenceId1').val(json.residenceId);
					$('#cooccupation1').val(json.occupation);
					$('#coactualLiveAddr1').val(json.actualLiveAddr);										
					$('#copost1').val(json.post);
					$('#cohouseRegist1').val(json.houseRegist);										
					$('#coserviceAddr1').val(json.serviceAddr);
					$('#colandLine1').val(json.landLine);										
					$('#cotelephone1').val(json.telephone);
					$('#coqqNum1').val(json.qqNum);
					$('#coweChatNum1').val(json.weChatNum);
					//$('#weChatNum').val(data[0].weChatNum);
//					$('#imgPersonUrl').val(data[0].imgPersonUrl);
					$('#copversion1').val(json.version);
					setImage1(json.id);
					}
				});
	}

	function setImage(imageid){
		$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+imageid+"&source=''",
						dataType:'JSON',
						success:function(info){
							var mediaFiles=info;
							
							/*var imageUrlsStr="<table align='center'><tr>";
							for(var i=0;i<mediaFiles.length;i++){
								imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
							}
							imageUrlsStr+="</tr></table>";
							$("#lelimage").html(imageUrlsStr);*/

							_initRollImgs(mediaFiles,"lelimage")
						}
		});
	}	
	

	function setImage1(imageid){
		$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+imageid+"&source=''",
						dataType:'JSON',
						success:function(info){
							var mediaFiles=info;
							
							/*var imageUrlsStr="<table align='center'><tr>";
							for(var i=0;i<mediaFiles.length;i++){
								imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
							}
							imageUrlsStr+="</tr></table>";
							$("#lelimage").html(imageUrlsStr);*/

							_initRollImgs(mediaFiles,"lelimage1")
						}
		});
	}	
	
	
	
	//同事信息
	function unitColleagueInfo(titleNam){
		var data =$('#list').datagrid('getChecked');	
		//$('#unitColleagueInfoDlg').dialog('open').dialog('setTitle',titleNam);
			setOpen($('#dataDiv3'));
		
				var id = data[0].id;
				var uId = data[0].uid;
				$('#unitColleagueInfoList').datagrid({					
					url: "<%=request.getContextPath()%>/unitPopulationController/getunitColleagueInfo.action?id="+id+"&uId="+uId,
					pagination:true,//是否分页			
					fitColumns: false,//
					singleSelect: false,//是否只能单选
					scrollbarSize: 0,
					rownumbers:true,//行号
					fit: true,
					nowrap: true,					
					onLoadSuccess:function(){
						dataCbProject = $('#unitColleagueInfoList').data('datagrid').data;
					},
					// hBuildingNum   hUnitNum  hFloorNum  roomNumber  birthday
					columns:[[
//						{field:'checkBox',checkbox:true},
						{field:'uid',title:'uid',hidden:true},
						{field:'id',title:'照片',width:45,align:'center',formatter:function(value, row, index){
							return "<a href='#' onclick='unitPersonImage(\""+value+"\")'>查看</a>";
						}},
					    //{field:'hbuildingNum',title:'房栋号',width:60},
						//{field:'hunitNum',title:'单元号',width:60},
						//{field:'hfloorNum',title:'楼层',width:50},
						//{field:'roomNumber',title:'房间号',width:50},
						
						
						{field:'name',title:'姓名',width:60},
						//{field:'personType',title:'人口性质',width:60},
						{field:'sex',title:'性别',width:50},
						//
						{field:'oldName',title:'曾用名',width:80},
						//{field:'birthday',title:'出生日期',width:80},
						{field:'nation',title:'民族',width:50},
						{field:'certificateNum',title:'身份证号',width:120},
						{field:'degreeEducation',title:'文化程度',width:80},
						/*{field:'maritalSta',title:'婚姻状况',width:60,formatter:function(value, row, index){
																	if (value == "0") {
																		return "未婚";
																	} else if (value == "1") {
																		return "已婚";
																	}else{
																	return "离异"
																	}
						}},*/
						{field:'maritalSta',title:'婚姻状况',width:60},
						{field:'militarySta',title:'兵役状况',width:80},
						{field:'bloodType',title:'血型',width:50},
						{field:'height',title:'身高',width:50},
						{field:'workDate',title:'从业日期',width:80},
						{field:'post',title:'职务',width:80},
						{field:'houseRegist',title:'户籍详址',width:80},
						{field:'birthday',title:'出生日期',width:80},
						{field:'landLine',title:'固定电话',width:80},
						{field:'telephone',title:'手机',width:80},
						{field:'weChatNum',title:'微信',width:80},
						{field:'qqNum',title:'QQ',width:80},
					    {field:'IdType',title:'户口类别',width:60}, 
						{field:'residenceId',title:'居住证号',width:60}
						//{field:'occupation',title:'职业',width:80},
						//{field:'rentDate',title:'出租日期',width:80},
						
						/*{field:'serviceAddr',title:'服务住所',width:80},						
						
						{field:'actualLiveAddr',title:'现居住地址',width:100},
						
						{field:'ptype',title:'人员类别',width:80,formatter:function(value, row, index){
																	if (value == "1") {
																		return "法人";
																	} else if (value == "2") {
																		return "员工";
																	} else {
																	return "房主";
																	}
						}},
//						{field:'imgPersonUrl',title:'个人照片',hidden:false},
						{field:'version',title:'版本号',width:50}*/												
					]],	
				onClickRow: function(rowIndex, rowData){
				}					
			});
	
	}
	
	
			//员工的拍照
	function unitPersonImage(vv){
		$('#upimageDlg').dialog('open');
		$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+vv+"&source=104",
						dataType:'JSON',
						success:function(info){
							var mediaFiles=info;
							
							/*var imageUrlsStr="<table align='center'><tr>";
							for(var i=0;i<mediaFiles.length;i++){
								imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
							}
							imageUrlsStr+="</tr></table>";
							$("#upimagediv").html(imageUrlsStr);*/
							_initRollImgs(mediaFiles,"upimagediv");
						}
		});
	}
	
	
		//查询
	function searchData(){
		var sname = $('#sname').val();
		//alert(sname)
		var scertificateNum = $('#scertificateNum').val();
		//alert(scertificateNum)
		var suName = $('#suName').val();
		//alert(suName)	
		var stelephone = $('#stelephone').val();
		//alert(stelephone)
//		var data = $("#fm1").serialize();
		var url = "<%=request.getContextPath()%>/unitPopulationController/getUnitPopulationQuery.action?sname="+sname+"&scertificateNum="+scertificateNum+"&suName"+suName+"&stelephone="+stelephone;
		$('#list').datagrid({url: url});
		$('#list').datagrid("reload");
	}	
	
		//单位户型图片
	function unitImage(titleNa){
			$('#unitImageDlg').dialog('open').dialog('setTitle',titleNa);
			var rows = $('#list').datagrid('getChecked');
			var layoutDiagramUrl=rows[0].layoutDiagramUrl;
			$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/unitController/findImages.action?imagesIds="+layoutDiagramUrl,
						dataType:'JSON',
						success:function(info){
							var mediaFiles=info;
							
							var imageUrlsStr="<table align='center'><tr>";
							for(var i=0;i<mediaFiles.length;i++){
								imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
							}
							imageUrlsStr+="</tr></table>";
							$("#unitImageDlg").html(imageUrlsStr);
						}
			});
			
			
	}
	///////////////
	
	//单位拍照
	function showUnitPhotoInfo(){
		var rows=$('#list').datagrid('getChecked');
		var uid=rows[0].uid;
		$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/unitController/getUnitIdById.action?uId="+uid,
						dataType:'JSON',
						success:function(msg){
							var data=msg;
							//alert(data.layoutDiagramUrl+"\t"+data.imageUrls);
							$.ajax({
											type:'POST',
											url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+uid+"&source=101",
											dataType:'JSON',
											success:function(info){
												$('#dlg6').dialog('open');
												var mediaFiles=info;
												
											/*	var imageUrlsStr="<table align='center'><tr>";
												for(var i=0;i<mediaFiles.length;i++){
													imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
												}
												imageUrlsStr+="</tr></table>";
												$("#imageUrlsDv2").html(imageUrlsStr);*/
												_initRollImgs(mediaFiles,"imageUrlsDv2");
											}
							});
						}
		});
	}
	//单位的户型图
	function showLayOutInfo(){
		var rows=$('#list').datagrid('getChecked');
		var uid=rows[0].uid;
		$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/unitController/getUnitIdById.action?uId="+uid,
						dataType:'JSON',
						success:function(msg){
							var data=msg;
							//alert(data.layoutDiagramUrl+"\t"+data.imageUrls);
							$.ajax({
											type:'POST',
											url: "<%=request.getContextPath()%>/unitController/findImages.action?imagesIds="+data.layoutDiagramUrl,
											dataType:'JSON',
											success:function(info){
												$('#dlg5').dialog('open');
												var mediaFiles=info;
												
												/*var imageUrlsStr="<table align='center'><tr>";
												for(var i=0;i<mediaFiles.length;i++){
													imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
												}
												imageUrlsStr+="</tr></table>";
												$("#imageUrlsDv1").html(imageUrlsStr);*/

												_initRollImgs(mediaFiles,"imageUrlsDv1")
											}
							});
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
<!--					<span>住址:-->
<!--						<input class="easyui-validatebox" type="text" style="width:130px;"  id="sactualLiveAddr" name="sactualLiveAddr" /></span>-->
<!--					<span>户籍:-->
<!--						<input class="easyui-validatebox" type="text" style="width:130px;"  id="shouseRegist" name="shouseRegist" /></span>-->
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
	
	
	
	
	
	
	
	<div id="dlg" class="easyui-dialog" style="width:1100px; height: 450px; padding: 0px;" closed="true" buttons="#dlg-buttons" data-options=" modal:true">
	
		<div class="easyui-layout" style="width:1090px;height:420px;">
		
		<div id="btnDiv" data-options="region:'north'" style="height:46px;background:#fafafa;padding-top: 5px;">
			<table align="center">
				<tr>
					<td>
					    <span id="unitInfo"> 
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="getUnitInfo('单位信息','1')">单位基本信息</a>
						</span> 
						
						<span id="landlordInfo"> 
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="legalOrlandlordInfo('房主信息')">房主信息</a>					
						</span>
						
						<span id="legalOrInfo"> 
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="legalRepresentOrlandlordInfo2('法人信息')">企业法人信息</a>
						</span>
						
						<span id="unitpopulationInfo">
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="unitColleagueInfo('同事信息')">企业职工信息</a>															
						</span>
						<!-- 
						<span id="personInfo"> 
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="showDataDiv1()">个人信息详情</a>
						</span>
						
						
						
						
						<span id="PhotoInfo"> 
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="showPhotoInfo()">照片</a>
						</span>	
						 -->
						<span id="DDPhotoInfo1"> 
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="exportWord('1')">导出法人信息</a>
						</span>
						<span id="DDPhotoInfo2"> 
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="exportEmploeeWord('2')">导出职工信息</a>
						</span>			
					
					</td>
				</tr>
			</table>
		</div>
		
		
		<div data-options="region:'south'" style="height:46px;background:#fafafa;padding-top: 10px;">
			<table align="center">
				<tr>
					<td><a href="#" id ='fmconfirm'  class="easyui-linkbutton" iconCls="icon-ok" onclick="update()">确认</a></td>
					<td><a href="#" id ='fmcancel'  class="easyui-linkbutton" iconCls="icon-cancel" onclick="d_close()">取消</a></td>
				</tr>
			</table>
		</div>
		
		
		<div data-options="region:'center'" style="background:#fafafa;padding-top: 5px;" align="center">
		<div id='dataDiv1'>
			<form id="fm" method="post">
				<input type="hidden" value="" id="id" name = "id"/>
	<!--		<input type="hidden" value="" id="uId" name = "uId"/>-->
	<!--		<input type="hidden" value="" id="imgPersonUrl" name = "imgPersonUrl"/> -->
				<table data-options="region:',border:false,fit:true,fitColumns:false" cellspacing="2" >
						<tr >
							<td align="right">房栋号：</td>
							<td ><input class="easyui-validatebox" type="text" id="hBuildingNumg"  name = "hBuildingNumg" ></input></td>
	
							<td align="right">单元号：</td>
							<td ><input class="easyui-validatebox" type="text" id="hUnitNumg" name="hUnitNumg" >
							</td>
						
							<td align="right">楼层：</td>
							<td ><input class="easyui-validatebox" type="text" id="hFloorNumg"  name = "hFloorNumg" ></input></td>
						</tr>
						
						<tr >
							<td align="right">房间号：</td>
							<td ><input class="easyui-validatebox" type="text" id="roomNumberg" name="roomNumberg" >
							</td>
							<td align="right">姓名：</td>
							<td ><input class="easyui-validatebox" type="text" id="nameg"  name = "nameg" ></input></td>
	                        
	                        <td align="right">出生日期：</td>
							<td ><input class="easyui-validatebox" type="text" id="birthdayg"  name = "birthdayg" ></input></td>
	
							<!-- <td align="right">曾用名：</td> 
							<td ><input class="easyui-validatebox" type="text" id="oldName" name="oldName" >
							</td> -->
						</tr >
	
						<tr >
							<td align="right">性别：</td>
							<td ><input class="easyui-validatebox" type="text" id="sexg" name="sexg" ></input></td>
	
							<td align="right">民族：</td>
							<td ><input class="easyui-validatebox" type="text" id="nationg" name="nationg" ></input></td>
						
							<td align="right">身份证号：</td>
							<td ><input class="easyui-validatebox" type="text" id="certificateNumg" name="certificateNumg" ></input></td>
						</tr>
	
					<!-- 	<tr >
							<td align="right">文化程度：</td>
							<td ><input class="easyui-validatebox" type="text" id="degreeEducation" name="degreeEducation" ></input></td>
							
							<td align="right">户口类别：</td>
							<td ><select id="IdType" name="IdType" class="easyui-combobox" style="width:173px;" >
													<option value="l">农村</option>
													<option value="2">城镇</option>
											</select>
							</td>
						</tr>
						<tr >
							<td align="right">人口性质：</td>
							<td>
								<select id="personType" name="personType" class="easyui-combobox" style="width:173px;" >
													<option value="流动人口">流动人口</option>
													<option value="实住人口">实住人口</option>
											</select>
							</td>
							<td align="right">婚姻状况：</td>
							<td ><select id="maritalSta" name="maritalSta" class="easyui-combobox" style="width:173px;" >
													<option value="0">未婚</option>
													<option value="1">已婚</option>
													<option value="2">离异</option>
											</select>
							</td>
	
							<td align="right">兵役状况：</td>
							<td ><select id="militarySta" name="militarySta" class="easyui-combobox" style="width:173px;" >
													<option value="0">未服役</option>
													<option value="1">正在服役</option>
													<option value="2">服役已过</option>
											</select>
							</td>
						</tr>	
						<tr >
							<td align="right">血型：</td>
							<td ><select id="bloodType" name="bloodType" class="easyui-combobox" style="width:173px;" >
													<option value="A">A</option>
													<option value="B">B</option>
													<option value="AB">AB</option>
													<option value="O">O</option>
											</select>
							</td>
	
							<td align="right">身高：</td>
							<td ><input class="easyui-validatebox" type="text" id="height" name="height" ></input></td>
					
							<td align="right">出租日期：</td>
							<td ><input class="easyui-validatebox" type="text" id="rentDate" name="rentDate" ></input></td>
						</tr>
	                           -->
						<tr >
							<td align="right">从业日期：</td>
							<td ><input class="easyui-validatebox" type="text" id="workDateg" name="workDateg" ></input></td>
							 
							 <td align="right">居住证号：</td>
							<td ><input class="easyui-validatebox" type="text" id="residenceIdg" name="residenceIdg" ></input></td>
	                        
	                        <td align="right">职务：</td>
							<td ><input class="easyui-validatebox" type="text" id="postg" name="postg" ></input></td>
						   
						</tr>
	
						<tr >
					 
						    <td align="right">户籍详址：</td>
							<td  ><input class="easyui-validatebox" type="text" id="houseRegistg" name="houseRegistg"  data-options="editable:false"></input></td>
							
							<td align="right">服务住所：</td>
							<td ><input class="easyui-validatebox" type="text" id="serviceAddrg" name="serviceAddrg"   ></input></td>
							
							
							<td align="right">固定电话：</td>
							<td ><input class="easyui-validatebox" type="text" id="landLineg" name="landLineg" ></input></td>
						
							</tr>
	
						<tr >
						  <td align="right">实际住址：</td>
							<td ><input class="easyui-validatebox" type="text" id="actualLiveAddrg" name="actualLiveAddrg" ></input></td>
	
	                        <td align="right">手机：</td>
							<td ><input class="easyui-validatebox" type="text" id="telephoneg" name="telephoneg" ></input></td>
						
							<td align="right">QQ：</td>
							<td ><input class="easyui-validatebox" type="text" id="qqNumg" name="qqNumg" ></input></td>
						</tr>
						<tr>
							<td align="right">微信：</td>
							<td ><input class="easyui-validatebox" type="text" id="weChatNumg" name="weChatNumg" ></input></td>
	
							 </tr>
	 
					</table>
					</form>
				</div>
				<div id='dataDiv2'>
					<form id="fm2" method="post">
						<div id="yuyiyiuy"  >
							<input type="hidden" value="" id="id" name = "id"/>
							<table data-options="region:',border:false,fit:true,fitColumns:false"  cellspacing="2" >
							 <tr>
										<td align="right">房栋号：</td>
										<td ><input class="easyui-validatebox" type="text" id="hBuildingNum1"  name = "hBuildingNum1" data-options="editable:false"></input></td>
				
										<td align="right">单元号：</td>
										<td ><input class="easyui-validatebox" type="text" id="hUnitNum1" name="hUnitNum1" data-options="editable:false"></td>
								
										<td align="right">楼层号：</td>
										<td ><input class="easyui-validatebox" type="text" id="hFloorNum1"  name = "hFloorNum1" data-options="editable:false"></input></td>
									</tr>
									
									<tr>
										<td align="right">房间号：</td>
										<td ><input class="easyui-validatebox" type="text" id="roomNumber1" name="roomNumber1" data-options="editable:false"></td>
										
										<td align="right">姓名：</td>
										<td ><input class="easyui-validatebox" type="text" id="name1"  name = "name1" data-options="editable:false"></input></td>
				                        
				                        <td align="right">性别：</td>
										<td ><input class="easyui-validatebox"  id="sex1" name="sex1" data-options="editable:false"></input></td>
				                      </tr>
				                       
				                     <tr>
									     <td align="right">曾用名：</td>
										<td ><input class="easyui-validatebox" type="text" id="oldName1" name="oldName1" data-options="editable:false"></td>
				                    
									    <td align="right">民族：</td>
										<td ><input class="easyui-validatebox" type="text" id="nation1" name="nation1" data-options="editable:false"></input></td>
									    
									    <td align="right">文化程度：</td>
										<td ><input class="easyui-validatebox" type="text" id="degreeEducation1" name="degreeEducation1" data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">身份证号：</td>
										<td ><input class="easyui-validatebox" type="text" id="certificateNum1" name="certificateNum1" data-options="editable:false"></input></td>
									    
									    <td align="right">婚姻状况：</td>
										<td ><input id="maritalSta1" name="maritalSta1" class="easyui-validatebox"  data-options="editable:false" ></input></td>
				
									    <td align="right">兵役状况：</td>
										<td ><input id="militarySta1" name="militarySta1" class="easyui-validatebox"  data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">血型：</td>
										<td ><input id="bloodType1" name="bloodType1" class="easyui-validatebox"  data-options="editable:false"></input></td>
				
										<td align="right">身高：</td>
										<td ><input class="easyui-validatebox" type="text" id="height1" name="height1" data-options="editable:false"></input></td>
									
									    <td align="right">出租日期：</td>
										<td ><input class="easyui-validatebox" type="text" id="rentDate1" name="rentDate1" data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">职业：</td>
										<td ><input class="easyui-validatebox" type="text" id="occupation1" name="occupation1" data-options="editable:false"></input></td>
									   
									    <td align="right">职务：</td>
										<td ><input class="easyui-validatebox" type="text" id="post1" name="post1" data-options="editable:false"></input></td>
									    
									    <td align="right">户籍详址：</td>
										<td colspan="5"><input class="easyui-validatebox" type="text" id="houseRegist1" name="houseRegist1"  data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">服务住所：</td>
										<td ><input class="easyui-validatebox" type="text" id="serviceAddr1" name="serviceAddr1" data-options="editable:false"></input></td>
									    
									    <td align="right">固定电话：</td>
										<td ><input class="easyui-validatebox" type="text" id="landLine1" name="landLine1" data-options="editable:false"></input></td>
				                       
				                        <td align="right">手机：</td>
										<td ><input class="easyui-validatebox" type="text" id="telephone1" name="telephone1" data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">微信：</td>
										<td ><input class="easyui-validatebox" type="text" id="weChatNum1" name="weChatNum1" data-options="editable:false"></input></td>
				                        
				                        <td align="right">QQ：</td>
										<td ><input class="easyui-validatebox" type="text" id="qqNum1" name="qqNum1" data-options="editable:false"></input></td>
										
									   <td align="right">实际住址：</td>
										<td ><input class="easyui-validatebox" type="text" id="actualLiveAddr1" name="actualLiveAddr1" data-options="editable:false"></input></td>
									</tr>
									
						</table>
						</div>
					</form>
					<div id = "lelimage"  ></div>
				</div>
				<div id='dataDiv3' style="height:320px;" >
					<!--  单位同事信息   -->
						<div id="unitColleagueInfoList" class="easyui-datagrid" ></div>
							
				</div>
				<div id='dataDiv4' style="height:300px;" >
						<div id="imageUrlsDvu"></div>
				</div>
				<div id='dataDiv5'>
					<form id="fm5" method="post">
						<input type="hidden" value="" id="id" name = "id"/> 
						<table data-options="region:',border:false,fit:true,fitColumns:false" cellspacing="8" >
						 <tr>
							<td align="right">单位名称：</td>
							<td ><input class="easyui-validatebox" type="text" id="uName"  name = "uName" ></input></td>
	
							<td align="right">单位地址：</td>
							<td ><input class="easyui-validatebox" type="text" id="uAddr" name="uAddr" ></td>
						</tr>
						
						<tr>
						   	<td align="right">经营范围：</td>
							<td ><input class="easyui-validatebox" type="text" id="uOperateRange" name="uOperateRange" ></td> 
							
							<td align="right">经营性质：</td>
						    <td ><input class="easyui-validatebox" type="text" id="uProperty"  name = "uProperty" ></input></td>
	                    </tr>
	                    
	                    <tr>  
	                      	<td align="right">租金：</td>
							<td ><input class="easyui-validatebox" type="text" id="rent" name="rent" ></td>
							
							<td align="right">从业人数：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="uPersonNum" name="uPersonNum" ></input></td>
						</tr>
					    
					    <tr>
    					    <td align="right">经营面积：</td>
							<td ><input class="easyui-validatebox" type="text" id="uOperateArea"  name = "uOperateArea" ></input></td>
	                        
	                        <td align="right">单位类别：</td>
							<td ><input class="easyui-validatebox" type="text" id="uCategory" name="uCategory" ></input></td>
						</tr>
						
						<tr>
						    <td align="right">联系电话：</td>
							<td ><input class="easyui-validatebox" type="text" id="LinkNumber" name="LinkNumber" ></input></td>
	                        
	                        <td align="right">注册资金：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="regesistMoney" name="regesistMoney" ></input></td>
	                   	</tr>
	                   	
	                   	<tr>
	                        
	                        <td align="right">注册日期：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="regesistTime" name="regesistTime" ></input></td>
						
	                        <td align="right">有效期至：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="regesistcloseTime" name="regesistcloseTime" ></input></td>
						</tr>
						
						<tr>
							<td align="right">开业日期：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="openningTime" name="openningTime" ></input></td>
	
	                        <td align="right">有效期至：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="closeTime" name="closeTime" ></input></td>
						</tr>
						
						<tr>
						    <td align="right">治安责任人：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="securityPersonId" name="securityPersonId" ></input></td>
		                    
		                    <td align="right">工商执照号：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="bussinessNum" name="bussinessNum" ></input></td>
						</tr>
						
						<tr>
						    <td align="right">组织结构代码：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="orgNum" name="orgNum" ></input></td>
	                   </tr>				
							</table>
							
							<div >
										<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="showLayOutInfo('单位户型图')">单位户型图</a>										
										&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;	
										<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="showUnitPhotoInfo()">单位照片</a>	
			
							</div>
					</form>
				
				</div>
				<div id='dataDiv6'></div>
				
						<div id='dataDivCorporation1'>
					<form id="fmCorporation" method="post">
						<input type="hidden" value="" id="id" name = "id"/>
							<table  data-options="region:center,border:false,fit:true,fitColumns:false"  >
									 		
									<tr>
										<td align="right">姓名：</td>
										<td ><input class="easyui-validatebox" type="text" id="coname1"  name = "Coname1" data-options="editable:false"></input></td>
				                        
				                        <td align="right">性别：</td>
										<td ><input class="easyui-validatebox"  id="cosex1" name="cosex1" data-options="editable:false"></input></td>
				                     
				                        <td align="right">曾用名：</td>
										<td ><input class="easyui-validatebox" type="text" id="cooldName1" name="cooldName1" data-options="editable:false"></td>
				                    </tr>
				                       
				                     <tr>
									    
									    <td align="right">民族：</td>
										<td ><input class="easyui-validatebox" type="text" id="conation1" name="conation1" data-options="editable:false"></input></td>
									    
									    <td align="right">身份证号：</td>
										<td ><input class="easyui-validatebox" type="text" id="cocertificateNum1" name="cocertificateNum1" data-options="editable:false"></input></td>
									   
									    <td align="right">文化程度：</td>
										<td ><input class="easyui-validatebox" type="text" id="codegreeEducation1" name="codegreeEducation1" data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">婚姻状况：</td>
										<td ><input id="comaritalSta1" name="comaritalSta1" class="easyui-validatebox"  data-options="editable:false" ></input></td>
				
									    <td align="right">兵役状况：</td>
										<td ><input id="comilitarySta1" name="comilitarySta1" class="easyui-validatebox"  data-options="editable:false"></input></td>
									
									    <td align="right">血型：</td>
										<td ><input id="cobloodType1" name="cobloodType1" class="easyui-validatebox"  data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">身高：</td>
										<td ><input class="easyui-validatebox" type="text" id="coheight1" name="coheight1" data-options="editable:false"></input></td>
									
									    <td align="right">从业日期：</td>
										<td ><input class="easyui-validatebox" type="text" id="coworkDate1" name="coworkDate1" data-options="editable:false"></input></td>
										
										<td align="right">职务：</td>
										<td ><input class="easyui-validatebox" type="text" id="copost1" name="copost1" data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">户籍详址：</td>
										<td ><input class="easyui-validatebox" type="text" id="cohouseRegist1" name="cohouseRegist1"  data-options="editable:false"></input></td>
									
								     	<td align="right">出生日期：</td>
										<td ><input class="easyui-validatebox" type="text" id="cobirthday1"  name = "cobirthday1" data-options="editable:false"></input></td>
				                        
				                        <td align="right">固定电话：</td>
										<td ><input class="easyui-validatebox" type="text" id="colandLine1" name="colandLine1" data-options="editable:false"></input></td>
				                     </tr>
									
									<tr>
									    <td align="right">手机：</td>
										<td ><input class="easyui-validatebox" type="text" id="cotelephone1" name="cotelephone1" data-options="editable:false"></input></td>
									    
									    <td align="right">微信：</td>
										<td ><input class="easyui-validatebox" type="text" id="coweChatNum1" name="coweChatNum1" data-options="editable:false"></input></td>
				                        
				                        <td align="right">QQ：</td>
										<td ><input class="easyui-validatebox" type="text" id="coqqNum1" name="coqqNum1" data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">户口类别：</td>
										<td ><input id="coIdType1" name="coIdType1" class="easyui-validatebox"  data-options="editable:false"></input></td>
										
										<td align="right">居住证号：</td>
										<td ><input class="easyui-validatebox" type="text" id="coresidenceId1" name="coresidenceId1" data-options="editable:false"></input></td>
				                   </tr>
									
									  <!-- 
				                        
				                       
										 
										<td align="right">职业：</td>
										<td ><input class="easyui-validatebox" type="text" id="occupation" name="occupation" data-options="editable:false"></input></td>
				                        
										
									   
				                        <td align="right">人口性质：</td>
										<td ><input id="personType" name="personType" class="easyui-validatebox"  data-options="editable:false" ></input>
										</td>
										
										<td align="right">人员类别：</td>					
										<td ><input id="pType" name="pType" class="easyui-validatebox"  data-options="editable:false"></input>
										</td>
										
										<td align="right">版本号：</td>
										<td ><input class="easyui-validatebox" type="text" id="pversion" name="pversion" data-options="editable:false"></input></td>
							       -->
									 
								 
								</table>
							</form>
						<div id = "lelimage1"  ></div>
				</div>
			</div>
			
			
			
		</div>
	
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	<!--  单位信息窗  弃用   
	<div id="unitdlg" >
		<form id="fm" method="post">
		<div class="easyui-layout" style="width:606px;height:470px;">		
		
		<div data-options="region:'center'" style="background:#fafafa;overflow:hidden;padding-top: 20px;" align="center">
		<input type="hidden" value="" id="id" name = "id"/> 
			<table data-options="region:',border:false,fit:true,fitColumns:false" cellspacing="8" >
					<tr>
						<td align="right">单位名称：</td>
						<td ><input class="easyui-validatebox" type="text" id="uName"  name = "uName" ></input></td>

						<td align="right">单位地址：</td>
						<td ><input class="easyui-validatebox" type="text" id="uAddr" name="uAddr" >
						</td>
					</tr>
					
					<tr>
						<td align="right">经营性质：</td>
						<td ><input class="easyui-validatebox" type="text" id="uProperty"  name = "uProperty" ></input></td>

						<td align="right">经营范围：</td>
						<td ><input class="easyui-validatebox" type="text" id="uOperateRange" name="uOperateRange" >
						</td>
					</tr>
					
					<tr>
						<td align="right">经营面积：</td>
						<td ><input class="easyui-validatebox" type="text" id="uOperateArea"  name = "uOperateArea" ></input></td>

						<td align="right">租金：</td>
						<td ><input class="easyui-validatebox" type="text" id="rent" name="rent" >
						</td>
					</tr>


					<tr>
						<td align="right">联系电话：</td>
						<td ><input class="easyui-validatebox" type="text" id="LinkNumber" name="LinkNumber" ></input></td>

						<td align="right">单位类别：</td>
						<td ><input class="easyui-validatebox" type="text" id="uCategory" name="uCategory" ></input></td>
					</tr>
					
					<tr >
						<td align="right">治安负责人Id：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="securityPersonId" name="securityPersonId" ></input></td>

						<td align="right">从业人数：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="uPersonNum" name="uPersonNum" ></input></td>
					</tr>
					
					<tr >
						<td align="right">单位联系电话：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="uTelephone" name="uTelephone" ></input></td>

						<td align="right">工商执照号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="bussinessNum" name="bussinessNum" ></input></td>
					</tr>
	

					<tr >
						<td align="right">注册资金：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="regesistMoney" name="regesistMoney" ></input></td>

						<td align="right">注册日期：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="regesistTime" name="regesistTime" ></input></td>
					</tr>

					<tr>
						<td align="right">开业时间：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="openningTime" name="openningTime" ></input></td>

						<td align="right">有效日期至：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="closeTime" name="closeTime" ></input></td>
					</tr>	
					<tr>
						<td align="right">组织结构代码：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="orgNum" name="orgNum" ></input></td>

						<td align="right">版本号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="uversion" name="uversion" ></input></td>
					</tr>						
				</table>
				
				<div >
							<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="showLayOutInfo('单位户型图')">此单位户型图</a>										
							&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;	
							<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="showUnitPhotoInfo()">此单位拍照</a>	

				</div>
			</div>
		</div>
		</form>
	</div>
	-->
	<!--  单位户型图片	
	<div id="unitImageDlg" class="easyui-dialog" style="width:500px;height:300px; padding: 0px;" closed="true" buttons="#dlg-buttons" data-options=" modal:true">
		<div class="easyui-layout" style="width:500px;height:300px">
			
			<div id="show"  data-options="region:'center'">
				<div id="unitImageDlg" class="easyui-datagrid" ></div>
			</div>
		</div>
	</div>
	
	-->
	
	<!--  单位拍照图片	
	<div id="photoImageDlg" title="单位拍照" class="easyui-dialog" style="width:500px;height:300px; padding: 0px;" closed="true" buttons="#dlg-buttons" data-options=" modal:true">
		<div id="imageUrlsDv"></div>
	</div>

-->

<!-----------弃用------------->
<!--  法人,房主信息窗口	  -->	
	<%--<div id="legalOrlandlordInfoDlg" class="easyui-dialog" style="width:608px; height: 499px; padding: 0px;" closed="true" buttons="#dlg-buttons" data-options=" modal:true">
		<form id="fm" method="post">
<!--		<div class="easyui-layout" style="width:806px;height:620px;">-->
		<div id="yuyiyiuy"  style="width:580px;padding-top: 20px;">
<!--		<div  data-options="region:'center'" style="background:#fafafa;overflow:hidden;padding-top: 20px;" align="center">-->
		<input type="hidden" value="" id="id" name = "id"/>
<!--		<input type="hidden" value="" id="uId" name = "uId"/>-->
<!--		<input type="hidden" value="" id="imgPersonUrl" name = "imgPersonUrl"/> --><center>
		<table data-options="region:',border:false,fit:true,fitColumns:false"  cellspacing="2" >
					<tr style="height:30px;">
						<td align="right">房栋号：</td>
						<td ><input class="easyui-validatebox" type="text" id="llhBuildingNum"  name = "llhBuildingNum" data-options="editable:false"></input></td>

						<td align="right">单元号：</td>
						<td ><input class="easyui-validatebox" type="text" id="llhUnitNum" name="llhUnitNum" data-options="editable:false">
						</td>
					</tr>
					
					<tr>
						<td align="right">楼层：</td>
						<td ><input class="easyui-validatebox" type="text" id="llhFloorNum"  name = "llhFloorNum" data-options="editable:false"></input></td>

						<td align="right">房间号：</td>
						<td ><input class="easyui-validatebox" type="text" id="llroomNumber" name="llroomNumber" data-options="editable:false">
						</td>
					</tr>
					
					<tr>
						<td align="right">姓名：</td>
						<td ><input class="easyui-validatebox" type="text" id="llname"  name = "llname" data-options="editable:false"></input></td>

						<td align="right">曾用名：</td>
						<td ><input class="easyui-validatebox" type="text" id="lloldName" name="lloldName" data-options="editable:false">
						</td>
					</tr>

					<tr>
						<td align="right">性别：</td>
						<td ><input class="easyui-validatebox"  id="llsex" name="llsex"  data-options="editable:false"></input>
						</td>

						<td align="right">民族：</td>
						<td ><input class="easyui-validatebox" type="text" id="llnation" name="llnation" data-options="editable:false"></input></td>
					</tr>

					<tr>
						<td align="right">身份证号：</td>
						<td ><input class="easyui-validatebox" type="text" id="llcertificateNum" name="llcertificateNum" data-options="editable:false"></input></td>

						<td align="right">文化程度：</td>
						<td ><input class="easyui-validatebox" type="text" id="lldegreeEducation" name="lldegreeEducation" data-options="editable:false"></input></td>
					</tr>
					
					<tr>
						<td align="right">出生日期：</td>
						<td ><input class="easyui-validatebox" type="text" id="llbirthday"  name = "llbirthday" data-options="editable:false"></input></td>

						<td align="right">户口类别：</td>
						<td ><input id="llIdType" name="llIdType" class="easyui-validatebox"  data-options="editable:false"></input>							
						</td>
					</tr>
					<tr >
						<td align="right">人口性质：</td>
						<td>
							<input id="llpersonType" name="llpersonType" class="easyui-validatebox"  data-options="editable:false" ></input>
						</td>
					</tr>	
					<tr >
						<td align="right">婚姻状况：</td>
						<td align="right"><input id="llmaritalSta" name="llmaritalSta" class="easyui-validatebox"  data-options="editable:false" ></input>
						</td>

						<td align="right">兵役状况：</td>
						<td align="right"><input id="llmilitarySta" name="llmilitarySta" class="easyui-validatebox"  data-options="editable:false"></input>
						</td>
					</tr>	
					<tr >
						<td align="right">血型：</td>
						<td align="right"><input id="llbloodType" name="llbloodType" class="easyui-validatebox"  data-options="editable:false"></input>
						</td>

						<td align="right">身高：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="llheight" name="llheight" data-options="editable:false"></input></td>
					</tr>

					<tr >
						<td align="right">出租日期：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="llrentDate" name="llrentDate" data-options="editable:false"></input></td>

						<td align="right">从业日期：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="llworkDate" name="llworkDate" data-options="editable:false"></input></td>
					</tr>
					
					<tr >
						<td align="right">职业：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="lloccupation" name="lloccupation" data-options="editable:false"></input></td>

						<td align="right">职务：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="llpost" name="llpost" data-options="editable:false"></input></td>
					</tr>

					<tr >
						<td align="right">户籍：</td>
						<td colspan="3"><input class="easyui-validatebox" type="text" id="llhouseRegist" name="llhouseRegist" style="width:380px;" data-options="editable:false"></input></td>
					</tr>

					<tr >
						<td align="right">服务处所：</td>
						<td colspan="3"><input class="easyui-validatebox" type="text" id="llserviceAddr" name="llserviceAddr" style="width:380px;" data-options="editable:false"></input></td>
					</tr>	

					<tr >
						<td align="right">现居住地址：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="llactualLiveAddr" name="llactualLiveAddr" data-options="editable:false"></input></td>

						<td align="right">固定电话：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="lllandLine" name="lllandLine" data-options="editable:false"></input></td>
					</tr>

					<tr>
						<td align="right">手机：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="lltelephone" name="lltelephone" data-options="editable:false"></input></td>

						<td align="right">QQ：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="llqqNum" name="llqqNum" data-options="editable:false"></input></td>
					</tr>	

					<tr >
						<td align="right">微信号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="llweChatNum" name="llweChatNum" data-options="editable:false"></input></td>

						<td align="right">人员类别：</td>					
						<td align="right"><input id="llpType" name="llpType" class="easyui-validatebox"  data-options="editable:false"></input>
						</td>
					</tr>

					<tr>
						<td align="right">居住证号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="llresidenceId" name="llresidenceId" data-options="editable:false"></input></td>

						<td align="right">版本号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="llpversion" name="llpversion" data-options="editable:false"></input></td>
					</tr>	
					
				</table>

</center>
<!--			</div>-->
		</div>
		<div id = "lelimage" style="margin-top:10px" >
		</div>
		</form>
	</div>--%>












	
	
	
<!--  法人,房主信息窗口	  	-->
<!--	<div id="legalOrlandlordInfoDlg" class="easyui-dialog" style="width:608px; height: 499px; padding: 0px;" closed="true" buttons="#dlg-buttons" data-options=" modal:true">-->
<!--		<form id="fm" method="post">-->
<!--		<div class="easyui-layout" style="width:606px;height:470px;">-->
<!--		-->
<!--		<div data-options="region:'center'" style="background:#fafafa;overflow:hidden;padding-top: 20px;" align="center">-->
<!--		<input type="hidden" value="" id="id" name = "id"/>-->
		<input type="hidden" value="" id="uId" name = "uId"/>
		<input type="hidden" value="" id="imgPersonUrl" name = "imgPersonUrl"/> 
<!--			<table data-options="region:',border:false,fit:true,fitColumns:false" cellspacing="2" >-->
<!--					<tr>-->
<!--						<td align="right">房栋号：</td>-->
<!--						<td ><input class="easyui-validatebox" type="text" id="llhBuildingNum"  name = "llhBuildingNum" data-options="editable:false"></input></td>-->
<!---->
<!--						<td align="right">单元号：</td>-->
<!--						<td ><input class="easyui-validatebox" type="text" id="llhUnitNum" name="llhUnitNum" data-options="editable:false">-->
<!--						</td>-->
<!--					</tr>-->
<!--					-->
<!--					<tr>-->
<!--						<td align="right">楼层：</td>-->
<!--						<td ><input class="easyui-validatebox" type="text" id="llhFloorNum"  name = "llhFloorNum" data-options="editable:false"></input></td>-->
<!---->
<!--						<td align="right">房间号：</td>-->
<!--						<td ><input class="easyui-validatebox" type="text" id="llroomNumber" name="llroomNumber" data-options="editable:false">-->
<!--						</td>-->
<!--					</tr>-->
<!--					-->
<!--					<tr>-->
<!--						<td align="right">姓名：</td>-->
<!--						<td ><input class="easyui-validatebox" type="text" id="llname"  name = "llname" data-options="editable:false"></input></td>-->
<!---->
<!--						<td align="right">曾用名：</td>-->
<!--						<td ><input class="easyui-validatebox" type="text" id="lloldName" name="lloldName" data-options="editable:false">-->
<!--						</td>-->
<!--					</tr>-->
<!---->
<!--					<tr>-->
<!--						<td align="right">性别：</td>-->
<!--						<td ><input class="easyui-validatebox"  id="llsex" name="llsex" style="width:173px;" data-options="editable:false"></input>-->
<!--						</td>-->
<!---->
<!--						<td align="right">民族：</td>-->
<!--						<td ><input class="easyui-validatebox" type="text" id="llnation" name="llnation" data-options="editable:false"></input></td>-->
<!--					</tr>-->
<!---->
<!--					<tr>-->
<!--						<td align="right">身份证号：</td>-->
<!--						<td ><input class="easyui-validatebox" type="text" id="llcertificateNum" name="llcertificateNum" data-options="editable:false"></input></td>-->
<!---->
<!--						<td align="right">文化程度：</td>-->
<!--						<td ><input class="easyui-validatebox" type="text" id="lldegreeEducation" name="lldegreeEducation" data-options="editable:false"></input></td>-->
<!--					</tr>-->
<!--					-->
<!--					<tr>-->
<!--						<td align="right">出生日期：</td>-->
<!--						<td ><input class="easyui-validatebox" type="text" id="llbirthday"  name = "llbirthday" data-options="editable:false"></input></td>-->
<!---->
<!--						<td align="right">户口类别：</td>-->
<!--						<td ><input id="llIdType" name="llIdType" class="easyui-validatebox" style="width:173px;" data-options="editable:false"></input>							-->
<!--						</td>-->
<!--					</tr>-->
<!--					<tr >-->
<!--						<td align="right">人口性质：</td>-->
<!--						<td>-->
<!--							<input id="llpersonType" name="llpersonType" class="easyui-validatebox" style="width:173px;" data-options="editable:false" ></input>-->
<!--						</td>-->
<!--					</tr>	-->
<!--					<tr >-->
<!--						<td align="right">婚姻状况：</td>-->
<!--						<td align="right"><input id="llmaritalSta" name="llmaritalSta" class="easyui-validatebox" style="width:173px;" data-options="editable:false" ></input>-->
<!--						</td>-->
<!---->
<!--						<td align="right">兵役状况：</td>-->
<!--						<td align="right"><input id="llmilitarySta" name="llmilitarySta" class="easyui-validatebox" style="width:173px;" data-options="editable:false"></input>-->
<!--						</td>-->
<!--					</tr>	-->
<!--					<tr >-->
<!--						<td align="right">血型：</td>-->
<!--						<td align="right"><input id="llbloodType" name="llbloodType" class="easyui-validatebox" style="width:173px;" data-options="editable:false"></input>-->
<!--						</td>-->
<!---->
<!--						<td align="right">身高：</td>-->
<!--						<td align="right"><input class="easyui-validatebox" type="text" id="llheight" name="llheight" data-options="editable:false"></input></td>-->
<!--					</tr>-->
<!---->
<!--					<tr >-->
<!--						<td align="right">出租日期：</td>-->
<!--						<td align="right"><input class="easyui-validatebox" type="text" id="llrentDate" name="llrentDate" data-options="editable:false"></input></td>-->
<!---->
<!--						<td align="right">从业日期：</td>-->
<!--						<td align="right"><input class="easyui-validatebox" type="text" id="llworkDate" name="llworkDate" data-options="editable:false"></input></td>-->
<!--					</tr>-->
<!--					-->
<!--					<tr >-->
<!--						<td align="right">职业：</td>-->
<!--						<td align="right"><input class="easyui-validatebox" type="text" id="lloccupation" name="lloccupation" data-options="editable:false"></input></td>-->
<!---->
<!--						<td align="right">职务：</td>-->
<!--						<td align="right"><input class="easyui-validatebox" type="text" id="llpost" name="llpost" data-options="editable:false"></input></td>-->
<!--					</tr>-->
<!---->
<!--					<tr >-->
<!--						<td align="right">户籍：</td>-->
<!--						<td colspan="3"><input class="easyui-validatebox" type="text" id="llhouseRegist" name="llhouseRegist" style="width:380px;" data-options="editable:false"></input></td>-->
<!--					</tr>-->
<!---->
<!--					<tr >-->
<!--						<td align="right">服务处所：</td>-->
<!--						<td colspan="3"><input class="easyui-validatebox" type="text" id="llserviceAddr" name="llserviceAddr" style="width:380px;" data-options="editable:false"></input></td>-->
<!--					</tr>	-->
<!---->
<!--					<tr >-->
<!--						<td align="right">现居住地址：</td>-->
<!--						<td align="right"><input class="easyui-validatebox" type="text" id="llactualLiveAddr" name="llactualLiveAddr" data-options="editable:false"></input></td>-->
<!---->
<!--						<td align="right">固定电话：</td>-->
<!--						<td align="right"><input class="easyui-validatebox" type="text" id="lllandLine" name="lllandLine" data-options="editable:false"></input></td>-->
<!--					</tr>-->
<!---->
<!--					<tr>-->
<!--						<td align="right">手机：</td>-->
<!--						<td align="right"><input class="easyui-validatebox" type="text" id="lltelephone" name="lltelephone" data-options="editable:false"></input></td>-->
<!---->
<!--						<td align="right">QQ：</td>-->
<!--						<td align="right"><input class="easyui-validatebox" type="text" id="llqqNum" name="llqqNum" data-options="editable:false"></input></td>-->
<!--					</tr>	-->
<!---->
<!--					<tr >-->
<!--						<td align="right">微信号：</td>-->
<!--						<td align="right"><input class="easyui-validatebox" type="text" id="llweChatNum" name="llweChatNum" data-options="editable:false"></input></td>-->
<!---->
<!--						<td align="right">人员类别：</td>					-->
<!--						<td align="right"><input id="llpType" name="llpType" class="easyui-validatebox" style="width:173px;" data-options="editable:false"></input>-->
<!--						</td>-->
<!--					</tr>-->
<!---->
<!--					<tr>-->
<!--						<td align="right">居住证号：</td>-->
<!--						<td align="right"><input class="easyui-validatebox" type="text" id="llresidenceId" name="llresidenceId" data-options="editable:false"></input></td>-->
<!---->
<!--						<td align="right">版本号：</td>-->
<!--						<td align="right"><input class="easyui-validatebox" type="text" id="llpversion" name="llpversion" data-options="editable:false"></input></td>-->
<!--					</tr>	-->
<!--					-->
<!--				</table>-->
<!--			</div>-->
<!--		</div>-->
<!--		</form>-->
<!--	</div>	-->
	
	<!--  单位人员拍照图片	-->
	<div id="upimageDlg" title="单位人员拍照" class="easyui-dialog" style="width:800px;height:360px; padding: 0px;" closed="true" >
		<div id="upimagediv"></div>
	</div>	
	
	
	
	<div id="dlg5" class="easyui-dialog" title="单位户型图"  style="width:800px;height:360px;padding:10px">
		<div id="imageUrlsDv1"></div>
	</div>
	<div id="dlg6" class="easyui-dialog" title="单位拍照"  style="width:800px;height:360px;padding:10px">
		<div id="imageUrlsDv2"></div>
	</div>
	<div id="dlgOpenImg" class="easyui-dialog" title="查看" closed="true"  style="width:700px;height:500px;padding:0px">
		<div id="imageOpenDIV"></div>
	</div>
</body>
</html>