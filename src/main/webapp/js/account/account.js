/**
 * Created by Anthony on 2017/1/1.
 */

function queryAccount() {
    var pageSize = 10;
    $.ajax({
        cache: true,
        type: "POST",
        url: "account/queryAccount.do",
        data: {
            pageSize: pageSize
        },
        async: false,
        success: function (res) {
            if (res.code == '01') {
                alert(res.message);
            }
            else if (res.code == '00') {

                location.href = "user/success.do";
            }
        },
        error: function (request) {
            alert("连接失败");
        }
    });
}

function showList(resList) {

}
