
function register() {
    $.ajax({
        type: "POST",
        url: "/hzuoj/register",
        contentType:"application/json",
        data: JSON.stringify(this.user),
        success: function(data){
            if (data=="sucess"){
                alert("注册成功,正在跳转到登录页面!!");
                window.location.href="/hzuoj/toLogin";
            }else{
                alert("用户名已经存在!!");
            }
        },
        error:function(xhr,textStatus){
        }
    });
}

function login() {
    $.ajax({
        type: "POST",
        url: "/hzuoj/login",
        contentType:"application/json",
        data: JSON.stringify(this.user),
        success: function(data){
            if (data=="sucess")
              window.location.href="/hzuoj/index";
            else {
                alert("帐号不存在或者密码错误!");
            }
        },
        error:function(xhr,textStatus){
        }
    });
}