package cr.onion.web.controller.admin.rest;

import cr.onion.common.ResponseVO;
import cr.onion.common.util.ResponseUtils;
import cr.onion.entity.TopicCategory;
import cr.onion.repo.TopicCategoryAutoRepo;
import cr.onion.web.controller.vo.TopicCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Beldon.
 */
@RestController
@RequestMapping("/admin/topicCategory")
public class TopicCategoryRestController {
    @Autowired
    private TopicCategoryAutoRepo topicCategoryAutoRepo;

    @GetMapping
    public ResponseVO list() {
        List<TopicCategory> categories = topicCategoryAutoRepo.findAll();
        return ResponseUtils.success("", categories);
    }

    @PostMapping
    public ResponseVO add(@RequestBody @Valid TopicCategoryVO categoryVO) {
        TopicCategory category = new TopicCategory();
        category.setName(categoryVO.getName());
        category.setSort(categoryVO.getSort());
        topicCategoryAutoRepo.save(category);
        return ResponseUtils.success();
    }

    @PutMapping("/{id}")
    public ResponseVO update(@RequestBody @Valid TopicCategoryVO categoryVO, @PathVariable("id") String id) {
        TopicCategory category = topicCategoryAutoRepo.findOne(id);
        if (category == null) {
            return ResponseUtils.error("记录不存在");
        }
        category.setName(categoryVO.getName());
        category.setSort(categoryVO.getSort());
        topicCategoryAutoRepo.save(category);
        return ResponseUtils.success();
    }

    @DeleteMapping("/{id}")
    public ResponseVO delete(@PathVariable(name = "id") String id) {
        if (StringUtils.isEmpty(id)) {
            return ResponseUtils.error("id不能为空");
        }
        TopicCategory category = topicCategoryAutoRepo.findOne(id);
        if (category != null) {
            topicCategoryAutoRepo.delete(category);
        }
        return ResponseUtils.success();
    }
}
