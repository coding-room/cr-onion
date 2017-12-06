package cr.onion.web.controller.mo;

import java.util.Date;

/**
 * @author Beldon
 * @create 2017-12-06 下午3:14
 */
public class UserMO {
    /**
     * 账号
     */
    private String account;
    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别，男|女
     */
    private String gender;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 签名
     */
    private String sign;
    /**
     * 创建时间
     */
    private Date created;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
