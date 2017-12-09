<#include "../common/_layout.ftl"/>
<#assign javascript>
<script type="text/javascript">
    $(function () {
        $("#saveCategory").click(function () {
            var categoryName = $('#categoryName').val();
            var categorySort = $('#categorySort').val();
            var data = {
                name: categoryName,
                sort: categorySort
            };
            console.log(data);
            $.ajax({
                type: "POST",
                url: "/admin/topicCategory",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data),
                dataType: "json",
                success: function (data) {
                    if (data.code === 0) {
                        layer.confirm('添加成功', {
                            btn: ['确认'] //按钮
                        }, function(){
                            window.location.href = "/admin/topicCategory/list";
                        });
                    } else {
                        layer.alert(data.msg, {icon: 5});
                    }
                }
            });
        });
    });
</script>
</#assign>
<@html title=''>
    <div class="row-content am-cf">
       <div class="row">
          <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">添加分类</div>
                        </div>
                        <div class="widget-body am-fr">
                            <form class="am-form tpl-form-line-form">
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">名称</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="categoryName" placeholder="请输入分类名称">
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">排序</label>
                                    <div class="am-u-sm-9">
                                        <input type="number" class="tpl-form-input" id="categorySort" placeholder="请输入排序">
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button type="button" id="saveCategory" class="am-btn am-btn-primary tpl-btn-bg-color-success ">提交</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
       </div>
    </div>
</@html>