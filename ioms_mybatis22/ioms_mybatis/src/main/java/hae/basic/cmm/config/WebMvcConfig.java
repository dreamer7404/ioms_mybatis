package hae.basic.cmm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author Windows ≫c¿eAU
 * @since 2023. 2. 6.
 * @see
 */



@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    
    @Value("${upload-image-path.url}") 
    private String uploadImagePath; 
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploadImages/**")
//                .addResourceLocations("file:/DATA/video/"); //리눅스 root에서 시작하는 폴더 경로
//                  .addResourceLocations("file:///D:/temp/"); //윈도우즈
        .addResourceLocations("file:///"+uploadImagePath); 
    }

}
