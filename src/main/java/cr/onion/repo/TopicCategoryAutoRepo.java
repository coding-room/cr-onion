package cr.onion.repo;

import cr.onion.entity.TopicCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Beldon.
 */
public interface TopicCategoryAutoRepo extends MongoRepository<TopicCategory,String> {
}
