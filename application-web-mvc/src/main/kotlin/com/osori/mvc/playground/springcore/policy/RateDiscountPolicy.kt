package com.osori.mvc.playground.springcore.policy

import com.osori.mvc.playground.springcore.domain.Grade
import com.osori.mvc.playground.springcore.domain.LectureMember

class RateDiscountPolicy : DiscountPolicy {
    private val rate: Int = 10

    override fun discount(member: LectureMember, itemOriginalPrice: Int): Int {
        return if (member.grade == Grade.VIP) {
            itemOriginalPrice * ((100 - rate) / 100)
        } else {
            0
        }
    }
}