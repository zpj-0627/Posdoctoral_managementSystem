MagicalCallback.prototype.after_start = function (param) {
    var api = param.api;
    var pageId = this.getParameter("pageId");
    if(pageId){
        $.getJSON(APPLICATION_ENV.getEnv().serverPath+"admin/user_project_page_rest/get/"+pageId,{date:new Date().getTime()},function (data) {
            if(data.flag){
                var item = data.data;
                if(item){
                    if(item.pageHtml){
                        api.insert({html:item.pageHtml,javascript:item.pageJs,css:item.css,magicalJsCodeData:JSON.parse(item.magicalJsCodeData),canvasStyle:JSON.parse(item.canvasStyle)});
                    }
                }
            }else {
                layer.msg(data.desc);
            }
        })
        //加载我自定义的组件 参考即可 不是必须的
        var addDataFun = {
            add:function (api,data,title) {
                if(data.flag){
                    var list = data.data;
                    if(list && list.length>0){
                        var item = {
                            name:title,
                            children:[]
                        }
                        for(var i=0;i<list.length;i++){
                            var itemObj = list[i];
                            item.children.push({name:itemObj.componentName,icon:"",html:itemObj.contentHtml});
                        }
                        if(title=='用户自定义'){
                            api.getConstant().components.unshift(item);
                        }else {
                            api.getConstant().components.push(item);
                        }
                        api.rebuildLeftComponents();
                    }
                }else {
                    layer.msg(data.desc)
                }
            }
        }
        $.getJSON(APPLICATION_ENV.getEnv().serverPath+"admin/user_component_rest/page",{uiFirst:api.getConstant().UI_NAME,safeOrderBy:"sort_num asc",page:1,limit:1000},function (data) {
            addDataFun.add(api,data,"用户自定义");
        })
        $.getJSON(APPLICATION_ENV.getEnv().serverPath+"admin/user_component_enjoin_rest/page",{uiFirst:api.getConstant().UI_NAME,safeOrderBy:"sort_num asc",page:1,limit:1000},function (data) {
            addDataFun.add(api,data,"用户分享");
        })
    }
}
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
    var html = param.html,javascript=param.javascript,css=param.css,magicalJsCodeData=JSON.stringify(param.magicalJsCodeData),canvasStyle=JSON.stringify(param.canvasStyle);
    var pageId = this.getParameter("pageId");
    if(pageId){
        $.post(APPLICATION_ENV.getEnv().serverPath+"admin/user_project_page_rest/save",{id:pageId,pageHtml:html,pageJs:javascript,css:css,magicalJsCodeData:magicalJsCodeData,canvasStyle:canvasStyle},function (data) {
            if(data.flag){
                layer.msg("保存成功");
            }else {
                layer.msg(data.desc);
            }
        })
    }
}