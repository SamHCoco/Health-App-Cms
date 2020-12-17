package com.samhcoco.healthapp.cms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
