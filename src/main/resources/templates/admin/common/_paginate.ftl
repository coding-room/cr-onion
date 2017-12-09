<#macro paginate currentPage totalPage actionUrl>
<#if (totalPage>1)>
	<#if (totalPage <= 0) || (currentPage > totalPage)><#return></#if>
	<#local startPage = currentPage - 2>
	<#if (startPage < 1)><#local startPage = 1></#if>

	<#local endPage = currentPage + 2>
	<#if (endPage > totalPage)><#local endPage = totalPage></#if>

<div style="text-align: center">
    <div class="laypage-main">
		<#if (currentPage <= 3)>
			<#local startPage = 1>
		</#if>
		<#if ((totalPage - currentPage) < 2)>
			<#local endPage = totalPage>
		</#if>

		<#if (currentPage == 1)>
			<!--<li>上页</li>-->
		<#else>
            <a href="${actionUrl?replace('\{page}','1')}" class="" title="首页">首页</a>
            <a href="${actionUrl?replace('\{page}','1')}" class="laypage-prev">上一页</a>
		</#if>

		<#list startPage..endPage as i>
			<#if currentPage == i>
                <span class="laypage-curr">#{i}</span>
			<#else>
                <a href="${actionUrl?replace('\{page}','#{i}')}">#{i}</a>
			</#if>
		</#list>

		<#if (currentPage == totalPage)>
			<!--<li>下页</li>-->
		<#else>
            <a href="${actionUrl?replace('\{page}','#{currentPage + 1}')}" class="laypage-next">下一页</a>
            <a href="${actionUrl?replace('\{page}','#{totalPage}')}" class="laypage-last" title="尾页">尾页</a>
		</#if>
    </div>
</div>
</#if>
</#macro>