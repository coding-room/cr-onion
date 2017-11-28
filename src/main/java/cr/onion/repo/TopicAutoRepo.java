package cr.onion.repo;

import cr.onion.entity.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Beldon.
 */
public interface TopicAutoRepo extends MongoRepository<Topic, String> {

}
