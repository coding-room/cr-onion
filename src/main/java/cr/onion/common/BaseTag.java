package cr.onion.common;

import cr.onion.common.util.SSUtil;
import freemarker.core.Environment;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author Beldon.
 */
public abstract class BaseTag extends BaseVariable implements TemplateDirectiveModel {
    @Override
    protected String getName() {
        return SSUtil.humpToLine(this.getClass().getSimpleName()).substring(1);
    }

    /**
     * 获取参数值
     *
     * @param params
     * @param name
     * @return
     */
    protected String getParam(Map params, String name) {
        Object value = params.get(name);
        if (value instanceof SimpleScalar) {
            return ((SimpleScalar) value).getAsString();
        }
        return null;
    }

    protected String getParam(Map params, String name, String defaultValue) {
        String value = getParam(params, name);
        return StringUtils.hasText(value) ? value : defaultValue;
    }

    protected void renderBody(Environment env, TemplateDirectiveBody body) throws IOException, TemplateException {
        if (body != null) {
            body.render(env.getOut());
        }
    }
}
