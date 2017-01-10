// window.onload=function (){
//     $("#content").load('jsp/account/account.jsp',1,function () {
//         $.getScript('js/common/common.js');
//         $.getScript('js/account/account.js',function () {
//             // changePage(curPage);
//             // $("#content").refresh();
//             console.log("123123123");
//         });
// });
// }

function clickMenu(element)
{
    var a=$(element).children('span');
    var b=a.attr('id');
    $("#content").load('jsp/account/account.jsp',1,function () {
        $.getScript('js/account/account.js',function () {
            changePage(1);
            // changePage(curPage);
            // $("#content").refresh();
        });
    });
}

function initPage()
{

}