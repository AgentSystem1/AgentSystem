<%--
  Created by IntelliJ IDEA.
  User: XiEr
  Date: 2019/10/10
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>代理商系统 - - 主页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<<body>
    <div class="layui-card">
        <div class="layui-card-header">代理商管理\当前用户信息</div>
        <div class="layui-card-body">
            您好，${userSession.userName}!您上次登录的时间为<fmt:formatDate value="${user.lastLoginTime}"  pattern="yyyy-MM-dd HH:mm:ss" /></br>
            您当前的账户余额：¥：${accountdetailMoney}    <a href="${pageContext.request.contextPath}/user/AgentSystemAccountDetails.html?userId=${userSession.id}" style="color: #1E9FFF">查看账户明细</a>
        </div>
    </div>
</body>
</html>
