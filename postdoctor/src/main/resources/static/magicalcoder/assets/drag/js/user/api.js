/*给用户主动调用的 您不需要改动 或者重写
* 只要 var api = new MagicalApi();
* 即可使用api.getHtml();等各种方法
* 为了达到向前兼容性 并且向后扩展性 而不改动接口参数个数 api的入参2.3.2之后统一使用{}传参 便于后续兼容性
* 比如api.getMagicalCoderIds({elem:null,firstSearchParent:false})
* */
function MagicalApi() {

}
/*get*/
/**
 * 获取布局器HTML源码
 * @return string
 */
MagicalApi.prototype.getHtml=function () {}
/**
 * 获取布局器脚本
 * @return string
 */
MagicalApi.prototype.getJavascript=function () {}
/**
 * 获取布局器根节点json
 * @return JSON
 */
MagicalApi.prototype.getRootNode=function () {}
/**
 * @3.0.1
 * 获取布局器纯净的根节点json 仅用来保存和恢复数据时使用即可 此值是拷贝的 并不是原始root
 * @return JSON
 */
MagicalApi.prototype.getPureRootNode=function () {}
/**
 * @version 2.2.9
 * 获取样式
 */
MagicalApi.prototype.getCss = function(){}
/**
 * @version 2.2.9
 * 获取脚本设计器的数据
 */
MagicalApi.prototype.getMagicalJsCodeData = function(){}
/**
 * @version 2.2.9
 * 获取脚本设计器的根画布的样式
 * @return obj{}
 */
MagicalApi.prototype.getCanvasStyle = function(){}
/**
 * 能获取表单条目下的控件数据
 * @return JSON[]
 */
MagicalApi.prototype.getFormItemNodes = function (){}
/**
 * 获取constatn.js实例
 * 这样就可以灵活的根据事件情况来调整配置
 * @return JSON
 */
MagicalApi.prototype.getConstant = function () {}
/**
 * 获取iframe-ui.js实例
 * 这样就可以灵活的根据事件情况来调整配置
 * 打开iframe-ui.js 找到prototype.api=function(){} 您可以使用api.getIframeUi().api().各类操作脚本的方法
 * @return JSON
 */
MagicalApi.prototype.getIframeUi = function () {}
/**
 * @version 2.3.0
 * 搜索当前dom所属的node.magicalCoder.Id
 * @param param.elem 当前的dom结构 $DOM 必填
 * @param param.firstSearchParent 首先往外层搜索 true|false  建议填写false可搜索绝大部分的场景
 * @return [] 大部分场景仅返回一个
 */
MagicalApi.prototype.getMagicalCoderIds = function (param) {}
/**
 * @version 2.3.0
 * 根据id获取dom结构
 * @param param.id 必填
 * @return {}
 */
MagicalApi.prototype.getElemByMagicalCoderId = function(param){}
/**
 * @version 2.3.0
 * 根据id获取node节点
 * @param param.id
 * @return {}
 */
MagicalApi.prototype.getNodeByMagicalCoderId = function (param) {}
/**
 * @version 2.3.0
 * 获取iframe的jquery对象 这样就可以自由获取内部结构了
 * @return 返回iframe内的$Dom
 * api.getIframeElemContents().find("input") 使用jquery查询方式即可
 */
MagicalApi.prototype.getIframeElemContents = function () {}
/**
 * 获取聚焦结构 默认返回第一个聚焦的原生
 * @return JSON[]
 */
MagicalApi.prototype.getFocusNode = function () {}
/**
 * 获取聚焦结构
 * @return JSON[]
 */
MagicalApi.prototype.findFocusNodes = function () {}
/**
 * 根据magicalCoderParam查询结构
 * @param param.fromNode 从哪个节点开始往下搜索 如果为null 则默认从根节点 JSON 必填
 * @param param.query 查询参数例如 查看node.magicalCoder属性即可得知参数 {id:1,....}  object 必填
 * return []
 */
MagicalApi.prototype.searchNodes = function (param) {}
/**
 * 查找前置节点
 * @param param.id string
 * @return JSON
 */
MagicalApi.prototype.findPreNode = function (param) {}
/**
 * 查找后置节点
 * @param param.id string
 * @return JSON
 */
MagicalApi.prototype.findNextNode = function (param) {}
/**
 * 查找父亲节点
 * @param param.id string
 * @return JSON
 */
MagicalApi.prototype.findParentNode = function (param) {}

/**
 * 比如 "el-input":[{type:this.type.SELEC,attrName:'type',options:[{"text":"输入框","textarea":"文本框"}],"myId":"el-input-type",.....},]
 * @version 2.2.5
 * @param param.key     rightPanel下的content下的key 比如 'el-input'
 * @param param.query 自定义一个查询 {"属性名":"属性值"} 这里的属性名可以由您自己定义一个 {"attrName":"type"}

 * 根据某个查询条件查询constant.js中配置的this.rightPanel下的一组满足条件的数据
 * 使用场景：如果您要根据ajax数据动态更改下拉框值 此方法很有用 记得改完调用api的refreshRightAttrPane()方法
 * @return []
 例如：以下代码更改form表单的label-position值 假设这段代码放after_start
 var list = api.getRightPanelItemListFromConstant({key:"el-form",query:{attrName:"label-position"}});
 console.log(list);
 for(var i=0;i<list.length;i++){
        list[i].options=[{"1":"新值"}]
    }
 */
MagicalApi.prototype.getRightPanelItemListFromConstant = function(param){}
/**
 * @version 2.2.7
 * 把rootNode平展开以key value形式返回
 * key:magicalCoder.id value:node
 * @param param.node 如果为null则默认取rootNode 根节点开始遍历
 *@return {}
 */
MagicalApi.prototype.getRootNodeMap=function(param){}
/*insert*/
/**
 * 插入html javascript css...常用于初始化布局器
 * @param param.html        取值=""可以实现清空布局器  string
 * @param param.javascript  取值=null可以实现重置布局器的脚本 千万不要为"" 否则默认脚本不支持 工作区不渲染 string
 * @param param.css  取值=""可以实现清空样式 =null 则加载默认样式 string
 * @param param.magicalJsCodeData  脚本设计器的预置值，取值={}可以实现清空 =null 则加载默认 object
 * @param param.canvasStyle  body画布基本样式，取值={}可以实现清空 =null 则加载默认样式 object
 * api.insert({html:"",javascript:null,css:null,magicalJsCodeData:null,canvasStyle:null})
 */
MagicalApi.prototype.insert=function (param) {}
/**
 * 根据rootNode 还原布局器
 * @param param.rootNode  根据之前保存的json方式恢复布局器 javascript请配合insertJavascript实现 JSON
 * @param param.javascript  取值=null可以实现重置布局器的脚本 千万不要为"" 否则默认脚本不支持 工作区不渲染 string
 * @param param.css  取值=""可以实现清空样式 =null 则加载默认样式 string
 * @param param.magicalJsCodeData  脚本设计器的预置值，取值={}可以实现清空 =null 则加载默认 object
 * @param param.canvasStyle  body画布基本样式，取值={}可以实现清空 =null 则加载默认样式 object
 * api.insert({rootNode:null,javascript:null,css:null,magicalJsCodeData:null,canvasStyle:null})
 */
MagicalApi.prototype.insertNode=function (param) {}
/**
 * 插入HTML到布局器
 * @param param.html  取值=""可以实现清空布局器 string
 */
MagicalApi.prototype.insertHtml=function (param) {}
/**
 * 插入RootNode到布局器
 * @param param.rootNode 取值null 可以清空布局器
 */
MagicalApi.prototype.insertRootNode=function (param) {}
/**
 * 插入javascript脚本 请尽量在insertHtml方法之后执行 因为大部分脚本操作的是html 必须先有html
 * @param param.javascript 不要="" 可以使用null来重置脚本 string
 */
MagicalApi.prototype.insertJavascript=function (param) {}
/**
 * @version 2.2.9
 * 插入css
 * @param param.css 取值=""可以实现清空样式 =null 则加载默认样式 string
 */
MagicalApi.prototype.insertCss=function (param) {}
/**
 * @version 2.2.9
 * 插入脚本设计器的数据
 * @param param.magicalJsCodeData 取值={}可以实现清空 =null 则加载默认样式 object
 */
MagicalApi.prototype.insertMagicalJsCodeData=function (param) {}
/**
 * @version 2.2.9
 * 插入脚本设计器的根画布样式
 * @param param.canvasStyle 取值={}可以实现清空 =null 则加载默认样式 object
 */
MagicalApi.prototype.insertCanvasStyle=function (param) {}

/*update*/
/**
 * @version 2.2.9.2
 * 更改一组样式
 * @param param.node 被操作的节点                         json
 * @param param.styleObj {width:"100px",height:"100px"}  json
 * @param param.triggerChange 是否刷新界面   true|false
 * 不会触发样式回调事件
 */
MagicalApi.prototype.changeStyles = function (param) {}
/**
 * @version 2.2.9.2
 * 改变样式
 * @param param.node 被操作的节点                         json
 * @param param.name 样式名 "height"                string
 * @param param.value 样式值 "100px"                string
 * @param param.triggerChange true|false 是否触发刷新
 */
MagicalApi.prototype.changeStyle = function (param){}
/**
 * @version 2.3.0
 * 改变文本
 * @param param.node 被操作的节点           json
 * @param param.text 内部文本               string
 * @param param.triggerChange true|false 是否触发刷新
 */
MagicalApi.prototype.changeText = function (param){}
/**
 * @version 2.3.0
 * 改变文本
 * @param param.node 被操作的节点           json
 * @param param.name  属性名             string
 * @param param.value 属性值               string
 * @param param.triggerChange true|false 是否触发刷新
 */
MagicalApi.prototype.changeAttr = function (param){}
/**
 * 重新设置孩子节点 比如您想在某个节点插入html 那么可以先把html调用htmlToRootNode得到node,
 * 然后childrenNodes = node.magicalCoder.children; 然后就可以调用此方法了 一般用在回调处理上
 * @param param.parentId 父节点magicalCoder.Id string
 * @param param.childrenNodes 子节点数组 JSON[]
 */
MagicalApi.prototype.resetChildren = function(param){}
/**
 * 在节点中追加html
 * @param param.parentNode  JSON 父节点
 * @param param.html  string
 * @param param.preNode  JSON 在此节点后追加
 * @return true|false
 */
MagicalApi.prototype.appendHtml = function (param) {}
/**
 * 重置父节点内的html
 * @param param.parentNode  JSON 父节点
 * @param param.html  string 要被设置的新html
 * @param param.triggerChange  boolean 是否触发刷新
 * @return true|false
 */
MagicalApi.prototype.resetHtml = function (param) {}
/**
 * 移动节点
 * @param param.dragId 要移动的id string
 * @param param.targetId 目标id string
 * @param param.moveType 可选值 inner prev next 类型 string
 */
MagicalApi.prototype.moveExistNode = function (param) {}
/*delete*/
/**
 * 删除多个节点
 * @param param.nodes 被删除的节点数组 只要保证有magicalCoder.id就好了 JSON[]
 */
MagicalApi.prototype.deleteNodes = function (param) {}
/**
 * @version 2.2.5
 * @param param 自定义一个参数 配合callback.js的reset_before(param)
 * 重置布局器
 */
MagicalApi.prototype.reset = function (param) {}
/*tool*/
/**
 * 聚焦某个结构
 * @param param.ids 结构的唯一magicalCoder.id string[]
 * @param param.force 强制刷新右侧属性面板 true|false
 */
MagicalApi.prototype.focus = function (param) {}
/**
 * 把html转换成magicalCoderNode数据 注意只能包裹在一个标签内 如果有多个标签并列，可以临时用<div></div>包裹传入 最好获取node.magicalCoder.children即可拿到多个
 * @param param.html string
 */
MagicalApi.prototype.htmlToRootNode = function (param) {}
/**
 * 把magicalCoder node数据转换成html
 * @param param.nodes  可以通过rootNode.magicalCoder.children传入  JSON[]
 * @param param.pure true|false 是否包含magicalcode属性 默认false  boolean
 */
MagicalApi.prototype.nodesToHtml = function (param) {}
/**
 * 把magicalCoder node数据转换成html
 * @param param.node   JSON
 * @param pure true|false 是否包含magicalcode属性 默认false  boolean
 */
MagicalApi.prototype.nodeToHtml = function (param) {}

/**
 * 主动触发布局器重绘工作区
 * @param param.force 是否强制刷新 默认false 强制刷新当您刷新不生效时可使用 比较耗费性能 会丢失当前聚焦结构 @2.2.9新增
 */
MagicalApi.prototype.refreshWorkspace = function (param) {}

/**
 * 仅仅把中间html重绘 并不触发节点变更
 */
MagicalApi.prototype.onlyCenterRefreshHtml = function(){}
/**
 * 重新构造左侧组件列表:如果您动态的向左侧增删组件 可以使用此方法
 * 您只需要修改完constant中的配置后 直接调用此方法 无需额外调用api.refresh();
 */
MagicalApi.prototype.rebuildLeftComponents = function () {}
/**
 * 刷新拖拽事件
 */
MagicalApi.prototype.refreshDragEvent = function () {}
/**
* 禁用拖拽事件
* @versin 2.3.0
*/
MagicalApi.prototype.disableDragEvent = function(){}
/**
* 启用拖拽事件
* @versin 2.3.0
*/
MagicalApi.prototype.enableDragEvent = function(){}
/**
 * 刷新右侧属性面板 如果您获取constant并且 动态修复属性配置，则需要调用此方法刷新事件
 * @param param.id string
 */
MagicalApi.prototype.refreshRightAttrPane = function (param) {}
/**
* @version 2.2.9
* 刷新整个布局器 简单粗暴
*/
MagicalApi.prototype.refreshAll = function(){}

