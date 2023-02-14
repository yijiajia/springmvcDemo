package com.example.config;


import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = {"com.example"},
        excludeFilters = {@ComponentScan.Filter (type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
@Configuration
@EnableAspectJAutoProxy
@Import(DataSourceConfig.class)
public class ApplicationContextConfig {
}
