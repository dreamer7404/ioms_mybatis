package com.oms.cmm.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.oms.cmm.security.HtmlCharacterEscapes;

/**
 *
 * <pre>
 * Config 클래스에 MappingJackson2HttpMessageConverter의 objectMapper를 설정하는 로직을 추가한다
 * 단, 예외 url을 설정할 수 있다.
 * 화면으로 부터 넘어오는 파라메터를 변형한다
 * </pre>
 *
 * @author sunny
 * @since 2020. 9. 4.
 * @see
 */
public class HttpMessageConverterConfig  implements WebMvcConfigurer{
	private static Logger log = LoggerFactory.getLogger(HttpMessageConverterConfig.class);

	/**
	 * 경로를 설정한다
	 * setRemoveSemicolonContent 는 경로를 파라메터로 사용할때 구분자를 허용하기 위해 false로 설정한다
	 * 사용하지 않을경우 주석처리해도 된다
	 */
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		urlPathHelper.setRemoveSemicolonContent(false);
		configurer.setUrlPathHelper(urlPathHelper);
	}

	/**
	 * messageconverter를 등록한다
	 */
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(escapingConverter());
        //super.addDefaultHttpMessageConverters(converters);  // default Http Message Converter  추가

    }

	/**
	 *
	 * 메세지를 변형하기 의해 컴버터를 만든다.
	 * 아래 함수는 json 데이터에 대해 일괄 변형하는 로직을 추가한 것이다
	 * 경로를 우회 할 수 있는것을 없다
	 *
	 * @return
	 */
    @Bean
    public HttpMessageConverter escapingConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.getFactory().setCharacterEscapes(new HtmlCharacterEscapes());

        MappingJackson2HttpMessageConverter escapingConverter =
                new MappingJackson2HttpMessageConverter();
        escapingConverter.setObjectMapper(objectMapper);

        return escapingConverter;
    }
}
