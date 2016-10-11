//工具JS


var ly = $.extend({}, ly);/* 全局对象 */  

/**
 * 获得项目根路径
 * 
 */
ly.getWebRootPath = function(){
	var curPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var pos = curPath.indexOf(pathName);
	var localhostPath = curPath.substring(0, pos);
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPath + projectName);
}


/**
 * 扩展字符串方法format 通过占位符方式拼接字符串
 */
String.prototype.format=function() 
{ 
  if(arguments.length==0) return this; 
  for(var s=this, i=0; i<arguments.length; i++) 
    s=s.replace(new RegExp("\\{"+i+"\\}","g"), arguments[i]); 
  return s; 
}; 

/**
 * 将form表单数据封装成Json对象
 */
ly.serializeObject = function(form){
  var o = {};  
  $.each(form.serializeArray(), function() {  
      if (o[this.name]) {  
    	  //判断是否是数组
           if (!o[this.name].push) {  
               o[this.name] = [o[this.name]];  
           }  
           o[this.name].push(this.value || '');  
       } else {  
           o[this.name] = this.value || '';  
       }  
   });  
   return o;  
}

/**
 * 将form表单数据封装成Json数组对象
 * step为数组元素object的属性个数
 */
ly.serializeArr = function(form, step){
	var serArr = form.serializeArray();
	var len = serArr.length;
	var arrData = [];
	var obj = {};
	for(var i = 0;i < len;i++){
		if(i == 0){
			obj[serArr[i].name]  = serArr[i].value;
		}else{
			if(i%step != 0){
				obj[serArr[i].name]  = serArr[i].value;
				if(i == len - 1){
					arrData.push(obj);
				}
			}else{
				arrData.push(obj);
				obj = {};
				obj[serArr[i].name]  = serArr[i].value;
			}
		}
	}
	return arrData;
}


/**
 *  不正确 不能封装同名多值的情况
 */
ly.serializeObject2 = function(form){
  var o = {};  
  $.each(form.serializeArray(), function() {  
      if (o[this.name]) {  
           o[this.name] =  o[this.name] + "," + this.value;  
       } else {  
           o[this.name] = this.value || '';  
       }  
   });  
   return o;  
}
/**
 * validatebox验证扩展
 * 长度最小值
 * 
 */
$.extend($.fn.validatebox.defaults.rules, {    
    minLength: {    
        validator: function(value, param){    
            return value.length >= param[0];    
        },    
        message: 'Please enter at least {0} characters.{1}'   
    }    
});  

/**
 * validatebox验证扩展
 * 密码确认一致
 * 
 */
$.extend($.fn.validatebox.defaults.rules, {    
    eqPassword: {    
        validator: function(value,param){    
            return value == $(param[0]).val();    
        },    
        message: 'Field do not match.'   
    },
    NAME: {
        validator: function (value, param) {
            return /^[\u0391-\uFFE5\w]+$/.test(value);
        },
        message: '登录名称只允许汉字、英文字母、数字及下划线。'
    }
});  

/**
 * datetimebox编辑器扩展
 */
$.extend($.fn.datagrid.defaults.editors, {    
	datetimebox: {    
        init: function(container, options){    
            var editor = $('<input/>').appendTo(container); 
            options.editable = false;
            $(editor).datetimebox(options);
            return editor;    
        },    
        getValue: function(target){    
            return $(target).datetimebox("getValue");    
        },    
        setValue: function(target, value){    
            $(target).datetimebox("setValue", value);    
        },    
        resize: function(target, width){    
            $(target).datetimebox("resize", width);    
        },
        destroy: function(target){
        	$(target).datetimebox("destroy");    
        }
    }    
});  


/**
 * 动态 删除、添加 编辑器扩展
 */
$.extend($.fn.datagrid.methods, {
	addEditor : function(jq, param) {
		if(param instanceof Array){
			$.each(param, function(index, item) {
				var e = $(jq).datagrid("getColumnOption", item.field);
				e.editor = item.editor;
			});
		}else{
			var e = $(jq).datagrid("getColumnOption", param.field);
			e.editor = param.editor;
		}
	},
	removeEditor : function(jq, param) {
		if(param instanceof Array){
			$.each(param, function(index, item) {
				var e = $(jq).datagrid("getColumnOption", item);
				e.editor = {};
			});
		}else{
			var e = $(jq).datagrid("getColumnOption", param);
			e.editor = {};
		}
	}
	
}); 

