package com.oms.cmm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author Windows ≫c¿eAU
 * @since 2023. 2. 14.
 * @see
 */

public class JwtAuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        
        
        
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
    
    
    

}
