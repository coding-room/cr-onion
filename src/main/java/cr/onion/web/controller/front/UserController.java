package cr.onion.web.controller.front;

import cr.onion.common.BaseFrontController;
import cr.onion.common.CommonConstant;
import cr.onion.web.security.SecurityContextHolder;
import cr.onion.web.security.remember.RememberMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Beldon.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseFrontController {
    @Autowired
    private RememberMeService rememberMeService;

    @GetMapping("/login")
    public String login() {
        return getTemplate("user/login");
    }

    @GetMapping("/reg")
    public String reg() {
        return getTemplate("user/reg");
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        rememberMeService.logout(request, response);
        SecurityContextHolder.removeAuthentication();
        request.getSession().removeAttribute(CommonConstant.Session.AUTHENTICATION);
        return "redirect:/user/login";
    }

}
