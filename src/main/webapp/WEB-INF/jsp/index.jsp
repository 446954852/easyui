<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/tag.jsp"%>
<html>
	<head>
	<TITLE>药品采购平台new index</TITLE>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<base href="${baseurl}">
	<%@ include file="/WEB-INF/jsp/common_css.jsp" %>
	<LINK rel="stylesheet" type="text/css" href="styles/login.css">
	<%@ include file="/WEB-INF/jsp/common_js.jsp"%>
	<script type="text/javascript" src="js/index.js" charset="UTF-8"></script>
		<script type="text/javascript" charset="utf-8">
			var blayout;
			var centerTitle;
			var centerPanel;
			$(function(){
				blayout = $("#blayout").layout();
				centerTitle = $("#centerTitle");
				
				centerTitle.on("click",function(){
					centerPanel = blayout.layout("panel", "center");
					console.info(centerPanel);
					var ops = centerPanel.panel("options");
					console.info(ops);
					alert(ops.title);
				});
				
				$("#addEast").on("click", function(){
					blayout.layout("add",{
							region : "east",
							title : "East",
							width : 100,
							iconCls : "icon-reload",
							split : false
						}
					)
				});
			})
		</script>
		
	</head>
	
	<body id="blayout" style="overflow-y: hidden"  scroll="no"> 
		<noscript>
			<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
			    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
			</div>
		</noscript>
		<div data-options="region:'north',split:true,collapsible:false,border:false" 
		style="overflow: hidden; height: 30px;background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
	        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
<script type="text/javascript" charset="utf-8">
	$(function() {
		
		openPwd();
	
		$('#editpass').click(function() {
			$('#w').window('open');
		});
	
		$('#btnConfirm').click(function() {
			serverLogin();
		})
	
		$('#btnCancel').click(function() {
			closePwd();
		})
	
		$('#loginOut').click(function() {
			$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
				if (r) {
					location.href = ly.getWebRootPath() + "/logout";
				}
			});
			//防止a标签提交事件
			return false;
		})
	});
</script>
<span style="float:right; padding-right:20px;" class="head">
		欢迎您：${activeUser.username}&nbsp;&nbsp;
	 <a href="#" id="editpass">修改密码</a> 
	 <a href="#" id="loginOut">安全退出</a>
</span>
<span style="padding-left:10px; font-size: 16px; float:left;">
	<img src="images/blocks.gif" width="20" height="20" align="absmiddle"/>
	 我的帐本
</span>
<ul id="css3menu" style="padding:0px; margin:0px;list-type:none; float:left; margin-left:40px;">
	<li>
		<a name="basic" class="active"  href="javascript:void(0);" title="基础数据">基础数据</a>
	</li>
	<li>
		<a name="point" href="javascript:void(0);" title="积分管理">积分管理</a>
	</li>
</ul>    
	    </div> 
	      
	    <div data-options="region:'south',split:true"  style="height: 30px; background: #D2E0F2; ">
	   			<div class="footer">By ly Email:446954852@qq.com</div>
	    </div>   
	    <div id="west" data-options="region:'west',title:'导航菜单',split:true,hide:true,href:'west.html'" style="width:300px;"></div>   
	    <div id="mainPanle" data-options="region:'center',href:'welcome.html'" style="padding:0px;background:#eee;overflow-y:hidden;"></div>   
	
		<!--修改密码窗口start-->
	    <div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
	        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;background: #fafafa;">
	        <div class="easyui-layout" fit="true">
	            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
	                <table cellpadding=3>
	                    <tr>
	                        <td>新密码：</td>
	                        <td><input id="txtNewPass" type="Password" class="txt01" /></td>
	                    </tr>
	                    <tr>
	                        <td>确认密码：</td>
	                        <td><input id="txtRePass" type="Password" class="txt01" /></td>
	                    </tr>
	                </table>
	            </div>
	            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
	                <a id="btnConfirm" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >确定</a>
	                <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
	            </div>
	        </div>
	    </div>
	    <!--  修改密码窗口end  -->
	    
	   <!--  选项卡右键菜单start  -->
	   <div id="mm" class="easyui-menu" style="width:150px;">
			<div id="mm-tabupdate">刷新</div>
			<div class="menu-sep"></div>
			<div id="mm-tabclose">关闭</div>
			<div id="mm-tabcloseall">全部关闭</div>
			<div id="mm-tabcloseother">除此之外全部关闭</div>
			<div class="menu-sep"></div>
			<div id="mm-tabcloseright">当前页右侧全部关闭</div>
			<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
			<div class="menu-sep"></div>
			<div id="mm-exit">退出</div>
		</div>
	    <!--  选项卡右键菜单end  -->
	    
	    
	</body>
		
</HTML>
