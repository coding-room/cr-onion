package cr.onion.web.controller.front.rest;

import cr.onion.common.CommonConstant;
import cr.onion.common.ResponseMO;
import cr.onion.common.util.ResponseUtils;
import cr.onion.domain.UserDomain;
import cr.onion.entity.User;
import cr.onion.repo.UserAutoRepo;
import cr.onion.web.controller.mo.LoginMO;
import cr.onion.web.controller.mo.RegisterMO;
import cr.onion.web.security.remember.RememberMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author Beldon.
 */
@RestController
@RequestMapping("/user/")
public class UserRestController {

    @Autowired
    private UserAutoRepo userAutoRepo;

    @Autowired
    private RememberMeService rememberMeService;

    @PostMapping("/register")
    public ResponseMO register(@RequestBody @Valid RegisterMO registerMO) {
        User user = new User();
        user.setAccount(registerMO.getAccount());
        user.setPassword(registerMO.getPassword());
        UserDomain domain = new UserDomain(user);
        if (domain.isExist()) {
            return ResponseUtils.error("用户名已存在");
        }
        domain.register();
        return ResponseUtils.success();
    }

    @PostMapping("/login")
    public ResponseMO login(@RequestBody @Valid LoginMO loginMO, HttpServletRequest request
            , HttpServletResponse response) {
        User user = userAutoRepo.findByAccount(loginMO.getAccount());
        if (user == null) {
            return ResponseUtils.error("用户不存在");
        }
        UserDomain domain = new UserDomain(user);
        if (!domain.checkPassword(loginMO.getPassword())) {
            return ResponseUtils.error("密码错误");
        }
        request.getSession().setAttribute(CommonConstant.Session.USER_ID, user.getId());
        rememberMeService.authenticated(request, response, user);
        return ResponseUtils.success();
    }
}
