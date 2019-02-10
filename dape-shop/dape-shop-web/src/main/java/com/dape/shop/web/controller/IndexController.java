package com.dape.shop.web.controller;

import com.dape.common.base.BaseController;
import com.dape.common.util.NewImageUtil;
import com.dape.shop.dao.model.*;
import com.dape.shop.rpc.api.ShopGoodsService;
import com.dape.shop.rpc.api.ShopMenuService;
import com.dape.shop.rpc.api.ShopModuleService;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.HttpClient;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

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

    /**
     * 赚钱教程
     * @param model
     * @return
     */
    @RequestMapping(value = "/courseZhuan", method = RequestMethod.GET)
    public String edit(Model model) {
       return thymeleaf("/course-zhuan");
    }

    /**
     * 省钱教程页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/courseSheng", method = RequestMethod.GET)
    public String order(Model model) {
        return thymeleaf("/course-sheng");
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
        Object so = request.getSession().getAttribute("shopuser");
        UpmsUser user = (UpmsUser)o;
        ShopUser shopUser = (ShopUser)o;

        String openId = user.getOpenid();
        // 项目根路径，绝对路径
        String proPath = request.getSession().getServletContext().getRealPath("");
        // 保存到本地的临时头像文件
        String headTemp = proPath + "/resources/images/"+openId+".tmp";
        // 生成的分享图片
        String targetImg = null;

        String ip = "192.168.10.234";
        int port = request.getLocalPort();
        // 分享二维码访问地址
        String qrCode = "http://" + ip + ":" + port;

        // 当前session存在分享图片，直接转出到前端，不存在创建分享图片
        Object fenxiangImg = request.getSession().getAttribute("fenxiangImg");
        if(fenxiangImg == null){
            targetImg = proPath + "/resources/images/fenxiang/"+openId+".jpg";
            File temp = new File(targetImg);
            if(temp.exists()){
                temp.delete();
            }
            // 网络头像保存到本地
            String headUrl = null;
            if(StringUtils.isNotEmpty(shopUser.getHeadUrl())){
                headUrl = shopUser.getHeadUrl();
            }else{
                String appName = request.getAttribute("appName").toString();
                String uiPath = request.getAttribute("uiPath").toString();
                headUrl = uiPath + appName + "/images/headimg.jpg";
            }

            // 保存下来的时头像文件
            File headF = new File(headTemp);
            if(!headF.exists()){
                try { headF.createNewFile(); } catch (IOException e) { e.printStackTrace(); }
            }

            // 请求头像并写入临时头像文件
            HttpGet httpGet = null;
            CloseableHttpClient httpClient = null;
            CloseableHttpResponse httpResponse = null;
            FileOutputStream outHead = null;
            try {
                RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
                httpClient = HttpClients.createDefault();
                httpGet = new HttpGet(headUrl);
                httpGet.setConfig(requestConfig);
                httpResponse = httpClient.execute(httpGet);
                InputStream in = httpResponse.getEntity().getContent();

                outHead = new FileOutputStream(headTemp);
                byte[] buffer = new byte[2048];
                int len = 0;
                while((len=in.read(buffer)) != -1 ){
                    outHead.write(buffer, 0, len);
                }
            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(outHead != null){try { outHead.close();} catch(IOException e) { e.printStackTrace();}}
                if(httpGet != null){httpGet.releaseConnection();}
                if(httpResponse != null){try { httpResponse.close();} catch(IOException e) { e.printStackTrace();}}
                if(httpClient != null){try {httpClient.close();} catch(IOException e) {e.printStackTrace();}}
            }

            NewImageUtil.fenxiangImg(shopUser.getWeiNickName() , targetImg, proPath+"/resources/images/base/fenxiang_base.jpg",headTemp,qrCode);
            headF.delete();// 删除临时头像

            request.getSession().setAttribute("fenxiangImg", targetImg);
        }else {
            targetImg = fenxiangImg.toString();
        }

        OutputStream out = null;
        try {
            FileInputStream inputStream = new FileInputStream(targetImg);
            int length = inputStream.available();
            byte data[] = new byte[length];
            response.setContentLength(length);
            response.setContentType("image/jpeg");
            inputStream.read(data);
            out = response.getOutputStream();
            out.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null){try {out.close();} catch (IOException e) {e.printStackTrace();}}
        }
    }

    /**
     * 常见问题
     * @param model
     * @return
     */
    @RequestMapping(value = "question", method = RequestMethod.GET)
    public String question(Model model) {
        return thymeleaf("/question");
    }
}
