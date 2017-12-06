package cr.onion.web.security.remember;

import cr.onion.common.CommonConstant;
import cr.onion.entity.User;
import cr.onion.repo.UserAutoRepo;
import cr.onion.web.security.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Beldon
 * @create 2017-12-06 下午4:08
 */
@Service
public class RememberMeServiceImpl implements RememberMeService {

    private final String DEFAULT_REMEMBER_KEY = "remember-me";
    private final int DEFAULT_EXPIRY = 60 * 60 * 24 * 30;

    private String rememberKey = DEFAULT_REMEMBER_KEY;
    private int expiry = DEFAULT_EXPIRY;

    private final UserAutoRepo userAutoRepo;

    public RememberMeServiceImpl(UserAutoRepo userAutoRepo) {
        this.userAutoRepo = userAutoRepo;
    }


    @Override
    public Authentication autoLogin(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (rememberKey.equals(cookie.getName())) {
                    String userId = "";
                    User user = userAutoRepo.findOne(userId);
                    if (user != null) {
                        Authentication authentication = new Authentication(user, false, true);
                        return authentication;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void authenticated(HttpServletRequest request, HttpServletResponse response, User user) {
        Authentication authentication = new Authentication(user, false, true);
        request.getSession().setAttribute(CommonConstant.Session.AUTHENTICATION, authentication);
        //TODO 设置key
        String key = "";
        Cookie cookie = new Cookie(rememberKey, key);
        cookie.setMaxAge(expiry);
        response.addCookie(cookie);
    }
}
