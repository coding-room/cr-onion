package cr.onion.common;

import cr.onion.common.util.SSUtil;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Beldon.
 */
public class BaseVariable extends ApplicationObjectSupport {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected BeansWrapperBuilder beansWrapperBuilder;

    protected BeansWrapper beansWrapper;

    @Autowired
    protected FreeMarkerConfigurer freeMarkerConfigurer;


    /**
     * 初始化Freemarker变量
     *
     * @throws TemplateModelException
     */
    @PostConstruct
    public void init() throws TemplateModelException {
        String tagName = getName();
        freeMarkerConfigurer.getConfiguration().setSharedVariable(tagName, this);
        freeMarkerConfigurer.getConfiguration().removeAutoInclude(tagName);
        beansWrapperBuilder = new BeansWrapperBuilder(Configuration.VERSION_2_3_26);
        beansWrapper = beansWrapperBuilder.build();
        if (logger.isDebugEnabled()) {
            logger.info("create【" + tagName + "】variable");
        }
    }

    /**
     * 卸载
     *
     * @throws TemplateModelException
     */
    @PreDestroy
    private void destroy() throws TemplateModelException {
        if (logger.isDebugEnabled()) {
            logger.info("destroy【" + getName() + "】variable");
        }
    }

    /**
     * 返回名称
     *
     * @return tagName
     */
    protected String getName() {
        return SSUtil.humpToLine(this.getClass().getSimpleName()).substring(1);
    }


}
