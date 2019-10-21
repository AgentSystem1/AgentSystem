<%--
  Created by IntelliJ IDEA.
  User: 29007
  Date: 2019/10/14
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <title>查看客户信息</title>
</head>
<body>
<script>
    var multiple=true;//判断下拉框数据是否第一次渲染
    var provinces;//省
    var citys;//城市
    var districts;//区
    var thtext;        //得到下拉框原始数据
    function getdata(){
        console.log("获取值原始方法进入")
        //得到省
        $.ajax({
            url : '${pageContext.request.contextPath}/pro/get_province',
            type : 'post',
            data : null,
            dataType : 'json',
            async: false,
            success : function(result) {
                console.log("省数据得到");
                provinces = result;

            },
            erorr : function() {
                alert("有异常！");
            }
        })
        //城市
        $.ajax({
            url : '${pageContext.request.contextPath}/pro/get_City',
            type : 'post',
            data : null,
            dataType : 'json',
            async: false,
            success : function(result) {
                console.log("城市数据得到");
                citys = result;
            },
            erorr : function() {
                alert("有异常！");
            }
        })
        //区
        $.ajax({
            url : '${pageContext.request.contextPath}/pro/get_Area',
            type : 'post',
            data : null,
            dataType : 'json',
            async: false,
            success : function(result) {
                console.log("区域数据得到");
                districts = result;

            },
            erorr : function() {
                alert("有异常！");
            }
        })

    }


    $(function () {

        getdata()
        var clientstrdata=localStorage.getItem("clientdata");
        var constrdata=localStorage.getItem("condatas");
        thtext=localStorage.getItem("thtext");
        console.log(thtext)
        //将string数据转为json数据
        var clientdata=eval('(' + clientstrdata + ')');
        var condata=eval('(' + constrdata + ')');
        //数据渲染到组件
        renderdata(clientdata.province,clientdata.city,clientdata.area)
        console.log(clientdata)
        renderdatas()
    })
    function renderdatas() {
        var list = new Array();
        var clientdata = localStorage.getItem("clientdata");
        var condatas = localStorage.getItem("condatas");
        var jsondata = eval('(' + clientdata + ')');//客户数据
        var jsoncondata = eval('(' + condatas + ')');//联系人集合
        var clientid = jsondata.id;
        for (i = 0; i < jsoncondata.length; i++) {
            console.log("循环进入")
            var obj = jsoncondata[i];
            console.log(obj)
            if (obj.customId == clientid)
                list.push(obj)
        }
        var table_body=$('#table_body');
        var htmls;
        for (i=0;i<list.length;i++) {
            var obj=list[i];
            console.log(obj)
            var name=obj.contactName;
            var phone=obj.contactTel;
            var fax=obj.contactFax;
            var mailbox=obj.contactEmail;
            var position=obj.contactRole;
            var ht="<tr> <th>"+name+"</th> <th>"+phone+"</th> <th>"+fax+"</th> <th>"+mailbox+"</th> <th>"+position+"</th></tr>";
            htmls+=ht;
            if (i==0)
                console.log(ht);
        }
        table_body.html(htmls);
        $('#customName').val(jsondata.customName)
        $('#bossName').val(jsondata.bossName);
        $('#siteUrl').val(jsondata.siteUrl)
        $('#cardNum').val(jsondata.cardNum)
        $('#companyFax').val(jsondata.companyFax)
        $('#companyTel').val(jsondata.companyTel)
        $('#companyAddress').val(jsondata.companyAddress)
        $('#memo').val(jsondata.memo)
        $('#id').val(jsondata.id);
        var i=thtext=="启用"?1:0;
        $("#customStatus ").val(i);
        var t=jsondata.customType;
        $('#customType').val(t)
        var z=jsondata.cardType;
        $('#cardType').val(z);
    }

    //渲染数据
    function renderdata(provinceID,cityID,areaID) {
        var provincse=$('#province')//省

        var prht="";
        console.log(provinces)
        for (i=0;i<provinces.length;i++) {
            var obj=provinces[i];
            var ht;
            if (multiple) {
                if (obj.provinceID==provinceID){
                    console.log("判断执行"+"传入ID"+provinceID+"执行值"+obj.province)
                    ht="<option selected=\"\" value="+obj.provinceID+">"+obj.province+"</option>"
                }
                else{
                    ht="<option value="+obj.provinceID+">"+obj.province+"</option>"
                }
            }else {
                ht="<option value="+obj.provinceID+">"+obj.province+"</option>"
            }
            prht+=ht;
        }
        provincse.html(prht);
        renders(cityID,areaID);
    }

    function renders(cityID,areaID) {

        console.log("方法执行")
        //得到当前选中省的值
        var price=$('#province option:selected').val();
        console.log(price+"---------------->省ID")
        var city=$('#city');//城市

        var ciht="";
        for (i=0;i<citys.length;i++){
            var ht;
            var obj=citys[i];
            if (i==0)
                console.log(obj.cityID+""+obj.city)
            if (obj.father==price){
                if (multiple){
                    if (obj.cityID==cityID){
                        console.log(obj.cityID+"---------------"+cityID+"----------------"+obj.city)
                        console.log("进入判断")
                        ht="<option selected=\"\" value="+obj.cityID+">"+obj.city+"</option>"
                    }
                    else{
                        ht="<option value="+obj.cityID+">"+obj.city+"</option>"
                    }
                }else {
                    ht="<option value="+obj.cityID+">"+obj.city+"</option>"
                }

                ciht+=ht;

            }

        }

        city.html(ciht);
        read(areaID)
    }


    function read(areaID) {
        var areaT=$('#area')//区
        console.log("方法执行")
        var arht="";
        //得到当前选中城市的值
        var price=$('#city option:selected').val();
        console.log(price+"-----------城市ID")
        for (i=0;i<districts.length;i++){
            var ht;
            var obj=districts[i];
            if (obj.father==price){
                if (multiple) {
                    if (obj.areaID==areaID){
                        ht="<option selected=\"\" value="+obj.areaID+">"+obj.area+"</option>"

                    }
                    else{
                        ht="<option value="+obj.areaID+">"+obj.area+"</option>"

                    }
                }else {
                    ht="<option value="+obj.areaID+">"+obj.area+"</option>"
                }
                arht+=ht;
            }
        }
        areaT.html(arht);
        multiple=false;
    }

</script>






<form enctype="multipart/form-data" id="form_on" class="layui-form" method="post" action="${pageContext.request.contextPath}/jsp/AgentManager/AgentClientManager.jsp">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>基本信息</legend>
    </fieldset>
    <input type="hidden" id="id" value="" name="id">

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">企业名称</label>
            <div class="layui-input-inline">
                <input type="text" name="customName" lay-verify="required" autocomplete="off" class="layui-input" id="customName" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">企业类型</label>
            <div class="layui-input-block">
                <select name="customType" lay-filter="aihao" id="customType" disabled>
                    <option value="">-请选择-</option>
                    <option value="17">个人</option>
                    <option value="16" selected="">企业</option>
                    <option value="18">政府</option>
                </select>
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">企业主页</label>
            <div class="layui-input-inline">
                <input type="text" name="siteUrl" lay-verify="required" autocomplete="off" class="layui-input" id="siteUrl" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">企业类型</label>
            <div class="layui-input-block">
                <select name="customStatus" lay-filter="aihao" id="customStatus" disabled>
                    <option value="">-请选择-</option>
                    <option value="1" selected="">启用</option>
                    <option value="0">停用</option>
                </select>
            </div>
        </div>
    </div>

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>基本信息</legend>
    </fieldset>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">法人代表</label>
            <div class="layui-input-inline">
                <input type="text" name="bossName" lay-verify="required" autocomplete="off" class="layui-input" id="bossName" disabled>
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">证件类型</label>
            <div class="layui-input-block">
                <select name="cardType" lay-filter="aihao" id="cardType" disabled>
                    <option value="">-请选择-</option>
                    <option value="19" selected="">国内身份证</option>
                    <option value="20">境内身份证</option>
                    <option value="21">营业执照</option>
                    <option value="22">其他类型</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">证件号码</label>
            <div class="layui-input-inline">
                <input type="text" name="cardNum" lay-verify="required" autocomplete="off" class="layui-input" id="cardNum" disabled>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">国家</label>
            <div class="layui-input-inline">
                <input name="country" class="layui-input layui-disabled" value="中国" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">省/地区</label>
            <div class="layui-input-block">
                <select name="province" lay-filter="provinces" id="province" disabled>

                </select>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">公司传真</label>
            <div class="layui-input-inline">
                <input type="text" name="companyFax" lay-verify="required" autocomplete="off" class="layui-input" id="companyFax" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">城市</label>
            <div class="layui-input-block">
                <select name="city" lay-filter="citys" id="city" onchange="read()" disabled>

                </select>
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">公司电话</label>
            <div class="layui-input-inline">
                <input type="text" name="companyTel" lay-verify="required" autocomplete="off" class="layui-input" id="companyTel" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">区</label>
            <div class="layui-input-block">
                <select name="area" lay-filter="aihao" id="area" disabled>

                </select>
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">公司地址</label>
            <div class="layui-input-inline">
                <input type="text" name="companyAddress" lay-verify="required" autocomplete="off" class="layui-input" id="companyAddress" disabled>
            </div>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" class="layui-textarea" name="memo" id="memo" disabled></textarea>
        </div>
    </div>
    <table class="layui-table" id="addlinkman">
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>电话</th>
            <th>传真</th>
            <th>邮箱</th>
            <th>职位</th>
        </tr>
        </thead>
        <tbody id="table_body">

        </tbody>
    </table>
    <div class="layui-form-item">
        <button class="layui-btn" onclick="javascript:history.back(-1)">返回</button>
    </div>
</form>
<script>
    var array=new Array();


</script>
<script>
    layui.use(['form', 'layedit', 'laydate'],function(){
        //获取layui标签
        var form=layui.form;
        var layedit=layui.layedit;
        var laydate=layui.laydate;
        //渲染窗口组件
        form.render();
        //给下拉框绑定值改变事件
        form.on('select(provinces)', function(data) {
            renders()
            form.render('select');
        })

        form.on('select(citys)',function(){
            read()
            form.render('select');
        })

    })
</script>
</body>
</html>
