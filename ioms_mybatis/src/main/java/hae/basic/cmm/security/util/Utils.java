package hae.basic.cmm.security.util;

import java.util.List;
import java.util.Map;

import lombok.experimental.UtilityClass;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author Windows ≫c¿eAU
 * @since 2023. 1. 19.
 * @see
 */

@UtilityClass
public class Utils {
    
    public static boolean isNull(Object obj) {
        if(obj == null) return true;
        if ((obj instanceof String) && (((String)obj).trim().length() == 0)) { return true; }
        if (obj instanceof Map) { return ((Map<?, ?>) obj).isEmpty(); }
        if (obj instanceof Map) { return ((Map<?, ?>)obj).isEmpty(); } 
        if (obj instanceof List) { return ((List<?>)obj).isEmpty(); }
        if (obj instanceof Object[]) { return (((Object[])obj).length == 0); }
        return false;
    }

}
