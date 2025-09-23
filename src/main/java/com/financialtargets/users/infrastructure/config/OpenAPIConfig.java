package com.financialtargets.users.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Financial Targets Users Service")
                .version("v1")
                .description("Service responsible for Financial Targets users and authentication")
                .license(new License().name("Apache 2.0")));
    };
}
