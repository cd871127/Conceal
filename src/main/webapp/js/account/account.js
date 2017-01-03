/**
 * Created by Anthony on 2017/1/1.
 */

var curPage = 1;
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
        dataType:"json",
        async: false,
        dataFilter:function (data,type){
            data=$.parseJSON(data);
            var content=data.content;
            for (var i in content) {
                content[i].createDate = new Date(content[i].createDate);
                content[i].updateDate = new Date(content[i].updateDate);
                content[i].accountType=dataDict.account_type[content[i].accountType];
            }
            return JSON.stringify(data);
        },
        success: function (res) {
            if (res.code == '00') {
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

function addAccount()
{
}
function delAccount()
{
}
function editAccount()
{
}

function changePage(curPage)
{
    $("#tableDiv").children().remove();
    table = createTable(columnName);
    table.appendTo("#tableDiv");
    queryAccount(curPage);
}

window.onload = function () {
    dataDict=queryDataDict(['account_type']);
    changePage(curPage++);
}