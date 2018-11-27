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
//    public static void main(String[] args){
//        fenxiangImg("测试", "D:\\new.jpg", "D:\\fenxiang_base.jpg","D:\\headimg.jpg","http://www.baidu.com/");
//    }

    public static void main(String[] args) {

        try {
            String targetImg = "D:\\new.jpg";

            // 主图
            String mainImgTmp = "D:\\main.jpg";
            File mainImgF = new File(mainImgTmp);
            // 店铺类型
            String shopType = "B";
            // 标题
            String title = "俞兆林卫衣 男2017春新款运动休闲印花大码潮人卫衣卫裤加厚外套装男";
            // 二维码数据
            String qrCode = "http://192.168.10.205:3334";
            // 折扣价
            String zkPrice = "86.27";
            // 原价
            String yjPrice = "121.87";
            // 是否包邮
            boolean baoyou = true;
            // 券
            String quan = "55";
            // 月销量
            String volume = "325";

            int width = 640;
            int height = 950;
            BufferedImage imageNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = imageNew.createGraphics();

            // 填充背景色：白色
            Color color = Color.white;
            g.setColor(color);
            g.fillRect(0,0, width, height);

            // 商品主图
            BufferedImage mainImgBuf = ImageIO.read(mainImgF);
            int mainW = mainImgBuf.getWidth();
            int mainH = mainImgBuf.getHeight();
            int tempH = mainH * 640 / mainW;
            g.drawImage(mainImgBuf, 0, 0, 640, tempH, null);
            //        mainImgF.delete();

            // 店铺类型
            if(shopType != null){
                if(shopType.equals("B")){ // 天猫
                    String tianmaoTmp = "D:\\icon_tianmao.png";
                    BufferedImage tianmaoIcon = ImageIO.read(new File(tianmaoTmp));
                    g.drawImage(tianmaoIcon, 20, tempH + 25, 40, 40, null);
                }else if(shopType.equals("C")){ // 淘宝
                    String tiaobaoTmp = "D:\\icon_tiaobao.png";
                    BufferedImage tiaobaoTmpIcon = ImageIO.read(new File(tiaobaoTmp));
                    g.drawImage(tiaobaoTmpIcon, 20, tempH + 25, 40, 40, null);
                }
            }

            // 二维码
            BufferedImage qrCodeImg = QRCodeUtil.encodeToBufferedImage(qrCode,BarcodeFormat.QR_CODE,200,200);
            if(qrCodeImg != null){
                g.drawImage(qrCodeImg,null, 435,tempH + 15);
            }

            // 长按识别二维码，免费领券
            Font font = new Font("微软雅黑", Font.PLAIN, 24);
            color = Color.black;
            g.setColor(color);
            g.setFont(font);
            g.drawString("长按识别二维码", 450,tempH +225);
            color = new Color(251, 67, 62);
            g.setColor(color);
            g.drawString("免费领券", 485,tempH +260);

            // 标题
            font = new Font("微软雅黑", Font.PLAIN, 28);
            g.setFont(font);
            color = new Color(55,55,55);
            g.setColor(color);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int line = 0;
            int lenW = 0;
            int charNum = 0;
            FontMetrics fm = g.getFontMetrics(font);
            for(int i = 0; i < title.length(); i++){
                lenW = fm.charWidth(title.charAt(i)) + lenW;
                if(line == 0){ // 首行缩进
                    if(lenW >= 336){
                        g.drawString(title.substring(charNum, i), 76,tempH + 60);
                        charNum = i;
                        lenW = 0;
                        line++;
                    }
                }else{
                    if(lenW >= 392){
                        g.drawString(title.substring(charNum, i), 20,(tempH + 60) + (40 * line));
                        charNum = i;
                        lenW = 0;
                        line++;
                    }
                }
            }
            if(title.substring(charNum).length() > 0){ // 最后一行不够整行宽度时，for循环不打印最后一行
                g.drawString(title.substring(charNum), 20,(tempH + 60) + (40 * line));
            }
            // 折扣价
            color = new Color(255, 68, 0);
            g.setColor(color);
            font = new Font("微软雅黑", Font.PLAIN, 25);
            g.setFont(font);
            g.drawString("券后", 20,(tempH + 60) + (35 * line) + 60);
            font = new Font("微软雅黑", Font.PLAIN, 30);
            g.setFont(font);
            String zkPriceStr = "¥ "+zkPrice;
            g.drawString(zkPriceStr, 80,(tempH + 60) + (35 * line) + 63);

            // 是否包邮
            if(baoyou){
                fm = g.getFontMetrics(font);
                int baoyouW = fm.stringWidth(zkPriceStr);
                g.fillRect(80 + baoyouW + 20, (tempH + 60) + (35 * line) + 40,46, 26);
                font = new Font("微软雅黑", Font.BOLD, 18);
                g.setFont(font);
                color = Color.white;
                g.setColor(color);
                g.drawString("包邮", 80 + baoyouW + 20 + 4,(tempH + 60) + (35 * line) + 59);
            }

            // 原价
            color = new Color(95, 95, 95);
            g.setColor(color);
            font = new Font("微软雅黑", Font.PLAIN, 22);
            g.setFont(font);
            g.drawString("原价", 20,(tempH + 60) + (35 * line) + 105);
            String yjPriceStr = "¥ "+yjPrice;
            g.drawString(yjPriceStr, 75,(tempH + 60) + (35 * line) + 107);
            // 原价删除线
            fm = g.getFontMetrics(font);
            int delLineW = fm.stringWidth(yjPriceStr);
            g.drawLine(75,(tempH + 60) + (35 * line) + 100, 75 + delLineW,(tempH + 60) + (35 * line) + 95);

            // 月销量
            font = new Font("微软雅黑", Font.PLAIN, 20);
            g.setFont(font);
            g.drawString("月销" + volume + "件", 75 + delLineW + 115,(tempH + 60) + (35 * line) + 105);

            // 券
            color = new Color(255, 68, 0);
            g.setColor(color);
            g.fillRoundRect(75 + delLineW + 10, (tempH + 60) + (35 * line) + 85, 30,26, 5, 5);
            g.drawRoundRect(75 + delLineW + 36,(tempH + 60) + (35 * line) + 85,72,25,5,5);
            font = new Font("微软雅黑", Font.BOLD, 18);
            g.setFont(font);
            color = Color.white;
            g.setColor(color);
            g.drawString("券", 75 + delLineW + 16,(tempH + 60) + (35 * line) + 105);
            font = new Font("微软雅黑", Font.BOLD, 18);
            g.setFont(font);
            color = new Color(255, 68, 0);
            g.setColor(color);
            int quanW = fm.stringWidth(quan);
            g.drawString("元", 75 + delLineW + 36 + quanW + (quanW / 2),(tempH + 60) + (35 * line) + 103);
            g.drawString(quan, 75 + delLineW + 36 + (quanW / 2),(tempH + 60) + (35 * line) + 105);

            // 底部
            color = new Color(255, 207, 207);
            g.setColor(color);
            g.fillRect(0, height - 100, width,80);
            color = new Color(155, 55, 55);
            g.setColor(color);
            font = new Font("楷体", Font.BOLD, 30);
            g.setFont(font);
            String dbTxt = "粉丝福利优惠券，别的地方看不到哦";
            fm = g.getFontMetrics(font);
            int dbW = fm.stringWidth(dbTxt);
            g.drawString(dbTxt, (width - dbW ) / 2,height - 50);
            File outputfile = new File(targetImg);
            ImageIO.write(imageNew,"jpg", outputfile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
