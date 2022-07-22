package com.osori.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class ApplicaionWebReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicaionWebReactiveApplication.class, args);
    }

}
