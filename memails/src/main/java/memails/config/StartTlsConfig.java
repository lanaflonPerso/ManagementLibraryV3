package memails.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@RefreshScope
@ConfigurationProperties("spring.mail.properties.mail.smtp.startls")
public class StartTlsConfig {
    private boolean enable;
    private boolean required;
}
