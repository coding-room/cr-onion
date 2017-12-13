package cr.onion.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import cr.onion.service.VerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * 验证码工具类
 *
 * @Author TDKnight
 * @Date 2017/12/11
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService{

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    private final String sessionKeyValue = defaultKaptcha.getConfig().getSessionKey();

    @Override
    public void generate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0L);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = defaultKaptcha.createText();
        request.getSession().setAttribute(sessionKeyValue, capText);
        BufferedImage bi = defaultKaptcha.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
    }

    @Override
    public Boolean checkVerifyCode(HttpServletRequest request, String verifyCode) {
        String rightVerifyCode = (String) request.getSession().getAttribute(sessionKeyValue);
        if (rightVerifyCode == null) return false;
        return rightVerifyCode.equals(verifyCode);
    }
}
