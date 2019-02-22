package com.dape.shop.rpc.service.impl;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
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

//        String url = "https://detail.m.tmall.com/item.htm?id=584989553305";
//        String url = "https://h5.m.taobao.com/awp/core/detail.htm?id=581423267164";
        String url = "https://s.click.taobao.com/t?e=m%3D2%26s%3DAi5Sw%2BkW4GFw4vFB6t2Z2ueEDrYVVa64juWlisr3dOdyINtkUhsv0KKDmSVhUxeC4GdqFgUik8IUU8I5v72K82OfZmId5Ix3rivmRbl1tBoDfV6DIhLzDGLVpCiUCL%2BGZiqtwk9j5QPwdDmZ4my9rK9DD%2F200Ioy9OSfRI2eAoOkOrGae4DS5oO2CiNcVz0K95vlob%2FPOFC9lY%2FnJkvXISGFCzYOOqAQ&scm=1007.19011.125585.0_13366&pvid=1be5ae89-f3a1-4941-848a-a498e63994e5&app_pvid=59590_11.1.39.91_770_1550821077764&ptl=floorId:13366;pvid:1be5ae89-f3a1-4941-848a-a498e63994e5;app_pvid:59590_11.1.39.91_770_1550821077764&union_lens=lensId:0b01275b_0c87_1691423b399_6ba3";

        BrowserVersion b = BrowserVersion.getDefault();
        WebClient wc = new WebClient(b);
        HtmlPage page = null;

        String pageXml = null;//记录请求的html字符串
        String imgUrl = null;
        try {

            wc.setUseInsecureSSL(true);
            wc.setJavaScriptEnabled(true); // 启用JS解释器，默认为true
            wc.setCssEnabled(false); // 禁用css支持
            wc.setThrowExceptionOnScriptError(false); // js运行错误时，是否抛出异常
            wc.setTimeout(100000); // 设置连接超时时间 ，这里是10S。如果为0，则无限期等待
            page = wc.getPage(url);

            pageXml = page.asXml();

            Document doc = Jsoup.parse(pageXml);
            Elements elements = doc.getElementsByTag("script");

            String tmp = null;

            for (Element e : elements) {
                tmp = e.data().toString();
                tmp = tmp.replaceAll(" ","").replaceAll("\n", "");
                if(tmp.indexOf("varg_config") >= 0){
                    tmp = tmp.substring(tmp.indexOf("descUrl")+7);
                    tmp = tmp.substring(1,tmp.indexOf(","));
                    tmp = tmp.substring(tmp.indexOf("'?'") +3, tmp.indexOf("':'"));
                    imgUrl = "http:" + tmp;
                    break;
                }
            }
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            wc.closeAllWindows();
        }

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

        Document doc = Jsoup.parse(respStr);
        Elements imgs = doc.getElementsByTag("img");
        for(Element img : imgs){
//            imgsArr.add(img.attr("data-ks-lazyload"));
        }


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
