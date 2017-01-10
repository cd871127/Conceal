/**
 * Created by Anthony on 2017/1/1.
 */

var curPage = 1;
var pageSize = 10;
var table;
var dataDict;
var columnName = [
    '账户名',
    '密码',
    '描述',
    '链接',
    '类型',
    '创建日期',
    '更新日期'
];
var objAttr = [
    'id',
    'accountName',
    'accountPassWord',
    'accountDesc',
    'accountUrl',
    'accountType'
    // ,
    // 'createDate',
    // 'updateDate'
];

//绑定回车
function bindEnter(element) {
    $("body").keydown(function () {
        if (event.keyCode == "13") {//keyCode=13是回车键
            element.click();
        }
    });
}

function buklDel() {
    var ids = getSelectedDataIDs();
    delAccount(ids);
    $("#mainCheckBox").attr("checked", "unchecked");
}

function addData() {
    $(".btn.btn-sm.btn-default").attr({"disabled": "disabled"});
    buildAccountForm();
}


//刷新页面
function changePage(page) {
    var dataCount = getAccountDataCount();
    dataDict = queryDataDict(['account_type']);
    $("#accountData").empty();
    if (dataCount == 0) {
        $("#tableFooter").hide();
    }
    else {
        $("#tableFooter").show();
        var maxPage = Math.ceil(dataCount / pageSize);
        if (page < 1) {
            page = 1;
        }
        if (page > maxPage) {
            page = maxPage;
        }
        curPage = page;
        showTableFooter(dataCount);
        getAccountData(page);
    }
}

function nextPage() {
    changePage(++curPage);
}

function prePage() {
    changePage(--curPage);
}

//填充表格
function fillTableData(table, data) {
    for (var i in data) {
        var newTr = $("<tr></tr>");
        for (var j in data[i]) {
            var newTd;
            if (j == 0) {
                newTd = $("<td><input type='checkbox' value='" + data[i][j] + "'></td>");
                var id = data[i][j];
            } else {
                newTd = $("<td></td>");
                newTd.text(data[i][j]);
            }
            newTr.append(newTd);
        }
        newTd = $("<td><button class='btn btn-sm btn-default' onclick='editAccount(" + id + ")'>Edit</button>&nbsp;&nbsp;&nbsp;&nbsp;<button class='btn btn-sm btn-default' onclick='delAccount(" + id + ")'>Del</button></td>");
        newTr.append(newTd);
        newTr.attr("id", "data" + id);
        table.append(newTr);
    }
    return table;
}

//数据转换为数组
function objectsToArray(objAttr, objects) {
    var data = new Array();
    for (var i in objects) {
        var tmp = new Array();
        for (var j in objAttr) {
            tmp.push(objects[i][objAttr[j]]);
        }
        data.push(tmp);
    }
    return data;
}

function showTableFooter(dataCount) {
    var tableFooter = $("#tableFooter");
    tableFooter.children('#detailCount').remove();
    tableFooter.children('#pageListDiv').remove();
    var startIndex = (curPage - 1) * pageSize + 1;
    var endIndex = curPage * pageSize;
    if (endIndex > dataCount) {
        endIndex = dataCount;
    }
    var detailCount = $("<div id='detailCount' class='col-sm-4 text-center'> <small class='text-muted inline m-t-sm m-b-sm'>showing " + startIndex + "-" + endIndex + " of " + dataCount + " items</small> </div>");
    var pageListDiv = $("<div id='pageListDiv' class='col-sm-4 text-right text-center-xs'>");
    var pageList = $("<ul class='pagination pagination-sm m-t-none m-b-none'>");
    var prePageBtn = $("<li><a onclick='prePage()'><i class='fa fa-chevron-left' ></i></a></li>");
    var nextPageBtn = $("<li><a onclick='nextPage()'><i class='fa fa-chevron-right'></i></a></li>");

    tableFooter.append(detailCount);
    tableFooter.append(pageListDiv);
    pageListDiv.append(pageList);
    pageList.append(prePageBtn);
    pageList.append(nextPageBtn);
}

//查询数据
function getAccountData(page) {
    var startIndex = (page - 1) * pageSize;
    $.ajax({
        cache: true,
        type: "POST",
        url: "account/queryAccount.do",
        data: {
            pageSize: pageSize,
            startIndex: startIndex
        },
        dataType: "json",
        async: false,
        dataFilter: function (data, type) {
            data = $.parseJSON(data);
            var content = data.content;
            for (var i in content) {
                content[i].createDate = new Date(content[i].createDate);
                content[i].updateDate = new Date(content[i].updateDate);
                content[i].accountType = dataDict.account_type[content[i].accountType];
            }
            return JSON.stringify(data);
        },
        success: function (res) {
            if (res.code == '00') {
                fillTableData($("#accountData"), objectsToArray(objAttr, res.content));
            }
            else {
                alert(res.message);
            }
        },
        error: function (request) {
            alert("连接失败");
        }
    });
}

//查询数据数量
function getAccountDataCount() {
    var count = -1;
    $.ajax({
        cache: true,
        type: "POST",
        url: "account/queryAccountCount.do",
        async: false,
        success: function (res) {
            if (res.code == '00') {
                count = res.content;
            }
            else {
                alert(res.message);
            }
        },
        error: function (request) {
            alert("连接失败");
        }
    });
    return count;
}

function test() {
    // delAccount();
    alert(getAccountDataCount());
}

//获取选择数据的id
function getSelectedDataIDs() {
    var ids = "";
    $('#accountData').find('input:checkbox').each(function () {
        if ($(this).prop("checked") == true) {
            ids += $(this).val() + ",";
        }
    });
    if (ids.charAt(ids.length - 1) == ",")
        ids = ids.substr(0, ids.length - 1);
    return ids;
}

function buildAccountForm() {
    var table = $("#accountData");
    var newTr = $("<tr></tr>");
    var newTd = $("<td></td>");
    var newBtn = $("<button class='btn btn-sm btn-default' onclick='addAccount()'>OK</button>");
    newTd.append(newBtn);
    // $("body").keydown(function () {
    //     if (event.keyCode == "13") {//keyCode=13是回车键
    //         newBtn.click();
    //     }
    // });
//     var newTd = $("<td><a class='active' onclick='addAccount()'><i class='fa fa-check text-success text-active'></i></a></td>");
    newTr.append(newTd);
    newTd = $("<td><input id='accountName' type='text' class='input-sm form-control'></td>");
    newTr.append(newTd);
    newTd = $("<td><input id='accountPassWord' type='text' class='input-sm form-control'></td>");
    newTr.append(newTd);
    newTd = $("<td><input id='accountDesc' type='text' class='input-sm form-control'></td>");
    newTr.append(newTd);
    newTd = $("<td><input id='accountUrl' type='text' class='input-sm form-control'></td>");
    newTr.append(newTd);
// &nbsp;&nbsp;&nbsp;&nbsp;<a class='active' onclick='cancelAddAccount()'><i class='fa fa-times text-danger text-active'></i></a>
    newTd = $("<td><select id='accountType' class='input-sm form-control input-s-sm inline'></select></td>");
    for (var key in dataDict.account_type) {
        newTd.find('#accountType').append("<option value='" + key + "'>" + dataDict.account_type[key] + "</option>");
    }
    newTr.append(newTd);
    newTd = $("<td><button class='btn btn-sm btn-default' onclick='cancelAddAccount()'>Cancel</button></td>");
    newTr.append(newTd);
    table.prepend(newTr);
}

function cancelAddAccount() {
    changePage(curPage);
    $(".btn.btn-sm.btn-default").removeAttr("disabled");
}

function addAccount() {
    $.ajax({
        cache: true,
        type: "POST",
        url: "account/addAccount.do",
        data: {
            accountName: $("#accountName").val(),
            accountPassWord: $("#accountPassWord").val(),
            accountDesc: $("#accountDesc").val(),
            accountUrl: $("#accountUrl").val(),
            accountType: $("#accountType").val()
        },
        dataType: "json",
        async: false,
        success: function (res) {
            if (res.code == '00') {
                changePage(curPage);
                $(".btn.btn-sm.btn-default").removeAttr("disabled");
            }
            else {
                alert(res.message);
            }
        },
        error: function (request) {
            alert("连接失败");
        }
    });
}

function delAccount(ids) {
    $.ajax({
        cache: true,
        type: "POST",
        url: "account/delAccount.do",
        data: {
            ids: ids
        },
        dataType: "json",
        async: false,
        success: function (res) {
            if (res.code == '00') {
                changePage(curPage);
            }
            else {
                alert(res.message);
            }
        },
        error: function (request) {
            alert("连接失败");
        }
    });
}

function editAccount(id) {
    var tr = "#data" + id;
    var trChild = $(tr).children();
    trChild.each(
        function (index) {
            if (index == 0) {
                $(this).attr("value", id);
                $(this).empty();
                var newBtn = $("<button class='btn btn-sm btn-default' onclick='updateAccount("+tr+")'>OK</button>");
                $(this).append(newBtn);
            }
            else if (index == trChild.length - 1) {

            }
            else {
                var text = $(this).text();
                $(this).empty();
                var inp = $("<input type='text' value='" + text + "'>");
                $(this).append(inp);
            }
        }
    );
}

function updateAccount(tr) {
    var id;
    console.log(tr);
    // var trChild = $(tr).children();
    // trChild.each(
    //     function (index) {
    //         if (index == 0) {
    //             id=$(this).attr("value");
    //             console.log(id);
    //         }
    //     }
    // );
}