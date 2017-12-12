package cr.onion.common.util;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
@Component
public class VerifyCodeUtils {

    private static DefaultKaptcha defaultKaptcha;

    private static String sessionKeyValue;

    @Autowired
    public VerifyCodeUtils(DefaultKaptcha defaultKaptcha) {
        this.defaultKaptcha = defaultKaptcha;
        this.sessionKeyValue = defaultKaptcha.getConfig().getSessionKey();
    }

    public static void generateVerifyCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
}
