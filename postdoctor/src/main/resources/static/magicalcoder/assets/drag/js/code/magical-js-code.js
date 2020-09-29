/*做一个可视化编码工具*/
function MagicalJsCode() {
    //父页面传递子页面的参数 {api:MagicalApi,attrItem:当前事件的属性配置比如onclick} MagicalCallback.prototype.extend_config内查看
    var pageParams = window.parent.pageParams;
    //父页面的api
    this.pageApi = pageParams.api;
    this.pageChangeAttr = pageParams.changeAttr;
    //获取方法名 也可能用户没配置
    this.focusNode = pageParams.api.findFocusNodes()[0]
    this.changeAttrName = pageParams.changeAttr.attrName;
    //暂存回调一下
    this.pageCallback = pageParams.pageCallback;
    //框架 vue jquery
    this.uiFrame = this.pageApi.getConstant().UI_FRAME;
    //方法正则
    this.methodReg = new RegExp("([a-zA-Z0-9_]*)(\\(?(.*)\\)?)");
    //参数正则
    this.paramNameReg = new RegExp("^[a-zA-Z_][a-zA-Z0-9_]*$")
    //原始方法名
    this.originFunctionName = this.getFunctionName();
    //原始参数
    this.originParams = this.findMethodParams(this.getAttrValue())
    //编码页面API
    this.codeApi = null;

}
MagicalJsCode.prototype.setCodeApi = function(api){
    this.codeApi = api;
}
MagicalJsCode.prototype.getPageApi=function () {
    return this.pageApi;
}
MagicalJsCode.prototype.getPageChangeAttr=function () {
    return this.pageChangeAttr;
}
MagicalJsCode.prototype.getFunctionName=function () {
    return this.findMethodName(this.getAttrValue());
}
MagicalJsCode.prototype.replaceFunctionName=function (newFunctionName) {
    var attrValue = this.getAttrValue();
    if(attrValue){
        if(attrValue.indexOf("(")!=-1){
            this.setAttrValue(newFunctionName+attrValue.substr(attrValue.indexOf("(")));
            return;
        }
    }
    this.setAttrValue(newFunctionName);
}
MagicalJsCode.prototype.getAttrValue=function () {
    return this.focusNode.attributes[this.changeAttrName];
}
MagicalJsCode.prototype.setAttrValue=function (attrValue) {
    this.focusNode.attributes[this.changeAttrName] = attrValue;
}
MagicalJsCode.prototype.getFunctionParams = function(){
    return this.pageChangeAttr.functionParams;
}
//寻找方法名
MagicalJsCode.prototype.findMethodName = function(attrValue){
    if(typeof attrValue =='undefined' || attrValue==null){
        return ""
    }
    attrValue= $.trim(attrValue);
    if(attrValue && attrValue.indexOf("(")!=-1){
        return $.trim(attrValue.substring(0,attrValue.indexOf("(")));
    }
    return $.trim(attrValue);
}
//找到方法内部的参数
MagicalJsCode.prototype.findMethodParams = function (attrValue) {
    if(typeof attrValue =='undefined' || attrValue==null){
        return null;
    }
    attrValue= $.trim(attrValue);
    if(attrValue.indexOf("(")==-1){
        return null;
    }
    var params = [];
    attrValue = $.trim(attrValue);
    if(this.methodReg.test(attrValue)) {
        this.methodReg.exec(attrValue);
        var methodParamStr = RegExp.$2;//参数
        if(methodParamStr){
            methodParamStr=methodParamStr.replace('(','').replace(')','');
            if(methodParamStr.trim()==""){
                return [];
            }
            params = methodParamStr.split(/[,，]/);//逗号分隔
        }
    }
    var pnum=0;
    for(var i=0;i<params.length;i++){
        var paramName = $.trim(params[i]);
        if(!this.paramNameReg.test(paramName)){
            paramName = "p"+(pnum++)
        }
        params[i] = {"name":paramName,title:""};
    }
    return params;
}
MagicalJsCode.prototype.save = function(){
    var api = new MagicalApi();
    var success = true;
    //检测下语法
    {
        new CodeSyntaxCheck().check();
        this.bindDomChangeValueEvent();
        var errorNodes = api.searchNodes({fromNode:null,query:{error:true}});
        if(errorNodes.length>0){
            success = false;
        }
    }
    if(!this.setMagicalJsCodeData(api.getHtml(),api.getRootNode())){
        success = false;
    }
    return success;
}

MagicalJsCode.prototype.setMagicalJsCodeData=function(html,rootNode){
    //清了方法
    if(rootNode.magicalCoder.children.length<=0){
        if(this.originFunctionName){
            this.pageApi.getIframeUi().api().removeMagicalJsCodeDataKey(this.originFunctionName);
            this.setAttrValue("");
            this.pageCallback();
        }
        return true;
    }
    var codeTranslate = new CodeTranslate(rootNode,this.uiFrame);
    var translateObj = codeTranslate.translate();
    var functionName = translateObj.functionName;
    if(functionName){
        {
            //检测方法个数
            var api = new MagicalApi();
            var mcFunctionParamNodes =api.searchNodes({fromNode:null,query:{identifier:"mc-function-param"}});
            if(this.originParams!=null && this.originParams.length>0){
                if(this.originParams.length>mcFunctionParamNodes.length){
                    layer.alert("参数个数与界面配置的不一致,至少要保证"+this.originParams.length+"个");
                    return false;
                }
            }
        }


        //判断是否改名 先删除旧的值
        if(this.originFunctionName!==functionName){
            if(this.originFunctionName){
                this.removeMagicalJsCodeDataKey(this.originFunctionName);
            }
        }
        this.replaceFunctionName(functionName);
        //console.log(translateObj.js)
        this.pageApi.getIframeUi().api().setMagicalJsCodeDataValue(functionName,html,translateObj.js);
        this.pageCallback();
        return true;
    }else{
        layer.alert("请给方法取一个英文名[英文开头，由数字字母下划线组成]");
        return false;
    }
}
MagicalJsCode.prototype.getMagicalJsCodeDataHtml=function(functionName){
    return this.pageApi.getIframeUi().api().getMagicalJsCodeDataValue(functionName);
}
MagicalJsCode.prototype.removeMagicalJsCodeDataKey=function(functionName){
    return this.pageApi.getIframeUi().api().removeMagicalJsCodeDataKey(functionName);
}

MagicalJsCode.prototype.afterStart = function(api){
    var attrValue = this.getAttrValue();
    var functionParams = this.getFunctionParams();
    if(attrValue){
        var functionName = this.findMethodName(attrValue);
        var methodParams = this.findMethodParams(attrValue);
        if(methodParams!=null){//被替换了
            functionParams = methodParams;
        }
        var codeDataHtml = this.getMagicalJsCodeDataHtml(functionName);
        if(codeDataHtml){
            //很可能从外面改函数名和参数个数
            api.insert({html:codeDataHtml,javascript:null,css:null,magicalJsCodeData:null,canvasStyle:null});
            this.changeFunctionName(api,functionName);
            api.refreshWorkspace();
        }else{
            this.insertDefaultFunction(api,functionName,functionParams);
        }
    }else{
        //插入一个基础的函数体
        this.insertDefaultFunction(api,null,functionParams);
    }
}

MagicalJsCode.prototype.resetFunction = function(){
    var functionParams = this.getFunctionParams();
    var attrValue = this.getAttrValue();
    var functionName = null;
    if(attrValue){
        functionName = this.findMethodName(attrValue);
        var methodParams = this.findMethodParams(attrValue);
        if(methodParams!=null){//被替换了
            functionParams = methodParams;
        }
    }
    this.insertDefaultFunction(this.codeApi,functionName,functionParams);
}

MagicalJsCode.prototype.insertDefaultFunction=function(api,functionName,functionParams){
    var componentMap = api.getConstant().getComponentMap();
    api.resetHtml({parentNode:null,html:componentMap.function.html,triggerChange:false});
    //方法名
    this.changeFunctionName(api,functionName);
    //参数
    if(functionParams){
        var mcFunctionParamNodes =api.searchNodes({fromNode:null,query:{identifier:"mc-function-params"}});
        var htmlArr = []
        for(var i=0;i<functionParams.length;i++){
            var param = functionParams[i];
            htmlArr.push('<input class="layui-input mc-function-param" type="text" placeholder="参数" value="'+param.name+'"/>')
        }
        api.resetHtml({parentNode:mcFunctionParamNodes[0],html:htmlArr.join(""),triggerChange:false});
    }
    api.refreshWorkspace();
}
MagicalJsCode.prototype.changeFunctionName=function(api,functionName){
    if(functionName){
        var mcFunctionNameNodes =api.searchNodes({fromNode:null,query:{identifier:"mc-function-name"}});
        if(mcFunctionNameNodes.length>0){
            api.changeAttr({node:mcFunctionNameNodes[0],name:"value",value:functionName,triggerChange:false});
        }
    }
}
/*手动绑定 修改输入框 文本框 动态修改node节点值 操作更优*/
MagicalJsCode.prototype.bindDomChangeValueEvent=function () {
    var api = MAGICAL_CODER_API;
    var _t = this;
    //遇到输入框则可以直接填写值
    api.getIframeElemContents().find("input").unbind('change').bind('change',function () {//input change
        var value = $(this).val();
        //高级属性 来变更node的值
        var focusNode = api.getFocusNode();
        api.changeAttr({node:focusNode,name:"value",value:value,triggerChange:false});
        $(this).removeClass("magicalcoder-error");
    })
    //遇到文本框 也可以直接填写内容
    api.getIframeElemContents().find("textarea").unbind('change').bind('change',function () {//input change
        var value = $(this).val();
        //高级属性 来变更node的值
        var focusNode = api.getFocusNode();
        api.changeText({node:focusNode,text:value,triggerChange:false});
        $(this).removeClass("magicalcoder-error");
    })
    //支持下拉框选择 配置
    var iframeLayui = api.getIframeUi().api().getWindow().layui;
    iframeLayui.form.on('select', function(data){
        var value = data.value;
        //查找option孩子 并且设置selected
        var focusNode = api.getFocusNode();
        var children = focusNode.magicalCoder.children;
        for(var i=0;i<children.length;i++){
            var node = children[i];
            var nodeValue = node.attributes['value'];
            if(nodeValue===value){
                node.attributes.selected = true;
            }else{
                delete node.attributes['selected'];
            }
        }
    });
    //加上下面的控制 可以更好的优化操作体验
    api.getIframeElemContents().find("input").unbind("mouseenter").bind("mouseenter",function(e){
        api.disableDragEvent();
    })
    api.getIframeElemContents().find("input").unbind("mouseleave").bind("mouseleave",function(e){
        api.enableDragEvent();
    })
}
/**
* 界面可能有的变量
*/
MagicalJsCode.prototype.variables = function(){
    var pageVariable = [];//页面变量
    var vueData = this.pageApi.getIframeUi().api().getVueData();
    for(var key in vueData){
        pageVariable.push({name:key})
    }
    var definedVarable = [];//当前界面定义的变量 但是还有个作用域问题

    return pageVariable;
}
MagicalJsCode.prototype.variablesToOptions = function(variables){
    var options = [];
    for(var i=0;i<variables.length;i++){
        var map = {};
        map["vueData."+variables[i].name] = variables[i].name;
        options.push(map);
    }
    return options;
}
/*自动设置变量下拉*/
MagicalJsCode.prototype.setVariable = function(){
    var variables = this.variables();
    var options = this.variablesToOptions(variables);
    var rightPanel = this.codeApi.getConstant().getRightPanel();
    for(var i=0;i<rightPanel.length;i++){
        var item = rightPanel[i];
        var content = item.content;
        for(var identifier in content){
            var configList = content[identifier];
            for(var n=0;n<configList.length;n++){
                var config = configList[n];
                if(config.identifier ==='variable'){
                    config.options = options;
                }
            }
        }
    }
}
var MAGICAL_JS_CODE = new MagicalJsCode();
parent.window.MAGICAL_JS_CODE = MAGICAL_JS_CODE;//回传给父窗口 便于关闭页面时调用保存方法

