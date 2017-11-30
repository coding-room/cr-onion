package cr.onion.web.controller.front;

import cr.onion.common.BaseFrontController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Beldon.
 */
@Controller
public class IndexController extends BaseFrontController {

    @GetMapping({"/", "/index"})
    public String index() {
        return getTemplate("index");
    }

}
