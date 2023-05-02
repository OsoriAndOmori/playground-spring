package com.osori.mvc.playground.springcore.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component


@Aspect
@Component
class AopCounter {
    @Around("execution(* com.osori.mvc.service.BeanNameTestService.index())")
    fun log(pointcut: ProceedingJoinPoint):Any {
        println("CALLED")
        return pointcut.proceed()
    }
}