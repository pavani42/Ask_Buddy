package com.hcl.gateway.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {
    
//    @Bean
//    public CorsConfiguration corsConfiguration() {
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.setAllowedOrigins(Arrays.asList("*"));
//        corsConfig.setAllowedHeaders(Arrays.asList("*"));
//        corsConfig.addAllowedMethod(HttpMethod.OPTIONS);
//        corsConfig.addAllowedMethod(HttpMethod.GET);
//        corsConfig.addAllowedMethod(HttpMethod.POST);
//        corsConfig.addAllowedMethod(HttpMethod.PUT);
//        corsConfig.addAllowedMethod(HttpMethod.DELETE);
//        corsConfig.addAllowedMethod(HttpMethod.PATCH);
//        corsConfig.setMaxAge(3600L);
//        return corsConfig;
//    }
    
    @Bean
    public CorsWebFilter corsWebFilter() {
    	CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:3000");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
    
}

