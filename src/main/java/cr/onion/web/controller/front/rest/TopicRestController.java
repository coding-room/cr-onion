package cr.onion.web.controller.front.rest;

import cr.onion.common.BaseController;
import cr.onion.common.ResponseMO;
import cr.onion.common.util.ResponseUtils;
import cr.onion.domain.TopicDomain;
import cr.onion.entity.Topic;
import cr.onion.entity.TopicCategory;
import cr.onion.repo.TopicAutoRepo;
import cr.onion.repo.TopicCategoryAutoRepo;
import cr.onion.web.controller.mo.TopicMO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author Beldon.
 */
@RestController
@RequestMapping("/topic")
public class TopicRestController extends BaseController {

    @Autowired
    private TopicCategoryAutoRepo topicCategoryAutoRepo;

    @Autowired
    private TopicAutoRepo topicAutoRepo;

    @PostMapping
    public ResponseMO add(@RequestBody @Valid TopicMO topicMO) {
        TopicCategory category = topicCategoryAutoRepo.findOne(topicMO.getCategoryId());
        if (category == null) {
            return ResponseUtils.error("分类信息不存在");
        }

        Topic topic = new Topic();
        topic.setTitle(topicMO.getTitle());
        topic.setContent(topicMO.getContent());
        topic.setCategory(category);
        topic.setCreated(new Date());
        topic.setUser(currentUser());
        topicAutoRepo.save(topic);
        return ResponseUtils.success("", topic.getId());
    }

    @PutMapping("/{id}")
    public ResponseMO update(@PathVariable("id") String id, @RequestBody @Valid TopicMO topicMO) {
        Topic topic = topicAutoRepo.findOne(id);
        if (topic == null) {
            return ResponseUtils.error("记录不存在");
        }
        TopicDomain domain = new TopicDomain(topic);
        if (!domain.isOwner(currentUserId())) {
            return ResponseUtils.error("记录不存在");
        }
        TopicCategory category = topicCategoryAutoRepo.findOne(topicMO.getCategoryId());
        if (category == null) {
            return ResponseUtils.error("分类信息不存在");
        }
        topic.setTitle(topicMO.getTitle());
        topic.setContent(topicMO.getContent());
        topic.setCategory(category);
        topicAutoRepo.save(topic);
        return ResponseUtils.success();
    }

    @DeleteMapping("/{id}")
    public ResponseMO delete(@PathVariable("id") String id) {
        Topic topic = topicAutoRepo.findOne(id);
        if (topic == null) {
            return ResponseUtils.error("记录不存在");
        }
        TopicDomain domain = new TopicDomain(topic);
        if (!domain.isOwner(currentUserId())) {
            return ResponseUtils.error("记录不存在");
        }
        topicAutoRepo.delete(topic);
        return ResponseUtils.success();
    }
}
