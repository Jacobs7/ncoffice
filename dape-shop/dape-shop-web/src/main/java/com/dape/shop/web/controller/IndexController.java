package com.dape.shop.web.controller;

import com.dape.common.base.BaseController;
import com.dape.common.util.NewImageUtil;
import com.dape.common.util.StringUtil;
import com.dape.shop.dao.model.*;
import com.dape.shop.rpc.api.ShopGoodsService;
import com.dape.shop.rpc.api.ShopMenuService;
import com.dape.shop.rpc.api.ShopModuleService;
import com.dape.shop.rpc.api.ShopUserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
public class IndexController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ShopGoodsService shopGoodsService;
    @Autowired
    private ShopMenuService shopMenuService;
    @Autowired
    private ShopModuleService shopModuleService;
//    @Autowired
//    public ShopUserService shopUserService;

    @RequestMapping(value = "demo", method = RequestMethod.GET)
    public String demo(Model model) {
        ShopGoodsExample example = new ShopGoodsExample();
        List<ShopGoods> list = shopGoodsService.selectByExample(example);
        model.addAttribute("list", list);
        return thymeleaf("/demo");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, Long showId, HttpServletRequest request) {

//        String openId = request.getAttribute("openId").toString();
//        if(openId == null){
//            ShopUserExample userExample = new ShopUserExample();
//            userExample.or().andOpenIdEqualTo(openId);
//            ShopUser user = shopUserService.selectFirstByExample(userExample);
//        }

        /** 后面要放到缓存中 start */
        // 查询导航栏列表: 首页、男装、女装等
        ShopMenuExample shopMenuE = new ShopMenuExample();
        shopMenuE.or().andIsEnabledEqualTo(true);
        shopMenuE.setOrderByClause("sort ASC");
        List<ShopMenu> menus = shopMenuService.selectByExample(shopMenuE);
        model.addAttribute("menus", menus);
        model.addAttribute("showId", showId == null ? 1L : showId);

        // 查询模块列表: 淘抢购、聚划算、拼多多、京东等
        ShopModuleExample shopModuleE = new ShopModuleExample();
        shopModuleE.or().andIsEnabledEqualTo(true);
        shopModuleE.setOrderByClause("sort ASC");
        List<ShopModule> modules = shopModuleService.selectByExample(shopModuleE);
        model.addAttribute("modules", modules);
        /** 后面要放到缓存中 end */

        return thymeleaf("/index");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model) {
        return thymeleaf("/address_edit");
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order(Model model) {
        return thymeleaf("/all_orders");
    }

    /**
     * 分享图片
     * @param model
     * @param request
     * @param response
     */
    @RequestMapping(value = "/fenxiang", method = RequestMethod.GET)
    public void fenxiang(Model model, HttpServletRequest request, HttpServletResponse response) {
        Object o = request.getSession().getAttribute("user");
        ShopUser user = (ShopUser)o;

        String openId = user.getOpenId();
        // 项目根路径，绝对路径
        String proPath = request.getSession().getServletContext().getRealPath("");
        // 保存到本地的临时头像文件
        String headTemp = proPath + "/resources/images/"+openId+".tmp";
        // 生成的分享图片
        String targetImg = null;

        String ip = "192.168.10.205";
        int port = request.getLocalPort();
        // 分享二维码访问地址
        String qrCode = "http://" + ip + ":" + port;

        // 当前session存在分享图片，直接转出到前端，不存在创建分享图片
        Object fenxiangImg = request.getSession().getAttribute("fenxiangImg");
        if(fenxiangImg == null){
            targetImg = proPath + "/resources/images/fenxiang/"+openId+".jpg";
            try {
                // 网络头像保存到本地
                String headUrl = null;
                if(StringUtils.isNotEmpty(user.getHeadUrl())){
                    headUrl = user.getHeadUrl();
                }else{
                    String appName = request.getAttribute("appName").toString();
                    String uiPath = request.getAttribute("uiPath").toString();
                    headUrl = uiPath + appName + "/images/headimg.jpg";
                }
                URL url = new URL(headUrl);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5 * 1000);
                InputStream inStream = conn.getInputStream();

                File headF = new File(headTemp);
                if(!headF.exists()){
                    headF.createNewFile();
                }
                FileOutputStream outHead = new FileOutputStream(headTemp);
                byte[] buffer = new byte[2048];
                int len = 0;
                while( (len=inStream.read(buffer)) != -1 ){
                    outHead.write(buffer, 0, len);
                }
                outHead.close();
                inStream.close();

                NewImageUtil.fenxiangImg(user.getWeiNickName() , targetImg, proPath+"/resources/images/base/fenxiang_base.jpg",headTemp,qrCode);
                headF.delete();

                request.getSession().setAttribute("fenxiangImg", targetImg);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            targetImg = fenxiangImg.toString();
        }

        try {
            FileInputStream inputStream = new FileInputStream(targetImg);
            int length = inputStream.available();
            byte data[] = new byte[length];
            response.setContentLength(length);
            response.setContentType("image/jpeg");
            inputStream.read(data);
            OutputStream out = response.getOutputStream();
            out.write(data);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
