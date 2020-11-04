//统计——统计范围下拉框
function selectrange() {
    layui.use(['form', 'jquery'], function () {
        var $ = layui.$,
            form = layui.form;
        $('#range').empty();
        $(function () {
            $.ajax({
                type: "POST",
                url: "/gzz-information/selectdNameInfo",
                dataType: "json",
                cache: false,
                success: function (data) {
                    /* alert(JSON.stringify(data));*/
                    $('#range').append(new Option());
                    $.each(data, function (index, item) {
                        $('#range').append(new Option(item.dname, item.did));
                    });
                    form.render('select');
                }, error: function () {
                    alert("查询失败");
                }
            });
        });

    })
}
