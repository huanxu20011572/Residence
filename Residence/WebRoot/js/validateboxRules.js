/**
 * validatebox扩展
 */
$(function(){
	$.extend($.fn.validatebox.defaults.rules, {
		//字母+数字
		alphabetfigure :{
            validator: function(value){     
                return /^[A-Za-z0-9]+$/i.test($.trim(value));     
            },     
            message: '请输入字母A-Z与数字0-9!'   
		},
		uid :{
            validator: function(value){     
                return /^[A-Fa-f0-9]{16}$/i.test($.trim(value));     
            },     
            message: '请输入字母A-F与数字0-9组成16位字符!'   
		},
		name :{
            validator: function(value){     
                return /^[A-Za-z\u4e00-\u9fa5]+$/i.test($.trim(value));     
            },  
            message: '请输入字母或汉字!' 
		},
		//表编号
		boxnumber :{
            validator: function(value){     
                return /^[A-Fa-f0-9]{14,14}$/i.test($.trim(value));     
            },     
            message: '请输入字母A-F(a-f)与数字0-9组成14位字符!'  
		},
		//字母+
		xyz :{
            validator: function(value){     
                return /^[A-Za-z0-9\u4e00-\u9fa5]+$/i.test($.trim(value));     
            },     
            message: '请输入字母A-Z(a-z)、数字0-9和汉字!'   
		},
		//小数验证
		xxx :{
            validator: function(value){     
                return /^-?[0-9]*(\.\d*)?$|^-?0(\.\d*)+$/i.test($.trim(value));     
            },     
            message: '请输入整数或小数!'   
		},
		//手机号码
        mobile : {     
            validator: function(value){     
                return /^1[0-9]{10}$/i.test($.trim(value));     
            },     
            message: '手机号码格式错误!'    
        },
        //email
        email : {     
            validator: function(value){     
                return /^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)[a-zA-Z0-9]{2,4}$/i.test($.trim(value));     
            },     
            message: '电子邮箱格式错误!'    
        },
		/*
		 *bps
		 */
		bps : {
			validator : function (value){
				var regbps = /^[0-9]{1,4}$/;
				return regbps.test(value);
				},
				message :'由1到4位数字组成!'
		},
		//-----------汉字验证-------------
		chinese: {
	        validator: function (value) {
	            return /^[\u0391-\uFFE5]+$/i.test(value);
	        },
	        message: '请输入中文!'
	    },
		/*
		 * ip验证
		 */
        ip: {
            validator: function (value) {
                var regIps = /^(((25[0-5]|2[0-4]\d|1\d{2}|[1-9]\d|[0-9])\.){3}(25[0-5]|2[0-4]\d|1\d{2}|[1-9]\d|[0-9]))$/;
                return regIps.test(value);
            },
            message: 'Ip格式不正确!'
        },
		/*
		 * 长度验证规则
		 */
		lengthRule : {
			validator : function(value, param) {
				return value.length >= param[0] && value.length <= param[1];
			},
			message : '由{0}~{1}个字符组成!'
		},
		/*
		 * 密码验证规则
		 */
//		passwordRule : {
//			validator : function(value, param) {
//				var codeStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";
//				for (var i = 0; i < value.length; i++) {
//					var str = value.charAt(i);
//					if (-1 == codeStr.indexOf(str, 0)) {
//						return false;
//					}
//				}
//				if (!(value.length >= param[0] && value.length <= param[1])) {
//					return false;
//				}
//				return true;
//			},
//			message : '密码由{0}~{1}位的字母、数字、下划线组成！'
//		},
//		/*
//		 * 两次输入一致性验证规则
//		 */
//		equalsRule : {   
//	        validator: function(value,param){
//	            return value == $(param[0]).val();
//	        }, 
//			message : '两次输入不一致！'
//		},
		/*
		 * 数字验证规则
		 */
		numberRule : {   
	        validator: function(value,param){
	        	var codeStr = "0123456789";
	        	for (var i = 0; i < value.length; i++) {
					var str = value.charAt(i);
					if (-1 == codeStr.indexOf(str, 0)) {
						return false;
					}
				}
				return true;
	        }, 
			message : '请输入数字!'
		},
		//空验证
		kong : {
	        validator: function (value) {
	            return /^S+$/i.test(value);
	        },
			message : '输入项为必输项!'
		}
	});
});

