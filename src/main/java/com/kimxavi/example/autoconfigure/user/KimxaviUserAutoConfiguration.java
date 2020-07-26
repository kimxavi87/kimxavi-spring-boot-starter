package com.kimxavi.example.autoconfigure.user;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(
        proxyBeanMethods = false
)
@EnableConfigurationProperties(KimxaviUserProperties.class)
public class KimxaviUserAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public KimxaviUser kimxaviUser(KimxaviUserProperties kimxaviUserProperties) {
        KimxaviUser kimxaviUser = new KimxaviUser();
        kimxaviUser.setAge(kimxaviUserProperties.getAge());
        kimxaviUser.setName(kimxaviUserProperties.getName());
        return kimxaviUser;
    }

}
