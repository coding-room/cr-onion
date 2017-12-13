package cr.onion.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface VerifyCodeService {

    /**
     * 生成验证码
     * @param request
     * @param response
     * @throws Exception
     */
    void generate(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
