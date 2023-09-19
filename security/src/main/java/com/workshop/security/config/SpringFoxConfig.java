package com.workshop.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                //.apis(RequestHandlerSelectors.basePackage("com.finalProject.currencyConversion.web.controller"))
                .paths(PathSelectors.any())
                .build();
                //.apiInfo(metaData());

    }

//    private ApiInfo metaData() {
//        return new ApiInfoBuilder()
//                .title("Spring Boot REST API")
//                .description("\"Spring Boot REST API for Security test\"")
//                .version("2.7.15")
//                .license("Apache License Version 2.0")
//                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
//                .contact(new Contact("John Thompson", "http://springframework.guru/about/", "john@springfrmework.guru"))
//                .build();
//    }
}
