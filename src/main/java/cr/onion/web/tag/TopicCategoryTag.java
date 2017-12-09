package cr.onion.web.tag;

import cr.onion.common.BaseTag;
import cr.onion.common.annotation.Tag;
import cr.onion.entity.TopicCategory;
import cr.onion.repo.TopicCategoryAutoRepo;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Beldon.
 */
@Tag(name = "topic_category")
public class TopicCategoryTag extends BaseTag {

    @Autowired
    private TopicCategoryAutoRepo topicCategoryAutoRepo;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] templateModels, TemplateDirectiveBody body) throws TemplateException, IOException {
        String id = getParam(params, "id");
        if (StringUtils.hasText(id)) {
            TopicCategory topicCategory = topicCategoryAutoRepo.findOne(id);
            env.setVariable("topicCategory", beansWrapper.wrap(topicCategory));
        }else{
            List<TopicCategory> topicCategories = topicCategoryAutoRepo.findAllByOrderBySort();
            env.setVariable("topicCategories", beansWrapper.wrap(topicCategories));
        }
        renderBody(env, body);
    }
}
