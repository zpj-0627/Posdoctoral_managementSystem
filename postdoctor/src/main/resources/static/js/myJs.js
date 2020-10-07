//所属部门下拉框
function departmentSelect(){
    layui.use(['form','jquery'],function () {
    var $ = layui.$,
        form = layui.form;
    $('#department').empty();
    $(function () {
        $.ajax({
            type: "POST",
            url: "/dictionary/queryDepartment",
            dataType: "json",
            cache: false,
            success: function (data) {
                $('#department').append(new Option());
                $.each(data, function (index, item) {
                        $('#department').append(new Option(item.title, item.id));

                });
                form.render('select');
            }, error: function () {
                alert("查询失败");
            }
        });
    });

});
}

//一级学科下拉框
function f_subject(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;

        $('#department').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryFsubject",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#fsubject').append(new Option());
                    $.each(data, function (index, item) {
                        $('#fsubject').append(new Option(item.title, item.id));

                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//高校名称添加联动显示高校代码
function siIdSelect() {
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;

        form.on('select(Type_filter)', function(o){
            id = o.value;
            $.get('/schoolinformation/getText/'+id,function (r) {
                $('[name=siId]').val(r.siId);
            },'json')
        });
    });
    }

//高校名称修改联动显示高校代码
function siIdSelectEdit() {
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;

        form.on('select(Type_filter)', function(o){
            $('[name=siId]').val(o.value);
        });
    });
}

//人员管理——部门名字下拉框
function selectdName(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#dName').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "postdoctorrinformation/querydName",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#dName').append(new Option());
                    $.each(data, function (index, item) {
                        $('#dName').append(new Option(item.dname, item.id));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//人员管理——国籍下拉框
function selectpNationality(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#pNationality').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "postdoctorrinformation/queryNationality",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#pNationality').append(new Option());
                    $.each(data, function (index, item) {
                        $('#pNationality').append(new Option(item.pnationality, item.id));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//人员管理——学科门类下拉框
function selectsubjectCategory(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#subjectCategory').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "dictionary/querySubjectCategory",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#subjectCategory').append(new Option());
                    $.each(data, function (index, item) {
                        $('#subjectCategory').append(new Option(item.title, item.id));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//人员管理——一级学科下拉框
function selectpfSubject(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#fSubject').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "dictionary/queryfSubject",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#fSubject').append(new Option());
                    $.each(data, function (index, item) {
                        $('#fSubject').append(new Option(item.title, item.id));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//人员管理——在站状态下拉框
function selectstatus(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#status').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "dictionary/querystatus",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#status').append(new Option());
                    $.each(data, function (index, item) {
                        $('#status').append(new Option(item.title, item.id));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}



//学科平台目录树
function spmTree() {
    layui.extend({
        dtree: 'layui/layui_exts/layui_ext/dtree/dtree'
    }).use(['dtree', 'layer', 'jquery'], function () {
        var dtree = layui.dtree,
            layer = layui.layer,
            $ = layui.jquery;

        //学科平台下拉树
        dtree.render({
            elem: "#spmTree",
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

        dtree.on("node(spmTree)", function (obj) {
            $("#input_spm").val(obj.param.context);
            $("#spmenu").toggleClass("layui-form-selected");
            $("#spmtest").toggleClass("layui-show layui-anim layui-anim-upbit");
            $("#spmTree").val(obj.param.nodeId);
        });
    });
}

//学科目录树
function smTree() {
    layui.extend({
        dtree: '../layui/layui_exts/layui_ext/dtree/dtree'
    }).use(['dtree', 'layer', 'jquery'], function () {
        var dtree = layui.dtree,
            layer = layui.layer,
            $ = layui.jquery;
        dtree.render({
            elem: "#smTree",
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

        dtree.on("node(smTree)", function (obj) {
            $("#input_sm").val(obj.param.context);
            $("#smenu").toggleClass("layui-form-selected");
            $("#smtest").toggleClass("layui-show layui-anim layui-anim-upbit");
            $("#smId").val(obj.param.nodeId);
        });

    });
}

//年选择器
function timeData() {
    layui.use(['laydate','jquery'],function () {
        var
            $ = layui.$,
            laydate = layui.laydate;

        laydate.render({
            elem: '#dTime',
            type: 'year',
            theme: 'molv',
            trigger: 'click',
            format: 'yyyy年'
        });

    });
}

//年范围选择器
function yearData() {
    layui.use(['laydate','jquery'],function () {
        var
            $ = layui.$,
            laydate = layui.laydate;
            laydate.render({
            elem: '#trDate',
            type: 'year',
            range: true,
            theme: 'molv',
            trigger: 'click',
            format: 'yyyy年',
        });

    });
}