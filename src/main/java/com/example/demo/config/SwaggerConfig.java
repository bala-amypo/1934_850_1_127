package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Digital Complaint Prioritization Engine")
                        .version("1.0")
                        .description("API documentation for the complaint prioritization system.\n"
                                     + "Access the Swagger UI at: https://9612.pro604cr.amypo.ai/swagger-ui/index.html"));
    }
}
