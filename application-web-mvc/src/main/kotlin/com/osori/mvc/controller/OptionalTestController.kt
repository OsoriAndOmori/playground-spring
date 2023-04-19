package com.osori.mvc.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class OptionalTestController {

    @GetMapping("/optional/test")
    fun test1(@RequestParam(required = false) sout: String?): Optional<String> {
        return Optional.ofNullable(sout)
    }
}