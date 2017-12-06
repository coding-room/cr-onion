package cr.onion.web.variable;

import cr.onion.common.BaseVariable;
import cr.onion.entity.User;
import cr.onion.repo.UserAutoRepo;
import cr.onion.web.controller.mo.UserMO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author Beldon.
 */
@Component
public class UserVariable extends BaseVariable {
    @Autowired
    private UserAutoRepo userAutoRepo;
    @Override
    protected String getName() {
        return "user";
    }

    public String getNickname() {
        return nickName(currentUserId());
    }

    public String nickName(String userId) {
        if (StringUtils.hasText(userId)) {
            User user = userAutoRepo.findOne(userId);
            if (user != null) {
                return user.getNickname();
            }
        }
        return "";
    }

    public UserMO currentUser() {
        return user(currentUserId());
    }

    public UserMO user(String userId) {
        User user = userAutoRepo.findOne(userId);
        UserMO userMO = new UserMO();
        if (user != null) {
            BeanUtils.copyProperties(user, userMO);
        }
        return userMO;
    }
}
