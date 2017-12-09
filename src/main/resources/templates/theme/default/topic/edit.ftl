<#include "../common/_layout.ftl"/>
<#assign javascript>
<script src="/templates/theme/default/topic/js/edit.js"></script>
</#assign>
<@html title=''>
    <#assign topic=onion.topic("${id!}")/>
<form class="am-form" action="javascript: return false;">
    <input type="hidden" value="${topic.id}" id="topicId">
    <fieldset>
        <legend>编辑话题</legend>
        <div class="am-form-group">
            <label for="doc-ipt-email-1">标题</label>
            <input type="text" class="" id="topicTitle" value="${topic.title}" placeholder="输入标题">
        </div>
        <div class="am-form-group">
            <label for="doc-select-1">分类</label>
            <select id="topicCategory">
                <@topic_category>
                <#list topicCategories as topicCategory>
                    <option value="${topicCategory.id}" <#if topic.category.id==topicCategory.id>selected</#if>>${topicCategory.name}</option>
                </#list>
                </@>
            </select>
            <span class="am-form-caret"></span>
        </div>

        <div class="am-form-group">
            <label for="doc-ta-1">内容</label>
            <textarea class="" rows="5" id="topicContent">${topic.content}</textarea>
        </div>

        <p><button id="saveTopic" class="am-btn am-btn-default">提交</button></p>
    </fieldset>
</form>
</@html>