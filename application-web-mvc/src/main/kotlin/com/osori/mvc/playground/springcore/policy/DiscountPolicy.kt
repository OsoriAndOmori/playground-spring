package com.osori.mvc.playground.springcore.policy

import com.osori.mvc.playground.springcore.domain.LectureMember

interface DiscountPolicy {
    fun discount(member: LectureMember, itemOriginalPrice: Int): Int
}