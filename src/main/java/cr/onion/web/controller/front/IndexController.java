package cr.onion.web.controller.front;

import cr.onion.common.BaseFrontController;
import cr.onion.common.util.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Beldon.
 */
@Controller
public class IndexController extends BaseFrontController {

    @GetMapping({"/", "/index"})
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return getTemplate("index");
    }

    @GetMapping("/verifycode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        try {
            VerifyCodeUtils.generateVerifyCode(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/u/{account}")
    public String home(@PathVariable(value = "account") String account) {
        return getTemplate("user/home");
    }
}
