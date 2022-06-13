package com.llamitatec.backend.service.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("serviceMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ServiceMapper userMapper(){
        return new ServiceMapper();
    }
}
