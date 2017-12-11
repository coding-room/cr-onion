package cr.onion.web.variable;


import cr.onion.common.BaseVariable;
import cr.onion.common.util.RelativeDateFormat;
import cr.onion.entity.Topic;
import cr.onion.entity.User;
import cr.onion.repo.TopicAutoRepo;
import cr.onion.repo.UserAutoRepo;
import cr.onion.web.controller.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Beldon.
 */

@Component
public class OnionVariable extends BaseVariable {

    @Autowired
    private TopicAutoRepo topicAutoRepo;
    @Autowired
    private UserAutoRepo userAutoRepo;

    @Override
    protected String getName() {
        return "onion";
    }

    /**
     * 格式化时间
     *
     * @param date
     * @return
     */
    public String formatData(Date date) {
        return RelativeDateFormat.format(date);
    }

    public UserVO currentUser() {
        return user(currentUserId());
    }

    public UserVO user(String userId) {
        User user = userAutoRepo.findOne(userId);
        UserVO userMO = new UserVO();
        if (user != null) {
            BeanUtils.copyProperties(user, userMO);
        }
        return userMO;
    }

    public Topic topic(String id) {
        return topicAutoRepo.findOne(id);
    }
}
