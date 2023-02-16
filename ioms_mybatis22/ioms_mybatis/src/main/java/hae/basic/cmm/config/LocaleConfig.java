package hae.basic.cmm.config;

import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import able.cloud.core.message.AbleReloadableResourceBundleMessageSource;
import able.cloud.core.message.MessageUtils;

/**
 * <pre>
 * 다국어 메세지 처리를 위한 Configuration
 * </pre>
 *
 * @authors sgyoon
 * @since 2020. 9. 3.
 * @see
 */
@Configuration
public class LocaleConfig implements WebMvcConfigurer{

    private DataSource dataSource;
    public LocaleConfig(DataSource dataSource) {
    	this.dataSource = dataSource;
    }

    /**
     * 메세지 처리를 위한 Bean 등록 - message.properties를 불러온다.
     * message.properties에서 변경된 메시지를 바로 반영한다.
     *
	 * @param
     * @return
     * @throws
     */
    @Bean
    public AbleReloadableResourceBundleMessageSource messageSource() {

    	AbleReloadableResourceBundleMessageSource source = new AbleReloadableResourceBundleMessageSource();

        // 메세지 프로퍼티파일의 위치와 이름을 지정한다.
    	source.setBasenames("classpath:/messages/messages*");

        // 기본 인코딩을 지정한다.
        source.setDefaultEncoding("UTF-8");
        // 프로퍼티 파일의 변경을 감지할 시간 간격을 지정한다.
        source.setCacheSeconds(60);

        return source;
    }

    /**
     * 메세지 처리를 위한 Bean 등록 - DB에서 메세지를 불러온다.
     * DB에 변경된 메시지를 바로 반영
     *
	 * @param
     * @return
     * @throws
     */
    /*
    @Bean
    public AbleReloadableResourceBundleMessageSource messageSource() {

    	AbleReloadableResourceBundleMessageSource source = new AbleReloadableResourceBundleMessageSource();

        // DB연동을 통한 메시지를 관리 할 경우 db:테이블명
        source.setBasenames("db:ABLE_MSG","classpath:/messages/messages*");

        // 기본 인코딩을 지정한다.
        source.setDefaultEncoding("UTF-8");
        // 프로퍼티 파일의 변경을 감지할 시간 간격을 지정한다.
        source.setCacheSeconds(60);

        // DB 연동을 위한 DAO 서비스 설정
        MessageDBResourceDAO messageDBResourceDAO = new MessageDBResourceDAO();
        messageDBResourceDAO.setDataSource(dataSource);
        messageDBResourceDAO.setSqlMsgTimestamp(
        		"SELECT MAX(MSG_TIMESTAMP) lastmodify FROM ABLE_MSG WHERE MSG_LANGUAGE = :lang ");
        messageDBResourceDAO.setSqlMsgProperty(
        		"SELECT MSG_KEY key, MSG_TEXT value, MSG_LANGUAGE language, " +
        				" MSG_TIMESTAMP lastmodify" +
        				" FROM ABLE_MSG WHERE MSG_LANGUAGE = :locale ");
        source.setMessageDBResourceDAO(messageDBResourceDAO);

        return source;
    }
    */

    /**
     * 변경된 언어 정보를 기억할 로케일 리졸버를 생성한다.
     * 여기서는 세션에 저장하는 방식을 사용한다.
     *
	 * @param
     * @return
     * @throws
     */
    /*
    @Bean
    public SessionLocaleResolver localeResolver() {
    	SessionLocaleResolver resolver = new SessionLocaleResolver();
    	resolver.setDefaultLocale(Locale.KOREA);
    	resolver.setLocaleAttributeName("lang");
        return new SessionLocaleResolver();
    }
    */

    /**
     * Bean Validation 사용을 위한 Bean 등록
     * 유효성 검사시 MessageSource의 데이터를 바인딩 한다.
     *
	 * @param
     * @return
     * @throws
     */
    @Bean
	public LocalValidatorFactoryBean getValidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

    /**
     * 변경된 언어 정보를 기억할 로케일 리졸버를 생성한다.
     * 여기서는 쿠키에 저장하는 방식을 사용한다.
	 * @param
     * @return
     * @throws
     */
    @Bean
    public LocaleResolver localeResolver() {
    	CookieLocaleResolver resolver = new CookieLocaleResolver();
    	resolver.setDefaultLocale(Locale.KOREA);
    	resolver.setCookieName("lang");
    	return resolver;
    }

    /**
     * MessageSource를 통해 메세지를 가져올 수 있도록 Bean 등록

     *
	 * @param
     * @return
     * @throws
     */
    @Bean
    public MessageSourceAccessor messageSourceAccessor() {
    	return new MessageSourceAccessor(messageSource());
    }

    /**
     * MessageUtils 사용을 위한 Bean 등록
     * MessageSourceAccessor을 통해 메세지를 가져올 수 있도록 Bean 등록
     *
	 * @param
     * @return
     * @throws
     */
    @Bean
    public MessageUtils messageUtils() {
    	MessageUtils messageUtils = new MessageUtils();
    	messageUtils.setMessageSourceAccessor(messageSourceAccessor());
    	return messageUtils;
    }

    /**
     * 언어 변경을 위한 인터셉터를 생성한다.
     *
	 * @param
     * @return
     * @throws
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    /**
     * 인터셉터를 등록한다.
     *
	 * @param registry InterceptorRegistry
     * @return
     * @throws
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
