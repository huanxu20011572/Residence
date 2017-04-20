function setFormReadOnly(){
/*	$("#fmconfirm").show();
	$("#fm .panel.layout-panel.layout-panel-center").css("top","5px");
	$("#fm .panel.layout-panel.layout-panel-south").show();
	$("#fm").removeClass("fm1");
	$("#fm").addClass("fm0");*/
	$("#fmconfirm").hide();
	$("#fmcancel").hide();
	$("form :input").attr("readonly", true);
	$("form .easyui-datetimebox").datebox({ disabled: true });
	$("form .easyui-datebox").datebox({ disabled: true });
	$("form .easyui-combobox").datebox({ disabled: true });
};

function setFormCanBeEdited(){
	//$("#fm .panel.layout-panel.layout-panel-south").hide();
/*	$("#fmconfirm").hide();
	$("#fm").removeClass("fm0");
	$("#fm").addClass("fm1");
	$("#fm :input").attr("readonly", "readonly");
	$("#fm .easyui-datetimebox").datebox({ disabled: true });	
	$("#fm .easyui-datebox").datebox({ disabled: true });
	$("#fm .easyui-combobox").datebox({ disabled: true });*/
};
function setOpen($p_div){
	$("#dataDiv1").hide();
	$("#dataDiv2").hide();
	$("#dataDiv3").hide();
	$("#dataDiv4").hide();
	$("#dataDiv5").hide();
	$("#dataDivCorporation").hide();
	$("#dataDivCorporation1").hide();
	if($p_div){
		$p_div.show();
	}
	 
	
}