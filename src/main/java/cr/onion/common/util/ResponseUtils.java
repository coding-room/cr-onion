package cr.onion.common.util;

import cr.onion.common.ResponseVO;

/**
 * @author Beldon.
 */
public class ResponseUtils {

    public static ResponseVO success() {
        return response(0, "success", null);
    }

    public static ResponseVO success(String msg) {
        return response(0, msg, null);
    }


    public static ResponseVO success(String msg, Object data) {
        return response(0, msg, data);
    }

    public static ResponseVO error(String msg) {
        return response(1, msg, null);
    }

    public static ResponseVO response(int code, String msg, Object data) {
        ResponseVO responseMO = new ResponseVO();
        responseMO.setCode(code);
        responseMO.setMsg(msg);
        responseMO.setData(data);
        return responseMO;
    }
}
