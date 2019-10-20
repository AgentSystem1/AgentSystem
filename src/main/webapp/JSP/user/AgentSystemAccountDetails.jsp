<%--
  Created by IntelliJ IDEA.
  User: XiEr
  Date: 2019/10/10
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>代理商系统 - - 主页面 - - 查看账户明细</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<table class="layui-table">
    <colgroup>
        <col width="200">
        <col width="200">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>序号</th>
        <th>账务类型</th>
        <th>账务资金</th>
        <th>账户余额</th>
        <th>备注信息</th>
        <th>明细时间</th>
    </tr>
    </thead>
    <tbody id="biuuu_city_list">

    </tbody>
</table>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend></legend>
</fieldset>
<div id="demo3"></div>

<input type="hidden" value="${userId1}" id="userId">

<script>
    var datas;//所有客户数据
    $(function () {
        var array=new Array();
        var userId = $("#userId").val();
        $.ajax({
            url : '${pageContext.request.contextPath}/user/AgeAccountDetailList',
            type : 'post',
            data : {userId : userId},
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
    layui.use(['laydate'],function () {
        var laydate=layui.laydate;
        //日期范围
        laydate.render({
            elem: '#test6'
            ,range: '到'
            ,done:function (value) {
                var i=value.indexOf('到')
                var array=new Array();
                if (i!=-1) {
                    var begin=value.substring(0,i).replace(/\s+/g,"");
                    var finish=value.substring(i+1,value.length).replace(/\s+/g,"");
                }
                console.log("-------------事件触发"+value.substring(0,i)+""+value.substring(i,value.length)+"----------------下标位置"+i)
                $.ajax({
                    url : '${pageContext.request.contextPath}/customcontroller/getAccountDetailList',
                    type : 'post',
                    data :{'begin':begin,'finish':finish} ,
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

            }
        });
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
                        var curr=obj.curr;
                        var arr = []
                            ,thisData = datas.concat().splice(curr*nums-nums, nums);
                        console.log(thisData)

                        layui.each(thisData, function(index, item){

                            var ht="<tr>\n" +
                                "                <th>"+item.id+"</th>\n" +
                                "                <th>"+item.detailTypeName+"</th>\n" +
                                "                <th>"+item.money+"</th>\n" +
                                "                <th>"+item.accountMoney+"</th>\n" +
                                "                <th>"+item.memo+"</th>\n" +
                                "                <th>"+item.detailDateTime+"</th>\n" +
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
