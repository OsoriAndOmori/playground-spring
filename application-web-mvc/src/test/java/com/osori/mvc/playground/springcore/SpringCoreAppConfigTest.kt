package com.osori.mvc.playground.springcore

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SpringCoreAppConfigTest {
    private val springCoreAppConfig = SpringCoreAppConfig()

    @Test
    fun memberService() {
        val first = springCoreAppConfig.memberService()
        val second = springCoreAppConfig.memberService()
        println(first)
        println(second)

        assertEquals(first, second)
    }
}