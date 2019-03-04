$(function(){

    $("#loginBtn").on("click",function(){
       console.log("事件启动");
        payLogin();
    })

});
//login
function payLogin(){
    var userName = $("#username").val();
    var pwd = $("#password").val();
    console.log("username="+userName+"and pwd="+pwd);

    $.post("/login/checkUserLogin",{"username":userName,"password":pwd},function(data){
        console.log(data);
    });
}