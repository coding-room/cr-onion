package cr.onion.web.variable;


import cr.onion.common.BaseVariable;
import cr.onion.web.security.Authentication;
import cr.onion.web.security.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Beldon.
 */

@Component
public class SecurityVariable extends BaseVariable {

    @Override
    protected String getName() {
        return "sec";
    }


    /**
     * 表示当前用户是否已经登录认证成功了。
     *
     * @return
     */
    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getAuthentication();
        return authentication != null && authentication.isAuthenticated();
    }

    /**
     * 判断用户是否登录
     *
     * @return
     */
    public boolean isLogin() {
        return SecurityContextHolder.getAuthentication() != null;
    }

}
