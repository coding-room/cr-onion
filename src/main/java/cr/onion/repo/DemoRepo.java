package cr.onion.repo;

import cr.onion.entity.Demo;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * @author Beldon
 * @create 2017-11-28 下午5:55
 */
public interface DemoRepo extends MongoRepository<Demo, Long> {

}
