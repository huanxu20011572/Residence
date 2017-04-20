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
<title>住房信息查询</title>

<script type="text/javascript">
	$(window).ready(function(){
		setFormReadOnly();
		getListPage();
		$('#dlg1').dialog('close');
		$('#dlg2').dialog('close');
		$('#dlg3').dialog('close');
		$('#dlg5').dialog('close');
		$('#dlg6').dialog('close');
		//$('#dlgOpenImg').dialog('close');
	});
//单位名 工商执照号 单位组织结构代码
	//查询方法，带分页
	function getListPage(){
				$('#list').datagrid({			
					url: "<%=request.getContextPath()%>/houseController/getListPage.action",
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
						{field:'hid',title:'hid',hidden:true},
						{field:'haddr',title:'实际房址',width:80},
						{field:'hname',title:'房屋名称',width:60},
						{field:'hbuildingNum',title:'房栋号',width:50},
						{field:'hunitNum',title:'单元号',width:50},
						{field:'hfloorNum',title:'楼层',width:50},
						{field:'hroomNum',title:'房间号',width:50},
						{field:'hstructure',title:'房屋性质',width:60},
						{field:'hpropertyRight',title:'使用形式',width:60},
						{field:'hsecurityStatus',title:'安全状况',width:60},
						{field:'rentalTime',title:'出租时间',width:80},
						{field:'rentalArea',title:'出租面积',width:60},
						{field:'rentalRoomNum',title:'出租间数',width:60},
						{field:'rentalRoomDate',title:'出租日期',width:80},
						{field:'policeOperateArea',title:'警务负责区',width:80},
						{field:'operateRow',title:'委组',width:80},
						{field:'chargePoliceNum',title:'责任区民警编号',width:100}
						//{field:'landlordId',title:'房主ID号',hidden:false},					
						//{field:'imageUrls',title:'房子图片URL',hidden:false},
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
						$('#hid').val(row[0].hid);
							openDialog('修改信息','0');							
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
						$('#hid').val(row[0].hid);
							openDialog('详细信息','1');							
						}
					}
				},
				{
					id:'btncut',
					text:'删除',
					iconCls:'icon-cut',
					handler:function(){
						var row = $('#list').datagrid('getChecked');
						houseDel(row);
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
						url: "<%=request.getContextPath()%>/houseController/updateHouse.action",
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
	function houseDel(rows){
		var hid ="";
		  if(rows != ""){
			  for(var i = 0; i < rows.length; i++){
				  hid += rows[i].hid +"," ;
			  }
			  $.messager.confirm('删除确认', '確定要删除选中的数据吗', function(r){
					if (r){
						 $.ajax({
							type:'POST',
							url: "<%=request.getContextPath()%>/houseController/deleteHouse.action",
							data : "hid=" + hid,
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
			var fileName = "住房信息表";
			var type = "house";
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

	function showDataDiv1(diff){
		setOpen($("#dataDiv1"));
  		var data =$('#list').datagrid('getChecked');
//  			$('#hid').val(data[0].hid);		  			
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
			//$('#rentalTime').datetimebox('setValue',data[0].rentalTime);
			$('#rentalArea').val(data[0].rentalArea);
			$('#rentalRoomNum').val(data[0].rentalRoomNum);	
			$('#rentalRoomDate').val(data[0].rentalRoomDate);					
			//$('#rentalRoomDate').datetimebox('setValue',data[0].rentalRoomDate);
			$('#policeOperateArea').val(data[0].policeOperateArea);
			$('#operateRow').val(data[0].operateRow);
			$('#rentType').val(data[0].rentType);
			var layoutDiagramUrl=data[0].layoutDiagramUrl;
			var imageUrls=layoutDiagramUrl.split(";");
			var imageUrlsStr="<table><tr>";
			for(var i=0;i<imageUrls.length;i++){
				imageUrlsStr+="<td><img src='../image/"+imageUrls[i]+"'/></td>";
			}
			imageUrlsStr+="</tr></table>";
			$("#imageUrlsDv").html(imageUrlsStr);
			$('#chargePoliceNum').val(data[0].chargePoliceNum);								
			$('#version').val(data[0].version);
			/*if(diff=='0')
			{
				$("#btnLa").hide();
				setFormReadOnly();
			}else{
				$("#btnLa").show();
				setFormCanBeEdited();
			}	*/
	}
		
	//打开Dialog层
	function openDialog(titleName,diff){
		  $('#dlg').dialog('open').dialog('setTitle',titleName);
		  showDataDiv1(diff);																												  			
	}
	//房子户型图片
	function houseImage(){
		//$('#dlg1').dialog('open');
			setOpen($("#dataDiv4"));
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
							$("#layoutimageUrlsDv").html(imageUrlsStr);*/
							_initRollImgs(mediaFiles,"layoutimageUrlsDv");
						}
			});
	}
	//此房子的的拍照
	function housePhotoImages()
	{
		setOpen($("#dataDiv5"));
		var rows = $('#list').datagrid('getChecked');
		var photosImages=rows[0].imageUrls;
		//$('#dlg5').dialog('open');
		$.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/mediaFileController/selectMediaFiles.action?modeId="+rows[0].hid+"&source=201",
						dataType:'JSON',
						success:function(info){
							var mediaFiles=info;
							
							/*var imageUrlsStr="<table align='center'><tr>";
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
			//查询
	function searchData(){
		var shbuildingNum = $('#shbuildingNum').val();
		var shunitNum = $('#shunitNum').val();
		if(shbuildingNum==''&&shunitNum==''){
			getListPage();
			return;
		}
		var url = "<%=request.getContextPath()%>/houseController/houseQuery.action?shbuildingNum="+shbuildingNum+"&shunitNum="+shunitNum;
		$('#list').datagrid({url: url});
		$('#list').datagrid("reload");
	}
	function searchPopulation(personType){
		var rows =$('#list').datagrid('getChecked');
		var id=rows[0].hid;
		 $.ajax({
					type:'POST',
					url: "<%=request.getContextPath()%>/residentPopulationController/selectHousePopulation.action?pType="+personType+"&hId="+id,
					//data:"pType="+personType+"&hId="+id,
					dataType : "json",
					success:function(info){
						if(personType=='1'){
							setOpen($('#dataDiv2'));
							var data =info;
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
							
							var photosImages=data[0].imgPersonUrl;
							var pId=data[0].id;
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
										//	$('#dlg2').dialog('open');
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
							   		{field:'id',title:'照片',width:45,align:'center',formatter:function(value, row, index){
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
									//{field:'version',title:'版本号',width:50},
								]]   
							});
							//$('#dlg3').dialog('open');
						}	
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
												var mediaFiles=minfo;

												$('#dlg6').dialog('open');
												/*var imageUrlsStr="<table align='center'><tr>";
												for(var i=0;i<mediaFiles.length;i++){
													imageUrlsStr+="<td><img src='../image/"+mediaFiles[i].physicalName+"'/></td>";
												}
												imageUrlsStr+="</tr></table>";
												$("#imageUrlsDv2").html(imageUrlsStr);*/
	
												_initRollImgs(mediaFiles,"imageUrlsDv2");
												
												}});
	}
</script>
</head>
<body>   
<!--  房栋号  单元号-->
	<div class="easyui-layout" data-options="fit:true">
	  		<div id="choose" data-options="region:'north'" style="height:50px;background-color:#F5F5F5">
	  			<div style="padding-left:5px;padding-top:10px;">
		  			<span>房栋号:
						<input class="easyui-validatebox" type="text" style="width:130px;"  id="shbuildingNum" name ="shbuildingNum"/></span>
						&nbsp;&nbsp;&nbsp;				
					<span>单元号:
						<input class="easyui-validatebox" type="text" style="width:130px;"  id="shunitNum" name = "shunitNum"/></span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchData()">查询</a>		
				</div>
	  		</div>  		
	  		
			<div id="show"  data-options="region:'center'">
				<div id="list" class="easyui-datagrid" ></div>
			</div>
	</div>
	<%--
	<div id="dlg5" class="easyui-dialog" title="房屋拍照" data-options="iconCls:'icon-save',modal:true" style="width:500px;height:300px;padding:10px">
		<div id="imageUrlsDv"></div>
	</div>

	<div id="dlg1" class="easyui-dialog" title="房屋户型图" data-options="iconCls:'icon-save',modal:true" style="width:500px;height:300px;padding:10px">
		<div id="layoutimageUrlsDv"></div>
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
						<td ><input class="easyui-validatebox"  id="sex" name="sex" ></input></td>
						<td align="right">民族：</td>
						<td ><input class="easyui-validatebox"  id="nation" name="nation" ></input></td>
					</tr>
					<tr >
						<td align="right">出生日期：</td>
						<td ><input class="easyui-validatebox" type="text" id="birthday" name="birthday" ></input></td>

						<td align="right">成员关系：</td>
						<td ><input class="easyui-validatebox" type="text" id="relation" name="relation" ></input></td>
					</tr>															
					<tr >
						<td align="right">身份证号：</td>
						<td ><input class="easyui-validatebox" type="text" id="certificateNum" name="certificateNum" ></input></td>

						<td align="right">文化程度：</td>
						<td ><input class="easyui-validatebox" type="text" id="degreeEducation" name="degreeEducation" ></input></td>
					</tr>

					<tr >
						<td align="right">婚姻状况：</td>
						<td ><input class="easyui-validatebox" type="text" id="maritalSta" name="maritalSta" ></input></td>
						<tr >
						<td align="right">人口性质：</td>
						<td ><input class="easyui-validatebox" type="text" id="personType" name="personType" ></input></td>
					</tr>	
						<td align="right">兵役状况：</td>
						<td ><input class="easyui-validatebox" type="text" id="militarySta" name="militarySta" ></input></td>
					</tr>											
					<tr>
						<td align="right">暂住编码：</td>
						<td ><input class="easyui-validatebox" type="text" id="tempLiveNo" name="tempLiveNo" ></input></td>

						<td align="right">暂住日期：</td>
						<td ><input class="easyui-validatebox"  id="tempLiveDate"   type="text" name="tempLiveDate" ></input></td>
					</tr>															
					<tr >
						<td align="right">血型：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="bloodType" name="bloodType" ></input></td>
						<td align="right">身高：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="height" name="height" ></input></td>
					</tr>
					
					<tr >
						<td align="right">职业：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="occupation" name="occupation" ></input></td>

						<td align="right">职务：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="post" name="post" ></input></td>
					</tr>

					<tr >
						<td align="right">户籍：</td>
						<td colspan="3"><input class="easyui-validatebox" type="text" id="houseRegist" name="houseRegist" style="width:380px;" ></input></td>
					</tr>

					<tr >
						<td align="right">服务住所：</td>
						<td colspan="3"><input class="easyui-validatebox" type="text" id="serviceAddr" name="serviceAddr" style="width:380px;" ></input></td>
					</tr>	
					<tr >
						<td align="right">现居住地址：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="actualLiveAddr" name="actualLiveAddr"  ></input></td>

						<td align="right">固定电话：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="landLine" name="landLine" ></input></td>
					</tr>
					<tr>
						<td align="right">手机：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="telephone" name="telephone" ></input></td>

						<td align="right">QQ：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="qqNum" name="qqNum" ></input></td>
					</tr>	
					<tr >
						<td align="right">微信号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="weChatNum" name="weChatNum" ></input></td>

						<td align="right">人员类别：</td>					
						<td align="right"><input class="easyui-validatebox"  id="pType" name="pType" ></input></td>
					</tr>
					<tr>
						<td align="right">租住时间：</td>
						<td align="right"><input class="easyui-validatebox"  id="rentDate" name="rentDate" ></input></td>

						<td align="right">暂住事由：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="rentReason" name="rentReason" ></input></td>
					</tr>
					<tr>
						<td align="right">居住时间：</td>
						<td align="right"><input class="easyui-validatebox" id="liveDate" name="liveDate" ></input></td>

						<td align="right">版本号：</td>
						<td align="right"><input class="easyui-validatebox" type="text" id="owVersion" name="owVersion"></input></td>
					</tr>																							
				</table>
				<div style="padding-top: 5px">
					<div id="imageUrlsDv1"></div>
				</div>
	</div>
	<div id="dlg3" class="easyui-dialog" title="家庭人员信息列表" data-options="iconCls:'icon-save',modal:true" style="width:700px;height:200px;padding:0px">
		<table id="dg"></table>
	</div>--%>
	<div id="dlg6" class="easyui-dialog" title="家庭人员拍照" style="width:800px;height:360px;padding:0px">
		<div id="imageUrlsDv2"></div>
	</div>
	<div id="dlg" class="easyui-dialog" style="width:1100px; height: 450px; padding: 0px;" closed="true" buttons="#dlg-buttons" data-options=" modal:true">
		<div id='dataDiv6'></div>
			<div class="easyui-layout" style="width:1090px;height:420px;">
				<div id='btnLa' data-options="region:'north'" style="height:46px;background:#fafafa;padding-top: 5px;">
					<table align="center">
							<tr>
								<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="showDataDiv1()">房屋基本信息</a></td>
								<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchPopulation('1')">房主信息</a></td>
								<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchPopulation('2')">实有人口信息</a></td>
								<td><a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'"  onclick="houseImage()">房屋户型图</a></td>
								<td><a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'"  onclick="housePhotoImages()">房屋照片</a></td>
							</tr>	
					</table>
				</div>
				<div data-options="region:'south'" style="height:46px;background:#fafafa;padding-top: 5px;">
					<table align="center">
						<tr>
							<td><a href="#" id ='fmconfirm' class="easyui-linkbutton" iconCls="icon-ok" onclick="update()">确认</a></td>
							<td><a href="#" id ='fmcancel' class="easyui-linkbutton" iconCls="icon-cancel" onclick="d_close()">取消</a></td>
						</tr>
					</table>
				</div>
				
				<div data-options="region:'center'" style="background:#fafafa;padding-top: 5px;" align="center">
					<div id='dataDiv1'>
						<form id="fm" method="post">
							<input type="hidden" value="" id="hid" name = "hid"/>
				<!--		<input type="hidden" value="" id="landlordId" name = "landlordId"/>-->
				<!--		<input type="hidden" value="" id="imageUrls" name = "imageUrls"/>-->
				<!--		<input type="hidden" value="" id="layoutDiagramUrl" name = "layoutDiagramUrl"/>-->
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
					</div>
					<div id='dataDiv2'>
						<form id="fm2" method="post">
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
							
							<%--<tr>
								<td align="right">版本号：</td>
								<td align="right"><input class="easyui-validatebox" type="text" id="owVersion" name="owVersion"></input></td>
							</tr>--%>	
							<tr >
							</tr>
							<tr >
							</tr>
							<!-- 
							<td align="right">成员关系：</td>
								<td ><input class="easyui-validatebox" type="text" id="relation" name="relation" ></input></td>
							 <td align="right">暂住日期：</td>
								<td ><input class="easyui-validatebox"  id="tempLiveDate"   type="text" name="tempLiveDate" ></input></td>
								<td align="right">职业：</td>
								<td ><input class="easyui-validatebox" type="text" id="occupation" name="occupation" ></input></td>
								<td align="right">职务：</td>
								<td ><input class="easyui-validatebox" type="text" id="post" name="post" ></input></td>
								 
							   <td align="right">租住时间：</td>
								<td ><input class="easyui-validatebox"  id="rentDate" name="rentDate" ></input></td>
							
								<td align="right">暂住事由：</td>
								<td ><input class="easyui-validatebox" type="text" id="rentReason" name="rentReason" ></input></td>
								<td align="right">居住时间：</td>
								<td ><input class="easyui-validatebox" id="liveDate" name="liveDate" ></input></td>
							 
								<td align="right">人口性质：</td>
								<td ><input class="easyui-validatebox" type="text" id="personType" name="personType" ></input></td>
								 <td align="right">暂住编码：</td>
								<td ><input class="easyui-validatebox" type="text" id="tempLiveNo" name="tempLiveNo" ></input></td>
							
							 -->																						
							</table>
						</form>
						<div id="imageUrlsDv1"></div>
					</div>
					<div id='dataDiv3' style="height:320px;">
						<div id="datagrid3"  ></div>
					</div>
					<div id='dataDiv4'>
						<div id="layoutimageUrlsDv"></div>
					</div>
					<div id='dataDiv5'>
						<div id="imageUrlsDv"></div>
					</div>
					
				</div>
			</div>

	</div>
	<div id="dlgOpenImg" class="easyui-dialog" title="查看" closed="true"  style="width:700px;height:500px;padding:0px">
		<div id="imageOpenDIV"></div>
	</div>
</body>
</html>