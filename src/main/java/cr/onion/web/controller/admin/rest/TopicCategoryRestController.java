package cr.onion.web.controller.admin.rest;

import cr.onion.common.ResponseMO;
import cr.onion.common.util.ResponseUtils;
import cr.onion.entity.TopicCategory;
import cr.onion.repo.TopicCategoryAutoRepo;
import cr.onion.web.controller.mo.TopicCategoryMO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Beldon.
 */
@RestController
@RequestMapping("/admin/topicCategory")
public class TopicCategoryRestController {
    @Autowired
    private TopicCategoryAutoRepo topicCategoryAutoRepo;

    @PostMapping
    public ResponseMO add(@RequestBody @Valid TopicCategoryMO categoryMO) {
        TopicCategory category = new TopicCategory();
        category.setName(categoryMO.getName());
        category.setSort(categoryMO.getSort());
        topicCategoryAutoRepo.save(category);
        return ResponseUtils.success();
    }

    @PutMapping("/{id}")
    public ResponseMO update(@RequestBody @Valid TopicCategoryMO categoryMO, @PathVariable("id") String id) {
        TopicCategory category = topicCategoryAutoRepo.findOne(id);
        if (category == null) {
            return ResponseUtils.error("记录不存在");
        }
        category.setName(categoryMO.getName());
        category.setSort(categoryMO.getSort());
        topicCategoryAutoRepo.save(category);
        return ResponseUtils.success();
    }

    @DeleteMapping("/{id}")
    public ResponseMO delete(@PathVariable(name = "id") String id) {
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
