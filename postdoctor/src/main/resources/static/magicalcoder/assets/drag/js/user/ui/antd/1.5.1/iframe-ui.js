/*每一种Ui的个性处理 比如各种组件初始化 重绘 注意剩余接口在iframe-ui-end.js中*/
function IframeUi() {
    this.ieVersion = ieVersion();
    this.vueData = {};
    this.vueMethod = this.api().getResetVueMethod();
    this.vueMounted = 'function(){}';
    this.defaultCss = "";//默认样式
    this.css = this.defaultCss;
    this.javascript="";
    //是否开启javascript调试
    this.debug = false;
    this.vueDataReg = new RegExp("var vueData = \\{([\\s\\S]*?)\\};\n*var vueMethod","g");
    this.vueMethodReg = new RegExp("var vueMethod = \\{([\\s\\S]*?)\\};\n*var vueMounted","g");
    this.vueMountedReg = new RegExp("var vueMounted = ([\\s\\S]*?)\n*\\/\\*注意以上代码由系统维护,非专业人士请勿修改\\*\\/","g");
    this.splitStr = ",/*别删我*/\n";
    //此正在匹配函数
    this.functionReg = new RegExp("\"?(\\w+)\"?\\s*:\\s*([\\s\\S]*)","g");
    /*脚本编辑器的数据functionName:html 方法名:脚本编辑器的可恢复数据*/
    this.magicalJsCodeData = {}
    /*工作区画布基础样式设置 key:样式名 value:样式值*/
    this.canvasStyle = {}
    this.construct();
}
IframeUi.prototype.inject = function(SINGLETON){
    this.preInject(SINGLETON);
}
//提供一系列动态操作脚本的接口 您可以调用API自由控制脚本内容
IframeUi.prototype.api = function(){
    return this.vueApi();//具体有哪些可参考ifram-ui-end.js的IframeUi.prototype.vueApi
}
/*此方法不要改名 初始化组件的方法 每次代码重绘 会调用此方法 来重新初始化组件*/
IframeUi.prototype.render=function (html,jsonFactory,globalConstant) {
    if(html==null){
        return;
    }
    var magicalCoderCss = this.autoCreateMagicalCss();
    magicalCoderCss.innerHTML = this.getCss();//设置样式内容

    var magicalDragScene = this.autoCreateRootDom();
    //由于vue框架不支持body做根 并且<template></template>标签在html里会自动变成虚无 所以我们正则替换一下 自动加上让vue渲染
    var html = this.realHtml(html);
    magicalDragScene.innerHTML = html;

    var javascript = this.getJavascript();

    try {
        if(this.debug){
            javascript = "debugger\n" + javascript;
        }
        //使用eval才行
        eval(javascript);
    }catch (e) {
        var msgHtml = '<div class="layui-row"><div class="layui-col-xs12" style="font-size: 17px; font-weight: bolder;">'+e.message+'</div><div class="layui-col-xs12" style="color: rgb(221, 32, 32);">'+e.stack+'</div></div>';
        parent.window.layui.layer.open({
            type:1,
            title:"您编写的脚本编译错误-非布局器报错",
            area: ['800px', '400px'],
            shadeClose:true,
            content:msgHtml,
        })
        console.log(e);
        eval("var Ctor = Vue.extend({});new Ctor().$mount('#magicalDragScene');new McECharts().render();");//兼容一下js错误 给出渲染界面
    }
    //做一些优化 比如删除一些不需要的结构
    this.fixDynamicDomAfterRender();
}
//修复一下动态创建的结构跑偏问题 有些ui设计的比较差 动态没用的结构很多，我们设置简介标签上的属性样式无法继承 所以就需要我们修复一下
IframeUi.prototype.fixDynamicDomAfterRender = function(){
    var _t = this;
    var rootMap = _t.magicalApi.getRootNodeMap();
        //写好标记死结构 就是为了打开弹窗的
    var dragMcPane = this.jsonFactory.api().pubGetDragMcPaneName();
    var magicalCoderIdAttrName = this.jsonFactory.api().getMagicalCoderIdAttrName();
    //修复下card
/*    $(".ant-card").each(function(){
        $(this).removeClass(dragMcPane);
        var cardBody = $(this).find(".ant-card-body");
        var mcId = $(this).attr(magicalCoderIdAttrName);
        $(this).removeAttr(magicalCoderIdAttrName);
        if(cardBody.length<=0){
            $(this).append("<div class='ant-card-body "+dragMcPane+"'"+magicalCoderIdAttrName+"='"+mcId+"'></div>")
        }else{
            cardBody.attr(magicalCoderIdAttrName,mcId);
            cardBody.addClass(dragMcPane)
        }
    })*/

    $(".ant-card").each(function(){
        $(this).removeClass(dragMcPane);
        var cardBody = $(this).find(".ant-card-body");
        var mcId = $(this).attr(magicalCoderIdAttrName);
       // $(this).removeAttr(magicalCoderIdAttrName);
        if(cardBody.length<=0){
            // $(this).append("<div class='el-card__body "+dragMcPane+"'"+magicalCoderIdAttrName+"='"+mcId+"'></div>")
            $(this).append("<div class='and-card-body "+dragMcPane+"'"+mcId+"'></div>")
        }else{
            // cardBody.attr(magicalCoderIdAttrName,mcId);
            cardBody.addClass(dragMcPane)
        }
    })
    //修复多选框
    $(".ant-checkbox-group").each(function(){
        var mcId = $(this).attr(magicalCoderIdAttrName);
        var parentNode = rootMap[mcId];
        if(parentNode){
            var children = parentNode.magicalCoder.children;
            $(this).children().each(function(idx,item){
                $(item).attr(magicalCoderIdAttrName,children[idx].magicalCoder.id);
            });

        }
    })
}

IframeUi.prototype.getJavascript = function(){
    return this.getVueScript();
}
IframeUi.prototype.setJavascript = function(javascript){
    this.setVueScript(javascript);
}
/*扩展可选图标icon*/
IframeUi.prototype.iconList = function(){
    if(window.location.href.indexOf("from=icon_list")!=-1){
        var util = this.util();
        var iconArr = ["step-backward","step-forward","fast-backward","fast-forward","shrink","arrows-alt","down","up","left","right","caret-up","caret-down","caret-left","caret-right","up-circle","down-circle","left-circle","right-circle","double-right","double-left","vertical-left","vertical-right","forward","backward","rollback","enter","retweet","swap","swap-left","swap-right","arrow-up","arrow-down","arrow-left","arrow-right","play-circle","up-square","down-square","left-square","right-square","login","logout","menu-fold","menu-unfold","border-bottom","border-horizontal","border-inner","border-left","border-right","border-top","border-verticle","pic-center","pic-left","pic-right","radius-bottomleft","radius-bottomright","radius-upleft","fullscreen","fullscreen-exit","question","question-circle","plus","plus-circle","pause","pause-circle","minus","minus-circle","plus-square","minus-square","info","info-circle","exclamation","exclamation-circle","close","close-circle","close-square","check","check-circle","check-square","clock-circle","warning","issues-close","stop","edit","form","copy","scissor","delete","snippets","diff","highlight","align-center","align-left","align-right","bg-colors","bold","italic","underline","strikethrough","redo","undo","zoom-in","zoom-out","font-colors","font-size","line-height","colum-height","dash","small-dash","sort-ascending","sort-descending","drag","ordered-list","radius-setting","area-chart","pie-chart","bar-chart","dot-chart","line-chart","radar-chart","heat-map","fall","rise","stock","box-plot","fund","sliders","lock","unlock","bars","book","calendar","cloud","cloud-download","code","copy","credit-card","delete","desktop","download","ellipsis","file","file-text","file-unknown","file-pdf","file-word","file-excel","file-jpg","file-ppt","file-markdown","file-add","folder","folder-open","folder-add","hdd","frown","meh","smile","inbox","laptop","appstore","link","mail","mobile","notification","paper-clip","picture","poweroff","reload","search","setting","share-alt","shopping-cart","tablet","tag","tags","to-top","upload","user","video-camera","home","loading","loading-3-quarters","cloud-upload","star","heart","environment","eye","eye-invisible","camera","save","team","solution","phone","filter","exception","export","customer-service","qrcode","scan","like","dislike","message","pay-circle","calculator","pushpin","bulb","select","switcher","rocket","bell","disconnect","database","compass","barcode","hourglass","key","flag","layout","printer","sound","usb","skin","tool","sync","wifi","car","schedule","user-add","user-delete","usergroup-add","usergroup-delete","man","woman","shop","gift","idcard","medicine-box","red-envelope","coffee","copyright","trademark","safety","wallet","bank","trophy","contacts","global","shake","api","fork","dashboard","table","profile","alert","audit","branches","build","border","crown","experiment","fire","money-collect","property-safety","read","reconciliation","rest","security-scan","insurance","interation","safety-certificate","project","thunderbolt","block","cluster","deployment-unit","dollar","euro","pound","file-done","file-exclamation","file-protect","file-search","file-sync","gateway","gold","robot","shopping","android","apple","windows","ie","chrome","github","aliwangwang","dingding","weibo-square","weibo-circle","taobao-circle","html5","weibo","twitter","wechat","youtube","alipay-circle","taobao","skype","qq","medium-workmark","gitlab","medium","linkedin","google-plus","dropbox","facebook","codepen","code-sandbox","amazon","google","codepen-circle","alipay","ant-design","aliyun","zhihu","slack","slack-square","behance","behance-square","dribbble","dribbble-square","instagram","yuque","alibaba","yahoo"]
        var html = [];
        html.push('<ul class="magicalcoder-extend-icons magicalcoder-antd-extend-icons">')
        for(var i=0;i<iconArr.length;i++){
            html.push("<li><a-icon type='"+iconArr[i]+"'/></li>")
        }
        html.push('</ul>')
        var magicalDragScene = this.autoCreateRootDom();
        magicalDragScene.innerHTML = html.join('');
        var Ctor = Vue.extend({});
        new Ctor().$mount('#magicalDragScene');

        var lis = document.getElementsByTagName("li");
        for(var i=0;i<lis.length;i++){
            lis[i].addEventListener('click',function () {
                var icon = this.childNodes[0]
                var active = true;
                if(icon.className.indexOf("active")==-1){
                    active = false;
                }
                var actives = document.getElementsByClassName("active");
                for(var j=0;j<actives.length;j++){
                    util.removeClass(actives[j],"active");
                }
                if(!active){
                    icon.className = icon.className +" active";
                }

            })
        }
        return true;
    }
    return false;
}
//下载按钮下载的内容
IframeUi.prototype.download = function(html){
    var source = [
        '<meta charset="UTF-8">','<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">',
        '<title>antdesign-由www.magicalcoder.com可视化布局器生成</title>',
        '<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ant-design-vue/1.5.1/antd.min.css"/>',
        '<link href="http://www.magicalcoder.com/magicaldrag/assets/drag/ui/magicalcoder/1.1.0/magicalcoder.css" rel="stylesheet"/>',

        '<!-- 如果要兼容ie8及以前版本 请打开注释--> <!-- <script src="http://www.magicalcoder.com/assets/ui/element/2.10.1/browser.min.js"></script><script src="http://www.magicalcoder.com/assets/ui/element/2.10.1/browser-polyfill.min.js"></script>-->',
        '<script src="https://cdnjs.cloudflare.com/ajax/libs/json3/3.3.3/json3.min.js"></script>',
        '<script src="https://cdnjs.cloudflare.com/ajax/libs/echarts/4.6.0/echarts.min.js"></script>',
        '<script src="https://cdnjs.cloudflare.com/ajax/libs/echarts/4.6.0/extension/dataTool.min.js"></script>',
        '<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.6.10/vue.min.js"></script>',
        '<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>',
        '<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.2/axios.min.js"></script>',
        '<script src="https://cdnjs.cloudflare.com/ajax/libs/ant-design-vue/1.5.1/antd.min.js"></script>',
        '<script src="http://www.magicalcoder.com/assets/js/common.js"></script>',
        '<script src="http://www.magicalcoder.com/magicaldrag/assets/drag/ui/magicalcoder/1.1.0/magicalcoder.js"></script>',
    ]
    //设置样式
    var style = [];
    for(var key in this.canvasStyle){
        style.push(key+":"+this.canvasStyle[key]);
    }
    var css = '\n<style>\n'+this.getCss()+'\n</style>\n';
    var head = '<head>'+source.join('\n')+css+'\n</head>\n';
    var body = '<body style="'+style.join(";").replace(/\"/g,"'")+'">\n'+this.realHtml(html)+'\n<script>\n'+this.getJavascript()+'\n</script>\n</body>\n';
    return {
        htmlBefore:"<!DOCTYPE html>\n<html><!--代码由www.magicalcoder.com可视化布局器拖拽生成 资源请自行下载到本地-->\n",
        head:head,
        body:body,
        htmlEnd:"\n</html>",
    }
}
