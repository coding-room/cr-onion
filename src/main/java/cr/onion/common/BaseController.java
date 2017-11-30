package cr.onion.common;

import cr.onion.entity.User;
import cr.onion.repo.UserAutoRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Beldon.
 */
public abstract class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected UserAutoRepo userAutoRepo;

    protected String currentUserId() {
        return (String) currentRequest().getSession().getAttribute(CommonConstant.Session.USER_ID);
    }

    protected User currentUser() {
        return userAutoRepo.findOne(currentUserId());
    }

    protected HttpServletRequest currentRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
