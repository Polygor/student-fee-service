package com.rakbank.paymentservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Payment Service API")
                        .description("API documentation for the Payment Service")
                        .version("1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("Payment Service Documentation")
                        .url("http://localhost:8082/swagger-ui.html"));
    }
}
