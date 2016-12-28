/**
 * Created by Anthony on 2016/12/27.
 */

var loginFunc = function () {
    $.ajax({
        cache: true,
        type: "POST",
        url: "login/login.do",
        contentType : 'application/json',
        data: {
            userName: $('#username').val(),
            passWord: $('#password').val()
        },
        async: false,
        success: function (data) {
            allPrpos(data);

            // $("#commonLayout_appcreshi").parent().html(data);
        },
        error: function (request) {
            allPrpos(request);
        }
    });
}

function allPrpos(obj) {
    // 用来保存所有的属性名称和值
    var props = "";
    var test="";
    // 开始遍历
    for (var p in obj) { // 方法
        if (typeof ( obj [p]) == " function ") {
            obj [p]();
        } else { // p 为属性名称，obj[p]为对应属性的值
            props += p + " = " + obj [p] + " /n ";
            test +=obj [p];
        }
    } // 最后显示所有的属性
    alert(props);
    alert(test);
}