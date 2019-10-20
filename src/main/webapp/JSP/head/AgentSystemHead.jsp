<%--
  Created by IntelliJ IDEA.
  User: XiEr
  Date: 2019/10/10
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <link href="${pageContext.request.contextPath}/layui/css/layui.css"  rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

    <style type="text/css">
        #VtiUserPass,#VtiNewUserPass,#VtiAgainUserPass{
            font-size:12px;
            color: #1E9FFF;
        }
        #Sub{
            width: 300px;
        }
    </style>

    <script>
        window.onbeforeunload   =   function(){
            var   n   =   window.event.screenX   -   window.screenLeft;
            var   b   =   n   >   document.documentElement.scrollWidth-20;
            if(b   &&   window.event.clientY   <   0   ||   window.event.altKey)
            {
                alert("是关闭而非刷新");
                window.event.returnValue   =   "是否关闭？";
            }else{
                alert("是刷新而非关闭");
            }
            alert("111")
        }
    </script>
</head>
<body>
<ul class="layui-nav" lay-filter="" style="width: 100%">
    <li class="layui-nav-item">
        <a href="javascript:;">代理商管理</a>
        <dl class="layui-nav-child"> <!-- 二级菜单 -->
            <dd><a href="">关键词申请</a></dd>
            <dd><a href="">代理商客户管理</a></dd>
            <dd><a href="">代理商预付款</a></dd>
            <dd><a href="">关键词申请管理</a></dd>
            <dd><a href="">操作日志</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="">门户管理</a></li>
    <li class="layui-nav-item"><a value="${pageContext.request.contextPath}/JSP/reportform/ReportFormAdministration.jsp" href="#" onclick="load(this)" id="BaoBiao">报表管理</a></li>
    <li class="layui-nav-item">
        <a href="javascript:;">系统管理</a>
        <dl class="layui-nav-child"> <!-- 二级菜单 -->
            <dd><a value="${pageContext.request.contextPath}/JSP/systemmanagement/finance/finance.jsp" href="#" onclick="load(this)">财务管理</a></dd>
            <dd><a value="${pageContext.request.contextPath}/JSP/systemmanagement/role/role.jsp" href="#" onclick="load(this)">角色管理</a></dd>
            <dd><a value="${pageContext.request.contextPath}/JSP/systemmanagement/author/authority.jsp" href="#" onclick="load(this)" id="BaoBiao1">角色权限配置</a></dd>
            <dd><a value="${pageContext.request.contextPath}/JSP/systemmanagement/user/user.jsp" href="#" onclick="load(this)">用户管理</a></dd>
            <dd><a value="${pageContext.request.contextPath}/JSP/systemmanagement/key/keywords.jsp" href="#" onclick="load(this)">关键词审核</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:;">系统配置管理</a>
        <dl class="layui-nav-child"> <!-- 二级菜单 -->
            <dd><a value="${pageContext.request.contextPath}/jsp/SystemConfig/AccountingType.jsp" href="#" onclick="load(this)">财务类型</a></dd>
            <dd><a value="${pageContext.request.contextPath}/jsp/SystemConfig/ServeType.jsp" href="#" onclick="load(this)">服务类型</a></dd>
            <dd><a value="${pageContext.request.contextPath}/jsp/SystemConfig/ServeYears.jsp" href="#" onclick="load(this)">服务年限</a></dd>
            <dd><a value="${pageContext.request.contextPath}/jsp/SystemConfig/AppAddress.jsp" href="#" onclick="load(this)">APP地址</a></dd>
            <dd><a value="${pageContext.request.contextPath}/jsp/SystemConfig/ClientType.jsp" href="#" onclick="load(this)">客户类型</a></dd>
            <dd><a value="${pageContext.request.contextPath}/jsp/SystemConfig/CredentialsType.jsp" href="#" onclick="load(this)">证件类型</a></dd>
            <dd><a value="${pageContext.request.contextPath}/jsp/SystemConfig/PreferentialType.jsp" href="#" onclick="load(this)">优惠类型</a></dd>
        </dl>
    </li>
    <span style="padding-left: 430px;line-height:60px;color: #d2d2d2">欢迎您：${userSession.userName}    <a href="javascript:;" style="color: #d2d2d2;padding-left: 5px" onclick="test()">修改密码</a>    <a href="${pageContext.request.contextPath}/user/AgentSystemSignOut?userCode=${userSession.userCode}" style="color: #d2d2d2;padding-left: 5px">退出</a></span>
    <input id="PrmaUserPass" type="hidden" value="${userSession.userPassword}"/>
    <input id="Verification" type="hidden" value="no"/>

</ul>

<iframe id="key_iframe" src="${pageContext.request.contextPath}/JSP/user/AgentSystemHomePage.jsp" onclick="load(this)" scrolling="no" width="100%" height="100%"></iframe>
<script>
    function load(iframe) {
        var BaoBiao = $(iframe).attr("id");
        var values=$(iframe).attr("value");
        var key_iframe = $("#key_iframe");
        if (BaoBiao == "BaoBiao" || BaoBiao == "BaoBiao1"){
            key_iframe.attr("height","200%");
        }
        else
            key_iframe.attr("height","100%");
        key_iframe.attr("src",values)
    }
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;

        //…
    });

    layui.use('layer', function(){ //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        $('#layerDemo .layui-btn').on('click', function(){
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });
    });


    /*修改密码*/
    function test(){
        layer.confirm('<div style="padding: 50px 30px;">'+
            '<b>您正在进行修改密码操作</b><hr><br>' + '<form action="${pageContext.request.contextPath}/user/UpdatePass" method="post" id="Sub">请输入原密码:<input type="text" name="userPass" id="userPass" onblur="VyiNewUserpass()"><br><span id="VtiUserPass">您本次登录时输入的密码</span>' +
            '<br><br> 请输入新密码:<input type="text" name="newUserPass" id="newUserPass" onblur="VyiNewUserpass()"><br><span id="VtiNewUserPass">新密码不少于6个字符</span> <br> <br>' +
            '请输入新密码:<input type="text" name="againUserPass" id="againUserPass" onblur="VyiNewUserpass()"><br><span id="VtiAgainUserPass">新密码不少于6个字符</span><input type="hidden" id="sa" name="userId" value="${userSession.id}"></form>'+'</div>',{
            btn: ['确认修改', '取消']
            ,yes: function(index, layero){
                VyiNewUserpass();
                var Verification = $("#Verification").val();
                if (Verification == "yes"){
                    $("#Sub").submit();
                }else
                    alert("请正确输入！");
                //layer.msg("请正确输入！",{icon:1.5});
            }
        }, function(index, layero){
        });
    }

    /*判断原密码*/
    function VyiNewUserpass() {
        var PrmaUserPass = $("#PrmaUserPass").val();  //原密码
        var userPass = $("#userPass").val();  //输入原密码
        var newUserPass = $("#newUserPass").val();  //第一次输入新密码
        var againUserPass = $("#againUserPass").val();  //第二次确认新密码
        if (PrmaUserPass != userPass){
            $("#VtiUserPass").html("原密码输入错误!").css({" font-size":"12px","color":"red"});
            $("#Verification").val("no");
        }else{
            $("#VtiUserPass").html("输入正确").css({" font-size":"12px","color":"green"});
            $("#Verification").val("no");
            if (newUserPass.length<6){
                $("#VtiNewUserPass").html("输入密码不能少于6个字符!").css({" font-size":"12px","color":"red"});
                $("#Verification").val("no");
            }else{
                $("#VtiNewUserPass").html("输入正确").css({" font-size":"12px","color":"green"});;
                $("#Verification").val("no");
                if (againUserPass.length<6){
                    $("#VtiAgainUserPass").html("输入密码不能少于6个字符!").css({" font-size":"12px","color":"red"});
                    $("#Verification").val("no");
                }
                else if(againUserPass != (newUserPass)){
                    $("#VtiAgainUserPass").html("两次新密码输入不一致!").css({" font-size":"12px","color":"red"});
                    $("#Verification").val("no");
                }
                else if(againUserPass == (PrmaUserPass) && newUserPass == (PrmaUserPass)){
                    $("#VtiAgainUserPass").html("新密码不可与原密码一致!").css({" font-size":"12px","color":"red"});
                    $("#Verification").val("no");
                }
                else {
                    $("#VtiAgainUserPass").html("输入正确").css({" font-size":"12px","color":"green"});
                    $("#Verification").val("yes");  //判断是否全部输入正确
                }
            }
        }
    }


    /**
     * 窗口关闭事件
     * @param event
     * @returns {boolean}
     */
    <%--window.addEventListener('beforeunload', function(event) {--%>
        <%--alert("进来了");--%>
        <%--$.ajax({--%>
            <%--url : '${pageContext.request.contextPath}/user/AgentSystemSignOuts',--%>
            <%--type : 'post',--%>
            <%--data :{'userCode':${userSession.userCode}} ,--%>
            <%--dataType : 'json',--%>
            <%--async: false,--%>
            <%--success : function(result) {--%>
            <%--},--%>
            <%--erorr : function() {--%>
                <%--alert("有异常！");--%>
            <%--}--%>
        <%--})--%>
    // });
</script>
</body>
</html>
