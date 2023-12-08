package com.studies.myspringboot.demos.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.application")
@Data
public class ApplicationProperties {
    private String name;
    private String title;
    private String version;
    private String author;
}
