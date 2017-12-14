package cr.onion.web.controller.front.rest;

import cr.onion.common.BaseController;
import cr.onion.common.ResponseVO;
import cr.onion.common.util.ResponseUtils;
import cr.onion.domain.TopicDomain;
import cr.onion.entity.Topic;
import cr.onion.entity.TopicCategory;
import cr.onion.repo.TopicAutoRepo;
import cr.onion.repo.TopicCategoryAutoRepo;
import cr.onion.web.controller.vo.TopicVO;
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
    public ResponseVO add(@RequestBody @Valid TopicVO topicVO) {
        TopicCategory category = topicCategoryAutoRepo.findOne(topicVO.getCategoryId());
        if (category == null) {
            return ResponseUtils.error("分类信息不存在");
        }

        Topic topic = new Topic();
        topic.setTitle(topicVO.getTitle());
        topic.setContent(topicVO.getContent());
        topic.setCategory(category);
        topic.setCreated(new Date());
        topic.setUser(currentUser());
        topicAutoRepo.save(topic);
        return ResponseUtils.success("", topic.getId());
    }

    @PutMapping("/{id}")
    public ResponseVO update(@PathVariable("id") String id, @RequestBody @Valid TopicVO topicVO) {
        Topic topic = topicAutoRepo.findOne(id);
        if (topic == null) {
            return ResponseUtils.error("记录不存在");
        }
        TopicDomain domain = new TopicDomain(topic);
        if (!domain.isOwner(currentUserId())) {
            return ResponseUtils.error("记录不存在");
        }
        TopicCategory category = topicCategoryAutoRepo.findOne(topicVO.getCategoryId());
        if (category == null) {
            return ResponseUtils.error("分类信息不存在");
        }
        topic.setTitle(topicVO.getTitle());
        topic.setContent(topicVO.getContent());
        topic.setCategory(category);
        topicAutoRepo.save(topic);
        return ResponseUtils.success();
    }

    @DeleteMapping("/{id}")
    public ResponseVO delete(@PathVariable("id") String id) {
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

    @PostMapping("/top/{id}")
    public ResponseVO top(@PathVariable("id") String id) {
        Topic topic = topicAutoRepo.findOne(id);
        if (topic == null) {
            return ResponseUtils.error("记录不存在");
        }
        topic.setTop(!topic.isTop());
        topicAutoRepo.save(topic);
        return ResponseUtils.success();
    }

    @PostMapping("/lock/{id}")
    public ResponseVO lock(@PathVariable("id") String id) {
        Topic topic = topicAutoRepo.findOne(id);
        if (topic == null) {
            return ResponseUtils.error("记录不存在");
        }
        topic.setLock(!topic.isLock());
        topicAutoRepo.save(topic);
        return ResponseUtils.success();
    }

    @PostMapping("/good/{id}")
    public ResponseVO good(@PathVariable("id") String id) {
        Topic topic = topicAutoRepo.findOne(id);
        if (topic == null) {
            return ResponseUtils.error("记录不存在");
        }
        topic.setGood(!topic.isGood());
        topicAutoRepo.save(topic);
        return ResponseUtils.success();
    }

}
