package com.osori.mvc.playground.springcore.policy

import com.osori.mvc.playground.springcore.domain.Grade
import com.osori.mvc.playground.springcore.domain.LectureMember

open class FixedDiscountPolicy(private val amount: Int) : DiscountPolicy {
    override fun discount(member: LectureMember, itemOriginalPrice: Int): Int {
        return if (member.grade == Grade.VIP) {
            itemOriginalPrice - amount
        } else {
            itemOriginalPrice
        }
    }
}