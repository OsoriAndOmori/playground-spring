package com.osori.mvc.service

import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

@Service
class BeanNameTestService (private val app: ApplicationContext){
    fun index(): String {
        println(app.getBean("beanNameTestController"))
        println(app.getBean("formController"))
        return "test"
    }
}
