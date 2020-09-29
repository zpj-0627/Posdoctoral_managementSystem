//建议您使用继承方式 扩展开发 而不是直接修改magicalcoder_open_api的文件
//做法 新建一个my.js 引入紧跟demo.js下面
//比如 我们要重写回调方法实现：这么写 下次升级 你就不用因为变更引起的合并问题了
//MagicalCallback.prototype.save_html = function (...) {
    //加入你自己的逻辑
// }

/*调用API实例*/

setTimeout(function () {
    var api = new MagicalApi();
    //var str = '{"attributes":{"id":"magicalDragScene","name":"","title":"","class":"mc-root mc-ui-absolute-pane","style":""},"magicalCoder":{"children":[{"attributes":{"id":"","name":"","title":"","class":"","style":"position: absolute; left: 31.5457%; top: 7.83333%; width: 33.6478%;"},"magicalCoder":{"children":[{"attributes":{"id":"","name":"","title":"","class":"","style":"","value":"0"},"magicalCoder":{"children":[{"attributes":{"id":"","name":"","title":"","class":"","style":""},"magicalCoder":{"children":[],"tagName":"","nodeType":3,"textContent":"选项A"}}],"tagName":"option","nodeType":1,"textContent":""}},{"attributes":{"id":"","name":"","title":"","class":"","style":"","value":"1"},"magicalCoder":{"children":[{"attributes":{"id":"","name":"","title":"","class":"","style":""},"magicalCoder":{"children":[],"tagName":"","nodeType":3,"textContent":"选项B"}}],"tagName":"option","nodeType":1,"textContent":""}}],"tagName":"select","nodeType":1,"textContent":""}},{"attributes":{"id":"","name":"switch","title":"","class":"","style":"position: absolute; left: 31.5457%; top: 30.6667%;","type":"checkbox","lay-skin":"switch"},"magicalCoder":{"children":[],"tagName":"input","nodeType":1,"textContent":""}},{"attributes":{"id":"","name":"","title":"","class":"","style":"width: 38.3648%; position: absolute; left: 31.5457%; top: 49.3333%;","controls":"controls"},"magicalCoder":{"children":[],"tagName":"audio","nodeType":1,"textContent":""}}],"tagName":"div","nodeType":1,"textContent":""}}'
   // api.insertNode({rootNode:JSON.parse(str)})

},5000)
