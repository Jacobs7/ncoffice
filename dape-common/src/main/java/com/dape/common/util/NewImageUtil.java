package com.dape.common.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NewImageUtil {

    /**
     *
     * @param name 微信名
     * @param targetImg 生成的新图片路径
     * @param baseImg 基础背景图
     * @param headImg 头像图片
     */
    public static void fenxiangImg(String name, String targetImg, String baseImg, String headImg, String qrCode){
        try {
            name = "我是" + name;
            String remark = "正在使用";
            int width = 640;
            int height = 1134;

            int codeW = 180;
            int codeH = 180;

            BufferedImage imageNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = imageNew.createGraphics();

            // 基本图
            Image imgBase = ImageIO.read(new File(baseImg));
            g.drawImage(imgBase, 0, 0, width, height, null);

            Font font = new Font("微软雅黑", Font.PLAIN, 30);
            Color color = Color.white;
            g.setFont(font);
            g.setColor(color);
            // 抗锯齿
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.fillRect(243,48,154,154);
            // 文字居中
            FontMetrics fm = g.getFontMetrics(font);
            int textWidth = fm.stringWidth(name);
            int widthX = (width - textWidth) / 2;
            g.drawString(name, widthX,250);

            textWidth = fm.stringWidth(remark);
            widthX = (width - textWidth) / 2;
            g.drawString(remark, widthX,290);

            // 头像
            Image imgHead = ImageIO.read(new File(headImg));
            g.drawImage(imgHead, 245, 50, 150, 150, null);

            BufferedImage qrCodeImg = QRCodeUtil.encodeToBufferedImage(qrCode,BarcodeFormat.QR_CODE,codeW,codeH);
            if(qrCodeImg != null){
                g.drawImage(qrCodeImg,null, 110,935);
            }

            File outputfile = new File(targetImg);
            ImageIO.write(imageNew,"jpg", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        fenxiangImg("测试", "D:\\new.jpg", "D:\\fenxiang_base.jpg","D:\\headimg.jpg","http://www.baidu.com/");
    }
}
