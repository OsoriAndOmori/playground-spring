package com.osori.servlet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2Controller {
    @GetMapping("/test2")
    public String s() {
        return "test2";
    }
}
