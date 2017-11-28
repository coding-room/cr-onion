package cr.onion.web.controller.mo;

import org.hibernate.validator.constraints.Length;

/**
 * @author Beldon.
 */
public class RegisterMO {
    @Length(min = 5, message = "账号必须大于五位")
    private String account;
    @Length(min = 6, max = 16, message = "密码长度6~16之间")
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
