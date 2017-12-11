package cr.onion.web.controller.vo;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Beldon.
 */
public class LoginVO {
    @NotEmpty(message = "账号不能为空")
    private String account;
    @NotEmpty(message = "密码不能为空")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
