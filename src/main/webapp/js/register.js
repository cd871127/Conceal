/**
 * Created by Anthony on 2016/12/29.
 */

function register() {
    $.ajax({
        cache: true,
        type: "POST",
        url: "/register/register.do",
        data: {
            userName: $('#userName').val(),
            passWord: $('#passWord').val(),
            eMail: $('#eMail').val(),
            telephone: $('#telephone').val()
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