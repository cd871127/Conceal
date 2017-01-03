/**
 * Created by Anthony on 2016/12/29.
 */

function register() {
    $.ajax({
        cache: true,
        type: "POST",
        url: "user/register.do",
        data: {
            userName: $('#userName').val(),
            passWord: $('#passWord').val(),
            eMail: $('#eMail').val(),
            telephone: $('#telephone').val()
        },
        async: false,
        success: function (res) {
            if (res.code == '00') {
                location.href = "user/success.do";
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