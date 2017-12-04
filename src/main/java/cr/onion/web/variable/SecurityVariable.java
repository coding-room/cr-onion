package cr.onion.web.variable;


import cr.onion.common.BaseVariable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
        return StringUtils.hasText(currentUserId());
    }

}
