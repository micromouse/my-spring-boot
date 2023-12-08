package com.studies.myspringboot.demos.web.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;
import java.util.Objects;

/**
 * 类条件
 */
public class ClassCondition implements Condition {
    /**
     * 条件匹配
     *
     * @param context  ： 条件上下文
     * @param metadata ：注解类型元数据
     * @return ： 是否符合条件
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean flag = true;

        try {
            String conditionalOnClassName = ConditionalOnClass.class.getName();
            Map<String, Object> attributes = Objects.requireNonNull(metadata.getAnnotationAttributes(conditionalOnClassName));

            //确保每个类都加载了
            String[] values = (String[]) attributes.get("value");
            for (String value : values) {
                Class.forName(value);
            }
        } catch (ClassNotFoundException cex) {
            flag = false;
        }

        return flag;
    }
}
