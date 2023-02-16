package com.oms.cmm.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author 안경수
 * @since 2023. 2. 9.
 * @see
 */
@OpenAPIDefinition(
        info = @Info(
                title = "OMS API 명세서",
                description = "OMS API 명세서 설명",
                version = "v1"
        )
)
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig  {
    
    @Bean
    public GroupedOpenApi groupedOpenApi() {
        String[] paths = {"/**"};
 
        return GroupedOpenApi.builder()
                .group("api")
                .pathsToMatch("/**")
                .build();
    }
}
