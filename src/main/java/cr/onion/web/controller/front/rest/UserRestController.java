package cr.onion.web.controller.front.rest;

import cr.onion.common.CommonConstant;
import cr.onion.common.ResponseVO;
import cr.onion.common.util.ResponseUtils;
import cr.onion.domain.UserDomain;
import cr.onion.entity.User;
import cr.onion.repo.UserAutoRepo;
import cr.onion.web.controller.vo.LoginVO;
import cr.onion.web.controller.vo.RegisterVO;
import cr.onion.web.security.SecurityContextHolder;
import cr.onion.web.security.remember.RememberMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseVO register(@RequestBody @Valid RegisterVO registerVO) {
        User user = new User();
        user.setAccount(registerVO.getAccount());
        user.setPassword(registerVO.getPassword());
        UserDomain domain = new UserDomain(user);
        if (domain.isExist()) {
            return ResponseUtils.error("用户名已存在");
        }
        domain.register();
        return ResponseUtils.success();
    }

    @PostMapping("/login")
    public ResponseVO login(@RequestBody @Valid LoginVO loginVO, HttpServletRequest request
            , HttpServletResponse response) {
        User user = userAutoRepo.findByAccount(loginVO.getAccount());
        if (user == null) {
            return ResponseUtils.error("用户不存在");
        }
        UserDomain domain = new UserDomain(user);
        if (!domain.checkPassword(loginVO.getPassword())) {
            return ResponseUtils.error("密码错误");
        }
        request.getSession().setAttribute(CommonConstant.Session.USER_ID, user.getId());
        rememberMeService.loginSuccess(request, response, user);
        return ResponseUtils.success();
    }

    @PostMapping("/logout")
    public ResponseVO logout(HttpServletRequest request, HttpServletResponse response) {
        rememberMeService.logout(request, response);
        SecurityContextHolder.removeAuthentication();
        request.getSession().removeAttribute(CommonConstant.Session.AUTHENTICATION);
        return ResponseUtils.success();
    }
}
