/**
 * Created by Anthony on 2016/12/29.
 */

function register() {
    $.ajax({
        cache: true,
        type: "POST",
        url: "/user/register.do",
        data: {
            userName: $('#userName').val(),
            passWord: $('#passWord').val(),
            eMail: $('#eMail').val(),
            telephone: $('#telephone').val()
        },
        async: false,
        success: function (res) {
            if (res.code == '01') {
                alert(res.message);
            }
            else if (res.code == '00') {
                alert(res.message);
            }
        },
        error: function (request) {
            alert("连接失败");
        }
    });
}