package com.github.wenhao.config;

import com.github.wenhao.spring.LoggingRequestInterceptor;
import com.google.common.collect.ImmutableList;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration
{
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        restTemplate.setInterceptors(ImmutableList.of(new LoggingRequestInterceptor()));
        return restTemplate;
    }
}
