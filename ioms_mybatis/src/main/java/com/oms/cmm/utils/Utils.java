package com.oms.cmm.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.experimental.UtilityClass;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author 안경수
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
    
    public static String getMethod(HttpServletRequest request) {
        return request.getHeader("_method");
    }

}
