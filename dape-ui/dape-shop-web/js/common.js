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
function createDialog(id,title,content,foot){
    if($('#'+id+'Win').length <= 0){
        var html = '<div id="'+id+'Mask" style="opacity:1;visibility:visible;display: none;" class="weui-mask"></div><div style="opacity:1;visibility:visible;display: none;" id="'+id+'Win" class="weui-dialog weui-dialog--visible">';
        if(title != ''){
            html += '<div class="weui-dialog__hd" style="background-color: #F54D23;color: #fff;font-size: 1rem;padding:0.25rem 0 0 0;line-height: 2.5rem;"><em>'+title+'</em><a style="position: absolute;right:0.25rem;top:0.2rem;font-size: 1.25rem;color:#E9E9E9;width:2rem;" id="'+id+'Close" href="javascript:">X</a></div>';
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
    document.querySelector('#'+id).select();
    document.execCommand("Copy");
    $('#'+id).blur();
    $.toast("复制成功");
}