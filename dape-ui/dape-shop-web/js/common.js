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