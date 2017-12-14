package cr.onion.web.controller.front.rest;

import cr.onion.common.CommonConstant;
import cr.onion.entity.Topic;
import cr.onion.entity.TopicCategory;
import cr.onion.repo.TopicAutoRepo;
import cr.onion.repo.TopicCategoryAutoRepo;
import cr.onion.web.MockUtils;
import cr.onion.web.controller.BaseControllerTest;
import cr.onion.web.controller.vo.TopicVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Beldon.
 */
public class TopicRestControllerTest extends BaseControllerTest {

    @Autowired
    private TopicAutoRepo topicAutoRepo;

    @Autowired
    private TopicCategoryAutoRepo topicCategoryAutoRepo;

    private String userId = "";

    private TopicCategory category = new TopicCategory();

    @Before
    public void before() throws Exception {
        topicAutoRepo.deleteAll();
        userId = registerUser();
        initCategory();
    }

    private void initCategory() {
        topicCategoryAutoRepo.deleteAll();
        category.setName("name");
        category.setSort(1);
        topicCategoryAutoRepo.save(category);
    }

    @Test
    public void add() throws Exception {
        TopicVO topicMO = new TopicVO();
        topicMO.setTitle("這是我的帖子");
        topicMO.setContent("帖子内容");
        topicMO.setCategoryId(category.getId());
        mockMvc.perform(MockUtils.populatePostBuilder("/topic", topicMO).sessionAttr(CommonConstant.Session.USER_ID, userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("0"));
        List<Topic> topics = topicAutoRepo.findAll();
        Assert.assertEquals(1, topics.size());
        Topic topic = topics.get(0);
        Assert.assertEquals(topic.getTitle(), topicMO.getTitle());
        Assert.assertEquals(topic.getContent(), topicMO.getContent());
        Assert.assertEquals(topic.getCategory().getId(), topicMO.getCategoryId());
        Assert.assertEquals(topic.getUser().getId(), userId);
    }

    @Test
    public void update() throws Exception {
        add();
        List<Topic> topics = topicAutoRepo.findAll();
        Assert.assertEquals(1, topics.size());
        Topic topic = topics.get(0);

        TopicVO topicMO = new TopicVO();
        topicMO.setTitle("這是我的帖子2");
        topicMO.setContent("帖子内容2");
        topicMO.setCategoryId(category.getId());

        mockMvc.perform(MockUtils.populatePutBuilder("/topic/" + topic.getId(), topicMO).sessionAttr(CommonConstant.Session.USER_ID, userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("0"));

        topics = topicAutoRepo.findAll();
        Assert.assertEquals(1, topics.size());
        Topic topic2 = topics.get(0);
        Assert.assertEquals(topic2.getTitle(), topicMO.getTitle());
        Assert.assertEquals(topic2.getContent(), topicMO.getContent());
        Assert.assertEquals(topic2.getCategory().getId(), topicMO.getCategoryId());
        Assert.assertEquals(topic2.getUser().getId(), userId);
        Assert.assertEquals(topic2.getId(), topic.getId());
    }

    @Test
    public void delete() throws Exception {
        add();
        List<Topic> topics = topicAutoRepo.findAll();
        Assert.assertEquals(1, topics.size());
        Topic topic = topics.get(0);

        TopicVO topicMO = new TopicVO();
        topicMO.setTitle("這是我的帖子2");
        topicMO.setContent("帖子内容2");
        topicMO.setCategoryId(category.getId());

        mockMvc.perform(MockUtils.populateDeleteBuilder("/topic/" + topic.getId(), null).sessionAttr(CommonConstant.Session.USER_ID, userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("0"));

        topics = topicAutoRepo.findAll();
        Assert.assertEquals(0, topics.size());
    }

    @Test
    public void top() throws Exception {
        add();
        List<Topic> topics = topicAutoRepo.findAll();
        Assert.assertEquals(1, topics.size());
        Topic topic = topics.get(0);

        TopicVO topicMO = new TopicVO();
        topicMO.setTitle("這是我的帖子2");
        topicMO.setContent("帖子内容2");
        topicMO.setCategoryId(category.getId());

        mockMvc.perform(MockUtils.populatePostBuilder("/topic/top/" + topic.getId(), null).sessionAttr(CommonConstant.Session.USER_ID, userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("0"));

        topics = topicAutoRepo.findAll();
        Assert.assertEquals(1, topics.size());
        Topic topic1 = topics.get(0);
        Assert.assertTrue(topic1.isTop());

    }


    @Test
    public void lock() throws Exception {
        add();
        List<Topic> topics = topicAutoRepo.findAll();
        Assert.assertEquals(1, topics.size());
        Topic topic = topics.get(0);

        TopicVO topicMO = new TopicVO();
        topicMO.setTitle("這是我的帖子2");
        topicMO.setContent("帖子内容2");
        topicMO.setCategoryId(category.getId());

        mockMvc.perform(MockUtils.populatePostBuilder("/topic/lock/" + topic.getId(), null).sessionAttr(CommonConstant.Session.USER_ID, userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("0"));

        topics = topicAutoRepo.findAll();
        Assert.assertEquals(1, topics.size());
        Topic topic1 = topics.get(0);
        Assert.assertTrue(topic1.isLock());
    }

    @Test
    public void good() throws Exception {
        add();
        List<Topic> topics = topicAutoRepo.findAll();
        Assert.assertEquals(1, topics.size());
        Topic topic = topics.get(0);

        TopicVO topicMO = new TopicVO();
        topicMO.setTitle("這是我的帖子2");
        topicMO.setContent("帖子内容2");
        topicMO.setCategoryId(category.getId());

        mockMvc.perform(MockUtils.populatePostBuilder("/topic/good/" + topic.getId(), null).sessionAttr(CommonConstant.Session.USER_ID, userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("0"));

        topics = topicAutoRepo.findAll();
        Assert.assertEquals(1, topics.size());
        Topic topic1 = topics.get(0);
        Assert.assertTrue(topic1.isGood());
    }
}