package com.anthony.conceal.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Anthony on 2016/12/28.
 */
@Configuration
public class SpringMybatisConfig {
@Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer()
{
    PropertyPlaceholderConfigurer propertyPlaceholderConfigurer=new PropertyPlaceholderConfigurer();
//    propertyPlaceholderConfigurer.setLocation();
    return propertyPlaceholderConfigurer;
}
}
