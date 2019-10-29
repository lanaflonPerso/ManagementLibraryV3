package mbooks.config;


import mbooks.technical.date.SimpleDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SimpleDate simpleDate(){ return  new SimpleDate(); }




}
