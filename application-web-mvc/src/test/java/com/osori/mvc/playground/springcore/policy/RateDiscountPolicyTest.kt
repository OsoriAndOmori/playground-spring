package com.osori.mvc.playground.springcore.policy

import com.osori.mvc.playground.springcore.domain.Grade
import com.osori.mvc.playground.springcore.domain.LectureMember
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class RateDiscountPolicyTest {
    private val discountPolicy : DiscountPolicy = RateDiscountPolicy()

    @Test
    @DisplayName("VIP 는 10% 까줌")
    fun discount() {
        val member = LectureMember(1, "오소리", Grade.VIP)
        val discount = discountPolicy.discount(member, 20000)
        assertEquals(2000, discount);
    }

    @Test
    @DisplayName("VIP 는 10%할인해주는데 숫자가 딱 안 떨어지는 가격 인 경우, 소숫점 버린다.")
    fun discount2() {
        val member = LectureMember(1, "오소리", Grade.VIP)
        val discount = discountPolicy.discount(member, 2222)
        assertEquals(222, discount);
    }

    @Test
    @DisplayName("GENERAL 은 할인없음")
    fun discount_general() {
        val member = LectureMember(1, "오소리", Grade.GENERAL)
        val discount = discountPolicy.discount(member, 20000)
        assertEquals(0, discount);
    }
}