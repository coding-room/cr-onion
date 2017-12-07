package cr.onion.web.security.remember;

import cr.onion.entity.User;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

/**
 * @author Beldon
 */
public abstract class BaseRememberMeService implements RememberMeService {
    private static final String DELIMITER = ":";

    private String rememberKey = DEFAULT_REMEMBER_KEY;
    private int expiry = DEFAULT_EXPIRY;

    public BaseRememberMeService() {

    }

    public BaseRememberMeService(String rememberKey, int expiry) {
        this.rememberKey = rememberKey;
        this.expiry = expiry;
    }


    protected boolean isTokenExpired(long tokenExpiryTime) {
        return tokenExpiryTime < System.currentTimeMillis();
    }

    protected CookieTokens decodeCookie(String cookieValue) {
        String cookies = new String(Base64.getDecoder().decode(cookieValue));
        String[] cookiesArr = cookies.split(DELIMITER);
        String[] tokens = StringUtils.delimitedListToStringArray(cookies, DELIMITER);
        if (cookiesArr.length >= 3) {
            return new CookieTokens(Long.valueOf(tokens[0]), tokens[1], tokens[2]);
        }
        return null;
    }

    protected String encodeCookie(long expiryTime, String account, String signature) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(expiryTime);
        stringBuilder.append(DELIMITER);
        stringBuilder.append(account);
        stringBuilder.append(DELIMITER);
        stringBuilder.append(signature);
        String value = stringBuilder.toString();
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    protected void setCookie(User user, HttpServletResponse response) {
        long expiryTime = calculateLoginLifetime();
        String signature = makeTokenSignature(expiryTime, user);
        String encodeCookie = encodeCookie(expiryTime, user.getAccount(), signature);

        Cookie cookie = new Cookie(rememberKey, encodeCookie);
        cookie.setMaxAge(getExpiry());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public void clearCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (rememberKey.equals(cookie.getName())) {
                cookie.setMaxAge(0);
                cookie.setValue("");
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
    }

    protected long calculateLoginLifetime() {
        return System.currentTimeMillis() + expiry * 1000;
    }

    protected abstract String makeTokenSignature(long expiryTime, User user);

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public String getRememberKey() {
        return rememberKey;
    }

    public void setRememberKey(String rememberKey) {
        this.rememberKey = rememberKey;
    }

    protected static class CookieTokens {
        private long tokenExpiryTime;
        private String account;
        private String signature;

        public CookieTokens(long tokenExpiryTime, String account, String signature) {
            this.tokenExpiryTime = tokenExpiryTime;
            this.account = account;
            this.signature = signature;
        }

        public long getTokenExpiryTime() {
            return tokenExpiryTime;
        }

        public void setTokenExpiryTime(long tokenExpiryTime) {
            this.tokenExpiryTime = tokenExpiryTime;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }
    }
}
