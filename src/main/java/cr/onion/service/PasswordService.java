package cr.onion.service;

/**
 * @author Beldon.
 */
public interface PasswordService {

    /**
     * 加密密码
     *
     * @param password
     * @return
     */
    String encode(String password);

    /**
     * 检查密码
     *
     * @param raw 源密码
     * @param encodePass 加密的密码
     * @return
     */
    boolean checkPassword(String raw, String encodePass);

}
