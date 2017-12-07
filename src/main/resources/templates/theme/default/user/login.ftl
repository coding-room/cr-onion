<#include "../common/_layout.ftl"/>
<#assign javascript>
<script type="text/javascript">
    $(function () {
        $("#login").click(function () {
            var account = $('#account').val();
            var password = $('#password').val();
            var rePassword = $('#rePassword').val();
            var data = {
                account: account,
                password: password
            };
            console.log(data);
            $.ajax({
                type: "POST",
                url: "/user/login",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data),
                dataType: "json",
                success: function (data) {
                    if (data.code === 0) {
                        alert("登录成功");
                        window.location.href = "/";
                    } else {
                        alert(data.msg)
                    }
                },
                error: function (data) {
                    alert("注册失败！");
                }
            });
        });
    });
</script>
</#assign>
<@html title='${(parameterVariable.key("SYS_WEBSITE_NAME"))!}'>
     <form class="am-form am-form-horizontal">
         <div class="am-form-group">
             <label for="account" class="am-u-sm-2 am-form-label">账号</label>
             <div class="am-u-sm-10">
                 <input type="text" id="account" placeholder="账号">
             </div>
         </div>

         <div class="am-form-group">
             <label for="doc-ipt-pwd-2" class="am-u-sm-2 am-form-label">密码</label>
             <div class="am-u-sm-10">
                 <input type="password" id="password" placeholder="密码">
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
                 <button type="button" id="login" class="am-btn am-btn-default">登入呗</button>
             </div>
         </div>
     </form>
</@html>