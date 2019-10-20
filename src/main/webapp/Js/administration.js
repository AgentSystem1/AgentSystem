function AdministrationQuery() {
    var selval = localStorage.getItem("selval");
    var begin = localStorage.getItem("begin");      //查询时间范围之从某时间开始
    var finish = localStorage.getItem("finish");    //查询时间范围之从某事件结尾
    var path = $("#path").val();
    if (selval == "0") {
        $.ajax({
            url: path + "/reportform/GetAdministrationList",
            type: 'post',
            data: null,
            dataType: 'json',
            async: false,
            success: function (result) {
                if (selval == "0") {
                    var item;
                    $('#AccountBalance tbody').remove();
                    $.each(result, function (i, result) {   //$.each()  遍历
                        item = " <tbody><tr class=\"noExl\"><td class=\"success\">" + result['id'] + "</td><td class=\"success\">" + result['userName'] + "</td><td class=\"success\">" + result['money'] + "</td></tr></tbody>";

                        $('#AccountBalance').append(item);
                        $("#ProductDiv").css({"display": "none", "margin": "0 auto"});
                        $("#AdvanceChargeDiv").css({"display": "none", "margin": "0 auto"});
                        $("#AccountBalanceDiv").css({"display": "block", "margin": "0 auto"});
                    });
                }
            },
            erorr: function () {
                alert("有异常！");
            }
        })
    } else if (selval == "1") {        //预付款流水报表
        $.ajax({
            url: path + "/reportform/GetPayment",
            type: 'post',
            data: null,
            dataType: 'json',
            async: false,
            success: function (result) {
                if (selval == "1") {
                    var item1;
                    $('#AdvanceCharge tbody').remove();
                    $.each(result, function (i, result) {   //$.each()  遍历
                        item1 = " <tbody><tr class=\"noExl\"><td class=\"success\">" + result['id'] + "</td><td class=\"success\">" + result['userName'] + "</td><td class=\"success\">" + result['money'] + "</td><td class=\"success\">" + result['accountMoney'] + "</td><td class=\"success\">" + result['memo'] + "</td><td class=\"success\">" + result['detailDateTime'] + "</td></tr></tbody>";

                        $('#AdvanceCharge').append(item1);
                        $("#AccountBalanceDiv").css({"display": "none", "margin": "0 auto"});
                        $("#ProductDiv").css({"display": "none", "margin": "0 auto"});
                        $("#AdvanceChargeDiv").css({"display": "block", "margin": "0 auto"});
                    });
                }
            },
            erorr: function () {
                alert("有异常！");
            }
        })
    } else if (selval == "3") {         //产品分类数量/金额总汇<
        $.ajax({
            url: path + "/reportform/Totalsummoney",
            type: 'post',
            data: null,
            dataType: 'json',
            async: false,
            success: function (result) {
                if (selval == "3") {
                    var item1;
                    $('#Product tbody').remove();
                    $.each(result, function (i, result) {   //$.each()  遍历
                        item1 = " <tbody><tr class=\"noExl\"><td class=\"success\">" + result['id'] + "</td><td class=\"success\">" + result['configTypeName'] + "</td><td class=\"success\">" + result['configTypeValue'] + "</td><td class=\"success\">" + result['configValue'] + "</td></tr></tbody>";

                        $('#Product').append(item1);

                        $("#AccountBalanceDiv").css({"display": "none", "margin": "0 auto"});
                        $("#ProductDiv").css({"display": "block", "margin": "0 auto"});
                        $("#AdvanceChargeDiv").css({"display": "none", "margin": "0 auto"});
                    });
                }
            },
            erorr: function () {
                alert("有异常！");
            }
        })
    }
}
