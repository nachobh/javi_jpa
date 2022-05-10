package com.javi.main;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.any;

@EnableCaching
@EnableSwagger2
@SpringBootConfiguration
@EnableTransactionManagement
@Import(SecurityConfiguration.class)
@EntityScan(basePackages = {"com.javi.entity"})
@EnableJpaRepositories(basePackages = {"com.javi.repository"})
@ComponentScan(basePackages = {"com.javi.controller", "com.javi.service.impl"})
public class AppConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.javi.controller"))
                .paths(any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Javi REST API",
                "REST API for Javi.",
                "API TOS",
                "https://www.termsfeed.com/public/uploads/2019/04/terms-of-service-template.pdf",
                new Contact("Ignacio Benito Herrero", "https://www.linkedin.com/nachobh",
                        "ibenitoherrero@gmail.com.com"),
                "License of API", "https://www.gnu.org/licenses/license-list.es.html",
                Collections.emptyList());
    }
}
