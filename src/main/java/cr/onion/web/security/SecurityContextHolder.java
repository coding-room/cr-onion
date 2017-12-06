package cr.onion.web.security;

/**
 * @author Beldon
 */
public class SecurityContextHolder {

    private static final ThreadLocal<Authentication> contextHolder = new ThreadLocal<Authentication>();

    public static Authentication getAuthentication(){
        return contextHolder.get();
    }

    public static void setAuthentication(Authentication authentication){
        contextHolder.set(authentication);
    }

    public static void removeAuthentication() {
        contextHolder.remove();
    }
}
