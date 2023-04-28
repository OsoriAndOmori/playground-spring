package com.osori.mvc.playground.springcore.policy

import com.osori.mvc.playground.springcore.domain.LectureMember
import com.osori.mvc.playground.springcore.`interface`.BeanCustomDefinition

interface DiscountPolicy : BeanCustomDefinition {
    fun discount(member: LectureMember, itemOriginalPrice: Int): Int
}