package cr.onion.service.impl;

import cr.onion.common.util.ShaUtils;
import cr.onion.service.PasswordService;
import org.springframework.stereotype.Service;

/**
 * @author Beldon.
 */
@Service
public class PasswordServiceImpl implements PasswordService {
    @Override
    public String encode(String password) {
        return ShaUtils.sha256(password);
    }

    @Override
    public boolean checkPassword(String raw, String encodePass) {
        return encode(raw).equals(encodePass);
    }


}
