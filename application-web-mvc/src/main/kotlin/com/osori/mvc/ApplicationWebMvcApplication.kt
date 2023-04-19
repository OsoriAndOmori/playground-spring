package com.osori.mvc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ApplicationWebMvcApplication

fun main(args: Array<String>) {
    SpringApplication.run(ApplicationWebMvcApplication::class.java, *args)
}