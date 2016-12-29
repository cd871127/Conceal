/**
 * Created by Anthony on 2016/12/27.
 */

function login() {
    $.ajax({
        cache: true,
        type: "POST",
        url: "/login/login.do",
        data: {
            userName: $('#userName').val(),
            passWord: $('#passWord').val()
        },
        async: false,
        success: function (res) {
            if (res.code == '01') {
                var messageLabel = $('#errorMessage');
                messageLabel.text(res.message);
                messageLabel.show();
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

function openRegisterPage()
{
    location.href="/register/register.do";
}

