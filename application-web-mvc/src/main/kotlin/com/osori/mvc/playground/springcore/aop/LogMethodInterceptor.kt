package com.osori.mvc.playground.springcore.aop

import com.osori.mvc.playground.springcore.annotation.앞뒤로로그찍을래
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.cglib.proxy.MethodInterceptor
import org.springframework.cglib.proxy.MethodProxy
import java.lang.reflect.Method

class LogMethodInterceptor() : MethodInterceptor {
    private var log: Log = LogFactory.getLog(LogMethodInterceptor::class.java)

    override fun intercept(p0: Any?, p1: Method?, p2: Array<out Any>?, p3: MethodProxy?): Any {
        p1!!.getAnnotation(앞뒤로로그찍을래::class.java) ?: return p3!!.invokeSuper(p0, p2)

        log.info("${p3!!.superName} : 실행 이전. ${System.currentTimeMillis()}")
        val invokeSuper = p3!!.invokeSuper(p0, p2)
        log.info("${p3!!.superName} : 실행 이후, ${System.currentTimeMillis()}")
        return invokeSuper
    }
}