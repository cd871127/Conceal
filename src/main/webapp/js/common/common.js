/**
 * Created by Anthony on 2017/1/2.
 */

//create table
var tableID = 0;
function createTable(columnName) {
    tableID++;
    var table = $("<table></table>");
    table.attr("id", "table" + tableID);
    table.attr("border", "1");
    var tableHead = $("<tr></tr>");
    for (var i in columnName) {
        var tableHeadCol = $("<td></td>");
        tableHeadCol.text(columnName[i]);
        tableHead.append(tableHeadCol);
    }
    table.append(tableHead);
    return table;
}



//查询数据字典
function queryDataDict(columnName) {
    var dataDict="";
    $.ajax({
        cache: true,
        type: "POST",
        url: "common/queryDataDict.do",
        data: {
            columnName:columnName
        },
        async: false,
        success: function (res) {
            if (res.code == '00') {
                dataDict= res.content;
            }
            else {
                alert(res.message);
            }
        },
        error: function (request) {
            alert("连接失败");
        }
    });
    return dataDict;
}


