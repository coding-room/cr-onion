package cr.onion.web.controller.admin;

import cr.onion.common.BaseAdminController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Beldon.
 */
@Controller
@RequestMapping("/admin/topicCategory")
public class TopicCategoryAdminController extends BaseAdminController {

    @GetMapping("/list")
    public String list() {
        return getTemplate("topic/categoryList");
    }

    @GetMapping("/add")
    public String add() {
        return getTemplate("topic/categoryAdd");
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        model.addAttribute("id", id);
        return getTemplate("topic/categoryEdit");
    }
}
