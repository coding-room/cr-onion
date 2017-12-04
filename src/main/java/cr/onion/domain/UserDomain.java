package cr.onion.domain;

import cr.onion.entity.User;
import cr.onion.repo.UserAutoRepo;
import cr.onion.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author Beldon.
 */
@Configurable
public class UserDomain {
    @Autowired
    private UserAutoRepo userAutoRepo;

    @Autowired
    private PasswordService passwordService;

    private final User entity;

    public UserDomain(User entity) {
        this.entity = entity;
    }

    public boolean checkPassword(String rawPassword) {
        return passwordService.checkPassword(rawPassword, entity.getPassword());
    }


    /**
     * 注册
     */
    public void register() {
        entity.setPassword(passwordService.encode(entity.getPassword()));
        entity.setNickname(entity.getAccount());
        userAutoRepo.save(entity);
    }

    public boolean isExist() {
        return userAutoRepo.findByAccount(entity.getAccount()) != null;
    }

    public boolean isPassword(String rawPassword) {
        return passwordService.checkPassword(rawPassword, entity.getPassword());
    }
}
