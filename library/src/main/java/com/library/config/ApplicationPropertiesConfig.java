package com.library.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("library.config")
@Getter
@Setter
public class ApplicationPropertiesConfig {

    private String coverUse;
    private Long carousselInterval;
    private String coverPath;
    private Long renewalNumber;

}
