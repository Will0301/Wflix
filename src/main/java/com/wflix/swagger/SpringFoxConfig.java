package com.wflix.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket swagger(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(info());

    }

    public ApiInfo info(){
        return new ApiInfo("Wflix movies",
                "API that simulates an online rental company",
                "1.0",
                "Terms of service",
                new Contact("Willian Weyh", "https://www.linkedin.com/in/willian-weyh/",
                        "willian.f.w@hotmail.com").toString(),
                "License",
                "Http://license-wflix.com"
        );
    }
}