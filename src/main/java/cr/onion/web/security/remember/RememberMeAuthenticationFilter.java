package cr.onion.web.security.remember;

import cr.onion.common.CommonConstant;
import cr.onion.web.security.Authentication;
import cr.onion.web.security.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Beldon
 * @create 2017-12-06 下午3:22
 */
public class RememberMeAuthenticationFilter extends OncePerRequestFilter {

    private final RememberMeService rememberMeServices;

    public RememberMeAuthenticationFilter(RememberMeService rememberMeServices) {
        this.rememberMeServices = rememberMeServices;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getAuthentication();
        if (authentication == null) {
            Authentication rememberMeAuth = rememberMeServices.autoLogin(request, response);
            if (rememberMeAuth != null) {
                SecurityContextHolder.setAuthentication(rememberMeAuth);
                request.getSession().setAttribute(CommonConstant.Session.AUTHENTICATION, rememberMeAuth);
            }
        }

        chain.doFilter(request, response);
    }
}
