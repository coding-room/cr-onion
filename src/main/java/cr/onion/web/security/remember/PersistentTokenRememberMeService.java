package cr.onion.web.security.remember;

import cr.onion.common.CommonConstant;
import cr.onion.entity.RememberMeToken;
import cr.onion.entity.User;
import cr.onion.repo.RememberMeTokenRepo;
import cr.onion.repo.UserAutoRepo;
import cr.onion.web.security.Authentication;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Beldon
 */
public class PersistentTokenRememberMeService extends BaseRememberMeService {
    private int size = 2;

    private final RememberMeTokenRepo rememberMeTokenRepo;

    private final UserAutoRepo userAutoRepo;

    public PersistentTokenRememberMeService(RememberMeTokenRepo rememberMeTokenRepo, UserAutoRepo userAutoRepo) {
        this.rememberMeTokenRepo = rememberMeTokenRepo;
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
                    if (cookieTokens != null && !isTokenExpired(cookieTokens.getTokenExpiryTime())) {
                        String account = cookieTokens.getAccount();
                        RememberMeToken rememberMeToken = rememberMeTokenRepo.findByAccountAndTokenValue(account, cookieTokens.getSignature());
                        if (rememberMeToken != null) {
                            User user = userAutoRepo.findByAccount(account);
                            if (user != null) {
                                rememberMeToken.setTokenValue(makeTokenSignature(calculateLoginLifetime(), user));
                                rememberMeToken.setUpdated(new Date());
                                rememberMeTokenRepo.save(rememberMeToken);
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
        List<RememberMeToken> rememberMeTokens = rememberMeTokenRepo.findAllByAccountOrderByCreated(user.getAccount());
        if (rememberMeTokens.size() >= size) {
            int end = rememberMeTokens.size() - size + 1;
            for (int i = 0; i < end; i++) {
                rememberMeTokenRepo.delete(rememberMeTokens.get(i));
            }
        }
        String uuid = UUID.randomUUID().toString();
        RememberMeToken rememberMeToken = new RememberMeToken();
        rememberMeToken.setCreated(new Date());
        rememberMeToken.setAccount(user.getAccount());
        rememberMeToken.setTokenValue(uuid);
        rememberMeTokenRepo.save(rememberMeToken);
        return uuid;
    }
}
