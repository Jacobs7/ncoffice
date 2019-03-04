package com.dape.shop.rpc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
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

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.GeneralSecurityException;

public class Test {
    public static void main(String[] args){

        String url = "https://s.click.taobao.com/t?e=m%3D2%26s%3DJkV3rSEFgylw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0NUP6waUCNMvrT4N0ONO4g0UU8I5v72K82OfZmId5Ix3rivmRbl1tBoDfV6DIhLzDGLVpCiUCL%2BGZiqtwk9j5QPwdDmZ4my9rOiO4XFlbGgy1EwcTchYENqkOrGae4DS5oO2CiNcVz0K47NHbLd0vlhY0Qx4B3K%2BQSGFCzYOOqAQ&scm=1007.19011.125585.0_13366&pvid=8533572e-8e0e-401f-b9bf-d8c8f945c4c1&app_pvid=59590_11.176.156.116_372_1551335531985&ptl=floorId:13366;pvid:8533572e-8e0e-401f-b9bf-d8c8f945c4c1;app_pvid:59590_11.176.156.116_372_1551335531985&union_lens=lensId:0bb09c74_0bcb_16932cda689_2dc4";

//        BrowserVersion b = BrowserVersion.getDefault();
        WebClient wc = new WebClient();
        HtmlPage page = null;
//
        String pageXml = null;//记录请求的html字符串
        String imgUrl = null;
        try {

            wc.setUseInsecureSSL(true);
            wc.setJavaScriptEnabled(true); // 启用JS解释器，默认为true
            wc.setAjaxController(new NicelyResynchronizingAjaxController());
            wc.setCssEnabled(false); // 禁用css支持
            wc.setThrowExceptionOnScriptError(false); // js运行错误时，是否抛出异常
            wc.setTimeout(100000); // 设置连接超时时间 ，这里是10S。如果为0，则无限期等待

            page = wc.getPage(url);

//            wc.waitForBackgroundJavaScript(15000);

            pageXml = page.asXml();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }finally {
            wc.closeAllWindows();
        }

        Document doc = Jsoup.parse(pageXml);
        Elements elScripts = doc.getElementsByTag("script");

        String tmp = null;

        String rateUrl = "https://rate.tmall.com/list_detail_rate.htm?";
        String params = "";
        String currentPage = "1";
        for (Element e : elScripts) {
            tmp = e.data().toString();
            tmp = tmp.replaceAll(" ","").replaceAll("\n", "");
            if(tmp.indexOf("rateConfig") >= 0){
                tmp = tmp.substring(tmp.indexOf("rateConfig")+10);
                tmp = tmp.substring(tmp.indexOf("{"),tmp.indexOf("}") + 1);
                JSONObject jsonObject = JSONObject.parseObject(tmp);
                String itemId = jsonObject.getString("itemId");
                params += "itemId=" + itemId;
                String spuId = jsonObject.getString("spuId");
                params += "&spuId=" + spuId;
                String sellerId = jsonObject.getString("sellerId");
                params += "&sellerId=" + sellerId;
                params += "&currentPage=" + currentPage;
                System.out.println(tmp);
                break;
            }
        }
        if(StringUtils.isBlank(params)){
            return;
        }
        String respStr = null;
        HttpGet httpGet = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
            httpClient = HttpClients.createDefault();
            httpGet = new HttpGet(rateUrl + params);
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

        System.out.println(respStr);

//        if(imgUrl != null){
//            try {
//                Document doc = Jsoup.connect(imgUrl).ignoreContentType(true).get();
//                System.out.println(doc.data());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        try {
//            Document doc = Jsoup.connect(url).ignoreContentType(true).get();
//            System.out.println(doc.data().toString());
//            Elements imgSrcElement = doc.select("#modules-desc > div");
//            for(Element ele : imgSrcElement){
//                Elements imgs = ele.getElementsByTag("img");
//                for(Element img : imgs){
//                    System.out.println("**: " +img.attr("data-ks-lazyload"));
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        String pageXml = null;//记录请求的html字符串
//
//        WebClient wc = new WebClient();
//        HtmlPage page = null;
//        try {
//            wc.setJavaScriptEnabled(true);
//            wc.setCssEnabled(false);
//            wc.setThrowExceptionOnScriptError(false);
//            wc.setJavaScriptTimeout(5000);
//            page = wc.getPage(url);
//            pageXml = page.asXml();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(pageXml);

//        HttpGet httpGet = null;
//        CloseableHttpClient httpClient = null;
//        CloseableHttpResponse httpResponse = null;
//        try {
//            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
//            httpClient = HttpClients.createDefault();
//            httpGet = new HttpGet(url);
//            httpGet.setConfig(requestConfig);
//            httpResponse = httpClient.execute(httpGet);
//
//            int status_code = httpResponse.getStatusLine().getStatusCode();
//
//
//            if(status_code == HttpStatus.SC_OK){
//                HttpEntity entity = httpResponse.getEntity();
//                if(entity != null){
//                    respStr = EntityUtils.toString(entity, "UTF-8");
//                }
//                EntityUtils.consume(entity);
//            }
//
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if(httpGet != null){httpGet.releaseConnection();}
//            if(httpResponse != null){try { httpResponse.close();} catch(IOException e) { e.printStackTrace();}}
//            if(httpClient != null){try {httpClient.close();} catch(IOException e) {e.printStackTrace();}}
//        }
//
//        long start = System.currentTimeMillis();
//        if(StringUtils.isNotBlank(respStr)){
//
//            Document doc = Jsoup.parse(respStr);
//            Elements elements = doc.select("img[class=lazyImg]");
//            for (Element ele : elements) {
//                String txt = ele.attr("data-ks-lazyload");
//                //out.println(JdbookID);
//            }
//        }
//        System.out.println("匹配耗时：" + (System.currentTimeMillis() - start));

//        return resultList;
    }
}
