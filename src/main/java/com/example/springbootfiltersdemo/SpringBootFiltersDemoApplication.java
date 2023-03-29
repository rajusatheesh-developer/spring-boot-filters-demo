package com.example.springbootfiltersdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Properties;

@SpringBootApplication
@EnableSwagger2
@Configuration
public class SpringBootFiltersDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFiltersDemoApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()// for all EndPoints
                .build();                   // create object
    }


    @Bean
    @Primary
    public DefaultHandlerExceptionResolver defaultHandlerExceptionResolver() {
        return new CustomExceptionHandlerResolver();
    }

    @Bean(name = "simpleMappingExceptionResolver")
    public SwitchableSimpleMappingExceptionResolver createSwitchableSimpleMappingExceptionResolver() {
       // logger.info("Creating SwitchableSimpleMappingExceptionResolver in disabled mode");

        // Turn exception resolving off to start
        boolean initialState = false;

        SwitchableSimpleMappingExceptionResolver resolver = new SwitchableSimpleMappingExceptionResolver(
                initialState);

        Properties mappings = new Properties();
        mappings.setProperty("HttpMediaTypeNotAcceptableException", "databaseException");
       // mappings.setProperty("HttpMediaTypeNotAcceptableException", "creditCardError");

        resolver.setExceptionMappings(mappings); // None by default
        resolver.setExceptionAttribute("ex"); // Default is "exception"
        resolver.setWarnLogCategory("demo1.ExceptionLogger"); // No default

        // See comment in ExceptionConfiguration
        resolver.setDefaultErrorView("defaultErrorPage");
        return resolver;
    }

}

