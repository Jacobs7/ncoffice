package com.dape.shop.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dape.shop.dao.model.ShopGoods;
import com.dape.shop.dao.model.ShopGoodsExample;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;
import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class ExportDgOptimusMaterial {

    public static void main(String[] args){

        // 多线程导入商品到数据库 start *******************************************************************

        int totalPage = 500;//查询开放平台的总页数
        // 查询的物料ID
        String materialIds = "13366,13367,13372,13370,13374,13371,13375,13368,13376,13369,13373";

        // 每页条数，开放平台要求最大100
        Long pageSize = 100L;

        String[] arr = materialIds.split(",");
        String url = "http://gw.api.taobao.com/router/rest";
        String appKey = "25632498";
        String secret = "51e06e43ebc6f093579131f6c7fcd568";
        Long adzoneId = 96030450186L;
        BigDecimal couponA = new BigDecimal("10");//券额大于等于10元的导入到数据库
        BigDecimal floatA = new BigDecimal("0.2");//券额占折扣价20%的导入到数据库

        webExportTbkDgOptimusMaterial(totalPage, pageSize, url, appKey, secret, adzoneId, arr, couponA, floatA);
        // 多线程导入商品到数据库 end *******************************************************************
    }

    static String url = "jdbc:mysql://39.98.78.66:3306/dp-office?useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
    static String user = "root";
    static String passwd = "tyXyp_2233!";

    static Vector<Connection> pools = new Vector<Connection>();
    public static Connection getDBConnection(){
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.取得数据库连接
            Connection conn =  DriverManager.getConnection(url, user, passwd);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    static {
        int i = 0;
        while(i<10){
            pools.add(getDBConnection());
            i++;
        }
    }
    public static synchronized Connection getPool(){
        if(pools != null && pools.size() > 0){
            int last_ind = pools.size() -1;
            return pools.remove(last_ind);
        }else{
            return getDBConnection();
        }
    }



    public static boolean addGoods(String itemId, BigDecimal zkFinalPrice, BigDecimal couponAmount, BigDecimal commission, Long materialId, JSONObject data){
        boolean flag = false;

        Connection conn = getPool();

        String sql = "INSERT INTO shop_goods(create_date,item_id,title,short_title,pict_url,small_images,click_url,zk_final_price,item_description,volume,coupon_click_url,coupon_amount,coupon_total_count,coupon_remain_count,coupon_start_fee,coupon_start_time,coupon_end_time,seller_id,shop_title,user_type,category_id,category_name,level_one_category_id,level_one_category_name,stock,sell_num,total_stock,ostime,oetime,jdd_num,jdd_price,orig_price,commission_rate,word_url,word,tmall_play_activity_info,uv_sum_pre_sale,x_id,new_user_price,material_id,commission) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = null;

        JSONObject smallImagesObj = data.getJSONObject("small_images");//小图数组
        String small_images = "";
        if(smallImagesObj != null){
            JSONArray smalls = smallImagesObj.getJSONArray("string");
            if(smalls != null && smalls.size() > 0){
                for(int m = 0; m < smalls.size(); m++){
                    small_images += smalls.getString(m);
                    if(m < smalls.size()){
                        small_images += ",";
                    }
                }
            }
        }
        JSONObject wordListObj = data.getJSONObject("word_list");
        String wordUrl = null;
        String word = null;
        if(wordListObj != null){
//                                wordUrl = data.getString("word_url");//商品相关关联词落地页地址
//                                word = data.getString("关联词");//商品相关的关联词
            wordUrl = "关联url";//商品相关关联词落地页地址
            word = "关联词";//商品相关的关联词
        }
        try {
            ps = conn.prepareStatement(sql);
            ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            ps.setString(2,itemId);
            ps.setString(3,data.getString("title"));
            ps.setString(4,data.getString("short_title"));
            ps.setString(5,data.getString("pict_url"));
            ps.setString(6,small_images);
            ps.setString(7,data.getString("click_url"));
            ps.setBigDecimal(8,zkFinalPrice);
            ps.setString(9,data.getString("item_description"));
            ps.setInt(10,data.getInteger("volume"));
            ps.setString(11,data.getString("coupon_click_url"));
            ps.setBigDecimal(12,couponAmount);
            if(data.containsKey("coupon_total_count")){
                ps.setInt(13,data.getInteger("coupon_total_count"));
            }else{
                ps.setNull(13,Types.INTEGER);
            }
            if(data.containsKey("coupon_remain_count")){
                ps.setInt(14,data.getInteger("coupon_remain_count"));
            }else{
                ps.setNull(14,Types.INTEGER);
            }
            ps.setString(15,data.getString("coupon_start_fee"));
            ps.setString(16,data.getString("coupon_start_time"));
            ps.setString(17,data.getString("coupon_end_time"));
            ps.setString(18,data.getString("seller_id"));
            ps.setString(19,data.getString("shop_title"));
            ps.setInt(20,data.getInteger("user_type"));
            ps.setString(21,data.getString("category_id"));
            ps.setString(22,data.getString("category_name"));
            ps.setString(23,data.getString("level_one_category_id"));
            ps.setString(24,data.getString("level_one_category_name"));
            if(data.containsKey("stock")){
                ps.setInt(25,data.getInteger("stock"));
            }else{
                ps.setNull(25,Types.INTEGER);
            }
            if(data.containsKey("sell_num")){
                ps.setInt(26,data.getInteger("sell_num"));
            }else{
                ps.setNull(26,Types.INTEGER);
            }
            if(data.containsKey("total_stock")){
                ps.setInt(27,data.getInteger("total_stock"));
            }else{
                ps.setNull(27,Types.INTEGER);
            }
            ps.setString(28,data.getString("ostime"));
            ps.setString(29,data.getString("oetime"));
            if(data.containsKey("jdd_num")){
                ps.setInt(30,data.getInteger("jdd_num"));
            }else{
                ps.setNull(30,Types.INTEGER);
            }
            ps.setString(31,data.getString("jdd_price"));
            ps.setString(32,data.getString("orig_price"));
            ps.setString(33,data.getString("commission_rate"));
            ps.setString(34,wordUrl);
            ps.setString(35,word);
            ps.setString(36,data.getString("tmall_play_activity_info"));
            if(data.containsKey("uv_sum_pre_sale")){
                ps.setInt(37,data.getInteger("uv_sum_pre_sale"));
            }else{
                ps.setNull(37,Types.INTEGER);
            }
            ps.setString(38,data.getString("x_id"));
            ps.setString(39,data.getString("new_user_price"));
            ps.setLong(40,materialId);
            ps.setBigDecimal(41,commission);

            ps.executeUpdate();

            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                pools.add(conn);
            }
        }
        return flag;
    }

    public static int countGoodsItemId(String itemId){
        int count = 0;
        String sql = "SELECT count(0) FROM shop_goods WHERE item_id = ?";
        Connection conn = getPool();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, itemId);
            rs = ps.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                pools.add(conn);
            }
        }
        return count;
    }

    public static Map<String, Object> webExportTbkDgOptimusMaterial(int totalPage, Long pageSize, String url, String appKey, String secret, Long adzoneId, String[] materialIds, BigDecimal couponA, BigDecimal floatA){

        int saveNum = 0;//记录保存到数据的总条数

        if(couponA == null){
            couponA = new BigDecimal("20");//券额大于19的保存到数据库
        }
        if(floatA == null){
            floatA = new BigDecimal("0.3");//券点折扣价的30%的保存到数据库
        }

        TaobaoClient client = new DefaultTaobaoClient(url, appKey, secret);
        TbkDgOptimusMaterialRequest req = null;

        Map<String, Object> exportInfo = new HashMap<String, Object>();//记录每个类目请求次数，查询条数，导入条数
        int requestNum = 0;//请求开放平台接口次数
        int queryNum = 0;
        int exportNum = 0;

        // 循环类目
        material:for(String item : materialIds){

            Long materialId = null;
            try{
                materialId = Long.valueOf(item);
            }catch (Exception e){
                continue material;
            }

            requestNum = 0;
            queryNum = 0;
            exportNum = 0;
            // 查询页数
            query:for(int i = 0; i < totalPage; i++){

                req = new TbkDgOptimusMaterialRequest();
                req.setPageSize(pageSize);
                req.setAdzoneId(adzoneId);
                req.setPageNo(Long.valueOf(i));
                req.setMaterialId(materialId);

                try {
                    TbkDgOptimusMaterialResponse rsp = client.execute(req);
                    String resultJson = rsp.getBody();

                    System.out.println(resultJson);

                    requestNum += 1;//请求总次数

                    // 返回结果转json
                    JSONObject jsonObject = JSON.parseObject(resultJson);
                    JSONObject tbkDgOptimusMaterialResponse = jsonObject.getJSONObject("tbk_dg_optimus_material_response");// 各个接口的结果集字段不一样
                    JSONObject errorResponse = jsonObject.getJSONObject("error_response");

                    if(errorResponse != null){//返回错误
                        String subMsg = errorResponse.getString("sub_msg");
                        if(subMsg.equals("无结果")){
                            break query;
                        }

                    }else if(tbkDgOptimusMaterialResponse != null){//查询成功
                        String requestId = tbkDgOptimusMaterialResponse.getString("request_id");
                        JSONObject resultList = tbkDgOptimusMaterialResponse.getJSONObject("result_list");
                        JSONArray mapData = resultList.getJSONArray("map_data");
                        if(mapData == null || mapData.size() <= 0){
                            break query;
                        }
                        queryNum += mapData.size();//记录查询总条数
                        save:for(int j = 0; j < mapData.size(); j++){
                            JSONObject data = mapData.getJSONObject(j);

                            String zkFinalPriceStr = data.getString("zk_final_price");//折扣价(未摔扣减券额)
                            String couponAmountStr = data.getString("coupon_amount");//折扣价(未摔扣减券额)
                            BigDecimal zkFinalPrice = new BigDecimal(zkFinalPriceStr);
                            BigDecimal couponAmount = new BigDecimal(couponAmountStr);

                            if(couponAmount.divide(zkFinalPrice, 2, BigDecimal.ROUND_HALF_DOWN).compareTo(floatA) == -1 && couponAmount.compareTo(couponA) == -1){
                                continue save;
                            }

                            String commissionRateStr = data.getString("commission_rate");
                            BigDecimal commissionRate = new BigDecimal("0");
                            if(StringUtils.isNotBlank(commissionRateStr)){
                                commissionRate = new BigDecimal(commissionRateStr);
                            }

                            String itemId = data.getString("item_id");
                            int count = countGoodsItemId(itemId);//验证数据是否已存在商品item_id
                            if(count > 0) {
                                continue save;
                            }

                            boolean addR = addGoods(itemId,zkFinalPrice, couponAmount, zkFinalPrice.subtract(couponAmount).multiply(commissionRate).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_DOWN), materialId, data);// 添加到数据库
                            if(addR){
                                exportNum += 1;//记录导入总条数
                                saveNum += 1;
                                System.out.println("导入条数：" + saveNum + "，分类id：" + materialId + "，商品id" + itemId);
                            }
                        }
                    }

                } catch (ApiException e) {
                    e.printStackTrace();
                    System.out.println("***************************************  异常[请求] start  ***************************************************************");
                    System.out.println("异常[请求]：导入条数：" + saveNum + ", 请求次数：" + requestNum + "，分类id：" + materialId);
                    System.out.println("***************************************  异常[请求] end  ***************************************************************");
                    break;
                } catch (Exception e1){
                    e1.printStackTrace();
                    System.out.println("***************************************  异常[其它] start  ***************************************************************");
                    System.out.println("异常[其它]：" + saveNum + ", 请求次数：" + requestNum + "，分类id：" + materialId);
                    System.out.println("***************************************  异常[其它] end  ***************************************************************");
                    break;
                }
            }
            exportInfo.put("LM_" + materialId, materialId + "：[请求次数：" + requestNum + "，查询总数：" + queryNum + "，导入总条数：" + exportNum + "]");
        }
        for(Map.Entry<String, Object> map : exportInfo.entrySet()){
            System.out.println(map.getValue());
        }
        return exportInfo;
    }
}
