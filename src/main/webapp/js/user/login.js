/**
 * Created by Anthony on 2016/12/27.
 */

function login() {
    $.ajax({
        cache: true,
        type: "POST",
        url: "user/login.do",
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
                location.href="user/success.do";
            }
        },
        error: function (request) {
            alert("连接失败");
        }
    });
}

function jumpToRegister()
{
    location.href="user/register.do";
}

