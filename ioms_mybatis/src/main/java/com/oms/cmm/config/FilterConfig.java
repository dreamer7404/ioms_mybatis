package com.oms.cmm.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import able.cloud.core.security.filter.HTMLTagFilter;

/**
 *
 * <pre>
 * &#64;Configuration을 설정한 클래스에 FilterRegistrationBean을 설정하는 함수를 생성한다
 * 적용할 url(setUrlPatterns)과 예외처리할 url(addInitParameter)을 설정한다
 * </pre>
 *
 * @author sunny
 * @since 2020. 9. 4.
 * @see
 */
@Configuration
public class FilterConfig {

    /**
     *
     * hidden http method 를 가능하게 한다
     * 적용할 url을 지정할 수 있다
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean hiddenHttpMethodFilter() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean(new HiddenHttpMethodFilter());
        filterRegBean.setUrlPatterns(Arrays.asList("/*", "/rest/*"));
        return filterRegBean;
    }

    /**
     *
     * html tag filter (자동차 표준 취약점 제거 필터)를 추가한다.
     * 예외 경로를 지정할 수 있다.
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean htmlTagFilter() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean(new HTMLTagFilter());
        filterRegBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegBean.addInitParameter("exclude_urls", "/test/noFilter");

        return filterRegBean;
    }

    /**
     * body 데이터에 대한 별도 처리를 추가할 경우 아래처럼 추가 할 수 있다
     */
    /*
     * @Bean public FilterRegistrationBean requestBodyFilter() {
     * FilterRegistrationBean filterRegBean = new FilterRegistrationBean(new
     * RequestBodyFilter()); filterRegBean.setUrlPatterns(Arrays.asList("/*"));
     * filterRegBean.addInitParameter("exclude_urls",
     * "/test/requestnoFilter, /h2-console/*"); return filterRegBean; }
     */

    /**
     * 서버단 코드 없이 바로 화면으로 리다이렉트 시킬경우 사용한다
     */
    /*
     * @Override public void addViewControllers(ViewControllerRegistry registry)
     * {
     * //<mvc:view-controller path="/index" view-name="index" />
     * registry.addViewController("/").setViewName("forward:/index.jsp"); }
     *
     * public void addArgumentResolvers(List<HandlerMethodArgumentResolver>
     * argumentResolvers) { argumentResolvers.add(new R) }
     */
}
