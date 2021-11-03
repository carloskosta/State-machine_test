package com.carlosreydacosta.statemachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class StateMachineApplication {

    public static void main(final String[] args) {
        SpringApplication.run(StateMachineApplication.class, args);
    }

}