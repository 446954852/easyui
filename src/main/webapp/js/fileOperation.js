;
/**
 * 点击按钮事件 借助form表单下载文件
 */
var downloadFileRespEntityOnClick = function(){
	var form = $("<form>");   //定义一个form表单
    form.attr('style', 'display:none');   //在form表单中添加查询参数
    form.attr('target', '');
    form.attr('method', 'post');
    form.attr('action', ly.getWebRootPath() + "/fileController/downloadFileRespEntityOnClick");
    var input1 = $('<input>');
    input1.attr('type', 'hidden');
    input1.attr('name', 'strUrl');
    input1.attr('value', "vUrl");
    $('body').append(form);  //将表单放置在web中
    form.append(input1);   //将查询参数控件提交到表单上
    form.submit(); 
}
