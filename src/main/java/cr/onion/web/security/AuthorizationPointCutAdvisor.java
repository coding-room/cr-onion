package cr.onion.web.security;

import cr.onion.common.annotation.Authorization;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Beldon
 */
@Service
public class AuthorizationPointCutAdvisor extends AbstractPointcutAdvisor{

    private final Pointcut pointcut;
    private final Advice advice;

    @Autowired
    public AuthorizationPointCutAdvisor(AuthorizationAdvisor advice) {
        this.pointcut = new AnnotationMatchingPointcut(null, Authorization.class);
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}

