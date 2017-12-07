package cr.onion.web.security;

import cr.onion.common.annotation.Authorization;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.annotation.AnnotationClassFilter;
import org.springframework.aop.support.annotation.AnnotationMethodMatcher;
import org.springframework.stereotype.Controller;

/**
 * @author Beldon.
 */
public class AuthorizationAnnotationMatchingPointcut implements Pointcut {

    private final ClassFilter classFilter;

    private final MethodMatcher methodMatcher;

    public AuthorizationAnnotationMatchingPointcut() {
        this.classFilter = new AnnotationClassFilter(Controller.class, true);
        this.methodMatcher = new AnnotationMethodMatcher(Authorization.class);
    }

    @Override
    public ClassFilter getClassFilter() {
        return classFilter;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }
}
