package cr.onion.web.security;

import cr.onion.common.CommonConstant;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Beldon
 * @create 2017-12-06 下午3:05
 */
@Service
public class AuthorizationAdvisor implements MethodInterceptor {
    private Logger log = LoggerFactory.getLogger(AuthorizationAdvisor.class);
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String userId = (String) request.getSession().getAttribute(CommonConstant.Session.USER_ID);
        if (StringUtils.isEmpty(userId)) {
            // TODO 处理未登录逻辑
            log.info("no login!");

        }
        return invocation.proceed();
    }
}
