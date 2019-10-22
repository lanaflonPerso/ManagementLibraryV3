package com.mfile.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("microservice.config")
@Getter
@Setter
public class ApplicationPropertiesConfig {

    private String coverUse;
    private String coverPath;
}
