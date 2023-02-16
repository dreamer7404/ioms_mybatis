package com.oms;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.multipart.support.MultipartFilter;

import com.oms.cmm.utils.CustomMultipartResolver;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author 안경수
 * @since 2023. 2. 9.
 * @see
 */



@SpringBootApplication
@MapperScan(basePackages = { "com.oms.dao" } )
public class Application {

    private static final Logger logger=LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("Application started");
    }
    
    /**
     * DEXT5 파일업로드 CustomMultipartResolver
     */
    @Bean
    public CustomMultipartResolver customMultipartResolver() {
        CustomMultipartResolver multipart = new CustomMultipartResolver();
        multipart.setMaxUploadSize(3 * 1024 * 1024);
        return multipart;
    }
    /**
     * DEXT5 파일업로드 MultipartFilter
     */
    @Bean
    @Order(0)
    public MultipartFilter multipartFilter() {
        MultipartFilter multipartFilter = new MultipartFilter();
        multipartFilter.setMultipartResolverBeanName("customMultipartResolver");
        return multipartFilter;
    }
}
