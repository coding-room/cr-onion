package cr.onion.web.controller;

import cr.onion.domain.UserDomain;
import cr.onion.entity.User;
import cr.onion.repo.UserAutoRepo;
import cr.onion.web.MockUtils;
import cr.onion.web.controller.mo.LoginMO;
import cr.onion.web.controller.mo.RegisterMO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Beldon.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private UserAutoRepo userAutoRepo;

    protected String account = "beldon";

    protected String password = "111111";

    @Before
    public void beforeInit() {
        userAutoRepo.deleteAll();
    }

    protected String registerUser() throws Exception {
        return registerUser(account, password);
    }

    protected String registerUser(String account, String password) throws Exception {
        RegisterMO registerMO = new RegisterMO();
        registerMO.setAccount(account);
        registerMO.setPassword(password);

        mockMvc.perform(MockUtils.populatePostBuilder("/user/register", registerMO))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("0"));
        List<User> userList = userAutoRepo.findAll();
        Assert.assertEquals(1, userList.size());
        User user = userList.get(0);
        UserDomain userDomain = new UserDomain(user);
        Assert.assertTrue(userDomain.checkPassword(password));
        return user.getId();
    }

    protected void userLogin() throws Exception {
        userLogin(account, password);
    }

    protected void userLogin(String account, String password) throws Exception {
        LoginMO loginMO = new LoginMO();
        loginMO.setAccount(account);
        loginMO.setPassword(password);
        mockMvc.perform(MockUtils.populatePostBuilder("/user/login", loginMO))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("0"));
    }
}
