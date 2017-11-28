package cr.onion.repo;

import cr.onion.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Beldon.
 */
public interface UserAutoRepo extends MongoRepository<User, String> {
    User findByAccount(String account);
}
