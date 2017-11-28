package cr.onion.web.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Beldon.
 */
@Controller
public class IndexController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "/index";
    }
}
