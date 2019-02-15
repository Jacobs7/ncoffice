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
    try{
        r1=arg1.toString().split('.')[1].length;
    }catch(e){r1=0}
    try{
        r2=arg2.toString().split('.')[1].length
    }catch(e){r2=0}
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