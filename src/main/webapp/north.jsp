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