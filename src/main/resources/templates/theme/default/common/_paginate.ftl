<#macro paginate currentPage totalPage actionUrl>
<#local currentPage = currentPage + 1>
<#if (totalPage>1)>
	<#if (totalPage <= 0) || (currentPage > totalPage)><#return></#if>
	<#local startPage = currentPage - 2>
	<#if (startPage < 1)><#local startPage = 1></#if>

	<#local endPage = currentPage + 2>
	<#if (endPage > totalPage)><#local endPage = totalPage></#if>

    <ul class="am-pagination am-pagination-centered">
		<#if (currentPage <= 3)>
			<#local startPage = 1>
		</#if>
		<#if ((totalPage - currentPage) < 2)>
			<#local endPage = totalPage>
		</#if>
		<#if (currentPage == 1)>
		   	<li class="am-disabled"><a href="#">首页</a></li>
        	<li class="am-disabled"><a href="#">上一页</a></li>
		<#else>
            <li><a href="${actionUrl?replace('\{page}','1')}">首页</a></li>
        	<li><a href="${actionUrl?replace('\{page}','#{currentPage-1}')}">上一页</a></li>
		</#if>
		<#list startPage..endPage as i>
			<#if currentPage == i>
			 	<li class="am-active"><a href="#">#{i}</a></li>
			<#else>
                <li><a href="${actionUrl?replace('\{page}','#{i}')}">#{i}</a></li>
			</#if>
		</#list>
		<#if (currentPage == totalPage)>
			<li class="am-disabled"><a href="#">尾页</a></li>
        	<li class="am-disabled"><a href="#">下一页</a></li>
		<#else>
			<li><a href="${actionUrl?replace('\{page}','#{currentPage + 1}')}" class="laypage-next">下一页</a></li>
			<li><a href="${actionUrl?replace('\{page}','#{totalPage}')}" class="laypage-last" title="尾页">尾页</a></li>
		</#if>
    </ul>
</#if>
</#macro>