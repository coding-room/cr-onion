package cr.onion.web;

import cr.onion.common.ResponseVO;
import cr.onion.common.exception.OnionException;
import cr.onion.common.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Beldon.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 全局异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ResponseVO defaultErrorHandler(Exception e) {
        logger.error(e.getMessage(), e);

        return ResponseUtils.error("系统繁忙，请稍后再试");
    }


    /**
     * 参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class, MissingServletRequestParameterException.class})
    public ResponseVO methodArgumentNotValidException(Exception e) {
        if (logger.isDebugEnabled()) {
            logger.info(e.getMessage(), e);
        }

        //参数缺失异常
        if (e instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException exception = (MissingServletRequestParameterException) e;
            String message = exception.getParameterName() + "不能为空";
            return ResponseUtils.error(message);
        }

        List<ObjectError> allErrors = new ArrayList<>();
        if (e instanceof BindException) {
            allErrors = ((BindException) e).getBindingResult().getAllErrors();
        } else if (e instanceof MethodArgumentNotValidException) {
            allErrors = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
        }
        StringBuffer errors = new StringBuffer();
        for (ObjectError allError : allErrors) {
            errors.append(allError.getDefaultMessage());
            break;
        }
        return ResponseUtils.error(errors.toString());
    }

    /**
     * 请求方法不支持异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseVO methodNotSupported(HttpRequestMethodNotSupportedException e) {
        if (logger.isDebugEnabled()) {
            logger.debug(e.getMessage(), e);
        }
        String message = "不支持" + e.getMethod() + "请求访问";
        return ResponseUtils.error(message);
    }

    /**
     * 请求内容不支持
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseVO httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        if (logger.isDebugEnabled()) {
            logger.debug(e.getMessage(), e);
        }
        String message = "不支持'" + e.getContentType() + "'内容";
        return ResponseUtils.error(message);
    }


    /**
     * 商城自定义异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(OnionException.class)
    public ResponseVO onionException(OnionException exception) {
        return ResponseUtils.error(exception.getMessage());
    }
}
