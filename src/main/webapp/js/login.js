// 失去会话后跳转到login.html页面时,保持login.html页面为最前端
// [注意]如果Spring Security已经配置.loginPage("/")则不用设置, 否则会一直不听跳转本页面
/*if(top.location != location){
    top.location.href = location.href;
}*/

let loading = document.getElementById('loading');

function load() {
    setTimeout("loading.style.transition='opacity 0.3s'",0);
    //设置透明度改变的过渡时间为0.3秒
    setTimeout("loading.style.opacity='0'",500);
    //0.5秒后加载动画开始变为透明
    setTimeout("loading.style.display='none'",800);
    //当透明度为0的时候，隐藏掉它
}

function submitCheck() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    if ((username == "") || (password == "")) {
        return "账号或密码不能为空"
    }

    return "账号或密码不能为空";
}
