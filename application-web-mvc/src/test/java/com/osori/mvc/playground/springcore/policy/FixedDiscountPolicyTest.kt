package com.osori.mvc.playground.springcore.policy

import com.osori.mvc.playground.springcore.domain.Grade
import com.osori.mvc.playground.springcore.domain.LectureMember
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class FixedDiscountPolicyTest {
    private val discountPolicy : DiscountPolicy = FixedDiscountPolicy()

    @Test
    @DisplayName("VIP 는 1000원 까줌")
    fun discount() {
        val member = LectureMember(1, "오소리", Grade.VIP)
        val discount = discountPolicy.discount(member, 10000)
        assertEquals(1000, discount);
    }

    @Test
    @DisplayName("GENERAL 은 할인없음")
    fun discount_general() {
        val member = LectureMember(1, "오소리", Grade.GENERAL)
        val discount = discountPolicy.discount(member, 10000)
        assertEquals(0, discount);
    }
}