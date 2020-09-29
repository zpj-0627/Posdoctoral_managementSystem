/*
*给用户回调处理
* 为了达到向前兼容性 并且向后扩展性 而不改动接口参数个数 callback的入参2.3.2之后统一使用{}传参 便于后续兼容性
*/
function MagicalCallback() {

}

/**
 * 可以获取浏览器入参
 * @param name 浏览器地址的参数名
 * @return  参数值 string
 */
MagicalCallback.prototype.getParameter = function (name) {
    var query = window.location.search.substring(1);
    if(query!=''){
        var vars = query.split("&");
        for (var i=0;i<vars.length;i++) {
            var pair = vars[i].split("=");
            if(pair.length=2){
                if(pair[0] == name){return pair[1];}
            }
        }
    }
    return null;
}
/**
 * 初始化布局器成功后执行：您可以调用api.insert(html,javascript)来初始化布局器的默认数据
 * @param param.api 接口api对象 具体方法参考api.js
 */
MagicalCallback.prototype.after_start = function (param) {}


/**
 * 保存按钮
 * @param param.html 源码部分            string
 * @param param.rootNode 当前布局器JSON  JSON
 * @param param.javascript 脚本         string
 * @param param.css 样式         string
 * @param param.magicalJsCodeData 脚本编辑器数据  JSON
 * @param param.canvasStyle 画布样式         JSON
 */
MagicalCallback.prototype.save_html = function (param) {
    // console.log(param.rootNode)
    // var api = new MagicalApi();
    // console.log(MAGICAL_CODER_API.getRootNode())
}
/**
 * 扩展配置钩子 这里做一些demo 注意请不要删除此demo 因为是图标的扩展配置
 * @param param.uiType 当前ui类型 在Constant.getUiType配置
 * @param param.configElem 右侧面板中 当前扩展配置按钮 左侧的dom结构
 * @param param.rightPanelItemObj 配置条目  {type:this.type.TEXT      ,clearAttr:true       ,oneLine:true     ,change:this.change.CLASS   ,title:'图标',extend:true    }
 * @param param.focusNode 聚焦结构 调试查看 attributes是结构的各种属性
 * @param param.callback(attrName,attrValue) 记得回调
 * layer.open可以参考https://www.layui.com/doc/modules/layer.html
 */
MagicalCallback.prototype.extend_config = function (param) {
    var uiType=param.uiType,configElem=param.configElem,rightPanelItemObj=param.rightPanelItemObj,focusNode=param.focusNode,callback=param.callback;
    var api = new MagicalApi();
    //您可以在这里初始化你自己的控件,使用layui.open弹窗方式打开 参考 https://www.layui.com/doc/modules/layer.html
    if(rightPanelItemObj.extendKey =='icon'){
        var iframUrl = '';
        if(uiType==0){
            iframUrl = 'iframe-layui-2.5.4.html';
        }else if(uiType ==4){
            iframUrl = 'iframe-element-2.10.1.html';
        }else if(uiType ==5){
            iframUrl = 'iframe-antdesign-1.5.1.html';
        }else if(uiType ==6){
            iframUrl = 'iframe-vant-2.5.html';
        }
        var index = layer.open({
            type: 2,
            content: iframUrl+'?from=icon_list',
            title:'扩展编辑',
            area: ['800px', '600px'],
            maxmin:true,
            btn:['确定'],
            yes:function () {
                var attrName = rightPanelItemObj.attrName;
                var iframe = $("#layui-layer-iframe"+index).contents();
                var activeI = iframe.find(".magicalcoder-extend-icons").find("i.active").first();
                var newAttrValue = "";
                if(uiType==0){//layui
                    var newIconClass =activeI.length>0? activeI.attr("class").replace("active",'').replace("layui-icon",'').trim():"";
                    var attrValue = focusNode.attributes[attrName]||'';
                    if(attrValue.indexOf("layui-icon-")!=-1){
                        newAttrValue = attrValue.replace(/layui-icon-[-\w]+/g,newIconClass);
                    }else {
                        newAttrValue = attrValue + " "+newIconClass;
                    }
                }else if(uiType == 4){//elementui
                    var newIconClass =activeI.length>0? activeI.attr("class").replace("active",'').trim():"";
                    var attrValue = focusNode.attributes[attrName]||'';
                    if(attrValue.indexOf("el-icon-")!=-1){
                        newAttrValue = attrValue.replace(/el-icon-[-\w]+/g,newIconClass);
                    }else {
                        newAttrValue = attrValue + " "+newIconClass;
                    }
                }else if(uiType == 5){//antdegign 特别对待 没有开头标示了
                    var newIconClass =activeI.length>0? activeI.attr("class").replace("active",'').trim():"";
                    var iconName = newIconClass.replace("anticon anticon-","");//获取图标名称
                    newAttrValue=iconName;
                }else if(uiType == 6){//vant
                    var newIconClass =activeI.length>0? activeI.attr("class").replace("active",'').trim():"";
                    var iconName = newIconClass.replace("van-icon van-icon-","");//获取图标名称
                    newAttrValue=iconName;
                }

                newAttrValue = newAttrValue.trim();
                configElem.val(newAttrValue);
                //记得回调 使生效 此处暂时注释
                callback(attrName,newAttrValue);
                layer.close(index)
            },cancel: function(index, layero){
                //右上角关闭
                //return false 开启该代码可禁止点击该按钮关闭
            }
        });

    }
    else if(rightPanelItemObj.extendKey =='method'){//现在是编写方法 可视化编程了
        var changeAttrName = rightPanelItemObj.attrName;
        var pageCallback = function(){
            configElem.val(focusNode.attributes[changeAttrName]);
        }
        //往编码器页面传参
        window.pageParams = {api:api,changeAttr:rightPanelItemObj,pageCallback:pageCallback};
        var index = layer.open({
            type: 2,
            content: 'index-code.html',
            title:'定制动作事件',
            area: ['60%', '90%'],
            maxmin:true,
            moveOut:true,
            shade:false,
            btn:['保存','取消'],
            yes:function () {
                //注意这个值在magical-js-code.js文件的最下方 属于子页面回传
                var MAGICAL_JS_CODE = window.MAGICAL_JS_CODE;
                if(MAGICAL_JS_CODE){
                    if(MAGICAL_JS_CODE.save()){
                        configElem.val(focusNode.attributes[changeAttrName]);
                        api.refreshWorkspace();//立即生效
                        layer.close(index);
                    }
                }

            },cancel: function(index, layero){

            }
        });
    }
    else if(rightPanelItemObj.extendKey == 'params'){
        var attrName = rightPanelItemObj.attrName;
        var attrValue = focusNode.attributes[attrName]||'';
        var paramList = [];
        if(attrValue){
            paramList = JSON.parse(page.lowCodeUtil.xssUtil.unEscapeXss(attrValue));
        }
        var extendHrefParams = new ExtendHrefParams(paramList);
        var index = layer.open({
            type: 1,
            content: extendHrefParams.template(),
            title:'扩展编辑',
            area: ['800px', '600px'],
            maxmin:true,
            btn:['确定'],
            yes:function () {
                var data = extendHrefParams.getData();
                var newAttrValue = JSON.stringify(data);
                configElem.val(newAttrValue);
                //记得回调 使生效 此处暂时注释
                callback(attrName,page.lowCodeUtil.xssUtil.escapeXss(newAttrValue));
                layer.close(index)
            },cancel: function(index, layero){
                //右上角关闭
                //return false 开启该代码可禁止点击该按钮关闭
            }
        });
        extendHrefParams.render();
    }


}
/**
 * 右侧属性配置属性变更前的回调事件 变更非文本
 * @param param.node 当前聚焦的节点
 * @param param.name 修改的属性名
 * @param param.value 修改后的属性值
 * @param param.originValue 修改前的属性值
 * @param param.itemObj 配置属性
 */
MagicalCallback.prototype.before_change_attr_callback = function (param) {
    return true;
}
/**
 * 右侧属性配置属性变更后的回调事件 变更非文本
 * @param param.node 当前聚焦的节点
 * @param param.name 修改的属性名
 * @param param.value 修改后的属性值
 * @param param.originValue 修改前的属性值
 * @param param.itemObj 配置属性
 */
MagicalCallback.prototype.after_change_attr_callback = function (param) {
}
/**
 * 右侧属性配置属性变更前的回调事件 注意变更文本（就是结构内的文本 change:this.change.TEXT）
 * @param param.focusNode 当前聚焦的节点
 * @param param.name null
 * @param param.value 修改后的文本值
 * @param param.originValue 修改前的文本值
 * @param param.itemObj 配置属性
 */
MagicalCallback.prototype.before_change_text_callback = function (param) {return true;}
/**
 * 右侧属性配置属性变更后的回调事件 注意变更文本（就是结构内的文本 change:this.change.TEXT）
 * @param param.focusNode 当前聚焦的节点
 * @param param.name null
 * @param param.value 修改后的文本值
 * @param param.originValue 修改前的文本值
 * @param param.itemObj 配置属性
 */
MagicalCallback.prototype.after_change_text_callback = function (param) {}
/**
 *@version 2.2.7
 * 右侧属性配置样式（change:this.change.STYLE）变更前的回调事件
 * @param param.node 变更的的节点
 * @param param.name 样式名
 * @param param.value 修改后的样式值
 * @param param.originValue 修改前的样式值
 * @param param.itemObj 配置属性
 */
MagicalCallback.prototype.before_change_style_callback = function (param) {return true;}
/**
 * @version 2.2.7
 * 右侧属性配置样式（change:this.change.STYLE）变更后的回调事件
 * @param param.node 变更的的节点
 * @param param.name 样式名
 * @param param.value 修改后的样式值
 * @param param.originValue 修改前的样式值
 * @param param.itemObj 配置属性
 */
MagicalCallback.prototype.after_change_style_callback = function (param) {}
/**
 * @version 2.2.5
 * 布局器顶端重置按钮点击之前
 * @param param 如果您是手动调用api.reset(param) 可以获取 否则就是系统点击 null
 * @return true则继续执行 false终止执行
 */
MagicalCallback.prototype.reset_before = function (param) {return true;}
/**
 * @version 2.2.5
 * 布局器顶端重置按钮点击后
 * @param param 如果您是手动调用api.reset(param) 可以获取 否则就是系统点击 null
 */
MagicalCallback.prototype.reset_after = function (param) {}
/**
 * 异步构建右侧属性面板前触发 可配合api.refreshRightAttrPane()重置某些下拉框值等
 * @param param.focusNode JSON
 * @param param.notifyContinueCallback 当您的逻辑执行完 一定要执行一下param.notifyContinueCallback(); 通知布局器继续绘制 由于大部分用户绘制右侧属性 多依赖后端接口 所以我们加了notifyContinueCallback @version 2.2.9
 */
MagicalCallback.prototype.pre_build_attrs = function (param) {
    //重写此方法时 一定不能省略此行的执行 您可以在自己的ajax方法结尾加上 要通知布局器继续绘制的
    param.notifyContinueCallback();
}
/**
 * 当工作区变更后：比如拖拽 删除 等操作触发的
 * 请不要跟api.refreshWorkspace()配合使用 否则就会无限递归死循环
 * 可配合onlyCenterRefreshHtml把您修改的节点属性绘制出来
 */
MagicalCallback.prototype.after_workspace_change = function () {}
/**
 * 当拖拽左侧组件准备松手到中间区域前 如果您此时给 dragItem设置属性则也会生效
 * @param param.dragNode   拖拽的结构   JSON
 * @param param.targetNode 拖放的目标结构 JSON
 * @param param.prevNode 拖放的目标之前的结构 JSON
 * @param param.nextNode 拖放的目标之后的结构 JSON
 * @return true|false true:继续构建 false:则拖拽放入失败
 * @version 2.3.1
 */
MagicalCallback.prototype.before_drop_left_to_center = function (param) {
    return true;
}
/**
 * 当拖拽左侧组件松手到中间区域放手后
 * @param param.dragNode   拖拽的结构   JSON
 * @param param.targetNode 拖放的目标结构 JSON
 * @param param.prevNode 拖放的目标之前的结构 JSON
 * @param param.nextNode 拖放的目标之后的结构 JSON
 * @version 2.3.1
 */
MagicalCallback.prototype.after_drop_left_to_center = function (param) {}
/**
 * 删除当前聚焦的组件 剪切也会执行此处
 * @param param.deleteNodes 已经被删除的组件 JSON[]
 */
MagicalCallback.prototype.after_delete_nodes = function (param) {}

/**
 * @version 2.3.1
 * 当点击左侧组件准备加入到中间面板前触发
 * @param param.clickNode 左侧点击的结构 JSON
 * @param param.targetNodes 工作区的目标结构对应的数组 JSON[]
 * @return {boolean} true|false true:继续构建 false:则终止
 */
MagicalCallback.prototype.before_click_left_component_to_center = function (param) {
    return true;
}
/**
 * @version 2.3.1
 * 当点击左侧组件加入到中间面板后触发
 * @param param.clickNode 左侧点击的结构 JSON
 * @param param.targetNodes 工作区的目标结构对应的数组 JSON[]
 */
MagicalCallback.prototype.after_click_left_component_to_center = function (param) {}
/**
* @version 2.2.6
 * @param param.focusNodes
* 右键菜单定制
* actionName: 动作事件名称 title:中文标题 handler 处理函数
* @return  [{actionName:"saveTo",title:"另存为",handler:function(focusNodes){//ajax保存吧}}];
*/
MagicalCallback.prototype.right_menu_list = function(param){
    //return [{actionName:"test",title:"测试",handler:function(focusNodes){  console.log(focusNodes) }}]
    return [];
}

/**
* @version 2.2.7 过期方法
* 有些时候我们的标签名是区分大小写的 但是根据浏览器规则 忽略大小写
* 此时我们可以在这个回调函数里定义要转换的一个map 从而实现我们的源码中标签名支持大小写
* {
      "保持原状的标签名":["此标签上的保持原状的属性名"]
  }
  例如这个jsp标签：{"c:forEach":["varStatus"]}
*/
MagicalCallback.prototype.tagNameNotIgnoreCase = function(){return {"c:forEach":["varStatus"]}}
/**
* @version 2.2.8
* 当拖拽控件在另外一个控件上面时，控制能否在parentNode插入childNode
* @param param.parentNode {}父节点
* @param param.childNode {}孩子节点
* #param param.alertMsg true|false 当不能插入时 根据此变量 是否弹窗提示错误信息
*/
MagicalCallback.prototype.canDragInToTarget = function(param){return true;}
/**
 * 当拖拽中间组件准备松手到中间区域前
 * @param param.dragNode   拖拽的结构   JSON
 * @param param.targetNode 拖放的目标结构 JSON
 * @param param.prevNode 拖放的目标之前的结构 JSON
 * @param param.nextNode 拖放的目标之后的结构 JSON
 * @return true|false true:继续构建 false:则拖拽放入失败
 * @version 2.3.1
 */
MagicalCallback.prototype.before_drop_center_to_center = function (param) {
    return true;
}
/**
 * 当拖拽中间组件松手到中间区域后
 * @param param.dragNode   拖拽的结构   JSON
 * @param param.targetNode 拖放的目标结构 JSON
 * @param param.prevNode 拖放的目标之前的结构 JSON
 * @param param.nextNode 拖放的目标之后的结构 JSON
 * @return true|false true:继续构建 false:则拖拽放入失败
 * @version 2.3.1
 */
MagicalCallback.prototype.after_drop_center_to_center = function (param) {}
/**
* @version 2.2.8
* 重做按钮点击前执行
* @return  true|false true:继续 false:中断
*/
MagicalCallback.prototype.before_redo = function () {return true;}
/**
* @version 2.2.8
* 重做按钮点击后执行
* @return  true|false true:继续 false:中断
*/
MagicalCallback.prototype.after_redo = function () {}
/**
* @version 2.2.8
* 撤销按钮点击前执行
* @return  true|false true:继续 false:中断
*/
MagicalCallback.prototype.before_undo = function () {return true;}
/**
* @version 2.2.8
* 撤销按钮点击后执行
* @return  true|false true:继续 false:中断
*/
MagicalCallback.prototype.after_undo = function () {}
/**
 * @version 2.2.9
 * 点击顶部背景图回调 以下代码 模仿了 弹窗 给您打开一个面板 在里面选择服务器资源供选择
 */
MagicalCallback.prototype.background_image = function () {
    //获取选中的图片
    var api = new MagicalApi();
    var iframeUi = api.getIframeUi();
    var originBackgroundImage =iframeUi.getCanvasStyle()['background-image'];

    //您可以自己根据自身情况 拼接以下html
    var html = '<div class="layui-row choose-background-image" ><div class="layui-col-xs12" ><button id="_mc_upload_background_image" class="magicalcoder-layupload layui-btn" type="button" >上传图片</button></div><div class="layui-col-xs12" ><ul class="mc-background-images-ul"><li ><img style="width:100%;" src="img.jpg"/></li><li ><img style="width:100%;" src="img.jpg" /></li></ul></div></div>';
    var index = layer.open({
        type:1,
        content:html,
        title:'扩展编辑',
        area: ['800px', '600px'],
        maxmin:false,
        btn:['确定','重置'],
        yes:function () {
            //获取选中的图片
            var li = $(".choose-background-image").find(".active");
            if(li.length>0){
                var url = li.find('img').attr("src");
                var canvasStyle = iframeUi.getCanvasStyle();
                canvasStyle['background-image']= "url(\""+url+"\")";
                iframeUi.setCanvasStyle(canvasStyle);
            }

            layer.close(index)
        },
        btn2:function () {
            var canvasStyle = iframeUi.getCanvasStyle();
            delete canvasStyle['background-image'];
            iframeUi.setCanvasStyle(canvasStyle);
            layer.close(index)
        },
        cancel: function(index, layero){

        }
    })
    //上传图片按钮
    var settings = api.getConstant().getSettings();
    upload.render({
        elem: "#_mc_upload_background_image",
        drag:true,
        field:settings.file.name,
        drag:true,
        url:settings.file.action,
        done:function (res) {
            var url = settings.file.callback(res);
            var canvasStyle = iframeUi.getCanvasStyle();
            canvasStyle['background-image']= "url(\""+url+"\")";
            iframeUi.setCanvasStyle(canvasStyle);
        },
        error:function () {
            layer.msg("请求异常");
        },
    });

    $(".choose-background-image").find("li").click(function () {
        $(".choose-background-image").find(".active").removeClass("active");
        $(this).addClass("active");
    })
}
/**
 * 当向下复制后触发
 * @param param.oldNodes 被复制的节点
 * @param param.newNodes 新增的节点
 * @version 2.3.0
 */
MagicalCallback.prototype.after_duplicate = function (param) {}
/**
 * 当点击复制后
 * @param param.copyNodes 被复制的节点
 * @version 2.3.0
 */
MagicalCallback.prototype.after_copy = function (param) {}
/**
 * 当粘贴后
 * @param param.pasteNodes 被成功粘贴的节点
 * @version 2.3.0
 */
MagicalCallback.prototype.after_paste = function (param) {}
/**
 * 当新增条目后
 * @param param.newAddNodes 新增的节点
 * @version 2.3.0
 */
MagicalCallback.prototype.after_add_one_items = function (param) {}
/**
 * 导航树移动前
 * @param param.dragMcId
 * @param param.targetMcId
 * @param param.moveType inner prev next
 * @version 2.3.0
 */
MagicalCallback.prototype.before_tree_drag_drop = function (param) {return true;}
/**
 * 导航树移动后
 * @param param.dragMcId
 * @param param.targetMcId
 * @param param.moveType inner prev next
 * @version 2.3.0
 */
MagicalCallback.prototype.after_tree_drag_drop = function (param) {return true;}
/**
 * 往前移动位置 只支持当前父节点移动 不支持拖出去
 * @param param.moveMagicalCoderIds
 * @version 2.3.0
 */
MagicalCallback.prototype.before_move_to_prev = function (param) {return true;}
/**
 * 往后移动位置 只支持当前父节点移动 不支持拖出去
 * @param param.moveMagicalCoderIds
 * @version 2.3.0
 */
MagicalCallback.prototype.before_move_to_next = function (param) {return true;}
/**
 * 当加载后是否默认render 首次使用布局器返回true 恢复布局器可以使用false 可根据浏览器参数来判断返回true|false
 * @version 2.3.0
 */
MagicalCallback.prototype.default_render_after_start = function () {return true;}
