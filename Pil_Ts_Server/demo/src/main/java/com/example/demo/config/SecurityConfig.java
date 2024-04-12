package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 다른 Spring Security 설정들을 적용합니다.
                .cors().and() // CorsFilter를 등록합니다.
                .csrf().disable(); // CSRF 보호 기능을 비활성화합니다.
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        // 허용할 Origin을 설정합니다. 예를 들어, React 애플리케이션이 실행되는 도메인을 추가합니다.
        config.addAllowedOrigin("http://localhost:3000");
        // 허용할 HTTP 메서드를 설정합니다.
        config.addAllowedMethod("*");
        // 허용할 헤더를 설정합니다.
        config.addAllowedHeader("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
