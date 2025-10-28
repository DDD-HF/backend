package com.example.dddbackend.common.configuration;

import com.example.domain.common.annotation.DomainService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {
                "com.example.domain.member",
        },
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {DomainService.class})}
)
public class DomainConfiguration {
}
