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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExportDgOptimusMaterial {

    public static void main(String[] args){

        // 多线程导入商品到数据库 start *******************************************************************

        int totalPage = 500;//查询开放平台的总页数


        // 查询的物料ID
        String hqzb = "hqzb|1:3756,2:3767,3:3758,4:3759,5:3762,6:3763,7:3764,8:3765,9:3760,10:3761,11:3766";//好券直播
        String deq = "deq|1:9660,2:9658,3:9655,4:9656,5:9648,6:9653,7:9654,8:9652,9:9650,10:9649,11:9651";//大额券
        String gyb = "gyb|1:13366,2:13367,3:13368,4:13369,5:13370,6:13371,7:13372,8:13373,9:13374,10:13375";//高佣榜
        String ppq = "ppq|1:3786,2:3788,3:3792,4:3793,5:3796,6:3794,7:3790,8:3787,9:3789,10:3791,11:3795";//品牌券
        String myzt = "myzt|1:4040,2:4041,3:4044,4:4042,5:4043,6:4045";

        String[] types1 = {hqzb,deq,gyb,ppq,myzt};

        String jhs = "jhs|1:4071";// 聚划算
        String yhh = "yhh|1:4092";// 有好货
        String clf = "clf|1:4093";// 潮流范
        String th = "th|1:4094";// 特惠

        String[] types2 = {yhh,clf,th};

        // 每页条数，开放平台要求最大100
        Long pageSize = 100L;

        String url = "http://gw.api.taobao.com/router/rest";
        String appKey = "25632498";
        String secret = "51e06e43ebc6f093579131f6c7fcd568";
        Long adzoneId = 96030450186L;
        BigDecimal couponA = new BigDecimal("0");//券额大于等于10元的导入到数据库
        BigDecimal floatA = new BigDecimal("0");//券额占折扣价20%的导入到数据库

        Map<String, Object> exportInfo1 = webExportTbkDgOptimusMaterial(totalPage, pageSize, url, appKey, secret, adzoneId, types1, couponA, floatA, "", "_type");
        Map<String, Object> exportInfo2 = webExportTbkDgOptimusMaterial(totalPage, pageSize, url, appKey, secret, adzoneId, types2, couponA, floatA, "is_", "");

        System.out.println();
        System.out.println("******************************  导入数据  **************************************");
        for(Map.Entry<String, Object> map : exportInfo1.entrySet()){
            System.out.println(map.getValue());
        }
        for(Map.Entry<String, Object> map : exportInfo2.entrySet()){
            System.out.println(map.getValue());
        }
        System.out.println("******************************  导入数据  **************************************");
        System.out.println();
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

    static Pattern pattern = Pattern.compile("[0-9]*");


    public static boolean editGoods(String itemId, BigDecimal zkFinalPrice, BigDecimal couponAmount, BigDecimal commission, Long materialId, JSONObject data, String column, Integer materialType, String prex, String sufx){
        boolean flag = false;
        Connection conn = getPool();
        String sql = "UPDATE shop_goods SET ";
        sql += "title = ?,";
        sql += "short_title = ?,";
        sql += "pict_url = ?,";
        sql += "small_images = ?,";
        sql += "click_url = ?,";
        sql += "zk_final_price = ?,";
        sql += "item_description = ?,";
        sql += "volume = ?,";
        sql += "coupon_share_url = ?,";
        sql += "coupon_amount = ?,";
        sql += "coupon_total_count = ?,";
        sql += "coupon_remain_count = ?,";
        sql += "coupon_start_time = ?,";
        sql += "coupon_end_time = ?,";
        sql += "commission_rate = ?,";
        sql += "new_user_price = ?,";
        sql += "commission = ?";//佣金
        if(StringUtils.isNotBlank(column)){
            sql += "," + prex + column + sufx + " = ?";
        }
        sql += " WHERE item_id=?";
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

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,data.getString("title"));
            ps.setString(2,data.getString("short_title"));
            ps.setString(3,data.getString("pict_url"));
            ps.setString(4,small_images);
            ps.setString(5,data.getString("click_url"));
            ps.setBigDecimal(6,zkFinalPrice);
            ps.setString(7,data.getString("item_description"));
            ps.setInt(8,data.getInteger("volume"));
            ps.setString(9,data.getString("coupon_share_url"));
            ps.setBigDecimal(10,couponAmount);
            if(data.containsKey("coupon_total_count")){
                ps.setInt(11,data.getInteger("coupon_total_count"));
            }else{
                ps.setNull(11,Types.INTEGER);
            }
            if(data.containsKey("coupon_remain_count")){
                ps.setInt(12,data.getInteger("coupon_remain_count"));
            }else{
                ps.setNull(12,Types.INTEGER);
            }
            String couponStartTime = data.getString("coupon_start_time");
            if(StringUtils.isNotBlank(couponStartTime)){
                Long dateMillis = null;
                Matcher isNum = pattern.matcher(couponStartTime);
                if(isNum.matches()){
                    dateMillis = Long.valueOf(couponStartTime);
                    ps.setTimestamp(13,new Timestamp(dateMillis));
                }else{
                    ps.setNull(13, Types.TIMESTAMP);
                }
            }else{
                ps.setNull(13, Types.TIMESTAMP);
            }
            String couponEndTime = data.getString("coupon_end_time");
            if(StringUtils.isNotBlank(couponEndTime)){
                Long dateMillis = null;
                Matcher isNum = pattern.matcher(couponEndTime);
                if(isNum.matches()){
                    dateMillis = Long.valueOf(couponEndTime);
                    ps.setTimestamp(14,new Timestamp(dateMillis));
                }else{
                    ps.setNull(14, Types.TIMESTAMP);
                }
            }else{
                ps.setNull(14, Types.TIMESTAMP);
            }
            ps.setString(15,data.getString("commission_rate"));
            ps.setString(16,data.getString("new_user_price"));
            ps.setBigDecimal(17,commission);
            int index = 18;
            if(StringUtils.isNotBlank(column)){
                ps.setInt(index,materialType);
                index++;
            }
            ps.setString(index,itemId);

            ps.execute();

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

    public static boolean addGoods(String itemId, BigDecimal zkFinalPrice, BigDecimal couponAmount, BigDecimal commission, Long materialId, JSONObject data, String column, Integer materialType, String prex, String sufx){
        boolean flag = false;

        Connection conn = getPool();

        String sql = "INSERT INTO shop_goods(create_date,item_id,title,short_title,pict_url,small_images,click_url,zk_final_price,item_description,volume,coupon_share_url,coupon_amount,coupon_total_count,coupon_remain_count,coupon_start_fee,coupon_start_time,coupon_end_time,seller_id,shop_title,user_type,category_id,category_name,level_one_category_id,level_one_category_name,stock,sell_num,total_stock,ostime,oetime,jdd_num,jdd_price,orig_price,commission_rate,word_url,word,tmall_play_activity_info,uv_sum_pre_sale,x_id,new_user_price,material_id,commission,coupon_info,nick";
        if(StringUtils.isNotBlank(column)){
            sql += "," + prex + column + sufx;
        }
        sql += ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
        if(StringUtils.isNotBlank(column)){
            sql += ",?";
        }
        sql += ")";

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
            ps.setString(11,data.getString("coupon_share_url"));
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
            String couponStartTime = data.getString("coupon_start_time");
            if(StringUtils.isNotBlank(couponStartTime)){
                Long dateMillis = null;
                Matcher isNum = pattern.matcher(couponStartTime);
                if(isNum.matches()){
                    dateMillis = Long.valueOf(couponStartTime);
                    ps.setTimestamp(16,new Timestamp(dateMillis));
                }else{
                    ps.setNull(16, Types.TIMESTAMP);
                }
            }else{
                ps.setNull(16, Types.TIMESTAMP);
            }

            String couponEndTime = data.getString("coupon_end_time");
            if(StringUtils.isNotBlank(couponEndTime)){
                Long dateMillis = null;
                Matcher isNum = pattern.matcher(couponEndTime);
                if(isNum.matches()){
                    dateMillis = Long.valueOf(couponEndTime);
                    ps.setTimestamp(17,new Timestamp(dateMillis));
                }else{
                    ps.setNull(17, Types.TIMESTAMP);
                }
            }else{
                ps.setNull(17, Types.TIMESTAMP);
            }

            ps.setString(18,data.getString("seller_id"));
            ps.setString(19,data.getString("shop_title"));
            if(data.containsKey("user_type")){
                ps.setInt(20,data.getInteger("user_type"));
            }else{
                ps.setNull(20,Types.INTEGER);
            }
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
            ps.setString(42,data.getString("coupon_info"));
            ps.setString(43,data.getString("nick"));

            if(StringUtils.isNotBlank(column)){
                ps.setInt(44, materialType);
            }

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

    public static Map<String, Object> webExportTbkDgOptimusMaterial(int totalPage, Long pageSize, String url, String appKey, String secret, Long adzoneId, String[] arr, BigDecimal couponA, BigDecimal floatA, String prex, String sufx){

        int addNum = 0;//记录保存到数据的总条数
        int editNum = 0;//修改的记录

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
        arrLoop:for(String item : arr){

            String[] materials = item.split("\\|");
            if(materials.length != 2){
                continue arrLoop;
            }
            String column = materials[0];
            String typeMaterialStr = materials[1];
            String[] typeMaterials = typeMaterialStr.split(",");
            if(typeMaterials.length <= 0){
                continue arrLoop;
            }
            typeLoop:for(String typeMaterial : typeMaterials){
                String[] tempArr = typeMaterial.split(":");
                if(tempArr.length != 2){
                    continue typeLoop;
                }
                String materialType = tempArr[0];
                String materialIdStr = tempArr[1];
                Long materialId = null;
                try{
                    materialId = Long.valueOf(materialIdStr);
                }catch (Exception e){
                    continue typeLoop;
                }

                requestNum = 0;
                queryNum = 0;
                exportNum = 0;

                Long pageNo = 1L;
                importLoop:while(true){
                    req = new TbkDgOptimusMaterialRequest();
                    req.setPageSize(pageSize);
                    req.setAdzoneId(adzoneId);
                    req.setPageNo(pageNo);
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
                            if(subMsg.equals("无结果")){// 无结果跳出当前循环
                                break importLoop;
                            }

                        }else if(tbkDgOptimusMaterialResponse != null){//查询成功
                            String requestId = tbkDgOptimusMaterialResponse.getString("request_id");
                            JSONObject resultList = tbkDgOptimusMaterialResponse.getJSONObject("result_list");
                            JSONArray mapData = resultList.getJSONArray("map_data");
                            if(mapData == null || mapData.size() <= 0){// 无结果跳出当前循环
                                break importLoop;
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
                                    // 更新子物料类型
                                    Integer materialTypeInt = Integer.valueOf(materialType);
                                    boolean editR = editGoods(itemId,zkFinalPrice,couponAmount,zkFinalPrice.subtract(couponAmount).multiply(commissionRate).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_DOWN),materialId, data, materialTypeInt==0?"":column, materialTypeInt, prex, sufx);
                                    if(editR){
                                        exportNum += 1;//记录导入总条数
                                        editNum += 1;
                                        System.out.println("更新条数：" + editNum + "，分类id：" + materialId + "，商品id" + itemId);
                                    }
                                }else{// 新增
                                    boolean addR = addGoods(itemId,zkFinalPrice, couponAmount, zkFinalPrice.subtract(couponAmount).multiply(commissionRate).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_DOWN), materialId, data, column, Integer.valueOf(materialType), prex, sufx);// 添加到数据库
                                    if(addR){
                                        exportNum += 1;//记录导入总条数
                                        addNum += 1;
                                        System.out.println("导入条数：" + addNum + "，分类id：" + materialId + "，商品id" + itemId);
                                    }
                                }
                            }
                        }

                    } catch (ApiException e) {
                        e.printStackTrace();
                        System.out.println("***************************************  异常[请求] start  ***************************************************************");
                        System.out.println("异常[请求]：导入条数：" + addNum + ", 请求次数：" + requestNum + "，分类id：" + materialId);
                        System.out.println("***************************************  异常[请求] end  ***************************************************************");
                        break;
                    } catch (Exception e1){
                        e1.printStackTrace();
                        System.out.println("***************************************  异常[其它] start  ***************************************************************");
                        System.out.println("异常[其它]：" + addNum + ", 请求次数：" + requestNum + "，分类id：" + materialId);
                        System.out.println("***************************************  异常[其它] end  ***************************************************************");
                        break;
                    }
                    pageNo++;
                }
                exportInfo.put("LM_" + materialId, materialId + "：[请求次数：" + requestNum + "，查询总数：" + queryNum + "，导入总条数：" + exportNum + "]");

            }
        }
        return exportInfo;
    }
}
