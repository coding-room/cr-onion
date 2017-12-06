package cr.onion.web.security;

import cr.onion.common.CommonConstant;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Beldon
 */
public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        try {
            Authentication authentication = (Authentication) request.getSession()
                    .getAttribute(CommonConstant.Session.AUTHENTICATION);
            SecurityContextHolder.setAuthentication(authentication);
            chain.doFilter(request, response);
        } finally {
            SecurityContextHolder.removeAuthentication();
        }
    }
}
