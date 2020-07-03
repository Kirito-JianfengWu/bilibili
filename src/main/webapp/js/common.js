// 此时jQuery还没有进行加载(就算放在header里也不能在body加载前完成加载), 所以不能使用jQuery写法
// 页面加载完成后隐藏loader.html[iframe]
function loadCompleteFallingAnimate(startOpacity, mySubTime, myTotalTime, myLoader, myMain) {
    // h = (g * t^2) / 2 自由落体距离公式 h[距离] g[重力加速度] t[时间]
    let opacity = startOpacity;
    let h = startOpacity;
    let subTime = mySubTime;
    let totalTime = myTotalTime;
    let t = totalTime / 1000;
    let g = (2 * h) / Math.pow(t, 2);
    let n = 0;
    let tn = 0;
    let tnDecrease1 = 0;
    let hn = 0;
    let hnDecrease1 = 0;

    let loader = myLoader;
    let main = myMain;

    // 设置透明度改变的过渡时间为0.3秒
    setTimeout("loader.style.transition='opacity 0.3s'",0);

    // 1秒的加载动画不透明->透明渐变过程
    // 当透明度为0的时候，移出或隐藏loader
    // setTimeout("loader.style.opacity='0'",500);
    // setTimeout("loader.style.display='none'",800);
    // console.log(new Date());
    let timer = setInterval(function () {
        if (opacity <= 0) {
            clearInterval(timer);
            loader.remove();
            // console.log(new Date());
        }

        tn = n * (subTime / totalTime) * t;
        tnDecrease1 = (n === 0 ? 0 : n - 1) * (subTime / totalTime) * t;
        hn = (g / 2) * Math.pow(tn, 2);
        hnDecrease1 = (g / 2) * Math.pow(tnDecrease1, 2);

        loader.style.opacity = opacity;

        opacity -= (hn - hnDecrease1);
        n++;

        // console.log(opacity);
    }, subTime);

    main.style.display="block";
}
