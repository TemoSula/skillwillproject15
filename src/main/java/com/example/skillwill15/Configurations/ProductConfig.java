package com.example.skillwill15.Configurations;

import com.example.skillwill15.Models.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    @Qualifier("technique-items")
    public Product computer() {
        return new Computer();
    }

    @Bean
    @Qualifier("household-items")
    public Product table() {
        return new Table();
    }

    @Bean
    @Qualifier("accessories")
    public Product ring() {
        return new Ring();
    }

    @Bean
    @Qualifier("communication-items")
    public Product phone() {
        return new Phone();
    }
}
