package com.dape.shop.web.controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[] args){
        try {
            String name = "我是测试";
            String remark = "正在使用";
            int width = 640;
            int height = 1134;

            BufferedImage imageNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = imageNew.createGraphics();

            Image imgBase = ImageIO.read(new File("E:\\huo\\project\\weixin\\ncoffice\\dape-ui\\dape-shop-web\\images\\fenxiang_base.jpg"));
            g.drawImage(imgBase, 0, 0, width, height, null);
//            g.setColor(markContentColor); //根据图片的背景设置水印颜色

            Image imgHead = ImageIO.read(new File("E:\\huo\\project\\weixin\\ncoffice\\dape-ui\\dape-shop-web\\images\\headimg.jpg"));
            g.drawImage(imgHead, 245, 50, 150, 150, null);

            Font font = new Font("微软雅黑", Font.PLAIN, 30);
            Color color = Color.white;
            g.setFont(font);
            g.setColor(color);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            FontMetrics fm = g.getFontMetrics(font);
            int textWidth = fm.stringWidth(name);
            int widthX = (width - textWidth) / 2;
            g.drawString(name, widthX,250);

            textWidth = fm.stringWidth(remark);
            widthX = (width - textWidth) / 2;
            g.drawString(remark, widthX,290);

            File outputfile = new File("D:\\new.jpg");
            ImageIO.write(imageNew,"jpg", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
