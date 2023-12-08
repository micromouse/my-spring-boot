package com.studies.myspringboot;

import com.studies.myspringboot.demos.web.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * my-spring-boot应用
 */
@SpringBootApplication
public class MySpringBootApplication {
    /**
     * 应用入口
     *
     * @param args ： 启动参数
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MySpringBootApplication.class, args);

        Object applicationProperties = context.getBean(ApplicationProperties.class);
        System.out.printf("应用程序配置属性:%n{%s}%n", applicationProperties);

        //获取bean，redisTemplate
        Object redisTemplate = context.getBean("redisTemplate");
        System.out.printf("redisTemplate: %s%n", redisTemplate);

        //获取bean，user
        Object user = context.getBean("user");
        System.out.printf("User is : %n%s%n", user);
    }

}
