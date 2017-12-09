function  loadData() {
    $('#dataTable').find("tbody").html("");
    $.ajax({
        type: "GET",
        url: "/admin/topicCategory",
        dataType: "json",
        success: function (data) {
            console.log(data);
            if (data.code ===0 ) {
                var resData = data.data;
                $(resData).each(function (i, item) {
                    var tr = $('<tr></tr>');
                    tr.addClass("gradeX");
                    var name = $('<td></td>');
                    name.text(item.name);
                    var sort = $('<td></td>');
                    sort.text(item.sort);
                    var operateTd = $('<td></td>');
                    var operateDiv = $('<div class="tpl-table-black-operation"></div>');
                    var operateEdit = $('<a href="javascript:;"><i class="am-icon-pencil"></i> 编辑</a>');
                    operateEdit.attr("href", "/admin/topicCategory/edit/" + item.id);
                    var operateDelete = $('<a href="javascript:;" class="categoryDelete tpl-table-black-operation-del"><i class="am-icon-trash"></i> 删除</a>');
                    operateDelete.attr("id",item.id)
                    operateDiv.append(operateEdit);
                    operateDiv.append(operateDelete);
                    operateTd.append(operateDiv);
                    tr.append(name);
                    tr.append(sort);
                    tr.append(operateTd);
                    $('#dataTable').find("tbody").append(tr);
                })
            }
        }
    });
}
$(function () {
    loadData();
    $("#dataTable").on("click", ".categoryDelete", function () {
        var categoryId = $(this).attr("id");
        layer.confirm('您确定要删除该记录么？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $.ajax({
                type: "DELETE",
                url: "/admin/topicCategory/" + categoryId,
                dataType: "json",
                success: function (data) {
                    if (data.code === 0) {
                        layer.confirm('删除成功', {
                            btn: ['确认'] //按钮
                        }, function(){
                            window.location.href = "/admin/topicCategory/list";
                        });
                    } else {
                        layer.alert(data.msg, {icon: 5});
                    }
                }
            });
        }, function(){

        });
    });


});