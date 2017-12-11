package cr.onion.web.security;

import cr.onion.common.ResponseVO;
import cr.onion.common.util.ResponseUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Beldon
 * @create 2017-12-06 下午3:05
 */
@Service
public class AuthorizationAdvice implements MethodInterceptor {
    private Logger log = LoggerFactory.getLogger(AuthorizationAdvice.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Authentication authentication = SecurityContextHolder.getAuthentication();
        if (authentication == null) {
            log.info("no login!");
            Class returnType = invocation.getMethod().getReturnType();
            if (returnType.isAssignableFrom(ResponseVO.class)) {
                return ResponseUtils.error("no login!");
            }else{
                return "redirect:/user/login";
            }
        }
        return invocation.proceed();
    }

}
