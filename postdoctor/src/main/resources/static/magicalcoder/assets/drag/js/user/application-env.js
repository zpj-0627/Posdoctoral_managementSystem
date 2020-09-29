/*环境变量 所有变化的东西 统一放在此处*/
function ApplicationEnv(){
    var commonConfig = {
        serverPath:"/",
    }
    this.env = {
        version:"3.0.4",
        serverPath:commonConfig.serverPath,//服务端前缀
        //秘钥对 最多允许放10个 这样您可以放多个环境的 只要有一个匹配到就可以
        keys:[
            {
                domain: "127.0.0.1",
                secret: "5208868604686464623632344010886"
            },{
                //允许的域名
                domain:"localhost",
                //发放的加密串 请咨询www.magicalcoder.com
                secret:"52088686046864646272304442084",
            },
            {
                //允许的域名
                domain:".magicalcoder.com",
                //发放的加密串 请咨询www.magicalcoder.com
                secret:"00886465246864672840638602123004002352084",
            }
        ],
        /*过期时间 如果不设置则永久不过期 跟您申请的key是绑定的:配置示例2020/06/01*/
        expireDate:"",
        /*constant.js有很多通用的 常量配置 统一提前到这里*/
        constant:{
            settings:{
                /*导航树*/
                navigateTree:{
                    /*是否启用*/
                    enable:true,
                },
                /*样式工具箱*/
                styleTool:{
                    /*是否启用*/
                    enable:true,
                },
                /*文件上传*/
                file:{
                    /*上传地址需要后台接口自己写*/
                    action:commonConfig.serverPath+"web/common_file_rest/upload",
                    name:"file",
                    /*返回数据处理*/
                    callback:function (res) {
                        if(res.flag){
                            var url = res.data.src;
                            if(url.startsWith("http")){
                                return url;
                            }
                            return commonConfig.serverPath+url;
                        }
                        return "";
                    }
                },
                /*javascript脚本 <script>标签是否开启 尽量别开format:true 可能有点问题*/
                javascript:{
                    enable:true,
                    format:false
                },
                /*html <html>标签是否开启*/
                html:{
                    enable:true,
                    format:true,
                    /*html里的注释标签 您想要在此处声明*/
                    commentList:[{start:"<!--",end:"-->"},{start:"<%",end:"%>"}]
                },
                /*css样式*/
                css:{
                    enable:true,
                    format:true
                },
                /*代码调试 采用打开新连接方式 输出一个新页面，把用户的html放在新页面 这样就可以利用浏览器的调试功能 */
                debug:{
                    //必须是post接口 请自行接收head body参数 然后redirect到一个新页面 处理 切记将"&lt;"转成"<" 因为浏览器检查发现脚本就报xss攻击
                    // action:"http://localhost/debug_form",
                    action:commonConfig.serverPath+"debug_form",
                },
                /*缓存 比如刷新浏览器 可以自动恢复*/
                cache:{
                    enable:true,/*是否启用本地缓存 注意初始化后会自动读取本地浏览器缓存数据 初始化到布局器*/
                    /*存储数据到本地缓存位置*/
                    storeLocation:'localStorage',//localStorage(刷新或关闭重启浏览器可恢复) sessionStorage(仅刷新可恢复)
                },
                //布局器右上角有个预览按钮 在弹窗打开 预览一下实际情况 因不同ui依赖资源不同 所以采用配置方式来加载资源
                view:{
                    //预览地址
                    url:"view.html",
                    //layui弹窗配置 area[0]宽如果不写则自动根据当前选中的设备模式宽 area[1]高
                    layerExtra:{title:"预览",area: [, '584px']},
                },
                workspace:{
                    /*iframe 根节点html 如果您希望初始初始状态就使用自由定位 可以配置成 <div class='mc-root mc-ui-absolute-pane' id='magicalDragScene'></div>*/
                    rootHtml:"<div class='mc-root mc-ui-absolute-pane' id='magicalDragScene'></div>",
                },
                other:{
                    top:{
                        /*视图模式*/
                        mode:{
                            /*拖拽宽高是否开启*/
                            resize:true,
                            /*是否可拖到元素*/
                            drag:true
                        },
                        /*预览模式*/
                        review:{
                            /*拖拽宽高是否开启*/
                            resize:true,
                            /*是否可以拖动元素*/
                            drag:true
                        },
                        skin:{
                            /*默认皮肤*/
                            defaultValue:'mc-skin-darcula'
                        }
                    },
                    /*脚本编辑器*/
                    code:{
                        /*当出现错误时鼠标悬停是否聚焦当前结构的右侧属性面板*/
                        hoverFocusWhileError:false
                    },
                    left:{
                        // 当{}左侧组件时，自动追加到中间面板的事件名称 click dblclick click,dblclick 逗号分隔 多个
                        addToCenterEvent:'click',
                        /*当从左侧拖拽完 或者点击控件 添加到中间区域后，是否立即聚焦此控件 @2.2.9.2*/
                        afterDropIfFocus:true,
                    },
                    right:{
                        /*复选框 属性配置 是否弹出 帮助提示*/
                        tooltip:false
                    }
                }
            },
            type:{
                TEXT:"text",
                TEXTAREA:"textarea",
                SELECT:"select",
                CHECKBOX:"checkbox",
                CHECKBOX_ARRAY:"checkbox_array",//一般用于['a','b'] 或者[1,2]这种数组配置 暂时配合chang:ATTR使用 样式还不支持
                SWITCH:"switch",
                COLOR_PICKER:"colorpicker",
                FILEUPLOAD:"fileupload",
                HTML:"html",
                SLIDER:"slider",
            },
            change:{
                ATTR:"attr",
                CLASS:"class",
                TEXT:"text",
                STYLE:"style",
            }
        },
        /*index-page相关配置*/
        page:{
            remote:false,
        }
    }
    //日志
    this.log = {
        debug:true,//true|false 详细打印布局器加载过程日志信息
    }
 }
ApplicationEnv.prototype.getEnv = function () {
     return this.env;
 }
 ApplicationEnv.prototype.addTmpShadeWhileIe=function(tagClassMapping,identifiers){
    var ieVersion = this.ieVersion();
    if(ieVersion>0){//ie系列
        for(var i=0;i<identifiers.length;i++){
            var item = tagClassMapping[identifiers[i]];
            if(item){
                item.tmpWrapTag='div';
                item.tmpWrapShade=true;
            }
        }
    }
 }
/*获取ie版本*/
ApplicationEnv.prototype.ieVersion=function() {
    var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
    var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1; //判断是否IE<11浏览器
    var isEdge = userAgent.indexOf("Edge") > -1 && !isIE; //判断是否IE的Edge浏览器
    var isIE11 = userAgent.indexOf('Trident') > -1 && userAgent.indexOf("rv:11.0") > -1;
    if(isIE) {
        var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
        reIE.test(userAgent);
        var fIEVersion = parseFloat(RegExp["$1"]);
        if(fIEVersion == 7) {
            return 7;
        } else if(fIEVersion == 8) {
            return 8;
        } else if(fIEVersion == 9) {
            return 9;
        } else if(fIEVersion == 10) {
            return 10;
        } else {
            return 6;//IE版本<=7
        }
    } else if(isEdge) {
        return 100;//edge
    } else if(isIE11) {
        return 11; //IE11
    }else{
        return -1;//不是ie浏览器
    }
}
 //请不要改此处全局变量名
var APPLICATION_ENV = new ApplicationEnv();
