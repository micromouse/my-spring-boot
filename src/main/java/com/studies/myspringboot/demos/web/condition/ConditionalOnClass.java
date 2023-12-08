package com.studies.myspringboot.demos.web.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 自定义类注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(ClassCondition.class)
public @interface ConditionalOnClass {
    /**
     * 获得值集合
     * @return : 值集合
     */
    String[] value();
}
