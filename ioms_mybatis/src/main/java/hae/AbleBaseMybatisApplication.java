package hae;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.multipart.support.MultipartFilter;

import hae.resolver.CustomMultipartResolver;

@SpringBootApplication
@MapperScan(basePackages = { "hae.basic.board.dao", "hae.basic.biz.dao" } )
public class AbleBaseMybatisApplication {

	private static final Logger logger=LoggerFactory.getLogger(AbleBaseMybatisApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AbleBaseMybatisApplication.class, args);
		logger.info("Application started");
	}
	
	@Bean
    public CustomMultipartResolver customMultipartResolver() {
        CustomMultipartResolver multipart = new CustomMultipartResolver();
        multipart.setMaxUploadSize(3 * 1024 * 1024);
        return multipart;
    }
    
    @Bean
    @Order(0)
    public MultipartFilter multipartFilter() {
        MultipartFilter multipartFilter = new MultipartFilter();
        multipartFilter.setMultipartResolverBeanName("customMultipartResolver");
        return multipartFilter;
    }
}
