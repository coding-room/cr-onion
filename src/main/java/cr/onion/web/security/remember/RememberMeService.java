package cr.onion.web.security.remember;


import cr.onion.entity.User;
import cr.onion.web.security.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Beldon
 */
public interface RememberMeService {

    /**
     * 记住登录默认cookie名称
     */
    String DEFAULT_REMEMBER_KEY = "remember-me";

    /**
     * 默认过期时间，两个星期
     */
    int DEFAULT_EXPIRY = 60 * 60 * 24 * 14;

    /**
     * 自动登录
     *
     * @param request
     * @param response
     * @return
     */
    Authentication autoLogin(HttpServletRequest request, HttpServletResponse response);

    /**
     * 密码登录设置cookie
     *
     * @param request
     * @param user
     */
    void loginSuccess(HttpServletRequest request, HttpServletResponse response, User user);


    /**
     * 退出登录
     *
     * @param request
     * @param response
     */
    void logout(HttpServletRequest request, HttpServletResponse response);
}
