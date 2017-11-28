package cr.onion.repo;

import cr.onion.entity.Demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Beldon
 * @create 2017-11-28 下午5:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRepoTest {
    @Autowired
    private DemoRepo demoRepo;


    @Test
    public void add() {
        demoRepo.deleteAll();

        Demo demo = new Demo();
        demo.setName("demo");
        demo.setAge(1);
        demoRepo.save(demo);

        List<Demo> demoList = demoRepo.findAll();
        assertEquals(demoList.size(), 1);
        assertEquals(demoList.get(0).getName(), demo.getName());
    }

}