Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1, //month 
		"d+" : this.getDate(), //day 
		"h+" : this.getHours(), //hour 
		"m+" : this.getMinutes(), //minute 
		"s+" : this.getSeconds(), //second 
		"q+" : Math.floor((this.getMonth() + 3) / 3), //quarter 
		"S" : this.getMilliseconds()
	// millisecond
	}

	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}

	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
					: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
}

function publishTimeFormatter(val,row)
{
	var date = new Date(val);
	if(val == 0){
		return "��δ����";
	}
	return date.format("yyyy-MM-dd hh:mm:ss");
}

function timeFormatter(val,row)
{  
	if(val){
	var date = new Date(val);
	return date.format("yyyy-MM-dd hh:mm:ss");
	}else{
		return "";
	}
}
function dateFormatter(val,row)
{
	if(val=="0"){
		return "";
	}
	if(val){
	var date = new Date(val);
	return date.format("yyyy-MM-dd");
	}else{
		return "";
	}
}
