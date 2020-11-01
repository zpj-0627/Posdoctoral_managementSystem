//博士学位一级学科下拉框
function selectPostfsub(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPostfsub",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#dSmName1').append(new Option());
                    $.each(data, function (index, item) {
                        $('#dSmName1').append(new Option(item.title, item.dictionaryid));
                        $('#dSmName1').val(r.dsmName1);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//博士学位二级学科下拉框
function selectPostssub(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPostssub",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#dSmName2').append(new Option());
                    $.each(data, function (index, item) {
                        $('#dSmName2').append(new Option(item.title, item.dictionaryid));
                        $('#dSmName2').val(r.dsmName2);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//读博国别下拉框
function selectPCountry(r){
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
                    $('#dDegreeNationality').append(new Option());
                    $.each(data, function (index, item) {
                        $('#dDegreeNationality').append(new Option(item.title, item.dictionaryid));
                        $('#dDegreeNationality').val(r.ddegreeNationality);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//是否留学回国国别下拉框
function selectSCountry(r){
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
                    $('#saNationality').append(new Option());
                    $.each(data, function (index, item) {
                        $('#saNationality').append(new Option(item.title, item.dictionaryid));
                        $('#saNationality').val(r.saNationality);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//科研项目下达部门下拉框
function selectPDept(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPDept",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#departmentName').append(new Option());
                    $.each(data, function (index, item) {
                        $('#departmentName').append(new Option(item.title, item.dictionaryid));
                        $('#departmentName').val(r.departmentName);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//科研项目性质下拉框
function selectPprojectNature(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPprojectNature",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#projectNature').append(new Option());
                    $.each(data, function (index, item) {
                        $('#projectNature').append(new Option(item.title, item.dictionaryid));
                        $('#projectNature').val(r.projectNature);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//科研项目进展下拉框
function selectPprojectProgress(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPprojectProgress",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#projectProgress').append(new Option());
                    $.each(data, function (index, item) {
                        $('#projectProgress').append(new Option(item.title, item.dictionaryid));
                        $('#projectProgress').val(r.projectProgress);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//科研项目承担责任下拉框
function selectPduty(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPduty",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#duty').append(new Option());
                    $.each(data, function (index, item) {
                        $('#duty').append(new Option(item.title, item.dictionaryid));
                        $('#duty').val(r.duty);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//专利类型下拉框
function selectPtype(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPtype",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#ptype').append(new Option());
                    $.each(data, function (index, item) {
                        $('#ptype').append(new Option(item.title, item.dictionaryid));
                        $('#ptype').val(r.ptype);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//排名下拉框
function selectRank(r){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/patent/queryRank",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#rank').append(new Option());
                    $.each(data, function (index, item) {
                        $('#rank').append(new Option(item.rank, item.id));
                        $('#rank').val(r.rank);
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//科研项目下达部门下拉框
function selectPDept1(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPDept",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#departmentName').append(new Option());
                    $.each(data, function (index, item) {
                        $('#departmentName').append(new Option(item.title, item.dictionaryid));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//科研项目性质下拉框
function selectPprojectNature1(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPprojectNature",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#projectNature').append(new Option());
                    $.each(data, function (index, item) {
                        $('#projectNature').append(new Option(item.title, item.dictionaryid));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//科研项目进展下拉框
function selectPprojectProgress1(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPprojectProgress",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#projectProgress').append(new Option());
                    $.each(data, function (index, item) {
                        $('#projectProgress').append(new Option(item.title, item.dictionaryid));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//科研项目承担责任下拉框
function selectPduty1(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPduty",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#duty').append(new Option());
                    $.each(data, function (index, item) {
                        $('#duty').append(new Option(item.title, item.dictionaryid));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//专利类型下拉框
function selectPtype1(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/dictionary/queryPtype",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#ptype').append(new Option());
                    $.each(data, function (index, item) {
                        $('#ptype').append(new Option(item.title, item.dictionaryid));

                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}
//排名下拉框
function selectRank1(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "/patent/queryRank",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#rank').append(new Option());
                    $.each(data, function (index, item) {
                        $('#rank').append(new Option(item.rank, item.id));

                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}