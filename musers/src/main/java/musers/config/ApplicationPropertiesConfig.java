package musers.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("microservice.config-user")
@Getter
@Setter
@RefreshScope
public class ApplicationPropertiesConfig {
    private boolean active;
    private String role;
}
