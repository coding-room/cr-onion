package cr.onion.common.util;

import cr.onion.common.ResponseMO;

/**
 * @author Beldon.
 */
public class ResponseUtils {

    public static ResponseMO success() {
        return response(0, "success", null);
    }

    public static ResponseMO success(String msg) {
        return response(0, msg, null);
    }


    public static ResponseMO success(String msg, Object data) {
        return response(0, msg, data);
    }

    public static ResponseMO error(String msg) {
        return response(1, msg, null);
    }

    public static ResponseMO response(int code, String msg, Object data) {
        ResponseMO responseMO = new ResponseMO();
        responseMO.setCode(code);
        responseMO.setMsg(msg);
        responseMO.setData(data);
        return responseMO;
    }
}
