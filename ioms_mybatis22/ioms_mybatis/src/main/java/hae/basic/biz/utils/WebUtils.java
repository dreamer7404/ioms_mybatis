package hae.basic.biz.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import hae.basic.biz.dao.UsrMgmtDAO;
import lombok.RequiredArgsConstructor;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author Windows ≫c¿eAU
 * @since 2023. 2. 8.
 * @see
 */

@RequiredArgsConstructor
@Service("webUtils")
public class WebUtils {
    
    public String getMethod(HttpServletRequest request) {
        return request.getHeader("_method");
    }
    
   
}
