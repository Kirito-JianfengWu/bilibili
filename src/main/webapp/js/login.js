// 失去会话后跳转到login.html页面时,保持login.html页面为最前端
// [注意]如果Spring Security已经配置.loginPage("/")则不用设置, 否则会一直不听跳转本页面
/*if(top.location != location){
    top.location.href = location.href;
}*/

// 此时jQuery还没有进行加载(就算放在header里也不能在body加载前完成加载), 所以不能使用jQuery写法
document.onreadystatechange = function() {
    if (document.readyState === "complete") {
        let loader = document.getElementById("loader");
        let main = document.getElementsByClassName("loginBox").item(0);

        loadCompleteFallingAnimate(1, 10, 700, loader, main);

        // autofocus属性失效, 页面加载完后主动focus
        $("#username").focus();
    }
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
                layer.tips(message, "#username", {
                    tips: [1, '#3299fe'],
                    time: 4000
                });
            } else {
                layer.tips(message, "#password", {
                    tips: [1, '#3299fe'],
                    time: 4000
                });
            }
            return false;
        }

        $("#loginForm").submit();
    });
});
