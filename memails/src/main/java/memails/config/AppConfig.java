package memails.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    /**
     * Permet l'utilisation du DTO
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
