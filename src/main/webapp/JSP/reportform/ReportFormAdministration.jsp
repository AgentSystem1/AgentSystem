<%--
  Created by IntelliJ IDEA.
  User: MI
  Date: 2019/9/25
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>代理商系统 - - 报表管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/jquery.table2excel.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/administration.js"></script>

    <script type="text/javascript">
        var a;
        function load(){
            a = $('#sel option:selected').val();
            localStorage.setItem("selval",a)
            AdministrationQuery();
        }
        $(document).ready(function(){
            var i=localStorage.getItem("selval");

            document.getElementById("sel")[i].selected=true;

        })
    </script>
</head>
<body>


<fieldset class="layui-elem-field layui-field-title" style="margin-bottom: 50px;">
    <legend>报表管理</legend>
</fieldset>
<div>
    <input id="path" type="hidden" value="${pageContext.request.contextPath}"/>
    <div style="text-align: center">
        <div class="layui-form-item">操作类型：
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <select name="quiz" style="height: 30px;" id="sel">
                        <optgroup label="财务报表" id="opt1">
                            <option value="0" class="AccountBalance">代理商账户余额报表</option>
                            <option value="1" class="AdvanceCharge">预付款流水报表</option>
                            <option value="1" class="AdvanceCharge">代理商流水报表</option>
                        </optgroup>
                        <optgroup label="产品报表" id="opt2">
                            <option value="3" class="Product">产品分类数量/金额总汇</option>
                        </optgroup>
                    </select>
                </div>
                <button class="layui-btn layui-btn-sm"  type="button" onclick="load()">查询</button>
            </div>
        </div>
    </div>

    <%--            预付款流水报表--%>
    <div style="width: 1000px;display: none" id="AdvanceChargeDiv">
        <div class="table-responsive table2excel" data-tableName="Test Table 1">
            <table class="layui-table" id="AdvanceCharge">
                <colgroup>
                    <col width="150">
                    <col width="150">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>序号</th>
                    <th>代理商名称</th>
                    <th>预付款</th>
                    <th>账户余额</th>
                    <th>备注信息</th>
                    <th>时间</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>


    <%--  代理商账户余额报表--%>
    <div style="width: 700px;display: none" id="AccountBalanceDiv">
        <div class="table-responsive table2excel" data-tableName="Test Table 1">
            <table class="layui-table" id="AccountBalance">
                <colgroup>
                    <col width="150">
                    <col width="150">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>序号</th>
                    <th>代理商名称</th>
                    <th>账号余额</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>


    <%--  产品分类信息报表--%>
    <div style="width: 700px;display: none" id="ProductDiv">
        <div class="table-responsive table2excel" data-tableName="Test Table 1">
            <table class="layui-table" id="Product">
                <colgroup>
                    <col width="150">
                    <col width="150">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>序号</th>
                    <th>产品分类名称</th>
                    <th>数量</th>
                    <th>价格</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
    <%--    <table class="layui-hide" id="test"></table>--%>
</div>

<button class="layui-btn" type="button" onclick="toexcel()">下载Excel</button>

<script>
    layui.use(['laydate'],function () {
        console.log("初始函数进入")
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
                    localStorage.setItem("begin",begin);
                    localStorage.setItem("finish",finish);
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
                        if (datas.length<=0) {
                            $('#biuuu_city_list').html("<span style='color: #2F4056;font-size:24px ;'>暂时没有查询到数据</span>")
                        }else {
                            dataload();
                        }

                    },
                    erorr : function() {
                        alert("有异常！");
                    }
                })

            }
        });
    })

</script>


<!-- Excel 导出 -->
<script>

    function toexcel() {
        var ex =$('#sel option:selected').attr("class")
        method5(ex);
    }

    //第五种方法
    var idTmr;
    function  getExplorer() {
        var explorer = window.navigator.userAgent ;
        //ie
        if (explorer.indexOf("MSIE") >= 0) {
            return 'ie';
        }
        //firefox
        else if (explorer.indexOf("Firefox") >= 0) {
            return 'Firefox';
        }
        //Chrome
        else if(explorer.indexOf("Chrome") >= 0){
            return 'Chrome';
        }
        //Opera
        else if(explorer.indexOf("Opera") >= 0){
            return 'Opera';
        }
        //Safari
        else if(explorer.indexOf("Safari") >= 0){
            return 'Safari';
        }
    }
    function method5(tableid) {
        if(getExplorer()=='ie')
        {
            var curTbl = document.getElementById(tableid);
            var oXL = new ActiveXObject("Excel.Application");
            var oWB = oXL.Workbooks.Add();
            var xlsheet = oWB.Worksheets(1);
            var sel = document.body.createTextRange();
            sel.moveToElementText(curTbl);
            sel.select();
            sel.execCommand("Copy");
            xlsheet.Paste();
            oXL.Visible = true;

            try {
                var fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls");
            } catch (e) {
                print("Nested catch caught " + e);
            } finally {
                oWB.SaveAs(fname);
                oWB.Close(savechanges = false);
                oXL.Quit();
                oXL = null;
                idTmr = window.setInterval("Cleanup();", 1);
            }

        }
        else
        {
            tableToExcel(tableid)
        }
    }
    function Cleanup() {
        window.clearInterval(idTmr);
        CollectGarbage();
    }
    var tableToExcel = (function() {
        var uri = 'data:application/vnd.ms-excel;base64,',
            template = '<html><head><meta charset="UTF-8"></head><body><table>{table}</table></body></html>',
            base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) },
            format = function(s, c) {
                return s.replace(/{(\w+)}/g,
                    function(m, p) { return c[p]; }) }
        return function(table, name) {
            if (!table.nodeType) table = document.getElementById(table)
            var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
            window.location.href = uri + base64(format(template, ctx))
        }
    })()
</script>



</body>
</html>
