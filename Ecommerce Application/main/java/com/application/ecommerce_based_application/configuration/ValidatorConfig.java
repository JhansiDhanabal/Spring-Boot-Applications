package com.application.ecommerce_based_application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Configuration
public class ValidatorConfig {
    @Bean
    public Validator validator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }
}
