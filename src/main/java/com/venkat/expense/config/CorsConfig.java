package com.venkat.expense.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfig {
    private final long MAX_AGE_SECONDS = 3600;
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").
                        allowedMethods("HEAD","OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE").
                        allowedOrigins("*").
                        allowedHeaders("*").
                        maxAge(MAX_AGE_SECONDS);
            }
        };
    }

}