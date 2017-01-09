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

//刷新页面
function changePage(page) {
    curPage = page;
    var dataCount = getAccountDataCount();
    var maxPage = Math.ceil(dataCount / pageSize);
    if (page < 1) {
        page = 1;
    }
    if (page > maxPage) {
        page = maxPage;
    }
    getAccountData(page);
}

function nextPage() {
    changePage(++curPage);
}
function prePage() {
    changePage(--curPage);
}

//填充表格
function fillTableData(table, data) {
    table.empty();
    for (var i in data) {
        var newTr = $("<tr></tr>");
        for (var j in data[i]) {
            var newTd;
            if (j == 0) {
                newTd = $("<td><input type='checkbox' value='" + data[i][j] + "'></td>");
            } else {
                newTd = $("<td></td>");
                newTd.text(data[i][j]);
            }
            newTr.append(newTd);
        }
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

//查询数据
function getAccountData(page) {
    dataDict = queryDataDict(['account_type']);
    // var startIndex = 0;
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

// function queryAccount(curPage) {
//     var pageSize = 10;
//     var startIndex = (curPage - 1) * pageSize;
//     $.ajax({
//         cache: true,
//         type: "POST",
//         url: "account/queryAccount.do",
//         data: {
//             pageSize: pageSize,
//             startIndex: startIndex
//         },
//         dataType: "json",
//         async: false,
//         dataFilter: function (data, type) {
//             data = $.parseJSON(data);
//             var content = data.content;
//             for (var i in content) {
//                 content[i].createDate = new Date(content[i].createDate);
//                 content[i].updateDate = new Date(content[i].updateDate);
//                 // content[i].accountType = dataDict.account_type[content[i].accountType];
//             }
//             return JSON.stringify(data);
//         },
//         success: function (res) {
//             if (res.code == '00') {
//                 console.log("123123123");
//                 fillTableData(table, objectsToArray(objAttr, res.content));
//             }
//             else {
//                 alert(res.message);
//             }
//         },
//         error: function (request) {
//             alert("连接失败");
//         }
//     });
// }

function addAccount() {
}

function delAccount() {
    var ids = getSelectedDataIDs();
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
                ;
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
function editAccount() {
}


// function changePage(curPage) {
//     $("#tableDiv").children().remove();
//     table = createTable(columnName);
//     table.appendTo("#tableDiv");
//     queryAccount(curPage);
// }
//
// window.onload = function () {
//     dataDict = queryDataDict(['account_type']);
//     changePage(curPage++);
// }

//
// $(this).dataTable({
//     "bProcessing": true,
//     "sAjaxSource": "js/data/datatable.json",
//     "sDom": "<'row'<'col-sm-6'l><'col-sm-6'f>r>t<'row'<'col-sm-6'i><'col-sm-6'p>>",
//     "sPaginationType": "full_numbers",
//     "aoColumns": [{"mData": "engine"}, {"mData": "browser"}, {"mData": "platform"}, {"mData": "version"}, {"mData": "grade"}]
// });

// $("#resTable").DataTable({
//     "bProcessing": true,
//     "sAjaxSource": "js/data/datatable.json",
//     "sDom": "<'row'<'col-sm-6'l><'col-sm-6'f>r>t<'row'<'col-sm-6'i><'col-sm-6'p>>",
//     "sPaginationType": "full_numbers",
//     "aoColumns": [{"mData": "engine"}, {"mData": "browser"}, {"mData": "platform"}, {"mData": "version"}, {"mData": "grade"}]
// });

// $("#resTable").dataTable({
//     bProcessing: true,
//     sDom: "<'row'<'col-sm-6'l><'col-sm-6'f>r>t<'row'<'col-sm-6'i><'col-sm-6'p>>",
//     sPaginationType: "full_numbers",
//     sAjaxSource:"account/queryAccount.do",
//     sServerMethod:"POST",
//     // "fnServerData":{
//
//     "fnServerParams": function( aoData )
//     {
//         aoData.push(
//             {"name":"pageSize","value":"1000"},
//             {"name":"startIndex","value":"0"}
//         )
//     },
//     // fnServerParams:{
//     //         pageSize:1000,
//     //         startIndex:0
//     //     },
//     // },
//     "aoColumns": [{"mData": "engine"}, {"mData": "browser"}, {"mData": "platform"}, {"mData": "version"}, {"mData": "grade"}]
// });


// $("#tableid").DataTable({
//     ajax:{
//         url:"data.action",
//         type:"POST",
//         data:{
//             beginDate:"2016-04-18",
//             endDate:"2016-04-21"
//         }
//     },
//     columns:[
//         {data:"name"},
//         {data:"age"}
//     ]
// });