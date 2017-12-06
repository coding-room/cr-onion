package cr.onion.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在需要授权的Controller 方法上加改注解
 * 具体实现看一下两个类
 * {@link cr.onion.web.security.AuthorizationPointCutAdvisor}
 * {@link cr.onion.web.security.AuthorizationAdvisor}
 * @author Beldon
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {
}
