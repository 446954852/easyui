;
function Clearnav() {	
	var pp = $('#wnav').accordion('panels');
	console.log(pp);
	$.each(pp, function(i, n) {
		if (n) {
			var t = n.panel('options').title;
			$('#wnav').accordion('remove', t);
		}
	});
	
	pp = $('#wnav').accordion('getSelected');
	if (pp) {
		var title = pp.panel('options').title;
		$('#wnav').accordion('remove', title);
	}
}

/**
 * 通过JSON数据 生成左侧菜单HTML
 */
function addNav(data) {
	$.each(data, function(i, sm) {
		var menulist = "";
		if(sm.menuname == "基础数据"){
			menulist += '<ul>';
			$.each(sm.menus, function(j, o) {
	//			alert(o.menuname);
				menulist += '<li><div><a ref="' + o.menuid + '" href="#" rel="'
						+ o.url + '" ><span class="icon ' + o.icon
						+ '" >&nbsp;</span><span class="nav">' + o.menuname
						+ '</span></a></div></li> ';
			});
			menulist += '</ul>';
		}else{
			menulist = '<ul id="tt"></ul><ul id="tt2"></ul>';
		}
		$('#wnav').accordion('add', {
			title : sm.menuname,
			content : menulist,
			iconCls : 'icon ' + sm.icon
		});

	});
	
	var pp = $('#wnav').accordion('panels');
	var t = pp[0].panel('options').title;
	$('#wnav').accordion('select', 2);
}

/**
 * 初始化左侧 为左侧菜单li a绑定click事件后生成Tab页面
 */
function InitLeftMenu() {
	
	hoverMenuItem();

	$('#wnav li a').on('click', function() {
		var tabTitle = $(this).children('.nav').text();
		var url = $(this).attr("rel");
		var menuid = $(this).attr("ref");
		var icon = getIcon(menuid, icon);
		addTab(tabTitle, url, icon);
		$('#wnav li div').removeClass("selected");
		$(this).parent().addClass("selected");
		
		return false;
	});
	//练习shiro 暂时去掉树 
//	showMenuTree();

}

/**
 * 菜单项鼠标Hover
 */
function hoverMenuItem() {
	$(".easyui-accordion").find('a').hover(function() {
		$(this).parent().addClass("hover");
	}, function() {
		$(this).parent().removeClass("hover");
	});
}

/**
 * 显示菜单树
 * \WebContent\js\jquery-easyui-1.3.4\demo\tree\tree_data1.json
 */
function showMenuTree() {
	$('#tt').tree({    
//	    url:ly.getWebRootPath()  + '/js/jquery-easyui-1.3.4/demo/tree/tree_data1.json',   
//	    url:ly.getWebRootPath()  + '/js/tree_data1.json',   
	    url:ly.getWebRootPath()  + '/menuController/findAllMenus',   
	    lines : true,
	    checkbox : true
	    /*
	    ,
	    onLoadSuccess : function(node, data){
	    	var t = $(this);
	    	if(data){
	    		alert(JSON.stringify(data));
	    		$(data).each(function(index, d){
	    			if(this.state == "closed") {
	    				t.tree("expandAll");
	    			}
	    		});
	    	}
	    }
	    */
	    
	}); 
	
	$('#tt2').tree({    
	    url:ly.getWebRootPath()  + '/js/tree_data1.json',   
	    lines : true,
	    checkbox : true
	}); 
}

// 获取左侧导航的图标
function getIcon(menuid) {
	var icon = 'icon ';
	$.each(_menus, function(i, n) {
		$.each(n, function(j, o) {
			$.each(o.menus, function(k, m){
				if (m.menuid == menuid) {
					icon += m.icon;
					return false;
				}
			});
		});
	});
	return icon;
}

function addTab(subtitle, url, icon) {
//	alert("subtitle:{0}---url:{1}---icon:{2}".format(subtitle, url, icon));
	if (!$('#tabs').tabs('exists', subtitle)) {
		$('#tabs').tabs('add', {
			title : subtitle,
//			content : createFrame(url),
			href : url,
			closable : true,
			icon : icon
		});
	} else {
		$('#tabs').tabs('select', subtitle);
		$('#mm-tabupdate').click();
	}
	tabClose();
}

function createFrame(url) {
//	alert(ly.getWebRootPath()+"/"+url);
	var s = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
	return s;
}

/**
 * 双击关闭TAB选项卡
 * 为选项卡绑定右键
 */
function tabClose() {
	/* 双击关闭TAB选项卡 */
	$(".tabs-inner").dblclick(function() {
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close', subtitle);
	});
	/* 为选项卡绑定右键 */
	$(".tabs-inner").bind('contextmenu', function(e) {
		$('#mm').menu('show', {
			left : e.pageX,
			top : e.pageY
		});

		var subtitle = $(this).children(".tabs-closable").text();

		//在'#mm'上绑定一个变量currtab, 其值为subtitle
		$('#mm').data("currtab", subtitle);
		$('#tabs').tabs('select', subtitle);
		return false;
	});
}
/**
 * 绑定右键菜单事件
 */ 
function tabCloseEven() {
	
	// 刷新
	$('#mm-tabupdate').click(function() {
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		$('#tabs').tabs('update', {
			tab : currTab,
			options : {
				content : createFrame(url)
			}
		});
	});
	// 关闭当前
	$('#mm-tabclose').click(function() {
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close', currtab_title);
	});
	// 全部关闭
	$('#mm-tabcloseall').click(function() {
		$('.tabs-inner span').each(function(i, n) {
			var t = $(n).text();
			$('#tabs').tabs('close', t);
		});
	});
	// 关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function() {
		$('#mm-tabcloseright').click();
		$('#mm-tabcloseleft').click();
	});
	// 关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function() {
		var nextall = $('.tabs-selected').nextAll();
		if (nextall.length == 0) {
			// msgShow('系统提示','后边没有啦~~','error');
			alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tabs').tabs('close', t);
		});
		return false;
	});
	// 关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function() {
		var prevall = $('.tabs-selected').prevAll();
		if (prevall.length == 0) {
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i, n) {
			//在$(n)查找'a:eq(0) span'
			var t = $('a:eq(0) span', $(n)).text();
			$('#tabs').tabs('close', t);
		});
		return false;
	});

	// 退出
	$("#mm-exit").click(function() {
		$('#mm').menu('hide');
	});
}

/**
 * 一级菜单点击事件
 */
var firstMenuClick = function(){
	$('#css3menu a').click(function() {
		$('#css3menu a').removeClass('active');
		$(this).addClass('active');
		
		var d = _menus[$(this).attr('name')];
//		alert(d);
		Clearnav();
		addNav(d);
		InitLeftMenu();
	});
}
// 弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}

// 本地时钟
function clockon() {
	var now = new Date();
	var year = now.getFullYear(); // getFullYear getYear
	var month = now.getMonth();
	var date = now.getDate();
	var day = now.getDay();
	var hour = now.getHours();
	var minu = now.getMinutes();
	var sec = now.getSeconds();
	var week;
	month = month + 1;
	if (month < 10)
		month = "0" + month;
	if (date < 10)
		date = "0" + date;
	if (hour < 10)
		hour = "0" + hour;
	if (minu < 10)
		minu = "0" + minu;
	if (sec < 10)
		sec = "0" + sec;
	var arr_week = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
	week = arr_week[day];
	var time = "";
	time = year + "年" + month + "月" + date + "日" + " " + hour + ":" + minu
			+ ":" + sec + " " + week;

	$("#bgclock").html(time);

	var timer = setTimeout("clockon()", 200);
}

function d(){
	alert(666666);
}
