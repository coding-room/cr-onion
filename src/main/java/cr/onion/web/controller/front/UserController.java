package cr.onion.web.controller.front;

import cr.onion.common.BaseFrontController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Beldon.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseFrontController {


    @GetMapping("/login")
    public String login() {
        return getTemplate("user/login");
    }

    @GetMapping("/reg")
    public String reg() {
        return getTemplate("user/reg");
    }

}
