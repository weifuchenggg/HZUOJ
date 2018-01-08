//设置导航功能页面的高度
function reinitIframe(){
    var iframeHeight = $("#naviframe").contents().find("body").height();
    $("#naviframe").height(iframeHeight+50);
}
$(function () {
    //自动设置高度
    window.setInterval("reinitIframe()", 200);



});

//需要跳转的链接
function naviframe_src(src) {
    $("#naviframe").attr("src", src);
}