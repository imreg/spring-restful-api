package com.job.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.job.posts.feed.CompanyJsonData;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Value("${my.api.host}")
    private String apiHost;

    @Value("${my.api.endpoint}")
    private String apiEndpoint;

    private static final Logger log = LoggerFactory.getLogger(CorsConfig.class);

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        log.info("Configuring CORS with host: {} and endpoint: {}", apiHost, apiEndpoint);
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping(apiEndpoint)
                        .allowedOrigins(apiHost)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}