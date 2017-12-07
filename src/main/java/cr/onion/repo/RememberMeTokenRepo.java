package cr.onion.repo;

import cr.onion.entity.RememberMeToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Beldon
 */
public interface RememberMeTokenRepo extends MongoRepository<RememberMeToken, String> {
    List<RememberMeToken> findAllByAccountOrderByCreated(String account);

    RememberMeToken findByAccountAndTokenValue(String account, String token);
}
