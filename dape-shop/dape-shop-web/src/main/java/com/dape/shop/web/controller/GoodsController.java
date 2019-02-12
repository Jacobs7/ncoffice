package com.dape.shop.web.controller;

import com.dape.common.base.BaseController;
import com.dape.common.util.QRCodeUtil;
import com.dape.shop.common.constant.ShopTypeEnum;
import com.dape.shop.dao.model.ShopGoods;
import com.dape.shop.dao.model.ShopStore;
import com.dape.shop.dao.model.ShopUser;
import com.dape.shop.dao.model.UpmsUser;
import com.dape.shop.rpc.api.ShopGoodsService;
import com.dape.shop.rpc.api.ShopStoreService;
import com.google.zxing.BarcodeFormat;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
@RequestMapping("goods")
public class GoodsController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private ShopGoodsService shopGoodsService;
    @Autowired
    private ShopStoreService shopStoreService;

    /**
     * 加载商品列表, ajax请求
     * @param pageNum 第几页
     * @param pageSize 每页多少条
     * @param query 查询条件
     * @return
     */
    @RequestMapping(value = "/loadGoods", method = RequestMethod.POST)
    @ResponseBody
    public List<ShopGoods> loadGoods(Integer pageNum, Integer pageSize, ShopGoods query) {
        return shopGoodsService.loadGoods(pageNum, pageSize, query);
    }

    /**
     * 商品详情
     * @param numIid id
     * @param platform 1:pc端,2:无线端
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/goodsDetail", method = RequestMethod.GET)
    public String goodsDetail(String numIid, Integer platform, Integer userid, Model model, HttpServletRequest request) {
        String ip = getIpAddress(request); // 真实ip地址

        // 商品
        ShopGoods shopGoods = shopGoodsService.findGoods(numIid,platform,ip);
        model.addAttribute("shopGoods", shopGoods);

        // 店铺
        ShopStore shopStore = shopStoreService.findShopStore(shopGoods.getSellerId().toString());
        model.addAttribute("shopStore", shopStore);

        // 分享方案  推荐理由、口令需要后续添加
        String shopTxt = ShopTypeEnum.getMessage("B");
        String copyTxt = shopGoods.getTitle() + "\n----------\n券后￥"+shopGoods.getZkFinalPrice()+"【优惠券"+shopGoods.getCouponInfo()+"元】\n原价￥"+shopGoods.getReservePrice() + (shopTxt==null?"":"【"+shopTxt+"】")+"\n----------\n推荐理由：大包装，全家一起泡，可以使用100次的艾草泡脚包，独立包装，吸湿暖足，排毒养颜，缓解疲劳，改善失眠，舒缓护理，家庭养生必备佳品，天然量多，效果好。\n----------\n￥joxNbkGCkNZ￥复制这条信息，打开手机淘宝即可领券";
        model.addAttribute("copyTxt", copyTxt);
        model.addAttribute("platform", platform);

        return thymeleaf("/goodsInfo");
    }

    /**
     * 转向查询页,get请求
     * @param pageNum 第几页
     * @param pageSize 每页多少条
     * @param sort 排序
     * @param query 查询条件
     * @param model
     * @return
     */
    @RequestMapping(value = "/toSearch", method = RequestMethod.POST)
    public String toSearch(Integer pageNum, Integer pageSize, Integer sort, ShopGoods query, Model model) {
        model.addAttribute("goodsList", shopGoodsService.loadGoods(pageNum, pageSize, query));
        model.addAttribute("query", query);
        model.addAttribute("sort", sort == null ? 1 : sort);
        return thymeleaf("/search");
    }

    /**
     * 获取真实ip地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取内网ip
     */
    public static String getLocalIp() {
        String localip = null;// 本地IP，如果没有配置外网IP则返回它
        String netip = null;// 外网IP
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            boolean finded = false;// 是否找到外网IP
            while (netInterfaces.hasMoreElements() && !finded) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> address = ni.getInetAddresses();
                while (address.hasMoreElements()) {
                    ip = address.nextElement();
                    if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
                        netip = ip.getHostAddress();
                        System.out.println("外网IP：" + netip);
                        finded = true;
                        break;
                    } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
                        localip = ip.getHostAddress();
                        System.out.println("内网IP：" + localip);
                    }

                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }

    /**
     * 生成推广
     * @param shopGood
     * @param shopType
     * @param model
     * @param request
     * @param response
     */
    @RequestMapping(value = "/haibao", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> haibao(ShopGoods shopGood, String shopType, Integer platform, Model model, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String date = format.format(new Date());

        Object o = request.getSession().getAttribute("upmsuser");
        String openId = "open_id_test";
        UpmsUser upmsuser = null;
        if(o != null){
            upmsuser = (UpmsUser)o;
            openId = upmsuser.getOpenid();
        }

        // 项目根路径，绝对路径
        String proPath = request.getSession().getServletContext().getRealPath("");


//        String ip = getLocalIp();//内网IP(测试用)，上线要改为域名
        String ip = "www.16office.com";
        int port = request.getLocalPort();
        // 商品推广二维码
        String qrCode = "http://" + ip + ":" + port + "/goods/goodsDetail?numIid="+shopGood.getNumIid()+"&platform=" + platform;

        // 当前session存在分享图片，直接转出到前端，不存在创建分享图片
        String haibaoKey = "goods_" + date + "_" + openId + "_" + shopGood.getNumIid();
        if (upmsuser != null){
            qrCode += "&userid=" + upmsuser.getUserId();
            haibaoKey = "goods_" + date + "_" + upmsuser.getUserId() + "_" + shopGood.getNumIid();
        }

//        Object haibaoImg = request.getSession().getAttribute(haibaoKey);
        // 生成的分享图片
        String targetImg = "/resources/images/tuiguang/"+haibaoKey+".jpg";

        long start = System.currentTimeMillis();
        String targetTemp = proPath + targetImg;
        File temp = new File(targetTemp);
        if(!temp.exists()){
//            temp.delete();
//        }
//        if(haibaoImg == null){

            try {
                // 商品主图保存到本地
                String mainImgTemp = proPath + "/resources/images/"+haibaoKey+".tmp";
                File mainImgF = new File(mainImgTemp);
                if(!mainImgF.exists()){
                    mainImgF.createNewFile();
                }

                // 请求商品主图并写入临时商品文件
                HttpGet httpGet = null;
                CloseableHttpClient httpClient = null;
                CloseableHttpResponse httpResponse = null;
                FileOutputStream outMainImg = null;
                try {
                    RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
                    httpClient = HttpClients.createDefault();
                    httpGet = new HttpGet(shopGood.getPictUrl());
                    httpGet.setConfig(requestConfig);
                    httpResponse = httpClient.execute(httpGet);
                    InputStream in = httpResponse.getEntity().getContent();

                    outMainImg = new FileOutputStream(mainImgF);
                    byte[] buffer = new byte[2048];
                    int len = 0;
                    while((len=in.read(buffer)) != -1 ){
                        outMainImg.write(buffer, 0, len);
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(outMainImg != null){try { outMainImg.close();} catch(IOException e) { e.printStackTrace();}}
                    if(httpGet != null){httpGet.releaseConnection();}
                    if(httpResponse != null){try { httpResponse.close();} catch(IOException e) { e.printStackTrace();}}
                    if(httpClient != null){try {httpClient.close();} catch(IOException e) {e.printStackTrace();}}
                }

                String title = shopGood.getTitle();// 标题
                String zkPrice = shopGood.getZkFinalPrice();// 折扣价
                String yjPrice = shopGood.getReservePrice();// 原价
                boolean baoyou = shopGood.getFreeShipment();// 是否包邮
                String volume = shopGood.getVolume().toString();// 30天销量
                String quan = shopGood.getCouponInfo();

                int width = 640;
                int height = 986;
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
                int tempW = 640;
                int tempH = mainH * tempW / mainW;
                if(tempH > 640){
                    tempH = 640;
                    tempW = mainW * tempH / mainH;
                }
                g.drawImage(mainImgBuf, 0, 0, tempW, tempH, null);
                mainImgF.delete();

                // 店铺类型
                if(shopType != null){
                    if(shopType.equals("B")){ // 天猫
                        String tianmaoTmp = proPath + "/resources/images/base/icon_tianmao.png";
                        BufferedImage tianmaoIcon = ImageIO.read(new File(tianmaoTmp));
                        g.drawImage(tianmaoIcon, 20, tempH + 25, 40, 40, null);
                    }else if(shopType.equals("C")){ // 淘宝
                        String tiaobaoTmp = proPath + "/resources/images/base/icon_taobao.png";
                        BufferedImage tiaobaoTmpIcon = ImageIO.read(new File(tiaobaoTmp));
                        g.drawImage(tiaobaoTmpIcon, 20, tempH + 25, 40, 40, null);
                    }
                }else{// 没有店铺类型时的默认图标
                    String morenTmp = proPath + "/resources/images/base/icon_moren.png";
                    BufferedImage morenTmpIcon = ImageIO.read(new File(morenTmp));
                    g.drawImage(morenTmpIcon, 20, tempH + 25, 40, 40, null);
                }

                // 二维码
                BufferedImage qrCodeImg = QRCodeUtil.encodeToBufferedImage(qrCode, BarcodeFormat.QR_CODE,190,190);
                if(qrCodeImg != null){
                    g.drawImage(qrCodeImg,null, 440,tempH + 10);
                }

                // 长按识别二维码，免费领券
                Font font = new Font("黑体 常规", Font.PLAIN, 24);
                color = Color.black;
                g.setColor(color);
                g.setFont(font);
                g.drawString("长按识别二维码", 450,tempH +205);
                color = new Color(251, 67, 62);
                g.setColor(color);
                g.drawString("免费领券", 485,tempH +240);

                // 标题
                font = new Font("黑体 常规", Font.PLAIN, 26);
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
                        if(lenW >= 364){
                            g.drawString(title.substring(charNum, i), 76,tempH + 60);
                            charNum = i;
                            lenW = 0;
                            line++;
                        }
                    }else{
                        if(lenW >= 416){
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
                font = new Font("黑体 常规", Font.PLAIN, 25);
                g.setFont(font);
                g.drawString("券后", 20,(tempH + 60) + (35 * line) + 60);
                font = new Font("黑体 常规", Font.PLAIN, 30);
                g.setFont(font);
                String zkPriceStr = "¥ "+zkPrice;
                g.drawString(zkPriceStr, 80,(tempH + 60) + (35 * line) + 63);

                // 是否包邮
                if(baoyou){
                    fm = g.getFontMetrics(font);
                    int baoyouW = fm.stringWidth(zkPriceStr);
                    g.fillRect(80 + baoyouW + 20, (tempH + 60) + (35 * line) + 40,46, 26);
                    font = new Font("黑体 常规", Font.BOLD, 18);
                    g.setFont(font);
                    color = Color.white;
                    g.setColor(color);
                    g.drawString("包邮", 80 + baoyouW + 20 + 4,(tempH + 60) + (35 * line) + 59);
                }

                // 原价
                color = new Color(95, 95, 95);
                g.setColor(color);
                font = new Font("黑体 常规", Font.PLAIN, 22);
                g.setFont(font);
                g.drawString("原价", 20,(tempH + 60) + (35 * line) + 105);
                String yjPriceStr = "¥ "+yjPrice;
                g.drawString(yjPriceStr, 75,(tempH + 60) + (35 * line) + 107);
                // 原价删除线
                fm = g.getFontMetrics(font);
                int delLineW = fm.stringWidth(yjPriceStr);
                g.drawLine(75,(tempH + 60) + (35 * line) + 100, 75 + delLineW,(tempH + 60) + (35 * line) + 95);

                // 月销量
                font = new Font("黑体 常规", Font.PLAIN, 20);
                g.setFont(font);
                g.drawString("月销" + volume + "件", 75 + delLineW + 115,(tempH + 60) + (35 * line) + 105);

                // 券
                color = new Color(255, 68, 0);
                g.setColor(color);
                g.fillRoundRect(75 + delLineW + 10, (tempH + 60) + (35 * line) + 85, 30,26, 5, 5);
                g.drawRoundRect(75 + delLineW + 36,(tempH + 60) + (35 * line) + 85,72,25,5,5);
                font = new Font("黑体 常规", Font.BOLD, 18);
                g.setFont(font);
                color = Color.white;
                g.setColor(color);
                g.drawString("券", 75 + delLineW + 16,(tempH + 60) + (35 * line) + 105);
                font = new Font("黑体 常规", Font.PLAIN, 18);
                g.setFont(font);
                color = new Color(255, 68, 0);
                g.setColor(color);
                int quanW = fm.stringWidth(quan);
                g.drawString("元", 75 + delLineW + 36 + quanW + (quanW / 2),(tempH + 60) + (35 * line) + 103);
                g.drawString(quan, 75 + delLineW + 36 + (quanW / 2),(tempH + 60) + (35 * line) + 105);

                // 底部
                color = new Color(255, 207, 207);
                g.setColor(color);
                g.fillRect(0, height - 60, width,60);
                color = new Color(155, 55, 55);
                g.setColor(color);
                font = new Font("楷体 常规", Font.BOLD, 30);
                g.setFont(font);
                String dbTxt = "粉丝福利优惠券，别的地方看不到哦";
                fm = g.getFontMetrics(font);
                int dbW = fm.stringWidth(dbTxt);
                g.drawString(dbTxt, (width - dbW ) / 2,height - 20);
                File outputfile = new File(targetTemp);
                ImageIO.write(imageNew,"jpg", outputfile);

//                request.getSession().setAttribute(haibaoKey, targetImg);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        else {
//            targetImg = haibaoImg.toString();
//        }
        System.out.println("生成海报共耗时：[" + (System.currentTimeMillis() - start) + "]毫秒");
        result.put("url", targetImg);
        result.put("success", true);
        return result;
    }
}
