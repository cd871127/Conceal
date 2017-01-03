/**
 * Created by Anthony on 2017/1/1.
 */

var curPage = 1;
var table;
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
    'accountName',
    'accountPassWord',
    'accountDesc',
    'accountUrl',
    'accountType',
    'createDate',
    'updateDate'
];
function queryAccount(curPage) {
    var pageSize = 10;
    var startIndex = (curPage - 1) * pageSize;
    $.ajax({
        cache: true,
        type: "POST",
        url: "account/queryAccount.do",
        data: {
            pageSize: pageSize,
            startIndex: startIndex
        },
        async: false,
        success: function (res) {
            if (res.code == '00') {
                var data = formatData(res.content);
                fillTableData(table, objectsToArray(objAttr, res.content));
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

//格式化数据 转换日期
function formatData(data) {
    for (var i in data) {
        data[i].createDate = new Date(data[i].createDate);
        data[i].updateDate = new Date(data[i].updateDate);
    }
}


window.onload = function () {
    table = createTable(columnName);
    table.appendTo("#tableDiv");
    queryAccount(curPage++);
}