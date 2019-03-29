package com.dape.common.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * 二维码工具类
 */
public class QRCodeUtil {


    private static final int BLACK = 0xff000000;
    private static final int WHITE = 0xFFFFFFFF;
    public static void encode(String contents, File file,String filePostfix, BarcodeFormat format, int width, int height, Map<EncodeHintType, ?> hints) {
        try {
            contents = new String(contents.getBytes("UTF-8"), "ISO-8859-1");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, format, width, height);
            writeToFile(bitMatrix, filePostfix, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        ImageIO.write(image, format, file);
    }
    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) == true ? BLACK : WHITE);
            }
        }
        return image;
    }

    public static BufferedImage encodeToBufferedImage(String contents, BarcodeFormat format, int width, int height){
        try {
            contents = new String(contents.getBytes("UTF-8"), "ISO-8859-1");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, format, width, height);
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) == true ? BLACK : WHITE);
                }
            }
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        String strJson = "http://www.163.cpm/";
        String path = "D:\\";
        String filePostfix = "jpg";
        String uuid = UUID.randomUUID().toString();
        File file = new File(path  +uuid + "."+filePostfix);
//        file.createNewFile();
        QRCodeUtil.encode(strJson, file,filePostfix, BarcodeFormat.QR_CODE, 200, 200, null);
        System.out.println(uuid+".png");
    }

}
