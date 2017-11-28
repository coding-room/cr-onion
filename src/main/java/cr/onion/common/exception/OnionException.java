package cr.onion.common.exception;

/**
 * @author Beldon.
 */
public class OnionException extends RuntimeException {
    public OnionException(String message) {
        super(message);
    }

    public OnionException(Throwable cause) {
        super(cause);
    }

    public OnionException(String message, Throwable cause) {
        super(message, cause);
    }
}
