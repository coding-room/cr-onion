package cr.onion.service;

import cr.onion.service.impl.PasswordServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Beldon.
 */
public class PasswordServiceTest {

    private PasswordService passwordService = new PasswordServiceImpl();

    @Test
    public void encode() {
        String password = "111111";
        String encodePassword = passwordService.encode(password);
        Assert.assertNotNull(encodePassword);

    }

    @Test
    public void checkPassword() {
        String password = "111111";
        String encodePassword = passwordService.encode(password);
        Assert.assertTrue(passwordService.checkPassword(password, encodePassword));
    }
}