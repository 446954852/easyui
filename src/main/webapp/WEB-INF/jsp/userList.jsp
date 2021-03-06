<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userList</title>
</head>
<body>
	<script type="text/javascript" charset="utf-8">
	var datagrid;
	$(function(){
		var editRow = undefined;
		datagrid = $("#datagrid").datagrid({
			url: ly.getWebRootPath() + "/user/query",
			fit:true,
			fitColumns:true,//fitColumns:false--frozenColumns有效
			border:false,//整个table的边框
			iconCls:"icon-save",
			nowrap:true,
			pagination:true,
			pageSize:5,
			pageList:[5,10,15,20,50,100],
			sortOrder:"desc",
			sortName:"userId",
			idField:"userId",
			frozenColumns:[[ {title:"编号",width:100,sortable:true,checkbox:true},
					          {title:"用户名",field:"username",width:100,sortable:true,align:"right",editor:{
					        		type:"validatebox",
					        		options:{
					        			required:true,
					        		}
					          },styler:function(value, rowData, rowIndex){
					        	  if(value == "admin8"){
					        		  return 'background-color:#ffee00;color:red;';
					        	  }
					          }}]],
			columns:[[
			          {title:"密码",field:"password",width:100,editor:{
			        		type:"validatebox",
			        		options:{
			        			required:true
			        		}
			          },formatter:function(value, rowData, rowIndex){
			        	  return "******";
			          }},
			          {title:"创建时间",field:"createDateTime",width:100,editor:{
			        		type:"datetimebox",
			        		options:{
			        			required:true
			        		}
			          }},
			          {title:"最后修改时间",field:"modifyDateTime",width:100,editor:{
			        		type:"datetimebox",
			        		options:{
			        			required:true
			        		}
			          }},{title:"操作",field:"userId",width:100,formatter:function(value, rowData, rowIndex){
			        	  return "<button onclick=edit("+rowIndex+")>编辑</button><button>删除</button>";
			          }}
			]],
			rowStyler:function(rowIndex, rowData){
				if(rowData.username == "admin6"){
					return 'background-color:#ffee00;color:red;';
				}
			},
			toolbar:[
			         {
					text:'增加',
					iconCls:"icon-add",
					handler:function(){
						if(editRow != undefined){
							datagrid.datagrid("endEdit", editRow);
						}
						if(editRow == undefined){
							changeEditorAddRow();
							datagrid.datagrid("insertRow",
								{
								index:0,
								row:{"username":"u","password":"p"}
								}
							);
							datagrid.datagrid("beginEdit", 0);
							editRow = 0;
						}
					}
				},'-',
				 {
					text:'删除',
					iconCls:"icon-remove",
					handler:function(){
						var selRows = datagrid.datagrid("getSelections");
						console.info(selRows);
						if(selRows.length > 0){
							$.messager.confirm("请确认", "您确定要删除当前所有选中数据吗" , function(b){
								alert(JSON.stringify(selRows));
								if(b){
									$.ajax({
										url : ly.getWebRootPath() + "/user/delete",
										data : JSON.stringify(selRows),
// 										data : selRows,
										type : "POST",
										dataType : "json",
										contentType :  "application/json;charset=utf-8",
										success : function(r){
											$.messager.show({msg:r.msg, title:"提示"});
											datagrid.datagrid("load");
											datagrid.datagrid("unselectAll");
										}
									}); 
// 									$.messager.alert("提示", "确认成功");
								}
							});
						}else{
							$.messager.alert("提示", "没有选中要删除的数据");
						}
					}
				},'-', {
					text:'修改',
					iconCls:"icon-edit",
					handler:function(){
						var selRows = datagrid.datagrid("getSelections");
						console.info(selRows);
						var len = selRows.length;
						switch(len){
							case 0:
								$.messager.alert("提示" , "没有选中数据");
								break;
							case 1:
								//$.messager.alert("提示" , "OK");
								changeEditorEditRow();
								var index = datagrid.datagrid("getRowIndex", selRows[0]);
								if(editRow != undefined){
									datagrid.datagrid("endEdit", editRow);
								}
								if(editRow == undefined){
									datagrid.datagrid("beginEdit", index);
									editRow = index;
									datagrid.datagrid("unselectAll");
								}
								break;
							default:
								$.messager.alert("提示" , "只能选中一条数据");
								break;
						}
						
					}
				},'-', {
					text:'保存',
					iconCls:"icon-save",
					handler:function(){
						datagrid.datagrid("endEdit", editRow);
					}
				},'-', {
					text:'取消编辑',
					iconCls:"icon-redo",
					handler:function(){
						editRow = undefined;
						datagrid.datagrid("rejectChanges");
						datagrid.datagrid("unselectAll");
					}
				},'-'
			],
			onAfterEdit:function(rowIndex, rowData, changes){
				console.info(rowData);
// 				console.info(changes);
				var inserted = datagrid.datagrid("getChanges", "inserted");
				console.info(inserted);
				var updated = datagrid.datagrid("getChanges", "updated");
				console.info(updated);
				var url = "";
				if(inserted && inserted.length > 0){
					url = ly.getWebRootPath() + "/user/add";
				}
				if(updated && updated.length > 0){
					url = ly.getWebRootPath() + "/user/edit";
				}
				$.ajax({
					url : url,
					data : rowData,
					dataType : "json",
					success : function(r){
						if(r && r.success){
							//提交所有从加载或者上一次调用acceptChanges函数后更改的数据。
							datagrid.datagrid("acceptChanges");
							$.messager.show({msg:r.msg,title:"成功 "});
						}else{
							datagrid.datagrid("rejectChanges");
							$.messager.alert("错误", r.msg, "error");
						}
						editRow = undefined;
						datagrid.datagrid("load");
						datagrid.datagrid("unselectAll");
					},
					error: function(r){
						console.info(r);
						editRow = undefined;
						datagrid.datagrid("unselectAll");
					}
				});
			},
			onDblClickRow:function(rowIndex, rowData){
				if(editRow == undefined){
					changeEditorEditRow();
					datagrid.datagrid("beginEdit", rowIndex);
					editRow = rowIndex;
					datagrid.datagrid("unselectAll");
					datagrid.datagrid("selectRow", rowIndex);
				}else{
					datagrid.datagrid("endEdit", editRow);
				}
			},
			onRowContextMenu : function(e, rowIndex, rowData) {
				e.preventDefault();
				$("#userMenu").menu("show",{
					left : e.pageX,
					top : e.pageY
				});
				datagrid.datagrid("unselectAll");
				datagrid.datagrid("selectRow", rowIndex);
				
			}
		
		});
		$(".datagrid-header div").css("textAlign", "center");
		
		changeEditorAddRow = function() {
			datagrid.datagrid("removeEditor", ["createDateTime", "modifyDateTime"]);
			datagrid.datagrid("addEditor",
				{field:"password",editor:{
	        		type:"validatebox",
	        		options:{
	        			required:true
	        		}
	            }}
			);
		};
		
		changeEditorEditRow = function() {
			datagrid.datagrid("removeEditor", "password");
			datagrid.datagrid("addEditor",
				[{field:"createDateTime",editor:{
	        		type:"datetimebox",
	        		options:{
	        			required:true
	        		}
	            }},{field:"modifyDateTime",editor:{
	        		type:"datetimebox",
	        		options:{
	        			required:true
	        		}
	            }}]
			);
		};
		
		edit = function(rowIndex){
			var rows = datagrid.datagrid("getRows");
			var row = rows[rowIndex];
			alert(JSON.stringify(row));
		};
		
	})
	
	var userListSearch = function(){
		var obj = ly.serializeObject($("#userListSearch"));
// 		var queryParams = datagrid.datagrid('options').queryParams;  
//      queryParams.username = "1";  
//      datagrid.datagrid('options').queryParams=queryParams
// 		console.info(datagrid.datagrid('options').queryParams);  
// 		alert(JSON.stringify(obj));
		datagrid.datagrid("load", obj);
	};
	var userListClear = function(){
		$("#userListSearch input").val("");
		datagrid.datagrid("load", {});
	};
	
	var testExport = function(){
		  var form = $("<form>");   //定义一个form表单
          form.attr('style', 'display:none');   //在form表单中添加查询参数
          form.attr('target', '');
          form.attr('method', 'post');
          form.attr('action', ly.getWebRootPath() + "/user/exportWord2");

          var input1 = $('<input>');
          input1.attr('type', 'hidden');
          input1.attr('name', 'strUrl');
          input1.attr('value', "vUrl");
          $('body').append(form);  //将表单放置在web中
          form.append(input1);   //将查询参数控件提交到表单上
          form.submit(); 
	}
</script>

	<div id="userListLayout" class="easyui-layout" data-options="fit:true,border:false">
		<div region="north" title="过滤" style="height: 115px;overflow: hidden;" border="false">
			<form id="userListSearch">
				<table class="tableForm datagrid-toolbar" style="width: 100%;height: 100%;">
					<tr>
						<th>用户名</th>
						<td><input name="username" style="width: 320px;"/></td>
					</tr>
					<tr>
						<th>创建时间</th>
						<td>
							<input name="createDateTimeStart" editable="false" class="easyui-datetimebox" style="width: 155px;"/>
							至
							<input name="createDateTimeEnd" editable="false" class="easyui-datetimebox" style="width: 155px;"/>
						</td>
					</tr>
					<tr>
						<th>最后修改时间</th>
						<td>
							<input name="modifyDateTimeStart" editable="false" class="easyui-datetimebox" style="width: 155px;"/>
							至
							<input name="modifyDateTimeEnd" editable="false" class="easyui-datetimebox" style="width: 155px;"/>
							<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="userListSearch();">查询</a>
							<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" onclick="userListClear();">清除</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div region="center" style="padding:0px;overflow:hidden;" data-options="border:false">
			<table id="datagrid"></table>
	</div>
</div>
	<div id="userMenu" class="easyui-menu" style="width: 100px;display: none;">
			<div onclick="javascript:alert('add');" iconCls="icon-add">增加</div>
			<shiro:hasPermission name="user:delete"><div onclick="" iconCls="icon-remove">删除</div></shiro:hasPermission>
			<div onclick="" iconCls="icon-edit">编辑</div>
	</div>
</body>
</html>