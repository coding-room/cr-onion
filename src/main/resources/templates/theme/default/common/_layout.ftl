<#include "header.ftl"/>
<#include "footer.ftl"/>
<#include "../common/_paginate.ftl"/>
<#macro html title>
    <@header title = title/>
<div class="container">
    <#nested>
</div>
    <@footer/>
</#macro>