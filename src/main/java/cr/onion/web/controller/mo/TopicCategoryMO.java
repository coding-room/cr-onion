package cr.onion.web.controller.mo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author Beldon.
 */
public class TopicCategoryMO {
    private String id;
    @NotEmpty(message = "分类名字不能为空")
    private String name;
    @NotNull(message = "排序不能为空")
    private Integer sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
