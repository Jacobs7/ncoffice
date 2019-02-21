// 返回页面头部
function backScroll(id){
    $("#"+id).scroll(function(){
        if($('#'+id).scrollTop()>200){
            $('#backTop').fadeIn(300);
        }else{
            $('#backTop').fadeOut(300);
        }
    });
    $('#backTop').click(function () {
        $("#"+id).animate({
            scrollTop:0
        }, 200);
    });
}

// 自定义dialog，id:必须，title:可选，为空时不添加标题，content:内容，foot:页脚
// 创建后不显示，调用showDialog方法显示弹出
function createDialog(id,title,content,foot,width){
    if($('#'+id+'Win').length <= 0){
        var temp = '80%';
        if(width && width != ''){
            temp = width;
        }
        var html = '<div id="'+id+'Mask" style="opacity:1;visibility:visible;display: none;" class="weui-mask"></div><div style="opacity:1;visibility:visible;width:'+temp+';display: none;" id="'+id+'Win" class="weui-dialog weui-dialog--visible">';
        if(title != ''){
            html += '<div class="weui-dialog__hd" style="padding: 0;">'+title+'</div>';
        }
        if(content != ''){
            html += '<div class="weui-dialog__bd" style="padding: 0;">'+content+'</div>';
        }
        if(foot != ''){
            html += '<div class="weui-dialog__ft">'+foot+'</div></div>';
        }
        $('body').append(html);
        if($('#'+id+'Close').length > 0){
            $('#'+id+'Close').click(function () {
                closeDialog(id);
            });
        }
        if($('#'+id+'Mask').length > 0){
            $('#'+id+'Mask').click(function () {
                closeDialog(id);
            });
        }
    }
}
// 显示弹窗
function showDialog(id) {
    if($('#'+id+'Win').length > 0){
        $('#'+id+'Mask').show();
        $('#'+id+'Win').show();
    }
}
// 隐藏弹窗
function closeDialog(id){
    $('#'+id+'Mask').hide();
    $('#'+id+'Win').hide();
}
// 复制
function cloneTxt(id){
    var clipboard = new ClipboardJS('#'+id);
    // var clipboard = new ClipboardJS('#'+id);
    clipboard.on('success', function(e) {
        toast("复制成功");
        clipboard.destroy();
    });
}
// 自带的苹果手机会乱跳，自己实现一个
function toast(txt){
    var html = '<div class="weui-toast  weui-toast--visible"><i class="weui-icon-success-no-circle weui-icon_toast"></i><p class="weui-toast_content">复制成功</p></div>';
    $('body').append(html);
    $('.weui-toast').fadeIn(100);
    setTimeout(function () {
        $('.weui-toast').remove();
    },2000)
}
function showLoading(txt,css) {
    var html = '<div class="weui-mask_transparent"></div><div '+css+' class="weui-toast weui_loading_toast weui-toast--visible"><div class="weui_loading"><i class="weui-loading weui-icon_toast"></i></div><p class="weui-toast_content">'+txt+'</p></div>';
    $('body').append(html);
}
// 图片加载完成后，隐藏加载杠，显示分享图片框
function imgloadComplent(id) {
    $.hideLoading();
    showDialog(id);
}
// 联系客服
function showKeFu(img){
    var dialogId = 'keFuDialog';
    var len = $('#'+dialogId+'Win').length;
    var title = '<div style="font-size: 1rem;padding:0.25rem 0 0 0;line-height: 2.5rem;"><em>联系客服</em></div>';
    var content = '<div style="color: #5c5c5e;padding-bottom:0;">长按图片－识别图中二维码－联系客服</div><div class="haibaoContent"><img id="kefuImg" src="'+appURL+img+'" onload="imgloadComplent(\''+dialogId+'\')"/></div><div style="color: #F54D23;padding-bottom:0.5rem;">在线时间：周一到周日，9:00-17:30</div>';
    var footer = '<div class="haibaoFoot"><a style="flex:0 0 100%;" href="javascript:closeDialog(\''+dialogId+'\')">关闭</a></div>';
    createDialog(dialogId,title,content,footer);
    if(len > 0){
        showDialog(dialogId);
    }else{
        showLoading('请稍候...','style="min-width: 5rem;min-height: 5rem;"');
    }
}
// 验证整数
function checkInt(val) {
    var re = new RegExp("^[0-9]*[1-9][0-9]*$");
    if (val != "") {
        if (re.test(val)) {
            return true
        }
    }
    return false;
}
// 验证小数,num是小数位
function checkDecimal(val, num) {
    if(!num){
        num = 2;
    }
    if(!isNaN(val)){
        var index = val.indexOf('.');
        if(index > 0){
            var len = val.substring(index + 1, val.length);
            if(len <= num){
                return true;
            }
        }
    }
    return false;
}
function isChinaName(name) {
    var pattern = /^[\u4E00-\u9FA5]{1,6}$/;
    return pattern.test(name);
}
// 验证手机号
function isPhoneNo(phone) {
    var pattern = /^1[34578]\d{9}$/;
    return pattern.test(phone);
}
// 验证身份证
function isCardNo(card) {
    var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    return pattern.test(card);
}
// 格式化时间戳
function timeFormat(now,mask){
    var d = new Date(now);
    return dateFormat(d,mask);
}
function dateFormat(now,mask)
{
    var d = now;
    var zeroize = function (value, length)
    {
        if (!length) length = 2;
        value = String(value);
        for (var i = 0, zeros = ''; i < (length - value.length); i++)
        {
            zeros += '0';
        }
        return zeros + value;
    };

    return mask.replace(/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT])\1?|[lLZ])\b/g, function ($0)
    {
        switch ($0)
        {
            case 'd': return d.getDate();
            case 'dd': return zeroize(d.getDate());
            case 'ddd': return ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'][d.getDay()];
            case 'dddd': return ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][d.getDay()];
            case 'M': return d.getMonth() + 1;
            case 'MM': return zeroize(d.getMonth() + 1);
            case 'MMM': return ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'][d.getMonth()];
            case 'MMMM': return ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'][d.getMonth()];
            case 'yy': return String(d.getFullYear()).substr(2);
            case 'yyyy': return d.getFullYear();
            case 'h': return d.getHours() % 12 || 12;
            case 'hh': return zeroize(d.getHours() % 12 || 12);
            case 'H': return d.getHours();
            case 'HH': return zeroize(d.getHours());
            case 'm': return d.getMinutes();
            case 'mm': return zeroize(d.getMinutes());
            case 's': return d.getSeconds();
            case 'ss': return zeroize(d.getSeconds());
            case 'l': return zeroize(d.getMilliseconds(), 3);
            case 'L': var m = d.getMilliseconds();
                if (m > 99) m = Math.round(m / 10);
                return zeroize(m);
            case 'tt': return d.getHours() < 12 ? 'am' : 'pm';
            case 'TT': return d.getHours() < 12 ? 'AM' : 'PM';
            case 'Z': return d.toUTCString().match(/[A-Z]+$/);
            // Return quoted strings with the surrounding quotes removed
            default: return $0.substr(1, $0.length - 2);
        }
    });
};

// js减法运算失精度问题
function jsSubtr(arg1,arg2){
    var r1,r2,m,n;
    var tmp1 = arg1.toString().split('.');
    if(tmp1.length > 1){
        r1=tmp1[1].length;
    }else{
        r1 = 0;
    }
    var tmp2 = arg2.toString().split('.');
    if(tmp2.length > 1){
        r2=tmp2[1].length;
    }else{
        r2 = 0;
    }
    m=Math.pow(10,Math.max(r1,r2));
    //动态控制精度长度
    n=(r1>=r2)?r1:r2;
    return ((arg1*m-arg2*m)/m).toFixed(n);
}
function byFnc(zkPrice, commission_rate){
    var tmp1;
    if(typeof(commission_rate) != 'undefined'){
        var tmp = zkPrice * commission_rate;
        tmp1 = Math.floor(tmp * 0.35) / 100;
        tmp1 = tmp1.toString();
        var index = tmp1.indexOf('.');
        if(index == -1){ tmp1 += '.00'; }else if(tmp1.length <= index + 2){ tmp1 += '0'; }
    }else{
        tmp1 = '0.00';
    }
    return tmp1;
}
function tyFnc(zkPrice, commission_rate){
    var tmp2;
    if(typeof(commission_rate) != 'undefined'){
        var tmp = zkPrice * commission_rate;
        tmp2 = Math.floor(tmp * 0.5) / 100;
        tmp2 = tmp2.toString();
        index = tmp2.indexOf('.');
        if(index == -1){ tmp2 += '.00'; }else if(tmp2.length <= index + 2){ tmp2 += '0'; }
    }else{
        tmp2 = '0.00';
    }
    return tmp2;
}
// item_id:商品id,zk_final_price:折扣价,coupon_amount:券面额,coupon_click_url:券领取链接,click_url:淘客链接,item_description:推荐理由
function postGoodsDetail(item_id,platform,commission_rate,coupon_amount,coupon_click_url,click_url,item_description){
    var form = $('#goodsDetailForm');
    if(form.length <= 0){
        $('body').append('<form id="goodsDetailForm" action="/goods/goodsDetail" method="post" style="display:none;"><input type="text" name="item_id"/><input type="text" name="platform"/><input type="text" name="commission_rate"/><input type="text" name="coupon_amount"/><input type="text" name="coupon_click_url"/><input type="text" name="click_url"/><input type="text" name="item_description"/></from>');
    }
    $('#goodsDetailForm').find("input[name='item_id']").val(item_id);
    $('#goodsDetailForm').find("input[name='platform']").val(platform);
    $('#goodsDetailForm').find("input[name='commission_rate']").val(commission_rate);
    $('#goodsDetailForm').find("input[name='coupon_amount']").val(coupon_amount);
    $('#goodsDetailForm').find("input[name='coupon_click_url']").val(coupon_click_url);
    $('#goodsDetailForm').find("input[name='click_url']").val(click_url);
    $('#goodsDetailForm').find("input[name='item_description']").val(item_description);
    $('#goodsDetailForm').submit();
}

function formatCouponInfo(info){
    var tmp = info.split('减');
    if(tmp.length == 2){
        var coupon = tmp[1].replace(/元/g,'');
        if(isNaN(coupon)){
            return 0;
        }else{
            return coupon;
        }
    }
}

// 首页加载商品
function loadGoodsForMain(){
    //$.post('/goods/loadGoods',{pageNum:pageNum,pageSize:pageSize,cat:'16,18',platform:platform,has_coupon:true,need_free_shipment:true,need_prepay:true,material_id:2836,sort:'tk_rate'},function(data){
    $.post('/goods/loadGoods',{pageNum:pageNum,pageSize:pageSize,platform:platform,material_id:material_id},function(data){
      loading = false;
      if(data.success){
        var mapData = data.mapData;
        if(mapData && mapData.length > 0){
            $(mapData).each(function(){
                $this = this;
                // 天猫:icon-tianmao-18, 淘宝:icon-taobao-18, 京东:icon-jingdong-18, 拼多多:icon-pinduoduo-18
                var tianmaoCss = 'icon-tianmao-18';
                if($this.user_type == 0){
                  tianmaoCss = 'icon-taobao-18';
                }else if($this.user_type == 1){
                  tianmaoCss = 'icon-tianmao-18';
                }
                var zkPrice = jsSubtr($this.zk_final_price,$this.coupon_amount);

                // new图标是否显示，如果券开始时间为当天：显示，反之：隐藏
                var newIcon = '<img src="'+appURL+'/images/flag-new-3.png" height="32" class="newFlag" style="display: block;">';
                //if(typeof($this.coupon_start_time) != 'undefined'){
                //  var coupon_start_time = $this.coupon_start_time;
                //  if(coupon_start_time == timeFormat($this.createDate,'yyyy-MM-dd')){
                //   newIcon = '<img src="'+appURL+'/images/flag-new-3.png" height="32" class="newFlag" style="display: block;">';
                //  }
                //}else{
                //  newIcon = '';
                //}

                $('#goodsUL').append('<li>' +
                      //'<a href="/goods/goodsDetail?numIid='+$this.item_id+'&platform='+platform+'">' +
                      '<a href="javascript:void(0)" onclick="postGoodsDetail('+$this.item_id+','+platform+','+$this.commission_rate+','+$this.coupon_amount+',\'https:'+$this.coupon_share_url+'\',\'https:'+$this.click_url+'\',\''+$this.item_description+'\')">' +
                        newIcon +
                        '<span class="quanFlag"><div><b>'+$this.coupon_amount+'</b></div><div style="white-space:nowrap;color:#fff;">元券</div></span>' +
                        '<div class="proimg">' +
                          '<img src="http:'+$this.pict_url+'">' +
                        '</div>' +
                        '<div class="protxt">' +
                        // 根据店铺类型判断是天猫、淘宝
                          '<div class="name" style="position: relative;">' +
                          '<i class="icon18-zz '+tianmaoCss+'" style="margin-right: 5px;"></i>' +
                          '<em style="position: absolute;top: -1px;">'+$this.title+'</em></div>' +
                          '<div class="name" style="position: relative;"><p>' +
                            '<em class="nowPrice">￥'+zkPrice+'</em>' +
                            '<span class="oldPrice">￥'+$this.zk_final_price+'</span>' +
                            '<small class="monthOrderNum">月销'+$this.volume+'件</small>' +
                            '</p></div>' +
                          '<div class="return" style="margin-bottom: 3px;">' +
                            '<div style="background-color: #dc2527;color: #fff;">标佣¥'+byFnc(zkPrice,$this.commission_rate)+'</div>' +
                            '<div style="color: #dc2527;">特佣¥'+tyFnc(zkPrice,$this.commission_rate)+'</div>' +
                            '</div>' +
                          '</div>' +
                        '</a>' +
                      '</li>');
            });
        }else{
            $("#listwrap").append('<div class="weui-cells__title" style="text-align: center;margin-bottom:5rem;">已无更多数据</div>');
            loading = true;
        }
      }else{
        $("#listwrap").append('<div class="weui-cells__title" style="text-align: center;margin-bottom:5rem;">已无更多数据</div>');
        loading = true;
        if(data.msg){
          $.toast(data.msg, 'forbidden');
        }else{
          $.toast('发送失败', 'forbidden');
        }
      }

      $(".weui-loadmore").hide();
    });
}

// 首页加载数据库商品
function loadLocalGoodsForMain(){
    $.post('/goods/loadLocalGoods',{pageNum:pageNum,pageSize:pageSize,platform:platform,materialId:material_id},function(data){
      loading = false;
      if(data.success){
        var mapData = data.data;
        if(mapData && mapData.length > 0){
            $(mapData).each(function(){
                $this = this;
                // 天猫:icon-tianmao-18, 淘宝:icon-taobao-18, 京东:icon-jingdong-18, 拼多多:icon-pinduoduo-18
                var tianmaoCss = 'icon-tianmao-18';
                if($this.userType == 0){
                  tianmaoCss = 'icon-taobao-18';
                }else if($this.userType == 1){
                  tianmaoCss = 'icon-tianmao-18';
                }
                var zkPrice = jsSubtr($this.zkFinalPrice,$this.couponAmount);

                // new图标是否显示，如果券开始时间为当天：显示，反之：隐藏
                var newIcon = '<img src="'+appURL+'/images/flag-new-3.png" height="32" class="newFlag" style="display: block;">';

                $('#goodsUL').append('<li>' +
                      '<a href="javascript:void(0)" onclick="postGoodsDetail('+$this.itemId+','+platform+','+$this.commissionRate+','+$this.couponAmount+',\'https:'+$this.couponShareUrl+'\',\'https:'+$this.clickUrl+'\',\''+$this.itemDescription+'\')">' +
                        newIcon +
                        '<span class="quanFlag"><div><b>'+$this.couponAmount+'</b></div><div style="white-space:nowrap;color:#fff;">元券</div></span>' +
                        '<div class="proimg">' +
                          '<img src="http:'+$this.pictUrl+'">' +
                        '</div>' +
                        '<div class="protxt">' +
                        // 根据店铺类型判断是天猫、淘宝
                          '<div class="name" style="position: relative;">' +
                          '<i class="icon18-zz '+tianmaoCss+'" style="margin-right: 5px;"></i>' +
                          '<em style="position: absolute;top: -1px;">'+$this.title+'</em></div>' +
                          '<div class="name" style="position: relative;"><p>' +
                            '<em class="nowPrice">￥'+zkPrice+'</em>' +
                            '<span class="oldPrice">￥'+$this.zkFinalPrice+'</span>' +
                            '<small class="monthOrderNum">月销'+$this.volume+'件</small>' +
                            '</p></div>' +
                          '<div class="return" style="margin-bottom: 3px;">' +
                            '<div style="background-color: #dc2527;color: #fff;">标佣¥'+byFnc(zkPrice,$this.commissionRate)+'</div>' +
                            '<div style="color: #dc2527;">特佣¥'+tyFnc(zkPrice,$this.commissionRate)+'</div>' +
                            '</div>' +
                          '</div>' +
                        '</a>' +
                      '</li>');
            });
        }else{
            $("#listwrap").append("<div class=\"weui-cells__title\" style='text-align: center;margin-bottom:5rem;'>已无更多数据</div>");
            loading = true;
        }
      }else{
        $("#listwrap").append("<div class=\"weui-cells__title\" style='text-align: center;margin-bottom:5rem;'>已无更多数据</div>");
        loading = true;
        if(data.msg){
          $.toast(data.msg, 'forbidden');
        }else{
          $.toast('发送失败', 'forbidden');
        }
      }

      $(".weui-loadmore").hide();
    });
}


// 综合排序
function sortTTSFnc(){
    if(sort == 'tk_total_sales_des'){
      sort = 'tk_total_sales_asc';
    }else if(sort == 'tk_total_sales_asc'){
      sort = 'tk_total_sales_des';
    }else{
      sort = 'tk_total_sales_des';
    }
    setJian(sort);
}
// 销量排序
function sortTSFnc(){
    if(sort == 'total_sales_des'){
      sort = 'total_sales_asc';
    }else if(sort == 'total_sales_asc'){
      sort = 'total_sales_des';
    }else{
      sort = 'total_sales_des';
    }
    setJian(sort);
}
// 价格排序
function sortPFnc(){
    if(sort == 'price_asc'){
      sort = 'price_des';
    }else if(sort == 'price_des'){
      sort = 'price_asc';
    }else{
      sort = 'price_asc';
    }
    setJian(sort);
}
// 搜索按钮
function searchPBtn(){
    setJian(sort);
}
// 设置排序箭头
function setJian(sort){
$('#sortDiv').find('i').remove();
$('#sortDiv').find('.on').removeClass('on');
  if(sort == 'tk_total_sales_des'){
    $('#tk_total_sales').append('<i class="icon18-zz icon-jian-18-2" style="margin-bottom:-3px;"></i>');
    $('#tk_total_sales').addClass('on');
  }else if(sort == 'tk_total_sales_asc'){
    $('#tk_total_sales').append('<i class="icon18-zz icon-jian-18-2" style="margin-bottom:-3px;"></i>');
  }else if(sort == 'total_sales_des'){
    $('#total_sales').append('<i class="icon18-zz icon-jian-18-2" style="margin-bottom:-3px;"></i>');
    $('#total_sales').addClass('on');
  }else if(sort == 'total_sales_asc'){
    $('#total_sales').append('<i class="icon18-zz icon-jian-18-2" style="margin-bottom:-3px;"></i>');
  }else if(sort == 'price_des'){
    $('#price_asc').append('<i class="icon18-zz icon-jian-18-2" style="margin-bottom:-3px;"></i>');
    $('#price_asc').addClass('on');
  }else if(sort == 'price_asc'){
    $('#price_asc').append('<i class="icon18-zz icon-jian-18-2" style="margin-bottom:-3px;"></i>');
  }
    $('#goodsUL').html('');
    q = $('#qTxt').val();
    if(q == ''){
      cat = '16,30,50020808,50010788,1801,50012100,1625,50002768,50008163,50006842';
    }else{
      cat = '';
    }
    loadGoodsForSearch();

}
// 查询页商品加载
function loadGoodsForSearch(){
    $(".weui-cells__title").remove();
    $(".weui-loadmore").show();
    $.post('/goods/loadSearchGoods',{pageNum:pageNum,pageSize:pageSize,q:q,cat:cat,material_id:material_id,has_coupon:has_coupon,sort:sort},function(data){
      loading = false;
      if(data.success){
        var mapData = data.mapData;
        if(mapData && mapData.length > 0){

            var commission_rate,coupon_amount;
            $(mapData).each(function(){
                $this = this;
                // 天猫:icon-tianmao-18, 淘宝:icon-taobao-18, 京东:icon-jingdong-18, 拼多多:icon-pinduoduo-18
                var tianmaoCss = 'icon-tianmao-18';

                commission_rate = 0;
                coupon_amount = 0;

                  commission_rate = $this.commission_rate / 100;
                  if(!!$this.coupon_info && $this.coupon_info != ''){
                    coupon_amount = formatCouponInfo($this.coupon_info);
                  }

                var zkPrice = jsSubtr($this.zk_final_price,coupon_amount);
                $('#goodsUL').append('<li>' +
                    //'<a href="/goods/goodsDetail?numIid='+num_iid+'&platform='+platform+'">' +
                    '<a href="javascript:void(0)" onclick="postGoodsDetail('+$this.num_iid+','+platform+','+commission_rate+','+coupon_amount+',\'https:'+$this.coupon_share_url+'\',\'https:'+$this.url+'\',\'\')">' +
                    '<img src="'+appURL+'/images/flag-new-3.png" height="32" class="newFlag" style="display: block;">' +
                    '<span class="quanFlag"><b>'+coupon_amount+'</b><br>元券</span>' +
                    '<div class="proimg">' +
                    '<img src="'+$this.pict_url+'">' +
                    '</div>' +
                    '<div class="protxt">' +
                    // 根据店铺类型判断是天猫、淘宝
                    '<div class="name" style="position: relative;">' +
                    '<i class="icon18-zz '+tianmaoCss+'" style="margin-right: 5px;"></i>' +
                    '<em style="position: absolute;top: -1px;">'+$this.title+'</em></div>' +
                    '<div class="name" style="position: relative;"><p>' +
                    '<em class="nowPrice">￥'+zkPrice+'</em>' +
                    '<span class="oldPrice">￥'+$this.zk_final_price+'</span>' +
                    '<small class="monthOrderNum">月销'+$this.volume+'件</small>' +
                    '</p></div>' +
                    '<div class="return" style="margin-bottom: 3px;">' +
                    '<div style="background-color: #d02c37;color: #fff;">标佣¥'+byFnc(zkPrice,commission_rate)+'</div>' +
                    '<div style="color: #d02c37;">特佣¥'+tyFnc(zkPrice,commission_rate)+'</div>' +
                    '</div>' +
                    '</div>' +
                    '</a>' +
                    '</li>');
            });
        }else{
            $("#goodsUL").append('<div class="weui-cells__title" style="text-align: center;margin-bottom:5rem;">已无更多数据</div>');
            loading = true;
        }
      }else{
        $("#listwrap").append('<div class="weui-cells__title" style="text-align: center;margin-bottom:5rem;">已无更多数据</div>');
        loading = true;
      }

      $(".weui-loadmore").hide();
    });
}

// 详情页加载商品
function loadInfo(){
    if(!!goodsDetail && goodsDetail.length > 0){
      var item = goodsDetail[0];
      numIid = item['num_iid'];
      // 商品图片
      pictUrl = item['pict_url'];
      $('#picList').append('<div class="swiper-slide"><img src="'+pictUrl+'" /></div>');
      var small_images = item['small_images'];
      if(!!small_images && small_images['string'].length > 0){
        for(var i = 0; i < small_images['string'].length; i++){
          $('#picList').append('<div class="swiper-slide"><img src="'+small_images['string'][i]+'" /></div>');
        }
      }
      // 券
      $('#quanFlag').append('<b>￥'+coupon_amount+'</b>');
      userType = item['user_type'];
      if(userType == 0){// 淘宝图标
        $('#itemTitle').append('<i class="icon18-zz icon-tianmao-18"></i>');
      }else if(userType == 1){// 天猫图标
        $('#itemTitle').append('<i class="icon18-zz icon-tianmao-18"></i>');
      }
      title = item['title'];
      $('#itemTitle').append('<em style="padding:1.1rem;">'+title+'</em>');
      // 原价、折扣价
      zkFinalPrice = item['zk_final_price'];
      zkPrice = jsSubtr(zkFinalPrice,coupon_amount);
      $('#itemPrice').append('<em class="num" style="font-size: 0.95rem;font-weight: bold;">¥'+zkPrice+'</em>');
      $('#itemPrice').append('<em class="detail-price-s">原价'+zkFinalPrice+'</em>');
      volume = item['volume'];
      $('#itemPrice').append('<em class="detail-price-v">月销量'+volume+'</em>');
      // 包邮
      if(!!item['free_shipment']){
        freeShipment = item['free_shipment'];
      }
      // 佣金
      $('#biaoYong').text(byFnc(zkPrice,commission_rate));
      $('#teYong').text(tyFnc(zkPrice,commission_rate));
      if(item_description != ''){
        $('#itemDescription').text(item_description);
      }else{
        $('#itemDescription').css('text-align','center');
      }
      // 详情

      // 评价

    }
}


// 抢券淘口令
function qiangquan(){
    if(tkl == ''){
        showLoading('正在获取淘口令','style="min-width: 6.5rem;min-height: 6.5rem;"');
        $.post('/goods/goodsTPwd',{url:coupon_click_url,text:title},function(data){
            $.hideLoading();
            if(data.success){
                tkl = data.model;
                tklTxt = txt+tkl+'复制这条信息，打开手机淘宝即可领券';
                if(!data.isLogin){
                    $.alert('亲，你还没有登录<br/>登录后才能获得返佣哦',function(){
                        showTKLWin(tklTxt);
                    });
                }else{
                    showTKLWin(tklTxt);
                }
            }else{
                if(data.msg){
                  toast(data.msg);
                }else{
                  toast('获取淘口令失败');
                }
            }

        });
    }else{
        showTKLWin(tklTxt);
    }

}
// 淘口令窗口
function showTKLWin(tklTxt){
  var dialogId = 'qianquan';
  var title = '<div style="background-color: #F54D23;color: #fff;font-size: 1rem;padding:0.25rem 0 0 0;line-height: 2.5rem;"><em>抢券淘口令</em><a style="position: absolute;right:0.25rem;top:0.2rem;font-size: 1.25rem;color:#E9E9E9;width:2rem;" id="'+dialogId+'Close" href="javascript:">X</a></div>';
  var content = '<div id="copyDiv" class="puBody">' +
        '<h2><em>长按框内 <u class="p3">&gt;</u> 全选 <u class="p3">&gt;</u> 复制</em></h2>' +
        '<form name="puKoulingForm" id="puKoulingForm">' +
          '<textarea class="inputArea inputArea-2" id="copyKeyAndroid">'+tklTxt+'</textarea>' +
        '</form>' +
      '</div>' +
      '<div id="copyButton" class="imne-copy-btn" style="display: block;" onclick="cloneTxt(\'copyButton\')" data-clipboard-text="'+tklTxt+'">一键复制</div>' +
      '<div class="hasCoupon" style="display: block;" id="hasCoupon">复制淘口令，打开【手机淘宝】即可领券！</div>';
  var footer = '';
  createDialog(dialogId,title,content,footer);
  showDialog(dialogId);
  // showLoading('正在获取淘口令','style="min-width: 6.5rem;min-height: 6.5rem;"');
  // $.post('/goods/quanKey',{goodId:''},function (data){
  //     $.hideLoading();
  //     if(data && data.copyTxt){
  //         $('#copyButton').attr('data-clipboard-text', data.copyTxt);
  //         $('#copyKeyAndroid').text(data.copyTxt);
  //         $('#copyButton').click(function (e) {
  //             cloneTxt('copyButton');
  //         })
  //     }
  //     showDialog(dialogId);
  // });
  // colseDialog(dialogId);
}

// 生成推广海报
function haibao() {
  if(!!goodsDetail && goodsDetail.length > 0){
        if(tkl == ''){
            $.post('/goods/goodsTPwd',{url:coupon_click_url,text:title},function(data){
                $.hideLoading();
                if(data.success){
                    tkl = data.model;
                    tklTxt = txt+tkl+'复制这条信息，打开手机淘宝即可领券';
                    createHaiBao();
                }else{
                    toast('生成海报失败');
                }
            });
        }else{
            createHaiBao();
        }

  }
}
function createHaiBao(){
    var dialogId = 'haibao';
    var len = $('#'+dialogId+'Win').length;
    var content = '<div class="haibaoContent"><img id="goodsHaibao" onload="imgloadComplent(\''+dialogId+'\')"/></div><div class="haibao-c-remark" style="color: #d47b4f;">长按图片发送给朋友，或保存到手机</div><div class="haibao-c-remark" style="color: #d9d9db;">好友通过领券购买，您即可赚取佣金</div>';
    var footer = '<div class="haibaoFoot"><a href="javascript:" id="copyTitle" onclick="cloneTxt(\'copyTitle\')" data-clipboard-text="'+title+'">复制标题</a><a href="javascript:" id="copyText" onclick="cloneTxt(\'copyText\')" data-clipboard-text="'+txt+'长按识别二维码，复制口伶或网址，打开手机淘宝，领券下单'+'">复制文案</a><a href="javascript:closeDialog(\''+dialogId+'\')">关闭</a></div>';
    createDialog(dialogId,'',content,footer);
    $.post('/goods/haibao',{
      shopType : userType,
      platform : platform,
      itemId : numIid,
      pictUrl : pictUrl,
      title : title,
      zkFinalPrice : zkFinalPrice,
      freeShipment : freeShipment,
      volume : volume,
      couponAmount : coupon_amount,
      tkl:tkl
    },function (data) {
      $('#goodsHaibao').attr('src',data.url);
    });
    if(len > 0){
      showDialog(dialogId);
    }else{
      //$.showLoading('正在生成<br>分享图片');// 自带的不能调节宽高
      showLoading('正在生成海报','style="min-width: 7.5rem;min-height: 7.5rem;"');
    }
}
var index_t;
// 显示首页菜单
function menuPopup(obj){
    var top = $(obj).offset().top + $(obj).height();
    $("#top-menu-box").css('top',top + 20);
    $("#top-menu-box-mask").show();
    $("#top-menu-box").show(200);
    //index_t = setTimeout("hideMenuPopup()",3000)
}
// 隐藏首页菜单
function hideMenuPopup(){
  $("#top-menu-box").hide(200);
  $("#top-menu-box-mask").hide();
  //clearTimeout(index_t);
}
// 淡入淡出
function deqFadeToggle(){
    if($("#top-menu-box").is(':hidden')){
        $("#top-menu-box-mask").show();
        $("#top-menu-box").fadeIn(100);
    }else{
        $("#top-menu-box-mask").hide();
        $("#top-menu-box").fadeOut(100);
    }
}
function toNewUrl(obj, url){
    $('#top-menu-box').find('.menuOn').removeClass('menuOn');
    $(obj).addClass('menuOn');
    window.location.href = url;
}
function toModulePage(id,url,platform){
    if(id == 8){
        showKeFu(url);
    }else{
        window.location.href = url + '?platform=' + platform;
    }
}

// 抓取商品详情
function goodsTBDetail(){
$.post('/goods/goodsTBDetail',{itemId:numIid,platform:platform},function(data){
    if(data.success){
        var imgStr = data.imgsStr;
        imgStr = imgStr.substring(10, imgStr.length-3).replace(/align="absmiddle"/g, '').replace(/class="desc_anchor"/g, '').replace(/id="desc-module-1"/g, '').replace(/<p>/g, '').replace(/<\/p>/g, '').replace(/<img/g, '<img width="100%"');
        $('#detailImgs').append(imgStr);
        console.log(imgStr);
    }
});
}
