package cr.onion.config;

import cr.onion.config.onion.RememberMeConfig;
import cr.onion.repo.RememberMeTokenRepo;
import cr.onion.repo.UserAutoRepo;
import cr.onion.web.security.SecurityFilter;
import cr.onion.web.security.remember.PersistentTokenRememberMeService;
import cr.onion.web.security.remember.RememberMeAuthenticationFilter;
import cr.onion.web.security.remember.RememberMeService;
import cr.onion.web.security.remember.DefaultRememberMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author Beldon
 * @create 2017-12-06 下午3:51
 */
@Configuration
public class SecurityConfig {

    @Autowired
    private UserAutoRepo userAutoRepo;

    @Autowired
    private OnionConfig onionConfig;

    @Autowired
    private RememberMeTokenRepo rememberMeTokenRepo;

    @Bean
    public FilterRegistrationBean securityFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new SecurityFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean rememberMeFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new RememberMeAuthenticationFilter(rememberMeService()));
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
        return registrationBean;
    }

    @Bean
    public RememberMeService rememberMeService() {
        String type = onionConfig.getRememberMe().getType();
        if (RememberMeConfig.PERSISTENT_TYPE.equals(type)) {
            return new PersistentTokenRememberMeService(rememberMeTokenRepo, userAutoRepo);
        } else {
            return new DefaultRememberMeService(userAutoRepo);
        }
    }

}
