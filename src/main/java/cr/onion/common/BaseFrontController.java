package cr.onion.common;

/**
 * @author Beldon.
 */
public abstract class BaseFrontController extends BaseController {
    protected String getTemplate(String template) {
        return "theme/" + getTheme() + "/" + template;
    }

    /**
     * 获取模板，默认是default，为后期模板开发做准备
     *
     * @return
     */
    protected String getTheme() {
        return "default";
    }
}
