package com.atividadeextensionista.config.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigCors {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")  // Allow CORS for all API endpoints
                        .allowedOrigins("http://localhost:4200")  // Allow the frontend to access
                        .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow specific HTTP methods
                        .allowedHeaders("*")  // Allow any headers
                        .allowCredentials(true);  // Allow credentials if needed (cookies, etc.)
            }
        };
    }
}
