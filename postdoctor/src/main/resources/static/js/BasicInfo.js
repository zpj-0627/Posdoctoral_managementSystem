//民族下拉框
function selectNational(r){
    layui.use(['form','jquery'],function () {
         var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryNational",
                dataType: "json",
                cache: false,
                success: function (data) {

                    $('#pNation').append(new Option());
                    $.each(data,function (index,item) {
                        $('#pNation').append(new Option(item.title,item.dictionaryid));
                        $('#pNation').val(r.pnation);
                    });
                    form.render('select');

                },error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//婚姻下拉框
function selectmarriage(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryMarriage",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#pMarriage').append(new Option());
                    $.each(data, function (index, item) {
                        $('#pMarriage').append(new Option(item.title, item.dictionaryid));
                        $('#pMarriage').val(r.pmarriage);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//政治面貌下拉框
function selectPPstatus(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPPstatus",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#pPStatus').append(new Option());
                    $.each(data,function (index,item) {
                        $('#pPStatus').append(new Option(item.title,item.dictionaryid));
                        $('#pPStatus').val(r.ppstatus);
                    });
                    form.render('select');

                },error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//专业技术职称下拉框
function selectpPTitle(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryquerypPTitle",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#pPTitle').append(new Option());
                    $.each(data, function (index, item) {
                        $('#pPTitle').append(new Option(item.title, item.dictionaryid));
                        $('#pPTitle').val(r.pptitle);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//出生城市下拉树
function cityTree() {
    layui.extend({
        dtree: '../../layui/layui_exts/layui_ext/dtree/dtree'
    }).use(['dtree', 'layer', 'jquery'], function () {
        var dtree = layui.dtree,
            layer = layui.layer,
            $ = layui.jquery;
        dtree.render({
            elem: "#cityTree",
            isJump: true,
            dataStyle: "layuiStyle",
            dataFormat: "list",
            response: {message: "msg", statusCode: 0},
            skin: "zdy",
            initLevel: 1,
            iconfont: ["dtreefont", "layui-icon", "iconfont"],
            iconfontStyle: [{
                snode: {
                    leaf: "dtree-icon-xiangmuxiaoxi",
                    node: {
                        open: "icon-appreciate"
                    }
                }
            }],
            url: "/dictionary/queryAll"
        });
        $("#smenu").on("click", function () {
            $(this).toggleClass("layui-form-selected");
            $("#smtest").toggleClass("layui-show layui-anim layui-anim-upbit");
        });

        dtree.on("node(cityTree)", function (obj) {
            $("#pBCity").val(obj.param.context);
            $("#smenu").toggleClass("layui-form-selected");
            $("#smtest").toggleClass("layui-show layui-anim layui-anim-upbit");
            $("#smId").val(obj.param.nodeId);
        });

    });
}
//现户籍城市下拉树
function nowCityTree() {
    layui.extend({
        dtree: '../../layui/layui_exts/layui_ext/dtree/dtree'
    }).use(['dtree', 'layer', 'jquery'], function () {
        var dtree = layui.dtree,
            layer = layui.layer,
            $ = layui.jquery;
        dtree.render({
            elem: "#nowCityTree",
            isJump: true,
            dataStyle: "layuiStyle",
            dataFormat: "list",
            response: {message: "msg", statusCode: 0},
            skin: "zdy",
            initLevel: 1,
            iconfont: ["dtreefont", "layui-icon", "iconfont"],
            iconfontStyle: [{
                snode: {
                    leaf: "dtree-icon-xiangmuxiaoxi",
                    node: {
                        open: "icon-appreciate"
                    }
                }
            }],
            url: "/dictionary/queryAll"
        });
        $("#spmenu").on("click", function () {
            $(this).toggleClass("layui-form-selected");
            $("#spmtest").toggleClass("layui-show layui-anim layui-anim-upbit");
        });

        dtree.on("node(nowCityTree)", function (obj) {
            $("#pChrCity").val(obj.param.context);
            $("#spmenu").toggleClass("layui-form-selected");
            $("#spmtest").toggleClass("layui-show layui-anim layui-anim-upbit");
            $("#spmId").val(obj.param.nodeId);
        });

    });
}
//学历信息下拉框
function selectDegree(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryDegree",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#education').append(new Option());
                    $.each(data,function (index,item) {
                        $('#education').append(new Option(item.title,item.dictionaryid));
                        $('#education').val(r.education);
                    });
                    form.render('select');

                },error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

