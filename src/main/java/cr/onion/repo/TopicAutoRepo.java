package cr.onion.repo;

import cr.onion.entity.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Beldon.
 */
public interface TopicAutoRepo extends MongoRepository<Topic, String> {
    Page<Topic> findByCategory_Id(String categoryId, Pageable pageable);
}
