<%--
  Created by IntelliJ IDEA.
  User: LinKaiKai
  Date: 2019/09/23
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>角色管理</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
		<script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript"></script>
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	</head>
	<body>


		<div class="layui-container" style="background-color: #FFFFFF;">
			<div class="layui-row" style="padding: 15px 0;">
				<div>系统管理\角色管理</div>
			</div>
			<div class="layui-row" style="background-color: #ffffff;">
				<div style="padding: 10px;">
					<div>
						<button id="addRole" type="button" class="layui-btn" onclick="AddRole()"><i class="layui-icon">&#xe654;</i>&nbsp;&nbsp;&nbsp;新&nbsp;增</button>
					</div>
					<div>
						<table id="demo" lay-filter="test"></table>
					</div>
				</div>
			</div>
			<div>&nbsp;</div>
		</div>

		<table class="layui-table">
			<colgroup>
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="100">
			</colgroup>
			<thead>
			<tr>
				<th>角色名称</th>
				<th>创建时间</th>
				<th>是否启用</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody id="biuuu_city_list">

			</tbody>
		</table>
		<div id="demo3"></div>




		<script src="${pageContext.request.contextPath}/layui/layui.js"></script>

	<script>

		var datas;//所有客户数据
		$(function () {
			var array=new Array();
			$.ajax({
				url : '${pageContext.request.contextPath}/systemrole/GetRoleStart',
				type : 'post',
				data : null,
				dataType : 'json',
				async: false,
				success : function(result) {
					console.log("数据得到的");
					datas = result;
					console.log(datas);
					dataload();
				},
				erorr : function() {
					alert("有异常！");
				}
			})
		})



		//数据加载
		function dataload() {
			layui.use(['table', 'laypage'], function () {
				var table = layui.table;
				var laypage = layui.laypage;


				//每页显示条数
				var nums = 5;
				//自定义首页、尾页、上一页、下一页文	本
				laypage.render({
					first: '首页'
					,last: '尾页'
					,prev: '<em>←</em>'
					,next: '<em>→</em>'
					,elem: 'demo3'
					,count: datas.length
					,limit:nums
					,page:true
					, jump: function (obj) {
						//模拟渲染
						document.getElementById('biuuu_city_list').innerHTML = function () {
							var curr = obj.curr;
							var arr = []
									, thisData = datas.concat().splice(curr * nums - nums, nums);
							console.log(thisData)

							layui.each(thisData, function (index, item) {

								var isStart;	//是否启用
								if(item.isStart == "1"){
									isStart = "启用";
								}else {
									isStart = "不启用";
								}

								var ht = "<tr>\n" +
										"                <th>" + item.roleName + "</th>\n" +
										"                <th>" + item.creationTime + "</th>\n" +
										"                <th>" + isStart + "</th>\n" +
										"                <th>" + "<a href='javascript:;'  onclick=\"ModifyRole(this)\" roleName=" + item.roleName + " isStart=" + item.isStart + " roleId="+item.id+">修改</a> | <a href='#' onclick=\"DeleteRole(this)\" roleId="+item.id+" roleName=" + item.roleName + ">删除</a>" + "</th>\n" +
										"            </tr>"
								arr.push(ht);
							});
							return arr.join('');
						}();
					}
				});
			})
		}
	</script>

   <script>
       /** 角色信息修改 */
       function ModifyRole(update) {
           var roleName = $(update).attr("roleName");
           var isStart = $(update).attr("isStart");
           var roleId = $(update).attr("roleId");
           layer.confirm('<div style="padding: 20px 30px;">'+'<input id="roleId" type="hidden" value='+roleId+'>'+
               '<b>修改角色信息</b><hr><br>' + '<table>角色名称:<input type="text" name="roleName" id="roleName" value='+roleName+'><br>'+
               '是否启用:<select name="isStart" id="isStart" lay-verify="required"> <option value="1" <c:if test='isStart == "1"'> selected="selected"</c:if>>启用</option><option value="0" <c:if test='isStart == "0"'> selected="selected"</c:if>>未启用</option></select><br>'+'</table>'+'</div>',{
               btn: ['确认修改', '取消']
               ,yes: function(index, layero){
                   UpdateRole();
                   location.reload();
               }
           }, function(index, layero){
           });
       }


       /** 进行修改功能*/
       function UpdateRole() {
           var roleName = $("#roleName").val();
           var isStart = $("#isStart").val();
           var roleId = $("#roleId").val();
           $.ajax({
               url : '${pageContext.request.contextPath}/systemrole/UpdateRole',
               type : 'post',
               data : {roleName:roleName,isStart:isStart,roleId:roleId},
               dataType : 'JSON',
               async: false,
               success : function(result) {
				   return result["roleIf"];

               },
               erorr : function() {
                   alert("有异常！");
               }
           })
       }

       /** 删除*/
       function DeleteRole(deletes) {
           var roleName = $(deletes).attr("roleName");
           var roleId =  $(deletes).attr("roleId");
           layer.confirm('您确定要删除【'+roleName+'】这个角色吗？',{
               btn: ['OK', 'Cancel']
               ,yes: function(index, layero){
					DeleteR(roleName,roleId);
				   location.reload();
               }
           }, function(index, layero){
           });
       }

	   function DeleteR(roleName,roleId) {
		   $.ajax({
			   url : '${pageContext.request.contextPath}/systemrole/DeleteRole',
			   type : 'post',
			   data : {roleName:roleName,roleId:roleId},
			   dataType : 'JSON',
			   async: false,
			   success : function(result) {
				   layer.msg("删除成功！",{icon:1.5});
			   },
			   erorr : function() {
				   alert("有异常！");
			   }
		   })
	   }

	   /** 新增角色 */
	   function AddRole() {
		   layer.confirm('<div style="padding: 20px 30px;">'+
				   '<b>新增角色信息</b><hr><br>' + '<table>角色名称:<input type="text" name="roleNameAdd" id="roleNameAdd"><br>'+
				   '是否启用:<select name="isStartAdd" id="isStartAdd" lay-verify="required"> <option value="1">启用</option><option value="0">未启用</option></select><br>'+'</table>'+'</div>',{
			   btn: ['保存', '取消']
			   ,yes: function(index, layero){
				   RoleAdd();
				   location.reload();
			   }
		   }, function(index, layero){
		   });
	   }

	   /**
		* 新增方法
		*/
	   function RoleAdd() {
		   var roleNameAdd = $("#roleNameAdd").val();
		   var isStartAdd= $("#isStartAdd").val();
		   $.ajax({
			   url : '${pageContext.request.contextPath}/systemrole/AddRole',
			   type : 'post',
			   data : {roleNameAdd:roleNameAdd,isStartAdd:isStartAdd},
			   dataType : 'JSON',
			   async: false,
			   success : function(result) {
				   layer.msg("新增成功！",{icon:1.5});
			   },
			   erorr : function() {
				   alert("有异常！");
			   }
		   })
	   }
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
