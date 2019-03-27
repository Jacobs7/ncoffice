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
    clipboard.on('success', function(e) {
        toast("复制成功");
        clipboard.destroy();
    });
}
// 自带的苹果手机会乱跳，自己实现一个
function toast(txt){
    var html = '<div class="weui-toast  weui-toast--visible" style="margin-left:0;"><i class="weui-icon-success-no-circle weui-icon_toast"></i><p class="weui-toast_content">'+txt+'</p></div>';
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
        showLoading('请稍候...','style="min-width:5rem;min-height:5rem;margin-left:0;"');
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
// 首页加载数据库商品
function loadGoods(){
    $.post('/goods/loadGoods',{pageNum:pageNum,pageSize:pageSize,type:type,field:field,title:title,sort:sort,des:des},function(data){
      loading = false;
      if(data.success){
        var mapData = data.data;
        if(mapData && mapData.length > 0){
            $(mapData).each(function(){
                $this = this;
                var zkPrice = jsSubtr($this.zkFinalPrice,$this.couponAmount);

                // new图标是否显示，如果券开始时间为当天：显示，反之：隐藏
                var newIcon = '<img src="'+appURL+'/images/flag-new-3.png" height="32" class="newFlag" style="display: block;">';

                $('#goodsUL').append('<li>' +
                      '<a href="/goods/goodsDetail?itemId='+$this.itemId+'">' +
                        newIcon +
                        '<span class="quanFlag"><div><b>'+$this.couponAmount+'</b></div><div style="white-space:nowrap;color:#fff;">元券</div></span>' +
                        '<div class="proimg">' +
                          '<img onload="imgLoadC(this)" style="display:none;" src="'+$this.pictUrl+'">' +
                          '<div class="loading-c"><div class="object object_one"></div><div class="object object_two"></div><div class="object object_three"></div></div>'+
                        '</div>' +
                        '<div class="protxt">' +
                        // 根据店铺类型判断是天猫、淘宝
                          '<div class="name" style="position: relative;">' +
                          '<em style="position: absolute;top: -1px;">'+$this.title+'</em></div>' +
                          '<div class="name" style="position: relative;"><p>' +
                            '<em class="nowPrice">￥'+zkPrice+'</em>' +
                            '<span class="oldPrice">￥'+$this.zkFinalPrice+'</span>' +
                            '<small class="monthOrderNum">月销'+$this.volume+'件</small>' +
                            '</p></div>' +
                          '</div>' +
                        '</a>' +
                      '</li>');
            });
        }else{
            $(".w-main").append("<div class=\"weui-cells__title\" style='text-align: center;margin-bottom:5rem;'>已无更多数据</div>");
            loading = true;
        }
      }else{
        $(".w-main").append("<div class=\"weui-cells__title\" style='text-align: center;margin-bottom:5rem;'>已无更多数据</div>");
        loading = true;
        if(data.msg){
          toast(data.msg);
        }else{
          toast('发送失败');
        }
      }

      $(".weui-loadmore").hide();
    });
}

// 首页加载数据库商品
function loadCouponsGoods(){
    $.post('/goods/loadCouponGoods',{pageNum:pageNum,pageSize:pageSize,type:type,field:field,title:title,sort:sort,des:des},function(data){
      loading = false;
      if(data.success){
        var mapData = data.data;
        if(mapData && mapData.length > 0){
            $(mapData).each(function(){
                $this = this;
                var zkPrice = jsSubtr($this.zkFinalPrice,$this.couponAmount);

                // new图标是否显示，如果券开始时间为当天：显示，反之：隐藏
                var newIcon = '<img src="'+appURL+'/images/flag-new-3.png" height="32" class="newFlag" style="display: block;">';

                $('#goodsUL').append('<li>' +
                      '<a href="/goods/goodsDetail?itemId='+$this.itemId+'">' +
                        newIcon +
                        '<span class="quanFlag"><div><b>'+$this.couponAmount+'</b></div><div style="white-space:nowrap;color:#fff;">元券</div></span>' +
                        '<div class="proimg">' +
                          '<img onload="imgLoadC(this)" style="display:none;" src="'+$this.pictUrl+'">' +
                          '<div class="loading-c"><div class="object object_one"></div><div class="object object_two"></div><div class="object object_three"></div></div>'+
                        '</div>' +
                        '<div class="protxt">' +
                          '<div class="name" style="position: relative;">' +
                          '<em style="position: absolute;top: -1px;">'+$this.title+'</em></div>' +
                          '<div class="name" style="position: relative;"><p>' +
                            '<em class="nowPrice">￥'+zkPrice+'</em>' +
                            '<span class="oldPrice">￥'+$this.zkFinalPrice+'</span>' +
                            '<small class="monthOrderNum">月销'+$this.volume+'件</small>' +
                            '</p></div>' +
                          '</div>' +
                        '</a>' +
                      '</li>');
            });
        }else{
            $(".w-main").append("<div class=\"weui-cells__title\" style='text-align: center;margin-bottom:5rem;'>已无更多数据</div>");
            loading = true;
        }
      }else{
        $(".w-main").append("<div class=\"weui-cells__title\" style='text-align: center;margin-bottom:5rem;'>已无更多数据</div>");
        loading = true;
        if(data.msg){
          toast(data.msg);
        }else{
          toast('发送失败');
        }
      }

      $(".weui-loadmore").hide();
    });
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
    pageNum = 1;
    $('#goodsUL').html('');
    q = $('#qTxt').val();
    loadGoodsForSearch();

}
// 显示首页菜单
function menuPopup(obj){
    var top = $(obj).offset().top + $(obj).height();
    $("#top-menu-box").css('top',top + 20);
    $("#top-menu-box-mask").show();
    $("#top-menu-box").show(200);
}
// 隐藏首页菜单
function hideMenuPopup(){
  $("#top-menu-box").hide(200);
  $("#top-menu-box-mask").hide();
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
function toModulePage(id,url,url2){
    if(id == 5){
        window.location.href = url2;
    }else if(id == 6){
        showKeFu(url2);
    }else{
        window.location.href = url;
    }
}
// 抓取商品详情
function goodsDetailImgs(url){
    if(url == ''){
        return;
    }
    $.post('/goods/goodsDetailImgs',{imgsUrl:url},function(data){
        $('#detailImgs').find('.loading-d').remove();
        if(data.success){
            var imgsArr = data.imgsArr;
            $(imgsArr).each(function(){
                $('#detailImgs').append('<img onload="imgLoadComplete(this)" src='+this+' />');
            });
        }
    });
}
// 图片加载完成设置宽度(商品详情页)
function imgLoadComplete(obj){
    var widthB = $('body').width();
    if(obj.width >= widthB){
        $(obj).width("100%");
    }
}
// 抓取商品评价
function goodsTBPJ(){
$.post('/goods/goodsTBPJ',{pjUrl:'https://rate.tmall.com/list_detail_rate.htm?itemId='+numIid+'&sellerId='+sellerId+'&pageSize='+pageSize},function(data){
    $('#detailPj').find('.loadingImg').remove();
        if(data.success){
            //console.log(data.TBPJ);
        }
    });
}
// 图片加载完成删除等待样式
function imgLoadD(obj){
    $(obj).parent().find('.loading-d').remove();
    $(obj).show();
}
function imgLoadC(obj){
    $(obj).parent().find('.loading-c').remove();
    $(obj).show();
}