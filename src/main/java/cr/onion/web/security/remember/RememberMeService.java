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
    void authenticated(HttpServletRequest request, HttpServletResponse response, User user);
}
