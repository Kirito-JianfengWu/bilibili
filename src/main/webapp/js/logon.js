// 此时jQuery还没有进行加载(就算放在header里也不能在body加载前完成加载), 所以不能使用jQuery写法
document.onreadystatechange = function() {
    if (document.readyState === "complete") {
        let loader = document.getElementById("loader");
        let main = document.getElementsByClassName("main").item(0);

        loadCompleteFallingAnimate(1, 10, 700, loader, main, "0.3s", 0);
    }
}