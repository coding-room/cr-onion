package cr.onion.web.controller.front.rest;

import cr.onion.common.CommonConstant;
import cr.onion.web.MockUtils;
import cr.onion.web.controller.BaseControllerTest;
import cr.onion.web.controller.mo.LoginMO;
import org.junit.Test;
import org.mockito.internal.matchers.CompareEqual;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Beldon.
 */
public class UserRestControllerTest extends BaseControllerTest {


    @Test
    public void register() throws Exception {
        registerUser();
    }

    @Test
    public void login() throws Exception {
        String userId = registerUser();
        LoginMO loginMO = new LoginMO();
        loginMO.setAccount(account);
        loginMO.setPassword(password);
        mockMvc.perform(MockUtils.populatePostBuilder("/user/login", loginMO))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("0"))
                .andExpect(request().sessionAttribute(CommonConstant.Session.USER_ID, new CompareEqual(userId)));
    }
}