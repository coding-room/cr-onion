package cr.onion.web.controller.front;

import cr.onion.common.BaseFrontController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Beldon.
 */
@Controller
@RequestMapping("/topic")
public class TopicController extends BaseFrontController {

    @GetMapping("/{id}")
    public String topic(@PathVariable("id") String id) {
        return getTemplate("topic");
    }
}
