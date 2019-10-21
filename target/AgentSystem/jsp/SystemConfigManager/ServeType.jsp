<%--
  Created by IntelliJ IDEA.
  User: Worldly
  Date: 2019-10-11
  Time: 8:05
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>服务类型</title>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<button type="button" class="layui-btn" onclick="test()">添加服务类型</button>
<script>
    layui.use('layer', function(){ //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        $('#layerDemo .layui-btn').on('click', function(){
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });
    });
    function test(){
        layer.confirm('<div style="padding: 50px 30px;">'+'<b>您正在进行添加操作</b><hr><br>' + '<form action="${pageContext.request.contextPath}/controller/serveTypeAdd" method="post" id="Sub">类型名称:<input type="text" name="configTypeName" id="configTypeName">' +
            '<br><br>类型数值:<input type="text" name="configValue" id="configValue">' +
            '<br><br>是否启用:<select  name="isStart" id="isStart"><option  value="1">启用' +
            '</option><option   value="2">禁用</option></select><br> <br><' +
            'input type="hidden" id="sa" name="id"></form>'+'</div>',{
            btn: ['保存', '取消']
            ,yes: function(index, layero){
                var a = $("#configTypeName").val();
                var b = $("#configValue").val();
                if(a=="" && b==""){
                    layer.confirm('必填项不能为空',{
                        btn: ['确定'] //可以无限个按钮
                        ,yes: function(index, layero){
                            test();
                        }
                        /* ,function(index, layero){

                         }*/
                    });
                }else if(a==""){
                    layer.confirm('类型名称不能为空',{
                        btn: ['确定'] //可以无限个按钮
                        ,yes: function(index, layero){
                            test();
                        }
                        /* ,function(index, layero){

                         }*/
                    });
                }else if(b==""){
                    layer.confirm('类型数值不能为空',{
                        btn: ['确定'] //可以无限个按钮
                        ,yes: function(index, layero){
                            test();
                        }
                        /* ,function(index, layero){

                         }*/
                    });
                }else
                $("#Sub").submit();
            }
        }, function(index, layero){
        });
    }
   /* function delet(id){
        var msg = "您确定要删除吗？";
        if (confirm(msg)==true){
            //将被绑定的元素（a）转换成jquery对象，可以使用jquery方
            window.location.href="${pageContext.request.contextPath}/controller/accountingTypeDel?id="+id;
            //你也可以在这里做其他的操作
        }else{
            return false;
        }
    }*/
    function updat(thist){

        thist=JSON.stringify(thist)
        thist=eval('(' + thist + ')')
        console.log('方法进入'+thist)
        layer.confirm('<div style="padding: 50px 30px;">'+'<b>您正在进行修改操作</b><hr><br>' + '<form action="${pageContext.request.contextPath}/controller/serveTypeUpd" method="post" id="Sub">类型名称:<input type="text" name="configTypeName" id="configTypeName" value='+thist.configTypeName+'>' +
            '<br><br>类型数值:<input type="text" name="configValue" id="configValue" value='+thist.configValue+'>'+
            '<br><br>是否启用:<select  name="isStart" id="isStart"><option  value="1">启用'+'</option><option  id="isStart" value="2">禁用</option></select><br> <br><'+'input type="hidden" id="id" name="id" value='+thist.id+'></form>'+'</div>',{
            btn: ['修改', '取消']
            ,yes: function(index, layero){
                var a = $("#configTypeName").val();
                var b = $("#configValue").val();
                if(a=="" && b==""){
                    layer.confirm('必填项不能为空',{
                        btn: ['确定'] //可以无限个按钮
                        ,yes: function(index, layero){
                            updat(thist);
                        }
                        /* ,function(index, layero){

                         }*/
                    });
                }else if(a==""){
                    layer.confirm('类型名称不能为空',{
                        btn: ['确定'] //可以无限个按钮
                        ,yes: function(index, layero){
                            updat(thist);
                        }
                        /* ,function(index, layero){

                         }*/
                    });
                }else if(b==""){
                    layer.confirm('类型数值不能为空',{
                        btn: ['确定'] //可以无限个按钮
                        ,yes: function(index, layero){
                            updat(thist);
                        }
                        /* ,function(index, layero){

                         }*/
                    });
                }else
                    $("#Sub").submit();
            }
        }, function(index, layero){
        });
        if(thist.isStart==1){
            var a= $("#isStart").val();
            $("#isStart").attr("selected",true);

        }else if(thist.isStart==2){
            document.getElementById("isStart")[1].selected=true;
        }
    }
</script>


<table class="layui-table">
    <colgroup>
        <col width="200">
        <col width="200">
        <col width="200">
        <col width="200">
    </colgroup>
    <thead>
    <tr>
        <th>序号</th>
        <th>配置类型</th>
        <th>配置数值</th>
        <th>是否启用</th>
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
    $(function () {
        $.ajax({
            url : '${pageContext.request.contextPath}/controller/serveTypeList',
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
    function dataload(){
        layui.use(['table','laypage'],function(){
            var table=layui.table;
            var laypage=layui.laypage;
            //每页显示条数
            var nums=5;
            //自定义首页、尾页、上一页、下一页文本
            laypage.render({
                first: '首页'
                ,last: '尾页'
                ,prev: '<em>←</em>'
                ,next: '<em>→</em>'
                ,elem: 'demo3'
                ,count: datas.length
                ,limit:nums
                ,jump: function(obj){




                    //模拟渲染
                    document.getElementById('biuuu_city_list').innerHTML = function(){

                        var curr=obj.curr;//当前页数
                        var arr = []
                            ,thisData = datas.concat().splice(curr*nums-nums, nums);
                        console.log(thisData)

                        layui.each(thisData, function(index, item){
                            var th="  <span><a href=\"#\" onclick='updat(" + JSON.stringify(item) +")'>修改</a></span>"
                            var types=item.isStart==1?"启用":"禁用";
                            var ht="<tr>\n" +
                                "                <th>"+item.id+"</th>\n" +
                                "                <th>"+item.configTypeName+"</th>\n" +
                                "                <th>"+item.configValue+"</th>\n" +
                                "                <th>"+types+"</th>\n" +
                                "                <th>"+th+"</th>\n" +
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
