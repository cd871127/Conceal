/**
 * Created by Anthony on 2016/12/27.
 */

var loginFunc = function()
{
    $.ajax({
        cache: true,
        type: "POST",
        url:"login/login.do",
        data:{
            username:$('#username').val(),
            password:$('#password').val()
        },
        async: false,
        success: function(data) {
            alert(data);
            $("#commonLayout_appcreshi").parent().html(data);
        },
        error: function(request) {
            alert("Connection error");
        }

    });
}