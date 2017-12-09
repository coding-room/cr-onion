$(function () {
    $("#saveTopic").click(function () {
        var topicId = $('#topicId').val();
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
            type: "PUT",
            url: "/topic/" + topicId,
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            dataType: "json",
            success: function (data) {
                if (data.code === 0) {
                    layer.confirm('更新成功', {
                        btn: ['确认'] //按钮
                    }, function () {
                        window.location.href = "/topic/" + topicId;
                    });
                } else {
                    layer.alert(data.msg, {icon: 5});
                }
            }
        });
    });
});