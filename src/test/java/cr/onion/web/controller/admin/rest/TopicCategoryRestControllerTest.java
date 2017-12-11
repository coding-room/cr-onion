package cr.onion.web.controller.admin.rest;

import cr.onion.entity.TopicCategory;
import cr.onion.repo.TopicCategoryAutoRepo;
import cr.onion.web.MockUtils;
import cr.onion.web.controller.BaseControllerTest;
import cr.onion.web.controller.vo.TopicCategoryVO;
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
public class TopicCategoryRestControllerTest extends BaseControllerTest {

    @Autowired
    private TopicCategoryAutoRepo topicCategoryAutoRepo;

    @Before
    public void before() {
        topicCategoryAutoRepo.deleteAll();
    }

    @Test
    public void add() throws Exception {
        TopicCategoryVO topicCategoryMO = new TopicCategoryVO();
        topicCategoryMO.setName("分类名字");
        topicCategoryMO.setSort(1);

        mockMvc.perform(MockUtils.populatePostBuilder("/admin/topicCategory", topicCategoryMO))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("0"));

        List<TopicCategory> topicCategories = topicCategoryAutoRepo.findAll();
        Assert.assertEquals(1, topicCategories.size());
        TopicCategory category = topicCategories.get(0);
        Assert.assertEquals(category.getName(), topicCategoryMO.getName());
        Assert.assertEquals(category.getSort(), topicCategoryMO.getSort());
    }

    @Test
    public void update() throws Exception {
        add();
        List<TopicCategory> topicCategories = topicCategoryAutoRepo.findAll();
        TopicCategory category = topicCategories.get(0);
        TopicCategoryVO topicCategoryMO = new TopicCategoryVO();
        topicCategoryMO.setName("分类名字22");
        topicCategoryMO.setSort(2);

        mockMvc.perform(MockUtils.populatePutBuilder("/admin/topicCategory/" + category.getId(), topicCategoryMO))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("0"));

        topicCategories = topicCategoryAutoRepo.findAll();
        Assert.assertEquals(1, topicCategories.size());
        category = topicCategories.get(0);
        Assert.assertEquals(category.getId(), category.getId());
        Assert.assertEquals(category.getName(), topicCategoryMO.getName());
        Assert.assertEquals(category.getSort(), topicCategoryMO.getSort());
    }

    @Test
    public void delete() throws Exception {
        add();
        List<TopicCategory> topicCategories = topicCategoryAutoRepo.findAll();
        TopicCategory category = topicCategories.get(0);

        mockMvc.perform(MockUtils.populateDeleteBuilder("/admin/topicCategory/" + category.getId(), null))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("0"));
        topicCategories = topicCategoryAutoRepo.findAll();
        Assert.assertEquals(0, topicCategories.size());
    }
}