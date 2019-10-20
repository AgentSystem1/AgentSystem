<%--
  Created by IntelliJ IDEA.
  User: LinKaiKai
  Date: 2019/09/23
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<meta charset="utf-8">
	<title>角色权限配置</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>

<div class="layui-container" style="background-color: #FFFFFF;">
	<div class="layui-row" style="padding: 15px 0;">
		<div>系统管理\角色权限配置</div>
	</div>
	<div class="layui-row" style="background-color: #ffffff;">
		<div style="padding: 10px;">
			<div class="layui-tab layui-tab-card" lay-filter='docDemoTabBrief'>
				<ul class="layui-tab-title">

				</ul>
				<div class="layui-tab-content">
					<h1 align="center" style="border-bottom: #0C0C0C 1px solid">功能列表</h1>
					<div id="show-text"><h2 align="center">请先选择角色</h2></div>
					<div class="layui-tab-item layui-show layui-hide" id="table-hide">
						<table id="demo" lay-filter="test"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div>&nbsp;</div>
</div>


<div id="operation_function" align="center" style="width: 500px;height: 250px;position: fixed;top: 20%;left: 37%;border: #0C0C0C solid 1px;background-color: #FFFFFF;display: none;">
	<div style="width: 400px;">
		<div style="margin: 30px 0;padding-bottom: 10px;border-bottom: #000000 solid 1px;">
			<h2 id="description"></h2>
		</div>
		<form class="layui-form" id="from_function" method="post">
			<input type="hidden" name="functionId" id="functionId">
			<input type="hidden" name="roleId" id="roleId">
			<div class="layui-form-item">
				<label class="layui-form-label">是否启用：</label>
				<div class="layui-input-inline">
					<select name="isStart" id="isStart" lay-verify="required">
						<option value=" ">-请选择-</option>
						<option value="1">启用</option>
						<option value="0">未启用</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block" style="margin-left: 0;">
					<button class="layui-btn" lay-submit lay-filter="formDemo">保存</button>
					<a id="close" class="layui-btn">取消</a>
				</div>
			</div>
		</form>
	</div>
</div>

<script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-xs" id="gotoPage" lay-event="edit">设置角色功能权限</a>
</script>

<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>

	/** */
	$(function () {
		$.ajax({
			url : '${pageContext.request.contextPath}/authority/GetRoleName',
			type : 'post',
			data : null,
			dataType : 'json',
			async: false,
			success : function(result) {//searchUser
				var item;
				$.each(result, function (i, result) {   //$.each()  遍历
					item = " <li class='role_li' value=\""+result['id']+"\">"+result['roleName']+"</li>";
					$(".layui-tab-title").append(item);
				})

			},
			erorr : function() {
				alert("有异常！");
			}
		})
	})

	//Demo
	layui.use(['table', 'element', 'jquery'], function() {
		var table = layui.table,
				element = layui.element,
				$ = layui.jquery;

		var roleId = 2;

		table.render({
			elem: '#demo'
			,url: '${pageContext.request.contextPath}/authority/showFunction.json' //设置异步接口
			,cols: [[
				{type:'numbers'},
				{field: 'id',hide: true},
				{field: 'functionName', title: '功能名称', align: 'center', sort: true, unresize: true},
				{field: 'funcUrl', title: '功能URL', align: 'center', unresize: true},
				{field: 'creationTime', title: '创建时间', align: 'center', sort: true, unresize: true},
				{field: 'isStart', title: '是否使用', align: 'center', unresize: true, templet: function(d){
						if(d.isStart=="1"){
							return "启用";
						}else{
							return "未启用";
						}
					}},
				{title: '角色是否使用权限',align: 'center',style:'color: red;',unresize: true},
				{title: '设置权限',align: 'center',unresize: true,toolbar: '#barDemo'}
			]]//设置表头
		});

		$('.role_li').click(function () {
			$('#table-hide').removeClass('layui-hide');
			$('#show-text').hide();
			roleId = this.value;
		})

		//监听行工具事件
		table.on('tool(test)', function(obj){
			var data = obj.data;
			//console.log(obj)
			if(obj.event === 'edit'){
				$('#functionId').val(data.id);
				$('#roleId').val(roleId);
				$('#from_function').attr('action','${pageContext.request.contextPath}/authority/updFunction.html');
				$('#description').text('【'+roleId+'】的功能权限设置');
				$('#operation_function').show();
			}
		});

		//获取角色的启动的权限
		$('.role_li').click(function () {
			var roleId = this.value;
			$.ajax({
				url : '${pageContext.request.contextPath}/authority/showFunctionId.json',
				type : 'get',
				data : 'roleId='+roleId,
				dataType : 'json',
				success : function (result) {
					var str=new String(result);
					var arr=new Array();

					arr=str.split(',');
					$('.laytable-cell-1-0-1').each(function () {
						if ($(this).text()!=''){
							for (var i = 0; i < arr.length; i++){
								if ($(this).text()!=0){
									if ($(this).text()==arr[i]){
										$(this).parent().next().next().next().next().next().children().text('启用');
										break;
									}else{
										$(this).parent().next().next().next().next().next().children().text('未启用');
									}
								}
							}
						}
					});
				},
				error : function () {
					alert('有异常');
				}
			});
		});

		$('#close').click(function () {
			$("#operation_function").hide();
		});
	});
</script>
<script>
	layui.use('element', function(){
		var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

		//监听导航点击
		element.on('nav(demo)', function(elem){
			//console.log(elem)
			layer.msg(elem.text());
		});
	});
</script>
</body>
</html>
