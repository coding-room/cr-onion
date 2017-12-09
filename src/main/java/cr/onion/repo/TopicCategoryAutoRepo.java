package cr.onion.repo;

import cr.onion.entity.TopicCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Beldon.
 */
public interface TopicCategoryAutoRepo extends MongoRepository<TopicCategory,String> {
    List<TopicCategory> findAllByOrderBySort();
}
