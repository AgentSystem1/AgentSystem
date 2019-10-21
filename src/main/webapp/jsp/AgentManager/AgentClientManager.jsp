<%--
  Created by IntelliJ IDEA.
  User: Worldly
  Date: 2019-10-14
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <title>代理商客户管理</title>
</head>
<body>

<form>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">客户名称：</label>
            <div class="layui-input-inline">
                <input type="text" id="customName" name="customName" lay-verify="required|number" autocomplete="off" class="layui-input">
            </div>
        </div>
        <button type="button" class="layui-btn" onclick="getclientByObj()">点击查询</button>
    </div>
</form>
<button type="button" class="layui-btn layui-btn-primary layui-btn-radius layui-btn-sm" onclick="add()"><i class="layui-icon"></i>添加客户</button>

<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>序号</th>
        <th>客户名称</th>
        <th>法人代表</th>
        <th>注册时间</th>
        <th>类型</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
   <tbody id="biuuu_city_list">

    </tbody>
</table>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend></legend>
</fieldset>
<div id="demo3"></div>


<script>
    var datas;//所有客户数据
    var condatas;//所有联系人数据
    function add(){
        location.href="${pageContext.request.contextPath}/jsp/AgentManager/AddAccountDetail.jsp";
    }

    //查看客户
    function lookclient(clientdata,th) {
        console.log("查看方法进入------------------输出数据"+clientdata)
        communal(clientdata,th)
        location.href="${pageContext.request.contextPath}/jsp/AgentManager/LookClients.jsp";
    }

    function communal(data,th) {
        var thtext=$(th).parent().parent().children("th:eq(5)").text();
        //得到text文本 判断停用或启用
        if (thtext==null || thtext.replace(/\s+/g,"")=="" || thtext==undefined) {
            thtext=$(th).parent().parent().children("th:eq(5)").children("span").text();
        }
        localStorage.setItem("clientdata",JSON.stringify(data))
        localStorage.setItem("condatas",JSON.stringify(condatas))
        localStorage.setItem("thtext",thtext)
    }
    //修改客户
    function  updateclient(clientdata,th) {
        console.log("修改方法进入---------------------输出数据"+clientdata)
        communal(clientdata,th)

        location.href="${pageContext.request.contextPath}/jsp/AgentManager/UpdClientInfo.jsp";
    }
    //模糊查询
    function getclientByObj() {
        var obj=$('#customName').val();
        $.ajax({
            url : '${pageContext.request.contextPath}/controller/agentClientList',
            type : 'post',
            data : {'customName':obj},
            dataType : 'json',
            success : function(result) {
                datas = result;
                console.log("客户数据得到------------------"+datas);
                dataload();
            },
            erorr : function() {
                alert("有异常！");
            }
        })
    }
    //转换客户状态
    function switchoverstatus(th){
        var th=$(th);
        var text=$(th).children("span").text();
        var brothernode=$(th).parent().parent().children("th:eq(5)");
        var id=$(th).parent().parent().children("th:eq(0)").text();

        //得到text文本 判断停用或启用
        if (text==null || text.replace(/\s+/g,"")=="" || text==undefined) {
            text=$(th).text();
        }
        //询问框
        layer.confirm('你确定'+text+'该用户吗', {
            btn: ['确定','取消'] //按钮
        }, function(){
            if (text=="停用"){
                brothernode.html("<span style='color: red'>停用</span>")
                th.html("启用")
            }
            else{
                brothernode.html("启用")
                th.html("<span style='color: red'>停用</span>")
            }
            var i=text=="启用"?0:1;
            console.log(brothernode+brothernode.text()+"主键ID"+id+"----------->类型改为"+i+"-----------数值为"+text)
            var item=new Array();
            item.push(id);
            item.push(i);
            $.ajax({
                url : '${pageContext.request.contextPath}/controller/update_Custom/'+item,
                type : 'post',
                data : null,
                dataType : 'json',
                success : function(result) {
                    console.log(result)
                    layer.msg('修改成功', {icon: 1});
                },
                erorr : function() {
                    layer.msg('修改失败-出现异常', {icon: 1});
                }
            })

        }, function(){
            layer.msg('取消');
        });


    }
    $(function () {
        $.ajax({
            url : '${pageContext.request.contextPath}/controller/agentClientList',
            type : 'post',
            data : null,
            dataType : 'json',
            success : function(result) {
                datas = result;
                console.log("客户数据得到------------------"+datas);

            },
            erorr : function() {
                alert("有异常！");
            }
        })

        $.ajax({
            url : '${pageContext.request.contextPath}/controller/contactList',
            type : 'post',
            data : null,
            dataType : 'json',
            success : function(result) {

                condatas = result;
                console.log("客户联系人数据得到------------------"+condatas);
                //调用渲染方法
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
            //自定义首页、尾页、上一页、下一页文本
            laypage.render({
                first: '首页'
                , last: '尾页'
                , prev: '<em>←</em>'
                , next: '<em>→</em>'
                , elem: 'demo3'
                , count: datas.length
                , limit: nums
                , jump: function (obj) {
                    //模拟渲染
                    document.getElementById('biuuu_city_list').innerHTML = function () {
                        var curr = obj.curr;
                        var arr = []
                            , thisData = datas.concat().splice(curr * nums - nums, nums);
                        console.log(thisData)

                        layui.each(thisData, function (index, item) {
                            var status = item.customStatus == 1 ? "启用" : "停用"
                            var statust;
                            if (status == "停用") {
                                status = "<span style='color: red'>停用</span>"
                                statust = " <button type=\"button\" class=\"layui-btn  layui-btn-primary\" onclick='switchoverstatus(this)'>启用</button>"
                            } else {
                                statust = " <button type=\"button\" class=\"layui-btn  layui-btn-primary\" onclick='switchoverstatus(this)'><span style='color: red'>停用</span></button>"
                            }
                            var str = item.toString()
                            var operation = " <button type=\"button\" class=\"layui-btn\" onclick='lookclient(" + JSON.stringify(item) + ",this)'>查看</button>\n" +
                                "    <button type=\"button\" class=\"layui-btn \" onclick='updateclient(" + JSON.stringify(item) + ",this)'>修改</button>" + statust;

                            var ht = "<tr>\n" +
                                "                <th>" + item.id + "</th>\n" +
                                "                <th>" + item.customName + "</th>\n" +
                                "                <th>" + item.bossName + "</th>\n" +
                                "                <th>" + item.regDatetime + "</th>\n" +
                                "                <th>" + item.customTypeName + "</th>\n" +
                                "                <th>" + status + "</th>\n" +
                                "                <th>" + operation + "</th>\n" +
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
</body>
</html>


