<%--
  Created by IntelliJ IDEA.
  User: DXY
  Date: 2019/10/11
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>App地址</title>
    <style type="text/css">
        #ku{

            height: 500px;
            border: slategrey solid 1px;
        }

    </style>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>

<body>

<script>
    $(function () {
        $.ajax({
            url : '${pageContext.request.contextPath}/controller/appAddressList',
            type : 'post',
            data : null,
            dataType : 'json',
            async: false,
            success : function(result) {
                console.log("数据得到的");
                $("#configTypeName").val(result.configTypeName);
                $("#configValue").val(result.configValue);
                $("#id").val(result.id);
            },
            erorr : function() {
                alert("有异常！");
            }
        })
    })
</script>



    <div id="ku" >
        <div class="layui-input-block" align="center">

            <div class="layui-form-item">
                <h3 >APP URL管理-填写制作APP的系统的URL地址</h3>
            </div>

        </div>

        <hr>
       <form action="appadd" method="post">
           <div class="layui-input-block" align="center">
               <input type="hidden" id="id" name="id" >
                   <div class="layui-form-item">
                           <input type="text" id="configTypeName" name="configTypeName" required="" lay-verify="required"  autocomplete="off" class="layui-input layui-form-danger" style="width: 300px  " readonly="readonly">

                   </div>

           </div>
                   <div class="layui-input-block" align="center">

                           <div class="layui-form-item" >
                                   <input type="text" name="configValue" required="" id="configValue" lay-verify="required" autocomplete="off" class="layui-input layui-form-danger"style="width: 300px">

                           </div>
                   </div>

                   <div class="layui-form-item" align="center">

                       <button class="layui-btn" type="button" id="add" onclick="test()">确认</button>


                   </div>



       </form>

    </div>





<script type="text/javascript">

    layui.use(['element','table'], function() {
        var element = layui.element;
        var table = layui.table;
    })
    function test() {
        var id = $("#id").val();
        var a = $("#configTypeName").val();
        var b = $("#configValue").val();

        $(function () {


            if(b==""){
                layer.confirm('url不能为空',{
                    btn: ['确定'] //可以无限个按钮
                    ,function(index, layero){

                    }
                });
            }else{

                $.ajax({
                    url: '${pageContext.request.contextPath}/controller/appAddressUpd',
                    type: 'GET',
                    data: {"configValue":b,"id":id},
                    dataType: 'json',
                    success: function (result) {

                        if(result){
                            layer.confirm('修改成功',{
                                btn: ['确定'] //可以无限个按钮
                                 ,function(index, layero){
                                }
                            });
                        }


                    },
                    erorr: function () {
                        alert("有异常！");
                    }

                })

            }



    }
        )}

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
