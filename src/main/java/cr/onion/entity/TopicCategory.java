package cr.onion.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Beldon.
 */
@Document(collection = "topic_category")
public class TopicCategory extends BaseEntity{
    private String name;
    private Integer sort;

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
