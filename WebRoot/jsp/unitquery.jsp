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
<title>实有单位查询</title>

<script type="text/javascript"><!--
	$(window).ready(function(){
		setFormReadOnly();
		getListPage();
		$('#photoImageDlg').dialog('close');
		$("div[id$='Dlg'] input").attr("readonly","readonly");

	});
	
//单位名 工商执照号 单位组织结构代码
	//查询方法，带分页
	function getListPage(){
				$('#list').datagrid({			
					url: "<%=request.getContextPath()%>/unitController/getListPage.action",
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
						{field:'landlordId',title:'房东ID号',hidden:true},
						{field:'legalRepresentId',title:'法人代表ID号',hidden:true},						
						{field:'uname',title:'单位名称',width:80},
						{field:'uaddr',title:'单位地址',width:100},
						//{field:'uproperty',title:'经营性质',width:80},
						{field:'uoperateRange',title:'经营范围',width:80},
						{field:'uoperateArea',title:'经营面积',width:80},
						//{field:'rent',title:'租金',width:50},
						{field:'LinkNumber',title:'联系电话',width:80},
						{field:'ucategory',title:'单位类别',width:80},
						{field:'securityPersonId',title:'治安负责人',width:100},
						{field:'upersonNum',title:'从业人数',width:60},
						//{field:'utelephone',title:'单位联系电话',width:100},
						{field:'bussinessNum',title:'工商执照号',width:100},
						{field:'regesistMoney',title:'注册资金',width:80},
						{field:'regesistTime',title:'注册日期',width:80},
						{field:'validTime',title:'有效期至',width:80},
						{field:'openningTime',title:'开业时间',width:80},
						{field:'closeTime',title:'有效期至',width:80},
						{field:'orgNum',title:'组织结构代码',width:100}
						//{field:'imageUrls',title:'单位户型图',hidden:false},
						//{field:'layoutDiagramUrl',title:'单位户型画图',hidden:false},
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
				},*/
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
				},{
					id:'btncut',
					text:'删除',
					iconCls:'icon-cut',
					handler:function(){
						var row = $('#list').datagrid('getChecked');
						deleteUnit(row);
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
			  $.messager.confirm('修改确认', '確定要修改此数据吗？', function(r){
			if (r){
				var rest = $("#fm").serialize();
				 $.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/unitController/updataUnit.action",
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
	function deleteUnit(rows){
		var id ="";
		  if(rows != ""){
			  for(var i = 0; i < rows.length; i++){
				  id += rows[i].id +"," ;
			  }
			  $.messager.confirm('删除确认', '確定要删除选中的数据吗', function(r){
					if (r){
						 $.ajax({
							type:'POST',
							url: "<%=request.getContextPath()%>/unitController/deleteUnit.action",
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
			var fileName = "单位信息表";
			var type = "unit";
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
	function showDataDiv1(type){
		 setOpen($("#dataDiv1"));//默认显示第一个div
	  		var data =$('#list').datagrid('getChecked');
//	  			$('#id').val(data[0].id);		  			
	  			$('#uName').val(data[0].uname);
	  			$('#uAddr').val(data[0].uaddr);
				$('#uProperty').val(data[0].uproperty);
				$('#uOperateRange').val(data[0].uoperateRange);										
				$('#uOperateArea').val(data[0].uoperateArea);
				$('#rent').val(data[0].rent);										
				$('#LinkNumber').val(data[0].LinkNumber);																								
				$('#uCategory').val(data[0].ucategory);										
				$('#securityPersonId').val(data[0].securityPersonId);
				$('#uPersonNum').val(data[0].upersonNum);
				$('#uTelephone').val(data[0].utelephone);
				$('#bussinessNum').val(data[0].bussinessNum);					
				$('#regesistMoney').val(data[0].regesistMoney);
				$('#regesistTime').val(data[0].regesistTime);
				//注册日期的有效期至
				$('#validTime').val(data[0].validTime);
				$('#openningTime').val(data[0].openningTime);
				$('#closeTime').val(data[0].closeTime);
				//$('#regesistTime').datetimebox('setValue',data[0].regesistTime);
				//$('#openningTime').datetimebox('setValue',data[0].openningTime);
				//$('#closeTime').datetimebox('setValue',data[0].closeTime);
				$('#orgNum').val(data[0].orgNum);
//				$('#legalRepresentId').val(data[0].legalRepresentId);
//				$('#landlordId').val(data[0].landlordId);										
//				$('#imageUrls').val(data[0].imageUrls);
//				$('#layoutDiagramUrl').val(data[0].layoutDiagramUrl);										
				$('#version').val(data[0].version);	
/*	 if(type=='1'){
	  	$("#btnDIv").hide();
		setFormReadOnly();
	  }else{
	  	$("#btnDIv").show();
		setFormCanBeEdited();
	  }*/
	}
	//打开Dialog层
	function openDialog(titleName,type){
		  $('#dlg').dialog('open').dialog('setTitle',titleName);
		  showDataDiv1(type);
																																		  			
	}
	//关闭dialog层
	function d_close(){
			$('#dlg').dialog('close');
	}


//					$('#legalRepresentId').val(data[0].legalRepresentId);
//					$('#landlordId').val(data[0].landlordId);	
	//房主信息窗口
	function legalRepresentOrlandlordInfo(titleNa){
			//$('#legalOrlandlordInfoDlg').dialog('open').dialog('setTitle',titleNa);
			
		//	$('#dataDiv2').html($('#legalOrlandlordInfoDlg').html());
			setOpen($('#dataDiv2'))
			var data =$('#list').datagrid('getChecked');
			var uId = "";//单位id
			var id = "";//人员id
			if("法人信息"==titleNa){
				uId = data[0].id;
				id = data[0].legalRepresentId;
			}else{//房主信息
				id = data[0].landlordId;
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
						$('#pType').val("法定代表人");									
					}else if("2"==json.ptype){
						$('#pType').val("单位员工");					
					}else{
						$('#pType').val("房主");					
					}
		  																							
		  			//hBuildingNum
		  			$('#hBuildingNum').val(json.hbuildingNum);
		  			$('#hUnitNum').val(json.hunitNum);
		  			$('#hFloorNum').val(json.hfloorNum);
		  			$('#roomNumber').val(json.roomNumber);
					$('#name').val(json.name);
					$('#oldName').val(json.oldName);
					$('#birthday').val(json.birthday);
						$('#sex').val(json.sex);					
					$('#nation').val(json.nation);
					$('#certificateNum').val(json.certificateNum);
					$('#degreeEducation').val(json.degreeEducation);
				    $('#maritalSta').val(json.maritalSta);
					$('#militarySta').val(json.militarySta);	
					/*if("0"==json.maritalSta){
						$('#maritalSta').val("未婚");
					}else if("1"==json.maritalSta){
						$('#maritalSta').val("已婚");
					}else{
						$('#maritalSta').val("离异");					
					}*/								
					$('#personType').val(json.personType);
					
					/*if("0"==json.maritalSta){
						$('#militarySta').val("未服");
					}else if("1"==json.maritalSta){
						$('#militarySta').val("正在服");
					}else{
						$('#militarySta').val("服起已过");					
					}*/
					$('#bloodType').val(json.bloodType);															
					$('#height').val(json.height);
					$('#rentDate').val(json.rentDate);
					$('#workDate').val(json.workDate);
					$('#IdType').val(json.IdType);
					$('#residenceId').val(json.residenceId);
					$('#occupation').val(json.occupation);
					$('#actualLiveAddr').val(json.actualLiveAddr);										
					$('#post').val(json.post);
					$('#houseRegist').val(json.houseRegist);										
					$('#serviceAddr').val(json.serviceAddr);
					$('#landLine').val(json.landLine);										
					$('#telephone').val(json.telephone);
					$('#qqNum').val(json.qqNum);
					$('#weChatNum').val(json.weChatNum);
					//$('#weChatNum').val(data[0].weChatNum);
//					$('#imgPersonUrl').val(data[0].imgPersonUrl);
					$('#pversion').val(json.version);
					setImage(json.id);
					}
				});
	}
	
		//法人信息窗口
	function legalRepresentOrlandlordInfo1(titleNa){
			//$('#legalOrlandlordInfoDlg').dialog('open').dialog('setTitle',titleNa);
			
		//	$('#dataDiv2').html($('#legalOrlandlordInfoDlg').html());
			setOpen($('#dataDivCorporation'))
			var data =$('#list').datagrid('getChecked');
			var uId = "";//单位id
			var id = "";//人员id
			if("法人信息"==titleNa){
				uId = data[0].id;
				id = data[0].legalRepresentId;
			}else{//房主信息
				id = data[0].landlordId;
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
						$('#copType').val("法定代表人");									
					}else if("2"==json.ptype){
						$('#copType').val("单位员工");					
					}else{
						$('#copType').val("房主");					
					}
		  																							
		  			//hBuildingNum
		  			$('#cohBuildingNum').val(json.hbuildingNum);
		  			$('#cohUnitNum').val(json.hunitNum);
		  			$('#cohFloorNum').val(json.hfloorNum);
		  			$('#coroomNumber').val(json.roomNumber);
					$('#coname').val(json.name);
					$('#cooldName').val(json.oldName);
					$('#cobirthday').val(json.birthday);
						$('#cosex').val(json.sex);				
					$('#conation').val(json.nation);
					$('#cocertificateNum').val(json.certificateNum);
					$('#codegreeEducation').val(json.degreeEducation);	
				    $('#comaritalSta').val(json.maritalSta);
					$('#comilitarySta').val(json.militarySta);	
					$('#copersonType').val(json.personType);
					$('#cobloodType').val(json.bloodType);															
					$('#coheight').val(json.height);
					$('#corentDate').val(json.rentDate);
					$('#coworkDate').val(json.workDate);
					/*if("1"==json.IdType){//1 农村 2 城镇
						$('#coIdType').val("农村");
					}else{
						$('#coIdType').val("城镇");
					}*/
					$('#coIdType').val(json.IdType);
					$('#coresidenceId').val(json.residenceId);
					$('#cooccupation').val(json.occupation);
					$('#coactualLiveAddr').val(json.actualLiveAddr);										
					$('#copost').val(json.post);
					$('#cohouseRegist').val(json.houseRegist);										
					$('#coserviceAddr').val(json.serviceAddr);
					$('#colandLine').val(json.landLine);										
					$('#cotelephone').val(json.telephone);
					$('#coqqNum').val(json.qqNum);
					$('#coweChatNum').val(json.weChatNum);
					//$('#weChatNum').val(data[0].weChatNum);
//					$('#imgPersonUrl').val(data[0].imgPersonUrl);
					$('#copversion').val(json.version);
					setImage1(json.id);
					}
				});
	}
	function setImage(imageid){
	var rows =$('#list').datagrid('getChecked');
		$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+imageid+"&source=''",
						dataType:'JSON',
						success:function(info){
							var mediaFiles=info;
						/*	var imageUrlsStr="<table align='center'><tr>";
							for(var i=0;i<mediaFiles.length;i++){
								imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
							}
							imageUrlsStr+="</tr></table>";
							$("#lelimage").html(imageUrlsStr);
							*/
							_initRollImgs(mediaFiles,"lelimage");
						}
		});
	}
	function setImage1(imageid){
	var rows =$('#list').datagrid('getChecked');
		$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+imageid+"&source=''",
						dataType:'JSON',
						success:function(info){
							var mediaFiles=info;
						/*	var imageUrlsStr="<table align='center'><tr>";
							for(var i=0;i<mediaFiles.length;i++){
								imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
							}
							imageUrlsStr+="</tr></table>";
							$("#lelimage").html(imageUrlsStr);
							*/
							_initRollImgs(mediaFiles,"lelimage1");
						}
		});
	}
	
	//职工信息
	function unitpopulationInfo(titleNa){//unitpopulationInfoList
			//$('#unitpopulationInfoDlg').dialog('open').dialog('setTitle',titleNa);
			setOpen($('#dataDiv3'));
			var data =$('#list').datagrid('getChecked');
			var uId = data[0].id;
			$('#unitpopulationInfoList').datagrid({			
					url: "<%=request.getContextPath()%>/unitPopulationController/getUnitPopulationInfo.action?uId="+uId,
					pagination:true,//是否分页			
					fitColumns: false,//
					singleSelect: false,//是否只能单选
					scrollbarSize: 0,
					rownumbers:true,//行号
					fit: true,
					nowrap: true,
					
					onLoadSuccess:function(){
						dataCbProject = $('#unitpopulationInfoList').data('datagrid').data;
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
		//此人的拍照
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
	//单位户型图片
	function unitImage(titleNa){
			//$('#unitImageDlg').dialog('open').dialog('setTitle',titleNa);
			setOpen($('#dataDiv4'));
			var rows = $('#list').datagrid('getChecked');
			var layoutDiagramUrl=rows[0].layoutDiagramUrl;
			$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/unitController/findImages.action?imagesIds="+layoutDiagramUrl,
						dataType:'JSON',
						success:function(info){
							var mediaFiles=info;
							/*var imageUrlsStr="<table align='center'><tr>";
							for(var i=0;i<mediaFiles.length;i++){
								imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
							}
							imageUrlsStr+="</tr></table>";
							$("#unitImageDlg").html(imageUrlsStr);*/

							_initRollImgs(mediaFiles,"unitImageDlg");
						}
			});
			
			
	}
	//次单位的拍照
	function unitPhotoImages()
	{
	//	$('#photoImageDlg').dialog('open');
		setOpen($('#dataDiv5'));
		var rows = $('#list').datagrid('getChecked');
		var photosImages=rows[0].imageUrls;
		var id=rows[0].id;
		$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+rows[0].id+"&source=101",
						dataType:'JSON',
						success:function(info){
							var mediaFiles=info;
							
							/*var imageUrlsStr="<table align='center'><tr>";
							for(var i=0;i<mediaFiles.length;i++){
								imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
							}
							imageUrlsStr+="</tr></table>";
							$("#imageUrlsDv").html(imageUrlsStr);*/
							_initRollImgs(mediaFiles,"imageUrlsDv")
						}
		});
	}
	
	
	
	
	//查询
	function searchData(){
		var suName = $('#suName').val();
		//alert(suName)
		var sbussinessNum = $('#sbussinessNum').val();
		//alert(sbussinessNum)
		var sorgNum = $('#sorgNum').val();
		//alert(sorgNum)	
//		var data = $("#fm1").serialize();
		var url = "<%=request.getContextPath()%>/unitController/unitQuery.action?suName="+suName+"&sbussinessNum="+sbussinessNum+"&sorgNum="+sorgNum;
		$('#list').datagrid({url: url});
		$('#list').datagrid("reload");
	}
--></script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
	  		<div id="choose" data-options="region:'north'" style="height:50px;background-color:#F5F5F5">
	  			<div style="padding-left:5px;padding-top:10px;">
		  			<span>单位名称:
						<input class="easyui-validatebox" type="text" style="width:130px;"  id="suName" name ="suName"/></span>
						&nbsp;&nbsp;&nbsp;				
					<span>工商执照号:
						<input class="easyui-validatebox" type="text" style="width:130px;"  id="sbussinessNum" name = "sbussinessNum"/></span>
						&nbsp;&nbsp;&nbsp;
					<span>组织结构代码:
						<input class="easyui-validatebox" type="text" style="width:130px;"  id="sorgNum" name = "sorgNum"/></span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchData()">查询</a>		
				</div>
	  		</div>  		
	  		
			<div id="show"  data-options="region:'center'">
				<div id="list" class="easyui-datagrid" ></div>
			</div>
	</div>
	
	
	
	
<!--  单位信息窗    -->
	<div id="dlg" class="easyui-dialog" style="width:1100px; height: 450px; padding: 0px;" closed="true" buttons="#dlg-buttons" data-options=" modal:true">
		
		<div class="easyui-layout" style="width:1090px;height:420px;">
		
		<div id="btnDIv" data-options="region:'north'" style="height:46px;background:#fafafa;padding-top: 10px;">
			<table align="center">
				<tr>
					<td>
						<div>
								<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="showDataDiv1(1)">单位基本信息</a>
								&nbsp;&nbsp;
								<a href="#" class="easyui-linkbutton"   data-options="iconCls:'icon-search'" onclick="legalRepresentOrlandlordInfo('房主信息')">房主信息</a>		
								&nbsp;&nbsp;
								<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="legalRepresentOrlandlordInfo1('法人信息')">法人信息</a>
								&nbsp;&nbsp;
							    <a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="unitpopulationInfo('单位员工信息')">职工信息</a>		
								&nbsp;&nbsp;
								<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="unitImage('单位户型图')">单位户型图</a>
								&nbsp;&nbsp;
								<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="unitPhotoImages()">单位照片</a>											
							</div>
						</td>
					</tr>
				</table>
	
			</div>
		
			<div data-options="region:'south'" style="height:46px;background:#fafafa;padding-top: 5px;top:350px">
				<table align="center">
					<tr>
						<td><a href="#" id ='fmconfirm' class="easyui-linkbutton" iconCls="icon-ok" onclick="update()">确认</a></td>
						<td><a href="#" id ='fmcancel' class="easyui-linkbutton" iconCls="icon-cancel" onclick="d_close()">取消</a></td>
					</tr>
				</table>
			</div>
		
			<div data-options="region:'center'" style="background:#fafafa;padding-top: 10px;" align="center">
				<div id = 'dataDiv1'>
				<form id="fm" method="post">
				<input type="hidden" value="" id="id" name = "id"/>
	<!--		<input type="hidden" value="" id="uId" name = "uId"/>-->
	<!--		<input type="hidden" value="" id="legalRepresentId" name = "legalRepresentId"/>-->
	<!--		<input type="hidden" value="" id="landlordId" name = "landlordId"/>-->
	<!--		<input type="hidden" value="" id="imageUrls" name = "imageUrls"/>-->
	<!--		<input type="hidden" value="" id="layoutDiagramUrl" name = "layoutDiagramUrl"/>-->
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
							<td align="right"><input class="easyui-validatebox" type="text" id="validTime" name="validTime" ></input></td>
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
						
					 
						
		
	
						<!--
						<tr >
							<td align="right">单位联系电话：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="uTelephone" name="uTelephone" ></input></td>
	
						</tr>
						<tr>
							<td align="right">版本号：</td>
							<td align="right"><input class="easyui-validatebox" type="text" id="version" name="version" ></input></td>
						</tr>	
						 --> 					
					</table>
					</form>
				</div>
				<div id='dataDiv2'>
					<form id="fm2" method="post">
						<input type="hidden" value="" id="id" name = "id"/>
							<table  data-options="region:center,border:false,fit:true,fitColumns:false"  >
									<tr>
										<td align="right">房栋号：</td>
										<td ><input class="easyui-validatebox" type="text" id="hBuildingNum"  name = "hBuildingNum" data-options="editable:false"></input></td>
				
										<td align="right">单元号：</td>
										<td ><input class="easyui-validatebox" type="text" id="hUnitNum" name="hUnitNum" data-options="editable:false"></td>
								
										<td align="right">楼层号：</td>
										<td ><input class="easyui-validatebox" type="text" id="hFloorNum"  name = "hFloorNum" data-options="editable:false"></input></td>
									</tr>
									
									<tr>
										<td align="right">房间号：</td>
										<td ><input class="easyui-validatebox" type="text" id="roomNumber" name="roomNumber" data-options="editable:false"></td>
										
										<td align="right">姓名：</td>
										<td ><input class="easyui-validatebox" type="text" id="name"  name = "name" data-options="editable:false"></input></td>
				                        
				                        <td align="right">性别：</td>
										<td ><input class="easyui-validatebox"  id="sex" name="sex" data-options="editable:false"></input></td>
				                      </tr>
				                       
				                     <tr>
									     <td align="right">曾用名：</td>
										<td ><input class="easyui-validatebox" type="text" id="oldName" name="oldName" data-options="editable:false"></td>
				                    
									    <td align="right">民族：</td>
										<td ><input class="easyui-validatebox" type="text" id="nation" name="nation" data-options="editable:false"></input></td>
									    
									    <td align="right">文化程度：</td>
										<td ><input class="easyui-validatebox" type="text" id="degreeEducation" name="degreeEducation" data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">身份证号：</td>
										<td ><input class="easyui-validatebox" type="text" id="certificateNum" name="certificateNum" data-options="editable:false"></input></td>
									    
									    <td align="right">婚姻状况：</td>
										<td ><input id="maritalSta" name="maritalSta" class="easyui-validatebox"  data-options="editable:false" ></input></td>
				
									    <td align="right">兵役状况：</td>
										<td ><input id="militarySta" name="militarySta" class="easyui-validatebox"  data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">血型：</td>
										<td ><input id="bloodType" name="bloodType" class="easyui-validatebox"  data-options="editable:false"></input></td>
				
										<td align="right">身高：</td>
										<td ><input class="easyui-validatebox" type="text" id="height" name="height" data-options="editable:false"></input></td>
									
									    <td align="right">出租日期：</td>
										<td ><input class="easyui-validatebox" type="text" id="rentDate" name="rentDate" data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">职业：</td>
										<td ><input class="easyui-validatebox" type="text" id="occupation" name="occupation" data-options="editable:false"></input></td>
									   
									    <td align="right">职务：</td>
										<td ><input class="easyui-validatebox" type="text" id="post" name="post" data-options="editable:false"></input></td>
									    
									    <td align="right">户籍详址：</td>
										<td colspan="5"><input class="easyui-validatebox" type="text" id="houseRegist" name="houseRegist"  data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">服务住所：</td>
										<td ><input class="easyui-validatebox" type="text" id="serviceAddr" name="serviceAddr" data-options="editable:false"></input></td>
									    
									    <td align="right">固定电话：</td>
										<td ><input class="easyui-validatebox" type="text" id="landLine" name="landLine" data-options="editable:false"></input></td>
				                       
				                        <td align="right">手机：</td>
										<td ><input class="easyui-validatebox" type="text" id="telephone" name="telephone" data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">微信：</td>
										<td ><input class="easyui-validatebox" type="text" id="weChatNum" name="weChatNum" data-options="editable:false"></input></td>
				                        
				                        <td align="right">QQ：</td>
										<td ><input class="easyui-validatebox" type="text" id="qqNum" name="qqNum" data-options="editable:false"></input></td>
										
									   <td align="right">实际住址：</td>
										<td ><input class="easyui-validatebox" type="text" id="actualLiveAddr" name="actualLiveAddr" data-options="editable:false"></input></td>
									</tr>
									
									
									  <!-- 
				                        <td align="right">出生日期：</td>
										<td ><input class="easyui-validatebox" type="text" id="birthday"  name = "birthday" data-options="editable:false"></input></td>
				                        
				                        <td align="right">户口类别：</td>
										<td ><input id="IdType" name="IdType" class="easyui-validatebox"  data-options="editable:false"></input>							
										</td>
										
										<td align="right">从业日期：</td>
										<td ><input class="easyui-validatebox" type="text" id="workDate" name="workDate" data-options="editable:false"></input></td>
										 
										<td align="right">职业：</td>
										<td ><input class="easyui-validatebox" type="text" id="occupation" name="occupation" data-options="editable:false"></input></td>
				                        
										
									    <td align="right">居住证号：</td>
										<td ><input class="easyui-validatebox" type="text" id="residenceId" name="residenceId" data-options="editable:false"></input></td>
				                        
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
						<div id = "lelimage"  ></div>
				</div>
				<div id='dataDiv3' style="height:315px;" >
					<div id="unitpopulationInfoList"  ></div>
				</div>
				<div id='dataDiv4' style="height:300px;" >
					<div id="unitImageDlg"  ></div>
				</div>
				<div id='dataDiv5'>
					<div id="imageUrlsDv"></div>
				</div>
				 <div id='dataDiv6'></div>
				
				<div id='dataDivCorporation'>
					<form id="fmCorporation" method="post">
						<input type="hidden" value="" id="id" name = "id"/>
							<table  data-options="region:center,border:false,fit:true,fitColumns:false"  >
									 		
									<tr>
										<td align="right">姓名：</td>
										<td ><input class="easyui-validatebox" type="text" id="coname"  name = "Coname" data-options="editable:false"></input></td>
				                        
				                        <td align="right">性别：</td>
										<td ><input class="easyui-validatebox"  id="cosex" name="cosex" data-options="editable:false"></input></td>
				                     
				                        <td align="right">曾用名：</td>
										<td ><input class="easyui-validatebox" type="text" id="cooldName" name="cooldName" data-options="editable:false"></td>
				                    </tr>
				                       
				                     <tr>
									    
									    <td align="right">民族：</td>
										<td ><input class="easyui-validatebox" type="text" id="conation" name="conation" data-options="editable:false"></input></td>
									    
									    <td align="right">身份证号：</td>
										<td ><input class="easyui-validatebox" type="text" id="cocertificateNum" name="cocertificateNum" data-options="editable:false"></input></td>
									   
									    <td align="right">文化程度：</td>
										<td ><input class="easyui-validatebox" type="text" id="codegreeEducation" name="codegreeEducation" data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">婚姻状况：</td>
										<td ><input id="comaritalSta" name="comaritalSta" class="easyui-validatebox"  data-options="editable:false" ></input></td>
				
									    <td align="right">兵役状况：</td>
										<td ><input id="comilitarySta" name="comilitarySta" class="easyui-validatebox"  data-options="editable:false"></input></td>
									
									    <td align="right">血型：</td>
										<td ><input id="cobloodType" name="cobloodType" class="easyui-validatebox"  data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">身高：</td>
										<td ><input class="easyui-validatebox" type="text" id="coheight" name="coheight" data-options="editable:false"></input></td>
									
									    <td align="right">从业日期：</td>
										<td ><input class="easyui-validatebox" type="text" id="coworkDate" name="coworkDate" data-options="editable:false"></input></td>
										
										<td align="right">职务：</td>
										<td ><input class="easyui-validatebox" type="text" id="copost" name="copost" data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">户籍详址：</td>
										<td ><input class="easyui-validatebox" type="text" id="cohouseRegist" name="cohouseRegist"  data-options="editable:false"></input></td>
									
								     	<td align="right">出生日期：</td>
										<td ><input class="easyui-validatebox" type="text" id="cobirthday"  name = "cobirthday" data-options="editable:false"></input></td>
				                        
				                        <td align="right">固定电话：</td>
										<td ><input class="easyui-validatebox" type="text" id="colandLine" name="colandLine" data-options="editable:false"></input></td>
				                     </tr>
									
									<tr>
									    <td align="right">手机：</td>
										<td ><input class="easyui-validatebox" type="text" id="cotelephone" name="cotelephone" data-options="editable:false"></input></td>
									    
									    <td align="right">微信：</td>
										<td ><input class="easyui-validatebox" type="text" id="coweChatNum" name="coweChatNum" data-options="editable:false"></input></td>
				                        
				                        <td align="right">QQ：</td>
										<td ><input class="easyui-validatebox" type="text" id="coqqNum" name="coqqNum" data-options="editable:false"></input></td>
									</tr>
									
									<tr>
									    <td align="right">户口类别：</td>
										<td ><input id="coIdType" name="coIdType" class="easyui-validatebox"  data-options="editable:false"></input></td>
										
										<td align="right">居住证号：</td>
										<td ><input class="easyui-validatebox" type="text" id="coresidenceId" name="coresidenceId" data-options="editable:false"></input></td>
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
	
	
		<!--  单位人员拍照图片	-->
	<div id="upimageDlg" title="单位人员拍照" class="easyui-dialog" style="width:800px;height:360px; padding: 0px;" closed="true" buttons="#dlg-buttons" data-options=" modal:true">
		<div id="upimagediv"></div>
	</div>
	
	
	
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
	
	
	
	
	
	
	
	
	
<!--  法人,房主信息窗口	  -->	
	<%--<div id="legalOrlandlordInfoDlg" class="easyui-dialog" style="width:960px; height: 350px; padding: 0px;" closed="true" buttons="#dlg-buttons" data-options=" modal:true">
		<form id="fm" method="post">
		<div id="yuyiyiuy"  data-options="region:'center'" style=" padding-left: 90px;" >
		<input type="hidden" value="" id="id" name = "id"/>
			<table  data-options="region:center,border:false,fit:true,fitColumns:false"  >
					<tr>
						<td align="right">房栋号：</td>
						<td ><input class="easyui-validatebox" type="text" id="hBuildingNum"  name = "hBuildingNum" data-options="editable:false"></input></td>

						<td align="right">单元号：</td>
						<td ><input class="easyui-validatebox" type="text" id="hUnitNum" name="hUnitNum" data-options="editable:false">
						</td>
				
						<td align="right">楼层：</td>
						<td ><input class="easyui-validatebox" type="text" id="hFloorNum"  name = "hFloorNum" data-options="editable:false"></input></td>
					</tr>
					
					<tr>
						<td align="right">房间号：</td>
						<td ><input class="easyui-validatebox" type="text" id="roomNumber" name="roomNumber" data-options="editable:false">
						</td>
						<td align="right">姓名：</td>
						<td ><input class="easyui-validatebox" type="text" id="name"  name = "name" data-options="editable:false"></input></td>

						<td align="right">曾用名：</td>
						<td ><input class="easyui-validatebox" type="text" id="oldName" name="oldName" data-options="editable:false">
						</td>
					</tr>

					<tr>
						<td align="right">性别：</td>
						<td ><input class="easyui-validatebox"  id="sex" name="sex" data-options="editable:false"></input>
						</td>

						<td align="right">民族：</td>
						<td ><input class="easyui-validatebox" type="text" id="nation" name="nation" data-options="editable:false"></input></td>
					
						<td align="right">身份证号：</td>
						<td ><input class="easyui-validatebox" type="text" id="certificateNum" name="certificateNum" data-options="editable:false"></input></td>
					</tr>

					<tr>
						<td align="right">文化程度：</td>
						<td ><input class="easyui-validatebox" type="text" id="degreeEducation" name="degreeEducation" data-options="editable:false"></input></td>
						<td align="right">出生日期：</td>
						<td ><input class="easyui-validatebox" type="text" id="birthday"  name = "birthday" data-options="editable:false"></input></td>

						<td align="right">户口类别：</td>
						<td ><input id="IdType" name="IdType" class="easyui-validatebox"  data-options="editable:false"></input>							
						</td>
					</tr>
					<tr >
						<td align="right">人口性质：</td>
						<td ><input id="personType" name="personType" class="easyui-validatebox"  data-options="editable:false" ></input>
						</td>
						<td align="right">婚姻状况：</td>
						<td ><input id="maritalSta" name="maritalSta" class="easyui-validatebox"  data-options="editable:false" ></input>
						</td>

						<td align="right">兵役状况：</td>
						<td ><input id="militarySta" name="militarySta" class="easyui-validatebox"  data-options="editable:false"></input>
						</td>
					</tr>	
					<tr >
						<td align="right">血型：</td>
						<td ><input id="bloodType" name="bloodType" class="easyui-validatebox"  data-options="editable:false"></input>
						</td>

						<td align="right">身高：</td>
						<td ><input class="easyui-validatebox" type="text" id="height" name="height" data-options="editable:false"></input></td>
					
						<td align="right">出租日期：</td>
						<td ><input class="easyui-validatebox" type="text" id="rentDate" name="rentDate" data-options="editable:false"></input></td>
					</tr>

					<tr >
						<td align="right">从业日期：</td>
						<td ><input class="easyui-validatebox" type="text" id="workDate" name="workDate" data-options="editable:false"></input></td>
						<td align="right">职业：</td>
						<td ><input class="easyui-validatebox" type="text" id="occupation" name="occupation" data-options="editable:false"></input></td>

						<td align="right">职务：</td>
						<td ><input class="easyui-validatebox" type="text" id="post" name="post" data-options="editable:false"></input></td>
					</tr>

					<tr >
						<td align="right">现居住地址：</td>
						<td ><input class="easyui-validatebox" type="text" id="actualLiveAddr" name="actualLiveAddr" data-options="editable:false"></input></td>

						<td align="right">固定电话：</td>
						<td ><input class="easyui-validatebox" type="text" id="landLine" name="landLine" data-options="editable:false"></input></td>

						<td align="right">手机：</td>
						<td ><input class="easyui-validatebox" type="text" id="telephone" name="telephone" data-options="editable:false"></input></td>
					</tr>

					<tr>
						<td align="right">QQ：</td>
						<td ><input class="easyui-validatebox" type="text" id="qqNum" name="qqNum" data-options="editable:false"></input></td>
						<td align="right">微信号：</td>
						<td ><input class="easyui-validatebox" type="text" id="weChatNum" name="weChatNum" data-options="editable:false"></input></td>

						<td align="right">人员类别：</td>					
						<td ><input id="pType" name="pType" class="easyui-validatebox"  data-options="editable:false"></input>
						</td>
					</tr>

					<tr>
						<td align="right">居住证号：</td>
						<td ><input class="easyui-validatebox" type="text" id="residenceId" name="residenceId" data-options="editable:false"></input></td>

						<td align="right">版本号：</td>
						<td ><input class="easyui-validatebox" type="text" id="pversion" name="pversion" data-options="editable:false"></input></td>
					</tr>	
					<tr >
						<td align="right">户籍：</td>
						<td colspan="5"><input class="easyui-validatebox" type="text" id="houseRegist" name="houseRegist" style="width:650px" data-options="editable:false"></input></td>
					</tr>

					<tr >
						<td align="right">服务住所：</td>
						<td colspan="5"><input class="easyui-validatebox" type="text" id="serviceAddr" name="serviceAddr" style="width:650px" data-options="editable:false"></input></td>
					</tr>	
				</table>
<!--			</div>-->
		</div>
			<div id = "lelimage"  >
		</div>
		</form>
	</div>
--%><!--  单位员工信息	-->
	<div id="unitpopulationInfoDlg" class="easyui-dialog" style="width:608px; height: 499px; padding: 0px;" closed="true" buttons="#dlg-buttons" data-options=" modal:true">
		<div class="easyui-layout" style="width:606px;height:470px;">
			<div id="upshow"  data-options="region:'center'">
				<div id="unitpopulationInfoList" class="easyui-datagrid" ></div>
			</div>
		</div>
	</div>
	
	<div id="dlgOpenImg" class="easyui-dialog" title="查看" closed="true"  style="width:700px;height:500px;padding:0px">
		<div id="imageOpenDIV"></div>
	</div>
</body>
</html>