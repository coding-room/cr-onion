package cr.onion.web.security.remember;

import cr.onion.common.CommonConstant;
import cr.onion.entity.User;
import cr.onion.repo.UserAutoRepo;
import cr.onion.web.security.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Beldon
 */
@Service
public class DefaultRememberMeService extends BaseRememberMeService {

    private String key = "";

    private final UserAutoRepo userAutoRepo;

    public DefaultRememberMeService(UserAutoRepo userAutoRepo) {
        this.userAutoRepo = userAutoRepo;
    }


    @Override
    public Authentication autoLogin(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (getRememberKey().equals(cookie.getName())) {
                    String rememberCookie = cookie.getValue();
                    CookieTokens cookieTokens = decodeCookie(rememberCookie);
                    if (cookieTokens != null && isTokenExpired(cookieTokens.getTokenExpiryTime())) {
                        String account = cookieTokens.getAccount();
                        User user = userAutoRepo.findByAccount(account);
                        if (user != null) {
                            String signature = makeTokenSignature(cookieTokens.getTokenExpiryTime(), user);
                            if (signature.equals(cookieTokens.getSignature())) {
                                setCookie(user, response);
                                return new Authentication(user, true, false);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void loginSuccess(HttpServletRequest request, HttpServletResponse response, User user) {
        Authentication authentication = new Authentication(user, false, true);
        request.getSession().setAttribute(CommonConstant.Session.AUTHENTICATION, authentication);
        setCookie(user, response);
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        clearCookie(request, response);
    }

    @Override
    protected String makeTokenSignature(long expiryTime, User user) {
        String data = user.getAccount() + ":" + expiryTime + ":" + user.getPassword() + ":" + key;
        return DigestUtils.md5DigestAsHex(data.getBytes());
    }

    public DefaultRememberMeService setKey(String key) {
        this.key = key;
        return this;
    }


}
