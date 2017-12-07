package cr.onion.config.onion;

import cr.onion.web.security.remember.RememberMeService;

/**
 * @author Beldon
 * @create 2017-12-07 上午10:20
 */
public class RememberMeConfig {
    /**
     * 传统set cookie模式，还有persistent模式
     */
    public static final String DEFAULT_TYPE = "tradition";
    public static final String PERSISTENT_TYPE = "persistent";
    private String rememberKey = RememberMeService.DEFAULT_REMEMBER_KEY;
    private int expiry = RememberMeService.DEFAULT_EXPIRY;
    private String type = PERSISTENT_TYPE;

    public void setRememberKey(String rememberKey) {
        this.rememberKey = rememberKey;
    }

    public String getRememberKey() {
        return rememberKey;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
