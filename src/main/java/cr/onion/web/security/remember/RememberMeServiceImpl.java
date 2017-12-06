package cr.onion.web.security.remember;

import cr.onion.entity.User;
import cr.onion.web.security.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Beldon
 * @create 2017-12-06 下午4:08
 */
@Service
public class RememberMeServiceImpl implements RememberMeService{
    @Override
    public Authentication autoLogin(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public void setCookie(HttpServletRequest request, User user) {

    }
}
