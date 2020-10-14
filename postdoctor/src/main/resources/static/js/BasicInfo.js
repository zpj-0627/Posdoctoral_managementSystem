//民族下拉框
function selectNational(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "dictionary/queryNational",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#National').append(new Option());
                    $.each(data, function (index, item) {
                        $('#National').append(new Option(item.title, item.id));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//婚姻下拉框
function selectmarriage(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "dictionary/queryNational",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#Marriage').append(new Option());
                    $.each(data, function (index, item) {
                        $('#Marriage').append(new Option(item.title, item.id));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//专业技术职称下拉框
function selectPositionaltitles(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "dictionary/queryPositionaltitles",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#Positionaltitles').append(new Option());
                    $.each(data, function (index, item) {
                        $('#Positionaltitles').append(new Option(item.title, item.id));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}

//出生省份下拉框
function selectBProvince(){
    layui.use(['form','jquery'],function () {
        var $ = layui.$,
            form = layui.form;
        $(function () {
            $.ajax({
                type: "POST",
                url: "dictionary/queryPositionaltitles",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $('#Positionaltitles').append(new Option());
                    $.each(data, function (index, item) {
                        $('#Positionaltitles').append(new Option(item.title, item.id));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    });
}



