$(function(){

    $("#loginBtn").on("click",function(){
       console.log("事件启动");
        cmsLogin();
    })

});
//login
function cmsLogin(){
    var userName = $("#username").val();
    var pwd = $("#password").val();
    console.log("username="+userName+"and pwd="+pwd);

    $.post("/cms/checkUserLogin",{"username":userName,"password":pwd},function(data){


    });
}