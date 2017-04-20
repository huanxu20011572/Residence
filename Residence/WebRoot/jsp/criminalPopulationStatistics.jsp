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
<title>家庭人员查询</title>
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
		<link
			href="<%=request.getContextPath()%>/echarts/doc/asset/css/echartsHome.css"
			rel="stylesheet">

		<script
			src="<%=request.getContextPath()%>/echarts/doc/example/www/js/echarts.js"></script>
		<script
			src="<%=request.getContextPath()%>/echarts/doc/asset/js/codemirror.js"></script>
		<script
			src="<%=request.getContextPath()%>/echarts/doc/asset/js/javascript.js"></script>
		<script
			src="<%=request.getContextPath()%>/echarts/doc/asset/js/esl/esl.js"></script>
		<link
			href="<%=request.getContextPath()%>/echarts/doc/asset/css/codemirror.css"
			rel="stylesheet">
		<link
			href="<%=request.getContextPath()%>/echarts/doc/asset/css/monokai.css"
			rel="stylesheet">

<script type="text/javascript">
	//Echart图表的全局变量
	$(window).ready(function(){
		getListPage();
//		getChartQuery();
	});
	var jsonObj={
		'xData':[],
		'yData':[]
	};

	//查询方法，带分页
	function getListPage(){
				 $.ajax({
						type:'POST',
						url: "<%=request.getContextPath()%>/residentPopulationController/findCriminalPersonsStatistics.action",
						dataType:'JSON',
						success:function(info){
							var data=info;
							var fields = [];
							var gridData = {};
							
							var fl = {field:"f0",title:"犯罪类型",width:80};
							fields[0]=fl;
							gridData["f0"]='数量';
							
							if(data){
								var val=document.documentElement.clientWidth;
								val = val&&val-100>0?val-100:1;
								for(var i=0;i<data.length;i++){
									var fl = {field:"f"+i+1,title:data[i].criminal,width:parseInt(val/data.length-3)};
									fields[i+1]=fl;
									gridData["f"+i+1]=data[i].count;
								}
							}
							$('#list').datagrid({   
							    data:[gridData],   
							    columns:[fields]   
							});  	
							
//							$('#list').datagrid({   
//							    data:data,   
//							    columns:[[   
//							        {field:'criminal',title:'犯罪类型',width:100},   
//							        {field:'count',title:'数量',width:100}    
//							    ]]   
//							});  
							 var xData=new Array();
						    var yData=new Array();
						    for(var i=0;i<data.length;i++){
						    	xData[i]=data[i].criminal;
						    	yData[i]=data[i].count;
						    }
						    jsonObj.xData=xData;
						    jsonObj.yData=yData;							
							loadChart(jsonObj);
						}
					});
	}
	 //加载图表
	function loadChart(json){
		 require(
        [
            'echarts',
            'echarts/chart/line',
            'echarts/chart/bar',
            'echarts/chart/pie'
        ],
        function (ec) {
        	echart = ec;
        	var myChart = echart.init(document.getElementById('main'));
		var option = {
				title : {
			        text: '重点人口分类统计',
			        subtext: '',
			        x:'center'
			    },
 			    tooltip: {
                    show: true
                },
                xAxis : [
                    {
                        type : 'category',
                        data : json.xData,
//                      axisLabel  : {rotate : 45},
                        name : '犯罪类型'
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        name : '数量'
                    }
                ],
                series : [
                    {
                        "name":"数量",
                        "type":"bar",
                        "data":json.yData,
                        "barWidth":60
                    }
                ]
//				toolbox: {
//				      show : true,
//				      feature : {
//					      dataView : {show: true, readOnly: false},
//					      magicType : {show: true, type: ['line', 'bar']},
//					      restore : {show: true},
//					      saveAsImage : {show: true}
//				      }
//				    },
//				    calculable : true
			};
            // 为echarts对象加载数据 
			myChart.setOption(option);
        }
        )
	}
</script>
</head>
<body>
<!--	<div class="easyui-layout" data-options="fit:true">	-->
<!--	  		-->
<!--			<div id="show"  data-options="region:'center'">-->
<!--				<div style="padding-left:5px;padding-top:0px;">-->
<!--					<div id="list" class="easyui-datagrid" ></div>-->
<!--				</div>-->
<!--			</div>-->
<!--	</div>-->
<div>
	<div id="div1" style='height:100px'>
		<script>
			$(function(){
				var val=document.documentElement.clientHeight;
				var val2=(val/2)<0?1:(val/2);
				val2=val2+"px";
				$("#div3").css("height",(val-100)+'px');
				//$("#div2").css("height",val2);
				$("#main").css("height",(val-100)*0.9+'px');
			});
		</script>
		<div id="div2">
			<div id="list" class="easyui-datagrid" ></div>
		</div>
	</div>
	<div style="padding-top:0px;" id="div3">
		<div id='main' style=""></div> 	
	</div>
</div>
<script type="text/javascript">

	 require.config({
            packages: [
                {
                    name: 'echarts',
                    location: '<%=request.getContextPath()%>/echarts/src',
                    main: 'echarts'
                },
                {
                    name: 'zrender',
                    location: '<%=request.getContextPath()%>/zrender/src',
                    main: 'zrender'
                }
            ]
        });
</script>
</body>

<script>
		
	
	</script>
</html>
