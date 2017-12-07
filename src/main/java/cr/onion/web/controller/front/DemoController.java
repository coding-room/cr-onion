package cr.onion.web.controller.front;

import cr.onion.common.ResponseMO;
import cr.onion.common.annotation.Authorization;
import cr.onion.common.util.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Beldon.
 */
@Controller
public class DemoController {

    @Authorization
    @GetMapping("/demo/index")
    public String index() {
        return "ss";
    }

    @Authorization
    @ResponseBody
    @GetMapping("/demo/demo")
    public ResponseMO demo() {
        return ResponseUtils.success("success");
    }
}
