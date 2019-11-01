package com.library.config;

import com.library.technical.books.BooksFunction;
import com.library.technical.date.SimpleDate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public SimpleDate simpleDate(){ return  new SimpleDate(); }

    @Bean
    public BooksFunction booksFunction() {
        return new BooksFunction() {};
    }



}
