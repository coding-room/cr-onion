package cr.onion.domain;

import cr.onion.entity.Topic;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author Beldon.
 */
@Configurable
public class TopicDomain {
    private final Topic entity;

    public boolean isOwner(String userId) {
        return entity.getUser().getId().equals(userId);
    }

    public TopicDomain(Topic entity) {
        this.entity = entity;
    }
}
