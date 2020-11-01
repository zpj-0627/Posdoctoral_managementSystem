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

        $('#fSubject').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryFsubject",
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
                url: "/postdoctorrinformation/querydName",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#dName').append(new Option());
                    $.each(data, function (index, item) {
                        $('#dName').append(new Option(item.dname, item.did));

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
                url: "/postdoctorrinformation/queryNationality",
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
                url: "/dictionary/querySubjectCategory",
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
                url: "/dictionary/queryfSubject",
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
                url: "/dictionary/querystatus",
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



//字典目录树
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

//文献类型下拉框
function selectLiterature(){
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
                    $.each(data, function (index, item) {
                        $('#literature').append(new Option(item.title, item.id));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//收录情况下拉框
function selectCollection(){
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
                    $.each(data, function (index, item) {
                        $('#collection').append(new Option(item.title, item.id));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//专利权人下拉框
function PselectdName(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#patenter').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/patent/querytName",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#patenter').append(new Option());
                    $.each(data, function (index, item) {
                        $('#patenter').append(new Option(item.patenter, item.id));

                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//专利申请时间下拉框
function timeData1() {
    layui.use(['laydate','jquery'],function () {
        var
            $ = layui.$,
            laydate = layui.laydate;

        laydate.render({
            elem: '#dTime1',
            type: 'year',
            theme: 'molv',
            trigger: 'click',
            format: 'yyyy年'
        });

    });
}
//专利公开日下拉框
function timeData2() {
    layui.use(['laydate','jquery'],function () {
        var
            $ = layui.$,
            laydate = layui.laydate;

        laydate.render({
            elem: '#dTime2',
            type: 'year',
            theme: 'molv',
            trigger: 'click',
            format: 'yyyy年'
        });

    });
}
//专利类型下拉框
function TrselectdName(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#ptype').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPtype",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#ptype').append(new Option());
                    $.each(data, function (index, item) {
                        $('#ptype').append(new Option(item.title, item.id));

                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//论著方式下拉框
function TrselectTtype(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#treatiseType').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryTtype",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#treatiseType').append(new Option());
                    $.each(data, function (index, item) {
                        $('#treatiseType').append(new Option(item.title, item.id));

                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//专利名称下拉框
function selectPname(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#patentName').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/patent/querypName",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#patentName').append(new Option());
                    $.each(data, function (index, item) {
                        $('#patentName').append(new Option(item.patentName, item.id));

                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//获奖类型下拉框
function selectAtype(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#awardsType').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryAtype",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#awardsType').append(new Option());
                    $.each(data, function (index, item) {
                        $('#awardsType').append(new Option(item.title, item.id));

                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//成果评价下拉框
function selectAresults(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#resultsAssessment').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryAresults",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#resultsAssessment').append(new Option());
                    $.each(data, function (index, item) {
                        $('#resultsAssessment').append(new Option(item.title, item.id));

                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//成果类型下拉框
function selectType(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#type').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/awards/queryType",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#type').append(new Option());
                    $.each(data, function (index, item) {
                        $('#type').append(new Option(item.type, item.id));

                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//获奖类别下拉框
function selectCategories(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#awardsCategories').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/awards/queryCategories",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#awardsCategories').append(new Option());
                    $.each(data, function (index, item) {
                        $('#awardsCategories').append(new Option(item.awardsCategories, item.id));

                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//单位名称下拉框
function Aselectdname(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#dName').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/awards/querydname",
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
//下达部门下拉框
function selectdepartmentName(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#departmentName').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/postdoctoraproject/queryDepartment",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#departmentName').append(new Option());
                    $.each(data, function (index, item) {
                        $('#departmentName').append(new Option(item.departmentName, item.id));

                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//项目性质下拉框
function selectprojectNature(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#projectNature').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/postdoctoraproject/queryprojectNature",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#projectNature').append(new Option());
                    $.each(data, function (index, item) {
                        $('#projectNature').append(new Option(item.projectNature, item.id));

                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//单位名称添加联动显示单位代码
function dIdSelect() {
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;

        form.on('select(Type_filter)', function(o){
                id = o.value;
            alert(JSON.stringify(o));
            $.get('/gzz-information/getText/'+id,function (r) {
                $('[name=dId]').val(r.did);
                $('[name=dType]').val(r.dtype);
            },'json')
            $.get('/project_application/getprojectId',function (r) {
                $('[name=projectId]').val(r);
                alert(JSON.stringify(r));
            },'json')
        });
    });
}
//日常科研——项目申报部门名字下拉框
function selectdName1(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#dName').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/gzz-information/selectdNameInfo",
                dataType: "json",
                cache: false,
                success: function (data) {
                   /* alert(JSON.stringify(data));*/
                    $('#dName').append(new Option());
                    $.each(data, function (index, item) {
                        $('#dName').append(new Option(item.dname, item.dname));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//项目类别下拉框
function selectprojrctType(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#project_type').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryprojecttype",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#projectType').append(new Option());
                    $.each(data, function (index, item) {
                        $('#projectType').append(new Option(item.title, item.dictionaryid));
                        $('#projectType').val(r.projectType);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//民族下拉框
function selectCountry(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPCountry",
                dataType: "json",
                cache: false,
                success: function (data) {

                    $('#nationality').append(new Option());
                    $.each(data,function (index,item) {
                        $('#nationality').append(new Option(item.title,item.dictionaryid));
                    });
                    form.render('select');

                },error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//论著方式下拉框
function TrselectTtype1(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $('#treatiseType').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryTtype",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#treatiseType').append(new Option());
                    $.each(data, function (index, item) {
                        $('#treatiseType').append(new Option(item.title, item.dictionaryid));
                        $('#treatiseType').val(r.treatiseType)
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}