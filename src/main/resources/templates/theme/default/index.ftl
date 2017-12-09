<#include "common/_layout.ftl"/>
<#include "common/_paginate.ftl"/>
<@html title=''>

<div data-am-widget="list_news" class="am-list-news am-list-news-default">
    <@topic_tag >
    <div class="am-list-news-bd">
        <ul class="am-list topic-list">
            <#list page.content as topic>
                   <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                       <div class="am-u-sm-2 am-u-md-1 am-list-thumb">
                           <a href="/u/${topic.user.account}" class="">
                               <img class="am-img-thumbnail am-circle" src="/templates/theme/default/common/images/avatar.png"/>
                           </a>
                       </div>
                       <div class=" am-u-sm-10 am-u-md-11 am-list-main">
                           <h3 class="am-list-item-hd"><a href="/topic/${topic.id}" class="">${topic.title}</a>
                           </h3>
                           <div class="am-list-item-text">
                               <a href="#">${topic.category.name}</a>•
                               <a href="/u/${topic.user.account}">${topic.user.nickname}</a>•
                               <a href="#">0个回复</a>•
                               <a href="#">28次浏览</a>•
                               <a href="#">${(onion.formatData(topic.created))!}</a>
                           </div>
                       </div>
                   </li>
            </#list>
        </ul>
    </div>
         <@paginate currentPage=page.number totalPage=page.totalPages actionUrl="/topic/p/{page}.html" />
    </@>
</div>
</@html>