package com.osori.applicationbatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBatchApplication.class, args);
    }

}
