package com.microrent.plataforma;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        // Esta es la URL que antes iba en el archivo .properties
        // Pon tu contraseña real aquí
        return MongoClients.create("mongodb+srv://aaroncitto:microrent2026@cluster0.ystttzm.mongodb.net/microrent?retryWrites=true&w=majority");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "microrent");
    }
}