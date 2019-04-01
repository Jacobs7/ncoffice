package com.dape.bc.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.*;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.*;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.dape.bc.common.constant.BcPayRefundStatusEnum;
import com.dape.bc.common.constant.BcPayStatusEnum;
import com.dape.bc.dao.model.BcPayOrder;
import com.dape.bc.dao.model.BcPayOrderExample;
import com.dape.bc.dao.model.BcPayOrderRefund;
import com.dape.bc.dao.model.BcPayOrderRefundExample;
import com.dape.bc.rpc.api.BcPayOrderRefundService;
import com.dape.bc.rpc.api.BcPayOrderService;
import com.dape.common.base.BaseController;
import com.dape.common.util.RamdonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
@RequestMapping("aliPayWeb")
public class AliPayWebController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AliPayWebController.class);

    @Autowired
    public BcPayOrderService bcPayOrderService;
    @Autowired
    public BcPayOrderRefundService bcPayOrderRefundService;

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

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("outTradeNo");
        if(StringUtils.isBlank(out_trade_no)){
            model.addAttribute("result", "商户订单号不能为空");
            return thymeleaf("/alipay");
        }else{
            BcPayOrderExample e = new BcPayOrderExample();
            e.or().andOutTradeNoEqualTo(out_trade_no);
            int count = bcPayOrderService.countByExample(e);
            if(count > 0){
                model.addAttribute("result", "商户订单号已存在");
                return thymeleaf("/alipay");
            }
        }
        //付款金额，必填
        String total_amount = request.getParameter("totalAmount");
        if(StringUtils.isBlank(total_amount)){
            model.addAttribute("result", "付款金额不能为空");
            return thymeleaf("/alipay");
        }else{
            try {
                BigDecimal amount = new BigDecimal(total_amount);
            } catch (NumberFormatException e){
                model.addAttribute("result", "付款金额不是数字");
                return thymeleaf("/alipay");
            }
        }
        //订单名称，必填
        String subject = request.getParameter("subject");
        if(StringUtils.isBlank(subject)){
            model.addAttribute("result", "订单名称不能为空");
            return thymeleaf("/alipay");
        }
        //商品描述，可空
        String body = request.getParameter("body");
        // 销售产品码 必填
        String product_code="FAST_INSTANT_TRADE_PAY";// intenet:FAST_INSTANT_TRADE_PAY, wap:QUICK_WAP_WAY

        BcPayOrder payOrder = new BcPayOrder();
        payOrder.setCreateDate(new Date());
        payOrder.setIsEnabled(true);
        payOrder.setOutTradeNo(out_trade_no);//商户网站订单号
        payOrder.setTotalAmount(total_amount);//付款金额
        payOrder.setSubject(subject);//订单名称
        payOrder.setBody(body);//描述
//        payOrder.setTradeNo(trade_no);// 支付宝交易号
        payOrder.setPayResult(BcPayStatusEnum.PROCESSING.getCode());//支付结果，0：处理中，1：支付成功，2：支付失败
        payOrder.setRefundResult(BcPayRefundStatusEnum.NO.getCode());// 0：未退款，1：全部退款，2：部分退款

        int c = bcPayOrderService.insert(payOrder);
        if(c > 0){
            // 调用支付宝支付
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
            alipayRequest.setReturnUrl(AlipayConfig.return_url);
            alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

            AlipayTradePagePayModel m = new AlipayTradePagePayModel();
            m.setOutTradeNo(out_trade_no);
            m.setSubject(subject);
            m.setTotalAmount(total_amount);
            m.setBody(body);
            // m.setTimeoutExpress("2m");// 超时时间，可空
            m.setProductCode(product_code);
            alipayRequest.setBizModel(m);
            // 设置异步通知地址
            alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
            // 设置同步地址
            alipayRequest.setReturnUrl(AlipayConfig.return_url);

            try {
                String result = alipayClient.pageExecute(alipayRequest).getBody();
                model.addAttribute("result", result);
            } catch (AlipayApiException e) {
                e.printStackTrace();
                model.addAttribute("result", "调用支付宝支付异常");
            }
        }else{
            model.addAttribute("result", "添加订单失败");
        }

        return thymeleaf("/alipay");
    }

    /**
     * 交易查询
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String query(HttpServletRequest request, Model model) {

        BcPayOrder order = null;

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("outTradeNo");
        if(StringUtils.isBlank(out_trade_no)){
            model.addAttribute("result", "商户订单号不能为空");
            return thymeleaf("/alipay");
        }else{
            BcPayOrderExample e = new BcPayOrderExample();
            e.or().andOutTradeNoEqualTo(out_trade_no);
            List<BcPayOrder> orders = bcPayOrderService.selectByExample(e);
            if(orders == null || orders.size() != 1){
                model.addAttribute("result", "该订单不存在");
                return thymeleaf("/alipay");
            }else{
                order = orders.get(0);
                if(order.getPayResult() == BcPayStatusEnum.PROCESSING.getCode()){
                    model.addAttribute("result", "该订单正在处理中");
                    return thymeleaf("/alipay");
                }else if(order.getPayResult() == BcPayStatusEnum.FAIL.getCode()){
                    model.addAttribute("result", "该订单支付失败");
                    return thymeleaf("/alipay");
                }else if(order.getPayResult() != BcPayStatusEnum.SUCCESS.getCode()){
                    model.addAttribute("result", "该订单状态异常，请稍后再试");
                    return thymeleaf("/alipay");
                }
            }
        }
        //支付宝交易号
        String trade_no = order.getTradeNo();

        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, AlipayConfig.format_type, AlipayConfig.charset, AlipayConfig.alipay_public_key,AlipayConfig.sign_type);
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();

        AlipayTradeQueryModel m = new AlipayTradeQueryModel();
        m.setOutTradeNo(out_trade_no);
        m.setTradeNo(trade_no);
        alipayRequest.setBizModel(m);

        try {
            AlipayTradeQueryResponse alipayResponse =alipayClient.execute(alipayRequest);
            String result = alipayResponse.getBody();
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

        BcPayOrder order = null;

        //商户订单号，商户网站订单系统中唯一订单号
        String out_trade_no = request.getParameter("outTradeNo");
        if(StringUtils.isBlank(out_trade_no)){
            model.addAttribute("result", "商户订单号不能为空");
            return thymeleaf("/alipay");
        }else{
            BcPayOrderExample e = new BcPayOrderExample();
            e.or().andOutTradeNoEqualTo(out_trade_no);
            List<BcPayOrder> orders = bcPayOrderService.selectByExample(e);
            if(orders == null || orders.size() != 1){
                model.addAttribute("result", "该订单不存在");
                return thymeleaf("/alipay");
            }else{
                order = orders.get(0);
                if(order.getPayResult() == BcPayStatusEnum.PROCESSING.getCode()){
                    model.addAttribute("result", "该订单正在处理中，不能退款");
                    return thymeleaf("/alipay");
                }else if(order.getPayResult() == BcPayStatusEnum.FAIL.getCode()){
                    model.addAttribute("result", "该订单支付失败，不能退款");
                    return thymeleaf("/alipay");
                }else if(order.getPayResult() != BcPayStatusEnum.SUCCESS.getCode()){
                    model.addAttribute("result", "该订单状态异常，请稍后再试");
                    return thymeleaf("/alipay");
                }
            }
        }

        //需要退款的金额，该金额不能大于订单金额，必填
        String refund_amount = request.getParameter("refundAmount");
        BigDecimal refundAmount = new BigDecimal("0");
        if(StringUtils.isBlank(refund_amount)){
            model.addAttribute("result", "付款金额不能为空");
            return thymeleaf("/alipay");
        }else{
            try {
                refundAmount = new BigDecimal(refund_amount);
            } catch (NumberFormatException e){
                model.addAttribute("result", "退款金额不是数字");
                return thymeleaf("/alipay");
            }
        }
        //退款的原因说明
        String refund_reason = request.getParameter("refundReason");
        //标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
//        String out_request_no = request.getParameter("outRequestNo");

        BcPayOrderRefundExample pore = new BcPayOrderRefundExample();
        pore.or().andOutTradeNoEqualTo(order.getOutTradeNo());
        List<BcPayOrderRefund> orderRefunds = bcPayOrderRefundService.selectByExample(pore);
        for(BcPayOrderRefund orderRefund : orderRefunds){
            refundAmount = refundAmount.add(new BigDecimal(orderRefund.getRefundAmount()));
        }

        if(refundAmount.compareTo(new BigDecimal(order.getTotalAmount())) == 1){
            model.addAttribute("result", "退款总金额不能大于订单金额");
            return thymeleaf("/alipay");
        }else if(refundAmount.compareTo(new BigDecimal(order.getTotalAmount())) == 0){
            order.setRefundResult(BcPayRefundStatusEnum.REFUND_ALL.getCode());// 全部退款
        }else if(refundAmount.compareTo(new BigDecimal(order.getTotalAmount())) == -1){
            order.setRefundResult(BcPayRefundStatusEnum.REFUND_PART.getCode());// 部分退款
        }

        BcPayOrderRefund record = new BcPayOrderRefund();
        record.setCreateDate(new Date());
        record.setIsEnabled(true);
        record.setOutTradeNo(order.getOutTradeNo());
        record.setTradeNo(order.getTradeNo());
        record.setRefundAmount(refund_amount);
        record.setRefundReason(refund_reason);

        String out_request_no = null;
        int num = 0;
        while (true){
            out_request_no = RamdonUtil.getCode(20);
            BcPayOrderRefundExample e = new BcPayOrderRefundExample();
            e.or().andOutRequestNoEqualTo(out_request_no);
            int ornCount = bcPayOrderRefundService.countByExample(e);
            if(ornCount <= 0){
                break;
            }
            System.out.println(num);
            num++;
        }

        record.setOutRequestNo(out_request_no);
        int rc = bcPayOrderRefundService.insert(record);

        if(rc > 0){
            // 更新订单退款状态
            int oc = bcPayOrderService.updateByPrimaryKey(order);
            //获得初始化的AlipayClient
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
            //设置请求参数
            AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();

            AlipayTradeRefundModel m=new AlipayTradeRefundModel();
            m.setOutTradeNo(out_trade_no);
            m.setTradeNo(order.getTradeNo());
            m.setRefundAmount(refund_amount);
            m.setRefundReason(refund_reason);
            m.setOutRequestNo(record.getOutRequestNo());
            alipayRequest.setBizModel(m);

            try {
                AlipayTradeRefundResponse alipayResponse =alipayClient.execute(alipayRequest);
                String result = alipayResponse.getBody();

//                {
//                    "alipay_trade_refund_response": {
//                            "code": "10000",
//                            "msg": "Success",
//                            "buyer_logon_id": "rkm***@sandbox.com",
//                            "buyer_user_id": "2088102177814025",
//                            "fund_change": "Y",
//                            "gmt_refund_pay": "2019-04-01 15:29:35",
//                            "out_trade_no": "201941152622684",
//                            "refund_fee": "0.34",
//                            "send_back_fee": "0.00",
//                            "trade_no": "2019040122001414021000010992"
//                },
//                    "sign": "nP+/cbPMFq/vG80AIZZRNqVOKhCLmYIS2HHOBcOndO4TcPvSBUm1aJeboX2wuXLmP/yMMCkxi1Rds/7/3CIzkS0nwaS2iNl+LiO3s3k01uDPir30UPSwYl76fcQCCOxShK7U/5QavI9C5cTa4TvNHL71ScZJr1ZqCsroKM7lsTOM54rDeWxUP22ZiBOBDEwYw0m1HFc+IebvZm7q+SNnKnkP4V23UQ4J9CsYmD233wdTdDoYnX0kkHIbDpAAwejYan2Xu2QZO8zIgvGYYk/RCzc8FXl0OkpnCkSiLu0O1Yhd5Mu1n9oSQlnj90PzC9F3RnG3YDKMxiWQARL8LUKVCA=="
//                }

                JSONObject jsonObject = JSONObject.parseObject(result);
                JSONObject alipayTradeRefundResponse = jsonObject.getJSONObject("alipay_trade_refund_response");// 各个接口的结果集字段不一样
                String msg = alipayTradeRefundResponse.getString("msg");
                // 退款成功，更新退款状态
                if(StringUtils.isNotBlank(msg) && msg.equals("Success")){
                    BcPayOrderRefundExample e = new BcPayOrderRefundExample();
                    e.or().andOutRequestNoEqualTo(out_request_no);
                    BcPayOrderRefund orderRefund = bcPayOrderRefundService.selectFirstByExample(e);
                    orderRefund.setRefundResult(BcPayRefundStatusEnum.REFUND_ALL.getCode());
                    bcPayOrderRefundService.updateByPrimaryKey(orderRefund);
                }

                model.addAttribute("result", result);
            } catch (AlipayApiException e) {
                e.printStackTrace();
                model.addAttribute("result", "调用支付宝退款异常");
            }
        }else{
            model.addAttribute("result", "添加退款订单失败");
        }
        return thymeleaf("/alipay");
    }

    /**
     * 退款查询
     * @return
     */
    @RequestMapping(value = "/refundQuery", method = RequestMethod.POST)
    public String refundQuery(HttpServletRequest request, Model model) {

        String bcPayOrderRefundId = request.getParameter("bcPayOrderRefundId");
        Long id = null;
        try{
            id = Long.valueOf(bcPayOrderRefundId);
        } catch (NumberFormatException e){
            model.addAttribute("result", "退款ID错误");
            return thymeleaf("/alipay");
        }

        BcPayOrderRefundExample refundE = new BcPayOrderRefundExample();
        refundE.or().andIdEqualTo(id);
        BcPayOrderRefund orderRefund = bcPayOrderRefundService.selectFirstByExample(refundE);

        if(orderRefund == null){
            model.addAttribute("result", "该退款订单不存在");
            return thymeleaf("/alipay");
        }

        //支付宝交易号
        String out_trade_no = orderRefund.getOutTradeNo();
        String trade_no = orderRefund.getTradeNo();
        String out_request_no = orderRefund.getOutRequestNo();

        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();

        AlipayTradeFastpayRefundQueryModel m = new AlipayTradeFastpayRefundQueryModel();
        m.setOutTradeNo(out_trade_no);
        m.setTradeNo(trade_no);
        m.setOutRequestNo(out_request_no);
        alipayRequest.setBizModel(m);

        try {
            AlipayTradeFastpayRefundQueryResponse alipayResponse = alipayClient.execute(alipayRequest);
            String result = alipayResponse.getBody();
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

        BcPayOrder  payOrder = null;

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("outTradeNo");
        //支付宝交易号
        if(StringUtils.isBlank(out_trade_no)){
            model.addAttribute("result", "商户订单号不能为空");
            return thymeleaf("/alipay");
        }else{
            BcPayOrderExample e = new BcPayOrderExample();
            e.or().andOutTradeNoEqualTo(out_trade_no);
            List<BcPayOrder> orders = bcPayOrderService.selectByExample(e);
            if(orders == null || orders.size() != 1){
                model.addAttribute("result", "该订单不存在");
                return thymeleaf("/alipay");
            }
            payOrder = orders.get(0);
        }

        String trade_no = payOrder.getTradeNo();

        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradeCloseRequest alipayRequest = new AlipayTradeCloseRequest();

        AlipayTradeCloseModel m =new AlipayTradeCloseModel();
        m.setOutTradeNo(out_trade_no);
        m.setTradeNo(trade_no);
        alipayRequest.setBizModel(m);

        try {
            AlipayTradeCloseResponse alipayResponse = alipayClient.execute(alipayRequest);
            String result = alipayResponse.getBody();
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
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        try {
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
                //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
                params.put(name, valueStr);
            }

            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

            boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
            if(signVerified) {//验证成功

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

                model.addAttribute("result", "回调：支付成功，[out_trade_no:"+out_trade_no+",trade_no:"+trade_no+",trade_status:"+trade_status+"]");

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
     * 支付完成后回跳页面
     * @return
     */
    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, Model model) {
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        try {
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            }

            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");


            boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

            //——请在这里编写您的程序（以下代码仅作参考）——
            if(signVerified) {
                BcPayOrderExample e = new BcPayOrderExample();
                e.or().andOutTradeNoEqualTo(out_trade_no);
                List<BcPayOrder> orders = bcPayOrderService.selectByExample(e);
                if(orders != null && orders.size() > 0){
                    // 付款成功，更新付款状态
                    BcPayOrder order = orders.get(0);
                    order.setTradeNo(trade_no);
                    order.setPayResult(BcPayStatusEnum.SUCCESS.getCode());
                    bcPayOrderService.updateByPrimaryKey(order);
                    model.addAttribute("result","trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>trade_status:"+trade_status);
                }else{
                    model.addAttribute("result","trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>trade_status:"+trade_status);
                }


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
