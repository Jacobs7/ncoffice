package com.dape.bc.web.controller;

import com.dape.bc.dao.model.BcGoods;
import com.dape.bc.dao.model.BcGoodsExample;
import com.dape.bc.dao.model.UpmsUser;
import com.dape.bc.rpc.api.BcGoodsService;
import com.dape.bc.rpc.api.BcModuleService;
import com.dape.common.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
@RequestMapping("goods")
public class GoodsController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private BcGoodsService bcGoodsService;
    @Autowired
    public BcModuleService bcModuleService;

    /**
     * 加载数据库商品, ajax请求
     * @param pageNum 第几页
     * @param pageSize 每页多少条
     * @return
     */
    @RequestMapping(value = "/loadGoods", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> loadGoods(Integer pageNum, Integer pageSize, Integer type, String field, String sort, String des, String title) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("success", false);

        BcGoodsExample example = new BcGoodsExample();
        BcGoodsExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(title)){
            criteria.andTitleLike(title);
        }
        if(StringUtils.isNotBlank(field)){
            if(field.equals("hqzb")){
                if(type == null || type == 1){
                    criteria.andHqzbTypeGreaterThan(0);
                }else{
                    criteria.andHqzbTypeEqualTo(type);
                }
            }else if(field.equals("deq")){
                if(type == null || type == 1){
                    criteria.andDeqTypeGreaterThan(0);
                }else{
                    criteria.andDeqTypeEqualTo(type);
                }
            }else if(field.equals("gyb")){
                if(type == null || type == 1){
                    criteria.andGybTypeGreaterThan(0);
                }else{
                    criteria.andGybTypeEqualTo(type);
                }
            }else if(field.equals("ppq")){
                if(type == null || type == 1){
                    criteria.andPpqTypeGreaterThan(0);
                }else{
                    criteria.andPpqTypeEqualTo(type);
                }
            }else if(field.equals("myzt")){
                if(type == null || type == 1){
                    criteria.andMyztTypeGreaterThan(0);
                }else{
                    criteria.andMyztTypeEqualTo(type);
                }
            }else if(field.equals("jhs")){
                if(type == null || type == 1){
                    criteria.andJhsTypeGreaterThan(0);
                }else{
                    criteria.andJhsTypeEqualTo(type);
                }
            }else if(field.equals("yhh")){
                if(type == null || type == 1){
                    criteria.andYhhTypeGreaterThan(0);
                }else{
                    criteria.andYhhTypeEqualTo(type);
                }
            }else if(field.equals("clf")){
                if(type == null || type == 1){
                    criteria.andClfTypeGreaterThan(0);
                }else{
                    criteria.andClfTypeEqualTo(type);
                }
            }else if(field.equals("th")){
                if(type == null || type == 1){
                    criteria.andThTypeGreaterThan(0);
                }else{
                    criteria.andThTypeEqualTo(type);
                }
            }
        }
        if(StringUtils.isNotBlank(sort)){
            String order = "";
            if(sort.equals("volume")){
                order = "volume ";
            }else if(sort.equals("price")){
                order = "zk_final_price ";
            }else{
                order = "modify_date ";
            }
            if(StringUtils.isNotBlank(des) && des.equals("asc")){
                order += "asc";
            }else{
                order += "desc";
            }
            example.setOrderByClause(order);
        }else{
            example.setOrderByClause("modify_date asc");
        }

        List<BcGoods> goods = bcGoodsService.selectByExampleForStartPage(example, pageNum, pageSize);
        params.put("data", goods);
        params.put("success", true);
        return params;
    }

    /**
     * 商品详情
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/goodsDetail", method = RequestMethod.GET)
    public String goodsDetail(String itemId, Model model, HttpServletRequest request) {

        // 商品
        BcGoodsExample example = new BcGoodsExample();
        example.or().andItemIdEqualTo(itemId);
        BcGoods goods = bcGoodsService.selectFirstByExample(example);
        model.addAttribute("goods", goods);

        Object o = request.getSession().getAttribute("upmsuser");
        Integer userId = 0;
        UpmsUser upmsuser = null;
        if(o != null){
            upmsuser = (UpmsUser)o;
            userId = upmsuser.getUserId();
        }
        model.addAttribute("userId", userId);

        return thymeleaf("/goodsInfo");
    }

    @RequestMapping(value = "/goodsDetailImgs", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> goodsDetailImgs(String imgsUrl, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("success", false);

        // 记录详情图片url
        List<String> imgsArr = getDetailImgs(imgsUrl);

        if(imgsArr.size() > 0){
            params.put("imgsArr", imgsArr);
            params.put("success", true);
        }
        return params;
    }

    /**
     * 请求详情图片的地址
     * @param imgUrl
     * @return
     */
    public List<String> getDetailImgs(String imgUrl){

        List<String> imgsArr = new ArrayList<String>();

        String respStr = null;
        HttpGet httpGet = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
            httpClient = HttpClients.createDefault();
            httpGet = new HttpGet(imgUrl);
            httpGet.setConfig(requestConfig);
            httpResponse = httpClient.execute(httpGet);

            int status_code = httpResponse.getStatusLine().getStatusCode();

            if(status_code == HttpStatus.SC_OK){
                HttpEntity entity = httpResponse.getEntity();
                if(entity != null){
                    respStr = EntityUtils.toString(entity, "UTF-8");
                }
                EntityUtils.consume(entity);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(httpGet != null){httpGet.releaseConnection();}
            if(httpResponse != null){try { httpResponse.close();} catch(IOException e) { e.printStackTrace();}}
            if(httpClient != null){try {httpClient.close();} catch(IOException e) {e.printStackTrace();}}
        }
        // 获取详情图片src属性
        Document doc = Jsoup.parse(respStr);
        Elements imgs = doc.getElementsByTag("img");
        for(Element img : imgs){
            imgsArr.add(img.attr("src"));
        }

        return imgsArr;
    }
}
