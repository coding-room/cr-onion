package cr.onion.config;

import cr.onion.config.onion.RememberMeConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Beldon
 */
@ConfigurationProperties(prefix = "onion")
public class OnionConfig {
    private boolean dev = false;


    private RememberMeConfig rememberMe;


    public void setDev(boolean dev) {
        this.dev = dev;
    }

    public boolean isDev() {
        return dev;
    }

    public RememberMeConfig getRememberMe() {
        if (rememberMe == null) {
            rememberMe = new RememberMeConfig();
        }
        return rememberMe;
    }

    public void setRememberMe(RememberMeConfig rememberMe) {
        this.rememberMe = rememberMe;
    }
}
