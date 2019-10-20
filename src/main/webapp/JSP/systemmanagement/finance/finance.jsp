<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>财务管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
    <div class="layui-container" style="background-color: #ffffff">
        <div class="layui-row" style="padding: 15px 0;">
            <div>系统管理\财务管理</div>
        </div>
        <div class="layui-row" style="background-color: #ffffff;">
            <div style="padding: 10px;">
                <form class="layui-form" action="${pageContext.request.contextPath}/finance/addFinance.html" method="post">
                    <div class="layui-form-item">
                        <label class="layui-form-label">搜索用户：</label>
                        <div class="layui-input-inline">
                            <select name="userId" lay-verify="required" id="searchUser">
                                <option value=" ">-请选择-</option>

                            </select>
                        </div>
                        <div class="layui-form-mid layui-word-aux">请选择你的用户</div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">操作类型：</label>
                        <div class="layui-input-inline">
                            <select name="detailType" lay-verify="required" id="searchSys">
                                <option value=" ">-请选择-</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">操作资金：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="accountMoney" required lay-verify="required" placeholder="请输入操作资金" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">重要提示：输入的资金数，正数（1000）为向账户增加1000圆，负数（-1000）为向账户减少1000圆，精确到小数点两位数</div>
                    </div>
                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">操作备注：</label>
                        <div class="layui-input-block">
                            <textarea name="memo" placeholder="请输入备注" class="layui-textarea"></textarea>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <h2 style="color: #FF0000">${show}</h2>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div>&nbsp;</div>
    </div>


    <script src="${pageContext.request.contextPath}/RESOURCES/layui/layui.js"></script>

    <script>
        /** */
        $(function () {
            $.ajax({
                url : '${pageContext.request.contextPath}/finance/Getfinance',
                type : 'post',
                data : null,
                dataType : 'json',
                async: false,
                success : function(result) {//searchUser
                    var item;
                    $.each(result, function (i, result) {   //$.each()  遍历
                        item = " <option value=\""+result['id']+"\">"+result['userCode']+"</option>";
                        $("#searchUser").append(item);
                    })

                },
                erorr : function() {
                    alert("有异常！");
                }
            })

            $.ajax({
                url : '${pageContext.request.contextPath}/finance/Getfinances',
                type : 'post',
                data : null,
                dataType : 'json',
                async: false,
                success : function(result) {
                    var item1;
                    $.each(result, function (i, result) {   //$.each()  遍历
                        item1 = " <option value="+result['id']+">"+result['configTypeName']+"</option>";
                        $("#searchSys").append(item1);
                    })
                },
                erorr : function() {
                    alert("有异常！");
                }
            })
        })
    </script>

    <script>
        //Demo
        layui.use(['form','element'], function(){
            var form = layui.form,
                element = layui.element;

            //监听提交
            form.on('submit(formDemo)', function(){
                return true;
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

<script>

</script>
</body>
</html>
