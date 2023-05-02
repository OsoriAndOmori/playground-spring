package com.osori.mvc.controller

import com.osori.mvc.service.BeanNameTestService
import org.springframework.context.ApplicationContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BeanNameTestController (private val app: ApplicationContext, private val beanNameTestService: BeanNameTestService) {
    @GetMapping("/bean/proxy-test")
    fun index(): String {
        println(app.getBean("beanNameTestService"))
        println(app.getBean("accountService"))
        return beanNameTestService.index()
    }
}