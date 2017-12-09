package cr.onion.web.security;

import cr.onion.common.BaseFrontController;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Beldon.
 */
@Component
public class OnionErrorViewResolver extends BaseFrontController implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView();
        if (status.value() == 404) {
            modelAndView.setViewName(getTemplate("notFound"));
        }
        return modelAndView;
    }
}
