package cr.onion.config;

import cr.onion.web.security.SecurityFilter;
import cr.onion.web.security.remember.RememberMeAuthenticationFilter;
import cr.onion.web.security.remember.RememberMeService;
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

    private RememberMeService rememberMeServices;

    @Bean
    public FilterRegistrationBean securityFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new SecurityFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean rememberMeFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new RememberMeAuthenticationFilter(rememberMeServices));
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE + 1);
        return registrationBean;
    }
}
