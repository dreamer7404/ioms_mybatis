package com.oms.cmm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

import com.oms.cmm.security.JwtAuthenticationFilter;
import com.oms.cmm.security.JwtTokenProvider;
import com.oms.service.security.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author 안경수
 * @since 2023. 2. 3.
 * @see
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
//    private final CustomUserDetailsService customUserDetailsService;
    private final JwtTokenProvider jwtTokenProvider;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        
//        http.cors().and().csrf().disable();
//
//        String[] resources = new String[]{
//                "/",
//                "/home",
//                "/pictureCheckCode",
//                "/include/**",
//                "/css/**",
//                "/icons/**",
//                "/images/**",
//                "/js/**",
//                "/resources/**",
//                "/layer/**",
//                "/static/**",
//                "/js/**",
//                "/img/**",
//                "/webapp/**",
//                "/api/**"
//        };
//
//        http.authorizeRequests()
//            .antMatchers(resources)
//            .permitAll();
//        
//        // dext5 때문에.
//        http.headers().frameOptions().disable();
//        
//        
//    }
    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService);
//    }

    
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        String[] resources = new String[]{
                "/",
                "/api/**"
        };
//        String role = "USER";
        
        http
        .headers().frameOptions().disable() // dext5때문에 필요.
        
        .and()
        .httpBasic().disable() // Http basic Auth 기반으로 로그인 인증창사용
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        
        .and()
        .authorizeHttpRequests().antMatchers(resources).permitAll()
//        .anyRequest().hasRole(role)
        
        // UsernamePasswordAuthenticationFilter 에 도달하기 전에 커스텀한 필터를 먼저 동작시킴
//        .and()
//        .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), 
//                UsernamePasswordAuthenticationFilter.class)
        
        ;
    
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.httpFirewall(defaultHttpFirewall())
        .ignoring().antMatchers("/swagger-ui/**", "/v3/api-docs/**");  // pass swagger
    }
    
    
    /*
     * 
     * AuthenticationManager
     */
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

   
    
    /*
     * 더블슬레시 허용 ("//")
     */
    @Bean
    public HttpFirewall defaultHttpFirewall() {
        return new DefaultHttpFirewall();
    }
    
    /*
     * PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
    
    
    

    
}
