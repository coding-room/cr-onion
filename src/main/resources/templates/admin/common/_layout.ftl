<#include "header.ftl"/>
<#include "footer.ftl"/>
<#include "../common/_paginate.ftl"/>
<#macro html title>
    <@header title = title/>
    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <#nested>
    </div>
    <@footer/>
</#macro>