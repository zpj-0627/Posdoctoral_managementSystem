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

//项目申请——部门名字下拉框
function selectdName2(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/postdoctorrinformation/querydName",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#dname').append(new Option());
                    $.each(data, function (index, item) {
                        $('#dname').append(new Option(item.dname, item.dictionaryid));
                        $('#dname').val(r.dname);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//文献类型下拉框
function selectliterature(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#literature').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryLiterature",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#literature').append(new Option());
                    $.each(data,function (index,item) {
                        $('#literature').append(new Option(item.title,item.dictionaryid));
                        $('#literature').val(r.literature);
                    });
                    form.render('select');

                },error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}


//论文收录情况下拉框
function selectcollection(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#collection').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryCollection",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#collection').append(new Option());
                    $.each(data,function (index,item) {
                        $('#collection').append(new Option(item.title,item.dictionaryid));
                        $('#collection').val(r.collection);
                    });
                    form.render('select');

                },error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//文献类型下拉框
function selectliterature1(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#literature').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryLiterature",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#literature').append(new Option());
                    $.each(data,function (index,item) {
                        $('#literature').append(new Option(item.title,item.dictionaryid));

                    });
                    form.render('select');

                },error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}


//论文收录情况下拉框
function selectcollection1() {
    layui.use(['form', 'jquery'], function () {
        var $ = layui.$,
            form = layui.form;
        $('#collection').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryCollection",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#collection').append(new Option());
                    $.each(data, function (index, item) {
                        $('#collection').append(new Option(item.title, item.dictionaryid));

                    });
                    form.render('select');

                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

/*//单位名称添加联动显示单位代码
function dIdSelect() {
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;

        form.on('select(Type_filter)', function(o){
            id = o.value;
            $.get('/gzz-information/getText/'+id,function (r) {
                $('[name=dId]').val(r.did);
                $('[name=dType]').val(r.dtype);
            },'json')
            $.get('/project_application/getprojectId',function (r) {
                $('[name=projectId]').val(r);
            },'json')
        });
    });
}*/
//基金情况——基金名称下拉框
function selectfundName(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryfundName",
                dataType: "json",
                cache: false,
                success: function (data) {
                    alert(JSON.stringify(data))
                    $('#fundName').append(new Option());
                    $.each(data, function (index, item) {
                        $('#fundName').append(new Option(item.title, item.dictionaryid));
                        $('#fundName').val(r.fundName);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });
        form.on('select(Type_filter)', function(o){
            id = o.value;
            alert(JSON.stringify(id))
            $.get('/gzz-information/getText/'+id,function (r) {
                $('[name=dId]').val(r.did);
                $('[name=dType]').val(r.dtype);
            },'json')
            $.get('/project_application/getprojectId',function (r) {
                $('[name=projectId]').val(r);
            },'json')
        });

    });
}
//基金情况——基金名称下拉框
function selectfundName1() {
    layui.use(['form', 'jquery'], function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryfundName",
                dataType: "json",
                cache: false,
                success: function (data) {
                    alert(JSON.stringify(data))
                    $('#fundName').append(new Option());
                    $.each(data, function (index, item) {
                        $('#fundName').append(new Option(item.title, item.dictionaryid));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });
        form.on('select(Type_filter)', function (o) {
            id = o.value;
            $.ajax({
                url: '/dictionary/queryfundGrade',
                data: {
                    id: id,
                },
                type: 'post',
                dataType: 'json',
                success: function (data) {
                    $('#fundGrade').append(new Option());
                    $.each(data, function (index, item) {
                        $('#fundGrade').append(new Option(item.title, item.id));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });

        });
    })
}