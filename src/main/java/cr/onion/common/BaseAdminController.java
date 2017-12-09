package cr.onion.common;

/**
 * @author Beldon.
 */
public abstract class BaseAdminController extends BaseController {
    protected String getTemplate(String template) {
        return "admin/" + template;
    }

}
