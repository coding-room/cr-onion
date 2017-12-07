<#include "../common/_layout.ftl"/>

<#assign javascript>
<script type="text/javascript">
    $(function () {
        $("#reg").click(function () {
            var account = $('#account').val();
            var password = $('#password').val();
            var rePassword = $('#rePassword').val();
            if (password !== rePassword) {
                alert("两次输入密码不相同")
                return;
            }
            var data = {
                account: account,
                password: password
            };
            console.log(data);
            $.ajax({
                type: "POST",
                url: "/user/register",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data),
                dataType: "json",
                success: function (data) {
                    if (data.code === 0) {
                        alert("注册成功");
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

<@html title=''>
      <form class="am-form am-form-horizontal" id="regForm">
          <div class="am-form-group">
              <label for="account" class="am-u-sm-2 am-form-label">账号</label>
              <div class="am-u-sm-10">
                  <input type="text" id="account" name="account" placeholder="账号">
              </div>
          </div>

          <div class="am-form-group">
              <label for="password" class="am-u-sm-2 am-form-label">密码</label>
              <div class="am-u-sm-10">
                  <input type="password" id="password" name="password" placeholder="密码">
              </div>
          </div>

          <div class="am-form-group">
              <label for="rePassword" class="am-u-sm-2 am-form-label">确认密码</label>
              <div class="am-u-sm-10">
                  <input type="password" id="rePassword" placeholder="确认密码">
              </div>
          </div>

          <div class="am-form-group">
              <div class="am-u-sm-10 am-u-sm-offset-2">
                  <button type="button" id="reg" class="am-btn am-btn-default">注册</button>
              </div>
          </div>
      </form>
</@html>