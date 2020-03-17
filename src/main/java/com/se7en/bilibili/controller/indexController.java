package com.se7en.bilibili.controller;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class indexController {

    //Spring Security BCrypt加密方式
//    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    //设置日期格式
//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    /**
//     * 处理头像
//     * @param img
//     */
    /*public static void rotundity_img(String img) {
        try {
            // 读取图片
            BufferedImage bi1 = ImageIO.read(new File(img));
            // 创建一个带透明色的BufferedImage
            BufferedImage image = new BufferedImage(bi1.getWidth(), bi1.getHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            // 创建一个椭圆形的2D图像
            Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, bi1.getWidth(), bi1
                    .getHeight());
            Graphics2D g2 = image.createGraphics();
            // 使用 setRenderingHint 设置抗锯齿
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            image = g2.getDeviceConfiguration().createCompatibleImage(bi1.getWidth(), bi1.getHeight(), Transparency.TRANSLUCENT);
            g2 = image.createGraphics();
            // 使用 setRenderingHint 设置抗锯齿
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    *//*        g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, WIDTH, HEIGHT);*//*
            g2.setComposite(AlphaComposite.Clear);
            g2.fill(new Rectangle(image.getWidth(), image.getHeight()));
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 1.0f));
            g2.setClip(shape);
            g2.drawImage(bi1, 0, 0, null);
            g2.dispose();
            ImageIO.write(image, "png", new File(img));
            System.out.println("已将"+"img"+"裁剪成圆形.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
//        System.out.println("(/, "+simpleDateFormat.format(new Date())+")");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
//        System.out.println("(/login, "+simpleDateFormat.format(new Date())+")");
        return "index";
    }
}
