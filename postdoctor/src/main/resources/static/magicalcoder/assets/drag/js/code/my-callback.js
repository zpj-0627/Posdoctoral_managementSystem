/*回调重写*/
MagicalCallback.prototype.after_start = function (param) {
    var api = param.api;
    MAGICAL_JS_CODE.setCodeApi(api);
    MAGICAL_JS_CODE.afterStart(api);
    MAGICAL_JS_CODE.setVariable()
}
/*暂存按钮*/
MagicalCallback.prototype.save_html = function (param) {
    MAGICAL_JS_CODE.save();
    layer.msg("暂存成功")
}
MagicalCallback.prototype.reset_after = function (param) {
    MAGICAL_JS_CODE.resetFunction();
}
MagicalCallback.prototype.after_workspace_change=function(){
	new CodeSyntaxCheck().check();
    MAGICAL_JS_CODE.bindDomChangeValueEvent();
}
