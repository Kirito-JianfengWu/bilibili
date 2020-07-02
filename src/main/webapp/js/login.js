// 失去会话后跳转到login.html页面时,保持login.html页面为最前端
// [注意]如果Spring Security已经配置.loginPage("/")则不用设置, 否则会一直不听跳转本页面
/*if(top.location != location){
    top.location.href = location.href;
}*/

// 这里由于是在body刚开始加载的时候调用的load()方法, 而load()方法又使用了临时变量loader
// 此时jQuery还没有进行加载(就算放在header里也不能在body加载前完成加载), 所以不能使用jQuery写法
let loader = document.getElementById("loader");

// 页面加载完成后隐藏loader.html[iframe]
function load() {
    //设置透明度改变的过渡时间为0.3秒
    setTimeout("loader.style.transition='opacity 0.3s'",0);
    //0.5秒后加载动画开始变为透明
    setTimeout("loader.style.opacity='0'",500);
    //当透明度为0的时候，隐藏掉它
    setTimeout("loader.style.display='none'",800);

    document.getElementsByClassName("loginBox").item(0).style.display="block";
}

// 绑定submit_btn的点击事件, 触发时由前端先验证用户名和密码是否为空
$(function () {
    $("#submit_btn").click(function () {
        // 如果登录界面上有后端返回登录失败的信息条, 在下次触发登录按钮点击事件时隐藏信息条
        let loginMessageInputBox = $("#loginMessageInputBox");
        let loginMessage = $("#loginMessage");
        if (loginMessage.val() !== undefined && loginMessage.val() !== "") {
            if (!loginMessageInputBox.hasClass("InVisible")) {
                loginMessageInputBox.addClass("InVisible");
            }
        }

        // 如果账号或者密码为空, focus()并弹出layer.tips提示
        let username = $("#username");
        let password = $("#password");
        let message = "";
        let isUsernameEmpty = false;
        if (username.val() === "") {
            isUsernameEmpty = true;
            message = "请输入账号!";
            username.focus();
        } else if (password.val() === "") {
            message = "请输入密码!";
            password.focus();
        }
        if (message !== "") {
            if (isUsernameEmpty) {
                layer.tips(message, "#usernameInputBox");
            } else {
                layer.tips(message, "#passwordInputBox");
            }
            return false;
        }

        $("#loginForm").submit();
    });
});
