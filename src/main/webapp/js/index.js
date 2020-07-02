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

    document.getElementsByClassName("main").item(0).style.display="block";
}