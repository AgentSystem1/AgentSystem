<%--
  Created by IntelliJ IDEA.
  User: XiEr
  Date: 2019/10/9
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%pageContext.setAttribute("path",request.getContextPath()); %>
<html>
<head>
    <title>代理商系统 - - 登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>

<body>
    <div class="layui-row" style="width: 350px;margin: 60px auto">
        <div class="layui-col-md9">代理商登录 - - 界面</div>
    </div>


    <div class="login bg-black " style="width: 350px;margin: 100px auto">
        <form class="layui-form bg-blue" action="${pageContext.request.contextPath }/user/userLogin.html" method="post">
            <div class="layui-form-item margin-top-10">
                <label class="layui-form-label">用户名
                    <i class="layui-icon">&#xe66f;</i>
                </label>
                <div class="layui-input-inline">
                    <!-- //采用inline表示可以继续放 -->
                    <input type="userCode" name="userCode" required lay-verify="userCode" placeholder="请输入用户名" autocomplete="off" class="layui-input" lay-verType="msg">
                    <span style="font-size: 12px;color: red">${LoginTips}</span>
                </div>
                <!-- <div class="layui-form-mid layui-word-aux"></div> -->
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码
                    <i class="layui-icon"> &#xe672;</i>
                </label>
                <div class="layui-input-inline">
                    <input type="password" name="userPassword" required lay-verify="userPassword" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
                <!-- <div class="layui-form-mid layui-word-aux"></div> -->
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="login">登录</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
