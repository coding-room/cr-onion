package cr.onion.web.controller.admin;

import cr.onion.common.BaseAdminController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Beldon.
 */
@Controller
@RequestMapping("/admin")
public class IndexAdminController extends BaseAdminController {

    @GetMapping({"/index", "/"})
    public String index() {
        return getTemplate("index");
    }

    @GetMapping("/template")
    public String template() {
        return getTemplate("template");
    }

    @GetMapping("/login")
    public String login() {
        return getTemplate("login");
    }
}
