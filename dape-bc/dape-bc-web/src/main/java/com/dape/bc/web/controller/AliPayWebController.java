package com.dape.bc.web.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.*;
import com.dape.common.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
@RequestMapping("aliPayWeb")
public class AliPayWebController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AliPayWebController.class);


    // 沙箱环境
    // 应用ID，收款帐号既是appId对应支付宝帐号
    public static String app_id = "2016092700605584";
    // 商户私钥，PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCJAqk/OwekG0xyVaIfG0Arj4+lxOxreNv/+4SJ8qeHGB7fLaeO+YoGpEGOjf8rlu6GkeaMkVr1Vqc77EHWqH7GU6dH8X5azUzM6JDbqyYqg/f6oaGzJqqGWMr4U1Cc5j6uJJH+5oQLmTVDNM1cy0GqOJwnBXuv1lqDpDQsIKL4G/aE90KoEPoIYEfOWsAXz+jC1A/lkevVaokFQBi0VP0yw8XfG7OR2opFkMdsZFnKukKrNpdGzZaFNbokLA49kYxLMn0LSp/keCRDT2h9zFjqqcAZAvOeEz2/E2mRyF7TqS7B+ZCCMo+dWjn57/Trd3N2V7S8fsszRXWm8XUBr3fzAgMBAAECggEATJP2MOc3cBvp8IW4ZZZ/mVlWOpsEYVVd8YeNHuVHiZSLvMXxv1HuOaQZGCp5ks17aC+oIq0jn7jdI/r7GZV3tjYPa4Co1Oumn2jlfkH8xQqZ0bYBgPZ9nTWHzKAUkH2ITyEVkNkauLjbMkMS/WiFvTSC4rSH21H9qVJf7sIXFIEFhXVmz+rT+8SigJZ3imjTgTE3Q+03pkv7aG+RRRbO4gjCdSoOI4IvXW5r7QTrBTfwQUAyoKoPKwXxRn+2AmLhzEpHopNomMZN3KuOVz3GyTe9zC7GlxJDRyCzkUVFTqmHMrQrvvT8px+J5ddTGgLFFTN/hgGYsCMiT1GrKr+RoQKBgQDsgkdcSVhRNIfl97bTHrWsdUk8qZjc20LhFAVZ8WUFYJ+7kS0AR2fYtN4hXvoEVB4IEduzralJViciAx5LN0prXt7/MmNireDl6ZY3snhcQnj/AWX/UqI65tKRCgnXEjCZ3AjmAcBVlQIhCWruUJhHx2qFUQIwcMu12EPLKIbXWQKBgQCUTTkofScx9S1ys2yIEAJcxdQe2/F8UD7f+cNSjmGJTtZrS62ubf2nJ5LeN+bDJQtQC97WrUdbyGlgdASaWVcwBlaC4yCqOS8wk2KXm6ZNCQmjR0z7ok5tlQHUcvCQ7O+BD/YSfMBAoRcUlTWVnVUtDaYTd9XKdAGqGNDXe3YsKwKBgA6iNPYh16QWov34qMhBUy5bh2+IctvfeTDiAz7Ab+a4RsndPrKQuH0xG7lm3gNcjQskx7pDWYEfIoa5OKugvSsNkLCrlnipl4vCOzgxA795oXDtzjjRDRal54tv2pIDHxy1/5rzqsng0WPn6ETcmb9/ODkNfRwwLnqO6grs9ALpAoGANtafbjNpTPXmimWCmoWg+gFFQOv/zgI2XcgTy/FOa+G1NBPV84xEoYzmqDlvoXWPS1g4XJXSr0Pag4ojMZgbv2x4jQnDyG5A3uuBJ6Ksyguvfqsc8mfALJFPDeo6vrx+i/EFAy0SQlPPHxNVry9wkapcYRKNAcIH44gtoaDLv+UCgYBokLxVGE+R7L/xCu06zHhX4K3lPZHA+BxijsQ9uV2/89byY8hZWmRLks3b94HCgk02C+8GZcq5e2Qb4XDUnEzJbs3N6hS/FzVIbSxBWd+76Vi0FnMwwI9Rnu/62DvY9eesuZi29SYAl8JlfyuNa3s5eTfpoLVi02ge8a6ey8eWlw==";
    // 支付宝公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm，对应APPID下的支付宝公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiQKpPzsHpBtMclWiHxtAK4+PpcTsa3jb//uEifKnhxge3y2njvmKBqRBjo3/K5buhpHmjJFa9VanO+xB1qh+xlOnR/F+Ws1MzOiQ26smKoP3+qGhsyaqhljK+FNQnOY+riSR/uaEC5k1QzTNXMtBqjicJwV7r9Zag6Q0LCCi+Bv2hPdCqBD6CGBHzlrAF8/owtQP5ZHr1WqJBUAYtFT9MsPF3xuzkdqKRZDHbGRZyrpCqzaXRs2WhTW6JCwOPZGMSzJ9C0qf5HgkQ09ofcxY6qnAGQLznhM9vxNpkche06kuwfmQgjKPnVo5+e/063dzdle0vH7LM0V1pvF1Aa938wIDAQAB";
    // 服务器异步通知页面路径，需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以访问
    public static String notify_url = "http://100.102.246.106:";
    // 页面跳转同步通知页面路径，需http://格式的完整路径... 同notify_url
    public static String return_url = "";
    // 签名格式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关，此地址为沙箱环境
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // log path
    public static String log_path = "C:\\";

    /**
     * 转向支付页
     * @return
     */
    @RequestMapping(value = "/toPay", method = RequestMethod.GET)
    public String toPay(HttpServletRequest request) {
        return thymeleaf("/aliPayTap");
    }

    /**
     * 支付页
     * @return
     */
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String pay(HttpServletRequest request, Model model) {
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayWebController.gatewayUrl, AliPayWebController.app_id, AliPayWebController.merchant_private_key, "json", AliPayWebController.charset, AliPayWebController.alipay_public_key, AliPayWebController.sign_type);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AliPayWebController.return_url);
        alipayRequest.setNotifyUrl(AliPayWebController.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("outTradeNo");
        //付款金额，必填
        String total_amount = request.getParameter("totalAmount");
        //订单名称，必填
        String subject = request.getParameter("subject");
        //商品描述，可空
        String body = request.getParameter("body");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        try {
            String result = alipayClient.pageExecute(alipayRequest).getBody();
            model.addAttribute("result", result);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return thymeleaf("/alipay");
    }

    /**
     * 交易查询
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String query(HttpServletRequest request, Model model) {
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayWebController.gatewayUrl, AliPayWebController.app_id, AliPayWebController.merchant_private_key, "json", AliPayWebController.charset, AliPayWebController.alipay_public_key, AliPayWebController.sign_type);
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("outTradeNo");
        //支付宝交易号
        String trade_no = request.getParameter("tradeNo");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","+"\"trade_no\":\""+ trade_no +"\"}");

        try {
            String result = alipayClient.execute(alipayRequest).getBody();
            model.addAttribute("result", result);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return thymeleaf("/alipay");
    }

    /**
     * 退款
     * @return
     */
    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    public String refund(HttpServletRequest request, Model model) {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayWebController.gatewayUrl, AliPayWebController.app_id, AliPayWebController.merchant_private_key, "json", AliPayWebController.charset, AliPayWebController.alipay_public_key, AliPayWebController.sign_type);
        //设置请求参数
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();

        //商户订单号，商户网站订单系统中唯一订单号
        String out_trade_no = request.getParameter("outTradeNo");
        //支付宝交易号
        String trade_no = request.getParameter("tradeNo");
        //请二选一设置
        //需要退款的金额，该金额不能大于订单金额，必填
        String refund_amount = request.getParameter("refundAmount");
        //退款的原因说明
        String refund_reason = request.getParameter("refundReason");
        //标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
        String out_request_no = request.getParameter("outRequestNo");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"trade_no\":\""+ trade_no +"\","
                + "\"refund_amount\":\""+ refund_amount +"\","
                + "\"refund_reason\":\""+ refund_reason +"\","
                + "\"out_request_no\":\""+ out_request_no +"\"}");

        try {
            String result = alipayClient.execute(alipayRequest).getBody();
            model.addAttribute("result", result);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return thymeleaf("/alipay");
    }

    /**
     * 退款查询
     * @return
     */
    @RequestMapping(value = "/refundQuery", method = RequestMethod.POST)
    public String refundQuery(HttpServletRequest request, Model model) {
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayWebController.gatewayUrl, AliPayWebController.app_id, AliPayWebController.merchant_private_key, "json", AliPayWebController.charset, AliPayWebController.alipay_public_key, AliPayWebController.sign_type);
        AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("outTradeNo");
        //支付宝交易号
        String trade_no = request.getParameter("tradeNo");
        String out_request_no = request.getParameter("outRequestNo");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                +"\"trade_no\":\""+ trade_no +"\","
                +"\"out_request_no\":\""+ out_request_no +"\"}");

        try {
            String result = alipayClient.execute(alipayRequest).getBody();
            model.addAttribute("result", result);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return thymeleaf("/alipay");
    }

    /**
     * 关闭交易
     * @return
     */
    @RequestMapping(value = "/close", method = RequestMethod.POST)
    public String close(HttpServletRequest request, Model model) {
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayWebController.gatewayUrl, AliPayWebController.app_id, AliPayWebController.merchant_private_key, "json", AliPayWebController.charset, AliPayWebController.alipay_public_key, AliPayWebController.sign_type);
        AlipayTradeCloseRequest alipayRequest = new AlipayTradeCloseRequest();

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("outTradeNo");
        //支付宝交易号
        String trade_no = request.getParameter("tradeNo");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," +"\"trade_no\":\""+ trade_no +"\"}");

        try {
            String result = alipayClient.execute(alipayRequest).getBody();
            model.addAttribute("result", result);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return thymeleaf("/alipay");
    }

    /**
     * 页面跳转同步通知页面路径
     * @return
     */
    @RequestMapping(value = "/notifyUrl", method = RequestMethod.GET)
    public String notifyUrl(HttpServletRequest request, Model model) {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        try {
            for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);

            }

            boolean signVerified = AlipaySignature.rsaCheckV1(params, AliPayWebController.alipay_public_key, AliPayWebController.charset, AliPayWebController.sign_type); //调用SDK验证签名
            if(signVerified) {//验证成功
                //商户订单号
                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //支付宝交易号
                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //交易状态
                String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

                if(trade_status.equals("TRADE_FINISHED")){
                    //判断该笔订单是否在商户网站中已经做过处理
                    //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                    //如果有做过处理，不执行商户的业务程序

                    //注意：
                    //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                }else if (trade_status.equals("TRADE_SUCCESS")){
                    //判断该笔订单是否在商户网站中已经做过处理
                    //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                    //如果有做过处理，不执行商户的业务程序

                    //注意：
                    //付款完成后，支付宝系统发送该交易状态通知
                }

                model.addAttribute("result", "回调：支付成功");

            }else {//验证失败
                model.addAttribute("result", "回调：支付失败");

                //调试用，写文本函数记录程序运行情况是否正常
                //String sWord = AlipaySignature.getSignCheckContentV1(params);
                //AlipayConfig.logResult(sWord);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            model.addAttribute("result", "转码异常");
        } catch (AlipayApiException e) {
            e.printStackTrace();
            model.addAttribute("result", "调用支付宝验签异常");
        }
        return thymeleaf("/alipay");
    }

    /**
     * 服务器异步通知页面路径
     * @return
     */
    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, Model model) {
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        try {
            for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用

                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            }

            boolean signVerified = AlipaySignature.rsaCheckV1(params, AliPayWebController.alipay_public_key, AliPayWebController.charset, AliPayWebController.sign_type); //调用SDK验证签名

            //——请在这里编写您的程序（以下代码仅作参考）——
            if(signVerified) {
                //商户订单号
                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //支付宝交易号
                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //付款金额
                String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

                model.addAttribute("result","trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount);
            }else {
                model.addAttribute("result","验签失败");
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            model.addAttribute("result", "转码异常");
        } catch (AlipayApiException e) {
            e.printStackTrace();
            model.addAttribute("result", "调用支付宝验签异常");
        }
        return thymeleaf("/alipay");
    }
}
