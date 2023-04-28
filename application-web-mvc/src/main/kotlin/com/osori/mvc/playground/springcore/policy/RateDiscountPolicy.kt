package com.osori.mvc.playground.springcore.policy

import com.osori.mvc.playground.springcore.domain.Grade
import com.osori.mvc.playground.springcore.domain.LectureMember

open class RateDiscountPolicy(private val rate: Int) : DiscountPolicy {
    override fun discount(member: LectureMember, itemOriginalPrice: Int): Int {
        return if (member.grade == Grade.VIP) {
            (itemOriginalPrice * rate) / 100
        } else {
            0
        }
    }
}