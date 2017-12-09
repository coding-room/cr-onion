<#include "../common/_layout.ftl"/>
<#assign javascript>
<script src="/templates/admin/topic/js/categoryList.js"></script>
</#assign>
<@html title=''>
<div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
    <div class="widget am-cf">
        <div class="widget-head am-cf">
            <div class="widget-title am-fl">帖子分类</div>
        </div>
        <div class="widget-body  widget-body-lg am-fr">
            <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                <div class="am-form-group">
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <a href="/admin/topicCategory/add" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</a>
                        </div>
                    </div>
                </div>
            </div>

            <table width="100%"class="am-table am-table-compact am-table-bordered am-table-radius am-table-striped tpl-table-black" id="dataTable">
                <thead>
                    <tr>
                        <th>分类名称</th>
                        <th>排序</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody >

                </tbody>
            </table>

        </div>
    </div>
</div>
</div>

</@html>