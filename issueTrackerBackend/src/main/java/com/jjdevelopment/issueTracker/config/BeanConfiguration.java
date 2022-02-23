package com.jjdevelopment.issueTracker.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public DozerBeanMapper beanMapper(){
        return new DozerBeanMapper();
    }
}
