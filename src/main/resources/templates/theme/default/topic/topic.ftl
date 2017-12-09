<#include "../common/_layout.ftl"/>
<@html title=''>
    <#assign topic=onion.topic("${id!}")/>
  <article class="am-article">
      <div class="am-article-hd">
          <h1 class="am-article-title">${(topic.title)!}</h1>
          <p class="am-article-meta">
              ${(topic.user.nickname)!}（广东） ${(onion.formatData(topic.created))!}
              <#if sec.isOwner("${topic.user.id}")>
                <a class="am-btn am-btn-default am-btn-xs" href="/topic/edit/${topic.id}">编辑</a>
              </#if>
          </p>
      </div>

      <div class="am-article-bd">
          ${(topic.content)!}
      </div>
  </article>
<hr/>
<article class="am-comment"> <!-- 评论容器 -->
    <a href="">
        <img class="am-comment-avatar" src="/templates/theme/default/common/images/avatar.png" alt=""/> <!-- 评论者头像 -->
    </a>
    <div class="am-comment-main"> <!-- 评论内容容器 -->
        <header class="am-comment-hd">
            <!--<h3 class="am-comment-title">评论标题</h3>-->
            <div class="am-comment-meta"> <!-- 评论元数据 -->
                <a href="#link-to-user" class="am-comment-author">Beldon</a> <!-- 评论者 -->
                评论于
                <time datetime="">2017-12-12</time>
            </div>
        </header>
        <div class="am-comment-bd">
            Onion 听说是能吃的
        </div> <!-- 评论内容 -->
    </div>
</article>
<article class="am-comment"> <!-- 评论容器 -->
    <a href="">
        <img class="am-comment-avatar" src="/templates/theme/default/common/images/avatar.png" alt=""/> <!-- 评论者头像 -->
    </a>
    <div class="am-comment-main"> <!-- 评论内容容器 -->
        <header class="am-comment-hd">
            <!--<h3 class="am-comment-title">评论标题</h3>-->
            <div class="am-comment-meta"> <!-- 评论元数据 -->
                <a href="#link-to-user" class="am-comment-author">Beldon</a> <!-- 评论者 -->
                评论于
                <time datetime="">2017-12-12</time>
            </div>
        </header>
        <div class="am-comment-bd">
            Onion 听说是能吃的
        </div> <!-- 评论内容 -->
    </div>
</article>
</@html>