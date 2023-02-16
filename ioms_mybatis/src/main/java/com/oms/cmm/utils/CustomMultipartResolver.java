package com.oms.cmm.utils;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author dext5editor
 * @since 2023. 2. 3.
 * @see
 */

public class CustomMultipartResolver extends CommonsMultipartResolver  {

    /*
     * @see org.springframework.web.multipart.commons.CommonsMultipartResolver#isMultipart(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public boolean isMultipart(HttpServletRequest request) {
        String _url = request.getRequestURL().toString();
        if(_url.indexOf("/dext5editor") > -1 || _url.indexOf("/dext5upload") > -1) {
            return false;
        }
        return super.isMultipart(request);
    }
    
    
}
