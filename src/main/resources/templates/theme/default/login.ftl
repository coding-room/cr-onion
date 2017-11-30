<#include "common/_layout.ftl"/>
<@html title='${(parameterVariable.key("SYS_WEBSITE_NAME"))!}'>
     <form class="am-form am-form-horizontal">
         <div class="am-form-group">
             <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">账号</label>
             <div class="am-u-sm-10">
                 <input type="email" id="doc-ipt-3" placeholder="账号">
             </div>
         </div>

         <div class="am-form-group">
             <label for="doc-ipt-pwd-2" class="am-u-sm-2 am-form-label">密码</label>
             <div class="am-u-sm-10">
                 <input type="password" id="doc-ipt-pwd-2" placeholder="密码">
             </div>
         </div>

         <div class="am-form-group">
             <div class="am-u-sm-offset-2 am-u-sm-10">
                 <div class="checkbox">
                     <label>
                         <input type="checkbox"> 记住十万年
                     </label>
                 </div>
             </div>
         </div>
         <div class="am-form-group">
             <div class="am-u-sm-10 am-u-sm-offset-2">
                 <button type="submit" class="am-btn am-btn-default">登入呗</button>
             </div>
         </div>
     </form>
</@html>