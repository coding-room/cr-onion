package cr.onion.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author Beldon.
 */
@Document(collection = "topic")
public class Topic extends BaseEntity {
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;

    @DBRef
    private User user;

    @DBRef
    private TopicCategory category;

    /**
     * 查看數量
     */
    private Integer views = 0;

    /**
     * 帖子状态:0-草稿，1-已发布,-1回收站
     */
    private int status = 1;

    /**
     * 是否置顶，1-true，0-false
     */
    private boolean top;

    /**
     * 是否锁帖，1-true，0-false
     */
    private boolean lock;
    /**
     * 是否精华，1-true，0-false
     */
    private boolean good;

    /**
     * 创建时间
     */
    private Date created;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TopicCategory getCategory() {
        return category;
    }

    public void setCategory(TopicCategory category) {
        this.category = category;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
