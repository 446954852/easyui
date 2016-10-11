var _menus = {
	basic : [ {
		"menuid" : "10",
		"icon" : "icon-sys",
		"menuname" : "基础数据",
		"menus" : [ {
			"menuid" : "111",
			"menuname" : "基础数据1",
			"icon" : "icon-nav",
			"url" : "demo.html"
		}, {
			"menuid" : "113",
			"menuname" : "上传下载导入导出",
			"icon" : "icon-nav",
			"url" : "fileOperation.html"
		}, {
			"menuid" : "115",
			"menuname" : "用户列表",
			"icon" : "icon-nav",
			"url" : "userList.html"
		}, {
			"menuid" : "117",
			"menuname" : "用户列表shiro",
			"icon" : "icon-nav",
			"url" : "user/list"
		}, {
			"menuid" : "119",
			"menuname" : "基础数据15",
			"icon" : "icon-nav",
			"url" : "em/enterpriseChannelObtend.action"
		} ]
	}, {
		"menuid" : "20",
		"icon" : "icon-sys",
		"menuname" : "测试一",
		"menus" : [ {
			"menuid" : "211",
			"menuname" : "测试一11",
			"icon" : "icon-nav",
			"url" : "#"
		}, {
			"menuid" : "213",
			"menuname" : "测试一22",
			"icon" : "icon-nav",
			"url" : "#"
		}, {
			"menuid" : "215",
			"menuname" : "测试一33",
			"icon" : "icon-nav",
			"url" : "#"
		}, {
			"menuid" : "217",
			"menuname" : "测试一44",
			"icon" : "icon-nav",
			"url" : "#"
		} ]
	} ],
	point : [ {
		"menuid" : "20",
		"icon" : "icon-sys",
		"menuname" : "积分管理",
		"menus" : [ {
			"menuid" : "211",
			"menuname" : "积分用途",
			"icon" : "icon-nav",
			"url" : "#"
		}, {
			"menuid" : "213",
			"menuname" : "积分调整",
			"icon" : "icon-nav",
			"url" : "#"
		} ]

	} ]
};



// 设置登录窗口
function openPwd() {
	$('#w').window({
		title : '修改密码',
		width : 300,
		modal : true,
		shadow : true,
		closed : true,
		height : 160,
		resizable : false
	});
}
// 关闭登录窗口
function closePwd() {
	$('#w').window('close');
}
// 修改密码
function serverLogin() {
	var $newpass = $('#txtNewPass');
	var $rePass = $('#txtRePass');

	if ($newpass.val() == '') {
		msgShow('系统提示', '请输入新密码！', 'warning');
		return false;
	}
	if ($rePass.val() == '') {
		msgShow('系统提示', '请再一次输入确认密码！', 'warning');
		return false;
	}

	if ($newpass.val() != $rePass.val()) {
		msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
		return false;
	}
	
	msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + $newpass.val(), 'info');
	$newpass.val('');
	$rePass.val('');
	close();
/*
	$.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
		
		
	})
*/	
}
