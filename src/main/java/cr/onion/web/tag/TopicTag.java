package cr.onion.web.tag;

import cr.onion.common.BaseTag;
import cr.onion.common.annotation.Tag;
import cr.onion.entity.Topic;
import cr.onion.repo.TopicAutoRepo;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author Beldon.
 */
@Tag(name = "topic_tag")
public class TopicTag extends BaseTag {

    @Autowired
    private TopicAutoRepo topicAutoRepo;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] templateModels, TemplateDirectiveBody body) throws TemplateException, IOException {
        Integer currentPage = Integer.valueOf(getParam(params, "page", "1"));
        currentPage--;
        Integer pageSize = Integer.valueOf(getParam(params, "pageSize", "10"));
        String categoryId = getParam(params, "categoryId", "");
        Pageable pageable = new PageRequest(currentPage, pageSize,new Sort(new Sort.Order(Sort.Direction.ASC,"created")));
        Page<Topic> topicPage;
        if (StringUtils.hasText(categoryId)) {
            topicPage = topicAutoRepo.findByCategory_Id(categoryId, pageable);
        } else {
            topicPage = topicAutoRepo.findAll(pageable);
        }
        env.setVariable("page", beansWrapper.wrap(topicPage));
        renderBody(env, body);
    }
}
