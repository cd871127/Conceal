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

function clickMenu(e)
{
    // var a=$(e).children('span');
    // var b=a.attr('id');
        $("#content").load('jsp/account/account.jsp',1,function () {
            $.getScript('js/account/account.js',function () {
                getAccountData();
            // changePage(curPage);
            // $("#content").refresh();
        });
});
}

function initPage()
{

}