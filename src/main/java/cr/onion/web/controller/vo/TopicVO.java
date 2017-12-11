package cr.onion.web.controller.vo;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Beldon.
 */
public class TopicVO {
    /**
     * 标题
     */
    @NotEmpty(message = "标题不能为空")
    private String title;
    /**
     * 内容
     */
    @NotEmpty(message = "内容不能为空")
    private String content;

    @NotEmpty(message = "分类不能为空")
    private String categoryId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
