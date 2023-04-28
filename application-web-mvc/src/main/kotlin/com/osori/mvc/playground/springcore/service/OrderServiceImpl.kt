package com.osori.mvc.playground.springcore.service

import com.osori.mvc.playground.springcore.domain.LectureItem
import com.osori.mvc.playground.springcore.domain.LectureMember
import com.osori.mvc.playground.springcore.domain.LectureOrder
import com.osori.mvc.playground.springcore.policy.DiscountPolicy

class OrderServiceImpl(private val discountPolicy: DiscountPolicy) : OrderService {
    override fun createOrder(member: LectureMember, item: LectureItem): LectureOrder {
        val discount = discountPolicy.discount(member, item.price)
        return LectureOrder(member.id, item.id, item.price, discount)
    }
}