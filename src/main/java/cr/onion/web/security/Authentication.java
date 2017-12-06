package cr.onion.web.security;

import cr.onion.entity.User;

/**
 * @author Beldon
 */
public class Authentication {

    private final boolean rememberMe;
    private final boolean authenticated;
    private final User user;

    public Authentication(User user, boolean rememberMe, boolean authenticated) {
        this.rememberMe = rememberMe;
        this.authenticated = authenticated;
        this.user = user;
    }


    /**
     * 判断是不是记住登录
     *
     * @return
     */
    public boolean isRememberMe() {
        return rememberMe;
    }

    /**
     * 判断是否是用户密码登录的
     *
     * @return
     */
    public boolean isAuthenticated() {
        return authenticated;
    }


    /**
     * 用户信息
     *
     * @return
     */
    public User user() {
        return user;
    }
}
