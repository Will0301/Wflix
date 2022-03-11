package com.wflix.swagger;

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
    public Docket swagger(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(info());

    }

    public ApiInfo info(){
        return new ApiInfoBuilder()
                .title("Employee API")
                .description("API that simulates an online rental company")
                .version("1.0.0")
                .contact(new Contact("Willian",
                        "https://www.linkedin.com/in/willian-weyh/",
                        "willian.f.w@hotmail.com"))
                .license("Terms of service")
                .licenseUrl("http://localhost:63342/Wflix/Wflix.main/com/wflix/view/terms/TermsOfService.html?_ijt=afopoio7akritao0uabjr9ddug&_ij_reload=RELOAD_ON_SAVE")
                .build();
    }
}