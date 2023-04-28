package com.osori.mvc.playground.springcore.service

import com.osori.mvc.playground.springcore.annotation.앞뒤로로그찍을래
import com.osori.mvc.playground.springcore.domain.LectureItem
import com.osori.mvc.playground.springcore.domain.LectureMember
import com.osori.mvc.playground.springcore.domain.LectureOrder
import com.osori.mvc.playground.springcore.policy.DiscountPolicy

open class OrderServiceImpl(private val discountPolicy: DiscountPolicy) : OrderService {
    @앞뒤로로그찍을래
    override fun createOrder(member: LectureMember, item: LectureItem): LectureOrder {
        val discount = discountPolicy.discount(member, item.price)
        return LectureOrder(member.id, item.id, item.price, discount)
    }
}