package com.osori.mvc.playground.springcore.policy

import com.osori.mvc.playground.springcore.domain.Grade
import com.osori.mvc.playground.springcore.domain.LectureMember

class FixedDiscountPolicy : DiscountPolicy {
    private val amount: Int = 1000

    override fun discount(member: LectureMember, itemOriginalPrice: Int): Int {
        return if (member.grade == Grade.VIP) {
            amount
        } else {
            0
        }
    }
}