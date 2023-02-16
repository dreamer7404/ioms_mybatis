package com.oms.cmm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.oms.cmm.interceptor.JwtAuthInterceptor;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author 안경수
 * @since 2023. 2. 6.
 * @see
 */



@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    
    @Value("${upload-image-path.url}") 
    private String uploadImagePath; 
    
    @Value("${download-file-path.url}") 
    private String downloadFilePath; 
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*
         * 에디터의 파일업로드
         */
        registry.addResourceHandler("/uploadImages/**")
//                .addResourceLocations("file:/DATA/video/"); //리눅스 root에서 시작하는 폴더 경로
//                  .addResourceLocations("file:///D:/temp/"); //윈도우즈
            .addResourceLocations("file:///"+uploadImagePath);

        /*
         * 파일업로더
         */
        registry.addResourceHandler("/downloadFiles/**")
            .addResourceLocations("file:///"+downloadFilePath);
        
        
        
        

    }

   
    /*
     * addInterceptors
     */
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtAuthInterceptor())

        .addPathPatterns("/**")
            .excludePathPatterns("/api/auth/**")
        ;
            
    }
    
    

}
