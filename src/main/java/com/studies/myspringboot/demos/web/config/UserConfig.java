package com.studies.myspringboot.demos.web.config;

import com.studies.myspringboot.demos.web.condition.ConditionalOnClass;
import com.studies.myspringboot.demos.web.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用户配置
 */
@Configuration
public class UserConfig {
    /**
     * 用户Bean
     *
     * @return : 用户实例
     */
    @Bean
    //@Conditional(ClassCondition.class)
    @ConditionalOnClass("org.springframework.data.redis.core.RedisTemplate")
    @ConditionalOnProperty(name = "spring.application.name", havingValue = "my-spring-boot")
    public User user() {
        return new User() {{
            setName("zhangsan");
            setAge(20);
        }};
    }
}
