$(function () {
    $("#saveTopic").click(function () {
        var topicCategory = $('#topicCategory').val();
        var topicTitle = $('#topicTitle').val();
        var topicContent = $('#topicContent').val();
        var data = {
            title: topicTitle,
            content: topicContent,
            categoryId: topicCategory
        };
        console.log(data);
        $.ajax({
            type: "POST",
            url: "/topic",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            dataType: "json",
            success: function (data) {
                if (data.code === 0) {
                    layer.confirm('添加成功', {
                        btn: ['确认'] //按钮
                    }, function () {
                        window.location.href = "/topic/" + data.data;
                    });
                } else {
                    layer.alert(data.msg, {icon: 5});
                }
            }
        });
    });
});